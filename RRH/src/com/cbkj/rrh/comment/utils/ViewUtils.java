package com.cbkj.rrh.comment.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;

public class ViewUtils {

	/**根据xml获取view*/
	public static View getView(Activity activity,int layoutID) {
		return activity.getLayoutInflater().inflate(layoutID, null);
	}
	
	/**
	 * 设置字体不受系统字体大小影响
	 * */
	public static void updateConfiguration(Activity activity){
		Resources resource = activity.getResources();
		Configuration c =resource.getConfiguration() ;
		c.fontScale=1.0f;
		resource.updateConfiguration(c, resource.getDisplayMetrics());
	}
	
	public static void setTextViewDrawables(Context context,TextView textView,int icon,int type){
		Drawable drawable=context.getResources().getDrawable(icon);
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
		switch(type){
		case 1:
			textView.setCompoundDrawables(drawable, null, null, null); //设置左图标
			break;
		case 2:
			textView.setCompoundDrawables(null, drawable,null , null); //设置上图标
			break;
		case 3:
			textView.setCompoundDrawables(null, null, drawable, null); //设置右图标
			break;
		case 4:
			textView.setCompoundDrawables(null, null,null , drawable); //设置下图标
			break;
		default :
			textView.setCompoundDrawables(null, null,null , null); 
			break;
		}
	}
}
