package com.example.mcal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SeeEvents extends Activity implements OnClickListener{

	TextView title, note, date, time;
	Button edit;
	HashMap<Integer, Event> events = new HashMap<Integer, Event>();

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_see_events);
		title = (TextView) findViewById(R.id.tvGetTitle);
		note = (TextView) findViewById(R.id.tvGetNote);
		date = (TextView) findViewById(R.id.tvGetDate);
		time = (TextView) findViewById(R.id.tvGetTime);
		edit = (Button) findViewById(R.id.bSeeEdit);
		
		try{

			StoreEvents storeEvents = new StoreEvents(this);
			storeEvents.openRead();
			events=storeEvents.getEvent();
			storeEvents.close();
			title.setText(events.get(0).getTitle());
			note.setText(events.get(0).getNote());
			date.setText(events.get(0).getDate());
			time.setText(events.get(0).getTime());
		}catch (Exception e){
			Dialog d = new Dialog(this);
			d.setTitle("Cannot Retieve Events");
			TextView tv = new TextView(this);
			tv.setText(e.toString());
			d.setContentView(tv);
			d.show();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.see_events, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch (v.getId())
		{
		case R.id.bSeeEdit:
			
			break;
			default:
				
			break;
		
		}
	}

}
