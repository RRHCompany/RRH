package com.cbkj.rrh.ui.contacts;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.cbkj.rrh.R;
import com.cbkj.rrh.adapter.contacts.ContactsCombineBusinessAdapter;
import com.cbkj.rrh.base.ui.BaseActivity;
import com.cbkj.rrh.base.ui.TitleBar;
import com.cbkj.rrh.bean.Business;

/**
 * 合作商品企业
 * @author jason
 * @data 2015-11-26
 */
public class ContactCombineBusinessActivity extends BaseActivity implements TitleBar.TitleBarListener  {
	private TitleBar titleBar;
	private ListView listView;
	private ContactsCombineBusinessAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_contact_combine_business);
		this.initView();
	}
	
	private void initView(){
		titleBar=new TitleBar(this,R.string.home_contact_combine_business_title);
		titleBar.setOther("", R.drawable.contact_combine_business_seacth_iocn, null);
		titleBar.addTitleBarListener(this);
		
		listView=(ListView)this.findViewById(R.id.contact_goods_business_listview);
		List<Business> list=new ArrayList<Business>();
		for(int i=0;i<10;i++){
			list.add(new Business(i, "深圳市xxx科技有限公司"+i));
		}
		adapter=new ContactsCombineBusinessAdapter(this, list);
		listView.setAdapter(adapter);
	}

	@Override
	public void onHeaderOtherButton(View v) {
		//查找企业
	}
}
