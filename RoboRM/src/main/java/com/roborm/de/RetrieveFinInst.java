package com.roborm.de;

import com.roborm.model.FinInst;

public class RetrieveFinInst {
	
	private FinInst finInst;
	private long finInstId;

	public FinInst getdetails()
	{
		
		finInstId=2;
		
		finInst.setFinInstId(finInstId);
		
		
		return finInst;
	}
}
