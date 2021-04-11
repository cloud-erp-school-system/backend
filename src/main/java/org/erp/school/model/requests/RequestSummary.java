package org.erp.school.model.requests;

import java.time.DayOfWeek;
import java.util.Map;

public class RequestSummary {
	
	private Integer totalRequestsReceived;
	private Map<RequestStatus, Integer> requestsByStatus;
	private Map<DayOfWeek, Integer> newProposalsByDay;

	public Integer getTotalRequestsReceived() {
		return totalRequestsReceived;
	}
	public void setTotalRequestsReceived(int totalRequestsReceived) {
		this.totalRequestsReceived = totalRequestsReceived;
	}
	public Map<RequestStatus, Integer> getRequestsByStatus() {
		return requestsByStatus;
	}
	public void setRequestsByStatus(Map<RequestStatus, Integer> requestsByStatus) {
		this.requestsByStatus = requestsByStatus;
	}
	public Map<DayOfWeek, Integer> getNewProposalsByDay() {
		return newProposalsByDay;
	}
	public void setNewProposalsByDay(Map<DayOfWeek, Integer> newProposalsByDay) {
		this.newProposalsByDay = newProposalsByDay;
	}
	
}