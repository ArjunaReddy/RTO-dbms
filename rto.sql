-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 11, 2019 at 09:30 AM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rto`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `name` varchar(25) DEFAULT NULL,
  `adminid` varchar(20) NOT NULL,
  `password` varchar(15) NOT NULL,
  `phone` bigint(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`name`, `adminid`, `password`, `phone`) VALUES
('Arjun Reddy', 'arj36', '123bruh', 9852586478),
('Likith', 'LC001', 'Noob123', 9900475688);

-- --------------------------------------------------------

--
-- Table structure for table `controls`
--

CREATE TABLE `controls` (
  `adminid` varchar(20) DEFAULT NULL,
  `usr_aadhar` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `drivinglicense`
--

CREATE TABLE `drivinglicense` (
  `DLno` varchar(15) NOT NULL,
  `cov` varchar(10) DEFAULT NULL,
  `doi` date DEFAULT NULL,
  `doe` date DEFAULT NULL,
  `usr_aadhar` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `learninglicence`
--

CREATE TABLE `learninglicence` (
  `LLno` varchar(20) NOT NULL,
  `cov` varchar(10) DEFAULT NULL,
  `doi` date DEFAULT NULL,
  `doe` date DEFAULT NULL,
  `usr_aadhar` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `rc`
--

CREATE TABLE `rc` (
  `regno` varchar(10) NOT NULL,
  `engno` varchar(15) NOT NULL,
  `fuel` varchar(8) NOT NULL,
  `cov` varchar(10) DEFAULT NULL,
  `doi` date DEFAULT NULL,
  `doe` date DEFAULT NULL,
  `model` varchar(25) DEFAULT NULL,
  `ownerid` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `transfer`
--

CREATE TABLE `transfer` (
  `t_no` int(11) NOT NULL,
  `b_id` bigint(20) DEFAULT NULL,
  `s_id` bigint(20) DEFAULT NULL,
  `regno` varchar(10) DEFAULT NULL,
  `fuel` varchar(8) DEFAULT NULL,
  `tdate` date DEFAULT NULL,
  `cov` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `Fname` varchar(15) NOT NULL,
  `Mname` varchar(15) DEFAULT 'NULL',
  `Lname` varchar(15) DEFAULT 'NULL',
  `aadhar` bigint(20) NOT NULL,
  `address` varchar(40) DEFAULT NULL,
  `phno` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`Fname`, `Mname`, `Lname`, `aadhar`, `address`, `phno`) VALUES
('Anirudh', NULL, NULL, 1234432112344321, 'bangalore', 9900990099);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`adminid`,`password`);

--
-- Indexes for table `drivinglicense`
--
ALTER TABLE `drivinglicense`
  ADD PRIMARY KEY (`DLno`);

--
-- Indexes for table `learninglicence`
--
ALTER TABLE `learninglicence`
  ADD PRIMARY KEY (`LLno`);

--
-- Indexes for table `rc`
--
ALTER TABLE `rc`
  ADD PRIMARY KEY (`regno`),
  ADD UNIQUE KEY `engno` (`engno`);

--
-- Indexes for table `transfer`
--
ALTER TABLE `transfer`
  ADD PRIMARY KEY (`t_no`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`aadhar`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
