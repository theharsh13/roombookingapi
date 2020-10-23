package com.booking.domain;

public class RoomBookingDTO {
	
	Long userId;
	
	String userName;
	
	Long roomId;
	
	String roomName;
	
	String roomStatus;

	public RoomBookingDTO(Long userId, String userName, Long roomId, String roomName, String roomStatus) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.roomId = roomId;
		this.roomName = roomName;
		this.roomStatus = roomStatus;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}

}
