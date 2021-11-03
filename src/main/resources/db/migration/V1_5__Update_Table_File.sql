ALTER TABLE `room_sharing`.`file`
ADD COLUMN `fileId` VARCHAR(36) NOT NULL FIRST,
ADD PRIMARY KEY (`fileId`),
ADD UNIQUE INDEX `fileId_UNIQUE` (`fileId` ASC) VISIBLE;