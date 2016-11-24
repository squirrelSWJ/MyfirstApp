package com.example.myfirstapp;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class ActMain extends Activity implements OnClickListener{

	TextView btn_menu, btn_setting, btn_anumobile, btn_movie, btn_weather, btn_tel, btn_map, btn_webtoon;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_main);

		setLayout();
	}

	private void setLayout(){//�ݺ������� ����Ϸ��� �̷��� �Լ��� ����� ����ϴ°� ȿ������

		btn_menu = (TextView) findViewById(R.id.btn_menu);
		btn_setting = (TextView) findViewById(R.id.btn_setting);
		btn_anumobile = (TextView) findViewById(R.id.btn_anumobile);
		btn_movie = (TextView) findViewById(R.id.btn_movie);
		btn_weather = (TextView) findViewById(R.id.btn_weather);
		btn_tel = (TextView) findViewById(R.id.btn_tel);
		btn_map = (TextView) findViewById(R.id.btn_map);
		btn_webtoon = (TextView) findViewById(R.id.btn_webtoon);

		btn_menu.setVisibility(View.INVISIBLE);

		btn_setting.setOnClickListener(this);
		btn_anumobile.setOnClickListener(this);
		btn_movie.setOnClickListener(this);
		btn_weather.setOnClickListener(this);
		btn_tel.setOnClickListener(this);
		btn_map.setOnClickListener(this);
		btn_webtoon.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {//��ư���� �������� �� View �� �����´�
		// TODO Auto-generated method stub
		switch(v.getId()){		//case ���� break���� �� ���ݽô�
		case R.id.btn_setting:

			break;
		case R.id.btn_anumobile:

			break;
		case R.id.btn_movie:

			break;
		case R.id.btn_weather:

			break;
		case R.id.btn_tel:

			break;
		case R.id.btn_map:

			break;
		case R.id.btn_webtoon:

			break;

		default:
			break;
		}
	}

}
