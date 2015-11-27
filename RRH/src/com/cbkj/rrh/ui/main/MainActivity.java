package com.cbkj.rrh.ui.main;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.cbkj.rrh.R;
import com.cbkj.rrh.base.adapter.AbstractBaseAdapter;
import com.cbkj.rrh.comment.utils.ViewUtils;
import com.cbkj.rrh.ui.home.HomeFragment;
import com.cbkj.rrh.ui.more.MoreActivity;

/**
 * 主页面
 * 
 * @author jason
 * @data 2015-1124
 * */
public class MainActivity extends FragmentActivity implements
		OnItemClickListener, MenuListener, OnClickListener {

	private DrawerLayout drawerLayout;
	private View menuLayout;
	private ListView menuListview;
	private List<MenuBean> menuData = new ArrayList<MenuBean>();
	private AbstractBaseAdapter<MenuBean> menuAdapter;
	private ActionBarDrawerToggle mDrawerToggle;
	private Button settingButton, msgButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.a_main);
		this.initView();
		this.initListener();
		menuData.add(new MenuBean("上到", R.drawable.menu_icon1));
		this.onItemClick(null, null, 0, 0);
	}

	private void initView() {
		drawerLayout = (DrawerLayout) findViewById(R.id.root_drawerlayout);
		menuLayout = findViewById(R.id.main_menu_layout);

		menuListview = (ListView) findViewById(R.id.main_menu_listview);
		menuListview.addHeaderView(ViewUtils.getView(this,
				R.layout.a_main_menu_header));
		menuAdapter = new MainMenuAdapter(this, menuData);
		menuListview.setAdapter(menuAdapter);

		settingButton = (Button) findViewById(R.id.main_menu_setting_btn);
		msgButton = (Button) findViewById(R.id.main_menu_msg_btn);
	}

	private void initListener() {
		menuListview.setOnItemClickListener(this);
		// 监听DrawerLayout的打开和关闭事件
		mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
				R.drawable.ic_launcher, R.string.app_name, R.string.app_name) {
			@Override
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				// 侧边栏打开
			}

			@Override
			public void onDrawerClosed(View drawerView) {
				super.onDrawerClosed(drawerView);
				// 侧边栏关闭
			}
		};
		drawerLayout.setDrawerListener(mDrawerToggle);
		settingButton.setOnClickListener(this);
		msgButton.setOnClickListener(this);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void openDrawer() {
		drawerLayout.openDrawer(menuLayout);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Toast.makeText(this, "你选择的是:" + position, Toast.LENGTH_SHORT).show();
		switch (position) {
		case 0:
			// 首页
			HomeFragment homeFragment = new HomeFragment(this);
			Bundle bundle = new Bundle();
			bundle.putString("fragmentdata", "标题");
			homeFragment.setArguments(bundle);
			this.changeFragment(homeFragment, view == null);
			break;
		}
		drawerLayout.closeDrawer(menuLayout);
	}

	private void changeFragment(Fragment fragment, boolean init) {
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		ft.replace(R.id.main_contant, fragment);
		if (!init) {
			ft.addToBackStack(null);
		}
		ft.commit();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.main_menu_setting_btn:
			//设置
			Intent intent=new Intent(this,MoreActivity.class);
			this.startActivity(intent);
			break;
		case R.id.main_menu_msg_btn:
			break;
		}
	}
}
