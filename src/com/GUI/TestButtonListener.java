package com.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * 监听按钮动作
 */
@SuppressWarnings("unused")
public class TestButtonListener {

	public static void main(String[] args) {
		//新建窗体
		JFrame f = new JFrame("Test Button");
		//设置窗体大小和位置
		f.setBounds(500, 400, 600, 400);
		f.setLayout(null);
		
		//新建Label对象存放图片
		JLabel lab = new JLabel();
		
		//新建图片并放入Label对象中
		ImageIcon pic = new ImageIcon("/Users/toyz/Package/IntermediateJAVA/src/com/GUI/shana.png");
		lab.setIcon(pic);
		lab.setBounds(250, 50,pic.getIconWidth(), pic.getIconHeight());
		
		//新建按钮用于隐藏图片
		JButton but = new JButton("Hide Pic");
		but.setBounds(260, 200, 100, 50);
//		but.addActionListener(new ActionListener() {
//			//重写点击动作
//			@Override 
//			public void actionPerformed(ActionEvent e) {
//				lab.setVisible(false);
//			}
//		});
		//特殊表达式
		but.addActionListener((e) -> lab.setVisible(false));
		
		//将组件放入窗体中
		f.add(lab);
		f.add(but);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		
	}

}
