package com.GUI;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;

public class TestToolBar {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setBounds(400, 300, 800, 400);
		
		//新建工具栏
		JToolBar bar = new JToolBar();
		//禁止工具栏移动
		bar.setFloatable(false);
		//新建按钮
		JButton but1 = new JButton(new ImageIcon("/Users/toyz/Package/IntermediateJAVA/src/com/GUI/pics/1.jpg"));
		JButton but2 = new JButton(new ImageIcon("/Users/toyz/Package/IntermediateJAVA/src/com/GUI/pics/2.jpg"));
		JButton but3 = new JButton(new ImageIcon("/Users/toyz/Package/IntermediateJAVA/src/com/GUI/pics/3.jpg"));
		JButton but4 = new JButton(new ImageIcon("/Users/toyz/Package/IntermediateJAVA/src/com/GUI/pics/4.jpg"));
		JButton but5 = new JButton(new ImageIcon("/Users/toyz/Package/IntermediateJAVA/src/com/GUI/pics/5.jpg"));
		JButton but6 = new JButton(new ImageIcon("/Users/toyz/Package/IntermediateJAVA/src/com/GUI/pics/6.jpg"));
		but1.setToolTipText("ADC");
		bar.add(but1);
		bar.add(but2);
		bar.add(but3);
		bar.add(but4);
		bar.add(but5);
		bar.add(but6);
		
		frame.setLayout(new BorderLayout());
		frame.add(bar,BorderLayout.NORTH);

		//窗体设置
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
