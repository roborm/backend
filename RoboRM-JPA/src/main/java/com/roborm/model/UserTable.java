package com.roborm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userTable")
public class UserTable {
	private long userId;
	private String userName;
	private String userPassword;
	private String maritalStatus;
	private int denpendents;

	public UserTable() {

	}

	/**
	 * @param userId
	 * @param userName
	 * @param userPassword
	 * @param maritalStatus
	 * @param denpendents
	 */
	public UserTable(long userId, String userName, String userPassword, String maritalStatus, int denpendents) {
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.maritalStatus = maritalStatus;
		this.denpendents = denpendents;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Column(name = "user_name", nullable = false)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "user_passeord", nullable = false)
	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Column(name = "marital_status", nullable = false)
	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	@Column(name = "denpendents", nullable = false)
	public int getDenpendents() {
		return denpendents;
	}

	public void setDenpendents(int denpendents) {
		this.denpendents = denpendents;
	}

}
