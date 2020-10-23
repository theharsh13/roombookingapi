package com.booking.domain;

public class UserBonusDTO {

	Long userId;
	
	String userName;
	
	Long bonusPoints;

	public UserBonusDTO(Long userId, String userName, Long bonusPoints) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.bonusPoints = bonusPoints;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getBonusPoints() {
		return bonusPoints;
	}

	public void setBonusPoints(Long bonusPoints) {
		this.bonusPoints = bonusPoints;
	}
	
	
}
