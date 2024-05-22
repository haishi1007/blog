package blog.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import blog.com.models.entity.Account;
import blog.com.models.entity.Blog;
import blog.com.services.BlogService;
import jakarta.servlet.http.HttpSession;

@Controller
public class BlogEditController {
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private HttpSession session;
	
	//show the edit page
	@GetMapping("/blog/edit/{blogId}")
	public String getBlogEditPage(@PathVariable Long productId, Model model) {
		Account account = (Account) session.getAttribute("loginUserInfo");
		if(account == null) {
			return "redirect:/user/login";
		}else {
			Blog blog = blogService.blogEditCheck(productId);
			if(blog==null) {
				return "redirect:/blog/list";
			}else {
				model.addAttribute("blog",blog);
				return "blog_edit.html";
			}
		}
	}
}
