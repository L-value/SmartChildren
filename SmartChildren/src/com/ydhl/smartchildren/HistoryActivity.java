package com.ydhl.smartchildren;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.smartchildren.R;
import com.example.smartchildren.R.drawable;
import com.example.smartchildren.R.id;
import com.example.smartchildren.R.layout;
import com.ydhl.common.BaseActivity;
import com.ydhl.utils.DBManager;

public class HistoryActivity extends BaseActivity
{

	private ListView listView;
	private ListView listView2;
	private ArrayList<Map<String, String>> arrayList;
	private DBManager dbManager;
	private int images[] = new int[] { R.drawable.imagebutton_calculate,
			R.drawable.imagebutton_consider, R.drawable.imagebutton_memory,
			R.drawable.imagebutton_way, R.drawable.imagebutton_word };
	private SimpleCursorAdapter simpleCursorAdapter;

	@Override
	public void setContentView()
	{
		setContentView(R.layout.activity_history);
		listView = (ListView) findViewById(R.id.historylist);
		listView2 = (ListView) findViewById(R.id.iconlist);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void initView()
	{
		dbManager = new DBManager(this,application.getUserName());
		Cursor cursor = dbManager.query(application.getUserName(), null, null, null, null,
				null, null, null);
		simpleCursorAdapter = new SimpleCursorAdapter(this, R.layout.history,
				cursor, new String[] { "_id", "high", "low" }, new int[] {
						R.id.title, R.id.hight, R.id.low });
		Map<String, Object> data = new HashMap<>();
		data.put("game", images[0]);
		Map<String, Object> data1 = new HashMap<>();
		data1.put("game", images[1]);
		Map<String, Object> data2 = new HashMap<>();
		data2.put("game", images[2]);
		Map<String, Object> data3 = new HashMap<>();
		data3.put("game", images[3]);
		Map<String, Object> data4 = new HashMap<>();
		data4.put("game", images[4]);
		ArrayList<Map<String, Object>> arrayList = new ArrayList<>();
		arrayList.add(data);
		arrayList.add(data1);
		arrayList.add(data2);
		arrayList.add(data3);
		arrayList.add(data4);
		SimpleAdapter simpleAdapter = new SimpleAdapter(this, arrayList,
				R.layout.icon, new String[] { "game"
				}, new int[] { R.id.game });
		listView2.setAdapter(simpleAdapter);
		listView.setAdapter(simpleCursorAdapter);
	}

	@Override
	public void initListeners()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void initData()
	{
		// TODO Auto-generated method stub

	}

}
