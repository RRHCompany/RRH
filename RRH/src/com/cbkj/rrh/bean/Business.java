package com.cbkj.rrh.bean;
/**
 * 企业
 * */
public class Business {

	private int businessId;
	
	private String name;

	public Business(int businessId, String name) {
		super();
		this.businessId = businessId;
		this.name = name;
	}

	public int getBusinessId() {
		return businessId;
	}

	public void setBusinessId(int businessId) {
		this.businessId = businessId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
