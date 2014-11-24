package com.suitmedia.screeningtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	EditText name;
	Button next;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		name = (EditText) findViewById(R.id.editName);
		next = (Button) findViewById(R.id.button1);
		
		next.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if (name.getText().toString().equals(null) || name.getText().toString().equals("")) {
					Toast.makeText(MainActivity.this, "Tolong isi kolom dengan nama anda...!",
							Toast.LENGTH_SHORT).show();
				} else {

					Intent i = new Intent(MainActivity.this, ChooseActivity.class);
					i.putExtra("name", name.getText().toString());
					startActivity(i);
				}
						
			}
		});
		
		
		

		
	}

	
}
