package com.example.mcal;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;



public final class StoreEvents {

	public StoreEvents(Context c){
		context = c;
	}
	
	
	private static final String TEXT_TYPE = " TEXT";
	private static final String COMMA_SEP = ",";
	private static final String SQL_CREATE_TABLE =
	    "CREATE TABLE " + SqlTableStructure.TABLE_NAME + " (" +
	    SqlTableStructure.ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
	    SqlTableStructure.COLUMN_NAME_TITLE + TEXT_TYPE + COMMA_SEP +
	    SqlTableStructure.COLUMN_NAME_NOTES + TEXT_TYPE + COMMA_SEP +
	    SqlTableStructure.COLUMN_NAME_DATE + TEXT_TYPE + COMMA_SEP +
	    SqlTableStructure.COLUMN_NAME_TIME + TEXT_TYPE + COMMA_SEP +
	    " )";

	private static final String SQL_DELETE_ENTRIES =
	    "DROP TABLE IF EXISTS " + SqlTableStructure.TABLE_NAME;
	
	private DbHelper dbHelper;
	private final Context context;
	private SQLiteDatabase sqliteDatabase;
	
	
	private static class DbHelper extends SQLiteOpenHelper{

		public DbHelper(Context context) {
			super(context, SqlTableStructure.DATABASE_NAME, null, SqlTableStructure.DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(SQL_CREATE_TABLE);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL(SQL_DELETE_ENTRIES);
			onCreate(db);
		}
		
	}
	
	public StoreEvents open()throws SQLException{
		dbHelper = new DbHelper(context);
		sqliteDatabase = dbHelper.getWritableDatabase();
		return this;
	}
	
	public void close(){
		dbHelper.close();		
	}

	public long addRecord(String title, String note, String date,String time) {
		ContentValues cv = new ContentValues();
		cv.put(SqlTableStructure.COLUMN_NAME_TITLE, title);
		cv.put(SqlTableStructure.COLUMN_NAME_NOTES, note);
		cv.put(SqlTableStructure.COLUMN_NAME_DATE, date);
		cv.put(SqlTableStructure.COLUMN_NAME_TIME, time);
		return sqliteDatabase.insert(SqlTableStructure.TABLE_NAME, null, cv);		
	}
}
