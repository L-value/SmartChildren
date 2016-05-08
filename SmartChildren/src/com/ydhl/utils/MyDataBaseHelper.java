package com.ydhl.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDataBaseHelper extends SQLiteOpenHelper
{
	private final static int DATABASE_VERSION = 1;
	private String tableName;
	private final String CREATE_TABLE_SQL;
	public MyDataBaseHelper(Context context,String tableName) {
	    super(context, "hyyyy", null, DATABASE_VERSION);
	    this.tableName = tableName;
	    CREATE_TABLE_SQL = 
				"create table "+ tableName +"(_id varchar(20) primary key,"
				+ "high integer default 0,"
				+ "low integer default 0)";
	  }
	public MyDataBaseHelper(Context context, String name,
			CursorFactory factory, int version)
	{
		super(context, name, factory, version);
		CREATE_TABLE_SQL = 
				"create table "+ tableName +"(_id varchar(20) primary key,"
				+ "high integer default 0,"
				+ "low integer default 0)";
	}

	
	@Override
	public void onCreate(SQLiteDatabase db)
	{
		db.execSQL(CREATE_TABLE_SQL);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		// TODO Auto-generated method stub

	}

}
