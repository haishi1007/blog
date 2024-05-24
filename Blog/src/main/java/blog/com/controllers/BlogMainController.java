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
public class BlogMainController {
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private HttpSession session;
	
	//blogMain画面を取得
	@GetMapping("/blog/main/{blogId}")
	public String getMainPage(@PathVariable Long blogId, Model model) {
		//sessionからログインする人の情報を取得する
		Account account = (Account) session.getAttribute("loginUserInfo");
		//もし、account==null -->/user/login
		//そうでない　blogIdをチェックする
		//blogId==null -->redirect:/blog/list
		//blogIdある -->blog_main.html
		if(account == null) {
			return "redirect:/user/login";
		}else {
			Blog blog = blogService.blogEditCheck(blogId);
			if(blog==null) {
				return "redirect:/blog/list";
			}else {
				model.addAttribute("blog",blog);
				return "blog_main.html";
			}
		}
	}
}
