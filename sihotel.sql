-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 10, 2022 at 06:52 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sihotel`
--

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `jabatan` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `address`, `email`, `gender`, `jabatan`, `name`) VALUES
(1, 'ciamis', 'aris.prnm16@gmail.com', 'Male', 'Manajer Keuangan', 'Aris Purnama '),
(2, 'Boyolali', 'romikusumab@gmail.com', 'Male', 'Direktur ', 'Romi Kusuma Bakti');

-- --------------------------------------------------------

--
-- Table structure for table `history`
--

CREATE TABLE `history` (
  `id` bigint(20) NOT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  `catatan` varchar(255) DEFAULT NULL,
  `check_in` tinyint(1) DEFAULT 0,
  `code` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `jenis_kelamin` varchar(255) DEFAULT NULL,
  `lama_inap` int(11) NOT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `no_ktp` varchar(255) DEFAULT NULL,
  `no_tlpn` varchar(255) DEFAULT NULL,
  `room` varchar(255) DEFAULT NULL,
  `tagihan` int(11) NOT NULL,
  `tanggal_checkin` date DEFAULT NULL,
  `tanggal_order` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `history`
--

INSERT INTO `history` (`id`, `alamat`, `catatan`, `check_in`, `code`, `email`, `jenis_kelamin`, `lama_inap`, `nama`, `no_ktp`, `no_tlpn`, `room`, `tagihan`, `tanggal_checkin`, `tanggal_order`) VALUES
(1, 'Banyumas', '', 1, 1, 'aris.prnm16@gmail.com', 'Female', 1, 'Badut Comrang', '098976545754', '09989898', 'com.neo.sihotel.model.Room@3c1d5820', 780000, '2022-04-11', '2022-04-10');

-- --------------------------------------------------------

--
-- Table structure for table `reservasi`
--

CREATE TABLE `reservasi` (
  `code` int(11) NOT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  `catatan` varchar(255) DEFAULT NULL,
  `check_in` tinyint(1) DEFAULT 0,
  `email` varchar(255) DEFAULT NULL,
  `jenis_kelamin` varchar(255) DEFAULT NULL,
  `lama_inap` int(11) NOT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `no_ktp` varchar(255) DEFAULT NULL,
  `no_tlpn` varchar(255) DEFAULT NULL,
  `tagihan` int(11) NOT NULL,
  `tanggal_checkin` date DEFAULT NULL,
  `tanggal_order` date DEFAULT NULL,
  `room_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `reservasi`
--

INSERT INTO `reservasi` (`code`, `alamat`, `catatan`, `check_in`, `email`, `jenis_kelamin`, `lama_inap`, `nama`, `no_ktp`, `no_tlpn`, `tagihan`, `tanggal_checkin`, `tanggal_order`, `room_id`) VALUES
(2, 'cdr', '', 0, 'aris.prnm16@gmail.com', 'Male', 1, 'Aris Purnama', '098976545754', '0989898900', 780000, '2022-04-11', '2022-04-10', 1);

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `id` int(11) NOT NULL,
  `nomor` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`id`, `nomor`, `status`, `type_id`) VALUES
(1, 'B44', 'Kosong', 2),
(2, 'B65', 'Kosong', 1);

-- --------------------------------------------------------

--
-- Table structure for table `room_type`
--

CREATE TABLE `room_type` (
  `id` int(11) NOT NULL,
  `harga` int(11) NOT NULL,
  `jenis` varchar(255) DEFAULT NULL,
  `kapasitas` int(11) NOT NULL,
  `photo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `room_type`
--

INSERT INTO `room_type` (`id`, `harga`, `jenis`, `kapasitas`, `photo`) VALUES
(1, 500000, 'Economik', 3, '1.png'),
(2, 780000, 'premium', 2, 'null.png');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `admin` bit(1) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `admin`, `email`, `name`, `password`) VALUES
(1, b'1', 'aris.prnm16@gmail.com', 'Aris Purnama ', '$2a$10$jFJ2QyuFkViVoutybh/CmeI7IlH4YF78tEZM.TUtRw9fDWgI6oN1K'),
(4, b'0', 'yoga@gmail.com', 'Yoga', '$2a$10$ge1.QHNXiKSCBtQUQ3cbFOaER0anXRJlGKCvz3CEO5GBrMxbi7QgS');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `history`
--
ALTER TABLE `history`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `reservasi`
--
ALTER TABLE `reservasi`
  ADD PRIMARY KEY (`code`),
  ADD KEY `FKm8asab8j9o29c1cewd1g23ymj` (`room_id`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKf5vbgyps3ubaknn710nk2m5o5` (`type_id`);

--
-- Indexes for table `room_type`
--
ALTER TABLE `room_type`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `history`
--
ALTER TABLE `history`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `reservasi`
--
ALTER TABLE `reservasi`
  MODIFY `code` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `room`
--
ALTER TABLE `room`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `room_type`
--
ALTER TABLE `room_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `reservasi`
--
ALTER TABLE `reservasi`
  ADD CONSTRAINT `FKm8asab8j9o29c1cewd1g23ymj` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`);

--
-- Constraints for table `room`
--
ALTER TABLE `room`
  ADD CONSTRAINT `FKf5vbgyps3ubaknn710nk2m5o5` FOREIGN KEY (`type_id`) REFERENCES `room_type` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
