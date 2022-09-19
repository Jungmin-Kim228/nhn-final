CREATE TABLE IF NOT EXISTS `final_exam9`.`Books` (
     `book_id`	BIGINT	NOT NULL AUTO_INCREMENT,
     `room_id`	BIGINT	NOT NULL,
     `user_id`	BIGINT	NOT NULL,
     `booked_at` DATE   NOT NULL,
     `check_in`	DATE	NOT NULL,
     `check_out`	DATE	NOT NULL,
     PRIMARY KEY (`book_id`),
    CONSTRAINT `fk_Books_Rooms`
    FOREIGN KEY (`room_id`)
    REFERENCES `final_exam9`.`Rooms` (`room_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

