package com.GUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

/*
 * 练习Panel切换
 * 功能预期：
 * 设计一个像SplitPanel的左右风格的SplitPanel
 * 左边放3个按钮，上面的文字分别是: 盖伦，提莫，安妮
 * 右边默认显示盖伦
 * 当左边按钮点击的时候，右边就会显示对应的图片
 */
public class TestPanelPractice {

	public static void main(String[] args) {
		/*
		 * 步骤
		 * 1.新建窗体
		 * 2.左边Panel，并放入三个按钮
		 * 3.右边三个Panel，分别放入图片
		 * 4.使用SplitPanel分割
		 * 5.写按钮点击的监听动作
		 */
		//新建窗体
		JFrame frame = new JFrame();
		frame.setBounds(400, 300, 800, 400);
		
		/*
		 * 左边Panel
		 */
		JPanel pleft = new JPanel();
		pleft.setBackground(Color.DARK_GRAY);
		pleft.setLayout(new FlowLayout());
		//新建按钮并放入
		JButton but1 = new JButton("盖伦");	
		JButton but2 = new JButton("提莫");
		JButton but3 = new JButton("安妮");
		pleft.add(but1);
		pleft.add(but2);
		pleft.add(but3);
		
		/*
		 * 右边Panel1
		 */
		//新建Label存放图片
		JLabel lab1 = new JLabel();
		ImageIcon image1 = new ImageIcon("/Users/toyz/Package/IntermediateJAVA/src/com/GUI/pics/gareen.jpg");
		lab1.setIcon(image1);
		//将Label放入Panel
		JPanel pright1 = new JPanel();
		pright1.setBackground(Color.DARK_GRAY);
		pright1.setLayout(new FlowLayout());
		pright1.add(lab1);
		
		/*
		 * 右边Panel2
		 */
		//新建Label存放图片
		JLabel lab2 = new JLabel();
		ImageIcon image2 = new ImageIcon("/Users/toyz/Package/IntermediateJAVA/src/com/GUI/pics/teemo.jpg");
		lab2.setIcon(image2);
		//将Label放入Panel
		JPanel pright2 = new JPanel();
		pright2.setBackground(Color.DARK_GRAY);
		pright2.setLayout(new FlowLayout());
		pright2.add(lab2);
		
		/*
		 * 右边Panel3
		 */
		//新建Label存放图片
		JLabel lab3 = new JLabel();
		ImageIcon image3 = new ImageIcon("/Users/toyz/Package/IntermediateJAVA/src/com/GUI/pics/annie.jpg");
		lab3.setIcon(image3);
		//将Label放入Panel
		JPanel pright3 = new JPanel();
		pright3.setBackground(Color.DARK_GRAY);
		pright3.setLayout(new FlowLayout());
		pright3.add(lab3);
		
		/*
		 * CardLayout方法存放Panel
		 */
		JPanel prights = new JPanel(new CardLayout());
		prights.add(pright1,"card1");
		prights.add(pright2,"card2");
		prights.add(pright3,"card3");

		/*
		 * SplitPanel分割
		 */
		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pleft, prights);
		sp.setDividerSize(10);
		
		//加入窗体
		frame.setContentPane(sp);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		/*
		 * 按钮监听
		 */
		but1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) prights.getLayout();
				cl.show(prights,"card1");
			}
		});
		
		but2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) prights.getLayout();
				cl.show(prights, "card2");
			}
		});
		
		but3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) prights.getLayout();
				cl.show(prights, "card3");
			}
		});
		

		
		
		
		
		
		
		
		
		
		
	}

}
