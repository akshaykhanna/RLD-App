package com.akby.rld;



import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class About extends  ModActivity implements OnClickListener 
{
   
	ImageView ib[]=new ImageView[5];
	TextView tvD;
	String url;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
         intial();
	}
	private void intial() {
		// TODO Auto-generated method stub
	//tvD=(TextView)findViewById(R.id.tvDevloper);
	     //tvD.setText("Devlopers");
		ib[0]=(ImageView)findViewById(R.id.ibAkshay786);
		ib[1]=(ImageView)findViewById(R.id.ibKapil786);
		ib[2]=(ImageView)findViewById(R.id.ibLike786);
		ib[3]=(ImageView)findViewById(R.id.ibRate786);
		ib[4]=(ImageView)findViewById(R.id.ibMsg786);
		//ib[5]=(ImageView)findViewById(R.id.ibPankaj786);
		for(int i=0;i<5;i++)
			ib[i].setOnClickListener(this);
	}
	@Override
	public void onClick(View id)
	{
		Intent i;
		// TODO Auto-generated method stub
		switch(id.getId())
		{
		
		case R.id.ibAkshay786:
			url = "https://www.facebook.com/AkiDiMasti";
			i= new Intent(Intent.ACTION_VIEW);
			i.setData(Uri.parse(url));
			startActivity(i);
			break;
		case R.id.ibKapil786:
			url = "https://www.facebook.com/Kachiever";
			i= new Intent(Intent.ACTION_VIEW);
			i.setData(Uri.parse(url));
			startActivity(i);
			break;
		/*case R.id.ibPankaj786:
			url = "https://www.facebook.com/kingpankajtomar";
			i= new Intent(Intent.ACTION_VIEW);
			i.setData(Uri.parse(url));
			startActivity(i);
			break;*/
		case R.id.ibLike786:
			url = "http://brainyoghurts.in/";
			i= new Intent(Intent.ACTION_VIEW);
			i.setData(Uri.parse(url));
			startActivity(i);
			break;
			
		case R.id.ibRate786:
			rateMyApp();
			break;
		case R.id.ibMsg786:
			try{
				email();
			}
			catch(Exception e)
			{
				Toast.makeText(this, "Error 301: Problem with email()", Toast.LENGTH_SHORT).show();
			}
			break;
		}
		
	}
	
	private void email() {
		// TODO Auto-generated method stub
		String emailaddress[] = { "akshay9911102163@gmail.com"};
		String message ="Enter your feedback or anything ......:p";
      Intent sm= new Intent(android.content.Intent.ACTION_SEND);
      sm.putExtra(android.content.Intent.EXTRA_EMAIL, emailaddress);
      sm.putExtra(android.content.Intent.EXTRA_SUBJECT,"Feeback of App: " + "App Name");
      sm.setType("plain/text");
      sm.putExtra(android.content.Intent.EXTRA_TEXT,message);
      startActivity(sm);
	}
	private boolean MyStartActivity(Intent aIntent) {
	    try
	    {
	        startActivity(aIntent);
	        return true;
	    }
	    catch (ActivityNotFoundException e)
	    {
	        return false;
	    }
	}
	 
	//On click event for rate this app button
	public void rateMyApp() {
	    Intent intent = new Intent(Intent.ACTION_VIEW);
	    //Try Google play
	    intent.setData(Uri.parse("market://details?id=package_name_or_id"));
	    if (!MyStartActivity(intent)) {
	        //Market (Google play) app seems not installed, let's try to open a webbrowser
	        intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=package_name_or_id"));
	        if (!MyStartActivity(intent)) {
	            //Well if this also fails, we have run out of options, inform the user.
	            Toast.makeText(this, "Could not open Android market, please install the market app.", Toast.LENGTH_SHORT).show();
	        }
	    }
	    
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
	}
	
	
	
	
}

