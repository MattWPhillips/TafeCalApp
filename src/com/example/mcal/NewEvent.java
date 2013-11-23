package com.example.mcal;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class NewEvent extends Activity implements OnClickListener{

	Button save;
	EditText title, note;
	DatePicker date;
	TimePicker time;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_event);
		save = (Button) findViewById(R.id.bSave);
		title = (EditText) findViewById(R.id.tvtitle);
		note = (EditText) findViewById(R.id.tvNote);
		date = (DatePicker) findViewById(R.id.datePick);
		time = (TimePicker) findViewById(R.id.timePick);
		
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
		String sqlDate = date.toString();
		String sqlTime = time.toString();
		
		StoreEvents entry = new StoreEvents(NewEvent.this);
		entry.open();
		entry.addRecord(sqlTitle, sqlNote, sqlDate, sqlTime);
		entry.close();
		}catch (Exception e){
			newRecord = false;
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
