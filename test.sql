-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 19, 2019 at 07:01 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `mid` int(25) NOT NULL,
  `mname` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `mtype` varchar(25) NOT NULL,
  `address` varchar(1000) NOT NULL,
  `mail` varchar(500) NOT NULL,
  `contactNumber` int(10) NOT NULL,
  `status` varchar(25) NOT NULL DEFAULT 'Active'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`mid`, `mname`, `password`, `mtype`, `address`, `mail`, `contactNumber`, `status`) VALUES
(2, 'Ganesh', 'g123', 'Buyer', 'zzzzzzzzzzzzzzzzzz', 'ganesh@gmail.com', 777825178, 'Active'),
(3, 'Kamal', 'k123', 'Seller', 'zzzzzzzzzzzzzzzzzz', 'kamal@gmail.com', 777825123, 'Active'),
(4, 'Jollygood', 'j123', 'Buyer', 'zzzzzzzzzzzzzzzzzz', 'jolly@gmail.com', 767315178, 'Active'),
(6, 'Vondro', 'vn12', 'Buyer', 'zzzzzzzzzzzzzzzzzz', 'vond@gmail.com', 773215112, 'Active'),
(7, 'Harry', 'harry123', 'Buyer', 'zzzzzzzzzzzzzzzzzz', 'harry@gmail.com', 767315178, 'Active'),
(8, 'dilrukshan', '1f0g688jhd6', 'Seller', 'zzzzzzzzzzzzzzzzzz', 'dilu@gmail.com', 721977226, 'Active'),
(9, 'Banuka', 'b123', 'Seller', 'zzzzzzzzzzzzzzzzzz', 'banuka@gmail.com', 777825178, 'Active'),
(11, 'Tharaniya', 'qwe', 'Seller', '43/A California, USA', 'jlj@skfjsn.com', 16565, 'Active'),
(12, 'asa', 'a', 'Seller', 'lkj', 'jlj@skfjsn.com', 354681, 'Active'),
(15, 'Janindu', 'j123', 'Seller', 'zzzzzzzzzzzzzzzzzz', 'jlj@skfjsn.com', 776318136, 'Active'),
(16, 'AlphaNoob', 'al12', 'Seller', '191 Avissawella Road, Orodawatta', 'alphaNoob@gmail.com', 766664422, 'Active'),
(17, 'abcde', 'a123', 'Seller', 'pojpojp', 'jlj@skfjsn.com', 776318136, 'Active'),
(18, 'Hariharan', 'h123', 'Seller', '191 Avissawella Road, Orodawatta', 'ganesh@gmail.com', 71397906, 'Active');

-- --------------------------------------------------------

--
-- Table structure for table `member2`
--

CREATE TABLE `member2` (
  `ID` int(10) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `Type` varchar(50) NOT NULL,
  `Address` varchar(500) NOT NULL,
  `Mail_Address` varchar(100) NOT NULL,
  `Contact_Number` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `member2`
--

INSERT INTO `member2` (`ID`, `Name`, `Password`, `Type`, `Address`, `Mail_Address`, `Contact_Number`) VALUES
(1, 'Testa', 'a', 'Seller', 'TestAddress', 'Test@gmail.com', 771234567),
(2, 'Testb', 'b', 'Seller', 'Test', 'Test@gmail.com', 771234567);

-- --------------------------------------------------------

--
-- Table structure for table `ordertbl`
--

CREATE TABLE `ordertbl` (
  `oid` int(11) NOT NULL,
  `sid` int(11) NOT NULL,
  `bid` int(11) NOT NULL,
  `pid` int(11) NOT NULL,
  `status` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ordertbl`
--

INSERT INTO `ordertbl` (`oid`, `sid`, `bid`, `pid`, `status`) VALUES
(1, 3, 3, 39, 'Decline'),
(2, 3, 3, 39, 'Accept'),
(3, 3, 3, 39, 'Accept'),
(4, 3, 3, 39, 'pending'),
(11, 9, 2, 36, 'Accept'),
(12, 18, 7, 42, 'Accept');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `payid` int(11) NOT NULL,
  `oid` int(11) NOT NULL,
  `cost` float NOT NULL,
  `address` varchar(5000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`payid`, `oid`, `cost`, `address`) VALUES
(2, 2, 600, 'Wellawatta'),
(4, 12, 4500, 'colombo');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `pid` int(10) NOT NULL,
  `pname` varchar(50) NOT NULL,
  `price` float NOT NULL,
  `description` varchar(5000) NOT NULL,
  `image` varchar(5000) DEFAULT NULL,
  `mid` int(10) NOT NULL,
  `status` varchar(4) NOT NULL DEFAULT 'nys'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`pid`, `pname`, `price`, `description`, `image`, `mid`, `status`) VALUES
(33, 'Brown Dress', 1500, 'ssad', 'themes/images/project_img6.jpg', 3, 'sold'),
(36, 'proda', 333, 'sdfsd', 'themes/images/pageBanner.png', 9, 'nys'),
(39, 'black frock', 600, 'gg', 'themes/images/project_img4.jpg', 3, 'nys'),
(40, 'dressA', 1500, 'Girls dress', 'themes/images/1.jpg', 3, 'nys'),
(41, 'DressB', 2500, 'DressB', 'themes/images/bootstrap-women-ware2.jpg', 3, 'nys'),
(42, 'girls frock', 4500, 'silk', 'themes/images/bootstrap-women-ware3.jpg', 18, 'sold');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`mid`),
  ADD UNIQUE KEY `mname` (`mname`);

--
-- Indexes for table `member2`
--
ALTER TABLE `member2`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `Name` (`Name`);

--
-- Indexes for table `ordertbl`
--
ALTER TABLE `ordertbl`
  ADD PRIMARY KEY (`oid`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`payid`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`pid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
  MODIFY `mid` int(25) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `member2`
--
ALTER TABLE `member2`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `ordertbl`
--
ALTER TABLE `ordertbl`
  MODIFY `oid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `payid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `pid` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
