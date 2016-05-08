package com.ydhl.bean;

public class RegisterInfo
{
@Override
	public String toString()
	{
		return "RegisterInfo [result=" + result + ", message=" + message + "]";
	}
	/*
 * "result":"false","message":
 * "The parents have binding without repeat binding",
 * "start_time":"1","end_time":"2","time_long":"1
 */
	private boolean result;
	private String message;
	public RegisterInfo()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	public RegisterInfo(boolean result, String message, String start_time,
			String end_time, String time_long)
	{
		super();
		this.setResult(result);
		this.setMessage(message);
	}
	public boolean isResult()
	{
		return result;
	}
	public void setResult(boolean result)
	{
		this.result = result;
	}
	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}

}
