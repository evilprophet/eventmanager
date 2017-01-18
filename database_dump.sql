-- phpMyAdmin SQL Dump
-- version 3.5.8.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Czas wygenerowania: 18 Sty 2017, 11:50
-- Wersja serwera: 5.6.31-77.0-log
-- Wersja PHP: 5.3.29

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Baza danych: `eventmanager`
--
CREATE DATABASE `eventmanager` DEFAULT CHARSET=utf8  COLLATE = utf8_general_ci;
USE `eventmanager`;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `admins`
--

CREATE TABLE IF NOT EXISTS `admins` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQ_A2E0150FAA08CB10` (`login`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `events`
--

CREATE TABLE IF NOT EXISTS `events` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `partner_id` int(11) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_general_ci NOT NULL,
  `description` longtext COLLATE utf8_general_ci NOT NULL,
  `amount` int(11) NOT NULL,
  `free_amount` int(11) NOT NULL,
  `price` double NOT NULL,
  `event_date` datetime NOT NULL,
  `published_at` datetime NOT NULL,
  `closed_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_5387574A9393F8FE` (`partner_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `partners`
--

CREATE TABLE IF NOT EXISTS `partners` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_general_ci NOT NULL,
  `description` longtext COLLATE utf8_general_ci NOT NULL,
  `website` varchar(255) COLLATE utf8_general_ci NOT NULL,
  `address` longtext COLLATE utf8_general_ci NOT NULL,
  `telephone` varchar(255) COLLATE utf8_general_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `reservations`
--

CREATE TABLE IF NOT EXISTS `reservations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `event_id` int(11) DEFAULT NULL,
  `uuid` varchar(64) COLLATE utf8_general_ci NOT NULL,
  `reservation_key` varchar(8) COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_general_ci NOT NULL,
  `first_name` varchar(255) COLLATE utf8_general_ci NOT NULL,
  `last_name` varchar(255) COLLATE utf8_general_ci NOT NULL,
  `telephone` varchar(255) COLLATE utf8_general_ci NOT NULL,
  `confirmed` tinyint(1) NOT NULL,
  `amount` int(11) NOT NULL,
  `finalPrice` double NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQ_4DA239D17F50A6` (`uuid`),
  UNIQUE KEY `UNIQ_4DA239DF928676` (`reservation_key`),
  KEY `IDX_4DA23971F7E88B` (`event_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci ;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `events`
--
ALTER TABLE `events`
  ADD CONSTRAINT `FK_5387574A9393F8FE` FOREIGN KEY (`partner_id`) REFERENCES `partners` (`id`) ON DELETE SET NULL;

--
-- Ograniczenia dla tabeli `reservations`
--
ALTER TABLE `reservations`
  ADD CONSTRAINT `FK_4DA23971F7E88B` FOREIGN KEY (`event_id`) REFERENCES `events` (`id`) ON DELETE SET NULL;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
