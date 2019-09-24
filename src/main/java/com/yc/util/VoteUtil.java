package com.yc.util;

import java.util.Random;

public class VoteUtil {
	public static String genVid() {
		return ""+System.currentTimeMillis()+new Random().nextInt(1000);
	}

}
