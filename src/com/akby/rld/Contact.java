package com.akby.rld;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Contact extends ModActivity implements OnItemSelectedListener 
{
	
	String text="",t="";
	TextView tv;
	Spinner sp1;
	String office[]={"Delhi Office","Lucknow Office"};
	   @Override
	    protected void onCreate(Bundle savedInstanceState) 
		{
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.contact_lay);
	        sp1=(Spinner)findViewById(R.id.spinner_Contact);
	        ArrayAdapter<String> adapter=new ArrayAdapter<String>(Contact.this,android.R.layout.simple_spinner_item,office);
			sp1.setAdapter(adapter);
			sp1.setOnItemSelectedListener(this);
	        intialise();
	        read_delhi();
		}
	   
	   private void intialise() {
			// TODO Auto-generated method stub
			
			tv=(TextView)findViewById(R.id.tvContact);
			
		}
	    void read_delhi()
	    {
	    	 InputStream obj=this.getResources().openRawResource(R.raw.delhi_off);
				BufferedReader br=new BufferedReader(new InputStreamReader(obj));
				text="";
				t="";
				
				try {
					while((text=br.readLine())!=null)
					{
						t+=text+"\n";
											
					}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					Toast.makeText(getBaseContext(), "Error 201: Unable to read from helptxt.txt", Toast.LENGTH_LONG);
				}	
				tv.setText(t);
	    }
	    void read_lko()
	    {
	    	 InputStream obj=this.getResources().openRawResource(R.raw.lko_off);
				BufferedReader br=new BufferedReader(new InputStreamReader(obj));
				text="";
				t="";
				
				try {
					while((text=br.readLine())!=null)
					{
						t+=text+"\n";
						
					}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					Toast.makeText(getBaseContext(), "Error 201: Unable to read from helptxt.txt", Toast.LENGTH_LONG);
				}
				tv.setText(t);
	    }
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		int p=sp1.getSelectedItemPosition();
		if(p==0)
			read_delhi();
			else
				read_lko();
		//Toast.makeText(this, "Spinne no. :"+p, Toast.LENGTH_LONG).show();
	}
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void openFbInBrowser(View v)
	{
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/RashtriyaLokDal"));
		startActivity(browserIntent);
	}
	public void openTweeterInBrowser(View v)
	{
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/Rldparty"));
		startActivity(browserIntent);
	}
	public void openInstagramInBrowser(View v)
	{
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/rashtriya_lokdal?ref=badge"));
		startActivity(browserIntent);
	}

}
