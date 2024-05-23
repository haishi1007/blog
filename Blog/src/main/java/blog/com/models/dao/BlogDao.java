package blog.com.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import blog.com.models.entity.Blog;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public interface BlogDao extends JpaRepository<Blog, Long> {
	//保存処理と更新処理　insert and update
	Blog save(Blog blog);
	
	//blog　listを表示する
	List<Blog>findAll();
	
	//blog register
	//select* FROM Blog WHERE blogTitle=?
	Blog findByBlogTitle(String blogTitle);
	
	//select* FROM Blog WHERE blogId=?
	//編集の時、同じのblogIdがあるか
	Blog findByBlogId(Long blogId);
	
	//削除する時に使用する
	void deleteByBlogId(Long blogId);
}
