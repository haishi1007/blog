package blog.com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog.com.models.dao.AccountDao;
import blog.com.models.entity.Account;

@Service
public class AccountService {
	@Autowired
	private AccountDao accountDao;
	
	//register
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
	
	//login
	public Account loginCheck(String userName, String password) {
		Account account = accountDao.findByUserNameAndPassword(userName, password);
		if(account==null) {
			return null;
		}else {
			return account;
		}
	}
}
