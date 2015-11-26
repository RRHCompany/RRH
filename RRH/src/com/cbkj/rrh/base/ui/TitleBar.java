package com.cbkj.rrh.base.ui;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.cbkj.rrh.R;
import com.cbkj.rrh.comment.utils.ViewUtils;
import com.cbkj.rrh.ui.main.MenuListener;

public class TitleBar implements OnClickListener{
	
	private Activity activity;
	private View barView;
	private View headLayoutView;//头部头像layout
	private ImageView headView;//头像
	private TextView titleView;
	private TextView otherView;
	private ImageView backView;
	private TitleBarListener listener;
	private MenuListener menuListener;
	
	public TitleBar(Activity activity,int title){
		this(activity, null, null,null);
		titleView.setText(activity.getResources().getString(title));
	}
	public TitleBar(Activity activity,View barView,TitleBarListener listener){
		this(activity, barView, listener,null);
	}
	public TitleBar(Activity activity,View barView,TitleBarListener listener,MenuListener menuListener){
		this.activity=activity;
		this.listener=listener;
		this.menuListener=menuListener;
		if(barView!=null){
			this.barView=barView;
		}else{
			this.barView=activity.findViewById(R.id.header_layout);
		}
		this.initView();
		this.initListener();
	}
	private void initView(){
		headLayoutView= barView.findViewById(R.id.header_head_layout_view);
		headView= (ImageView)barView.findViewById(R.id.header_head_view);
		titleView= (TextView)barView.findViewById(R.id.header_title_view);
		otherView= (TextView)barView.findViewById(R.id.header_other_view);
		backView= (ImageView)barView.findViewById(R.id.header_back_view);
	}
	private void initListener(){
		otherView.setOnClickListener(this);
		headLayoutView.setOnClickListener(this);
		backView.setOnClickListener(this);
	}
	//设置用户头像
	public void setHeadImage(int headImage){
		headView.setImageResource(headImage);
		headLayoutView.setVisibility(View.VISIBLE);
		backView.setVisibility(View.GONE);
	}
	//设置标题
	public void setTitle(int title){
		titleView.setText(activity.getResources().getString(title));
	}
	//设置其他按钮
	public void setOther(String text,int icon,Object tag){
		otherView.setText(text);
		otherView.setTag(tag);
		if(icon==-1){
			otherView.setCompoundDrawables(null, null,null , null); 
		}else{
			ViewUtils.setTextViewDrawables(activity, otherView, icon, 1);
		}
		otherView.setVisibility(View.VISIBLE);
	}
	
	@Override
	public void onClick(View v) {
		switch(v.getId()){
			case R.id.header_head_layout_view:
				//顶部用户ICON
				if(menuListener!=null){
					menuListener.openDrawer();
				}
				break;
			case R.id.header_other_view:
				//其他按钮
				if(listener!=null){
					listener.onHeaderOtherButton(v);
				}
				break;
			case R.id.header_back_view:
				//退出
				activity.finish();
				break;
		}
	}
	
	public static interface TitleBarListener{
		public void onHeaderOtherButton(View v);
	}
}
