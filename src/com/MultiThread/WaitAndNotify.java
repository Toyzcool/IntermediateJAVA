package com.MultiThread;
/*
 * 线程间的交互
 * 实现要求：掉血速度大于回血，当掉血到1时，暂停掉血，启动回血后，再启动掉血
 */
public class WaitAndNotify {

	public static void main(String[] args) {
		//新建英雄对象
		Hero hero = new Hero("盖伦",200);
		//掉血线程
		Thread t1 = new Thread() {
			public void run() {
				//无限循环掉血
				while(true) {
					hero.hurtWait();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		t1.start();
		
		//回血线程
		Thread t2 = new Thread() {
			public void run() {
				while(true) {
					hero.recoverNotify();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		t2.start();
	}

}
