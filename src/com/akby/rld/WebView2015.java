package com.akby.rld;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class WebView2015 extends ModActivity
{
	 WebView web;
	 ProgressBar progressBar;

	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        Bundle b=getIntent().getExtras();
	        if(b.getInt("int")==0)
	        {
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
	                                        WindowManager.LayoutParams.FLAG_FULLSCREEN); 
	        }
	        setContentView(R.layout.webview_lay_new);
           
	        web = (WebView) findViewById(R.id.webview01);
	        progressBar = (ProgressBar) findViewById(R.id.progressBar1);
	        progressBar.setMax(100);
	       // web.setWebViewClient(new myWebClient());
	        web.setWebChromeClient(new MyWebViewClient());
	        web.getSettings().setJavaScriptEnabled(true);
	        String url=getValueFromBundle();
	        
	        if(b.getInt("int")==0)
	        	setWebViewInThatWay();
	        web.loadUrl(url); 
	        progressBar.setProgress(0);
	    }
	    private void setWebViewInThatWay() {
			// TODO Auto-generated method stub
	    	
	    	web.getSettings().setLoadWithOverviewMode(true);
	    	web.getSettings().setJavaScriptEnabled(true);
	        web.getSettings().setUseWideViewPort(true);
	        web.getSettings().setBuiltInZoomControls(true);
		}
		String getValueFromBundle()
	     {
	    	 Bundle b=getIntent().getExtras();
			 String url=b.getString("url");
			 return url;
	     }
		
		private class MyWebViewClient extends WebChromeClient 
		{	
			@Override
			public void onProgressChanged(WebView view, int newProgress) {			
				progressBar.setProgress(newProgress);
				if(newProgress>=100)
				{
					 progressBar.setVisibility(View.GONE);
				}
				super.onProgressChanged(view, newProgress);
			}
			
		}

		

		/*
	    public class myWebClient extends WebViewClient
	    {
	    	*
	    	
	    	@Override
	     public void onPageStarted(WebView view, String url, Bitmap favicon) {
	      // TODO Auto-generated method stub
	      super.onPageStarted(view, url, favicon);
	     }

	     @Override
	     public boolean shouldOverrideUrlLoading(WebView view, String url) {
	      // TODO Auto-generated method stub

	      view.loadUrl(url);
	      return true;

	     }

	     @Override
	     public void onPageFinished(WebView view, String url) {
	      // TODO Auto-generated method stub
	      super.onPageFinished(view, url);

	      progressBar.setVisibility(View.GONE);
	     }
	    }
        */
	    // To handle "Back" key press event for WebView to go back to previous screen.
	 @Override
	 public boolean onKeyDown(int keyCode, KeyEvent event)
	 {
	  if ((keyCode == KeyEvent.KEYCODE_BACK) && web.canGoBack()) 
	  {
	   web.goBack();
	   return true;
	  }
	  return super.onKeyDown(keyCode, event);
	 }
	}
	
  

