package com.ydhl.bean;

import com.example.smartchildren.R.string;

public class LoginInfo
{
	private String userName;
	private String passWord;
	public LoginInfo()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginInfo(String userName, String passWord)
	{
		super();
		this.userName = userName;
		this.passWord = passWord;
	}
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public String getPassWord()
	{
		return passWord;
	}
	public void setPassWord(String passWord)
	{
		this.passWord = passWord;
	}

}
