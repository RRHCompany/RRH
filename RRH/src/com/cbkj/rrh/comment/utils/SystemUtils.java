package com.cbkj.rrh.comment.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Log;
/**
 * 系统工具
 * @author jason
 * */
public class SystemUtils {
	
	private static final String TAG = "SystemUtils";
	/**获取包名*/
	public static String getPackageName(Context context){
		String packageName = "";
		try {
			packageName=context.getApplicationInfo().packageName;
		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
		}
		return packageName;
	}
	/**获取版本号*/
	public static int getVersionCode(Context context) {
		int verCode = -1;
		try {
			verCode = context.getPackageManager().getPackageInfo(SystemUtils.getPackageName(context), 0).versionCode;
		} catch (NameNotFoundException e) {
			Log.e(TAG, e.getMessage());
		}
		return verCode;
	}
	/**获取版本名称*/
	public static String getVersionName(Context context) {
		String verName = "";
		try {
			verName = context.getPackageManager().getPackageInfo(SystemUtils.getPackageName(context), 0).versionName;
		} catch (NameNotFoundException e) {
			Log.e(TAG, e.getMessage());
		}
		return verName;
	}
	
	/** 获得当前进程的名字*/
    public static String getCurProcessName(Context context) {
        int pid = android.os.Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : activityManager.getRunningAppProcesses()) {
            if (appProcess.pid == pid) {
                return appProcess.processName;
            }
        }
        return null;
    }
    /** 判断是否是当前线程*/
    public static boolean isCurProcess(Context context){
    	return SystemUtils.getPackageName(context).equals(SystemUtils.getCurProcessName(context));
    }
    
    /**判断当前网络是否已经连接 */
	public static boolean isNetworkConnect(Context context) { 
		// 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理） 
		try { 
			ConnectivityManager connectivity = (ConnectivityManager) context .getSystemService(Context.CONNECTIVITY_SERVICE); 
			if (connectivity != null) { 
				// 获取网络连接管理的对象 
				NetworkInfo info = connectivity.getActiveNetworkInfo(); 
				if (info != null&& info.isConnected()) { 
					// 判断当前网络是否已经连接 
					if (info.getState() == NetworkInfo.State.CONNECTED) { 
						return true; 
					} 
				} 
			} 
		} catch (Exception e) { 
		} 
		return false; 
	} 
	
	/**获取设备的imei号*/
	public static String getDeviceImei(Context context){
		TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE); 
		return tm.getDeviceId();
	}
	
}
