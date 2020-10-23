package com.booking.enums;

public enum RoomStatusEnum {

	
	PENDING_APPROVAL("PENDING APPROVAL"),
	BOOKED("BOOKED"),
	VACANT("VACANT");

	private String status;
	
	RoomStatusEnum(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
