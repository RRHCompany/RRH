package com.cbkj.rrh;

import java.io.File;

import android.content.Context;
import android.os.Environment;

public class Constants {
	
	private static final String SD_CARD_DIR="sdcard_temp";//SD卡路径
	
	/**获取SDCard文件缓存路径   当前目录用来保存其他图片信息*/
	public static String getSDCachePath(Context context) {
		String filePath = null;
		if (Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED)) {
			//外部cache下的内容(/mnt/sdcard/android/data/com.xxx.xxx/cache)
			if(context.getExternalCacheDir()!=null){
				filePath=context.getExternalCacheDir().getPath()+ File.separator;
			}
		}
		if(filePath==null){
			filePath = context.getFilesDir().getPath() + File.separator + Constants.SD_CARD_DIR+ File.separator;
		}
		File file=new File(filePath);
		if(!file.exists()){
			file.mkdirs();
		}
		return filePath;
	}
}
