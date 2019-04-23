package MultiThread;

public class Battle implements Runnable {
	
	private Hero h1;
	private Hero h2;
	
	
	public Battle(Hero h1, Hero h2) {
		super();
		this.h1 = h1;
		this.h2 = h2;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!h2.isDead()) {
			h1.attackHero(h2);
		}
	}

}
