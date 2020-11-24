package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest 
{
	public static void main(String [] args) throws ClassNotFoundException, IOException, SQLException, ParseException
	{
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();
		testGetMenuItem();
	}
	public static void testGetMenuItemListAdmin() throws ClassNotFoundException, IOException, SQLException
	{
		MenuItemDao menuItemDao= new MenuItemDaoSqlImpl();
		System.out.println("Menu Item List for Admin");
		for(MenuItem m:menuItemDao.getMenuItemListAdmin()) 
		{
			System.out.println(m.toString());
		}
	}
	public static void testGetMenuItemListCustomer() throws ClassNotFoundException, IOException, SQLException
	{
		MenuItemDao menuItemDao= new MenuItemDaoSqlImpl();
		System.out.println("Menu Item List for Customer");
		for(MenuItem m:menuItemDao.getMenuItemListCustomer()) 
		{
			System.out.println(m.toString());
		}
	}
	public static void testModifyMenuItem() throws ParseException, ClassNotFoundException, IOException, SQLException 
	{
		MenuItemDao menuItemDao= new MenuItemDaoSqlImpl();
		MenuItem m=new MenuItem(3,"Pizza Mania",167, true,DateUtil.convertToDate("29/08/2018"),"Main Course",false);
		menuItemDao.modifyMenuItem(m);
		
	}
	public static void testGetMenuItem() throws ClassNotFoundException, IOException, SQLException
	{
		MenuItemDao menuItemDao= new MenuItemDaoSqlImpl();
		System.out.println("After Modification");
		MenuItem m=menuItemDao.getMenuItem(3);
		System.out.println(m.toString());
	}
	
	
}
