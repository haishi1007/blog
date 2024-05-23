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
	
	//blogListのチェック
	//もし、userId==null -->null
	//findAllの内容をコントローラークラスに渡す
	public List<Blog>selectAllBlogList(Long userId){
		if(userId == null) {
			return null;
		}else {
			return blogDao.findAll();
		}
	}
	
	//blog登録処理のチェック
	//fingByBlogTitle==null -->true 保存処理
	//そうでない　-->false
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
	
	//編集画面の表示のチェック
	//もし、blogId==null -->null
	//そうでない
	//findByBlogIdの情報をコントローラークラスに渡す
	public Blog blogEditCheck(Long blogId) {
		if(blogId == null) {
			return null;
		}else {
			return blogDao.findByBlogId(blogId);
		}
	}
	
	//更新処理のチェック
	//もしblogId==nullだったら、更新できない
	//false
	//そうでない
	//更新する
	public boolean blogUpdate(Long blogId, 
			String blogTitle,
			String categoryName,
			String blogImage,
			String article,
			Long userId) {
		if(blogId == null) {
			return false;
		}else {
			//更新する内容はblogに入れる
			Blog blog = blogDao.findByBlogId(blogId);
			blog.setBlogTitle(blogTitle);
			blog.setCategoryName(categoryName);
			blog.setBlogImage(blogImage);
			blog.setArticle(article);
			blog.setUserId(userId);
			//保存処理
			blogDao.save(blog);
			return true;
		}
	}
	
	//削除処理のチェック
	//もし、blogId==null 削除できない
	//あったら、削除する
	public boolean deleteBlog(Long blogId) {
		if(blogId == null) {
			return false;
		}else {
			blogDao.deleteByBlogId(blogId);
			return true;
		}
	}
}
