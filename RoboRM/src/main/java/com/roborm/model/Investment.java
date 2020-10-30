package com.roborm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "investment")
public class Investment {

	private long investmentId;
	private long userId;
	private double amt;

	public Investment() {

	}

	/**
	 * @param investmentId
	 * @param userId
	 * @param amt
	 */
	public Investment(long investmentId, long userId, double amt) {
		this.investmentId = investmentId;
		this.userId = userId;
		this.amt = amt;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getInvestmentId() {
		return investmentId;
	}

	public void setInvestmentId(long investmentId) {
		this.investmentId = investmentId;
	}

	@Column(name = "user_Id", nullable = false)
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Column(name = "amt", nullable = false)
	public double getAmt() {
		return amt;
	}

	public void setAmt(double amt) {
		this.amt = amt;
	}

}
