package com.cbkj.rrh.bean;

import java.io.Serializable;


/**
 * 群组
 */
public class Group implements Serializable {

	private static final long serialVersionUID = 1L;

	private int groupId;//群组编号
    
    private String groupName;//名称
    
    private int type;//性别  0:男  1:女
    
    private String portrait;//头像
    
	public Group(int groupId, String groupName, int type) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.type = type;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}
	
}
