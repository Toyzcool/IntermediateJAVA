package com.GUI;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

/*
 * swing常用组件
 */
public class TestComponent {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setBounds(500, 400, 800, 400);
		
		/*
		 * 标签
		 */
		//标签设置
		JLabel label = new JLabel();
		ImageIcon pic = new ImageIcon("/Users/toyz/Package/IntermediateJAVA/src/com/GUI/shana.png");
		label.setIcon(pic);
		label.setSize(pic.getIconWidth(), pic.getIconHeight());
		//窗体设置
//		frame.setLayout(new FlowLayout());
//		frame.add(label);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
		
		/*
		 * 按钮
		 */
		//略
		
		/*
		 * 复选框
		 */
		//复选框设置
		JCheckBox cb1 = new JCheckBox("Agree");
		JCheckBox cb2 = new JCheckBox("Forced to Agree");
		//选项一默认选中
		cb1.setSelected(true);
		//窗体设置
//		frame.setLayout(new FlowLayout());
//		frame.add(cb1);
//		frame.add(cb2);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
		
		/*
		 * 单选框和选项组
		 */
		//单选框
		JRadioButton rb1 = new JRadioButton("Agree");
		JRadioButton rb2 = new JRadioButton("Disagree");
		//选项一默认选中
		rb1.setSelected(true);
		//选项组实现选项互斥
		ButtonGroup bg = new ButtonGroup();
		bg.add(rb1);
		bg.add(rb2);
		
		//窗体设置
//		frame.setLayout(new FlowLayout());
//		frame.add(rb1);
//		frame.add(rb2);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
		
		/*
		 * 下拉框
		 */
		//下拉框
		String[] hero = new String[] {"red","green","blue"};
		JComboBox cb = new JComboBox(hero);
		
		//窗体设置
//		frame.setLayout(new FlowLayout());
//		frame.add(cb);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
		
		/*
		 * 对话框
		 */
		
		//窗体设置
//		frame.setLayout(new FlowLayout());
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
		
		//对话框——询问
//		JOptionPane op = new JOptionPane();
//		int option = op.showConfirmDialog(frame, "是否同意");
//		if(JOptionPane.OK_OPTION == option) {
//			String name = op.showInputDialog(frame, "enter your name");
//			op.showMessageDialog(frame, "Welcome  "+name);
//		}else if(JOptionPane.CANCEL_OPTION == option) {
//			frame.setVisible(false);
//		}else {
//			frame.setVisible(false);
//		}
		
		/*
		 * 文本框和密码框
		 */
		//文本框设置
		JLabel lab1 = new JLabel("账号：");
		JTextField tf = new JTextField("请输入账号");
		tf.setPreferredSize(new Dimension(100,30));
		JLabel lab2 = new JLabel("密码：");
		JPasswordField pf = new JPasswordField();
		pf.setPreferredSize(new Dimension(100,30));
		
		//窗体设置
//		frame.setLayout(new FlowLayout());
//		frame.add(lab1);
//		frame.add(tf);
//		frame.add(lab2);
//		frame.add(pf);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
		
		/*
		 * 文本域
		 */
		//文本域设置
		JTextArea ta = new JTextArea();
		ta.setPreferredSize(new Dimension(200,150));
		//显示内容
		ta.setText("Come on!\nYou will never forget\n");
		//追加显示
		ta.append("Don't do this");
		//自动换行
		ta.setLineWrap(true);
		
		//窗体设置
//		frame.setLayout(new FlowLayout());
//		frame.add(ta);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
		
		/*
		 * 进度条
		 */
		//进度条设置
		JProgressBar pb = new JProgressBar();
		pb.setPreferredSize(new Dimension(200,40));
		pb.setMaximum(100);
		pb.setValue(50);
		//显示当前进度
		pb.setStringPainted(true);
		
		//窗体设置
		frame.setLayout(new FlowLayout());
		frame.add(pb);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		/*
		 * 打开和保存文件
		 */
		        JFrame f = new JFrame("LOL");
		        f.setLayout(new FlowLayout());
		        JFileChooser fc = new JFileChooser();
		        fc.setFileFilter(new FileFilter() {
		             
		            @Override
		            public String getDescription() {
		                return ".txt";
		            }
					@Override
					public boolean accept(File f) {
						return false;
					}
		        });
		  
		        JButton bOpen = new JButton("打开文件");
		  
		        JButton bSave = new JButton("保存文件");
		  
		        f.add(bOpen);
		        f.add(bSave);
		  
		        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        f.setSize(250, 150);
		        f.setLocationRelativeTo(null);
		  
		        f.setVisible(true);
		          
		        bOpen.addActionListener(new ActionListener() {
		              
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                 int returnVal =  fc.showOpenDialog(f);
		                 File file = fc.getSelectedFile();
		                 if (returnVal == JFileChooser.APPROVE_OPTION) {
		                     JOptionPane.showMessageDialog(f, "计划打开文件:" + file.getAbsolutePath());
		                 }
		                  
		            }
		        });
		        bSave.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                int returnVal =  fc.showSaveDialog(f);
		                File file = fc.getSelectedFile();
		                if (returnVal == JFileChooser.APPROVE_OPTION) {
		                    JOptionPane.showMessageDialog(f, "计划保存到文件:" + file.getAbsolutePath());
		                }
		            }
		        });
		  
		    }
		
	}

