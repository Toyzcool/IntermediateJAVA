package com.MultiThread;
/*
 * lock和trylock进行线程占用
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
	
	//获取时间方法 
	public static String now() {
	        return new SimpleDateFormat("HH:mm:ss").format(new Date());
	    }
	
	 //输出日志方法
	public static void log(String msg) {
	        System.out.printf("%s %s %s %n", now() , Thread.currentThread().getName() , msg);
	    }
	    
	public static void main(String[] args) {
		//新建Lock对象
		Lock lock = new ReentrantLock();
		
		//新建线程一
		Thread t1 = new Thread() {
			public void run() {
				try {
					log("线程启动");
					log("试图占用");
					//占用锁住对象
					lock.lock();
					log("占用成功");
					log("进行5秒业务操作");
					Thread.sleep(5000);
				}catch (Exception e) {
					e.printStackTrace();
				} finally {
					log("释放");
					//释放对象
					lock.unlock();
				}

			}
		};
		//启动线程
		t1.start();
		
		try {
			//让t1线程先运行2秒
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//新建t2线程
		Thread t2 = new Thread() {
			public void run() {
				try {
					log("线程启动");
					log("试图占用");
					
					//占用锁住对象
					lock.lock();
					log("占用成功");
					log("进行5秒业务操作");
					Thread.sleep(5000);
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					log("释放");
					//释放对象
					lock.unlock();
				}
			}
		};
		t2.start();
	}

}
