package com.MultiThread;

/*
 * Concurrency 问题使用synchronized()方法解决——Hero.java中的hurt()和recover()方法
 */
public class Synchronized {

	public static void main(String[] args) {
		
		//新建英雄对象
		Hero hero = new Hero("VN",10000);
		System.out.printf("英雄VN初始血量为：%.0f %n",hero.hp);
		
		//新建1000个hurt()线程和1000个recover()线程
		int n = 10000;
		Thread[] tHurt = new Thread[n];
		Thread[] tRecover = new Thread[n];
		
		//循环建立10000个hurt()方法，使用方法时锁住对象
		for(int i = 0 ; i < n ; i ++ ) {
			Thread t = new Thread() {
				public void run() {
						hero.hurt();
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
			};
			t.start();
			tHurt[i] = t;
		}
		
		//循环建立10000个recover()方法，使用方法时锁住对象
		for(int i = 0 ; i < n ; i++ ) {
			Thread t = new Thread() {
				//可以将synchronized关键词写到recover()方法名称中！！！
				public void run() {
						hero.recover();
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
					}
				}
			};
			t.start();
			tRecover[i] = t;
		}
		
		//等待线程全部完成
		for (Thread t : tHurt) {
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (Thread t : tRecover) {
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//打印最后血量
		System.out.printf("最终血量为：%.0f",hero.hp);
	}

}
