package com.GUI;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.JDBC.Hero;
import com.JDBC.HeroDAO;

public class TestTableModel_Hero extends AbstractTableModel {
	
	String[] columnName = new String[] {"id","name","hp","damage"};
	public List<Hero> heros = new HeroDAO().list();
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return heros.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnName.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Hero h = heros.get(rowIndex);
		if(0 == columnIndex)
			return h.id;
		if(1 == columnIndex)
			return h.name;
		if(2 == columnIndex)
			return h.hp;
		if(3 == columnIndex)
			return h.damage;
		return null;
	}
	//获取每一列名称	
	public String getColumnName(int columnIndex) {
	    return columnName[columnIndex];
	}
}
