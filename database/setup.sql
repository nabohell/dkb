SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bankdb`
--
CREATE DATABASE IF NOT EXISTS `bankdb` DEFAULT CHARACTER SET utf32 COLLATE utf32_bin;
USE `bankdb`;

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
                           `id` bigint(20) NOT NULL,
                           `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
                           `updated_date` timestamp NOT NULL DEFAULT current_timestamp(),
                           `balance` double DEFAULT NULL,
                           `currency` varchar(255) COLLATE utf32_bin DEFAULT NULL,
                           `iban` varchar(255) COLLATE utf32_bin DEFAULT NULL,
                           `client` bigint(20) DEFAULT NULL,
                           `type` bigint(20) DEFAULT NULL,
                           `active` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_bin;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`id`, `created_date`, `updated_date`, `balance`, `currency`, `iban`, `client`, `type`, `active`) VALUES
                                                                                                                            (1, '2022-04-12 00:56:54', '2022-04-12 23:34:31', 70, 'eur', 'DE18000011110000000011', 1, 1, 1),
                                                                                                                            (2, '2022-04-12 00:59:01', '2022-04-12 23:34:31', 80, 'eur', 'DE88000011110000000012', 1, 2, 1),
                                                                                                                            (3, '2022-04-12 23:52:20', '2022-04-12 23:52:20', 0, 'eur', 'DE39000011110000000021', 2, 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `account_type`
--

CREATE TABLE `account_type` (
                                `id` bigint(20) NOT NULL,
                                `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
                                `updated_date` timestamp NOT NULL DEFAULT current_timestamp(),
                                `name` varchar(255) COLLATE utf32_bin DEFAULT NULL,
                                `settings` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_bin;

--
-- Dumping data for table `account_type`
--

INSERT INTO `account_type` (`id`, `created_date`, `updated_date`, `name`, `settings`) VALUES
                                                                                          (1, '2022-04-09 10:45:49', '2022-04-09 10:45:49', 'current', 1),
                                                                                          (2, '2022-04-09 10:47:10', '2022-04-09 10:47:10', 'saving', 1),
                                                                                          (3, '2022-04-09 10:48:30', '2022-04-09 10:48:30', 'loan', 2);

-- --------------------------------------------------------

--
-- Table structure for table `account_type_settings`
--

CREATE TABLE `account_type_settings` (
                                         `id` bigint(20) NOT NULL,
                                         `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
                                         `updated_date` timestamp NOT NULL DEFAULT current_timestamp(),
                                         `deposit` bit(1) NOT NULL,
                                         `withdraw` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_bin;

--
-- Dumping data for table `account_type_settings`
--

INSERT INTO `account_type_settings` (`id`, `created_date`, `updated_date`, `deposit`, `withdraw`) VALUES
                                                                                                      (1, '2022-04-09 10:39:32', '2022-04-09 10:39:32', b'1', b'1'),
                                                                                                      (2, '2022-04-09 10:40:01', '2022-04-09 10:40:01', b'1', b'0');

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
                          `id` bigint(20) NOT NULL,
                          `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
                          `updated_date` timestamp NOT NULL DEFAULT current_timestamp(),
                          `address_line1` varchar(255) COLLATE utf32_bin NOT NULL,
                          `address_line2` varchar(255) COLLATE utf32_bin DEFAULT NULL,
                          `address_line3` varchar(255) COLLATE utf32_bin DEFAULT NULL,
                          `country` varchar(255) COLLATE utf32_bin NOT NULL,
                          `first_name` varchar(255) COLLATE utf32_bin NOT NULL,
                          `last_name` varchar(255) COLLATE utf32_bin NOT NULL,
                          `middle_name` varchar(255) COLLATE utf32_bin NOT NULL,
                          `phone_number` varchar(255) COLLATE utf32_bin NOT NULL,
                          `postal_code` varchar(255) COLLATE utf32_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_bin;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`id`, `created_date`, `updated_date`, `address_line1`, `address_line2`, `address_line3`, `country`, `first_name`, `last_name`, `middle_name`, `phone_number`, `postal_code`) VALUES
                                                                                                                                                                                                       (1, '2022-04-09 03:06:32', '2022-04-09 03:06:32', '123', '123', '123', 'palestine', 'nassar', 'abc', 'abc', '0599942839', '123'),
                                                                                                                                                                                                       (2, '2022-04-09 03:35:56', '2022-04-09 03:35:56', '123', '123', '123', 'palestine', 'nassar', 'abc', 'abc', '0599942811', '123'),
                                                                                                                                                                                                       (3, '2022-04-09 12:58:37', '2022-04-09 12:58:37', '123', '123', '123', 'palestine', 'nassar', 'abc', 'abc', '0599942822', '123'),
                                                                                                                                                                                                       (4, '2022-04-09 13:35:51', '2022-04-09 13:35:51', '123', '123', '123', 'palestine', 'nassar', 'abc', 'abc', '0599942844', '123');

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
                               `id` bigint(20) NOT NULL,
                               `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
                               `updated_date` timestamp NOT NULL DEFAULT current_timestamp(),
                               `amount` double DEFAULT NULL,
                               `date` datetime DEFAULT NULL,
                               `transaction_type` varchar(255) COLLATE utf32_bin DEFAULT NULL,
                               `account` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_bin;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`id`, `created_date`, `updated_date`, `amount`, `date`, `transaction_type`, `account`) VALUES
                                                                                                                      (1, '2022-04-12 01:00:58', '2022-04-12 01:00:58', 100, '2022-04-12 01:00:58', 'CREDIT', 1),
                                                                                                                      (2, '2022-04-12 01:02:06', '2022-04-12 01:02:06', 50, '2022-04-12 01:02:06', 'DEPT', 1),
                                                                                                                      (3, '2022-04-12 01:02:06', '2022-04-12 01:02:06', 50, '2022-04-12 01:02:06', 'CREDIT', 2),
                                                                                                                      (4, '2022-04-12 22:56:51', '2022-04-12 22:56:51', 50, '2022-04-12 22:56:50', 'CREDIT', 2),
                                                                                                                      (5, '2022-04-12 23:34:31', '2022-04-12 23:34:31', 20, '2022-04-12 23:34:31', 'DEPT', 2),
                                                                                                                      (6, '2022-04-12 23:34:31', '2022-04-12 23:34:31', 20, '2022-04-12 23:34:31', 'CREDIT', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
    ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_cuc1pxk2ofct9xra2nm0oon` (`iban`),
  ADD KEY `FKp4traw23086e5apisdb35r2n3` (`client`),
  ADD KEY `FKmx2dw4wpm8mp0432qq6yffdhj` (`type`);

--
-- Indexes for table `account_type`
--
ALTER TABLE `account_type`
    ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_h6j4wuyxw7bvqjnjf7cx4pisc` (`name`),
  ADD KEY `FKh558t4i45hjea9o379s3qf7kx` (`settings`);

--
-- Indexes for table `account_type_settings`
--
ALTER TABLE `account_type_settings`
    ADD PRIMARY KEY (`id`);

--
-- Indexes for table `client`
--
ALTER TABLE `client`
    ADD PRIMARY KEY (`id`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
    ADD PRIMARY KEY (`id`),
  ADD KEY `FKflw7pgdaxqqtc83ru6m214qh9` (`account`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `account_type`
--
ALTER TABLE `account_type`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `account_type_settings`
--
ALTER TABLE `account_type_settings`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `client`
--
ALTER TABLE `client`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `account`
--
ALTER TABLE `account`
    ADD CONSTRAINT `FKmx2dw4wpm8mp0432qq6yffdhj` FOREIGN KEY (`type`) REFERENCES `account_type` (`id`),
  ADD CONSTRAINT `FKp4traw23086e5apisdb35r2n3` FOREIGN KEY (`client`) REFERENCES `client` (`id`);

--
-- Constraints for table `account_type`
--
ALTER TABLE `account_type`
    ADD CONSTRAINT `FKh558t4i45hjea9o379s3qf7kx` FOREIGN KEY (`settings`) REFERENCES `account_type_settings` (`id`);

--
-- Constraints for table `transaction`
--
ALTER TABLE `transaction`
    ADD CONSTRAINT `FKflw7pgdaxqqtc83ru6m214qh9` FOREIGN KEY (`account`) REFERENCES `account` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
