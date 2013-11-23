package com.example.mcal;

import android.provider.BaseColumns;

public class SqlTableStructure implements BaseColumns{

	public SqlTableStructure()
	{
	}
		public static final String DATABASE_NAME = "MCalTable";
		public static final int DATABASE_VERSION = 1;
        public static final String TABLE_NAME = "events";
        public static final String ROW_ID = "ID";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_NOTES = "notes";
        public static final String COLUMN_NAME_TIME = "time";
        public static final String COLUMN_NAME_DATE = "date";
 
}
