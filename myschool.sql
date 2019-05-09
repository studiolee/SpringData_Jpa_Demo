/*
Navicat MySQL Data Transfer

Source Server         : LR
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : myschool

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-05-09 15:04:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ban`
-- ----------------------------
DROP TABLE IF EXISTS `ban`;
CREATE TABLE `ban` (
  `b_id` int(11) NOT NULL AUTO_INCREMENT,
  `ban_name` varchar(255) DEFAULT NULL,
  `ban_teacher` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`b_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ban
-- ----------------------------
INSERT INTO `ban` VALUES ('1', '16计科1班', '刘老师');
INSERT INTO `ban` VALUES ('2', '16计科2班', '李老师');
INSERT INTO `ban` VALUES ('3', '16软件2班', '王老师');
INSERT INTO `ban` VALUES ('4', '16软件1班', '赵老师');

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `c_id` int(11) NOT NULL,
  `c_name` varchar(255) DEFAULT NULL,
  `credit` double DEFAULT NULL,
  `place` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1001', '数据库原理与应用', '3', '工1_102');
INSERT INTO `course` VALUES ('1002', '数据结构与算法', '2.5', '文A-207');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `birth` datetime DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `ban_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK253k4ppygn1mgo22xqh1u4bdw` (`ban_id`),
  CONSTRAINT `FK253k4ppygn1mgo22xqh1u4bdw` FOREIGN KEY (`ban_id`) REFERENCES `ban` (`b_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '2019-04-08 17:32:17', '0', '梅梅', '1');
INSERT INTO `student` VALUES ('2', '2018-11-13 17:34:01', '0', '李雷', '4');
INSERT INTO `student` VALUES ('3', '2019-01-14 17:33:55', '1', '王小二', '3');
INSERT INTO `student` VALUES ('4', '2019-02-19 17:33:46', '1', '李华', '2');
INSERT INTO `student` VALUES ('5', '2005-01-05 17:41:42', '1', '赵四', '2');
INSERT INTO `student` VALUES ('6', '2018-09-17 17:42:16', '0', '花花', '1');
INSERT INTO `student` VALUES ('7', '2019-01-22 17:43:06', '0', '吉吉', '1');
INSERT INTO `student` VALUES ('8', '2018-12-17 17:43:01', '0', '翠花', '4');
INSERT INTO `student` VALUES ('9', '2019-04-16 17:42:55', '1', '熊大', '3');
INSERT INTO `student` VALUES ('10', '2003-01-03 21:07:06', '1', '熊二', '2');

-- ----------------------------
-- Table structure for `student_course`
-- ----------------------------
DROP TABLE IF EXISTS `student_course`;
CREATE TABLE `student_course` (
  `s_c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_id` int(11) DEFAULT NULL,
  `s_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`s_c_id`),
  KEY `FK6k2xmwhnsyh1l8mnheyf5eeb0` (`c_id`),
  KEY `FKf1wd75sb0p0r5wt2wvvc78hd1` (`s_id`),
  CONSTRAINT `FK6k2xmwhnsyh1l8mnheyf5eeb0` FOREIGN KEY (`c_id`) REFERENCES `course` (`c_id`),
  CONSTRAINT `FKf1wd75sb0p0r5wt2wvvc78hd1` FOREIGN KEY (`s_id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_course
-- ----------------------------
INSERT INTO `student_course` VALUES ('1', '1002', '5');
INSERT INTO `student_course` VALUES ('2', '1002', '3');
INSERT INTO `student_course` VALUES ('3', '1001', '2');

-- ----------------------------
-- Table structure for `stu_info`
-- ----------------------------
DROP TABLE IF EXISTS `stu_info`;
CREATE TABLE `stu_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addr` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nation` varchar(255) DEFAULT NULL,
  `qq` varchar(255) DEFAULT NULL,
  `telphone` varchar(255) DEFAULT NULL,
  `s_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_7ixa0l9ye5iruumop26xxxjrx` (`s_id`),
  CONSTRAINT `FKndtpcbmaypuxorp9oboe9q8k4` FOREIGN KEY (`s_id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu_info
-- ----------------------------
INSERT INTO `stu_info` VALUES ('1', '武汉', '13213@qq.com', '汉', '9898786', '13287876543', '5');
