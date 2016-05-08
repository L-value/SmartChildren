package com.ydhl.bean;

public class LoginGetInfo
{
	private boolean result = true;
	private String message;
	private String start_time;
	private String end_time;
	private String time_long;

	public LoginGetInfo(boolean result, String message, String start_time,
			String end_time, String time_long)
	{
		super();
		this.result = result;
		this.message = message;
		this.start_time = start_time;
		this.end_time = end_time;
		this.time_long = time_long;
	}
	@Override
	public String toString()
	{
		return "LoginGetInfo [result=" + result + ", message=" + message
				+ ", start_time=" + start_time + ", end_time=" + end_time
				+ ", time_long=" + time_long + "]";
	}
	public LoginGetInfo()
	{
		// TODO Auto-generated constructor stub
	}
	public String getStart_time()
	{
		return start_time;
	}
	public void setStart_time(String start_time)
	{
		this.start_time = start_time;
	}
	public String getEnd_time()
	{
		return end_time;
	}
	public void setEnd_time(String end_time)
	{
		this.end_time = end_time;
	}
	public String getTime_long()
	{
		return time_long;
	}
	public void setTime_long(String time_long)
	{
		this.time_long = time_long;
	}
	public boolean isReslut()
	{
		return result;
	}
	public void setReslut(boolean reslut)
	{
		this.result = reslut;
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
