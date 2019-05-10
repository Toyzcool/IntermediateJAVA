package com.GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * 常用面板
 */
public class TestPanel {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setBounds(400, 300, 800, 400);
		
		/*
		 * JPanel——基本面板
		 */
		/*
		//新建面板1
		JPanel p1 = new JPanel();
		p1.setBounds(200, 10, 300, 60);
		p1.setLayout(new FlowLayout());
		p1.setBackground(Color.darkGray);
		//新建放置在面板上的按钮
		JButton b1 = new JButton("Yes");
		JButton b2 = new JButton("No");
		JButton b3 = new JButton("Canel");
		//放置按钮
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		//新建面板2
		JPanel p2 = new JPanel();
		p2.setBounds(200, 200, 300, 60);
		p2.setLayout(new FlowLayout());
		p2.setBackground(Color.BLUE);
		//新建放置在面板上的按钮
		JButton b4 = new JButton("Yes");
		JButton b5 = new JButton("No");
		JButton b6 = new JButton("Canel");
		//放置按钮
		p2.add(b4);
		p2.add(b5);
		p2.add(b6);
		
		//窗体设置
		frame.add(p1);
		frame.add(p2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		*/
		
		/*
		 * ContentPanel
		 */
		//平时通过f.add()向JFrame增加组件，其实是向JFrame上的 ContentPane加东西
		
		/*
		 * SplitPanel
		 */	/*

		//创建基本Panel1
		JPanel pleft = new JPanel();
		pleft.setLayout(new FlowLayout());
		pleft.setBackground(Color.darkGray);
		//新建放置在面板上的按钮
		JButton b1 = new JButton("Yes");
		JButton b2 = new JButton("No");
		JButton b3 = new JButton("Canel");
		//放置按钮
		pleft.add(b1);
		pleft.add(b2);
		pleft.add(b3);
		
		//创建基本Panel2
		JPanel pright = new JPanel();
		pright.setLayout(new FlowLayout());
		pright.setBackground(Color.darkGray);
		//新建放置在面板上的按钮
		JButton b4 = new JButton("Yes");
		JButton b5 = new JButton("No");
		JButton b6 = new JButton("Canel");
		//放置按钮
		pright.add(b4);
		pright.add(b5);
		pright.add(b6);
		
		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pleft,pright);
		sp.setDividerLocation(80);
		
		frame.setContentPane(sp);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);	*/

		
		/*
		 * JScrollPanel
		 */ /*
		//文本域放入滚动面板中
		JTextArea ta = new JTextArea();
		for(int i = 0 ; i < 1000 ; i++) {
			ta.append("Come on!\n");
		}
		ta.setLineWrap(true);
		
		//新建滚动面板
		JScrollPane sp = new JScrollPane(ta);
		
		frame.setContentPane(sp);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true); */
		
		/*
		 * TabbedPanel
		 */ /*
		//创建基本Panel1
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		p1.setBackground(Color.darkGray);
		//新建放置在面板上的按钮
		JButton b1 = new JButton("Yes");
		JButton b2 = new JButton("No");
		JButton b3 = new JButton("Canel");
		//放置按钮
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		
		//创建基本Panel2
		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		p2.setBackground(Color.darkGray);
		//新建放置在面板上的按钮
		JButton b4 = new JButton("No");
		JButton b5 = new JButton("Way");
		JButton b6 = new JButton("Canel");
		//放置按钮
		p2.add(b4);
		p2.add(b5);
		p2.add(b6);
		
		//新建tab面板
		JTabbedPane tp = new JTabbedPane();
		tp.add(p1);
		tp.add(p2);
		tp.setTitleAt(0, "page1");
		tp.setTitleAt(1, "page2");
		
		//窗体设置
		frame.setContentPane(tp);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);	*/
		
		/*
		 * CardLayerout
		 */
		//新建下拉框并加入面板
		JPanel ComboBoxPane = new JPanel();
		String buttonPanel = "按钮面板";
		String inputPanel = "输入面板";
		String comboBoxItem[] = {buttonPanel,inputPanel};
		JComboBox<String> cb = new JComboBox<String>(comboBoxItem);
		ComboBoxPane.add(cb);
		
		//新建panel作为card
		JPanel card1 = new JPanel();
		card1.add(new JButton("button1"));
		card1.add(new JButton("button2"));
		card1.add(new JButton("button3"));
		
		JPanel card2 = new JPanel();
		card2.add(new JTextField("Input",20));
		
		//新建panel放card
		JPanel cards;
		cards = new JPanel(new CardLayout());
		cards.add(card1,buttonPanel);
		cards.add(card2,inputPanel);
		
		//面板加入窗体
		frame.add(ComboBoxPane,BorderLayout.NORTH);
		frame.add(cards,BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);	
		
		//重写下拉框的监听
		cb.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				CardLayout cl = (CardLayout) cards.getLayout();
				cl.show(cards, (String) e.getItem());
			}
		});
		
	}

}
