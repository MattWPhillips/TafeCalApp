package com.example.mcal;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class EditEvent extends Activity implements OnClickListener{

	Button sqlSave, sqlDelete;
	EditText sqlTitle, sqlNotes, sqlDate, sqlTime;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_event);
		sqlSave = (Button) findViewById(R.id.bEditSave);
		sqlSave.setOnClickListener(this);
		sqlDelete = (Button) findViewById(R.id.bEditDelete);
		sqlDelete.setOnClickListener(this);
		
		sqlTitle = (EditText) findViewById(R.id.etEditGetTitle);
		sqlNotes = (EditText) findViewById(R.id.etEditGetNote);
		sqlDate = (EditText) findViewById(R.id.etEditGetDate);
		sqlTime = (EditText) findViewById(R.id.etEditGetTime);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_event, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId())
		{
		case R.id.bEditSave:
			
			break;
		case R.id.bEditDelete:
			
			break;
			default:
				
			break;
		}
	}

}
