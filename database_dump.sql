-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: eventmanager
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `admins`
--

DROP TABLE IF EXISTS `admins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admins` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQ_A2E0150FAA08CB10` (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admins`
--

LOCK TABLES `admins` WRITE;
/*!40000 ALTER TABLE `admins` DISABLE KEYS */;
/*!40000 ALTER TABLE `admins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `events`
--

DROP TABLE IF EXISTS `events`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `events` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `partner_id` int(11) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `description` longtext NOT NULL,
  `amount` int(11) NOT NULL,
  `free_amount` int(11) NOT NULL,
  `price` double NOT NULL,
  `event_date` datetime NOT NULL,
  `published_at` datetime NOT NULL,
  `closed_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_5387574A9393F8FE` (`partner_id`),
  CONSTRAINT `FK_5387574A9393F8FE` FOREIGN KEY (`partner_id`) REFERENCES `partners` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `events`
--

LOCK TABLES `events` WRITE;
/*!40000 ALTER TABLE `events` DISABLE KEYS */;
INSERT INTO `events` (`id`, `partner_id`, `name`, `description`, `amount`, `free_amount`, `price`, `event_date`, `published_at`, `closed_at`) VALUES (1,1,'Event 1(1)','event for partner 1',10,10,5,'2017-04-10 12:00:00','2017-01-10 12:00:00','2017-03-10 12:00:00');
INSERT INTO `events` (`id`, `partner_id`, `name`, `description`, `amount`, `free_amount`, `price`, `event_date`, `published_at`, `closed_at`) VALUES (2,2,'Event 1(2)','event for partner 2',5,5,25,'2017-04-10 14:00:00','2017-01-10 12:00:00','2017-03-10 12:00:00');
INSERT INTO `events` (`id`, `partner_id`, `name`, `description`, `amount`, `free_amount`, `price`, `event_date`, `published_at`, `closed_at`) VALUES (3,1,'Event 2(1)','event for partner 1',20,20,10,'2017-04-11 15:00:00','2017-01-10 12:00:00','2017-03-10 12:00:00');
INSERT INTO `events` (`id`, `partner_id`, `name`, `description`, `amount`, `free_amount`, `price`, `event_date`, `published_at`, `closed_at`) VALUES (4,NULL,'Event 3(1)','event for partner 1',2,2,3,'2017-02-10 12:00:00','2017-01-01 12:00:00','2017-01-05 12:00:00');
/*!40000 ALTER TABLE `events` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partners`
--

DROP TABLE IF EXISTS `partners`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `partners` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` longtext NOT NULL,
  `website` varchar(255) NOT NULL,
  `address` longtext NOT NULL,
  `telephone` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partners`
--

LOCK TABLES `partners` WRITE;
/*!40000 ALTER TABLE `partners` DISABLE KEYS */;
INSERT INTO `partners` (`id`, `name`, `description`, `website`, `address`, `telephone`, `email`) VALUES (1,'Partner 1','partner 1 description','example.com','Test 1, 00-000 Test','123123123','partner@example.com');
INSERT INTO `partners` (`id`, `name`, `description`, `website`, `address`, `telephone`, `email`) VALUES (2,'Partner 2','partner 2 description','test.com','Testowa 1, 99-999 Test','000999888','partner@test.com');
/*!40000 ALTER TABLE `partners` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservations`
--

DROP TABLE IF EXISTS `reservations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `event_id` int(11) DEFAULT NULL,
  `uuid` varchar(64) NOT NULL,
  `reservation_key` varchar(8) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `telephone` varchar(255) NOT NULL,
  `confirmed` tinyint(1) NOT NULL,
  `amount` int(11) NOT NULL,
  `final_price` double NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQ_4DA239D17F50A6` (`uuid`),
  UNIQUE KEY `UNIQ_4DA239DF928676` (`reservation_key`),
  KEY `IDX_4DA23971F7E88B` (`event_id`),
  CONSTRAINT `FK_4DA23971F7E88B` FOREIGN KEY (`event_id`) REFERENCES `events` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservations`
--

LOCK TABLES `reservations` WRITE;
/*!40000 ALTER TABLE `reservations` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservations` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-18 20:42:28
