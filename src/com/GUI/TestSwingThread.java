package com.GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

/*
 * 三种线程
 * 1.初始化线程
 * 2.事件调度线程
 * 3.长耗时任务线程
 */
public class TestSwingThread {

	public static void main(String[] args) {
		/*
		 * 前端页面
		 */
		JFrame frame = new JFrame();
		frame.setBounds(400, 300, 800, 400);
		frame.setLayout(new FlowLayout());
		//新建按钮
		JButton butDispatchThread = new JButton("使用事件调度线程执行长耗时任务");
		butDispatchThread.setPreferredSize(new Dimension(300,40));
		frame.add(butDispatchThread);
		JButton butSwingWorker = new JButton("使用SwingWorker执行长耗时任务");
		butSwingWorker.setPreferredSize(new Dimension(300,40));
		frame.add(butSwingWorker);
		//新建Label展示当前线程
		JLabel lab = new JLabel();
		lab.setPreferredSize(new Dimension(300,40));
		frame.add(lab);
		//窗体设置
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
		
        /*
         * 按钮动作
         */
        //事件调度线程
        butDispatchThread.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lab.setText("当前线程是否是 事件调度线程: " + SwingUtilities.isEventDispatchThread());
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
        //SwingWorker
        butSwingWorker.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//新建对象
				SwingWorker worker = new SwingWorker() {

					@Override
					//放置长耗时任务，将放在专门的线程中执行
					protected Object doInBackground() throws Exception {
						Thread.sleep(5000);
						lab.setText("执行这个SwingWorder的线程是：" + Thread.currentThread().getName());
						return null;
					}
				};
				worker.execute();
			}
		});
	}

}
