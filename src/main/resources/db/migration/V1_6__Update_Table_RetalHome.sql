ALTER TABLE `room_sharing`.`rental_home`
ADD COLUMN `roomType` ENUM('Room', 'House') NULL DEFAULT NULL AFTER `room_id`;
