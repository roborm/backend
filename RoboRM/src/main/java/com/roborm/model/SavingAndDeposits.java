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
@Table(name = "savingAndDeposits")
public class SavingAndDeposits {
	
	private long savingId;
	private long userId;
	private long finInstId;
	private double balanceAmt;
	private double income;
	private double expense;
	
	public SavingAndDeposits() {}
	
	public SavingAndDeposits(long savingId, long userId, long finInstId, double balanceAmt, double income,
			double expense) {
		
		this.savingId = savingId;
		this.userId = userId;
		this.finInstId = finInstId;
		this.balanceAmt = balanceAmt;
		this.income = income;
		this.expense = expense;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public long getSavingId() {
		return savingId;
	}

	public void setSavingId(long savingId) {
		this.savingId = savingId;
	}

	@Column(name = "userId", nullable = false)
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Column(name = "finInstId", nullable = false)
	public long getFinInstId() {
		return finInstId;
	}

	public void setFinInstId(long finInstId) {
		this.finInstId = finInstId;
	}

	@Column(name = "balanceAmt", nullable = false)
	public double getBalanceAmt() {
		return balanceAmt;
	}

	public void setBalanceAmt(double balanceAmt) {
		this.balanceAmt = balanceAmt;
	}

	@Column(name = "income", nullable = false)
	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	@Column(name = "expense", nullable = false)
	public double getExpense() {
		return expense;
	}

	public void setExpense(double expense) {
		this.expense = expense;
	}
	
	

}
