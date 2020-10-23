package com.booking.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.booking.model.UserBonus;

public interface UserBonusRepository extends CrudRepository<UserBonus, Integer>{
	
	public Optional<UserBonus> getByUserId(Integer userId);

}
