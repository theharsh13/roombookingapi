package com.booking.repository.custom.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.booking.data.extractor.ActiveBookingsExtractor;
import com.booking.domain.RoomBookingDTO;
import com.booking.domain.UserBonusDTO;
import com.booking.repository.custom.IReportingRepository;

@Repository
public class ReportingRepositoryImpl implements IReportingRepository {

	@Autowired
	NamedParameterJdbcTemplate namedJdbcTemplate;
	
	@Override
	public List<RoomBookingDTO> getActiveBookings() {
		return namedJdbcTemplate.query(GET_ALL_ACTIVE_BOOKINGS, new ActiveBookingsExtractor());
	}

	@Override
	public List<UserBonusDTO> getAllUserBonusPoints() {
		return namedJdbcTemplate.query(GET_ALL_USERS_WITH_BONUS_POINTS, new ResultSetExtractor<List<UserBonusDTO>>() {

			@Override
			public List<UserBonusDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<UserBonusDTO> list = new ArrayList<>();
				while(rs.next()) {
					list.add(new UserBonusDTO(rs.getLong("user_key"), 
							rs.getString("username"), rs.getLong("bonus_points")));
				}
				return list;
			}
		});
	}

}
