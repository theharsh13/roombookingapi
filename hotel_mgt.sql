-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema hotel_mgt
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hotel_mgt
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hotel_mgt` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci ;
USE `hotel_mgt` ;

-- -----------------------------------------------------
-- Table `hotel_mgt`.`tx_room_master`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_mgt`.`tx_room_master` (
  `room_key` INT NOT NULL AUTO_INCREMENT,
  `room_name` VARCHAR(45) NULL DEFAULT NULL,
  `price` INT NOT NULL,
  PRIMARY KEY (`room_key`),
  UNIQUE INDEX `room_key_UNIQUE` (`room_key` ASC)  )
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_general_ci
COMMENT = 'Stores master data of rooms.';


-- -----------------------------------------------------
-- Table `hotel_mgt`.`tx_user_master`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_mgt`.`tx_user_master` (
  `user_key` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`user_key`),
  UNIQUE INDEX `user_key_UNIQUE` (`user_key` ASC)  )
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE =  utf8mb4_general_ci;


-- -----------------------------------------------------
-- Table `hotel_mgt`.`tx_room_status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_mgt`.`tx_room_status` (
  `room_status_key` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `key2tx_user_master` INT NULL DEFAULT NULL,
  `key2tx_room_master` INT NULL DEFAULT NULL,
  `status` VARCHAR(45) NULL DEFAULT NULL,
  `active_flag` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`room_status_key`),
  INDEX `user_key_ref2_idx` (`key2tx_user_master` ASC)  ,
  INDEX `room_key_ref_idx` (`key2tx_room_master` ASC)  ,
  CONSTRAINT `room_key_ref`
    FOREIGN KEY (`key2tx_room_master`)
    REFERENCES `hotel_mgt`.`tx_room_master` (`room_key`),
  CONSTRAINT `user_key_ref2`
    FOREIGN KEY (`key2tx_user_master`)
    REFERENCES `hotel_mgt`.`tx_user_master` (`user_key`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE =  utf8mb4_general_ci;


-- -----------------------------------------------------
-- Table `hotel_mgt`.`tx_user_bonus`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel_mgt`.`tx_user_bonus` (
  `user_bonus_key` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `key2tx_user_master` INT NULL DEFAULT NULL,
  `bonus_points` INT NULL DEFAULT NULL,
  PRIMARY KEY (`user_bonus_key`),
  INDEX `key2tx_user_master_idx` (`key2tx_user_master` ASC)  ,
  CONSTRAINT `user_key_ref`
    FOREIGN KEY (`key2tx_user_master`)
    REFERENCES `hotel_mgt`.`tx_user_master` (`user_key`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE =  utf8mb4_general_ci;

INSERT INTO `tx_room_master` VALUES (1,'delux-1',1000),(2,'delux-2',2000),(3,'suite-1',3000),(4,'suite-2',4000);
INSERT INTO `tx_user_master` VALUES (1,'amit'),(2,'yash'),(3,'ramesh'),(4,'dhiraj');
INSERT INTO `tx_user_bonus` VALUES (1,1,2000),(2,2,4000),(3,3,6000),(4,4,8000);




SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
