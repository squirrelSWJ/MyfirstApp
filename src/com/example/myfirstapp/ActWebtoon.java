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

		title = (TextView) findViewById(R.id.title);
		btn_naver = (TextView) findViewById(R.id.btn_naver);
		btn_daum = (TextView) findViewById(R.id.btn_daum);
		btn_lezhin = (TextView) findViewById(R.id.btn_Lezhin);
		btn_nate = (TextView) findViewById(R.id.btn_nate);

		btn_naver.setOnClickListener(this);
		btn_daum.setOnClickListener(this);
		btn_lezhin.setOnClickListener(this);
		btn_nate.setOnClickListener(this);


		String v_title = getIntent.getStringExtra("title");
		int v_subtitle = getIntent.getIntExtra("subtitle", 0);

		title.setText(v_title +", subtitle : "+v_subtitle);

	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {
		case R.id.btn_naver:
			
			break;
		case R.id.btn_daum:

			break;

		case R.id.btn_Lezhin:

			break;

		case R.id.btn_nate:

			break;
			
		default:
			break;
		}

	}

}
