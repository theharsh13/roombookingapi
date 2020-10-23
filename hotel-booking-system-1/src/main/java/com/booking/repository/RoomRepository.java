package com.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.model.Room;

public interface RoomRepository extends JpaRepository<Room, Integer>{

}
