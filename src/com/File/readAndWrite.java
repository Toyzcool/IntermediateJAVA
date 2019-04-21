package com.File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class readAndWrite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 文件的读
		 */
		System.out.println("-----文件的读取-----");
		File f = new File("/Users/toyz/eclipse-workspace/AB.txt");
		//创建基于文件的输入流,输入是相对于当前程序为主体，从文件输入到当前程序，因此称为输入流
		try {
			FileInputStream fis = new FileInputStream(f);
			//定义存储数组的长度
			byte[] b = new byte[(int) f.length()];
			//获取输入流
			fis.read(b);
			System.out.print("文件内容为：");
			//使用for-each方法输出
			for (byte c : b) {
				System.out.print(" "+c);
			}
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * 文件的写
		 */
		System.out.println("");
		System.out.println("-----文件的写入-----");
		File fw = new File("/Users/toyz/eclipse-workspace/XY.txt");
		try {
			FileOutputStream fos = new FileOutputStream(fw);
			//新建写入的数组
			byte[] bos = {84,88};
			//写入内容
			fos.write(bos);
			fos.close();
			//读取写入的内容
			FileInputStream fis2 = new FileInputStream(fw);
			byte[] bis = new byte[(int) fw.length()];
			fis2.read(bis);
			System.out.print("写入XY.txt文件的内容为：");
			for (byte b : bis) {
				System.out.print(" "+ b);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
