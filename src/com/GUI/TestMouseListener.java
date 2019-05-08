package com.GUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * 鼠标监听
 * 实现功能：鼠标移到图片，图片就变换位置
 */
@SuppressWarnings("unused")
public class TestMouseListener {
	public static void main(String[] args) {
		//窗体
		JFrame frame = new JFrame("Test");
		frame.setBounds(600, 500, 800, 400);
		frame.setLayout(null);
		
		//图片
		final JLabel lab = new JLabel();
		ImageIcon image = new ImageIcon("/Users/toyz/Package/IntermediateJAVA/src/com/GUI/shana.png");
		lab.setIcon(image);
		lab.setBounds(250, 200, image.getIconWidth(), image.getIconHeight());
		frame.add(lab);
		
		//鼠标进入的方法一
//		lab.addMouseListener(new MouseListener() {
//			
//			@Override
//			public void mouseReleased(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void mousePressed(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void mouseExited(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			//重写鼠标进入的方法
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				Random r = new Random();
//				int x = r.nextInt(frame.getWidth()-lab.getWidth());
//				int y = r.nextInt(frame.getHeight()-lab.getHeight());
//				lab.setLocation(x, y);
//			}
//			
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
		
		//鼠标进入的方法二——使用适配器
		lab.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				Random r = new Random();
				int x = r.nextInt(frame.getWidth()-lab.getWidth());
				int y = r.nextInt(frame.getHeight()-lab.getHeight());
				lab.setLocation(x, y);
			}	
		});
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
