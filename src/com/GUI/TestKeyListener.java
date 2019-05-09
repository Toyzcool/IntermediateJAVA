package com.GUI;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * 键盘监听
 * 功能实现：用键盘控制图片移动
 */
public class TestKeyListener {

	public static void main(String[] args) {
		//新建窗体
		JFrame frame = new JFrame("Test");
		//设置窗体参数
		frame.setBounds(600, 500, 800, 400);
		frame.setLayout(null);
		
		//新建图片
		ImageIcon pic = new ImageIcon("/Users/toyz/Package/IntermediateJAVA/src/com/GUI/shana.png");
		JLabel lab = new JLabel();
		lab.setIcon(pic);
		lab.setBounds(250, 200, pic.getIconWidth(), pic.getIconHeight());
		
		//组件放入窗体
		frame.add(lab);
		
		//监听键盘动作
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				//左 37
				case 37:
					lab.setLocation(lab.getX()-10,lab.getY());
					break;
				//上 38
				case 38:
					lab.setLocation(lab.getX(),lab.getY()-10);
					break;
				//右 39
				case 39:
					lab.setLocation(lab.getX()+10,lab.getY());
					break;
				//下 40
				case 40:
					lab.setLocation(lab.getX(),lab.getY()+10);
					break;
				}
			}

		});
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
