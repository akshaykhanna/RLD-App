package com.akby.rld;



import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

   Button bGA;
   Bitmap bm;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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


	private void intialise() {
		// TODO Auto-generated method stub
		bGA=(Button)findViewById(R.id.bGA);
		bGA.setOnClickListener(this);
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
	      Toast.makeText(this, "About selected", Toast.LENGTH_SHORT)
	          .show();
	      break;
	    // action with ID action_settings was selected
	    case R.id.action_Contact:
	      Toast.makeText(this, "Contact selected", Toast.LENGTH_SHORT)
	          .show();
	      break;
	    case R.id.action_Devloper:
		      Toast.makeText(this, "Developer selected", Toast.LENGTH_SHORT)
		          .show();
		      break;
	    case R.id.action_Rate:
		      Toast.makeText(this, "Rate selected", Toast.LENGTH_SHORT)
		          .show();
		      break;
	    default:
	      break;
	    }

	    return true;
	  } 

	@Override
	public void onClick(View id)
	{
		// TODO Auto-generated method stub
		switch(id.getId())
		{
		case R.id.bGA: Intent i=new Intent(MainActivity.this,SpalshScreenActivity.class);
		startActivity(i);;
			break;
		}
	}
    
}
