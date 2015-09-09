package com.akby.rld;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RLD_About extends ModActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rld_about);
  /*
        GridView gridView = (GridView)findViewById(R.id.gridview);
        gridView.setAdapter(new MyAdapter(this)); 
        gridView.setOnItemClickListener(new OnItemClickListener() 
        {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) 
            {
                // this 'mActivity' parameter is Activity object, you can send the current activity.
                //Intent i = new Intent(this, ActvityToCall.class);
                //startActivity(i);
            	Intent i=new Intent(RLD_About.this,RLD.class);
        		Bundle suitcase=new Bundle();
        		suitcase.putInt("menu",position);
        		
        		i.putExtras(suitcase);
        		startActivity(i);
            	  //Toast.makeText(RLD_About.this, "Item selected: "+position, Toast.LENGTH_SHORT)
    	          //.show();
            }
        });*/
    }
    void chooseMenu(int position)
    {
    	Intent i=new Intent(RLD_About.this,RLD.class);
		Bundle suitcase=new Bundle();
		suitcase.putInt("menu",position);
		
		i.putExtras(suitcase);
		startActivity(i);
    }
       public void methodRLD_About(View v)
	{
    	   chooseMenu(0);
	}
    public void methodInspiration(View v)
	{
    	chooseMenu(1);
	}
    public void methodElection(View v)
   	{
    	chooseMenu(2);
   	}

    public void methodMLA(View v)
	{
    	chooseMenu(3);
	}
   
  /*
    private class MyAdapter extends BaseAdapter
    {
        private List<Item> items = new ArrayList<Item>();
        private LayoutInflater inflater;

        public MyAdapter(Context context)
        {
            inflater = LayoutInflater.from(context);

            items.add(new Item("Image 1", R.drawable.rld_about));
            items.add(new Item("Image 2", R.drawable.inspiration));
            items.add(new Item("Image 3", R.drawable.election));
            items.add(new Item("Image 4", R.drawable.mla));
           
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int i)
        {
            return items.get(i);
        }

        @Override
        public long getItemId(int i)
        {
            return items.get(i).drawableId;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup)
        {
            View v = view;
            ImageView picture;
            TextView name;

            if(v == null)
            {
               v = inflater.inflate(R.layout.gridview_item, viewGroup, false);
               v.setTag(R.id.picture, v.findViewById(R.id.picture));
               v.setTag(R.id.text, v.findViewById(R.id.text));
            }

            picture = (ImageView)v.getTag(R.id.picture);
            name = (TextView)v.getTag(R.id.text);

            Item item = (Item)getItem(i);

            picture.setImageResource(item.drawableId);
            name.setText(item.name);

            return v;
        }

        private class Item
        {
            final String name;
            final int drawableId;

            Item(String name, int drawableId)
            {
                this.name = name;
                this.drawableId = drawableId;
            }
        }
    } */
}
