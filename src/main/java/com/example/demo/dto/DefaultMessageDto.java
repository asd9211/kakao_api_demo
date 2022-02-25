package com.example.demo.dto;


public class DefaultMessageDto {
	private String objType;
	private String text;
	private String webUrl;
	private String mobileUrl;
	private String btnTitle;
	public String getObjType() {
		return objType;
	}
	public void setObjType(String objType) {
		this.objType = objType;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getWebUrl() {
		return webUrl;
	}
	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}
	public String getMobileUrl() {
		return mobileUrl;
	}
	public void setMobileUrl(String mobileUrl) {
		this.mobileUrl = mobileUrl;
	}
	public String getBtnTitle() {
		return btnTitle;
	}
	public void setBtnTitle(String btnTitle) {
		this.btnTitle = btnTitle;
	}
}
