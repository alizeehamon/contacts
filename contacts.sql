/*
Navicat MySQL Data Transfer

Source Server         : poe
Source Server Version : 50153
Source Host           : localhost:3307
Source Database       : contacts

Target Server Type    : MYSQL
Target Server Version : 50153
File Encoding         : 65001

Date: 2022-10-17 21:09:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `contact`
-- ----------------------------
DROP TABLE IF EXISTS `contact`;
CREATE TABLE `contact` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address1` varchar(255) DEFAULT NULL,
  `address2` varchar(255) DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `company_role` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `encounter_summary` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `web_site` varchar(255) DEFAULT NULL,
  `zip_code` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKe07k4jcfdophemi6j1lt84b61` (`user_id`),
  CONSTRAINT `FKe07k4jcfdophemi6j1lt84b61` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of contact
-- ----------------------------
INSERT INTO `contact` VALUES ('1', '15 rue des Lilas', null, '1994-06-22', 'Nantes', 'Capgemini', 'Software Engineer', 'France', 'jean@gmail.com', 'At work', 'Jean', null, 'Bernard', '0876543212', null, '44000', '1');
INSERT INTO `contact` VALUES ('2', '5 avenue de Gaulle', null, '1993-02-13', 'Nantes', 'Capgemini', 'Product Owner', 'France', 'lise@gmail.com', 'At a seminar online', 'Lise', null, 'Morin', '0765435216', null, '44000', '2');
INSERT INTO `contact` VALUES ('3', '2 rue des Aigrettes', '', '1989-04-05', 'Nantes', 'Capgemini', 'UX Designer', 'France', 'bob@gmail.com', 'On a beach', 'Bob', 'http://localhost:8080/images/147144.png', 'Poulter', '0965432134', '', '44000', '6');
INSERT INTO `contact` VALUES ('4', '8 rue des hirondelles', '', '2004-03-17', 'Nantes', 'Aucune', 'Aucun', 'France', 'john@gmail.com', 'Met with Bob', 'John', 'http://localhost:8080/images/user-icon.jpg', 'Doe', '0876545323', '', '44000', '6');
INSERT INTO `contact` VALUES ('5', '2 rue du stade', '', '2002-10-04', 'Nantes', 'Aucun', 'Aucun', 'France', 'lola.rodriguez@gmail.com', 'At a birthday party', 'Lola', 'http://localhost:8080/images/3135823.png', 'Rodriguez', '0453621324', '', '44000', '6');
INSERT INTO `contact` VALUES ('6', '20 rue des Boulets', '', '1976-08-03', 'Nantes', 'Capgemini', 'Software Engineer', 'France', 'john.travolta@gmail.com', 'During an afterwork', 'John', 'http://localhost:8080/images/3135715.png', 'Travolta', '0786547687', '', '44000', '6');

-- ----------------------------
-- Table structure for `hibernate_sequence`
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('14');

-- ----------------------------
-- Table structure for `relationship`
-- ----------------------------
DROP TABLE IF EXISTS `relationship`;
CREATE TABLE `relationship` (
  `id` bigint(20) NOT NULL,
  `relation_type` varchar(255) DEFAULT NULL,
  `target_contact_id` bigint(20) DEFAULT NULL,
  `transmitter_contact_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKq4y8lx688s4tnfch3fqe3bghs` (`target_contact_id`),
  KEY `FKa3xe3b1y6u205w4bc0jetl2wr` (`transmitter_contact_id`),
  CONSTRAINT `FKa3xe3b1y6u205w4bc0jetl2wr` FOREIGN KEY (`transmitter_contact_id`) REFERENCES `contact` (`id`),
  CONSTRAINT `FKq4y8lx688s4tnfch3fqe3bghs` FOREIGN KEY (`target_contact_id`) REFERENCES `contact` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of relationship
-- ----------------------------
INSERT INTO `relationship` VALUES ('8', 'Frère', '4', '3');
INSERT INTO `relationship` VALUES ('9', 'Frère', '3', '4');
INSERT INTO `relationship` VALUES ('10', 'Père/Fille', '5', '3');
INSERT INTO `relationship` VALUES ('11', 'Père/Fille', '3', '5');
INSERT INTO `relationship` VALUES ('12', 'Ami', '4', '6');
INSERT INTO `relationship` VALUES ('13', 'Ami', '6', '4');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'john.doe@gmail.com', 'Doe', 'https://mpng.subpng.com/20180411/due/kisspng-computer-icons-user-profile-info-5acde51e963fe2.9717334815234429746154.jpg', 'John', '$2a$10$WL9yhH3lLvJzB9.9jqUVjen6hlm.s8Y2yllvWkoZqjjSpaH9Zx9X2');
INSERT INTO `user` VALUES ('2', 'alizee.hamon@laposte.net', 'Hamon', '', 'Alizée', '$2a$10$AgmCtzTn.5JOuQWVRumVlOyMyBXj4gNHvlp5lkDfQU.9b.pCl.P9q');
INSERT INTO `user` VALUES ('5', 'test@test.fr', 'Test', 'https://mpng.subpng.com/20210506/yja/transparent-accountant-icon-accounting-icon-account-icon-60949f38925b14.9683030316203528245995.jpg', 'Test', '$2a$10$VThVD.Dwp5jzaq32Y8EzneyPKp5YcBH2Jqclq6oEII9WWtIUCri2i');
INSERT INTO `user` VALUES ('6', 'boris.sauvage@gmail.com', 'Sauvage', 'https://cdn-icons-png.flaticon.com/512/149/149071.png', 'Boris', '$2a$10$uGrpmSI9YZM5Cy6BcNLj3uCr92153h0xzqJKMmmVPLmoDmjzSDWSq');
