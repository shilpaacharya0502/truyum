package com.cognizant.truyum.dao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl implements CartDao
{
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException, ClassNotFoundException, IOException, SQLException
	{
		Connection con=ConnectionHandler.getConnection();
		Cart cart=new Cart(new ArrayList<MenuItem>(),0);
		String sql="select me_id,me_name,me_price,me_active,me_dol from cart INNER JOIN menu_item on cart.ct_menu_id=menu_item.me_id WHERE cart.ct_user_id=?;";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setLong(1, userId);
		ResultSet rs=ps.executeQuery();
		while (rs.next()) 
		{ 
			MenuItem m=new MenuItem(rs.getLong(1),rs.getString(2),rs.getFloat(3),rs.getBoolean(4),rs.getDate(5), sql, false);
			cart.getMenuItemList().add(m);
		}
		String sql1="select sum(me_price) from menu_item INNER JOIN cart on cart.ct_menu_id=menu_item.me_id WHERE cart.ct_user_id=?;";
		PreparedStatement pstmt=con.prepareStatement(sql1);
		pstmt.setLong(1, userId);
		rs=pstmt.executeQuery();
		rs.next();
		cart.setTotal(rs.getDouble(1));
		return cart.getMenuItemList();
	}
	
	public void addCartItem(long userId ,long menuItemId) throws ClassNotFoundException, IOException, SQLException
	{
		Connection con=ConnectionHandler.getConnection();
		String sql="INSERT INTO cart(ct_user_id,ct_menu_id) values(?,?);";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setLong(1, userId);
		ps.setLong(2, menuItemId);
		ps.executeUpdate();
		
	}
	public void removeCartItem( long userId,long menuItemId) throws ClassNotFoundException, IOException, SQLException
	{
		Connection con=ConnectionHandler.getConnection();
		String sql="DELETE from cart where ct_user_id=? and ct_menu_Id=?;";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setLong(1, userId);
		ps.setLong(2, menuItemId);
		ps.executeUpdate();
	}
}
