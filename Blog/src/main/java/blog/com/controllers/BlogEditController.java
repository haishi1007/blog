package blog.com.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	
	//編集画面の表示
	@GetMapping("/blog/edit/{blogId}")
	public String getBlogEditPage(@PathVariable Long blogId, Model model) {
		//sessionからログイン情報をaccountという変数に格納する
		Account account = (Account) session.getAttribute("loginUserInfo");
		//もし、account==null -->/user/login
		//そうでない
		//編集画面に表示させる情報を変数に格納
		if(account == null) {
			return "redirect:/user/login";
		}else {
			Blog blog = blogService.blogEditCheck(blogId);
			if(blog==null) {
				return "redirect:/blog/list";
			}else {
				model.addAttribute("blog",blog);
				return "blog_edit.html";
			}
		}
	}
	
	//更新処理
	@PostMapping("/blog/edit/process")
	public String blogUpdate(@RequestParam String blogTitle,
			@RequestParam String categoryName,
			@RequestParam MultipartFile blogImage,
			@RequestParam String article,
			@RequestParam Long blogId) {
		//sessionからログイン情報をaccountという変数に格納する
		Account account = (Account) session.getAttribute("loginUserInfo");
		//もし、account==null,戻ります
		//そうでない
		if(account == null) {
			return "redirect:/user/login";
		}else {
			//ファイル保存する
			String fileName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-").format(new Date())+blogImage.getOriginalFilename();
			try {
				Files.copy(blogImage.getInputStream(), Path.of("src/main/resources/static/blog-img/"+fileName));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//もし、blogUpdate-->true -->/blog/list
			//そうでない　ーー＞/blog/edit"+blogId
			if(blogService.blogUpdate(blogId, blogTitle, categoryName, fileName, article, account.getUserId())) {
				return "redirect:/blog/list";
			}else {
				return "redirect:/blog/edit"+blogId;
			}
		}
	}
	
}
