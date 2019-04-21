package com.File;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class DataRead {
	//读取数据方法
	public static void dataWriter() {
		File f = new File("/Users/toyz/eclipse-workspace/data.txt");
		
	}
	public static void dataReader() {
		File f = new File("/Users/toyz/eclipse-workspace/data.txt");
		System.out.println("文件是否存在："+f.exists());
		try (			
			FileInputStream fis = new FileInputStream(f);
			DataInputStream dis = new DataInputStream(fis);
			)
		{
			int i = dis.readInt();
			String s = dis.readUTF();
			System.out.println("读到的数字为："+i);
			System.out.println("读到的字符串为："+s);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dataReader();
	}

}
