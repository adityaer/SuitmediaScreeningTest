package com.suitmedia.screeningtest;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ChooseActivity extends Activity {
	
	Button event, guest;
	TextView nameText;
	private static final int GET_EVENT= 1;
	private static final int GET_GUEST= 2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose);
		
		Intent i = getIntent();
		String name = i.getExtras().getString("name");
		
		nameText = (TextView) findViewById(R.id.textName);
		event = (Button) findViewById(R.id.buttonEvent);
		guest = (Button) findViewById(R.id.buttonGuest);
		
		nameText.setText(name);
		
		event.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(ChooseActivity.this, EventActivity.class);
				//startActivity(i);
				startActivityForResult(i, GET_EVENT);
				
			}
		});
		
		guest.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(ChooseActivity.this, GuestActivity.class);
				//startActivity(i);
				startActivityForResult(i, GET_GUEST);
				
			}
		});
	}
	
	
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
			
			if (resultCode == Activity.RESULT_OK) {
				switch (requestCode) {
				case GET_EVENT:
					event.setText(data.getExtras().getString("data_event"));
					break;
					
				case GET_GUEST:
					guest.setText(data.getExtras().getString("data_guest"));
					getDay(data.getExtras().getString("tgl_guest"));
					break;
				}
			}
	
	}
	
	public void getDay(String string_date){
		
		int day=0;
		
		day = Integer.parseInt(string_date.substring(8, string_date.length()));
		
		/*SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	 
		try {
	 
			Date date = formatter.parse(string_date);
			day = date.getDay();
		} catch (ParseException e) {
			e.printStackTrace();
		}*/
		
		if (day % 2== 0 && day % 3== 0){
			Toast.makeText(getApplicationContext(), "iOS", Toast.LENGTH_SHORT).show();
		}else if(day%2==0){
			Toast.makeText(getApplicationContext(), "Blackberry", Toast.LENGTH_SHORT).show();
		}else if(day%3==0){
			Toast.makeText(getApplicationContext(), "Android", Toast.LENGTH_SHORT).show();
		}else{
			Toast.makeText(getApplicationContext(), "Feature Phone", Toast.LENGTH_SHORT).show();
		}
	}
	

}
	
	

