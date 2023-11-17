package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_Kaoqin")
public class Kaoqin implements Serializable{

	private static final long serialVersionUID = -7141419035239709511L;

	private long id;
	
	private int kaoqinlock;
	
	private User user;
	
	private String leixing;//上班登记，下班登记，请假登记，出差登记，外出登记
	
	private String beizhu;//备注
	
	private String shenhezhuangtai;//审核状态 未审核，审核通过，审核不通过
	
	private String shenhejieguo;
	
	private String createtime;

	

	public String getShenhejieguo() {
		return shenhejieguo;
	}

	public void setShenhejieguo(String shenhejieguo) {
		this.shenhejieguo = shenhejieguo;
	}

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getKaoqinlock() {
		return kaoqinlock;
	}

	public void setKaoqinlock(int kaoqinlock) {
		this.kaoqinlock = kaoqinlock;
	}

	@ManyToOne
	@JoinColumn(name="userid")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



	public String getLeixing() {
		return leixing;
	}

	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}

	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	public String getShenhezhuangtai() {
		return shenhezhuangtai;
	}

	public void setShenhezhuangtai(String shenhezhuangtai) {
		this.shenhezhuangtai = shenhezhuangtai;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	

	

	
	
	
}
