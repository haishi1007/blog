package blog.com.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import blog.com.models.entity.Blog;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public interface BlogDao extends JpaRepository<Blog, Long> {
	//insert and update
	Blog save(Blog blog);
	
	//show the blog list
	List<Blog>findAll();
	
	//blog register
	//select* FROM Blog WHERE blogTitle=?
	Blog findByBlogTitle(String blogTitle);
	
	//select* FROM Blog WHERE blogId=?
	//edit
	Blog findByBlogId(Long blogId);
	
	//delete
	void deleteByBlogId(Long blogId);
}
