package com.akby.rld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;



import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RLD extends ModActivity 
{

	   Button bGA;
	  // String text="Rashtriya Lok Dal (abbreviated as RLD) (translation: National People's Party) is a political party in India. Chaudhary Ajit Singh is a founder and the president of the party. He is carrying on the political legacy of his father and former Prime Minister of India, Charan Singh and the original Lok Dal.";
		String text,t;
		int count_lines;
		int id;
	   @Override
	    protected void onCreate(Bundle savedInstanceState) 
		{
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.join_party_lay);
	        getValueFromBundle();
			InputStream obj;
			switch(id)
			{
			case 1:obj=this.getResources().openRawResource(R.raw.inspiration);
				break;
			case 2:obj=this.getResources().openRawResource(R.raw.election);
			break;
			case 3: obj=this.getResources().openRawResource(R.raw.mla);
			break;
			default: obj=this.getResources().openRawResource(R.raw.helptext);
			}
	        
			BufferedReader br=new BufferedReader(new InputStreamReader(obj));
			text="";
			t="";
			
			try {
				while((text=br.readLine())!=null)
				{
					t+=text+"\n";
					count_lines++;
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				Toast.makeText(getBaseContext(), "Error 201: Unable to read from helptxt.txt", Toast.LENGTH_LONG);
			}
	       intialise();
	    }
     void getValueFromBundle()
     {
    	 Bundle b=getIntent().getExtras();
		 id=b.getInt("menu");
     }
		private void intialise() {
			// TODO Auto-generated method stub
			TextView tvT=(TextView)findViewById(R.id.tvJoinUsTitle);
			TextView tv=(TextView)findViewById(R.id.tvJoinParty);
			switch(id)
			{
			case 1:tvT.setText("Our Inspiration");
			break;
			case 2:tvT.setText("Election History");
			break;
			case 3:tvT.setText("Our Inspiration");
			break;
			default:tvT.setText("Rashtriya Lok Dal");
			}
			
			tv.setText(t);
		}

}
