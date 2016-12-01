package com.example.myfirstapp;

import com.sungwook.utils.Utils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class ActMain extends Activity implements OnClickListener{

	TextView btn_menu, btn_setting, btn_anumobile, btn_movie, btn_weather, btn_tel, btn_map, btn_webtoon;
	Utils utils;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_main);
		
		setLayout();
	}

	private void setLayout(){//�ݺ������� ����Ϸ��� �̷��� �Լ��� ����� ����ϴ°� ȿ������
		
		utils = new Utils(ActMain.this);
		
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
		
		Utils.setToastShow("���̵�� " + v.getId());
		
		switch(v.getId()){		//case ���� break���� �� ���ݽô�
		case R.id.btn_setting:
			
			
			break;
		case R.id.btn_anumobile:	//�Ͻ��� intent �� action_view���
			Intent intent_mobile = new Intent(Intent.ACTION_VIEW,Uri.parse("http://m.andong.ac.kr"));
			intent_mobile.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NO_ANIMATION);//clear top�� ���� activity�� ������ �����ϴ°��� �����ش�.
			startActivity(intent_mobile);
			break;
		case R.id.btn_movie:
			Intent intent_movie = new Intent(ActMain.this,ActMovie.class);
			intent_movie.putExtra("title", "�ֽſ�ȭ����");
			startActivity(intent_movie);
			break;
		case R.id.btn_weather:

			break;
		case R.id.btn_tel:	//�Ͻ��� intent �� Action_dial ���
			Intent intent_tel = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:054-820-5684"));
			startActivity(intent_tel);
			break;
		case R.id.btn_map:	//�Ͻ��� intent �� Action_view �� geo ��� api16������ ���������� ��� ����̾ȵ�.
			Intent intent_map = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:36.544051, 128.796081"));
			startActivity(intent_map);
			break;
		case R.id.btn_webtoon://����� intent �� ����Ͽ� Actmain ���� actwebtoon class�� �̵���
			Intent intent_webtoon = new Intent(ActMain.this,ActWebtoon.class);
			intent_webtoon.putExtra("title", "����");
			intent_webtoon.putExtra("subtitle", 1);
			startActivity(intent_webtoon);
			break;

		default:
			break;
		}
	}

}
