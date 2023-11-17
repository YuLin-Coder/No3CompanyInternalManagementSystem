package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_Gongzuorizhi")
public class Gongzuorizhi implements Serializable{

	private static final long serialVersionUID = -7141419035239709511L;

	private long id;
	
	private String content;//工作安排
	
	private String shijian;//添加时间
	
	private String title;
	
	private User user;

	private int gongzuorizhilock;
	
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getShijian() {
		return shijian;
	}

	public void setShijian(String shijian) {
		this.shijian = shijian;
	}

	@ManyToOne
	@JoinColumn(name="userid")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getGongzuorizhilock() {
		return gongzuorizhilock;
	}

	public void setGongzuorizhilock(int gongzuorizhilock) {
		this.gongzuorizhilock = gongzuorizhilock;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	
	
}
