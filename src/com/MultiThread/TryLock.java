package com.MultiThread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLock {
	
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
		
		//新建线程1
		Thread t1 = new Thread() {
			public void run() {
				//新建用于保存lock是否被锁的状态变量
				boolean locked = false;

				//获取锁的状态
				try {
					log("启动");
					log("试图占用");
					//试图占用，尝试1秒
					locked = lock.tryLock(1, TimeUnit.SECONDS);
					//如果locked为真，则占用成功
					if(locked) {
						log("占用成功");
						lock.lock();
						Thread.sleep(5000);
					}else {
						log("占用失败");
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					if(locked) {
					log("释放");
					lock.unlock();
					}
				}
			}
		};
		t1.start();
		
//		//让t1先运行2秒
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		//新建线程2
		Thread t2 = new Thread() {
			public void run() {
				boolean locked = false;
				try {
					log("启动");
					log("试图占用");
					locked = lock.tryLock(1,TimeUnit.SECONDS);
					if(locked) {
						log("占用成功");
						lock.lock();
						Thread.sleep(5000);
					}else {
						log("占用失败");
					}
				} catch (Exception e) {
					// TODO: handle exception
				}finally {
					if(locked) {
						log("释放");
						lock.unlock();
					}
				}
			}
		};
		t2.start();
	
	}

}
