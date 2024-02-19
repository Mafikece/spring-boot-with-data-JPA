package com.mafik.main.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mafik.main.DAO.Dao;
import com.mafik.main.Model.Item;
import com.mafik.main.Model.User;
import com.mafik.main.Repository.UserRepo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	UserRepo ur;
	@Autowired
	Dao dao;
	@GetMapping("/index")
	public String indexPage() {
		return "index";
	}
	
	@GetMapping("/Login")
	public String login() {
		return "loginForm";
	}
	
	@GetMapping("/userLoggedIn")
	public String userLoggedIn(@RequestParam String userName, @RequestParam String password, Model m, HttpServletRequest request) {
		User user = dao.userCheck(userName, password);
		if (user != null) {
			
			HttpSession session = request.getSession(true);
			session.setAttribute("u", user);
			
			m.addAttribute("m1", user);
			List<Item> viewAllItem = dao.viewAllItem();
			m.addAttribute("item", viewAllItem);
			return "loginSuccess";
					
		} else {
			return "loginFailed";
		}
	}
	
	@GetMapping("/Logout")
	public String logout(HttpServletRequest request ) {
		HttpSession session1 = request.getSession(false);
		session1.invalidate();
		return "logout";
	}
	
	@GetMapping("/addToCart/{id}")
	public String cart(@PathVariable int id,HttpServletRequest request, Model m ) {
		HttpSession session2 = request.getSession(false);
		User user = (User) session2.getAttribute("u");
		
		dao.relation(user,id);
		
		m.addAttribute("mKey", user);
		return "cart";
	}
	

	@GetMapping("/Registration")
	public String registration() {
		return "registrationForm";		
	}
	@GetMapping("/userRegistration")
	public String userRegistration(@ModelAttribute User user) {
		ur.save(user);
		System.out.println(user);
		return "userRegistration";
	}
	
	@GetMapping("/viewUsers")
	public ModelAndView viewUsers() {
		List<User> users = ur.findAll();
		return new ModelAndView("viewAll","list",users);
	}
	
	
}
