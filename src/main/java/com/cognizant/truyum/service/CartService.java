package com.cognizant.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;
@Service("CartService")
public class CartService implements CartDao{
    @Autowired
    private CartDao cartDao;
    
    public List<MenuItem> getAllCartItems(long userId)  throws CartEmptyException {
        return null;
    }
    public void  setCartDao(CartDao cartDao) {
        
    }
    public void addCartItem(long userId, long menuItemId) {
        
    }
   public void removeCartItem(long userId,long menuItemId) {
       
   }
}
