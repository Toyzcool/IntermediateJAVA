package com.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import com.JDBC.Hero;
import com.JDBC.HeroDAO;

/*
 * 使用TableModel,将数据和显示分离
 */
public class TestTableModel_GUI {

	public static void main(String[] args) {
		//新建窗体
		JFrame frame = new JFrame();
		frame.setBounds(400, 300, 800, 400);
		frame.setLayout(new BorderLayout());

		//新建Label显示选中的英雄
		JLabel lab = new JLabel("未选中英雄");
		JPanel panelDisplay = new JPanel();
		panelDisplay.add(lab);
		
		/*
		 * 新建展示选中内容条
		 */
		//新建TableModel
		TestTableModel_Hero tmh = new TestTableModel_Hero();
		//新建Table
		JTable table = new JTable(tmh);
		JScrollPane sp = new JScrollPane(table);
		//table监听选中的项目
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int row = table.getSelectedRow();
				Hero h = tmh.heros.get(row);
				lab.setText("选中的英雄："+h.name);
			}
		});

		/*
		 * 新建添加功能
		 */
		//新建输入框
		JTextField nameField = new JTextField();
		nameField.setPreferredSize(new Dimension(80,30));
		JTextField hpField = new JTextField();
		hpField.setPreferredSize(new Dimension(80,30));
		JTextField damageField = new JTextField();
		damageField.setPreferredSize(new Dimension(80,30));
		//新建输入框标签
		JLabel nameLab = new JLabel("Name");
		JLabel hpLab = new JLabel("HP");
		JLabel damageLab = new JLabel("Damage");
		//新建按钮
		JButton submit = new JButton("Submit");
		//新建面板并放入组件
		JPanel panelAdd = new JPanel();
		panelAdd.setLayout(new FlowLayout());
		panelAdd.add(nameLab);
		panelAdd.add(nameField);
		panelAdd.add(hpLab);
		panelAdd.add(hpField);
		panelAdd.add(damageLab);
		panelAdd.add(damageField);
		panelAdd.add(submit);
		
		/*
		 * 新建按钮添加动作
		 */
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//初始化数据库驱动
				HeroDAO hd = new HeroDAO();
				//获取输入框中内容
				String name = nameField.getText();
				String hp = hpField.getText();
				String damage = damageField.getText();
				//新建存储对象
				Hero hero = new Hero();
				//判断name是否为空白
				if(name.length() == 0) {
					JOptionPane.showMessageDialog(frame,"Name不能为空");//提示
					nameField.grabFocus();//输入框重新获得聚焦
					return;//需要重新判断
				}
				//判断hp是否为浮点型
				try {
					Float.parseFloat(hp);//将内容转换成float，失败则抛出异常
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(frame, "HP需要为数字");//提示
					hpField.grabFocus();
					return;
				}
				//判断damage是否为数字
				try {
					Integer.parseInt(damage);//将内容转换成int，失败则抛出异常
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(frame, "Damage需要为数字");
					damageField.grabFocus();
					return;
				}
				//将输入内容赋值给hero对象
				hero.name = name;
				hero.hp = Float.parseFloat(hp);
				hero.damage = Integer.parseInt(damage);
				
				//对象加入数据库
				hd.add(hero);
				//更新table model指针
				tmh.heros = hd.list();
				//刷新页面
				table.updateUI();
			}
		});
		
		 // 设置选择模式为 只能选中一行
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // 选中第一行 （基本0）
        table.getSelectionModel().setSelectionInterval(0, 0);

		//窗体设置
		frame.add(panelDisplay,BorderLayout.SOUTH);
		frame.add(panelAdd,BorderLayout.NORTH);
		frame.add(sp, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
