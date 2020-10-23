package com.booking.repository.custom;

import java.util.List;

import com.booking.domain.RoomBookingDTO;
import com.booking.domain.UserBonusDTO;

public interface IReportingRepository {

	List<RoomBookingDTO> getActiveBookings();
	
	List<UserBonusDTO> getAllUserBonusPoints();
	
	
	public String GET_ALL_ACTIVE_BOOKINGS = 
			"select  " + 
			"rm.room_key, um.user_key,rm.room_name, um.username, rs.status  " + 
			"from  " + 
			"hotel_mgt.tx_room_status rs JOIN hotel_mgt.tx_room_master rm  " + 
			"ON rs.key2tx_room_master = rm.room_key  " + 
			"JOIN hotel_mgt.tx_user_master um  " + 
			"ON rs.key2tx_user_master = um.user_key  " + 
			"where rs.active_flag = 'Y'";
	
	public String GET_ALL_USERS_WITH_BONUS_POINTS = 
			"select um.user_key,um.username,ub.bonus_points " + 
			"from " + 
			"hotel_mgt.tx_user_master um JOIN hotel_mgt.tx_user_bonus ub  " + 
			"ON um.user_key = ub.key2tx_user_master";

}
