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
@Table(name="t_Wendang")
public class Wendang implements Serializable{

	private static final long serialVersionUID = -7141419035239709511L;

	private long id;
	
	private int wendanglock;
	
	private String title;
	
	private String content;
	
	private Date createtime;
	
	private User user;
	
	private Bumen bumen;
	
	private String path;
	

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public int getWendanglock() {
		return wendanglock;
	}

	public void setWendanglock(int wendanglock) {
		this.wendanglock = wendanglock;
	}

	
	
	
}
