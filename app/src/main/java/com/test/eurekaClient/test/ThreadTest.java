package com.test.eurekaClient.test;

import java.util.concurrent.TimeUnit;

public class ThreadTest {

	private static boolean runOpenIng = true;// 如果没有volatile
														// 那么会造成共享内存不可见

	public static void main(String[] args) {
		/*
		 * System.out.println (new StringBuilder ().append ("Byte-->>").append
		 * ("字节数：").append (Byte.BYTES).append (";位数："). append
		 * (Byte.SIZE).append ("; 最小值-->最大值:").append (Byte.MIN_VALUE).append
		 * ("-->").append (Byte.MAX_VALUE)); System.out.println (new
		 * StringBuilder ().append ("Short-->>").append ("字节数：").append
		 * (Short.BYTES).append (";位数："). append (Short.SIZE).append
		 * ("; 最小值-->最大值:").append (Short.MIN_VALUE).append ("-->").append
		 * (Short.MAX_VALUE)); System.out.println (new StringBuilder ().append
		 * ("Integer-->>").append ("字节数：").append (Integer.BYTES).append
		 * (";位数："). append (Integer.SIZE).append ("; 最小值-->最大值:").append
		 * (Integer.MIN_VALUE).append ("-->").append (Integer.MAX_VALUE));
		 * System.out.println (new StringBuilder ().append ("Long-->>").append
		 * ("字节数：").append (Long.BYTES).append (";位数："). append
		 * (Long.SIZE).append ("; 最小值-->最大值:").append (Long.MIN_VALUE).append
		 * ("-->").append (Long.MAX_VALUE)); System.out.println (new
		 * StringBuilder ().append ("Float-->>").append ("字节数：").append
		 * (Float.BYTES).append (";位数："). append (Float.SIZE).append
		 * ("; 最小值-->最大值:").append (Float.MIN_VALUE).append ("-->").append
		 * (Float.MAX_VALUE)); System.out.println (new StringBuilder ().append
		 * ("Double-->>").append ("字节数：").append (Double.BYTES).append (";位数：").
		 * append (Double.SIZE).append ("; 最小值-->最大值:").append
		 * (Double.MIN_VALUE).append ("-->").append (Double.MAX_VALUE));
		 * System.out.println (new StringBuilder ().append
		 * ("Character-->>").append ("字节数：").append (Character.BYTES).append
		 * (";位数："). append (Character.SIZE).append ("; 最小值-->最大值:").append
		 * ((int)Character.MIN_VALUE).append ("-->").append
		 * ((int)Character.MAX_VALUE));
		 */

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (runOpenIng) {
					// System.out.println("))))))"+runOpenIng);//如果打印输出，即使是空的输出也不会一直运行下去
					int i = 1 + 1;// 即使有也会一直运行
				}
			}
		}).start();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		synchronized (ThreadTest.class) {
			try {
				ThreadTest.class.wait(5);// 特定时间 到期自己唤醒 如果没有时间，那么需要被唤醒
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			runOpenIng = false;
			System.out.println(runOpenIng);
		}
	}
}
