package com.akby.rld;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
public class  WebViewYouTube extends ModActivity
{
	private MyWebChromeClient mWebChromeClient = null;
	private View mCustomView;
	private LinearLayout mContentView;
	private FrameLayout mCustomViewContainer;
	private WebChromeClient.CustomViewCallback mCustomViewCallback;
	WebView myWebView;
	 @Override
	    public void onCreate(Bundle savedInstanceState) 
	 {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.webview_lay_new);
	        
	        myWebView = (WebView) findViewById(R.id.webview01);
	        mWebChromeClient = new MyWebChromeClient();
	        myWebView.setWebChromeClient(mWebChromeClient);
	        myWebView.loadUrl("https://www.youtube.com/user/rashtriyalokdal/videos"); 
	 }

	 @Override
	 public void onBackPressed() {
	     if (mCustomViewContainer != null)
	         mWebChromeClient.onHideCustomView();
	     else if (myWebView.canGoBack())
	         myWebView.goBack();
	     else
	         super.onBackPressed();
	 }
  class MyWebChromeClient extends WebChromeClient 
 {
    FrameLayout.LayoutParams LayoutParameters = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
            FrameLayout.LayoutParams.MATCH_PARENT);

    @Override
    public void onShowCustomView(View view, CustomViewCallback callback) {
        // if a view already exists then immediately terminate the new one
        if (mCustomView != null) {
            callback.onCustomViewHidden();
            return;
        }
        mContentView = (LinearLayout) findViewById(R.id.LL_Webview_new);
        mContentView.setVisibility(View.GONE);
        mCustomViewContainer = new FrameLayout(WebViewYouTube.this);
        mCustomViewContainer.setLayoutParams(LayoutParameters);
        mCustomViewContainer.setBackgroundResource(android.R.color.black);
        view.setLayoutParams(LayoutParameters);
        mCustomViewContainer.addView(view);
        mCustomView = view;
        mCustomViewCallback = callback;
        mCustomViewContainer.setVisibility(View.VISIBLE);
        setContentView(mCustomViewContainer);
    }

    @Override
    public void onHideCustomView() {
        if (mCustomView == null) {
            return;
        } else {
            // Hide the custom view.  
            mCustomView.setVisibility(View.GONE);
            // Remove the custom view from its container.  
            mCustomViewContainer.removeView(mCustomView);
            mCustomView = null;
            mCustomViewContainer.setVisibility(View.GONE);
            mCustomViewCallback.onCustomViewHidden();
            // Show the content view.  
            mContentView.setVisibility(View.VISIBLE);
            setContentView(mContentView);
        }
    }
}
} 