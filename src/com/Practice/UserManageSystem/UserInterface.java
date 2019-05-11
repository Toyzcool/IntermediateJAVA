package com.Practice.UserManageSystem;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class UserInterface {

	public static void main(String[] args) {
		//新建窗体
		JFrame frame = new JFrame("用户管理界面");
		frame.setBounds(250, 200, 1000, 500);
		frame.setLayout(new BorderLayout());
		
		/*
		 * 数据表格 
		 */
		//新建tablemodel
		UserTableModel utm = new UserTableModel();
		//新增数据展示表格
		JTable tableDisplay = new JTable(utm);
		JScrollPane sp = new JScrollPane(tableDisplay);//将表格放入支持滑动的面板
		
		//新建按钮模块
		JPanel panelSet = new JPanel();
		panelSet.setLayout(new FlowLayout());
		JButton butAdd = new JButton("新增");
		JButton butDelete = new JButton("删除");
		JButton butUpdate = new JButton("编辑");
		panelSet.add(butAdd);
		panelSet.add(butDelete);
		panelSet.add(butUpdate);
		
		/*
		 * 窗体设置
		 */
		frame.add(sp,BorderLayout.NORTH);
		frame.add(panelSet,BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}

}
