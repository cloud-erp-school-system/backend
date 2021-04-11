package org.erp.school.model.requests;

import java.time.DayOfWeek;

public class ProposalByDay {
	
	private DayOfWeek day;
	private int totalNewProposals;
	
	public DayOfWeek getDay() {
		return day;
	}
	public void setDay(DayOfWeek day) {
		this.day = day;
	}
	public int getTotalNewProposals() {
		return totalNewProposals;
	}
	public void setTotalNewProposals(int totalNewProposals) {
		this.totalNewProposals = totalNewProposals;
	}
	
}