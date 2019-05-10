package com.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

/*
 * 组件功能的综合练习
 */
public class TestComponentPractice {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setLocation(400,300);
		frame.setSize(800, 400);
		
		/*
		 * 在JTextField中输入数据，在旁边加一个按钮JButton,当点击按钮的时候，判断JTextFiled中有没有数据，并使用JOptionPane进行提示
		 *//*
		//新建面板
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		//新建textField以及button
		JTextField tf = new JTextField();
		tf.setPreferredSize(new Dimension(100,30));
		JButton but = new JButton("提交");
		//加入面板
		panel.add(tf);
		panel.add(but);
		
		//新建提示框
		JOptionPane op = new JOptionPane();
		
		//窗体设置
		frame.setContentPane(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		//点击动作
		but.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//获取输入内容
				String tip = tf.getText();
				if(tip.equals("")) {
					op.showMessageDialog(op, "内容不能为空");
				}
			}
		});*/
		
		/*
		 * 进度条
		 * 设计一个线程，每隔100毫秒，就把进度条的进度+1,从0%一直加到100%
		 * 刚开始加的比较快，以每隔100毫秒的速度增加，随着进度的增加，越加越慢
		 */
		//新建面板
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setBackground(Color.lightGray);
		
		//新建进度条
		JProgressBar bar = new JProgressBar();
		bar.setMaximum(100);
		bar.setValue(0);
		bar.setStringPainted(true);
		bar.setPreferredSize(new Dimension(200,50));
		panel.add(bar);
		
		//窗体设置
		frame.setContentPane(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		//新建线程
		Thread t1 = new Thread() {
				public void run() {
					int n = 0;
					int timespan = 100;
					while(bar.getValue() != 100) {
						bar.setValue(n);
						n += 1;
						timespan += 100;
						try {
							Thread.sleep(timespan);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						}
					}
		};
		t1.start();
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
