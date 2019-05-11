package com.GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/*
 * 表格
 */
public class TestTable {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setBounds(400, 300, 800, 400);
		frame.setLayout(new BorderLayout());
		
		//新建表头和表格项
		String[] columName = new String[] {"id","name","hp","damage"};
		String[][] heros = new String[][] {
			{"1","VN","500","100"},{"2","EZ","500","100"},{"3","Teemo","500","100"}	
		};
		
		//新建表格
		JTable table = new JTable(heros,columName);
		
		//新建滚动面板
		JScrollPane sp = new JScrollPane();
		sp.setViewportView(table);
		frame.add(sp,BorderLayout.CENTER);
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		
		//窗体设置
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}

}
