/*
Navicat MySQL Data Transfer

Source Server         : lianjie
Source Server Version : 50525
Source Host           : 127.0.0.1:3306
Source Database       : creditmanagement

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2017-11-28 17:10:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(10) NOT NULL,
  `pwd` varchar(20) NOT NULL,
  `tel` varchar(11) NOT NULL,
  `other` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'Ta1', 'a1', '10010', 'beizhu');
INSERT INTO `admin` VALUES ('2', 'Tadmin', 'admin', '10086', '备注信息');

-- ----------------------------
-- Table structure for admin_su
-- ----------------------------
DROP TABLE IF EXISTS `admin_su`;
CREATE TABLE `admin_su` (
  `username` varchar(10) NOT NULL,
  `pwd` varchar(20) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_su
-- ----------------------------
INSERT INTO `admin_su` VALUES ('Sroot', 'root');

-- ----------------------------
-- Table structure for application
-- ----------------------------
DROP TABLE IF EXISTS `application`;
CREATE TABLE `application` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `applicationName` varchar(10) NOT NULL,
  `applicationNumber` int(10) NOT NULL,
  `applicationCategory` varchar(10) NOT NULL,
  `applicationWhat` varchar(255) NOT NULL,
  `applicationTime` varchar(20) NOT NULL,
  `isPass` varchar(5) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of application
-- ----------------------------
INSERT INTO `application` VALUES ('1', 'san', '1703200', 'goods', '周三下午使用xx教室', '2017-11-14 11:10:16', 'false');

-- ----------------------------
-- Table structure for creditactivity
-- ----------------------------
DROP TABLE IF EXISTS `creditactivity`;
CREATE TABLE `creditactivity` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `number` int(10) NOT NULL,
  `name` varchar(10) NOT NULL,
  `categoryId` varchar(10) NOT NULL,
  `detail` varchar(255) NOT NULL,
  `dates` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of creditactivity
-- ----------------------------
INSERT INTO `creditactivity` VALUES ('2', '1703', 'hahah', '1', 'shishi', '2017-11-11');
INSERT INTO `creditactivity` VALUES ('3', '170320000', 'tom', '1', 'detail', '2017-12-12');

-- ----------------------------
-- Table structure for creditcategory
-- ----------------------------
DROP TABLE IF EXISTS `creditcategory`;
CREATE TABLE `creditcategory` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `categoryId` int(10) NOT NULL,
  `categoryName` varchar(100) NOT NULL,
  `detail` varchar(255) NOT NULL,
  `score` int(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of creditcategory
-- ----------------------------
INSERT INTO `creditcategory` VALUES ('1', '1', '赛会得奖', '国奖一', '50');
INSERT INTO `creditcategory` VALUES ('2', '1', '赛会得奖', '国奖二', '40');
INSERT INTO `creditcategory` VALUES ('4', '2', '社会公益', '敬老院服务', '30');
INSERT INTO `creditcategory` VALUES ('5', '2', '社会公益', '支教', '30');
INSERT INTO `creditcategory` VALUES ('6', '1', '12', '??', '20');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `goodsName` varchar(50) NOT NULL,
  `goodsNumberRemain` int(5) NOT NULL,
  `goodsNumberBorrowed` int(5) NOT NULL,
  `goodsBorrower` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '条幅', '10', '1', 'sam');
INSERT INTO `goods` VALUES ('2', '订书机', '20', '1', 'tom');

-- ----------------------------
-- Table structure for info
-- ----------------------------
DROP TABLE IF EXISTS `info`;
CREATE TABLE `info` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `infoTittle` varchar(100) NOT NULL,
  `infoContent` varchar(255) NOT NULL,
  `infoTime` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of info
-- ----------------------------
INSERT INTO `info` VALUES ('1', '标题1', '内容1', '2017-11-22 11:16:50');

-- ----------------------------
-- Table structure for stu_base
-- ----------------------------
DROP TABLE IF EXISTS `stu_base`;
CREATE TABLE `stu_base` (
  `name` varchar(10) NOT NULL,
  `number` int(10) NOT NULL,
  `pwd` varchar(20) NOT NULL,
  `college` varchar(30) NOT NULL,
  `class` varchar(20) NOT NULL,
  `credit` int(5) NOT NULL DEFAULT '0',
  PRIMARY KEY (`number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu_base
-- ----------------------------
INSERT INTO `stu_base` VALUES ('hahah', '1703', '2423523452344234234', 'shuji', '17-1', '80');
INSERT INTO `stu_base` VALUES ('tom', '170320000', '123', '数计', '17-1', '80');
INSERT INTO `stu_base` VALUES ('sss', '170320001', '123', '数计', '17-2', '90');
