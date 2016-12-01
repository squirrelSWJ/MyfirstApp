package com.example.adapter;

import java.util.ArrayList;

import com.example.dao.MovieDao;
import com.example.myfirstapp.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

	Context mContext;
	ArrayList<MovieDao> item = new ArrayList<MovieDao>();
	LayoutInflater inflater;
	
	TextView rank,title;
	
	public CustomAdapter(Context context, ArrayList<MovieDao> content) {
		// TODO Auto-generated constructor stub
		
		mContext = context;
		item = content; 
		inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
	}
	
	@Override
	public int getCount() {//ë¦¬ìŠ¤?Š¸ ê°œìˆ˜ë¥? ?„¸?•„? ¤?„œ ê°?? ¸?˜´
		// TODO Auto-generated method stub
		return item.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return item.get(position);
		
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertview, ViewGroup parent) {//?•œ?–‰?•œ?–‰ ë§Œë“¤?–´ì£¼ëŠ” ?—­?• 
		// TODO Auto-generated method stub
		
		if(null == convertview){
			convertview = inflater.inflate(R.layout.item_low, parent,false);
						
		}
		rank = (TextView) convertview.findViewById(R.id.rank);
		title = (TextView) convertview.findViewById(R.id.title);
		
		rank.setText(item.get(position).getRank());
		title.setText(item.get(position).getMovieNm());
		
		
		
		
		return convertview;
	}

}
