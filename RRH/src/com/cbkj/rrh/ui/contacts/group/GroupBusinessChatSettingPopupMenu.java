package com.cbkj.rrh.ui.contacts.group;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.cbkj.rrh.R;

public class GroupBusinessChatSettingPopupMenu extends PopupWindow implements OnClickListener{
	
	private Activity activity;
	private View popView;
	private TextView persionSetting;
	public GroupBusinessChatSettingPopupMenu(Activity activity) {  
        super(activity);  
        this.activity = activity;  
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
        popView = inflater.inflate(R.layout.a_contact_group_business_chat_setting_popupmenu, null);// 加载菜单布局文件  
        this.setContentView(popView);// 把布局文件添加到popupwindow中  
        this.setWidth(dip2px(activity, 120));// 设置菜单的宽度（需要和菜单于右边距的距离搭配，可以自己调到合适的位置）  
        this.setHeight(LayoutParams.WRAP_CONTENT);  
        this.setFocusable(true);// 获取焦点  
        this.setTouchable(true); // 设置PopupWindow可触摸  
        this.setOutsideTouchable(true); // 设置非PopupWindow区域可触摸  
        ColorDrawable dw = new ColorDrawable(0x00000000);  
        this.setBackgroundDrawable(dw);
        this.initView();
        this.initListener();
    }  
	
	private void initView(){
		persionSetting=(TextView)popView.findViewById(R.id.group_business_chat_persion_setting_tv);
	}
	
	private void initListener(){
		persionSetting.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.group_business_chat_persion_setting_tv:
			Intent intent=new Intent(activity,GroupBusinessChatPersionSettingActivity.class);
			activity.startActivity(intent);
			break;
		}
		this.dismiss();
	}
	/**设置显示的位置  resourId  这里的x,y值自己调整可以 */  
    public void showLocation(int resourId) {  
        this.showAsDropDown(activity.findViewById(resourId), dip2px(activity, 0),  
                dip2px(activity, 0));  
    }  
	
	// dip转换为px  
    public int dip2px(Context context, float dipValue) {  
        final float scale = context.getResources().getDisplayMetrics().density;  
        return (int) (dipValue * scale + 0.5f);  
    } 
}
