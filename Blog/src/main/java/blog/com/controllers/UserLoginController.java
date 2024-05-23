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
	
	//sessionを使う
	@Autowired
	private HttpSession session;
	
	//ログイン画面の表示
	@GetMapping("/user/login")
	public String getUserLoginPage() {
		return "login.html";
	}
	
	
	//ログイン処理
	@PostMapping("/user/login/process")
	public String userLoginProcess(@RequestParam String userName,
			@RequestParam String password) {
		//loginCheckメソッドを呼び出した結果をaccountに格納する
		Account account = accountService.loginCheck(userName, password);
		//もし、account==null、login.htmlへ行く
		//そうでない
		//　"/blog/list"へ行く
		if(account == null) {
			return "login.html";
		}else {
			session.setAttribute("loginUserInfo", account);
			return "redirect:/blog/list";
		}
	}
	
}