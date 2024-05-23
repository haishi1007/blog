package blog.com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog.com.models.dao.AccountDao;
import blog.com.models.entity.Account;

@Service
public class AccountService {
	@Autowired
	private AccountDao accountDao;
	
	//登録のために
	//もし、userName==null
	//accountDaoに登録者のデータを保存する　true
	//そうでない
	//false
	public boolean createAccount(String userName,
			String userEmail,
			String password) {
		if(accountDao.findByUserEmail(userEmail)==null) {
			accountDao.save(new Account(userName, userEmail, password));
			return true;
		}else {
			return false;
		}
	}
	
	//ログイン
	//もし、userNameとpasswordが存在しないーー＞null
	//そうでない
	//ログイン情報をコントローラークラスに渡す
	public Account loginCheck(String userName, String password) {
		Account account = accountDao.findByUserNameAndPassword(userName, password);
		if(account==null) {
			return null;
		}else {
			return account;
		}
	}
}
