package com.File;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class BufferRead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 文件的读取
		 */
		System.out.println("-----文件读取结果-----");
		File f = new File("/Users/toyz/eclipse-workspace/AB.txt");
		try {
			//创建文件字符流
			FileReader fr = new FileReader(f);
			//缓存流在一个已存在流的基础上
			BufferedReader br = new BufferedReader(fr);
			while(true) {
				String line = br.readLine();
				if(line == null) {
					break;
				}
				System.out.println(line);
			}
			fr.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		/*
		 * 文件的写入
		 */
		System.out.println("-----文件编写-----");
		try(			
			//创建文件字符流
			FileWriter fw = new FileWriter(f);
			//将内容一行一行写入
			PrintWriter pw = new PrintWriter(fw);)
		{
			//获取用户输入
			System.out.println("请输入想要写入文件的内容,结束输入'end'");
			Scanner console = new Scanner(System.in);
			while (true) {
				String i = console.next();
				pw.println(i);
				pw.flush();
				if(i.equals("end")) {
					break;
				}
			}
			console.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
