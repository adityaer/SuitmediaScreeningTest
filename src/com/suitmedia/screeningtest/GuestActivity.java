package com.suitmedia.screeningtest;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.suitmedia.screeningtest.adapter.GridAdapter;
import com.suitmedia.screeningtest.util.ConstantUtil;
import com.suitmedia.screeningtest.util.JSONParser;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import android.widget.AdapterView.OnItemClickListener;


public class GuestActivity extends Activity {
	
	GridView grid;
	ListView list;
	JSONParser jsonParser = new JSONParser();
	Editor editor;
	List<NameValuePair> params = new ArrayList<NameValuePair>();
	ProgressDialog pDialog;
	JSONArray data_json;
	ArrayList<HashMap<String, String>> list_data;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guest);
		
		grid = (GridView)findViewById(R.id.gridView1);
		
		new AttemptDataJSON().execute();
		
		
	}
	
	class AttemptDataJSON extends AsyncTask<String, String, String> {
		  boolean failure = false;

	      @Override
	      protected void onPreExecute() {
	          super.onPreExecute();
	          pDialog = new ProgressDialog(GuestActivity.this);
	          pDialog.setMessage("Attempting data...");
	          pDialog.setIndeterminate(false);
	          pDialog.setCancelable(true);
	          pDialog.show();
	      }

			@Override
			protected String doInBackground(String... args) {
	          
			  JSONArray jsonn = jsonParser.makeHttpRequest(ConstantUtil.WEB_SERVICE.URL_DATA,"GET", params);
			  Log.v("Return JSON", jsonn.toString());
			    
	          return jsonn.toString();
	          
			}
			/**
	       * After completing background task Dismiss the progress dialog
	       * **/
	      protected void onPostExecute(String json_res) {
	          // dismiss the dialog once product deleted
	          pDialog.dismiss();
	          
	         
			try {
				 JSONArray json = new JSONArray(json_res);
			
	          if (json!=null) {
			      
					data_json = json;
					int count = data_json.length();
							
					list_data = new ArrayList<HashMap<String, String>>();
							
					for (int i = 0; i < count; i++) {
					     JSONObject c = data_json.getJSONObject(i);
					     HashMap<String, String> data_single = new HashMap<String, String>();
					                
					     String id = c.getString("id");
					     String name = c.getString("name");
					     String birth = c.getString("birthdate");
					                
					                
					     data_single.put("id", id);
					     data_single.put("name", name);
					     data_single.put("birth", birth);
					                
					     list_data.add(data_single);
					}
							 
							
							 
					GridAdapter grid_adapter = new GridAdapter(GuestActivity.this, list_data);
				    grid.setAdapter(grid_adapter);

					grid.setOnItemClickListener(new OnItemClickListener() {

						@Override
						public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
							   long arg3) {
						// TODO Auto-generated method stub
							        
							    Intent returnIntent = new Intent(GuestActivity.this, ChooseActivity.class);
							    String[] guest = (String[]) arg0.getItemAtPosition(arg2);
							    returnIntent.putExtra("data_guest", guest[0]);
								returnIntent.putExtra("tgl_guest", guest[1]);
								setResult(RESULT_OK,returnIntent);
								finish();
						}

					});
	                       	
			    }  
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	      }

		}	

}
