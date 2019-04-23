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
}
