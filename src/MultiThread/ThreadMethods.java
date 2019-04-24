package MultiThread;
/*
 * 多线程的各种方法
 */
public class ThreadMethods {

	public static void main(String[] args) {
		//新建英雄对象
		Hero gailun = new Hero("gailun",500,90);
		Hero vn = new Hero("vn",450,70);
		Hero ez = new Hero("ez",420,80);
		Hero jinx = new Hero("jinx",400,80);
		Hero test1 = new Hero("test1",420,80);
		Hero test2 = new Hero("test2",400,80);
		
		/*
		 * 线程暂停的方法
		 * 涉及变量（t1）
		 */
		Thread t1 = new Thread() {
			public void run() {
				int time = 0;
				while(true) {
					try {
						//暂停一秒
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.printf("你已经玩游戏 %d 秒了 %n",time++);
				}
			}
		};
		t1.start();
		
		/*
		 * 加入线程的方法
		 * t2和t3同时运行，此时t2使用join()方法，主线程进入等待池，等t2完成后，t4才执行
		 * 涉及变量（t2\t3\t4）
		 */
		//定义线程和匿名方法
		Thread t2 = new Thread() {
			public void run() {
				while(!vn.isDead()) {
					gailun.attackHero(vn);
				}
			}
		};
		Thread t3 = new Thread() {
			public void run() {
				while(!jinx.isDead()) {
					ez.attackHero(jinx);
				}
			}
		};
		
		//同时启动t2和t3，使其并行
		t2.start();
		t3.start();
		
		//代码执行到这里，一直是main线程在运行
		try {
			//主线程进入等待池，t3不受影响，依旧运行
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//证明主线程进入等待池,t4将在t2完成后，才能运行
		Thread t4 = new Thread() {
			public void run() {
				while(!test2.isDead()) {
					test1.attackHero(test2);
				}
			}
		};
		t4.start();
		
		/*
		 * 线程优先级
		 * 涉及变量（t5\t6）
		 */
		Thread t5 = new Thread() {
			public void run() {
				while(!vn.isDead()) {
					gailun.attackHero(vn);
				}
			}
		};
		Thread t6 = new Thread() {
			public void run() {
				while(!jinx.isDead()) {
					ez.attackHero(jinx);
				}
			}
		};
		t5.setPriority(Thread.MAX_PRIORITY);
		t6.setPriority(Thread.MIN_PRIORITY);
		t5.start();
		t6.start();
		
		/*
		 * 临时暂停
		 * 涉及变量（t7\t8）
		 */
		Thread t7 = new Thread() {
			public void run() {
				while(!vn.isDead()) {
					gailun.attackHero(vn);
				}
			}
		};
		Thread t8 = new Thread() {
			public void run() {
				while(!jinx.isDead()) {
					//暂停，但是可能无效，因为让步线程依旧可能被程序选中执行
					Thread.yield();
					ez.attackHero(jinx);
				}
			}
		};
		t7.setPriority(5);
		t8.setPriority(5);
		t7.start();
		t8.start();
		
		/*
		 * 守护线程
		 * 当仅剩下守护线程时，程序终止。经常用于日志和性能统计工作
		 * 涉及变量(threadDaemon\t9)
		 */
		
		//守护线程，用于计算程序运行时间
		Thread threadDaemon = new Thread() {
			public void run() {
			int time = 0;
			while(true) {
				try {
					//暂停一秒
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.printf("你已经玩游戏 %d 秒了 %n",time++);
			}
		}
		};
		threadDaemon.setDaemon(true);
		threadDaemon.start();
		//主要进程
		Thread t9 = new Thread() {
			public void run() {
				while(!vn.isDead()) {
					gailun.attackHero(vn);
				}
			}
		};
		t9.start();
		
	}

}
