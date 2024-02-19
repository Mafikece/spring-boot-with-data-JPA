package com.mafik.main.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.mafik.main.DAO.Dao;
import com.mafik.main.Model.Item;
import com.mafik.main.Repository.ItemRepo;

@Controller
public class ItemController {
	@Autowired
	ItemRepo ir;
	@Autowired
	Dao dao;
	
	@GetMapping("/Items")
	public String itemAdd() {
		return "itemForm";
	}
	
	@GetMapping("/saveItems")
	public String saveItems(@ModelAttribute Item item) {
		 Item item2 = ir.save(item);
		return "itemSave";
	}
	/*
	 * @GetMapping("/viewAllItem") public String viewAllItem(Model model) {
	 * List<Item> allItem = dao.viewAllItem(); System.out.println(allItem);
	 * model.addAttribute("item", allItem); return "loginSuccess";
	 * 
	 * }
	 */
}
