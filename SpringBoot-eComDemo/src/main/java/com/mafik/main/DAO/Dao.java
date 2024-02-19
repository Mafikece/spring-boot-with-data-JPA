package com.mafik.main.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.mafik.main.Model.Item;
import com.mafik.main.Model.User;
import com.mafik.main.Repository.ItemRepo;
import com.mafik.main.Repository.UserRepo;

@Component
public class Dao {
	
	@Autowired
	UserRepo ur;
	@Autowired
	ItemRepo ir;
	
	public User userCheck(String userName, String password) {
		User user = ur.findByUser(userName,password);
		return user;
	}
	
	
	public List<Item> viewAllItem() {
		List<Item> items = ir.findAll();
		System.out.println(items);
		return items;
	}


	public void relation(User user, int id) {
		User user2 = ur.findById(user.getUserId()).orElse(null);
		Item item = ir.findById(id).orElse(null);
		user2.getItem().add(item);
		ur.save(user2);
	}
}
