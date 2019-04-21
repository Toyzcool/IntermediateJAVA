package com.File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/*
 * 与Hero类关联
 */
public class ObjectRead {

	public static void main(String[] args) {
		Hero h = new Hero("Toyz",356);
		System.out.println("当前英雄为："+h.name);
		/*
		 * 写入
		 */
		//新建文件对象
		System.out.println("-----准备写入对象-----");
		File f = new File("/Users/toyz/eclipse-workspace/hero.txt");
		System.out.println("文件是否存在："+f.exists());
		try
		(
			//创建对象输出流
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			//创建对象输入流
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
		) {
			//对象写入
			oos.writeObject(h);
			System.out.println("-----写入成功-----");
			//对象输出
			Hero h2 = (Hero) ois.readObject();
			System.out.println("英雄名称为："+h2.name);
			System.out.println("英雄血量为："+h2.hp);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
