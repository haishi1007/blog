package blog.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserLogoutController {
	@Autowired
	private HttpSession session;
	
	//logout
	@GetMapping("/user/logout")
	public String userLogout() {
		session.invalidate();
		return "redirect:/user/login";
	}
}
