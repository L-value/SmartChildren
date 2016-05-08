package com.ydhl.utils;

import java.util.Random;

import com.example.smartchildren.R;

import android.R.integer;
import android.widget.Button;

public class ImageFactory
{
	private static int[] images1 = new int[] {
			R.drawable.consider_butterfly_01, R.drawable.consider_crocodile_01,
			R.drawable.consider_peacock_01, R.drawable.consider_deer_01 };
	private static int[] images2 = new int[] {
			R.drawable.consider_butterfly_02, R.drawable.consider_crocodile_02,
			R.drawable.consider_peacock_02, R.drawable.consider_deer_02 };
	private static int[] images3 = new int[] {
			R.drawable.consider_butterfly_03, R.drawable.consider_crocodile_03,
			R.drawable.consider_peacock_03, R.drawable.consider_deer_03 };
	private static int[] images4 = new int[] {
			R.drawable.consider_butterfly_04, R.drawable.consider_crocodile_04,
			R.drawable.consider_peacock_04, R.drawable.consider_deer_04 };
	private static int[] images5 = new int[] { R.drawable.consider_butterfly,
			R.drawable.consider_crocodile, R.drawable.consider_peacock,
			R.drawable.consider_deer };
	private static int[] animalSound = new int[] { R.raw.cat, R.raw.cheetah,
			R.raw.chicken, R.raw.cow };
	private static int location[] = new int[4];
	private static Random random = new Random();
	private static int which = 0;
	private static void makeImage(int[] imageGet1, int[] imageGet2,
			int[] imageGet3, int[] imageGet4,int[] imageGet5,
			Button considerb1,Button considerb2,Button considerb3,
			Button considerb4,Button considerb5,Button consider11,
			Button consider22,Button consider33,Button consider44)
	{
		for (int i = 0; i < 4; i++)
		{
			location[i] = random.nextInt(4);
			check(i);
		}
		imageGet1 = new int[] { images1[location[1]], images1[location[0]],
				images1[location[2]], images1[location[3]], };
		imageGet2 = new int[] { images2[location[2]], images2[location[0]],
				images2[location[1]], images2[location[3]], };
		imageGet3 = new int[] { images3[location[3]], images3[location[0]],
				images3[location[1]], images3[location[2]], };
		imageGet4 = new int[] { images4[location[2]], images4[location[1]],
				images4[location[0]], images4[location[3]], };
		considerb1.setBackgroundResource(imageGet1[0]);
		consider11.setBackgroundResource(imageGet1[1]);
		considerb2.setBackgroundResource(imageGet2[0]);
		consider22.setBackgroundResource(imageGet2[1]);
		considerb3.setBackgroundResource(imageGet3[0]);
		consider33.setBackgroundResource(imageGet3[1]);
		considerb4.setBackgroundResource(imageGet4[0]);
		consider44.setBackgroundResource(imageGet4[1]);
		considerb5.setBackgroundResource(images5[which]);
	}

	private static void check(int i)
	{
		for (int j = 0; j < i; j++)
		{
			if (location[i] == location[j])
			{
				location[i] = random.nextInt(4);
				check(i);
			}
		}
		
	}
}
