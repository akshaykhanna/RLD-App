package com.akby.rld;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RSSreader extends Activity 
{
	 private String finalUrl="http://tutorialspoint.com/android/sampleXML.xml";
	   private HandleRSS obj;
	   private EditText title,link,description;

	   @Override
	   protected void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.rss_lay);
	      title = (EditText)findViewById(R.id.editText1);
	      link = (EditText)findViewById(R.id.editText2);
	      description = (EditText)findViewById(R.id.editText3);
	   }

	
	   public void fetch(View view)
	   {
	      obj = new HandleRSS(finalUrl);
	      obj.fetchXML();
	      while(obj.parsingComplete);
	         title.setText(obj.getTitle());
	         link.setText(obj.getLink());
	         description.setText(obj.getDescription());
	   }
	
  
}
