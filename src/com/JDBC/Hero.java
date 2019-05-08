package com.JDBC;

public class Hero {
	public Hero(int id, String name, float hp, int damage) {
		super();
		this.id = id;
		this.name = name;
		this.hp = hp;
		this.damage = damage;
	}
	public Hero(String name, float hp, int damage) {
		this.name = name;
		this.hp = hp;
		this.damage = damage;
	}
	public Hero() {
		
	}
	public int id;
	public String name;
	public float hp;
	public int damage;
}
