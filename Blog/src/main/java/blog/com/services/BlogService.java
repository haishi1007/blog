package blog.com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog.com.models.dao.BlogDao;
import blog.com.models.entity.Blog;

@Service
public class BlogService {
	@Autowired
	private BlogDao blogDao;
	
	//blog list
	public List<Blog>selectAllBlogList(Long userId){
		if(userId == null) {
			return null;
		}else {
			return blogDao.findAll();
		}
	}
	
	//blog register
	public boolean createBlog(String blogTitle,
			String categoryName,
			String blogImage,
			String article,
			Long userId) {
		if(blogDao.findByBlogTitle(blogTitle)==null) {
			blogDao.save(new Blog(blogTitle,categoryName,blogImage,article,userId));
			return true;
		}else {
			return false;
		}
	}
	
	//check when you want to edit the blog
	public Blog blogEditCheck(Long blogId) {
		if(blogId == null) {
			return null;
		}else {
			return blogDao.findByBlogId(blogId);
		}
	}
}
