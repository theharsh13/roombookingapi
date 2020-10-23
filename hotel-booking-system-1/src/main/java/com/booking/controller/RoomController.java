package com.booking.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.model.Room;
import com.booking.repository.RoomRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController("roomController")
@RequestMapping("/room")
public class RoomController {
	
	@Autowired
	RoomRepository roomRepository;
	
	@ApiOperation(value = "get all rooms available.", response = Room.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully returns all rooms available.") })
	@GetMapping(value = "/list", produces = "application/json")
	public ResponseEntity<List<Room>> getProductLevelSourceModifiers(){
		return new ResponseEntity<>(new ArrayList<>(roomRepository.findAll()), HttpStatus.OK);
	}
	
}
