/*
Navicat MySQL Data Transfer

Source Server         : mysql1
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : limit_blog

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2020-09-13 21:02:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
`user_id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`user_name`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`user_password`  varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`user_email`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`user_profile_photo`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`user_level`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`user_rights`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`user_registration_time`  timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
`user_birthday`  date NULL DEFAULT NULL ,
`user_age`  tinyint(4) NULL DEFAULT NULL ,
`user_telephone_numbuter`  int(20) NULL DEFAULT NULL ,
`user_nickname`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`user_photo`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`user_sex`  varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`user_qq`  int(13) NULL DEFAULT NULL ,
`user_wechat`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`user_hobby`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`user_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=61

;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('1', 'pulaige', '123', '123123@qq.com', null, null, '3', '2020-07-29 09:40:34', '2018-11-01', '20', '1123123112', null, null, '男', '7777777', 'pulaige', '爱国敬业诚信友善'), ('2', 'tom', '123', '123456@qq.com', null, null, '3', '2020-07-29 09:40:38', '2018-11-09', '22', '1234141414', null, null, '女', '12111123', 'tom123', '你好啊'), ('3', 'kity', '123', '1233211@qq.com', null, null, '3', '2019-05-09 09:20:17', '2018-12-13', '18', '1234567897', null, null, '女', '123123123', 'kitty', '嘻嘻嘻'), ('4', 'root', '1234', '1029930857@qq.com', null, null, '1', '2020-09-12 10:28:19', null, null, null, null, null, null, null, null, null), ('5', 'cluster', '123456', '1029930857@qq.com', null, null, '1', '2020-07-29 15:49:21', null, null, null, null, null, null, null, null, null), ('6', 'john123', 'root', '2723504975@qq.com', null, null, null, '2020-09-12 14:25:48', null, null, null, null, null, null, null, null, null), ('15', '杨威', '1234', '2723504975@qq.com', null, null, null, '2020-09-13 09:39:18', null, null, null, null, null, null, null, null, null), ('29', '21212', '1111', '2723504975@qq.com', null, null, null, '2020-09-13 10:33:31', null, null, null, null, null, null, null, null, null), ('30', '????????', '111', '2723504975@qq.com', null, null, null, '2020-09-13 10:35:04', null, null, null, null, null, null, null, null, null), ('31', '????????', '111', '2723504975@qq.com', null, null, null, '2020-09-13 10:37:04', null, null, null, null, null, null, null, null, null), ('32', '?????????', '111', '2723504975@qq.com', null, null, null, '2020-09-13 10:40:24', null, null, null, null, null, null, null, null, null), ('35', '?в??', '1111', '2723504975@qq.com', null, null, null, '2020-09-13 11:04:28', null, null, null, null, null, null, null, null, null), ('36', '锟斤拷学锟斤拷', '111', '2723504975@qq.com', null, null, null, '2020-09-13 11:06:44', null, null, null, null, null, null, null, null, null), ('37', '????', '1212', '2723504975@qq.com', null, null, null, '2020-09-13 11:09:31', null, null, null, null, null, null, null, null, null), ('38', '????', '111', '2723504975@qq.com', null, null, null, '2020-09-13 11:13:22', null, null, null, null, null, null, null, null, null), ('39', '?????????', '1', '2723504975@qq.com', null, null, null, '2020-09-13 19:07:10', null, null, null, null, null, null, null, null, null), ('40', '?????????', '1', '2723504975@qq.com', null, null, null, '2020-09-13 19:08:22', null, null, null, null, null, null, null, null, null), ('41', '?????????', '1', '2723504975@qq.com', null, null, null, '2020-09-13 19:08:48', null, null, null, null, null, null, null, null, null), ('42', '?????????', '1', '2723504975@qq.com', null, null, null, '2020-09-13 19:09:31', null, null, null, null, null, null, null, null, null), ('43', '����', '2332', '2723504975@qq.com', null, null, null, '2020-09-13 19:16:28', null, null, null, null, null, null, null, null, null), ('44', '����', '2332', '2723504975@qq.com', null, null, null, '2020-09-13 19:16:44', null, null, null, null, null, null, null, null, null), ('45', '����', '2332', '2723504975@qq.com', null, null, null, '2020-09-13 19:17:01', null, null, null, null, null, null, null, null, null), ('46', '????', '2332', '2723504975@qq.com', null, null, null, '2020-09-13 19:17:26', null, null, null, null, null, null, null, null, null), ('47', '????', '2332', '2723504975@qq.com', null, null, null, '2020-09-13 19:17:45', null, null, null, null, null, null, null, null, null), ('48', '????', '2332', '2723504975@qq.com', null, null, null, '2020-09-13 19:17:52', null, null, null, null, null, null, null, null, null), ('49', '????', '2332', '2723504975@qq.com', null, null, null, '2020-09-13 19:18:14', null, null, null, null, null, null, null, null, null), ('50', '????', '2332', '2723504975@qq.com', null, null, null, '2020-09-13 19:18:26', null, null, null, null, null, null, null, null, null), ('51', '????', '2332', '2723504975@qq.com', null, null, null, '2020-09-13 19:19:10', null, null, null, null, null, null, null, null, null), ('52', '????', '2332', '2723504975@qq.com', null, null, null, '2020-09-13 19:19:19', null, null, null, null, null, null, null, null, null), ('53', '????', '2332', '2723504975@qq.com', null, null, null, '2020-09-13 19:20:36', null, null, null, null, null, null, null, null, null), ('54', '????', '2332', '2723504975@qq.com', null, null, null, '2020-09-13 19:21:46', null, null, null, null, null, null, null, null, null), ('55', '????', '2332', '2723504975@qq.com', null, null, null, '2020-09-13 20:55:08', null, null, null, null, null, null, null, null, null), ('56', '????', '2332', '2723504975@qq.com', null, null, null, '2020-09-13 20:55:30', null, null, null, null, null, null, null, null, null), ('57', '????', '2332', '2723504975@qq.com', null, null, null, '2020-09-13 20:55:55', null, null, null, null, null, null, null, null, null), ('58', '????', '2332', '2723504975@qq.com', null, null, null, '2020-09-13 20:56:38', null, null, null, null, null, null, null, null, null), ('59', '????', '2332', '2723504975@qq.com', null, null, null, '2020-09-13 20:56:53', null, null, null, null, null, null, null, null, null), ('60', '????', '2332', '2723504975@qq.com', null, null, null, '2020-09-13 20:57:30', null, null, null, null, null, null, null, null, null);
COMMIT;

-- ----------------------------
-- Auto increment value for user
-- ----------------------------
ALTER TABLE `user` AUTO_INCREMENT=61;
