package com.akby.rld;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class JoinPartyFirst extends ModActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.join_party_lay_first);
		
	}
	
	
	public void onlineMembership(View v)
	{
		//Toast.makeText(this, "Method works", Toast.LENGTH_LONG).show();
		
		
		Intent 	ii=new Intent(JoinPartyFirst.this,WebView2015.class);
		Bundle suitcase=new Bundle();
		suitcase.putString("url","http://rld.rashtriyalokdal.com");
		suitcase.putInt("int", 0);
		ii.putExtras(suitcase);
		
		startActivity(ii);
	}
	public void joinParty(View v)
	{
		Intent 	i=new Intent(JoinPartyFirst.this,JoinParty.class);
		startActivity(i);
	}
	
	public void giveMissedCall(View v)
    {
    	//Toast.makeText(this, "Missed Call method", Toast.LENGTH_LONG).show();
    	
    	
    	 try {
    		 
    		                    // String uri = "tel:"+"180030100333";
    		 
    		                     
    		 Intent callIntent = new Intent(Intent.ACTION_CALL);
    			callIntent.setData(Uri.parse("tel:180030100333"));
    			startActivity(callIntent);
    		 
    		                   
    		 
    		                 }catch(Exception e) {
    		 
    		                     Toast.makeText(getApplicationContext(),"Your call has failed...",
    		 
    		                         Toast.LENGTH_LONG).show();
    		 
    		                     e.printStackTrace();
    		 
    		                 }
       
    }
  
}
