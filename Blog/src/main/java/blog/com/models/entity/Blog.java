package blog.com.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Blog {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long blogId;
	
	private String blogTitle;
	private String categoryName;
	/**
	 * @DateTimeFormat(pattern = "yyyy-MM-dd") Spring
	 * Frameworkアノテーションで、このフィールドが日付/時間の形式を持つことを示します。
	 */
	/*@DateTimeFormat(pattern = "yyyy-MM-dd")*/
	/*private LocalDate date;*/
	private String blogImage;
	private String article;
	private Long userId;
	
	//空のコンストラクタ
	public Blog() {
	}
	
	
	//コンストラクタ
	public Blog(String blogTitle, String categoryName, String blogImage, String article, Long userId) {
		this.blogTitle = blogTitle;
		this.categoryName = categoryName;
		this.blogImage = blogImage;
		this.article = article;
		this.userId = userId;
	}

	//get and set
	public Long getBlogId() {
		return blogId;
	}

	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getBlogImage() {
		return blogImage;
	}

	public void setBlogImage(String blogImage) {
		this.blogImage = blogImage;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
	
	
	
}
