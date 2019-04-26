package MultiThread;
/*
 * 线程交互
 * 类似于synchronized中的wait()和notify()方法
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadInteraction {
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
		//通过lock对象获得condition对象，以后调用condition方法的await和signal方法
		Condition condition = lock.newCondition();
		
		//新建线程1
		Thread t1 = new Thread() {
			public void run() {
				try {
					log("启动");
					log("试图占用");
					lock.lock();
					log("占用对象5秒");
					Thread.sleep(5000);
					log("短暂释放lock对象");
					//短暂释放lock对象，等待通知
					condition.await();
					//再此占用后再占用对象5秒
					log("重新占用对象,并再次占用5秒");
					lock.lock();
					Thread.sleep(5000);
				} catch (Exception e) {
					// TODO: handle exception
				}finally {
					log("占用结束");
					lock.unlock();
				}
			}
		};
		t1.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//新建线程2
		Thread t2 = new Thread() {
			public void run() {
				try {
					log("启动");
					log("试图占用对象");
					lock.lock();
					log("占用对象5秒");
					Thread.sleep(5000);
					//占用完成后通知其他线程可继续
					condition.signal();
				} catch (Exception e) {
					// TODO: handle exception
				}finally {
					log("占用结束");
					lock.unlock();
				}
			}
		};
		t2.start();
	}

}
