package com.example.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class ActWebtoon extends Activity implements OnClickListener {

	Intent getIntent;
	TextView title,btn_naver,btn_daum,btn_nate,btn_lezhin;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_webtoon);

		setLayout();



	}


	/**
	 * 레이아웃을 지정하기 위한 함수 입니다.
	 */
	private void setLayout(){
		getIntent = getIntent();
		String v_title = getIntent.getStringExtra("title");
		title = (TextView) findViewById(R.id.title);
		title.setText(v_title);
		
		btn_naver = (TextView) findViewById(R.id.btn_naver);
		btn_daum = (TextView) findViewById(R.id.btn_daum);
		btn_lezhin = (TextView) findViewById(R.id.btn_Lezhin);
		btn_nate = (TextView) findViewById(R.id.btn_nate);

		btn_naver.setOnClickListener(this);
		btn_daum.setOnClickListener(this);
		btn_lezhin.setOnClickListener(this);
		btn_nate.setOnClickListener(this);


		int v_subtitle = getIntent.getIntExtra("subtitle", 0);

		title.setText(v_title +", subtitle : "+v_subtitle);

	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {
		case R.id.btn_naver:
			startActivity(getWebUrl("네이버 웹툰", "http://comic.naver.com/index.nhn"));
			break;
		case R.id.btn_daum:
			startActivity(getWebUrl("다음 웹툰", "http://webtoon.daum.net/#day=wed&tab=day"));
			break;

		case R.id.btn_Lezhin:
			startActivity(getWebUrl("레진 코믹스 웹툰", "https://www.lezhin.com/ko/"));
			break;

		case R.id.btn_nate:
			startActivity(getWebUrl("네이트판 웹툰", "http://comics.nate.com/main"));
			break;
			
		default:
			break;
		}

	}
	
	
	/**
	 * 웹뷰로 전달 될 인텐트 생성
	 * @param title 타이틀 입력
	 * @param url 실행 될 URL
	 * @return intent
	 */
	private Intent getWebUrl(String title, String url){
		Intent intent = new Intent(ActWebtoon.this,ActWebview.class);
		intent.putExtra("title", title);
		intent.putExtra("url", url);
		return intent;
	}

}
