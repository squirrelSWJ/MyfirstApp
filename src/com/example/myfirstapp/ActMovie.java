package com.example.myfirstapp;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.adapter.CustomAdapter;
import com.example.dao.MovieDao;
import com.example.parser.JsonThread;
import com.example.parser.ParseData;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ActMovie extends Activity {
	
	JsonThread jt;
	Intent getIntent;
	TextView title,txt,txt1,txt2;
	ListView listview;
	
	ParseData parsedata;
	CustomAdapter mCustomAdapter;
	ArrayList<MovieDao> item = new ArrayList<MovieDao>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_movie);
		
		txt = (TextView) findViewById(R.id.txt);
		txt1 = (TextView) findViewById(R.id.txt1);
		txt2 = (TextView) findViewById(R.id.txt2);
		listview = (ListView) findViewById(R.id.listview);
		
		getIntent = getIntent();
		String v_title = getIntent.getStringExtra("title");
		title = (TextView) findViewById(R.id.title);
		title.setText(v_title);
		
		
		jt = new JsonThread(mHandler, 0);
		jt.setDaemon(true);
		jt.setQuery("http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json?"
				, "key=3b0b0415669c9b63537c9a6df1971f8d&targetDt=20161102&weekGb=0");
		jt.start();


	}

	private Handler mHandler = new Handler()
	{

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			HashMap<String, Object> map = new HashMap<String, Object>();
			map = (HashMap<String, Object>) msg.obj;
			
			parsedata = new ParseData();
			map = parsedata.getMovieParser(map);
			
			txt.setText((String)map.get("boxofficeType"));
			txt1.setText("조회기간 +"+(String)map.get("showRange"));
			txt2.setText((String)map.get("yearWeekTime").toString().substring(0,4) + "년 " +
			(String)map.get("yearWeekTime").toString().substring(4,6) + "주차");
			
			item = (ArrayList<MovieDao>)map.get("BoxOffice");
			
			mCustomAdapter = new CustomAdapter(ActMovie.this, item);
			listview.setAdapter(mCustomAdapter);
			listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	            @Override
	            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	                ListView listView = (ListView) parent;
	                // TODO 아이템 클릭시에 구현할 내용은 여기에.
	                Intent intent_mobile = new Intent(Intent.ACTION_VIEW,Uri.parse("http://m.search.naver.com/search.naver?query=" + item.get(position).getMovieNm()));
	    			intent_mobile.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NO_ANIMATION);//clear top은 같은 activity를 여러개 생성하는것을 막아준다.
	    			startActivity(intent_mobile);
	            }

	        });
			
		}

	};
	
}
