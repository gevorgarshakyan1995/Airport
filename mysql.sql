/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 10.4.22-MariaDB : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `test`;

/*Table structure for table `airplane` */

DROP TABLE IF EXISTS `airplane`;

CREATE TABLE `airplane` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `city_arrival` varchar(255) DEFAULT NULL,
  `city_departune` varchar(255) DEFAULT NULL,
  `flight_no` varchar(255) NOT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `time_arrivel` time DEFAULT NULL,
  `time_depature` time DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_nfw0237kqficmvkpkfca9otg7` (`flight_no`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=latin1;

/*Data for the table `airplane` */

insert  into `airplane`(`id`,`city_arrival`,`city_departune`,`flight_no`,`remarks`,`time_arrivel`,`time_depature`) values 
(1,'london','Madrid','pe65','ON_TIME','15:10:00','11:53:00'),
(2,'Moscow','barcelona','pk65','DELAYYED','16:53:16','12:53:16'),
(3,'Madrid','london','pk75','DELAYYED','15:43:16','10:53:16'),
(5,'barcelona','Manchester','pi75','ON_TIME','15:53:10','14:53:16'),
(6,'Yerevan','Madrid','555pk','CANCELLED','11:01:00','10:10:10'),
(14,'london','Moscow','k5080','ON_TIME','10:10:00','10:00:10'),
(15,'Yerevan','barcelona','pz555','ON_TIME','23:00:00','22:20:20'),
(16,'Manchester','Moscow','pz777','CANCELLED','13:00:00','15:30:30'),
(17,'New York','Tbilisi','p775','CANCELLED','15:53:16','10:53:16'),
(18,'Tbilisi','New York','p675','CANCELLED','14:53:16','10:53:16'),
(19,'Tbilisi','london','p605','ON_TIME','17:53:16','10:00:16'),
(20,'Tbilisi','Moscow','NN605','ON_TIME','17:53:16','12:00:16'),
(21,'Tbilisi','barcelona','N0005','ON_TIME','10:53:16','02:00:16'),
(22,'Tbilisi','Madrid','N0015','ON_TIME','15:50:00','02:00:00'),
(23,'New York','Madrid','Nk015','CANCELLED','13:50:00','03:00:00'),
(25,'New York','london','Nk115','ON_TIME','13:50:00','04:30:00'),
(26,'New York','Moscow','No115','ON_TIME','13:50:00','09:30:00'),
(27,'New York','Yerevan','No119','ON_TIME','14:50:00','10:30:00'),
(28,'New York','Berlin','No209','DELAYYED','14:50:00','10:30:00'),
(29,'Berlin','Tbilisi','No09','ON_TIME','14:50:00','11:30:00'),
(30,'Berlin','New York','No99','ON_TIME','19:50:00','11:30:00'),
(31,'Berlin','london','No399','DELAYYED','19:50:00','12:30:00'),
(32,'barcelona','Berlin','No309','ON_TIME','18:50:00','12:30:00'),
(33,'barcelona','Paris','NKK09','ON_TIME','18:50:00','13:30:00'),
(34,'Paris','Yerevan','NK99','CANCELLED','15:50:00','12:30:00'),
(35,'Paris','Roma','Ns089','CANCELLED','20:50:00','12:10:00'),
(36,'Roma','Yerevan','N1009','DELAYYED','21:50:00','18:00:00'),
(37,'Roma','New York','N909','ON_TIME','20:20:00','10:00:00'),
(38,'Roma','Madrid','N901','ON_TIME','23:00:00','10:00:00'),
(39,'Roma','barcelona','N911','ON_TIME','23:50:00','17:00:00'),
(40,'Yerevan','Milano','N711','CANCELLED','13:45:00','10:00:00'),
(41,'Milano','Paris','G711','ON_TIME','13:05:00','11:00:00'),
(42,'Milano','Roma','G721','ON_TIME','13:05:00','11:30:00'),
(44,'Milano','Madrid','G723','ON_TIME','13:00:00','11:30:00'),
(45,'Milano','Amsterdam','G003','ON_TIME','23:00:00','11:30:00'),
(46,'Amsterdam','Yerevan','G063','ON_TIME','13:00:00','12:30:00'),
(47,'Amsterdam','Milano','G903','DELAYYED','13:00:00','12:30:00'),
(48,'Amsterdam','Madrid','G703','CANCELLED','13:00:00','02:30:00'),
(49,'Amsterdam','Berlin','E307','CANCELLED','13:00:00','02:30:00'),
(50,'Hong Kong','Berlin','E507','ON_TIME','14:00:00','12:30:00'),
(51,'Hong Kong','Madrid','m7-007','DELAYYED','13:00:00','10:30:00');

/*Table structure for table `authority` */

DROP TABLE IF EXISTS `authority`;

CREATE TABLE `authority` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `authority` */

insert  into `authority`(`id`,`name`) values 
(1,'ROLE_ADMIN'),
(2,'ROLE_USER');

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `flight_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1wxwagv6cm3vjrxqhmv884hir` (`user_id`),
  KEY `FK9elrf3ksem4a7c5uwqi1xv71d` (`flight_id`),
  CONSTRAINT `FK1wxwagv6cm3vjrxqhmv884hir` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FK9elrf3ksem4a7c5uwqi1xv71d` FOREIGN KEY (`flight_id`) REFERENCES `flight` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

/*Data for the table `book` */

insert  into `book`(`id`,`user_id`,`flight_id`) values 
(1,2,1),
(2,2,2),
(3,3,3),
(4,4,4),
(5,5,4),
(6,7,33),
(7,8,34),
(8,9,11),
(9,9,30),
(10,10,30),
(12,2,1),
(16,4,1),
(17,2,54);

/*Table structure for table `flight` */

DROP TABLE IF EXISTS `flight`;

CREATE TABLE `flight` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `count` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `baggage_status` varchar(255) DEFAULT NULL,
  `airplane_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKb8t4272gfgo1feyyidvscbjm0` (`airplane_id`),
  CONSTRAINT `FKb8t4272gfgo1feyyidvscbjm0` FOREIGN KEY (`airplane_id`) REFERENCES `airplane` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=latin1;

/*Data for the table `flight` */

insert  into `flight`(`id`,`count`,`price`,`baggage_status`,`airplane_id`) values 
(1,49,100,'BAGGAGE',1),
(2,100,50,'BAGGAGE',3),
(3,10,100,'BAGGAGE',2),
(4,20,80,'BAGGAGE',5),
(7,50,90,'BAGGAGE',6),
(8,10,80,'UNBAGGAGE',6),
(9,20,70,'UNBAGGAGE',14),
(10,22,55,'UNBAGGAGE',22),
(11,30,60,'BAGGAGE',22),
(24,40,100,'BAGGAGE',15),
(25,55,90,'UNBAGGAGE',15),
(26,0,150,'BAGGAGE',16),
(27,40,140,'UNBAGGAGE',16),
(28,55,100,'BAGGAGE',17),
(29,10,95,'BAGGAGE',18),
(30,40,10,'BAGGAGE',19),
(31,45,600,'BAGGAGE',20),
(32,40,400,'BAGGAGE',21),
(33,10,300,'UNBAGGAGE',21),
(34,33,150,'BAGGAGE',23),
(35,14,160,'BAGGAGE',28),
(36,33,170,'BAGGAGE',25),
(37,16,180,'BAGGAGE',26),
(38,51,100,'UNBAGGAGE',26),
(39,40,110,'BAGGAGE',27),
(40,5,200,'BAGGAGE',29),
(41,17,180,'UNBAGGAGE',29),
(42,36,250,'BAGGAGE',30),
(43,90,200,'UNBAGGAGE',30),
(44,18,150,'BAGGAGE',31),
(45,36,100,'UNBAGGAGE',31),
(46,40,90,'BAGGAGE',32),
(47,10,60,'UNBAGGAGE',32),
(48,80,190,'BAGGAGE',33),
(49,27,180,'UNBAGGAGE',33),
(50,9,150,'BAGGAGE',34),
(51,11,100,'UNBAGGAGE',34),
(52,22,200,'BAGGAGE',35),
(54,0,200,'BAGGAGE',51);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`id`,`email`,`password`) values 
(1,'reo@gmail.com','$2a$10$xfEFTLO5rjb7oK3Topz48.NNAinnIg7i7eZ/i3aSF1v2EMYdpBwzi'),
(2,'333@gmail.com','$2a$10$bw75VrfccIVlHaEmYXBUVOvCTWw2fyRPZszjhZ/EArKZmh62blxf.'),
(3,'maco@gmail.com','$2a$10$jhvrvKlu3w7e9w4v00Ro9u8wsI8QKQDVWZHVtb2uScVP0AM2/t/S2'),
(4,'mgu@mail.ru','$2a$10$2WlOhDmcNQ7oZLwJ/B216OzJAEq5NTVMJrt17aWPZGxSTbnzKZX5C'),
(5,'mku@mail.ru','$2a$10$Pr5GXkJBljuE5ckoEgC4UuChN.X54xeH.igo5T4O1hQ4dZxidKj5S'),
(6,'gagok.18.u@mail.ru','$2a$10$lsPu1DR.A1PvUdYoEB2snuNeTGA92uWqssP9zARHeXjmJ/FlBB4pi'),
(7,'gagok.95@mail.ru','$2a$10$5UE2jaeRG48yj3rqLpLltO0iICH0G1SCP71JWHqJQhgS5cjQkKRm.'),
(8,'fika.1995@mail.ru','$2a$10$1qtOuuQt2mldok5XHj6aROjAsU0Ctzw.E48dpLypLTQrTVzMG5eL.'),
(9,'Sur.1991@mail.ru','$2a$10$JwUmE7x0u.brfbjWTgU3HuFYBCDGnZpv9CytYyIY2qXD5OkkEGvba'),
(10,'arm.1@gmail.com','$2a$10$RcgZvZsotnkZMVQ7uXJtculTBSehYDhlhY.jFmcknR9oXnGBxl3..');

/*Table structure for table `user_authoriti` */

DROP TABLE IF EXISTS `user_authoriti`;

CREATE TABLE `user_authoriti` (
  `user_id` bigint(20) NOT NULL,
  `authoriti_id` int(11) NOT NULL,
  KEY `FKmnq2ungvutq2dv611f7xhq62m` (`authoriti_id`),
  KEY `FK75uunnno7qvu4ssag2wsgh0cb` (`user_id`),
  CONSTRAINT `FK75uunnno7qvu4ssag2wsgh0cb` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKmnq2ungvutq2dv611f7xhq62m` FOREIGN KEY (`authoriti_id`) REFERENCES `authority` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user_authoriti` */

insert  into `user_authoriti`(`user_id`,`authoriti_id`) values 
(1,1),
(2,2),
(3,2),
(4,2),
(5,2),
(6,2),
(7,2),
(8,2),
(9,2),
(10,2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
