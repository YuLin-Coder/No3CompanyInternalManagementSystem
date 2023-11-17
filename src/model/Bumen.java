package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_Bumen")
public class Bumen implements Serializable{

	private static final long serialVersionUID = -7141419035239709511L;

	private long id;
	
	private String bumenming;//部门名称
	
	private String jianjie;//部门简介
	
	private String dianhua;//部门联系电话
	
	private int bumenlock;
	
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBumenming() {
		return bumenming;
	}

	public void setBumenming(String bumenming) {
		this.bumenming = bumenming;
	}

	public String getJianjie() {
		return jianjie;
	}

	public void setJianjie(String jianjie) {
		this.jianjie = jianjie;
	}

	public String getDianhua() {
		return dianhua;
	}

	public void setDianhua(String dianhua) {
		this.dianhua = dianhua;
	}

	public int getBumenlock() {
		return bumenlock;
	}

	public void setBumenlock(int bumenlock) {
		this.bumenlock = bumenlock;
	}

	
	
}
