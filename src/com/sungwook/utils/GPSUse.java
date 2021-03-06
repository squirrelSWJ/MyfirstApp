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
	 * GPS ?κ²½μ€? ??΄μ§? ?΄? ? ? ?? μ²΄ν¬
	 */
	public boolean resumeCheck = false;

	/**
	 * GPS ?¬?© ?€? λΆ?λΆ?
	 */
	private boolean gps_Check;
	private LocationManager locationManager = null;
	/*private GPSProvider gpsProvider;*/

	/**
	 * GPS ? λ³? ???₯
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
	 * GPS? λ³΄λ?? κ°?? Έ?€κΈ? ?? λ©μ?
	 * @return κ²°κ³Όκ°?
	 * @throws IOException ?€?Έ??¬ ??¬ μ²΄ν¬
	 */
	/*public void Gps_Init() throws IOException{
		//GPS ?λΉμ€ ?±λ‘?
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
	 * ?μΉμ λ³? ?¬?©? ?°λ₯? λ©μμ§? μΆλ ₯
	 */
	/*public void alertCheckGPS() {

		AlertDialog.Builder gsDialog = new AlertDialog.Builder(activity);
		gsDialog.setTitle("?μΉμ λ³΄ν?Έ");
		gsDialog.setMessage("?ν?€?Έ?μ? κ³ κ°?? ??¬ ?μΉ? ? λ³΄λ?? ?¬?©?κ³ μ ?©??€.");
		gsDialog.setPositiveButton("??Έ", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// GPS?€?  ?λ©΄μΌλ‘? ?΄?
				//sv.setGPSStatus(true);
				moveConfigGPS();
				dialog.dismiss();
				resumeCheck = true;
			}
		});
		gsDialog.setNegativeButton("μ·¨μ", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// GPS?€?  ?λ©΄μΌλ‘? ?΄?
				dialog.dismiss();
				GPSData.gps_lat = 37.516799;
				GPSData.gps_lon = 127.046911;
				
//				Act.locaionThread();
			}
		}).create().show();

	}
	
	*//**
	 * ?μΉμ λ³? ?¬?©? ?°λ₯? λ©μμ§? μΆλ ₯
	 *//*
	public void GPSConfirm() {

		AlertDialog.Builder gsDialog = new AlertDialog.Builder(activity);
		gsDialog.setTitle("??€?Έ");
		gsDialog.setMessage("?μΉμ λ³΄λ?? ?Ή?Έ???Ό μ£Όλ?? λ³΄λ?? ?¬?©??€? ??΅??€.");
		gsDialog.setPositiveButton("??Έ", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// GPS?€?  ?λ©΄μΌλ‘? ?΄?
				moveConfigGPS();
				dialog.dismiss();
				resumeCheck = true;
			}
		});
		gsDialog.setNegativeButton("μ·¨μ", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// GPS?€?  ?λ©΄μΌλ‘? ?΄?
				GPSData.gps_lat = 37.516799;
				GPSData.gps_lon = 127.046911;
				
//				Act.locaionThread();
				dialog.dismiss();
			}
		}).create().show();

	}*/

	// GPS ?€? ?λ©΄μΌλ‘? ?΄?
	public void moveConfigGPS() {
		Intent gpsOptionsIntent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
		activity.startActivity(gpsOptionsIntent);
	}

}
