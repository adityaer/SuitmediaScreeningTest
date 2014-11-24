package com.suitmedia.screeningtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.suitmedia.screeningtest.adapter.ListAdapter;


public class EventActivity extends Activity {
	
	ListView list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_event);
		
		list = (ListView) findViewById(R.id.listView1);
		
		String[] event_array = {"Pasar Seni ITB 2014", "Holis Culinary Night", "Braga Culinary Night",
				"Bandung Automotive Expo 2014", "Pesta Rakyat Mandalajati"};
		
		String[] tgl_array = {"23 November 2014", "23 November 2014", "22 November 2014",
				"21-23 November 2014", "22-23 November 2014"};
		
		ListAdapter list_adapter = new ListAdapter(this, event_array, tgl_array);
		
		list.setAdapter(list_adapter);
		
		list.setOnItemClickListener(new OnItemClickListener() {

	        @Override
	        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
	                long arg3) {
	            // TODO Auto-generated method stub
	 
	        	Intent returnIntent = new Intent(EventActivity.this, ChooseActivity.class);
				returnIntent.putExtra("data_event",arg0.getItemAtPosition(arg2).toString());
				setResult(RESULT_OK,returnIntent);
				finish();
	        }

	    });
		
	}

}
