-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 03. Feb 2023 um 18:33
-- Server-Version: 10.4.27-MariaDB
-- PHP-Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `cma`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `customeraccount`
--

CREATE TABLE `customeraccount` (
  `email` text NOT NULL,
  `password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Daten für Tabelle `customeraccount`
--

INSERT INTO `customeraccount` (`email`, `password`) VALUES
('', '');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `performance`
--

CREATE TABLE `performance` (
  `ID` bigint(20) UNSIGNED NOT NULL,
  `title` text NOT NULL,
  `duration` int(11) NOT NULL,
  `time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `assignedHall_ID` int(11) NOT NULL,
  `assignedHall_row` int(11) NOT NULL,
  `assignedHall_seatsInRow` int(11) NOT NULL,
  `availableSeats` int(11) NOT NULL,
  `isArchived` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Daten für Tabelle `performance`
--

INSERT INTO `performance` (`ID`, `title`, `duration`, `time`, `assignedHall_ID`, `assignedHall_row`, `assignedHall_seatsInRow`, `availableSeats`, `isArchived`) VALUES
(1, 'PerformanceTest_NonArchived_Second', 120, '2023-02-22 15:00:00', 2, 3, 10, 15, 0),
(2, 'PerformanceTest_Archived', 120, '2023-01-31 12:00:00', 1, 10, 10, 30, 1),
(4, 'PerformanceTest_NonArchived_First', 120, '2023-02-22 12:00:00', 1, 10, 10, 30, 0);

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `customeraccount`
--
ALTER TABLE `customeraccount`
  ADD UNIQUE KEY `email` (`email`) USING HASH;

--
-- Indizes für die Tabelle `performance`
--
ALTER TABLE `performance`
  ADD UNIQUE KEY `ID` (`ID`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `performance`
--
ALTER TABLE `performance`
  MODIFY `ID` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
