-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1:3306
-- Létrehozás ideje: 2020. Dec 14. 13:56
-- Kiszolgáló verziója: 8.0.21
-- PHP verzió: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `animal_shelter`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `animals`
--

DROP TABLE IF EXISTS `animals`;
CREATE TABLE IF NOT EXISTS `animals` (
  `id` text CHARACTER SET utf8 COLLATE utf8_hungarian_ci,
  `name` varchar(255) COLLATE utf8_hungarian_ci NOT NULL,
  `type` text COLLATE utf8_hungarian_ci NOT NULL,
  `gender` text COLLATE utf8_hungarian_ci NOT NULL,
  `status` text COLLATE utf8_hungarian_ci NOT NULL,
  `color` text COLLATE utf8_hungarian_ci NOT NULL,
  `date_of_birth` date DEFAULT NULL,
  `cost_per_day` int NOT NULL,
  `description` text CHARACTER SET utf8 COLLATE utf8_hungarian_ci NOT NULL,
  `costPerDay` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `animals`
--

INSERT INTO `animals` (`id`, `name`, `type`, `gender`, `status`, `color`, `date_of_birth`, `cost_per_day`, `description`, `costPerDay`) VALUES
('d4b6a76e-17ca-4a42-9cb5-258c9b93ed59', 'Buksi', 'DOG', 'MALE', 'TAKE_CARE', 'BROWN', '2020-01-01', 450, '', NULL),
('764643e1-db0e-4172-b832-ba54bd29666f', 'Keksz', 'DOG', 'FEMALE', 'ADOPTED', 'GREY', '2019-01-01', 450, '', NULL),
('0465d5cb-e302-44ee-8bf5-325f85b47544', 'Áfonya', 'CAT', 'MALE', 'NOTIFIED', 'RED', '2018-12-24', 2500, '', NULL),
('440c75ce-a4fe-4f53-a7cb-4fc1951102f1', 'Maggie', 'DOG', 'FEMALE', 'TAKE_CARE', 'WHITE', '2017-07-04', 450, 'We she take care 2 years.', NULL),
('96d41e33-3615-4076-b474-d8f5ad4f6f9f', 'Teddy', 'DOG', 'MALE', 'TAKE_CARE', 'BLACK', '2016-04-12', 450, 'We she take care 2 years.', NULL),
('d9dc3a9f-0a16-4c94-811d-ec9eac6ef87c', 'Max', 'CAT', 'MALE', 'NOTIFIED', 'OTHER', '2015-08-19', 2500, 'Unfortunately, his owner do not want to take care for it.', NULL),
('0ceafe05-ce26-43d9-ae1b-8d30a6a7282e', 'Charlie', 'CAT', 'MALE', 'ADOPTED', 'RED', '2010-12-30', 2500, 'None', NULL),
('c7ecac9a-a580-4642-91f2-26ad07b2ffe2', 'Jack', 'CAT', 'MALE', 'TAKE_CARE', 'OTHER', '2010-12-30', 2500, 'None', NULL),
('48f84bce-36e8-4b0d-90a1-4066e1417401', 'Luna', 'FISH', 'FEMALE', 'NOTIFIED', 'RED', '2015-08-06', 1500, 'None.', NULL),
('969d081f-216b-4e4e-9657-f5b0b285b901', 'Lorry', 'PARROT', 'MALE', 'TAKE_CARE', 'OTHER', '2017-12-06', 750, 'None.', NULL),
('5a3e6a10-8cef-45de-a375-a254c78b5505', 'George', 'PARROT', 'MALE', 'TAKE_CARE', 'YELLOW', '2020-03-01', 750, 'None.', NULL),
('eafbf851-2e66-44ac-b2e4-7bafa036f367', 'Veronica', 'DOG', 'FEMALE', 'ADOPTED', 'BROWN', '2010-12-31', 450, 'None.', NULL);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `skills`
--

DROP TABLE IF EXISTS `skills`;
CREATE TABLE IF NOT EXISTS `skills` (
  `id` int NOT NULL AUTO_INCREMENT,
  `skill` text COLLATE utf8_hungarian_ci NOT NULL,
  `level` int NOT NULL,
  `animal` text CHARACTER SET utf8 COLLATE utf8_hungarian_ci NOT NULL,
  `idx` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `skills`
--

INSERT INTO `skills` (`id`, `skill`, `level`, `animal`, `idx`) VALUES
(1, 'CHILD_FRIENDLY', 10, '0465d5cb-e302-44ee-8bf5-325f85b47544', 0),
(2, 'HOUSE_TRAINED', 10, '0465d5cb-e302-44ee-8bf5-325f85b47544', 1),
(3, 'SIT', 10, '440c75ce-a4fe-4f53-a7cb-4fc1951102f1', 0),
(4, 'HOUSE_TRAINED', 10, '440c75ce-a4fe-4f53-a7cb-4fc1951102f1', 1),
(5, 'SIT', 7, '440c75ce-a4fe-4f53-a7cb-4fc1951102f1', 2),
(6, 'SEARCH', 2, '440c75ce-a4fe-4f53-a7cb-4fc1951102f1', 3),
(7, 'SIT', 10, '96d41e33-3615-4076-b474-d8f5ad4f6f9f', 0),
(8, 'HOUSE_TRAINED', 10, '96d41e33-3615-4076-b474-d8f5ad4f6f9f', 1),
(9, 'CHILD_FRIENDLY', 7, '96d41e33-3615-4076-b474-d8f5ad4f6f9f', 2),
(10, 'SIT', 10, '99a67f63-1ff6-4c02-a7b4-a32088328aba', 0),
(11, 'HOUSE_TRAINED', 10, '99a67f63-1ff6-4c02-a7b4-a32088328aba', 1),
(12, 'CHILD_FRIENDLY', 7, '99a67f63-1ff6-4c02-a7b4-a32088328aba', 2),
(13, 'SIT', 10, 'de26eb3f-8cc5-4ac7-bbba-07da24cb25fc', 0),
(14, 'HOUSE_TRAINED', 10, 'de26eb3f-8cc5-4ac7-bbba-07da24cb25fc', 1),
(15, 'CHILD_FRIENDLY', 7, 'de26eb3f-8cc5-4ac7-bbba-07da24cb25fc', 2),
(16, 'HOUSE_TRAINED', 10, 'd9dc3a9f-0a16-4c94-811d-ec9eac6ef87c', 0),
(17, 'CHILD_FRIENDLY', 7, 'd9dc3a9f-0a16-4c94-811d-ec9eac6ef87c', 1),
(18, 'HOUSE_TRAINED', 10, '0ceafe05-ce26-43d9-ae1b-8d30a6a7282e', 0),
(19, 'CHILD_FRIENDLY', 7, '017213f2-f039-4033-9e01-d01031f4fd46', 0),
(20, 'CHILD_FRIENDLY', 7, 'c7ecac9a-a580-4642-91f2-26ad07b2ffe2', 0),
(21, 'SPEAK', 4, '5a3e6a10-8cef-45de-a375-a254c78b5505', 0),
(23, 'SIT', 3, '948d2c9d-5b08-4097-907d-a4040de60523', 0),
(24, 'SIT', 3, 'eafbf851-2e66-44ac-b2e4-7bafa036f367', 0),
(25, 'LIE', 7, 'eafbf851-2e66-44ac-b2e4-7bafa036f367', 1),
(26, 'BARK', 6, 'eafbf851-2e66-44ac-b2e4-7bafa036f367', 2),
(27, 'CHILD_FRIENDLY', 5, 'eafbf851-2e66-44ac-b2e4-7bafa036f367', 3);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
