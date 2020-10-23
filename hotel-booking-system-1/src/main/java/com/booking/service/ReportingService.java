package com.booking.service;

import java.util.List;

import com.booking.domain.RoomBookingDTO;
import com.booking.domain.UserBonusDTO;

public interface ReportingService {

		List<RoomBookingDTO> getActiveBookingsReport();

		List<UserBonusDTO> getUsersWithBonusPoints();

}
