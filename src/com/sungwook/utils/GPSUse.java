package com.sungwook.utils;

import java.io.IOException;

/*import com.jongbean.dao.GPSData;
import com.jongbean.gps.GPSProvider;
*/
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Handler;

public class GPSUse {

	private Activity activity;
	boolean gps_enable;
	boolean gps_enable_chk;

	boolean update_enable_chk;

	/**
	 * GPS ?��경설?��?��?���? ?��?�� ?�� ?��?��?�� 체크
	 */
	public boolean resumeCheck = false;

	/**
	 * GPS ?��?�� ?��?���?�?
	 */
	private boolean gps_Check;
	private LocationManager locationManager = null;
	/*private GPSProvider gpsProvider;*/

	/**
	 * GPS ?���? ???��
	 */
	/*private GPSData mGps;*/

	private Utils utils;
	private SharedValues sv;
	
	private Handler mHandler2;

	public GPSUse(Activity ac, Handler handler_){
		this.activity = ac;
		utils = new Utils(activity);
		sv = new SharedValues(activity);
		mHandler2 = handler_;
	}

	/**
	 * GPS?��보�?? �??��?���? ?��?�� 메소?��
	 * @return 결과�?
	 * @throws IOException ?��?��?��?�� ?��?�� 체크
	 */
	/*public void Gps_Init() throws IOException{
		//GPS ?��비스 ?���?
		String context = Context.LOCATION_SERVICE;
		locationManager = (LocationManager)(activity.getSystemService(context));
		mGps = new GPSData(activity);

		if(!locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
//			if(!sv.getGPSStatus()){
//				alertCheckGPS();
//			}else{
				GPSConfirm();
//			}
			

		}else{

			String temp =""; 
			gpsProvider = new GPSProvider(locationManager);

			GPSData.gps_lat = gpsProvider.getLatitude();
			GPSData.gps_lon = gpsProvider.getLongitude();

			Utils.log("gps_lat", ""+GPSData.gps_lat);
			Utils.log("gps_lon", ""+GPSData.gps_lon);
			
			mHandler.sendEmptyMessageDelayed(0, 1000);
			
		}

	}
	
	Handler mHandler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			
			if(GPSData.gps_lat == 0.0){
				try {
					Gps_Init();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				mHandler2.sendEmptyMessage(0);
			}
			
			
		};
	};*/

	public static boolean bStart = true;

	/**
	 * ?��치정�? ?��?��?�� ?���? 메시�? 출력
	 */
	/*public void alertCheckGPS() {

		AlertDialog.Builder gsDialog = new AlertDialog.Builder(activity);
		gsDialog.setTitle("?��치정보확?��");
		gsDialog.setMessage("?�테?��?��?�에?�� 고객?��?�� ?��?�� ?���? ?��보�?? ?��?��?��고자 ?��?��?��.");
		gsDialog.setPositiveButton("?��?��", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// GPS?��?�� ?��면으�? ?��?��
				//sv.setGPSStatus(true);
				moveConfigGPS();
				dialog.dismiss();
				resumeCheck = true;
			}
		});
		gsDialog.setNegativeButton("취소", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// GPS?��?�� ?��면으�? ?��?��
				dialog.dismiss();
				GPSData.gps_lat = 37.516799;
				GPSData.gps_lon = 127.046911;
				
//				Act.locaionThread();
			}
		}).create().show();

	}
	
	*//**
	 * ?��치정�? ?��?��?�� ?���? 메시�? 출력
	 *//*
	public void GPSConfirm() {

		AlertDialog.Builder gsDialog = new AlertDialog.Builder(activity);
		gsDialog.setTitle("?��?��?��");
		gsDialog.setMessage("?��치정보�?? ?��?��?��?��?�� 주�??��보�?? ?��?��?��?��?�� ?��?��?��?��.");
		gsDialog.setPositiveButton("?��?��", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// GPS?��?�� ?��면으�? ?��?��
				moveConfigGPS();
				dialog.dismiss();
				resumeCheck = true;
			}
		});
		gsDialog.setNegativeButton("취소", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// GPS?��?�� ?��면으�? ?��?��
				GPSData.gps_lat = 37.516799;
				GPSData.gps_lon = 127.046911;
				
//				Act.locaionThread();
				dialog.dismiss();
			}
		}).create().show();

	}*/

	// GPS ?��?��?��면으�? ?��?��
	public void moveConfigGPS() {
		Intent gpsOptionsIntent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
		activity.startActivity(gpsOptionsIntent);
	}

}
