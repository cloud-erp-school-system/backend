package org.erp.school.model.requests;

import java.util.List;

public class RequestSummary {
	
	private RequestByStatus requestsByStatus;
	private List<ProposalByDay> newProposalsByDay;
	
	public List<ProposalByDay> getNewProposalsByDay() {
		return newProposalsByDay;
	}
	public void setNewProposalsByDay(List<ProposalByDay> newProposalsByDay) {
		this.newProposalsByDay = newProposalsByDay;
	}
	public RequestByStatus getRequestsByStatus() {
		return requestsByStatus;
	}
	public void setRequestsByStatus(RequestByStatus requestsByStatus) {
		this.requestsByStatus = requestsByStatus;
	}
	
}