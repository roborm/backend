package com.roborm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "asset")
public class Asset {

	private long assetId;
	private long userId;
	private double amt;

	public Asset() {

	}

	public Asset(long assetId, long userId, double amt) {
		super();
		this.assetId = assetId;
		this.userId = userId;
		this.amt = amt;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getAssetId() {
		return assetId;
	}

	public void setAssetId(long assetId) {
		this.assetId = assetId;
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

}
