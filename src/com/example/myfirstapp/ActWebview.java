package com.example.myfirstapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class ActWebview extends Activity {

	String title, url;
	Intent intent;
	
	TextView v_title;
	WebView v_webview;
	
	ProgressDialog progressdialog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_webview);

		intent = getIntent();

		title = intent.getStringExtra("title");//getStringExtra("key")값은  보내는 intent String 값과 같아야 한다
		url = intent.getStringExtra("url");
		v_title = (TextView) findViewById(R.id.title);
		v_title.setText(title);

		v_webview = (WebView) findViewById(R.id.webview);
		v_webview.loadUrl(url); //url로드해줘야됨
		v_webview.getSettings().setJavaScriptEnabled(true);//적어줘야 자바스크립트 활성화가 된다.
		v_webview.getSettings().setUseWideViewPort(true);//확대 축소가 가능해 진다.
		v_webview.getSettings().setGeolocationEnabled(true);//위치정보 확인
		//v_webview.getSettings().setUserAgentString(true);//모바일 페이지로 보기 pc버전으로 보기 설정 가능
		
		
		
		v_webview.setWebViewClient(new WebViewClient(){

			@Override
			public void onPageFinished(WebView view, String url) {
				// TODO Auto-generated method stub
				super.onPageFinished(view, url);
				progressdialog.dismiss();
			}

			@Override
			public void onPageStarted(WebView view, String url, Bitmap favicon) {
				// TODO Auto-generated method stub
				super.onPageStarted(view, url, favicon);
				progressdialog = ProgressDialog.show(ActWebview.this, "알림", "페이지를 읽고 있습니다...");
				//.show 로 보이는것은 대부분 대화상자. ex) Toast.show() 이것도 대화상자로 뜸
			}

			
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO Auto-generated method stub
				return super.shouldOverrideUrlLoading(view, url);
			}
			
		});

	}
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		
		if(progressdialog.isShowing()){//사용자에게 보여주고있을때에는 
			progressdialog.dismiss();
			return;
			
		}
		
		if(v_webview.canGoBack()){
			v_webview.goBack();			
		}
		else{
			finish();
		}
		
	}
}
