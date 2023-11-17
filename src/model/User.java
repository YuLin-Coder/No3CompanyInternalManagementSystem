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
@Table(name="t_User")
public class User implements Serializable{

	private static final long serialVersionUID = -7141419035239709511L;

	private long id;
	
	private String username;
	
	private String password;
	
	private Date createtime;
	
	private String truename;

	private int role;//2表总经理（系统管理员），1表示部门经理（部门管理员），0表示普通员工
	
	private int userlock;
	
	private String lianxidianhua;//联系电话
	
	private String sfz;//身份证
	
	private String zhuzhi;//住址
	
	private String xingbie;//性别
	
	private String ruzhishijian;//入职时间
	
	private String jianjie;//简介
	
	private Bumen bumen;//所属部门
	
	private Bumen bumen2;//部门管理员
	
	

	public int getUserlock() {
		return userlock;
	}

	public void setUserlock(int userlock) {
		this.userlock = userlock;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getTruename() {
		return truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getLianxidianhua() {
		return lianxidianhua;
	}

	public void setLianxidianhua(String lianxidianhua) {
		this.lianxidianhua = lianxidianhua;
	}

	public String getSfz() {
		return sfz;
	}

	public void setSfz(String sfz) {
		this.sfz = sfz;
	}

	public String getZhuzhi() {
		return zhuzhi;
	}

	public void setZhuzhi(String zhuzhi) {
		this.zhuzhi = zhuzhi;
	}

	public String getXingbie() {
		return xingbie;
	}

	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}

	public String getRuzhishijian() {
		return ruzhishijian;
	}

	public void setRuzhishijian(String ruzhishijian) {
		this.ruzhishijian = ruzhishijian;
	}

	public String getJianjie() {
		return jianjie;
	}

	public void setJianjie(String jianjie) {
		this.jianjie = jianjie;
	}

	@ManyToOne
	@JoinColumn(name="bumenid")
	public Bumen getBumen() {
		return bumen;
	}

	public void setBumen(Bumen bumen) {
		this.bumen = bumen;
	}

	@ManyToOne
	@JoinColumn(name="bumenid2")
	public Bumen getBumen2() {
		return bumen2;
	}

	public void setBumen2(Bumen bumen2) {
		this.bumen2 = bumen2;
	}
	
}
