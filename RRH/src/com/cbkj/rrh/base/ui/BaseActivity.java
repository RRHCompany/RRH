package com.cbkj.rrh.base.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.widget.Toast;

public class BaseActivity extends Activity {
	private static Context context;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		context = this;
		setVolumeControlStream(AudioManager.STREAM_MUSIC);// 使得音量键控制媒体声音
	}

	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	protected void onStop() {
		super.onStop();
	}

	@Override
	protected void onRestart() {
		super.onRestart();
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
	@Override
	public void startActivity(Intent intent) {
		super.startActivity(intent);
	}

	public void startActivityForResult(Intent intent, int requestCode) {
		super.startActivityForResult(intent, requestCode);
	}

	@Override
	public void finish() {
		super.finish();
	}

	protected void showShortToast(String text) {
		Toast.makeText((Activity)context, text,Toast.LENGTH_SHORT).show();
	}

	protected void showShortToast(int resId) {
		Toast.makeText(this, resId,Toast.LENGTH_SHORT).show();
	}

}
