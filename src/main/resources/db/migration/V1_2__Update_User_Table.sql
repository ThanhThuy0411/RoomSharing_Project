ALTER TABLE `room_sharing`.`users`
CHANGE COLUMN `user_name` `user_name` VARCHAR(50) NULL ,
DROP PRIMARY KEY,
ADD PRIMARY KEY (`user_id`);
;
