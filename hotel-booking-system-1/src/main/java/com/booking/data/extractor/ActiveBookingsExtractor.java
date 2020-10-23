package com.booking.data.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.booking.domain.RoomBookingDTO;

public class ActiveBookingsExtractor implements ResultSetExtractor<List<RoomBookingDTO>>{

	@Override
	public List<RoomBookingDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		List<RoomBookingDTO> list = new ArrayList<>();
		
		while(rs.next()) {
			
			list.add(new RoomBookingDTO(rs.getLong("user_key"), rs.getString("username"), 
					rs.getLong("room_key"), rs.getString("room_name"), rs.getString("status")));
		}
		
		
		return list;
	}

}
