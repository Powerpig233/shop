package com.mty.shop.controller;


import com.mty.shop.model.Admin;
import com.mty.shop.model.User;
import com.mty.shop.service.AdminService;
import com.mty.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * system operation controller
 */
@Controller
public class LoginController {

	// dependency injection
	@Autowired
	private AdminService adminService;
	@Autowired
	private UserService userService;

	/**
	 * login
	 */
	@RequestMapping(value = "/")
	public String gologin() {
		return "login";
	}


	/**
	 * enter the workbench
	 */
	@RequestMapping(value = "/workdest")
	public String workdest() {
		return "workdest";
	}

	/**
	 * go to home page
	 */
	@RequestMapping(value = "/index")
	public String index(HttpSession session) {
		return "index";
	}

	/**
	 * enter personal center
	 */
	@RequestMapping(value = "/profile")
	public String profile() {
		return "profile";
	}


	/**
	 * Log in
	 * Write the submitted data (username, password) to the Admin object
	 */
	@RequestMapping(value = "/login")
	@ResponseBody
	public String login(String username,String password,String type, Model model, HttpSession session) {
		Map mp = new HashMap();
		if(username.equals("") || password.equals("")){
			return "202";
		}
		if(type.equals("01")){
			mp.put("username",username);
			mp.put("password",password);
			List<Admin> admins = adminService.queryFilter(mp);
			if(admins!=null && admins.size()==1){
				session.setAttribute("userInfo", admins.get(0));
				session.setAttribute("type", "01");
			}else{
				return "201";
			}
		}else{
			mp.put("phone",username);
			mp.put("password",password);
			mp.put("type","02");
			List<User> users = userService.queryFilter(mp);
			if(users!=null && users.size()==1){
				session.setAttribute("userInfo", users.get(0));
				session.setAttribute("type", "02");
				return "203";
			}else{
				return "201";
			}
		}
		return "200";
	}

	/**
	 * sign out
	 */
	@RequestMapping(value = "/logout")
	public String loginOut(HttpSession session) {
		session.invalidate();
		return "logout";
	}

	/**
	 * go to register
	 */
	@GetMapping(value = "/register")
	public String register() {
		return "register";
	}



	/**
	 * Submit registration
	 */
	@PostMapping(value = "/register")
	@ResponseBody
	public String register(String phone,String password,String repassword,String type) {
		if(phone.equals("") || password.equals("") || repassword.equals("")){
			return "201";
		}
		if(!password.equals(repassword)){
			return "202";
		}
		if(!isMobile(phone)){
			return "205";
		}
		List<User> all = userService.findAll();
		for(int i=0;i<all.size();i++){
			if(all.get(i).getPhone().equals(phone)){
				return "204";
			}
		}
		User user = new User();
		user.setPhone(phone);
		user.setPassword(password);
		Date date = new Date();
		user.setCreateTime(date);
		int num = userService.addByCondition(user);
		if(num > 0){
			return "200";
		}else {
			return "203";
		}
	}


	/**
	 * Determine whether it is a mobile phone number
	 *
	 * @param mobile
	 * @return
	 */
	public static boolean isMobile(String mobile) {
		String regex = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$";
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(mobile);
		return m.matches();
	}


}
