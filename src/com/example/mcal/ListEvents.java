package com.example.mcal;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

@SuppressLint("UseSparseArrays")
public class ListEvents extends ListActivity {

	
	HashMap<Integer, String> events = new HashMap<Integer, String>();
	String[] eventNames;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		try{
			StoreEvents storeEvents = new StoreEvents(this);
			storeEvents.openRead();
			events=storeEvents.getEventsList();
			storeEvents.close();
		}catch (Exception e){
			Dialog d = new Dialog(this);
			d.setTitle("Cannot Retieve Events");
			TextView tv = new TextView(this);
			tv.setText(e.toString());
			d.setContentView(tv);
			d.show();
		}
		eventNames[0]="";
		Iterator<Entry<Integer, String>> iterator = events.entrySet().iterator();
		int indx =0; 
		while(iterator.hasNext()){
			eventNames[indx] = iterator.next().getValue();
			indx++;	
		}
		setListAdapter(new ArrayAdapter<String>(ListEvents.this, android.R.layout.simple_list_item_1, eventNames));
	}

	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		try {
			@SuppressWarnings("rawtypes")
			Class createClass = Class.forName("com.example.mcal.SeeEvents");
			Intent intent = new Intent(ListEvents.this, createClass);
			intent.putExtra(events.get(position), position);
			startActivity(intent);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_events, menu);
		return true;
	}

}
