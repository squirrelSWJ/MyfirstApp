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

		title = intent.getStringExtra("title");//getStringExtra("key")����  ������ intent String ���� ���ƾ� �Ѵ�
		url = intent.getStringExtra("url");
		v_title = (TextView) findViewById(R.id.title);
		v_title.setText(title);

		v_webview = (WebView) findViewById(R.id.webview);
		v_webview.loadUrl(url); //url�ε�����ߵ�
		v_webview.getSettings().setJavaScriptEnabled(true);//������� �ڹٽ�ũ��Ʈ Ȱ��ȭ�� �ȴ�.
		v_webview.getSettings().setUseWideViewPort(true);//Ȯ�� ��Ұ� ������ ����.
		v_webview.getSettings().setGeolocationEnabled(true);//��ġ���� Ȯ��
		//v_webview.getSettings().setUserAgentString(true);//����� �������� ���� pc�������� ���� ���� ����
		
		
		
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
				progressdialog = ProgressDialog.show(ActWebview.this, "�˸�", "�������� �а� �ֽ��ϴ�...");
				//.show �� ���̴°��� ��κ� ��ȭ����. ex) Toast.show() �̰͵� ��ȭ���ڷ� ��
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
		
		if(progressdialog.isShowing()){//����ڿ��� �����ְ����������� 
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
