package com.roborm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "finInst")
public class FinInst {

	private long finInstId;
	private String finInstName;
	private String finInstType;

	public FinInst() {

	}

	public FinInst(long finInstId, String finInstName, String finInstType) {

		this.finInstId = finInstId;
		this.finInstName = finInstName;
		this.finInstType = finInstType;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getFinInstId() {
		return finInstId;
	}

	public void setFinInstId(long finInstId) {
		this.finInstId = finInstId;
	}

	@Column(name = "fininst_name", nullable = false)
	public String getFinInstName() {
		return finInstName;
	}

	public void setFinInstName(String finInstName) {
		this.finInstName = finInstName;
	}

	@Column(name = "fininst_type", nullable = false)
	public String getFinInstType() {
		return finInstType;
	}

	public void setFinInstType(String finInstType) {
		this.finInstType = finInstType;
	}

}
