 CREATE TABLE `user` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `username` varchar(45) NOT NULL,
    `password` varchar(200) NOT NULL,
    `first_name` varchar(200) DEFAULT NULL,
    `last_name` varchar(200) DEFAULT NULL,
    `date_of_birth` date DEFAULT NULL,
    `email` varchar(45) DEFAULT NULL,
    `enabled` int(11) NOT NULL,
    `role` varchar(45) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `username` (`username`)
  ) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

INSERT IGNORE INTO `user` VALUES (NULL, 'admin', '12345', 'Admin' , 'Admin','2000-01-01', 'test@gamil.com', '1','Admin');
INSERT IGNORE INTO `user` VALUES (NULL, 'admin2', '12345', 'Admin' , 'Admin','2000-01-01', 'test@gamil.com', '1','Admin');