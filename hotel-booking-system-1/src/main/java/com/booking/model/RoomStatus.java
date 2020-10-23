package com.booking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TX_ROOM_STATUS")
public class RoomStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ROOM_STATUS_KEY")
	Integer roomStatusId;
	
	@Column(name = "key2tx_user_master")
	Integer userId;
	
	@Column(name = "key2tx_room_master")
	Integer roomId;
	
	@Column(name = "STATUS")
	String status;
	
	@Column(name = "ACTIVE_FLAG")
	String activeFlag;

	public Integer getRoomStatusId() {
		return roomStatusId;
	}

	public void setRoomStatusId(Integer roomStatusId) {
		this.roomStatusId = roomStatusId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}
}
