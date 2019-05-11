package com.Practice.UserManageSystem;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class UserInterface {

	public static void main(String[] args) {
		//新建窗体
		JFrame frame = new JFrame("用户管理界面");
		frame.setBounds(250, 200, 1000, 500);
		frame.setLayout(new BorderLayout());
		
		//新建tablemodel
		UserTableModel utm = new UserTableModel();
		//新增数据展示表格
		JTable tableDisplay = new JTable(utm);
		JScrollPane sp = new JScrollPane(tableDisplay);//将表格放入支持滑动的面板
		
		
	}

}
