-- Adminer 4.2.0 MySQL dump

SET NAMES utf8mb4;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `id` int(11) NOT NULL,
  `post_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `content` text NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  KEY `post_id` (`post_id`),
  CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `experiences`;
CREATE TABLE `experiences` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `products_id` int(11) NOT NULL,
  `user` varchar(40) COLLATE utf8_czech_ci NOT NULL,
  `text` text COLLATE utf8_czech_ci NOT NULL,
  `plus` int(11) NOT NULL DEFAULT '0',
  `minus` int(11) NOT NULL DEFAULT '0',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `products_id` (`products_id`),
  CONSTRAINT `experiences_ibfk_1` FOREIGN KEY (`products_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci;

INSERT INTO `experiences` (`id`, `products_id`, `user`, `text`, `plus`, `minus`, `created_at`) VALUES
(1,	1,	'Martin',	'I like this water',	0,	0,	'2015-02-20 11:21:19'),
(2,	1,	'Petr',	'Don\'t bay it!!!!',	0,	0,	'2015-02-20 12:11:14');

DROP TABLE IF EXISTS `posts`;
CREATE TABLE `posts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `content` text NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_czech_ci NOT NULL,
  `description` text COLLATE utf8_czech_ci NOT NULL,
  `plus` int(11) NOT NULL DEFAULT '0',
  `minus` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci;

INSERT INTO `products` (`id`, `name`, `description`, `plus`, `minus`) VALUES
(1,	'Mineral water',	'Mineral water is water from a mineral spring that contains various minerals, such as salts and sulfur compounds. Mineral water may be effervescent (i.e., \"sparkling\") due to contained gases.\r\n\r\nTraditionally, mineral waters were used or consumed at their spring sources, often referred to as \"taking the waters\" or \"taking the cure,\" at places such as spas, baths, or wells. The term spa was used for a place where the water was consumed and bathed in; bath where the water was used primarily for bathing, therapeutics, or recreation; and well where the water was to be consumed.\r\n\r\nIn modern times, it is far more common for mineral water to be bottled at the source for distributed consumption. Travelling to the mineral water site for direct access to the water is now uncommon, and in many cases not possible (because of exclusive commercial ownership rights). There are more than 3,000 brands of mineral water commercially available worldwide.[1]\r\n\r\nIn England, effervescent mineral water is often referred to as \"Vichy water,\" which refers to water from the springs at Vichy, ',	3,	0),
(2,	'Sparkling water',	'Carbonated water (also known as club soda, soda water, sparkling water, seltzer water, or fizzy water) is water into which carbon dioxide gas under pressure has been dissolved. Some of these have additives such as sodium (seltzer water is almost always composed of water and carbon dioxide with no other additives). This process, known as carbonation, is a process that causes the water to become effervescent. For people who enjoy drinking soft drinks, carbonated water can provide a calorie and sugar-free substitute.[1] The vast majority of carbonated water is sold in ready to drink bottles as mineral water and carbonated beverages such as soft drinks. However it is rather easy to prepare at home with soda makers.',	4,	0);

-- 2015-02-20 16:11:52

