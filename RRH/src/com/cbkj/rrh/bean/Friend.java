package com.cbkj.rrh.bean;

import java.io.Serializable;

import android.text.TextUtils;

import com.cbkj.rrh.comment.utils.PinyinHelper;


/**
 * 好友
 */
public class Friend implements Serializable {

	private static final long serialVersionUID = 1L;

	private int userId;//用户编号
    
    private String nickName;//昵称
    
    private int gender;//性别  0:男  1:女
    
    private String portrait;//头像
    
    private int portraitResId;//头像资源文件
    
    private String nickNamePinyin;//昵称拼音
    
    private String relation;//关系
    
    private char searchKey;
    
    public Friend(){
    	
    }

    public Friend(int userId, String nickName, String portrait) {
        this.userId = userId;
        this.nickName = nickName;
        this.portrait = portrait;
        createSeachKey(nickName);
    }
    
    public Friend(int userId, String nickName, int portraitResId) {
        this.userId = userId;
        this.nickName = nickName;
        this.portraitResId = portraitResId;
        createSeachKey(nickName);
    }
    private final void createSeachKey(String nickName) {
        if (TextUtils.isEmpty(nickName)) {
            return;
        }
        nickNamePinyin = PinyinHelper.getInstance().getPinyins(nickName, "");
        if (nickNamePinyin != null && nickNamePinyin.length() > 0) {
            char key = nickNamePinyin.charAt(0);
            if (key >= 'A' && key <= 'Z') {
            } else if (key >= 'a' && key <= 'z') {
                key -= 32;
            } else if (key == '★' ) {
                key = '★';
            }else {
                key = '#';
            }
            searchKey = key;
        } else {
            searchKey = '#';
        }
    }

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
		createSeachKey(nickName);
	}

	public String getNickNamePinyin() {
		return nickNamePinyin;
	}

	public void setNickNamePinyin(String nickNamePinyin) {
		this.nickNamePinyin = nickNamePinyin;
	}

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	public char getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(char searchKey) {
		this.searchKey = searchKey;
	}

	public int getPortraitResId() {
		return portraitResId;
	}

	public void setPortraitResId(int portraitResId) {
		this.portraitResId = portraitResId;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}
}
