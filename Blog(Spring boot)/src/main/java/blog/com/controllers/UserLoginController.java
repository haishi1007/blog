package blog.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import blog.com.models.entity.Account;
import blog.com.services.AccountService;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserLoginController {
	@Autowired
	private AccountService accountService;
	
	//use the session
	@Autowired
	private HttpSession session;
	
	//login page
	@GetMapping("/user/login")
	public String getUserLoginPage() {
		return "login.html";
	}
	
	//post the message
	@PostMapping("/user/login/process")
	public String userLoginProcess(@RequestParam String userName,
			@RequestParam String password) {
		Account account = accountService.loginCheck(userName, password);
		if(account == null) {
			return "login.html";
		}else {
			session.setAttribute("loginUserInfo", account);
			return "redirect:/blog/list";
		}
	}
	
}
