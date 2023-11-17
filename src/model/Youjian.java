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
@Table(name="t_Youjian")
public class Youjian implements Serializable{

	private static final long serialVersionUID = -7141419035239709511L;

	private long id;
	
	private String content;//
	
	private Date createtime;
	
	private String title;//
	
	private User fromuser;
	
	private User touser;

	private int youjianlock;
	
	private String readzhuangtai;//未阅读 ，已阅读
	
	
	
	
	

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

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@ManyToOne
	@JoinColumn(name="fromuserid")
	public User getFromuser() {
		return fromuser;
	}

	public void setFromuser(User fromuser) {
		this.fromuser = fromuser;
	}

	@ManyToOne
	@JoinColumn(name="touserid")
	public User getTouser() {
		return touser;
	}

	public void setTouser(User touser) {
		this.touser = touser;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public int getYoujianlock() {
		return youjianlock;
	}

	public void setYoujianlock(int youjianlock) {
		this.youjianlock = youjianlock;
	}

	public String getReadzhuangtai() {
		return readzhuangtai;
	}

	public void setReadzhuangtai(String readzhuangtai) {
		this.readzhuangtai = readzhuangtai;
	}

	

	
	
	
}
