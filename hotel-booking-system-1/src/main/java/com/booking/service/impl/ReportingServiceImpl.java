package com.booking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.domain.RoomBookingDTO;
import com.booking.domain.UserBonusDTO;
import com.booking.repository.custom.IReportingRepository;
import com.booking.service.ReportingService;

@Service("reportingService")
public class ReportingServiceImpl implements ReportingService {

	@Autowired
	IReportingRepository reportingRepository;
	
	@Override
	public List<RoomBookingDTO> getActiveBookingsReport() {		
		return reportingRepository.getActiveBookings();
	}

	@Override
	public List<UserBonusDTO> getUsersWithBonusPoints() {
		return reportingRepository.getAllUserBonusPoints();
	}

}
