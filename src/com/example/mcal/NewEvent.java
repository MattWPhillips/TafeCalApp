package com.example.mcal;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NewEvent extends Activity implements OnClickListener{

	Button save;
	EditText title, note, date, time;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_event);
		save = (Button) findViewById(R.id.bSave);
		title = (EditText) findViewById(R.id.etGetTitle);
		note = (EditText) findViewById(R.id.etGetNote);
		date = (EditText) findViewById(R.id.etGetDate);
		time = (EditText) findViewById(R.id.etGetTime);
		
		save.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_event, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		
		boolean newRecord=true;
		try{
		String sqlTitle = title.getText().toString();
		String sqlNote = note.getText().toString();
		String sqlDate = date.getText().toString();
		String sqlTime = time.getText().toString();
		
		StoreEvents entry = new StoreEvents(NewEvent.this);
		entry.openWrite();
		entry.addRecord(sqlTitle, sqlNote, sqlDate, sqlTime);
		//entry.addRecord("Get it done", "Hello my dear friend","23-11-2013", "3:50");
		entry.close();
		}catch (Exception e){
			newRecord = false;
			Dialog d = new Dialog(this);
			d.setTitle("New Record Failed to Add");
			TextView tv = new TextView(this);
			tv.setText(e.toString());
			d.setContentView(tv);
			d.show();
		}finally{
			if(newRecord)
			{
				Dialog d = new Dialog(this);
				d.setTitle("New Record Added");
				TextView tv = new TextView(this);
				tv.setText("Success");
				d.setContentView(tv);
				d.show();
			}
		}
	}
}
