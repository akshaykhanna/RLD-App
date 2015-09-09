package com.akby.rld;



import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class ListMenu extends ListActivity {

	
	String[] title = {
		      "Chaudhary Charan Singh",
		      "Chaudhary Ajit Singh",
		      "Jayant Chaudhary",
		      "Munna Singh Chauhan",
		      
		  } ;
	String[] subTitle = {
		    "Chaudhary Charan Singh, son of Smt. Netra Kaur and Chaudhary Meer Singh, was born on 23 December 1902 in Noorpur village in Meerut District of Uttar Pradesh. Chaudhary Charan Singh had his primary education in his native village school at Jani Khurd, and passed his matriculation from the Government High School, Meerut. He graduated in Science from Agra College in 1923, did his M.A. in History from Agra University, passed the L.L.B. examination in 1927 and got himself enrolled as an advocate in Ghaziabad.",
		    "Chaudhary Ajit Singh, the National President of Rashtriya Lok Dal is currently serving his 6th term as Lok Sabha Member of Parliament in the 15th Lok Sabha. Born on 12 February, 1939, he is an alumnus of Lucknow University, I.I.T, Kharagpur and the Illinois Institute of Technology (U.S.A). He worked for 17 years in the computer software engineer in the emerging IT industry in U.S.A. Ch. Ajit Singh first entered parliament as a Member of the Rajya Sabha in 1986.",
		    "Jayant Chaudhary served as a Member of Parliament in the 15th Lok Sabha. He contested the 2009 General Election from Mathura, Uttar Pradesh. He is currently the National General Secretary of the Rashtriya Lokdal."

+"Born on 27th December 1978, Jayant did his undergraduate studies from Shri Venkateswara College, Delhi University, and in 2002 completed an MSc in Accounting and Finance from the London School of Economics and Political Science.",
		    "Shri Munna Singh Chauhan is a prominent leader of Rashtriya Lok Dal, an Ex-MLA and former Cabinet Minister in Government of Uttar Pradesh. He started his political career as a grass-root political worker under the leadership of Late Chaudhary Charan Singh when he was appointed as District President, Faizabad of Lok Dal (Youth Wing). He has held several organizational positions & responsibilities at Central and State level in Lok Dal. In 2000, Shri Chauhan became the National President of Rashtriya Lok Dal (Youth Wing)."

+"He served as Member of Legislature Council (MLC) and as Leader of House.",
		    
		   
		  } ;
		  Integer[] imageId = {
		      R.drawable.charan,
		      R.drawable.ajit,
		      R.drawable.berbatov,
		      R.drawable.munna,
		     
		  };
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		CustomListAdapter apadterObj=new CustomListAdapter(ListMenu.this,title,imageId,subTitle);
		setListAdapter(apadterObj);
		handle_actionBar("Leaders");
	}
	

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		/*Intent i=new Intent(ListMenu.this,ThirdActivity.class);
		Bundle suitcase=new Bundle();
		suitcase.putString("title",title[position]);
		suitcase.putString("sub",subTitle[position]);
		suitcase.putInt("imgid", imageId[position]);
		i.putExtras(suitcase);
		startActivity(i); */
		//Toast.makeText(this, "Position: "+position,Toast.LENGTH_SHORT).show();
		dialogToAskProceedWebsiteOrNOt(position);
	}
	void dialogToAskProceedWebsiteOrNOt(final int p)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(this);

	    builder.setTitle("Read more");
	    builder.setMessage("Want to know more about " + title[p]+ " via RLD website?");

	    builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

	        public void onClick(DialogInterface dialog, int which) {
	            // Do nothing but close the dialog
	        	openFullLeadersDetailsFromWebsite(p);
	            dialog.dismiss();
	        }

	    });

	    builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

	        @Override
	        public void onClick(DialogInterface dialog, int which) {
	            // Do nothing
	            dialog.dismiss();
	        }
	    });

	    AlertDialog alert = builder.create();
	    alert.show();
	}
	void openFullLeadersDetailsFromWebsite(int p)
	{
		Intent browserIntent; 
		switch(p)
		{
		case 0:browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://rashtriyalokdal.com/14-rld-profile/40-profile-chaudhary-charan-singh.html"));
		startActivity(browserIntent);	
		break;
		case 1:browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://rashtriyalokdal.com/14-rld-profile/42-chaudhary-ajit-singh.html"));
		startActivity(browserIntent);	
		break;
		case 2:browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://rashtriyalokdal.com/14-rld-profile/41-jayant-chaudhary.html"));
		startActivity(browserIntent);	
		break;
		case 3:browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://rashtriyalokdal.com/14-rld-profile/425-munna-singh-chauhan.html"));
		startActivity(browserIntent);	
		break;
			
		}
		
	}
	 private void handle_actionBar(String title)
	    {
			// TODO Auto-generated method stub
	    	 ColorDrawable colorDrawable = new ColorDrawable();
			ActionBar acb = getActionBar();
			//colorDrawable.setColor(0xff006B00);
	       // acb.setBackgroundDrawable(colorDrawable);
	        //enable home button
	        acb.setHomeButtonEnabled(true);
	        //change title of action bar
	        acb.setTitle(title);
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
		    
		    case android.R.id.home:
		        Intent intent = new Intent(this, GalleryActivity.class);
		        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		        startActivity(intent);
		        break;
		    // action with ID action_refresh was selected
		    case R.id.action_About:
		    	Intent ia=new Intent(this,RLD.class);
				startActivity(ia);
		      break;
		    // action with ID action_settings was selected
		    case R.id.action_Contact:
		      Toast.makeText(this, "Contact selected", Toast.LENGTH_SHORT)
		          .show();
		      Intent ic=new Intent(this,Contact.class);
				startActivity(ic);
		      break;
		    case R.id.action_Devloper:
			      Toast.makeText(this, "Developer selected", Toast.LENGTH_SHORT)
			          .show();
			      Intent id=new Intent(this,About.class);
					startActivity(id);
			      break;
		    case R.id.action_Rate:
			      Toast.makeText(this, "Rate selected", Toast.LENGTH_SHORT)
			          .show();
			      rateMyApp();
			      break;
		    default:
		      break;
		    }

		    return true;
		  } 
		
		public void rateMyApp() 
		{
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
	}
