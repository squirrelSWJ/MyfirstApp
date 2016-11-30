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
	 * ���̾ƿ��� �����ϱ� ���� �Լ� �Դϴ�.
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
			startActivity(getWebUrl("���̹� ����", "http://comic.naver.com/index.nhn"));
			break;
		case R.id.btn_daum:
			startActivity(getWebUrl("���� ����", "http://webtoon.daum.net/#day=wed&tab=day"));
			break;

		case R.id.btn_Lezhin:
			startActivity(getWebUrl("���� �ڹͽ� ����", "https://www.lezhin.com/ko/"));
			break;

		case R.id.btn_nate:
			startActivity(getWebUrl("����Ʈ�� ����", "http://comics.nate.com/main"));
			break;
			
		default:
			break;
		}

	}
	
	
	/**
	 * ����� ���� �� ����Ʈ ����
	 * @param title Ÿ��Ʋ �Է�
	 * @param url ���� �� URL
	 * @return intent
	 */
	private Intent getWebUrl(String title, String url){
		Intent intent = new Intent(ActWebtoon.this,ActWebview.class);
		intent.putExtra("title", title);
		intent.putExtra("url", url);
		return intent;
	}

}
