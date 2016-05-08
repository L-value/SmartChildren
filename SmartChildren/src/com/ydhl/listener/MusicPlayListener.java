package com.ydhl.listener;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

import com.ydhl.mylog.MyLog;
import com.ydhl.utils.MyHttpClient;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore.Audio.Media;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class MusicPlayListener implements OnItemClickListener
{

	private static final String URLPATH_STRING1 = "http://zcs.svnt.ml/rzet/RZET_(1).mp3";
	private static final String URLPATH_STRING2 = "http://zcs.svnt.ml/rzet/RZET_(2).mp3";
	private static final String URLPATH_STRING3 = "http://zcs.svnt.ml/rzet/RZET_(3).mp3";
	private static final String URLPATH_STRING4 = "http://zcs.svnt.ml/rzet/RZET_(4).mp3";
	private static final String URLPATH_STRING5 = "http://zcs.svnt.ml/rzet/RZET_(5).mp3";
	private static final String URLPATH_STRING6 = "http://zcs.svnt.ml/rzet/RZET_(6).mp3";
	private static final String URLPATH_STRING7 = "http://zcs.svnt.ml/rzet/RZET_(7).mp3";
	private static final String URLPATH_STRING8 = "http://zcs.svnt.ml/rzet/RZET_(8).mp3";
	private static final String URLPATH_STRING9 = "http://zcs.svnt.ml/rzet/RZET_(9).mp3";
	private static final String URLPATH_STRING10 = "http://zcs.svnt.ml/rzet/RZET_(10).mp3";
	private Context context;
	private boolean[] bos = new boolean[10];
	private MediaPlayer[] mediaPlayers = new MediaPlayer[]{
		new MediaPlayer(),new MediaPlayer(),new MediaPlayer(),
		new MediaPlayer(),new MediaPlayer(),new MediaPlayer(),
		new MediaPlayer(),new MediaPlayer(),
		new MediaPlayer(),new MediaPlayer(),
	};
	private MediaPlayer mmediaPlayer;

	public MusicPlayListener(Context context, MediaPlayer mediaPlayer)
	{
		this.context = context;
		mmediaPlayer = mediaPlayer;
		
		mediaPlayer.setOnCompletionListener(new OnCompletionListener()
		{

			@Override
			public void onCompletion(MediaPlayer mp)
			{
				mmediaPlayer.start();

			}
		});
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id)
	{
		mmediaPlayer.pause();
		switch (position)
		{
		case 0:
			try
			{
				mediaPlayers[0].setDataSource(URLPATH_STRING1);
				mediaPlayers[0].prepare();
			} catch (Exception e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (!bos[0])
			{
				for (int i = 0; i < 10; i++)
				{
					if (bos[i])
					{
						mediaPlayers[i].stop();
					}
				}
				bos[0] = true;
				mediaPlayers[0].start();
				
			} else
			{
				bos[0] = false;
				mediaPlayers[0].pause();
			}
			break;
		case 1:
			try
			{
				mediaPlayers[1].setDataSource(URLPATH_STRING2);
				mediaPlayers[1].prepare();
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (!bos[1])
			{
				for (int i = 0; i < 10; i++)
				{
					if (bos[i])
					{
						mediaPlayers[i].stop();
					}
				}
				bos[1] = true;
				mediaPlayers[1].start();
			} else
			{
				bos[1] = false;
				mediaPlayers[1].pause();
			}
			break;
		case 2:
			try
			{
				mediaPlayers[2].setDataSource(URLPATH_STRING3);
				mediaPlayers[2].prepare();
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (!bos[2])
			{
				for (int i = 0; i < 10; i++)
				{
					if (bos[i])
					{
						mediaPlayers[i].stop();
					}
				}
				bos[2] = true;
				mediaPlayers[2].start();
			} else
			{
				bos[2] = false;
				mediaPlayers[2].pause();
			}
			break;
		case 3:
			try
			{
				mediaPlayers[3].setDataSource(URLPATH_STRING4);
				mediaPlayers[3].prepare();
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (!bos[3])
			{
				for (int i = 0; i < 10; i++)
				{
					if (bos[i])
					{
						mediaPlayers[i].stop();
					}
				}
				bos[3] = true;
				mediaPlayers[3].start();
			} else
			{
				bos[3] = false;
				mediaPlayers[3].pause();
			}
			break;
		case 4:
			try
			{
				mediaPlayers[4].setDataSource(URLPATH_STRING5);
				mediaPlayers[4].prepare();
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (!bos[4])
			{
				for (int i = 0; i < 10; i++)
				{
					if (bos[i])
					{
						mediaPlayers[i].stop();
					}
				}
				bos[4] = true;
				mediaPlayers[4].start();
			} else
			{
				bos[4] = false;
				mediaPlayers[4].pause();
			}
			break;
		case 5:
			try
			{
				mediaPlayers[5].setDataSource(URLPATH_STRING6);
				mediaPlayers[5].prepare();
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (!bos[5])
			{
				for (int i = 0; i < 10; i++)
				{
					if (bos[i])
					{
						mediaPlayers[i].stop();
					}
				}
				bos[5] = true;
				mediaPlayers[5].start();
			} else
			{
				bos[5] = false;
				mediaPlayers[5].pause();
			}
			break;
		case 6:
			try
			{
				mediaPlayers[6].setDataSource(URLPATH_STRING7);
				mediaPlayers[6].prepare();
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (!bos[6])
			{
				for (int i = 0; i < 10; i++)
				{
					if (bos[i])
					{
						mediaPlayers[i].stop();
					}
				}
				bos[6] = true;
				mediaPlayers[6].start();
			} else
			{
				bos[6] = false;
				mediaPlayers[6].pause();
			}
			break;
		case 7:
			try
			{
				mediaPlayers[7].setDataSource(URLPATH_STRING8);
				mediaPlayers[7].prepare();
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (!bos[7])
			{
				for (int i = 0; i < 10; i++)
				{
					if (bos[i])
					{
						mediaPlayers[i].stop();
					}
				}
				bos[7] = true;
				mediaPlayers[7].start();
			} else
			{
				bos[7] = false;
				mediaPlayers[7].pause();
			}
			break;
		case 8:
			try
			{
				mediaPlayers[8].setDataSource(URLPATH_STRING9);
				mediaPlayers[8].prepare();
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (!bos[8])
			{
				for (int i = 0; i < 10; i++)
				{
					if (bos[i])
					{
						mediaPlayers[i].stop();
					}
				}
				bos[8] = true;
				mediaPlayers[8].start();
			} else
			{
				bos[8] = false;
				mediaPlayers[8].pause();
			}
			break;
		case 9:
			try
			{
				mediaPlayers[9].setDataSource(URLPATH_STRING10);
				mediaPlayers[9].prepare();
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (!bos[9])
			{
				for (int i = 0; i < 10; i++)
				{
					if (bos[i])
					{
						mediaPlayers[i].stop();
					}
				}
				bos[9] = true;
				mediaPlayers[9].start();
			} else
			{
				bos[9] = false;
				mediaPlayers[9].pause();
			}
			break;
			default:
			break;
		}
	}

}
