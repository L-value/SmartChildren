package com.ydhl.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBManager
{
	private MyDataBaseHelper myDataBaseHelper;
	private SQLiteDatabase sqLiteDatabase;

	public DBManager(Context context,String tableName)
	{
		myDataBaseHelper = new MyDataBaseHelper(context,tableName);
		sqLiteDatabase = myDataBaseHelper.getWritableDatabase();
	}
	
	public void createTable(String tableName){
		sqLiteDatabase.execSQL(	"create table "+ tableName +"(_id varchar(20) primary key,"
				+ "high integer default 0,"
				+ "low integer default 0)");
	}
	public void execSQL(String sql)
	{
		sqLiteDatabase.execSQL(sql);
	}
	public boolean insert(String table, String nullColumnHack,
			ContentValues values)
	{
		boolean flag = false;
		long count = sqLiteDatabase.insert(table, nullColumnHack, values);
		flag = count > 0 ? true : false;
		return flag;
	}

	public Cursor query(String table, String[] columns, String selection,
			String[] selectionArgs, String groupBy, String having,
			String orderBy, String limit)
	{
		Cursor cursor = null;
		cursor = sqLiteDatabase.query(table, columns, selection, selectionArgs,
				groupBy, having, orderBy);
		return cursor;
	}
	public void upData(String table, ContentValues values, String whereClause, String[] whereArgs)
	{
		sqLiteDatabase.update(table, values, whereClause, whereArgs);
	}
	public void conn()
	{
		if (sqLiteDatabase != null)
		{
			sqLiteDatabase.close();
		}
	}
}
