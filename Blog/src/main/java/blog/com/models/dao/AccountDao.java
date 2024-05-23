package blog.com.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import blog.com.models.entity.Account;

@Repository
public interface AccountDao extends JpaRepository<Account, Long> {

	//保存処理と更新処理insert and update
	Account save(Account account);
	
	//登録の時、同じメールができない
	Account findByUserEmail(String userEmail);
	
	//ログインの時、userNameとpasswordの一致性のために
	Account findByUserNameAndPassword(String userName, String password);
	
	
}
