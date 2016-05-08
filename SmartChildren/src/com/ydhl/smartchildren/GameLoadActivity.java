package com.ydhl.smartchildren;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.smartchildren.R;
import com.ydhl.common.BaseActivity;
import com.ydhl.utils.MyHttpClient;

public class GameLoadActivity extends BaseActivity implements OnClickListener
{

	private static final String SD_ROOT_PATH =  Environment.getExternalStorageDirectory().
			getAbsolutePath().toString();
	private ImageView imageView1;
	ProgressDialog progressDialog;
	private Handler handler = new Handler(){
		       public void handleMessage(android.os.Message msg) {
			    if (msg.what == 2)
				{
			    	Intent intent = new Intent();
		            intent.setAction("android.intent.action.VIEW");
		            intent.setDataAndType(Uri.fromFile(new File(SD_ROOT_PATH+"/"+"2048.apk"))
		            		,"application/vnd.android.package-archive");
		            GameLoadActivity.this.startActivity(intent);
				}
		};
	};
	@Override
	public void setContentView()
	{
		setContentView(R.layout.activity_game_load);
		imageView1 = (ImageView) findViewById(R.id.imageView1);
	}

	@Override
	public void initView()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initListeners()
	{
		imageView1.setOnClickListener(this);
		
	}

	@Override
	public void initData()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClick(View v)
	{
		MyTask myTask = new MyTask();
		myTask.execute("http://zcs.svnt.ml/rzet/Download.php");
		
	}
	
	public void loadApk(String path){
		File file = new File(SD_ROOT_PATH+"/"+"2048.apk");
		if (!file.exists())
		{
			HttpClient httpClient = MyHttpClient.getInstatnce();
			HttpPost httpPost = new HttpPost(path);
			NameValuePair nameValuePair = new BasicNameValuePair("apk_name","2048.apk");
			ArrayList<NameValuePair> nameValuePairs = new ArrayList<>();
			nameValuePairs.add(nameValuePair);
			try
			{
				UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(nameValuePairs);
				httpPost.setEntity(urlEncodedFormEntity);
				HttpResponse response = httpClient.execute(httpPost);
				if (response.getStatusLine().getStatusCode() == 200)
				{
					
					InputStream inputStream = response.getEntity().getContent();
					FileOutputStream os = new FileOutputStream(SD_ROOT_PATH+"/"+"2048.apk");
					int len = 0;
					byte[] buffer = new byte[1024];
					while ((len = inputStream.read(buffer))!=-1)
					{
						os.write(buffer,0,len);
					}
					os.close();
					inputStream.close();
				}
			} catch (Exception e)
			{
				Toast.makeText(GameLoadActivity.this, "œ¬‘ÿ ß∞‹...", 1000).show();
				e.printStackTrace();
			}
		}

		
	}
	private class MyTask extends AsyncTask<String, Integer, String>{

		@Override
		protected String doInBackground(String... params)
		{
			loadApk(params[0]);
			this.publishProgress();
			return null;
		}
		@Override
		protected void onPostExecute(String result)
		{
			handler.sendEmptyMessage(2);
			super.onPostExecute(result);
		}
		 
		@Override
		protected void onProgressUpdate(Integer... values)
		{
			super.onProgressUpdate(values);
		}
	}
}
