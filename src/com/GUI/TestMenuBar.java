package com.GUI;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/*
 * 菜单栏
 */
public class TestMenuBar {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setBounds(400, 300, 800, 400);
		
		//新建菜单栏
		JMenuBar menuBar = new JMenuBar();
		
		//新建菜单
		JMenu menu1 = new JMenu("File");
		JMenu menu2 = new JMenu("Edit");
		JMenu menu3 = new JMenu("Source");
		JMenu menu4 = new JMenu("Refactor");
		//新建菜单项
		menu1.add(new JMenuItem("New"));
		menu1.add(new JMenuItem("Open"));
		menu1.addSeparator();
		menu1.add(new JMenuItem("Save"));
		menu1.add(new JMenuItem("Sava As"));
		menuBar.add(menu1);
		menuBar.add(menu2);
		menuBar.add(menu3);
		menuBar.add(menu4);
		
		//加入窗体
		frame.setJMenuBar(menuBar);
		
		//窗体设置
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
