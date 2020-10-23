package com.booking.service;

public interface RoomBookingService {
	
	public String bookRoom(Integer userId, Integer roomId);

	public String vacantRoom(Integer roomId);

}
