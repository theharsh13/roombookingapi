package com.booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.model.RoomStatus;

public interface RoomStatusRepository extends JpaRepository<RoomStatus, Integer>{
	
	//List<RoomStatus> findByRoomIdInAndUserIdInAndActiveFlagIn(Integer roomId, Integer userId, String active_flag);
	List<RoomStatus> findByRoomIdAndActiveFlag(Integer roomId, String active_flag);

}
