package com.booking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TX_USER_BONUS")
public class UserBonus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "USER_BONUS_KEY")
	private Integer userBonusId;
	
	@Column(name = "key2tx_user_master")
	private Integer userId;
	
	@Column(name = "BONUS_POINTS")
	private Integer bonusPoints;

	public Integer getUserBonusId() {
		return userBonusId;
	}

	public void setUserBonusId(Integer userBonusId) {
		this.userBonusId = userBonusId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getBonusPoints() {
		return bonusPoints;
	}

	public void setBonusPoints(Integer bonusPoints) {
		this.bonusPoints = bonusPoints;
	}

}
