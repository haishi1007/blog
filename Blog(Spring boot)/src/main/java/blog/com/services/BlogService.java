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
	public List<Blog>selectAllBlogList(Long userId){
		if(userId == null) {
			return null;
		}else {
			return blogDao.findAll();
		}
	}
}
