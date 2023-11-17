package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_Info")
public class Info implements Serializable{

	private static final long serialVersionUID = -7141419035239709511L;

	private long id;
	
	private int infolock;
	
	private String title;
	
	private String content;
	
	private Date createtime;
	
	private User user;
	
	private Bumen bumen;
	
	private String leixing;//规章制度，公司新闻，公司通知
	
	
	
	

	

	public String getLeixing() {
		return leixing;
	}

	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}



	public int getInfolock() {
		return infolock;
	}

	public void setInfolock(int infolock) {
		this.infolock = infolock;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@ManyToOne
	@JoinColumn(name="userid")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@ManyToOne
	@JoinColumn(name="bumenid")
	public Bumen getBumen() {
		return bumen;
	}

	public void setBumen(Bumen bumen) {
		this.bumen = bumen;
	}

	
	
}
