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
	 * GPS ?™˜ê²½ì„¤? •?˜?´ì§? ?´?™ ?›„ ? ‘?†?‹œ ì²´í¬
	 */
	public boolean resumeCheck = false;

	/**
	 * GPS ?‚¬?š© ?„¤? •ë¶?ë¶?
	 */
	private boolean gps_Check;
	private LocationManager locationManager = null;
	/*private GPSProvider gpsProvider;*/

	/**
	 * GPS ? •ë³? ???¥
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
	 * GPS? •ë³´ë?? ê°?? ¸?˜¤ê¸? ?œ„?•œ ë©”ì†Œ?“œ
	 * @return ê²°ê³¼ê°?
	 * @throws IOException ?„¤?Š¸?›Œ?¬ ?—?Ÿ¬ ì²´í¬
	 */
	/*public void Gps_Init() throws IOException{
		//GPS ?„œë¹„ìŠ¤ ?“±ë¡?
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
	 * ?œ„ì¹˜ì •ë³? ?‚¬?š©?— ?”°ë¥? ë©”ì‹œì§? ì¶œë ¥
	 */
	/*public void alertCheckGPS() {

		AlertDialog.Builder gsDialog = new AlertDialog.Builder(activity);
		gsDialog.setTitle("?œ„ì¹˜ì •ë³´í™•?¸");
		gsDialog.setMessage("?˜í…Œ?Š¤?Š¸?™ì—?„œ ê³ ê°?‹˜?˜ ?˜„?¬ ?œ„ì¹? ? •ë³´ë?? ?‚¬?š©?•˜ê³ ì ?•©?‹ˆ?‹¤.");
		gsDialog.setPositiveButton("?™•?¸", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// GPS?„¤? • ?™”ë©´ìœ¼ë¡? ?´?™
				//sv.setGPSStatus(true);
				moveConfigGPS();
				dialog.dismiss();
				resumeCheck = true;
			}
		});
		gsDialog.setNegativeButton("ì·¨ì†Œ", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// GPS?„¤? • ?™”ë©´ìœ¼ë¡? ?´?™
				dialog.dismiss();
				GPSData.gps_lat = 37.516799;
				GPSData.gps_lon = 127.046911;
				
//				Act.locaionThread();
			}
		}).create().show();

	}
	
	*//**
	 * ?œ„ì¹˜ì •ë³? ?‚¬?š©?— ?”°ë¥? ë©”ì‹œì§? ì¶œë ¥
	 *//*
	public void GPSConfirm() {

		AlertDialog.Builder gsDialog = new AlertDialog.Builder(activity);
		gsDialog.setTitle("?…Œ?Š¤?Š¸");
		gsDialog.setMessage("?œ„ì¹˜ì •ë³´ë?? ?Š¹?¸?•˜?…”?•¼ ì£¼ë?? •ë³´ë?? ?‚¬?š©?•˜?‹¤?ˆ˜ ?ˆ?Šµ?‹ˆ?‹¤.");
		gsDialog.setPositiveButton("?™•?¸", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// GPS?„¤? • ?™”ë©´ìœ¼ë¡? ?´?™
				moveConfigGPS();
				dialog.dismiss();
				resumeCheck = true;
			}
		});
		gsDialog.setNegativeButton("ì·¨ì†Œ", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// GPS?„¤? • ?™”ë©´ìœ¼ë¡? ?´?™
				GPSData.gps_lat = 37.516799;
				GPSData.gps_lon = 127.046911;
				
//				Act.locaionThread();
				dialog.dismiss();
			}
		}).create().show();

	}*/

	// GPS ?„¤? •?™”ë©´ìœ¼ë¡? ?´?™
	public void moveConfigGPS() {
		Intent gpsOptionsIntent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
		activity.startActivity(gpsOptionsIntent);
	}

}
