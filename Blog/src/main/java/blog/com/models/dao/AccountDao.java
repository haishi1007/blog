package blog.com.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import blog.com.models.entity.Account;

@Repository
public interface AccountDao extends JpaRepository<Account, Long> {

	//insert and update
	Account save(Account account);
	
	//register
	Account findByUserEmail(String userEmail);
	
	//for login
	Account findByUserNameAndPassword(String userName, String password);
	
	
}
