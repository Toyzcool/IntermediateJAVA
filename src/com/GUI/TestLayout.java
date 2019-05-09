package com.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestLayout {

	public static void main(String[] args) {
		//新建窗体
		JFrame frameFlow = new JFrame("布局器_FlowLayout");
		JFrame frameBorder = new JFrame("布局器_BorderLayout");
		JFrame frameGrid = new JFrame("布局器_GridLayout");
		frameFlow.setBounds(500,400,800,400);
		frameBorder.setBounds(500,400,800,400);
		frameGrid.setBounds(500,400,800,400);
		//新建按钮，展示布局
		JButton but1 = new JButton("wechat");
		JButton but2 = new JButton("qq");
		JButton but3 = new JButton("weibo");
		JButton but4 = new JButton("facebook");
		JButton but5 = new JButton("google");

		but1.setSize(80, 40);
		but2.setSize(80, 40);
		but3.setSize(80, 40);
		but4.setSize(80, 40);
		but5.setSize(80, 40);

		/*
		 * FlowLayout布局器+setPreferredSize()方法
		 */
		frameFlow.setLayout(new FlowLayout());
		frameFlow.add(but1);
		frameFlow.add(but2);
		frameFlow.add(but3);
		frameFlow.add(but4);
		but4.setPreferredSize(new Dimension(100,50));
		frameFlow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameFlow.setVisible(true);

		/*
		 * BorderLayout布局器
		 */
		frameBorder.setLayout(new BorderLayout());
		frameBorder.add(but1,BorderLayout.NORTH);
		frameBorder.add(but2,BorderLayout.SOUTH);
		frameBorder.add(but3,BorderLayout.WEST);
		frameBorder.add(but4,BorderLayout.EAST);
		frameBorder.add(but5,BorderLayout.CENTER);
		//setPreferredSize方法无效
		but5.setPreferredSize(new Dimension(40,50));
		frameBorder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameBorder.setVisible(true);
		
		/*
		 * GridLayout布局器
		 */
		frameGrid.setLayout(new GridLayout(2,3));
		frameGrid.add(but1);
		frameGrid.add(but2);
		frameGrid.add(but3);
		frameGrid.add(but4);
		frameGrid.add(but5);
		frameGrid.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameGrid.setVisible(true);
		
		
	}

}
