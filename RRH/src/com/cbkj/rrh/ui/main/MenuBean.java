package com.cbkj.rrh.ui.main;
/**
 * 导航菜单
 * */
public class MenuBean {

	private String name;
	
	private int imageRes;
	

	public MenuBean(String name, int imageRes) {
		super();
		this.name = name;
		this.imageRes = imageRes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getImageRes() {
		return imageRes;
	}

	public void setImageRes(int imageRes) {
		this.imageRes = imageRes;
	}
}
