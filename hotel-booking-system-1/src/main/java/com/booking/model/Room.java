package com.booking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TX_ROOM_MASTER")
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ROOM_KEY")
	private Integer roomKey;
	
	@Column(name = "ROOM_NAME")
	private String roomName;
	
	@Column(name = "price")
	private Integer price;

	public Integer getRoomKey() {
		return roomKey;
	}

	public void setRoomKey(Integer roomKey) {
		this.roomKey = roomKey;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
}
