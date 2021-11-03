ALTER TABLE `room_sharing`.`districs`
CHANGE COLUMN `districs_id` `district_id` VARCHAR(36) NOT NULL , RENAME TO  `room_sharing`.`district` ;
