package org.erp.school.model.requests;

public class RequestByStatus {
	
	private int totalRequestsReceived;
	private int totalUnderReview;
	private int totalPending;
	private int totalVerified;
	private int totalReverted;
	
	public int getTotalRequestsReceived() {
		return totalRequestsReceived;
	}
	public void setTotalRequestsReceived(int totalRequestsReceived) {
		this.totalRequestsReceived = totalRequestsReceived;
	}
	public int getTotalUnderReview() {
		return totalUnderReview;
	}
	public void setTotalUnderReview(int totalUnderReview) {
		this.totalUnderReview = totalUnderReview;
	}
	public int getTotalPending() {
		return totalPending;
	}
	public void setTotalPending(int totalPending) {
		this.totalPending = totalPending;
	}
	public int getTotalVerified() {
		return totalVerified;
	}
	public void setTotalVerified(int totalVerified) {
		this.totalVerified = totalVerified;
	}
	public int getTotalReverted() {
		return totalReverted;
	}
	public void setTotalReverted(int totalReverted) {
		this.totalReverted = totalReverted;
	}

}