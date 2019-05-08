package com.File;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Hero implements Serializable {
	public String name;
	public int hp;
	public Hero(String name, int hp) {
		super();
		this.name = name;
		this.hp = hp;
	}
}
