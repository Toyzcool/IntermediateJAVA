package MultiThread;

public class TestThread {

	public static void main(String[] args) {
		
		//新建英雄对象
		Hero gailun = new Hero("gailun",500,90);
		Hero vn = new Hero("vn",450,70);
		Hero ez = new Hero("ez",420,80);
		Hero jinx = new Hero("jinx",400,80);
		
		/*
		 * 使用单线程攻击方法
		 */
//		System.out.println("-----以下为单线程攻击方法------");
//		while(!vn.isDead()){
//			gailun.attackHero(vn);
//		}
//		while(!jinx.isDead()) {
//			ez.attackHero(jinx);
//		}
		
		/*
		 * 多线程攻击方法一,继承Thread类——KillThread.java
		 */
		System.out.println("-----以下为多线程 攻击方法一-----");
		KillThread kt1 = new KillThread(gailun, vn);
		kt1.start();
		KillThread kt2 = new KillThread(ez, jinx);
		kt2.start();
		
		/*
		 * 多线程攻击方法二，使用Runnable接口——Battle.java
		 */
		System.out.println("-----以下为多线程 攻击方法二-----");
		Battle b1 = new Battle(gailun,vn);
		new Thread(b1).start();
		Battle b2 = new Battle(ez,jinx);
		new Thread(b2).start();
		
		/*
		 * 多线程攻击方法三，使用匿名类
		 */
		System.out.println("-----以下为多线程 攻击方法三-----");
		Thread t1 = new Thread() {
			public void run() {
				while(!vn.isDead()) {
					gailun.attackHero(vn);
				}
			}
		};
		t1.start();
		Thread t2 = new Thread() {
			public void run() {
				while(!jinx.isDead()) {
					ez.attackHero(jinx);
				}
			}
		};
		t2.start();
	}
}
