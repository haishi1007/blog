package blog.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserLogoutController {
	@Autowired
	private HttpSession session;
	
	//logout画面の表示
	@GetMapping("/user/logout")
	public String userLogout() {
		//session無効化
		session.invalidate();
		return "redirect:/user/login";
	}
}
