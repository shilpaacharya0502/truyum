package com.cognizant.truyum.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.cognizant.truyum.service.MenuItemService;

@Controller
public class MenuItemController {

        @Autowired
        private MenuItemService menuItemService;
        
        private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);
        
        @GetMapping(value="/show-menu-list-admin")
        public String showMenuItemListAdmin(ModelMap model) throws ClassNotFoundException, IOException, SQLException //throws SystemException
        {
            LOGGER.info("Start - showing admin menuItemList");
            model.addAttribute("menuItemList", menuItemService.getMenuItemListAdmin());
            LOGGER.info("End - admin menuItemList");
            return "menu-item-list-admin";        
        }
        
}
