package com.Practice.UserManageSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class UserInterface {

	public static void main(String[] args) {
		//新建窗体
		JFrame frame = new JFrame("用户管理界面");
		frame.setBounds(250, 200, 1000, 500);
		frame.setLayout(new BorderLayout());
		
		/*
		 * 展示模块——数据表格 
		 */
		//新建tablemodel
		UserTableModel utm = new UserTableModel();
		//新增数据展示表格
		JTable tableDisplay = new JTable(utm);
		JScrollPane sp = new JScrollPane(tableDisplay);//将表格放入支持滑动的面板
		
		
		/*
		 * 编辑模块
		 */
		//新建按钮模块
		JPanel panelSet = new JPanel();
		panelSet.setLayout(new FlowLayout());
		JButton butAdd = new JButton("新增");
		butAdd.setPreferredSize(new Dimension(150,40));
		JButton butDelete = new JButton("删除");
		butDelete.setPreferredSize(new Dimension(150,40));
		JButton butUpdate = new JButton("编辑");
		butUpdate.setPreferredSize(new Dimension(150,40));
		panelSet.add(butAdd);
		panelSet.add(butDelete);
		panelSet.add(butUpdate);
		
		/*
		 * 新建添加弹出框组件
		 */
		//添加窗体和面板
		JFrame addFrame = new JFrame("用户添加");
		addFrame.setBounds(600, 350, 300, 180);
		JPanel addPanel = new JPanel();
		addPanel.setLayout(null);
		//第一行——用户名输入
		JLabel labNameAdd = new JLabel("用户名：");
		labNameAdd.setBounds(20,20, 70, 30);
		JTextField tfNameAdd = new JTextField();
		tfNameAdd.setBounds(90, 20, 150, 30);
		addPanel.add(labNameAdd);
		addPanel.add(tfNameAdd);
		//第二行——密码输入
		JLabel labPasswordAdd = new JLabel("密码：");
		labPasswordAdd.setBounds(20, 50, 70, 30);
		JTextField tfPasswordAdd = new JTextField();
		tfPasswordAdd.setBounds(90, 50, 150, 30);
		addPanel.add(labPasswordAdd);
		addPanel.add(tfPasswordAdd);
		//第三行——提示语
		JLabel labTip = new JLabel();
		labTip.setBounds(90, 80, 200, 20);
		labTip.setForeground(Color.RED);;
		addPanel.add(labTip);
		//第四行——提交按钮
		JButton butSubmitAdd = new JButton("确认");
		butSubmitAdd.setBounds(30, 100, 120, 40);
		butSubmitAdd.setForeground(Color.BLUE);
		JButton butCancelAdd = new JButton("取消");
		butCancelAdd.setBounds(150, 100, 120, 40);
		addPanel.add(butSubmitAdd);
		addPanel.add(butCancelAdd);
		//窗体设置
		addFrame.setContentPane(addPanel);
		addFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addFrame.setVisible(false);
	
		/*
		 * 新建编辑弹出框组件
		 */
		//新建窗体和面板
		JFrame UpdateFrame = new JFrame("用户修改");
		UpdateFrame.setBounds(600, 350, 300, 200);
		JPanel UpdatePanel = new JPanel();
		UpdatePanel.setLayout(null);
		
		//第一行——展示ID
		JLabel labIdTip = new JLabel("ID为：");
		labIdTip.setBounds(20,10, 40, 30);
		JLabel labId = new JLabel();
		labId.setBounds(90, 10, 150, 30);
		UpdatePanel.add(labIdTip);
		UpdatePanel.add(labId);
		//第二行——用户名输入
		JLabel labNameUpdate = new JLabel("用户名：");
		labNameUpdate.setBounds(20, 40, 70, 30);
		JTextField tfNameUpdate = new JTextField();
		tfNameUpdate.setBounds(90, 40, 150, 30);
		UpdatePanel.add(labNameUpdate);
		UpdatePanel.add(tfNameUpdate);
		//第三行——密码输入
		JLabel labPasswordUpdate = new JLabel("密码：");
		labPasswordUpdate.setBounds(20, 70, 70, 30);
		JTextField tfPasswordUpdate = new JTextField();
		tfPasswordUpdate.setBounds(90, 70, 150, 30);
		UpdatePanel.add(labPasswordUpdate);
		UpdatePanel.add(tfPasswordUpdate);
		//第三行——提示语
		JLabel labTipUpdate = new JLabel();
		labTipUpdate.setBounds(90, 100, 200, 20);
		labTipUpdate.setForeground(Color.RED);;
		UpdatePanel.add(labTipUpdate);
		//第四行——提交按钮
		JButton butSubmitUpdate = new JButton("确认");
		butSubmitUpdate.setBounds(30, 120, 120, 40);
		butSubmitUpdate.setForeground(Color.BLUE);
		JButton butCancelUpdate = new JButton("取消");
		butCancelUpdate.setBounds(150, 120, 120, 40);
		UpdatePanel.add(butSubmitUpdate);
		UpdatePanel.add(butCancelUpdate);
		//窗体设置
		UpdateFrame.setContentPane(UpdatePanel);
		UpdateFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		UpdateFrame.setVisible(false);
		
		/*
		 * 动作模块——添加按钮动作
		 */
		butAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addFrame.setVisible(true);
				UserDAO userDao = new UserDAO();
				User user = new User();
				//判断用户是否确认添加
				butSubmitAdd.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						//获取输入框内容
						String name = tfNameAdd.getText();
						String password = tfPasswordAdd.getText();
						//判断输入name是否为空
						if(name.length() == 0) {
							labTip.setText("用户名不能为空");
							tfNameAdd.grabFocus();
							return;					
						}
						//判断密码是否为数字
						try {
							Integer.parseInt(password);
						} catch (Exception e2) {
							labTip.setText("密码需要为纯数字");
							tfPasswordAdd.grabFocus();
							return;
						}
						//将输入的值赋给user对象
						user.name = name;
						user.password = Integer.parseInt(password);
						//清空数据
						labTip.setText(null);
						tfNameAdd.setText(null);
						tfPasswordAdd.setText(null);
						//将user对象加入数据库
						userDao.add(user);
						//更新table model指针
						utm.users = userDao.list();
						//刷新页面
						tableDisplay.updateUI();
						//关闭窗口
						addFrame.setVisible(false);
					}
				});
				//判断用户是否取消添加
				butCancelAdd.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						addFrame.setVisible(false);						
					}
				});
			}
		});
		
		/*
		 * 动作模块——删除按钮动作
		 */
		butDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectInt = tableDisplay.getSelectedRow();
				//判断是否选中的特定行
				if(selectInt == -1) {
					JOptionPane.showMessageDialog(frame, "请选择要删除的项目");
					return;
				}
				int deleteConfirm = JOptionPane.showConfirmDialog(frame, "是否确认删除","确认",JOptionPane.YES_NO_OPTION);
				if(deleteConfirm == JOptionPane.YES_OPTION) {
					//获取选中行的id值
					int selectId = (int) tableDisplay.getValueAt(selectInt,0);
					//新建数据库对象，并执行删除方法
					UserDAO userDao = new UserDAO();
					userDao.delete(selectId);
					//更新table model指针
					utm.users = userDao.list();
					//刷新页面
					tableDisplay.updateUI();
				}
			}
		});
		
		/*
		 * 动作模块——编辑按钮
		 */
		butUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UpdateFrame.setVisible(true);
				UserDAO userDao = new UserDAO();
				User userUpdate = new User();
				//获取选中的项
				int selectInt = tableDisplay.getSelectedRow();
				//判断是否选中的特定行
				if(selectInt == -1) {
					JOptionPane.showMessageDialog(frame, "请选择要修改的项目");
					return;
				}
				//获取选中行的id值
				int selectId = (int) tableDisplay.getValueAt(selectInt,0);
				String labIdString = selectId+"";
				labId.setText(labIdString);
				//判断用户是否确认修改
				butSubmitUpdate.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {

						//获取输入框内容
						String name = tfNameUpdate.getText();
						String password = tfPasswordUpdate.getText();
						//判断输入name是否为空
						if(name.length() == 0) {
							labTipUpdate.setText("用户名不能为空");
							tfNameUpdate.grabFocus();
							return;					
						}
						//判断密码是否为数字
						try {
							Integer.parseInt(password);
						} catch (Exception e2) {
							labTipUpdate.setText("密码需要为纯数字");
							tfPasswordUpdate.grabFocus();
							return;
						}
						//将输入的值赋给userUpdate对象
						userUpdate.id = selectId;
						userUpdate.name = name;
						userUpdate.password = Integer.parseInt(password);
						//调用更新方法
						userDao.update(userUpdate);
						//刷新指针
						utm.users = userDao.list();
						//刷新页面
						tableDisplay.updateUI();
						//关闭窗口
						UpdateFrame.setVisible(false);
					}
				});
				//判断用户是否取消添加
				butCancelUpdate.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						UpdateFrame.setVisible(false);						
					}
				});
			}
			
		});
		
		
		
		
		/*
		 * 窗体设置
		 */
		frame.add(sp,BorderLayout.NORTH);
		frame.add(panelSet,BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}

}
