package com.example.mcal;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.view.Menu;
import android.widget.TextView;

public class SeeEvents extends Activity {

	TextView title, note, date, time;
	List<String> events = new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_see_events);
		title = (TextView) findViewById(R.id.tvGetTitle);
		note = (TextView) findViewById(R.id.tvGetNote);
		date = (TextView) findViewById(R.id.tvGetDate);
		time = (TextView) findViewById(R.id.tvGetTime);
		boolean viewRecord = true;
		try{

			StoreEvents storeEvents = new StoreEvents(this);
			storeEvents.openRead();
			events=storeEvents.getEvent();
			storeEvents.close();
			title.setText(events.get(0));
			note.setText(events.get(1));
			date.setText(events.get(2));
			time.setText(events.get(3));
		}catch (Exception e){
			viewRecord = false;
			Dialog d = new Dialog(this);
			d.setTitle("Cannot Retieve Events");
			TextView tv = new TextView(this);
			tv.setText(e.toString());
			d.setContentView(tv);
			d.show();
		}finally{
			if(viewRecord)
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.see_events, menu);
		return true;
	}

}
