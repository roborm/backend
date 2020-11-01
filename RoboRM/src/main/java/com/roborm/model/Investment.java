package com.roborm.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "investment")
public class Investment {

	private long investmentId;
	private long userId;
	private double amt;
	
	private FinInst finInst;

	public Investment() {

	}

	/**
	 * @param investmentId
	 * @param userId
	 * @param amt
	 */
	
	public Investment(long investmentId, long userId, double amt, FinInst finInst) {
		this.investmentId = investmentId;
		this.userId = userId;
		this.amt = amt;
		this.finInst = finInst;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getInvestmentId() {
		return investmentId;
	}

	public void setInvestmentId(long investmentId) {
		this.investmentId = investmentId;
	}

	@Column(name = "userId", nullable = false)
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

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "finInstId", referencedColumnName = "finInstId")
	public FinInst getFinInst() {
		return finInst;
	}

	public void setFinInst(FinInst finInst) {
		this.finInst = finInst;
	}

}
