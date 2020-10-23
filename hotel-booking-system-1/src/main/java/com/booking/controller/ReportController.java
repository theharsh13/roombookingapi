package com.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.domain.RoomBookingDTO;
import com.booking.domain.UserBonusDTO;
import com.booking.service.ReportingService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController("reportController")
@RequestMapping("/reports")
public class ReportController {

	@Autowired
	ReportingService reportingService;
	
	@ApiOperation(value = "Get Active booking of rooms", response = RoomBookingDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully returns active bookings of the rooms.") })
	@GetMapping("/getActiveBookings")
	public ResponseEntity<List<RoomBookingDTO>> getRoomBookingStatusReport(){
		return new ResponseEntity<>(reportingService.getActiveBookingsReport(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "get users with their bonus points balance", response = UserBonusDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully saved global level source modifiers.") })
	@GetMapping("/getAllUsersWithBonusPoints")
	public ResponseEntity<List<UserBonusDTO>> getAllUsersWithBonusPoints(){
		return new ResponseEntity<>(reportingService.getUsersWithBonusPoints(), HttpStatus.OK);
	}
}
