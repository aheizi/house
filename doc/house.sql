/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : house

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2015-08-05 00:09:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `house_collection`
-- ----------------------------
DROP TABLE IF EXISTS `house_collection`;
CREATE TABLE `house_collection` (
  `collection_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `out_dtail_id` int(10) NOT NULL,
  `in_dtail_id` int(10) NOT NULL,
  PRIMARY KEY (`collection_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of house_collection
-- ----------------------------
INSERT INTO `house_collection` VALUES ('3', '2', '0', '5');
INSERT INTO `house_collection` VALUES ('4', '2', '1', '0');
INSERT INTO `house_collection` VALUES ('5', '2', '4', '0');

-- ----------------------------
-- Table structure for `house_in_dtail`
-- ----------------------------
DROP TABLE IF EXISTS `house_in_dtail`;
CREATE TABLE `house_in_dtail` (
  `in_id` int(10) NOT NULL AUTO_INCREMENT,
  `in_publisher` varchar(15) DEFAULT NULL,
  `in_publishDate` varchar(15) DEFAULT NULL,
  `in_title` varchar(80) DEFAULT NULL,
  `in_provinces` varchar(20) DEFAULT NULL,
  `in_city` varchar(20) DEFAULT NULL,
  `in_country` varchar(20) DEFAULT NULL,
  `in_rent` int(6) DEFAULT NULL,
  `in_rentWay` varchar(20) DEFAULT NULL,
  `in_description` varchar(500) DEFAULT NULL,
  `in_time` varchar(20) DEFAULT NULL,
  `in_contactTel` varchar(20) DEFAULT NULL,
  `in_contact` varchar(20) DEFAULT NULL,
  `in_qqNum` varchar(20) DEFAULT NULL,
  `in_state` int(1) DEFAULT NULL,
  PRIMARY KEY (`in_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of house_in_dtail
-- ----------------------------
INSERT INTO `house_in_dtail` VALUES ('3', 'aheizi', '2015-05-28', '三峡大学租房', '湖北', '宜昌市', '西陵区', '1300', '单间出租', '干净就行。', '2015-05-29', '黄同学', '17092233221', '785193391', '2');
INSERT INTO `house_in_dtail` VALUES ('4', 'aheizi', '2015-05-28', '寻求好房源', '湖北', '宜昌市', '夷陵区', '1000', '单间出租', '好房源，干净的房屋', '2015-05-31', '黄同学', '17092233221', '785193391', '2');

-- ----------------------------
-- Table structure for `house_news`
-- ----------------------------
DROP TABLE IF EXISTS `house_news`;
CREATE TABLE `house_news` (
  `news_id` int(10) NOT NULL AUTO_INCREMENT,
  `news_dtail` varchar(500) DEFAULT NULL,
  `news_publisher` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`news_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of house_news
-- ----------------------------

-- ----------------------------
-- Table structure for `house_out_dtail`
-- ----------------------------
DROP TABLE IF EXISTS `house_out_dtail`;
CREATE TABLE `house_out_dtail` (
  `house_id` int(10) NOT NULL AUTO_INCREMENT,
  `house_publisher` varchar(15) DEFAULT NULL,
  `house_publishDate` varchar(15) DEFAULT NULL,
  `house_region` varchar(20) DEFAULT NULL,
  `house_hireWay` varchar(15) DEFAULT NULL,
  `house_identity` varchar(15) DEFAULT NULL,
  `house_provinces` varchar(20) DEFAULT NULL,
  `house_city` varchar(20) DEFAULT NULL,
  `house_country` varchar(20) DEFAULT NULL,
  `house_communityName` varchar(50) DEFAULT NULL,
  `house_room` int(3) DEFAULT NULL,
  `house_hall` int(3) DEFAULT NULL,
  `house_toilet` int(3) DEFAULT NULL,
  `house_squareMeter` int(3) DEFAULT NULL,
  `house_floor` int(3) DEFAULT NULL,
  `house_floorth` int(3) DEFAULT NULL,
  `house_rent` int(3) DEFAULT NULL,
  `house_rentWay` varchar(30) DEFAULT NULL,
  `house_title` varchar(80) DEFAULT NULL,
  `house_description` varchar(500) DEFAULT NULL,
  `house_imgUrl` varchar(30) DEFAULT NULL,
  `house_contact` varchar(15) DEFAULT NULL,
  `house_contactTel` varchar(30) DEFAULT NULL,
  `hosue_qqNum` varchar(20) DEFAULT NULL,
  `house_state` int(1) DEFAULT NULL,
  PRIMARY KEY (`house_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of house_out_dtail
-- ----------------------------
INSERT INTO `house_out_dtail` VALUES ('4', 'aheizi', '2015-05-29', '宜昌', '整套出租', '个人', '湖北', '宜昌市', '西陵区', '怡景花园', '3', '1', '1', '80', '12', '24', '1200', '押一付三', '好房出租', '本人向您推荐的该物业位于康慧苑园中园，为康慧苑中少有放盘的南向三房带主套大户型，一梯二户；一进门口，房子给人感觉超舒服，间隔很好，业主保养得很好，房大厅大，绝对能够满足喜欢房大厅大的要求；厅出阳台和厨房出阳台望花园，格局非常的实用，实用率达到95%左右，南北对流，通风采光很好，所以这套房子真的是很值，康慧苑的需求量非常大，房子很少有放盘，而大面积的又是南向的仅此一套，不要错过啊，赶快约我看房吧！', 'house1.png', '黄同学', '17092233221', '785193391', '2');
INSERT INTO `house_out_dtail` VALUES ('5', 'aheizi1', '2015-05-30', '宜昌', '整套出租', '个人', '天津', '天津', '红桥区', '12', '12', '12', '12', '1212', '1212', '12', '12', '押二付二', '121212121212', '12', 'house1.png', '12', '12', '1212', '2');

-- ----------------------------
-- Table structure for `house_user`
-- ----------------------------
DROP TABLE IF EXISTS `house_user`;
CREATE TABLE `house_user` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(15) DEFAULT NULL,
  `user_password` varchar(15) DEFAULT NULL,
  `user_emial` varchar(20) DEFAULT NULL,
  `user_realname` varchar(20) DEFAULT NULL,
  `user_address` varchar(20) DEFAULT NULL,
  `user_zipcode` varchar(20) DEFAULT NULL,
  `user_type` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of house_user
-- ----------------------------
INSERT INTO `house_user` VALUES ('1', 'test', '131313', '785193391@qq.com', '', '', '', 'normal');
INSERT INTO `house_user` VALUES ('2', 'aheizi', '121212', '785193391@qq.com', '黄阳全', 'longquan', '443000', 'normal');
INSERT INTO `house_user` VALUES ('3', 'aheizi', '121212', null, null, null, null, 'manager');
INSERT INTO `house_user` VALUES ('4', 'admin', 'admin', null, null, null, null, 'admin');
INSERT INTO `house_user` VALUES ('5', 'huang', '121212', null, null, null, null, 'manager');
INSERT INTO `house_user` VALUES ('6', 'aheizi1', '121212', '785193391@qq.com', '', '', '', 'normal');
INSERT INTO `house_user` VALUES ('7', 'hu', '121212', null, null, null, null, 'manager');
