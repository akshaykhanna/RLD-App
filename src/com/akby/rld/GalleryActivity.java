package com.akby.rld;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;

import android.support.v4.view.ViewPager;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class GalleryActivity extends Activity implements OnClickListener
{

	Button bGA;
	ImageView iv[];
	@Override
    protected void onCreate(Bundle savedInstanceState) 
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_lay);
        intialise();
        handle_actionBar();
    }
	  private void handle_actionBar()
	    {
			// TODO Auto-generated method stub
	    	 ColorDrawable colorDrawable = new ColorDrawable();
			ActionBar acb = getActionBar();
			colorDrawable.setColor(0xff006B00);
	        acb.setBackgroundDrawable(colorDrawable);
			//acb.setBackgroundDrawable(d);
		}
	  @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }

		@Override
		  public boolean onOptionsItemSelected(MenuItem item) {
		    switch (item.getItemId()) {
		    // action with ID action_refresh was selected
		    case R.id.action_About:
		      //Toast.makeText(this, "About selected", Toast.LENGTH_SHORT)
		          //.show();
		    	Intent ia=new Intent(GalleryActivity.this,RLD_About.class);
				startActivity(ia);
		    	
		      break;
		    // action with ID action_settings was selected
		    case R.id.action_Contact:
		    	Intent ic=new Intent(GalleryActivity.this,Contact.class);
				startActivity(ic);

		      break;
		    case R.id.action_Devloper:
			    //  Toast.makeText(this, "Developer selected", Toast.LENGTH_SHORT)
			      //    .show();
			      Intent id=new Intent(GalleryActivity.this,About.class);
					startActivity(id);
			      break;
		    case R.id.action_Rate:
			   //   Toast.makeText(this, "Rate selected", Toast.LENGTH_SHORT)
			     //     .show();
			      break;
		    default:
		      break;
		    }

		    return true;
		  } 
    void intialise()
    {
    	iv=new ImageView[7];
    	int k=1;
    	Display display = getWindowManager().getDefaultDisplay();
    	Point size = new Point();
    	display.getSize(size);
    	int width = size.x;
    	int height = size.y;
    	iv[0]=(ImageView)findViewById(R.id.imageButton1);
    	iv[1]=(ImageView)findViewById(R.id.imageButton2);
    	iv[2]=(ImageView)findViewById(R.id.imageButton3);
    	iv[3]=(ImageView)findViewById(R.id.imageButton4);
    	iv[4]=(ImageView)findViewById(R.id.imageButton5);
    	iv[5]=(ImageView)findViewById(R.id.imageButton6);
    	iv[6]=(ImageView)findViewById(R.id.imageButton7);
    	    
    	for(int i=0;i<7;i++)
    	{
    		iv[i].setMinimumWidth(width-50);
    		iv[i].setMaxWidth(width-50);
    		iv[i].setLeft(width/6);
    		iv[i].setOnClickListener(this);
    	} 
    }
	@Override
	public void onClick(View id) {
		// TODO Auto-generated method stub
		Intent i;
		switch(id.getId())
		{
		case R.id.imageButton1:;
		 i=new Intent(GalleryActivity.this,RLD_About.class);
		startActivity(i);
			break;
		case R.id.imageButton2: //Leaders activity
			 i=new Intent(GalleryActivity.this,ListMenu.class);
			startActivity(i);
		break;
		case R.id.imageButton3:// Website activity
			//i=new Intent(GalleryActivity.this,WebSite.class);
			//startActivity(i);
			Intent 	ii=new Intent(GalleryActivity.this,WebView2015.class);
			Bundle suitcase=new Bundle();
			suitcase.putString("url","http://www.rashtriyalokdal.com");
			suitcase.putInt("int", 0);
			ii.putExtras(suitcase);
			startActivity(ii);
		break;
		case R.id.imageButton4://join party;
			i=new Intent(GalleryActivity.this,JoinPartyFirst.class);
			startActivity(i);
		break;
		case R.id.imageButton5://News;
			i=new Intent(GalleryActivity.this,WebViewYouTube.class);
			startActivity(i);
			//Toast.makeText(this, "Page under construction!", Toast.LENGTH_LONG).show();;
			break;
		case R.id.imageButton6://Contact;
			i=new Intent(GalleryActivity.this,Contact.class);
			startActivity(i);
		break;
		case R.id.imageButton7: //Developers
			i=new Intent(GalleryActivity.this,About.class);
			startActivity(i);
			//Toast.makeText(this, "Image 7", Toast.LENGTH_LONG).show();;
		break;
		}
	}

}
