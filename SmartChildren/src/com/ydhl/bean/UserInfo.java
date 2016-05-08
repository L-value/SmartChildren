package com.ydhl.bean;


public class UserInfo
{
	private String userName;
	private String passWord;
	private String sex;
	private int age;
	private String tel;
	private String lead;

	public UserInfo(String userName, String passWord, String sex, int age,
			String tel,String lead)
	{
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.setSex(sex);
		this.setAge(age);
		this.setTel(tel);
		this.setLead(lead);
	}
	public UserInfo() {
		// TODO Auto-generated constructor stub
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
	public String getSex()
	{
		return sex;
	}
	public void setSex(String sex)
	{
		this.sex = sex;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public String getTel()
	{
		return tel;
	}
	public void setTel(String tel)
	{
		this.tel = tel;
	}

	@Override
	public String toString()
	{
		return "UserInfo [userName=" + userName + ", passWord=" + passWord
				+ ", sex=" + sex + ", age=" + age + ", tel=" + tel + ", lead="
				+ lead + "]";
	}
	public String getLead()
	{
		return lead;
	}
	public void setLead(String lead)
	{
		this.lead = lead;
	}
	
}
