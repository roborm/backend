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
@Table(name = "insurance")
public class Insurance {
	
	private long insuranceId;
	private long userId;
	private String insuranceType;
	private long finInstId;
	private double premiumAmt;
	private double sumAssured;
	private double hospitalBenefitAmt;
	private String coverage;
	
	public Insurance() {
	}

	public Insurance(long insuranceId, long userId, String insuranceType, long finInstId, double premiumAmt,
			double sumAssured, double hospitalBenefitAmt, String coverage) {
		
		this.insuranceId = insuranceId;
		this.userId = userId;
		this.insuranceType = insuranceType;
		this.finInstId = finInstId;
		this.premiumAmt = premiumAmt;
		this.sumAssured = sumAssured;
		this.hospitalBenefitAmt = hospitalBenefitAmt;
		this.coverage = coverage;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public long getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(long insuranceId) {
		this.insuranceId = insuranceId;
	}

	@Column(name = "userId", nullable = false)
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Column(name = "insuranceType", nullable = false)
	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	@Column(name = "finInstId", nullable = false)
	public long getFinInstId() {
		return finInstId;
	}


	public void setFinInstId(long finInstId) {
		this.finInstId = finInstId;
	}

	@Column(name = "premiumAmt", nullable = false)
	public double getPremiumAmt() {
		return premiumAmt;
	}

	
	public void setPremiumAmt(double premiumAmt) {
		this.premiumAmt = premiumAmt;
	}

	@Column(name = "sumAssured", nullable = false)
	public double getSumAssured() {
		return sumAssured;
	}

	public void setSumAssured(double sumAssured) {
		this.sumAssured = sumAssured;
	}

	@Column(name = "hospitalBenefitAmt", nullable = false)
	public double getHospitalBenefitAmt() {
		return hospitalBenefitAmt;
	}

	public void setHospitalBenefitAmt(double hospitalBenefitAmt) {
		this.hospitalBenefitAmt = hospitalBenefitAmt;
	}

	@Column(name = "coverage", nullable = false)
	public String getCoverage() {
		return coverage;
	}

	public void setCoverage(String coverage) {
		this.coverage = coverage;
	}

}
