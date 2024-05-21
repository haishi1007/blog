package blog.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import blog.com.models.entity.Account;
import jakarta.servlet.http.HttpSession;

@Controller
public class BlogListController {
	@Autowired
	private HttpSession session;
	
	//show the blog list page
	@GetMapping("/blog/list")
	public String getBlogList() {
		Account account = (Account) session.getAttribute("loginUserInfo");
		if(account == null) {
			return "redirect:/user/login";
		}else {
			return "blog_list.html";
		}
	}
}
