package com.GUI;

import javax.swing.JDialog;
import javax.swing.JFrame;

/*
 * 各种容器
 */
public class TestContainer {

	public static void main(String[] args) {
		//frame窗体
		JFrame frame = new JFrame("Frame");
		frame.setBounds(600,500,800,400);
		//dialog窗体，无放大缩小
		JDialog dialog = new JDialog(frame);
		dialog.setTitle("模态对话框且无法调节大小");
		dialog.setBounds(600, 500, 400, 200);

		//模态窗口，将dialog设置为模态窗口
		dialog.setModal(true);
		
		//将dialog窗口设置为不可调节大小
		dialog.setResizable(false);
		
		frame.setVisible(true);
		dialog.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dialog.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
	}

}
