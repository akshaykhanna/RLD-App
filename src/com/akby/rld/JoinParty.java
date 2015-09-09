package com.akby.rld;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class JoinParty extends ModActivity 
{

	   Button bCall;
	   String text="• Any Citizen of India of the age of 18 years or above.\n"
 
+"• He/she must bear true faith and allegiance to the Constitution of India.\n"
 
+"• He/she must believe in the principles & programmes of party, bear true faith and allegiance to the Rashtriya Lok Dal.\n"
 
+"• He/she must not be a member of any other political party or organization.\n"
 
+"• For membership , the person concerned should contact the District office or State office of his place of residence.\n";

		@Override
	    protected void onCreate(Bundle savedInstanceState) 
		{
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.join_party_lay);
	       intialise();
	    }
		private void intialise() {
			// TODO Auto-generated method stub
			
			TextView tv=(TextView)findViewById(R.id.tvJoinParty);
			// bCall=(Button)findViewById(R.id.bt_JoinParty);
			// bCall.setVisibility(View.VISIBLE);
			tv.setText(text);
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
