-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 22, 2022 at 12:17 AM
-- Server version: 8.0.24
-- PHP Version: 7.1.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sih`
--

-- --------------------------------------------------------

--
-- Table structure for table `achievements`
--

CREATE TABLE `achievements` (
                                `id` bigint NOT NULL,
                                `achievements_description` varchar(255) DEFAULT NULL,
                                `achievements_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `achievements`
--

INSERT INTO `achievements` (`id`, `achievements_description`, `achievements_name`) VALUES
    (1, 'test', 'test');

-- --------------------------------------------------------

--
-- Table structure for table `article`
--

CREATE TABLE `article` (
                           `id` bigint NOT NULL,
                           `article_data` varchar(10000) DEFAULT NULL,
                           `article_desc` varchar(255) DEFAULT NULL,
                           `article_name` varchar(255) DEFAULT NULL,
                           `user_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `article`
--

INSERT INTO `article` (`id`, `article_data`, `article_desc`, `article_name`, `user_id`) VALUES
                                                                                            (1, '<div class=\"> update', 'NEW DESC update #PastSimple', 'NEW ARTICLE update', 2),
                                                                                            (2, '<div class=\">', 'NEW DESC', 'NEW ARTICLE', 2);

-- --------------------------------------------------------

--
-- Table structure for table `article_tag`
--

CREATE TABLE `article_tag` (
                               `id` bigint NOT NULL,
                               `article_id` bigint DEFAULT NULL,
                               `tag_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `article_tag`
--

INSERT INTO `article_tag` (`id`, `article_id`, `tag_id`) VALUES
    (42, 1, 11);

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
    `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
    (57);

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE `question` (
                            `id` bigint NOT NULL,
                            `correct_answer` varchar(255) DEFAULT NULL,
                            `question_text` varchar(255) DEFAULT NULL,
                            `test_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`id`, `correct_answer`, `question_text`, `test_id`) VALUES
                                                                                (32, 'default', 'default', 2),
                                                                                (33, 'default', 'default', 2),
                                                                                (34, 'TEST 3 DESC', 'TEST 3', 30),
                                                                                (35, 'default', 'default', 30),
                                                                                (36, 'default', 'default', 30),
                                                                                (44, 'default', 'default', 43),
                                                                                (45, 'default', 'default', 43),
                                                                                (46, 'default', 'default', 43),
                                                                                (55, 'test', 'New test', 54);

-- --------------------------------------------------------

--
-- Table structure for table `sih_user`
--

CREATE TABLE `sih_user` (
                            `id` bigint NOT NULL,
                            `password` varchar(255) DEFAULT NULL,
                            `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `sih_user`
--

INSERT INTO `sih_user` (`id`, `password`, `username`) VALUES
                                                          (1, '$2a$10$TWkxHigStyeRUxvEfR.aAewFGrYGJPOm7tcYI1guySORIZ0Y/t36u', 'username'),
                                                          (2, '$2a$10$Zhx3JJA9la4exa99TPAzf.HdjdqLI.0qqsBCnDSHMshQvy8BykX9S', 'u'),
                                                          (3, '$2a$10$O0DGcP5b6EwLHprhkmHZrO6x7C3hsbvdctv71Ad3MPSra32B21ShC', 'user');

-- --------------------------------------------------------

--
-- Table structure for table `sih_user_roles`
--

CREATE TABLE `sih_user_roles` (
                                  `user_id` bigint NOT NULL,
                                  `roles_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `sih_user_roles`
--

INSERT INTO `sih_user_roles` (`user_id`, `roles_id`) VALUES
                                                         (1, 1),
                                                         (3, 1),
                                                         (2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `tag`
--

CREATE TABLE `tag` (
                       `id` bigint NOT NULL,
                       `tag_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `tag`
--

INSERT INTO `tag` (`id`, `tag_name`) VALUES
                                         (12, 'FutureContinuous'),
                                         (2, 'Grammar'),
                                         (5, 'NewTag'),
                                         (8, 'Past'),
                                         (11, 'PastSimple'),
                                         (10, 'SetsTest'),
                                         (7, 'TestTag');

-- --------------------------------------------------------

--
-- Table structure for table `test`
--

CREATE TABLE `test` (
                        `id` bigint NOT NULL,
                        `test_name` varchar(255) DEFAULT NULL,
                        `user_id` bigint DEFAULT NULL,
                        `test_description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `test`
--

INSERT INTO `test` (`id`, `test_name`, `user_id`, `test_description`) VALUES
                                                                          (2, 'Past Cont T', 2, 'Test Desc #PastSimple'),
                                                                          (30, 'New test', 2, 'Test Desc #Past #SetsTest'),
                                                                          (43, 'Тетсування у дрібницях. Past Simple vs Past Contunious', 2, 'Цей тест створено, щоб Ви на практиці уміли використовувати Past Simple та Past Contunious, знаючи де який використовувати. #PastSimple'),
                                                                          (47, 'Новий тест!', 2, 'Дізнайтесь наємниці цього тесту'),
                                                                          (48, 'Past Simple', 2, '#Past Simple'),
                                                                          (49, 'New test', 2, 'Test Desc #PastSimple'),
                                                                          (54, 'FutureContinuous', 2, 'FutureContinuous #FutureContinuous');

-- --------------------------------------------------------

--
-- Table structure for table `test_tag`
--

CREATE TABLE `test_tag` (
                            `id` bigint NOT NULL,
                            `tag_id` bigint DEFAULT NULL,
                            `test_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `test_tag`
--

INSERT INTO `test_tag` (`id`, `tag_id`, `test_id`) VALUES
                                                       (40, 8, 30),
                                                       (41, 10, 30),
                                                       (50, 11, 43),
                                                       (51, 8, 48),
                                                       (52, 11, 2),
                                                       (53, 11, 49),
                                                       (56, 12, 54);

-- --------------------------------------------------------

--
-- Table structure for table `t_role`
--

CREATE TABLE `t_role` (
                          `id` bigint NOT NULL,
                          `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `t_role`
--

INSERT INTO `t_role` (`id`, `name`) VALUES
                                        (1, 'ROLE_USER'),
                                        (2, 'ROLE_ADMIN');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `achievements`
--
ALTER TABLE `achievements`
    ADD PRIMARY KEY (`id`);

--
-- Indexes for table `article`
--
ALTER TABLE `article`
    ADD PRIMARY KEY (`id`),
  ADD KEY `FKonvr37xq86x60xm7urf5qb0y3` (`user_id`);

--
-- Indexes for table `article_tag`
--
ALTER TABLE `article_tag`
    ADD PRIMARY KEY (`id`),
  ADD KEY `FKenqeees0y8hkm7x1p1ittuuye` (`article_id`),
  ADD KEY `FKesqp7s9jj2wumlnhssbme5ule` (`tag_id`);

--
-- Indexes for table `question`
--
ALTER TABLE `question`
    ADD PRIMARY KEY (`id`),
  ADD KEY `FK8hejcpbbiq1qje11346akp3uj` (`test_id`);

--
-- Indexes for table `sih_user`
--
ALTER TABLE `sih_user`
    ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sih_user_roles`
--
ALTER TABLE `sih_user_roles`
    ADD PRIMARY KEY (`user_id`,`roles_id`),
  ADD KEY `FK6r81n5tc1radgiusv2vt2jq09` (`roles_id`);

--
-- Indexes for table `tag`
--
ALTER TABLE `tag`
    ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `tag_name` (`tag_name`);

--
-- Indexes for table `test`
--
ALTER TABLE `test`
    ADD PRIMARY KEY (`id`),
  ADD KEY `FKj5u1gwxqk9f252fdwy1q3u3q8` (`user_id`);

--
-- Indexes for table `test_tag`
--
ALTER TABLE `test_tag`
    ADD PRIMARY KEY (`id`),
  ADD KEY `FKips8s6457ubh8d8vxma50q0xj` (`tag_id`),
  ADD KEY `FKb20rxjppfolen1iuq2nq77dn5` (`test_id`);

--
-- Indexes for table `t_role`
--
ALTER TABLE `t_role`
    ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `achievements`
--
ALTER TABLE `achievements`
    MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `article`
--
ALTER TABLE `article`
    MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `sih_user`
--
ALTER TABLE `sih_user`
    MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tag`
--
ALTER TABLE `tag`
    MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `article`
--
ALTER TABLE `article`
    ADD CONSTRAINT `FKonvr37xq86x60xm7urf5qb0y3` FOREIGN KEY (`user_id`) REFERENCES `sih_user` (`id`);

--
-- Constraints for table `article_tag`
--
ALTER TABLE `article_tag`
    ADD CONSTRAINT `FKenqeees0y8hkm7x1p1ittuuye` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`),
  ADD CONSTRAINT `FKesqp7s9jj2wumlnhssbme5ule` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`id`);

--
-- Constraints for table `question`
--
ALTER TABLE `question`
    ADD CONSTRAINT `FK8hejcpbbiq1qje11346akp3uj` FOREIGN KEY (`test_id`) REFERENCES `test` (`id`);

--
-- Constraints for table `sih_user_roles`
--
ALTER TABLE `sih_user_roles`
    ADD CONSTRAINT `FK6r81n5tc1radgiusv2vt2jq09` FOREIGN KEY (`roles_id`) REFERENCES `t_role` (`id`),
  ADD CONSTRAINT `FKoi32e1ftgjbu9a34xtmggsv7w` FOREIGN KEY (`user_id`) REFERENCES `sih_user` (`id`);

--
-- Constraints for table `test`
--
ALTER TABLE `test`
    ADD CONSTRAINT `FKj5u1gwxqk9f252fdwy1q3u3q8` FOREIGN KEY (`user_id`) REFERENCES `sih_user` (`id`);

--
-- Constraints for table `test_tag`
--
ALTER TABLE `test_tag`
    ADD CONSTRAINT `FKb20rxjppfolen1iuq2nq77dn5` FOREIGN KEY (`test_id`) REFERENCES `test` (`id`),
  ADD CONSTRAINT `FKips8s6457ubh8d8vxma50q0xj` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
