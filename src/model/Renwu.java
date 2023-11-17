package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_Renwu")
public class Renwu implements Serializable{

	private static final long serialVersionUID = -7141419035239709511L;

	private long id;
	
	private String content;//工作安排
	
	private String shijian;//完成时间
	
	private String title;//工作概述
	
	private User fromuser;
	
	private User touser;

	private int renwulock;
	
	private String wanchengqingkuang;//未完成 ，已完成
	
	private String wanchenghuibao;//完成汇报
	
	private String wanchengpingggu;//完成评估
	
	
	public String getWanchenghuibao() {
		return wanchenghuibao;
	}

	public void setWanchenghuibao(String wanchenghuibao) {
		this.wanchenghuibao = wanchenghuibao;
	}

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

	public int getRenwulock() {
		return renwulock;
	}

	public void setRenwulock(int renwulock) {
		this.renwulock = renwulock;
	}

	public String getWanchengqingkuang() {
		return wanchengqingkuang;
	}

	public void setWanchengqingkuang(String wanchengqingkuang) {
		this.wanchengqingkuang = wanchengqingkuang;
	}

	public String getWanchengpingggu() {
		return wanchengpingggu;
	}

	public void setWanchengpingggu(String wanchengpingggu) {
		this.wanchengpingggu = wanchengpingggu;
	}

	
	
	
}
