package com.booking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.booking.domain.CustomAppException;
import com.booking.enums.RoomStatusEnum;
import com.booking.model.Room;
import com.booking.model.RoomStatus;
import com.booking.model.UserBonus;
import com.booking.repository.RoomRepository;
import com.booking.repository.RoomStatusRepository;
import com.booking.repository.UserBonusRepository;
import com.booking.service.RoomBookingService;

@Service
public class RoomBookingServiceImpl implements RoomBookingService {
	
	@Autowired
	UserBonusRepository userBonusRepository;

	@Autowired
	RoomRepository roomRepository;
	
	@Autowired
	RoomStatusRepository roomStatusRepository;
	
	@Override
	public String bookRoom(Integer userId, Integer roomId) {
		
		UserBonus userBonus = userBonusRepository.getByUserId(userId).orElseThrow(() -> 
		new CustomAppException(HttpStatus.UNPROCESSABLE_ENTITY, "Incorrect UserId"));
		
		Room room = roomRepository.findById(roomId).orElseThrow(() -> 
		new CustomAppException(HttpStatus.UNPROCESSABLE_ENTITY, "Incorrect UserId"));
		
		List<RoomStatus> list = roomStatusRepository.findByRoomIdAndActiveFlag(roomId, "Y");
		RoomStatus roomStatus = null;
		if (list.size() >0) {
			/*
			 * 1. vacant :- status based on bonus points
			 * 2. pending approval :- status based on bonus points
			 * 3. booked :- No action needed
			 */
			roomStatus = list.get(0);
			
			if(RoomStatusEnum.PENDING_APPROVAL.getStatus().equals(roomStatus.getStatus()) &&
					 room.getPrice() <= userBonus.getBonusPoints()){
				roomStatus.setUserId(userBonus.getUserId());
				roomStatus.setStatus(RoomStatusEnum.BOOKED.getStatus());
			}else if(RoomStatusEnum.VACANT.getStatus().equals(roomStatus.getStatus())) {
				roomStatus.setUserId(userBonus.getUserId());
				roomStatus.setStatus( room.getPrice() <= userBonus.getBonusPoints() ? RoomStatusEnum.BOOKED.getStatus() 
						: RoomStatusEnum.PENDING_APPROVAL.getStatus());
			}else if(RoomStatusEnum.BOOKED.getStatus().equals(roomStatus.getStatus())) {
				return "Room is aleady booked!";
			}
		}else {
			/* New Room */
			roomStatus = initRoomStatus(userBonus,room);
		}
		
		if(roomStatus != null)
			roomStatusRepository.save(roomStatus);
		
		return "Booking Successfull!";
	}

	@Override
	public String vacantRoom(Integer roomId) {
		
		Room room = roomRepository.findById(roomId).orElseThrow(() -> 
		new CustomAppException(HttpStatus.UNPROCESSABLE_ENTITY, "Incorrect UserId"));
		
		List<RoomStatus> list = roomStatusRepository.findByRoomIdAndActiveFlag(roomId, "Y");
		
		if (list.size() > 0) {
			RoomStatus roomStatus = list.get(0);
			
			if(RoomStatusEnum.BOOKED.getStatus().equals(roomStatus.getStatus())) {
				UserBonus userBonus = userBonusRepository.getByUserId(roomStatus.getRoomId()).orElseThrow(() -> 
				new CustomAppException(HttpStatus.UNPROCESSABLE_ENTITY, "Incorrect UserId"));
				
				userBonus.setBonusPoints(userBonus.getBonusPoints() - room.getPrice());
				userBonusRepository.save(userBonus);
			}
			
			roomStatus.setUserId(null);
			roomStatus.setStatus(RoomStatusEnum.VACANT.getStatus());
			
			roomStatusRepository.save(roomStatus);
			
			return "Room checkout sucessfull!";
			
		}else {
			return "Room is alerady vacant!";
		}
	}
	
	private RoomStatus initRoomStatus(UserBonus userBonus, Room room) {
		
		RoomStatus roomStatus = new RoomStatus();
		roomStatus.setRoomId(room.getRoomKey());
		roomStatus.setUserId(userBonus.getUserId());
		roomStatus.setActiveFlag("Y");
		
		roomStatus.setStatus( room.getPrice() > userBonus.getBonusPoints() ? RoomStatusEnum.PENDING_APPROVAL.getStatus() : 
			RoomStatusEnum.BOOKED.getStatus());
		
		return roomStatus;
		
	}


}
