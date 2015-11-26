package com.cbkj.rrh.ui.me;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cbkj.rrh.R;
import com.cbkj.rrh.base.ui.BaseActivity;
import com.cbkj.rrh.view.me.MeTopView;

/**
 * 个人中心
 * @author jason
 * @date:2015-11-21
 * */
public class MeActivity extends BaseActivity{

	private MeTopView meTopView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.a_me);
		this.initView();
		this.initListener();
	}
	
	private void initView(){
		TextView titleView=(TextView)this.findViewById(R.id.header_title_view);
		titleView.setText(R.string.me_title);
		
		meTopView=(MeTopView)this.findViewById(R.id.me_top_view);
		List<View> viewList=new ArrayList<View>();
//		viewList.add(this.getView(R.layout.me_a_top_user_view));
//		viewList.add(this.getView(R.layout.me_a_top_company_view));
		meTopView.createView(viewList);
	}
	
	private void initListener(){
		
	}
}
