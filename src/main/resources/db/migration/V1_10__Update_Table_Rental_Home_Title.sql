ALTER TABLE `room_sharing`.`rental_home` 
ADD COLUMN `title` VARCHAR(1024) NULL DEFAULT NULL AFTER `date`;
