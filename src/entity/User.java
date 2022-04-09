package entity;

import java.io.Serializable;

/**
 * 实体类
 */
public class User implements Serializable {
	private Integer id;
	private String userName;
	private String pwd;
	private String gender;
	private String category;
	private String interest;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public String getPwd() {
		return pwd;
	}

	public String getGender() {
		return gender;
	}

	public String getCategory() {
		return category;
	}

	public String getInterest() {
		return interest;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}
}
