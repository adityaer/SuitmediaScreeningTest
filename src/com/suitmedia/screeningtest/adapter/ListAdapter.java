package com.suitmedia.screeningtest.adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.suitmedia.screeningtest.R;

public class ListAdapter extends BaseAdapter{
	
	private int count;
    private Context context;
    String[] event = null;
    String[] tgl = null;
	
	public ListAdapter(Context context,String[] event, String[] tgl)
    {
        this.context = context;
        this.event = event;
        this.tgl = tgl;
        this.count = event.length;
        
    }
    
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return count;
    }
 
    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
    	
        return event[arg0];
    }
 
    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    
    @Override
    public View getView(int position, View contentView, ViewGroup arg2) {
    	
    	View view = contentView;
    	TextView event_t, tgl_t;
    	ImageView event_image;
    	
    	
    	LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		view = inflater.inflate(R.layout.list_item, null);
		
		event_image = (ImageView)view.findViewById(R.id.event_pic);
		event_t = (TextView)view.findViewById(R.id.textEvent);
		tgl_t = (TextView)view.findViewById(R.id.textTgl);
		
		event_t.setText(event[position]);
		tgl_t.setText(tgl[position]);
		
		return view;
        
    }
    
    
    
}
