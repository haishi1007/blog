package blog.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import blog.com.services.AccountService;

@Controller
public class UserRegisterController {
	@Autowired
	private AccountService accountService;
	
	//登録画面の表示
	@GetMapping("/user/register")
	public String getUserRegisterPage() {
		return "register.html";
	}
	
	//登録処理
	@PostMapping("/user/register/process")
	public String userRegisterProcess(@RequestParam String userName,
			@RequestParam String password,
			@RequestParam String userEmail) {
		//もし、createAccount-->true login.htmlへ行く
		//そうでない
		//register.htmlへ行く
		if(accountService.createAccount(userName, userEmail, password)) {
			return "login.html";
		}else {
			return "register.html";
		}
	}
}
