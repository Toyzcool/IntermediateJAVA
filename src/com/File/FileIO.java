package com.File;

import java.io.File;

public class FileIO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//新建文件对象
		File f = new File("/Users/toyz/eclipse-workspace");
		//判断文件是否存在
		System.out.println("文件是否存在："+f.exists());
		//新建文件
		@SuppressWarnings("unused")
		File f1 = new File(f,"/Users/toyz/eclipse-workspace/1.rtf");
	}

}
