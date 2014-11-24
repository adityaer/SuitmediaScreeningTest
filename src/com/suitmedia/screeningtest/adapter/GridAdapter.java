package com.suitmedia.screeningtest.adapter;

import java.util.ArrayList;
import java.util.HashMap;

import com.suitmedia.screeningtest.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class GridAdapter extends BaseAdapter {
	private Context context;
	private ArrayList<HashMap<String,String>> data;

	public GridAdapter(Context context, ArrayList<HashMap<String,String>> data) {
		this.context = context;
		this.data = data;
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View gridView;

		if (convertView == null) {

			gridView = new View(context);
			gridView = inflater.inflate(R.layout.grid_item, null);
			TextView label = (TextView) gridView.findViewById(R.id.grid_item_label);
			
			label.setText(data.get(position).get("name") + " / " + data.get(position).get("birth"));
			
		} else {
			gridView = (View) convertView;
		}

		return gridView;
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		String[] guest = {data.get(position).get("name"),data.get(position).get("birth")};
		return guest;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

}
