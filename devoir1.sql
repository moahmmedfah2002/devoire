-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Dec 12, 2024 at 11:34 PM
-- Server version: 8.3.0
-- PHP Version: 8.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `devoir1`
--

-- --------------------------------------------------------

--
-- Table structure for table `costumer`
--

DROP TABLE IF EXISTS `costumer`;
CREATE TABLE IF NOT EXISTS `costumer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `costumer`
--

INSERT INTO `costumer` (`id`, `nom`, `email`, `phone`) VALUES
(1, 'fahlaoui', 'fahlaouimohammed@gmail.com', '0680622793');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
CREATE TABLE IF NOT EXISTS `orders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `amount` float NOT NULL,
  `costumer` int NOT NULL,
  `statue` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `costumer` (`costumer`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id`, `date`, `amount`, `costumer`, `statue`) VALUES
(1, '2024-12-13', 0.687423, 1, 1),
(2, '2024-12-13', 0.687423, 1, 1),
(3, '2024-12-13', 0.265026, 1, 0),
(4, '2024-12-13', 0.265026, 1, 0),
(5, '2024-12-13', 0.858884, 1, 0),
(6, '2024-12-13', 0.858884, 1, 0),
(7, '2024-12-13', 0.897496, 1, 1),
(8, '2024-12-13', 0.897496, 1, 1),
(9, '2024-12-13', 0.556408, 1, 1),
(10, '2024-12-13', 0.556408, 1, 1),
(11, '2024-12-13', 0.133659, 1, 0),
(12, '2024-12-13', 0.133659, 1, 0),
(13, '2024-12-13', 0.650999, 1, 0),
(14, '2024-12-13', 0.650999, 1, 0),
(15, '2024-12-13', 0.0280871, 1, 0),
(16, '2024-12-13', 0.0280871, 1, 0),
(17, '2024-12-13', 0.789458, 1, 0),
(18, '2024-12-13', 0.789458, 1, 0),
(19, '2024-12-13', 0.160254, 1, 1),
(20, '2024-12-13', 0.160254, 1, 1),
(21, '2024-12-13', 0.800198, 1, 1),
(22, '2024-12-13', 0.800198, 1, 1),
(23, '2024-12-13', 0.15789, 1, 1),
(24, '2024-12-13', 0.15789, 1, 1),
(25, '2024-12-13', 0.0520516, 1, 0),
(26, '2024-12-13', 0.0520516, 1, 0),
(27, '2024-12-13', 0.627018, 1, 0),
(28, '2024-12-13', 0.627018, 1, 0),
(29, '2024-12-13', 0.451539, 1, 1),
(30, '2024-12-13', 0.451539, 1, 1),
(31, '2024-12-13', 0.79059, 1, 0),
(32, '2024-12-13', 0.79059, 1, 0),
(33, '2024-12-13', 0.442208, 1, 1),
(34, '2024-12-13', 0.442208, 1, 1),
(35, '2024-12-13', 0.53671, 1, 1),
(36, '2024-12-13', 0.53671, 1, 1),
(37, '2024-12-13', 0.0662961, 1, 1),
(38, '2024-12-13', 0.0662961, 1, 1),
(39, '2024-12-13', 0.126965, 1, 0),
(40, '2024-12-13', 0.126965, 1, 0),
(41, '2024-12-13', 0.909729, 1, 1),
(42, '2024-12-13', 0.909729, 1, 1),
(43, '2024-12-13', 0.789549, 1, 0),
(44, '2024-12-13', 0.789549, 1, 0),
(45, '2024-12-13', 0.380379, 1, 1),
(46, '2024-12-13', 0.380379, 1, 1),
(47, '2024-12-13', 0.555558, 1, 0),
(48, '2024-12-13', 0.555558, 1, 0),
(49, '2024-12-13', 0.277203, 1, 0),
(50, '2024-12-13', 0.277203, 1, 0),
(51, '2024-12-13', 0.300624, 1, 0),
(52, '2024-12-13', 0.300624, 1, 0),
(53, '2024-12-13', 0.639525, 1, 0),
(54, '2024-12-13', 0.639525, 1, 0),
(55, '2024-12-13', 0.892324, 1, 0),
(56, '2024-12-13', 0.892324, 1, 0),
(57, '2024-12-13', 0.135104, 1, 0),
(58, '2024-12-13', 0.135104, 1, 0),
(59, '2024-12-13', 0.0803146, 1, 1),
(60, '2024-12-13', 0.0803146, 1, 1),
(61, '2024-12-13', 0.684778, 1, 1),
(62, '2024-12-13', 0.684778, 1, 1),
(63, '2024-12-13', 0.414415, 1, 1),
(64, '2024-12-13', 0.414415, 1, 1),
(65, '2024-12-13', 0.232524, 1, 0),
(66, '2024-12-13', 0.232524, 1, 0),
(67, '2024-12-13', 0.978979, 1, 0),
(68, '2024-12-13', 0.978979, 1, 0);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `costumer` FOREIGN KEY (`costumer`) REFERENCES `costumer` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
