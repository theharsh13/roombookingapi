package com.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.domain.Response;
import com.booking.service.RoomBookingService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController("roomBookingController")
@RequestMapping("/roomBooking")
public class RoomBookingController {
	
	@Autowired
	RoomBookingService roomBookingService;
	
	@ApiOperation(value = "Book a room for user.", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully books room for given user.") })
	@GetMapping(value = "/{userId}/{roomId}/book", produces = "application/json")
	public ResponseEntity<Response> bookRoom(@PathVariable("userId") Integer userId, @PathVariable("roomId") Integer roomId){
		return new ResponseEntity<>(new Response(roomBookingService.bookRoom(userId, roomId)) , HttpStatus.OK);
	}

	@ApiOperation(value = "vacant given room.", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully vacants given room.") })
	@GetMapping(value = "/{roomId}/vacant", produces = "application/json")
	public ResponseEntity<Response> vacantRoom(@PathVariable("roomId") Integer roomId){
		return new ResponseEntity<>(new Response(roomBookingService.vacantRoom(roomId)) , HttpStatus.OK);
	}
}
