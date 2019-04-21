package com.File;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataRead {
	//读取数据方法，注意：datainputstream方法一定要用dataoutputstream写入才能读取，因为带特殊标记
	public static void dataWriter() {
		File fw = new File("/Users/toyz/eclipse-workspace/data.txt");
		System.out.println("-----写入内容-----");
		try(
			FileOutputStream fos = new FileOutputStream(fw);
			DataOutputStream dos = new DataOutputStream(fos);
			)
		{
			int i = 520;
			String s = "You know";
			//写入
			dos.writeInt(i);
			dos.writeUTF(s);
			System.out.println("成功写入："+i+" 和 "+s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void dataReader() {
		File fr = new File("/Users/toyz/eclipse-workspace/data.txt");
		System.out.println("-----文件输出-----");
		System.out.println("文件是否存在："+fr.exists());
		try (			
			FileInputStream fis = new FileInputStream(fr);
			DataInputStream dis = new DataInputStream(fis);
			)
		{
			int i = dis.readInt();
			String s = dis.readUTF();
			System.out.println("读到的数字为："+i);
			System.out.println("读到的字符串为："+s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		dataWriter();
		dataReader();
	}
}
