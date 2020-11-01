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
@Table(name = "liability")
public class Liability {
	private long liabilityId;
	private long userId;
	private double amt;
	
	private FinInst finInst;

	public Liability() {

	}

	/**
	 * @param liabilityId
	 * @param userId
	 * @param amt
	 */
	public Liability(long liabilityId, long userId, double amt) {
		this.liabilityId = liabilityId;
		this.userId = userId;
		this.amt = amt;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)		
	public long getLiabilityId() {
		return liabilityId;
	}

	public void setLiabilityId(long liabilityId) {
		this.liabilityId = liabilityId;
	}

	@Column(name = "user_id", nullable = false)
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
