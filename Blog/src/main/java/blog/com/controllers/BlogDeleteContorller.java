package blog.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import blog.com.models.entity.Account;
import blog.com.services.BlogService;
import jakarta.servlet.http.HttpSession;

@Controller
public class BlogDeleteContorller {
	//BlogService導入
	@Autowired
	private BlogService blogService;
	
	//sessionを使うための準備
	@Autowired
	private HttpSession session;
	
	@PostMapping("/blog/delete/process")
	public String blogDelete(Long blogId) {
		//sessionからログイン情報をaccountという変数に格納する
		Account account = (Account) session.getAttribute("loginUserInfo");
		if(account == null) {
			return "redirect:/user/login";
			}else {
				//もし、deleteBlog==true、削除する
				//blogListへ行く
				//そうでない
				//blogEditへ行く
				if(blogService.deleteBlog(blogId)) {
					return "redirect:/blog/list";
				}else {
					return "redirect:/blog/edit"+blogId;
				}
			}
	}
}
