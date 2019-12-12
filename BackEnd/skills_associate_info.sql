-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: localhost    Database: skills
-- ------------------------------------------------------
-- Server version	5.7.26-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `associate_info`
--

DROP TABLE IF EXISTS `associate_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `associate_info` (
  `associate_id` int(11) NOT NULL AUTO_INCREMENT,
  `associate_email` varchar(255) NOT NULL,
  `associate_first_name` varchar(255) NOT NULL,
  `associate_last_name` varchar(255) NOT NULL,
  `associate_mobile` bigint(20) NOT NULL,
  `country` varchar(255) NOT NULL,
  `dob` datetime NOT NULL,
  `gender` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`associate_id`),
  UNIQUE KEY `UK_1ngj1qfy8nvyy7up7muyixaof` (`associate_email`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `associate_info`
--

LOCK TABLES `associate_info` WRITE;
/*!40000 ALTER TABLE `associate_info` DISABLE KEYS */;
INSERT INTO `associate_info` VALUES (1,'kavyapoojary989@gmail.com','Kavya','Amin',8970540961,'India','1998-07-02 05:30:00','female','Bangalore','$2a$10$ngu0jCWSn1Kx/Qai8gq70OcMchbP2T8M3DVdF9GI.1HOxjMTK5mcu'),(2,'bhavanabs3@gmail.com','Bhavana','Shetty',9087987654,'India','1997-03-16 05:30:00','female','Bangalore','$2a$10$eobfJok4lL9oW7/PP5hpbexQLqc1Rw4IPOdK0wEZIGrB6cSLQQzlq'),(3,'nishithalakshmi1@gmail.com','Nishitha','Lakshmi',8762359909,'Zimbabwe','1997-09-01 05:30:00','female','Harare','$2a$10$aHspIhqZdwieAmIP/xtv/OxZnCWUs73fsXqv.ujEXNLxS1/V8j8Hy');
/*!40000 ALTER TABLE `associate_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-12  8:50:11
