package com.example.parser;

import java.util.HashMap;

import android.os.Handler;
import android.os.Message;

public class JsonThread extends Thread {
	String m_Url;  // �α��� �Ķ����? ���� ��ü
	String m_query;  // �α��� �Ķ����? ���� ��ü
	
	Handler handler; // �Ľ̵� ������ ó���ϱ� ���� �޼ҵ�
	Parser parser;  // �Ľ�ó���� ���� Ŭ����
	
	int type = 0;

	//�α��� ������ ���? ���� ��ü
	private HashMap<String, Object> map = new HashMap<String, Object>();
	
	public JsonThread(Handler _handler, int type_){
		this.parser = new Parser();
		this.handler = _handler;
		this.type = type_;
	}
	
	/**
	 * �Ľ� URL���� �� ������ �ޱ� ���� �޼ҵ� 
	 * @param url URL����
	 * @param query ��������
	 */
	public void setQuery(String url, String query){
		this.m_query = query;
		this.m_Url = url;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

		map = parser.getJson(m_Url,m_query);
		Message msg = new Message();
		msg.what = type;
		msg.obj = map;
	
		handler.sendMessage(msg);
	}
	
}
