package com.cbkj.rrh.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.cbkj.rrh.R;
import com.cbkj.rrh.adapter.home.HomeFragmentPagerAdapter;
import com.cbkj.rrh.base.fragment.BaseFragment;
import com.cbkj.rrh.base.ui.TitleBar;
import com.cbkj.rrh.ui.contacts.ContactAddActivity;
import com.cbkj.rrh.ui.main.MenuListener;
/**
 * 首页
 * @author jason
 * @data 2015-11-25
 * */
public class HomeFragment extends BaseFragment implements  ViewPager.OnPageChangeListener,TitleBar.TitleBarListener,OnClickListener{

	private TitleBar titleBar;
	private MenuListener menuListener;
	
	private View view;
	private ViewPager mViewPager;
	private HomeFragmentPagerAdapter homeFragmentPagerAdapter;
	private ImageView messageView, contactView, cloudteamView;
	public HomeFragment(MenuListener menuListener){
		this.menuListener=menuListener;
	}
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.a_home, container, false);
		this.initView();
		this.initListener();
		return view;
	}

	private void initView() {
		titleBar=new TitleBar(getActivity(),view,this,menuListener);
		titleBar.setHeadImage(R.drawable.me_head_icon);
		
		messageView = (ImageView) view.findViewById(R.id.home_message_iv);
		contactView = (ImageView) view.findViewById(R.id.home_contact_iv);
		cloudteamView = (ImageView) view.findViewById(R.id.home_cloudteam_iv);
		mViewPager = (ViewPager) view.findViewById(R.id.home_viewpager);
		
		homeFragmentPagerAdapter = new HomeFragmentPagerAdapter(getFragmentManager(),getActivity());
        mViewPager.setAdapter(homeFragmentPagerAdapter);
        mViewPager.setOnPageChangeListener(this);
        mViewPager.setOffscreenPageLimit(2);
		this.onPageSelected(0);
		
	}
	private void initListener(){
		messageView.setOnClickListener(this);
		contactView.setOnClickListener(this);
		cloudteamView.setOnClickListener(this);
	}
	@Override
	public void onPageSelected(int index) {
		messageView.setImageResource(R.drawable.home_tab_icon1);
		contactView.setImageResource(R.drawable.home_tab_icon2);
		cloudteamView.setImageResource(R.drawable.home_tab_icon3);
		switch (index) {
			case 0:
				messageView.setImageResource(R.drawable.home_tab_enable_icon1);
				titleBar.setTitle(R.string.home_message_title);
				titleBar.setOther("", R.drawable.home_scan_qecode_icon, "message");
				break;
			case 1:
				contactView.setImageResource(R.drawable.home_tab_enable_icon2);
				titleBar.setTitle(R.string.home_contact_title);
				titleBar.setOther("", R.drawable.home_add_friend_icon, "contact");
				break;
			case 2:
				cloudteamView.setImageResource(R.drawable.home_tab_enable_icon3);
				titleBar.setTitle(R.string.home_cloudTeam_title);
				titleBar.setOther("公司资料", -1, "cloudTeam");
				break;
		}
	}
	
	@Override
	public void onHeaderOtherButton(View v) {
		//点击右上角按钮
		if(v.getTag()!=null){
			if(v.getTag().equals("message")){
				Toast.makeText(getActivity(), "扫描二维码", Toast.LENGTH_SHORT).show();
			}else if(v.getTag().equals("contact")){
				Intent intent=new Intent(getActivity(),ContactAddActivity.class);
				getActivity().startActivity(intent);
			}else if(v.getTag().equals("cloudTeam")){
				Toast.makeText(getActivity(), "公司资料", Toast.LENGTH_SHORT).show();
			}
		}
	}
	@Override
	public void onPageScrollStateChanged(int arg0) {
	}
	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
	}
	@Override
	public void onClick(View v) {
		switch(v.getId()){
			case R.id.home_message_iv:
				//消息
				mViewPager.setCurrentItem(0);
				break;
			case R.id.home_contact_iv:
				//通讯录
				mViewPager.setCurrentItem(1);
				break;
			case R.id.home_cloudteam_iv:
				//云团队
				mViewPager.setCurrentItem(2);
				break;
			}
	}
}
