package MultiThread;
/*
 * 创建英雄和英雄动作
 */
public class Hero {
	public String name;
	public float hp;
	//定义英雄攻击力
	public int damage;
	
	public Hero(String name, float hp, int damage) {
		super();
		this.name = name;
		this.hp = hp;
		this.damage = damage;
	}
	public Hero(String name, float hp) {
		super();
		this.name = name;
		this.hp = hp;
	}
	
	//新建英雄攻击方法
	public void attackHero(Hero h) {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		//攻击后剩余血量
		h.hp -= damage;
		System.out.println(name+"正在攻击"+h.name+","+h.name+"的血量为："+h.hp);
		//判断是否死亡
		if(h.isDead()) {
			System.out.println(h.name+"阵亡");
		}
	}
	//新建英雄死亡判断方法
	public boolean isDead() {
		return 0 >= hp?true:false;
	}
	
	//新建英雄伤害方法——Synchronized.java
	public synchronized void hurt() {
		this.hp -= 1 ;
	}
	//新建英雄回血方法——Synchronized.java
	public synchronized void recover() {
		this.hp += 1 ;
	}
	
	//新建英雄掉血方法，需要暂停占用——WaitAndNotify.java
	public synchronized void hurtWait() {
		//当血量为1时，暂停占用掉血方法
		if(hp == 1) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		hp -= 1;
		System.out.println("掉血，目前血量："+hp);
	}
	
	//新建英雄回血方法，回血后通知其他进程已回血完毕——WaitAndNotify.java
	public synchronized void recoverNotify() {
		hp += 1;
		this.notify();
		System.out.println("回血，目前血量："+hp);
	}
}








