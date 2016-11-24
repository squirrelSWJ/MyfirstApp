package com.example.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ActWebtoon extends Activity {

	Intent getIntent;
	TextView title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_webtoon);

		setLayout();



	}

	private void setLayout(){
		getIntent = getIntent();

		title = (TextView) findViewById(R.id.title);

		String v_title = getIntent.getStringExtra("title");
		int v_subtitle = getIntent.getIntExtra("subtitle", 0);

		title.setText(v_title +", subtitle : "+v_subtitle);

	}

}
