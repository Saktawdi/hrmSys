/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50728
Source Host           : localhost:3306
Source Database       : hrm

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2023-12-23 17:33:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `eID` varchar(12) NOT NULL COMMENT '档案编号',
  `eL1InstID` varchar(6) DEFAULT NULL COMMENT '一级机构',
  `eL2InstID` varchar(6) DEFAULT NULL COMMENT '二级机构',
  `eL3InstID` varchar(6) DEFAULT NULL COMMENT '三级机构',
  `ePositionCategory` varchar(200) DEFAULT NULL COMMENT '职位分类',
  `ePositionName` varchar(200) DEFAULT NULL COMMENT '职位名称',
  `eJobTitle` varchar(200) DEFAULT NULL COMMENT '职称名称',
  `eName` varchar(200) DEFAULT NULL COMMENT '姓名',
  `eGender` varchar(2) DEFAULT NULL COMMENT '性别',
  `eAge` smallint(3) DEFAULT NULL COMMENT '年龄',
  `eEmail` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `eFixedPhone` varchar(20) DEFAULT NULL COMMENT '固定电话',
  `eCellPhone` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `eQQ` varchar(50) DEFAULT NULL COMMENT 'QQ',
  `eAddress` varchar(200) DEFAULT NULL COMMENT '地址',
  `ePostcode` varchar(200) DEFAULT NULL COMMENT '邮编',
  `eBirthday` date DEFAULT NULL COMMENT '生日',
  `eBirthplace` varchar(200) DEFAULT NULL COMMENT '出生地',
  `eAvatar` varchar(200) DEFAULT NULL COMMENT '头像',
  `eIDcard` varchar(200) DEFAULT NULL COMMENT '身份证号码',
  `eSSC` varchar(200) DEFAULT NULL COMMENT '社会保障号码',
  `eCountry` varchar(200) DEFAULT NULL COMMENT '国家',
  `eEthnic` varchar(200) DEFAULT NULL COMMENT '民族',
  `eReligion` varchar(200) DEFAULT NULL COMMENT '宗教信仰',
  `ePolitical` varchar(200) DEFAULT NULL COMMENT '政治面貌',
  `eEducation` varchar(200) DEFAULT NULL COMMENT '学历',
  `eMajor` varchar(200) DEFAULT NULL COMMENT '学历专业',
  `eSalary` varchar(200) DEFAULT NULL COMMENT '薪酬标准编号',
  `eBankName` varchar(200) DEFAULT NULL COMMENT '开户银行',
  `eBankAccount` varchar(200) DEFAULT NULL COMMENT '银行账号',
  `eHobby` varchar(200) DEFAULT NULL COMMENT '爱好',
  `eSpecicalty` varchar(200) DEFAULT NULL COMMENT '特长',
  `eResume` text COMMENT '简历',
  `eFamily` text COMMENT '家庭关系',
  `eRemarks` text COMMENT '备注',
  `eRecoders` varchar(12) DEFAULT NULL COMMENT '登记人',
  `eRecodDate` date DEFAULT NULL COMMENT '登记时间',
  `eStatus` varchar(50) DEFAULT NULL COMMENT '档案状态',
  PRIMARY KEY (`eID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of employee
-- ----------------------------

-- ----------------------------
-- Table structure for institution
-- ----------------------------
DROP TABLE IF EXISTS `institution`;
CREATE TABLE `institution` (
  `iID` varchar(6) NOT NULL COMMENT '机构编号',
  `iName` varchar(200) DEFAULT NULL COMMENT '机构名',
  `iLevel` int(3) DEFAULT NULL COMMENT '机构等级',
  `iParent` varchar(6) DEFAULT NULL COMMENT '上级机构编号',
  PRIMARY KEY (`iID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of institution
-- ----------------------------

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parent_id` int(10) DEFAULT NULL COMMENT '父级id',
  `mCode` varchar(200) DEFAULT NULL COMMENT '资源编号user.add',
  `mName` varchar(200) DEFAULT NULL COMMENT '名字',
  `sort` int(3) DEFAULT '0' COMMENT '优先级',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', null, 'user.*', '用户管理', '0');
INSERT INTO `menu` VALUES ('2', '1', 'user.add', '添加', '0');
INSERT INTO `menu` VALUES ('3', '1', 'user.all', '列表', '0');
INSERT INTO `menu` VALUES ('4', '1', 'user.delete', '删除', '0');
INSERT INTO `menu` VALUES ('5', '1', 'user.update', '更新', '0');
INSERT INTO `menu` VALUES ('6', null, 'role.*', '角色管理', '0');
INSERT INTO `menu` VALUES ('7', '6', 'role.all', '列表', '0');
INSERT INTO `menu` VALUES ('8', '6', 'role.add', '添加', '0');
INSERT INTO `menu` VALUES ('9', '6', 'role.delete', '删除', '0');
INSERT INTO `menu` VALUES ('10', '6', 'role.update', '更新', '0');
INSERT INTO `menu` VALUES ('11', '1', 'user.get', '查询', '0');
INSERT INTO `menu` VALUES ('12', null, 'auth.*', '权限管理', '0');
INSERT INTO `menu` VALUES ('13', '12', 'auth.add', '分配角色', '0');
INSERT INTO `menu` VALUES ('14', '12', 'auth.update', '更新', '0');
INSERT INTO `menu` VALUES ('15', '12', 'auth.delete', '删除', '0');
INSERT INTO `menu` VALUES ('16', '12', 'auth.get', '查询', '0');
INSERT INTO `menu` VALUES ('17', null, 'menu.*', '菜单管理', '0');
INSERT INTO `menu` VALUES ('18', '17', 'menu.add', '添加', '0');
INSERT INTO `menu` VALUES ('19', '17', 'menu.all', '列表', '0');
INSERT INTO `menu` VALUES ('20', '17', 'menu.get', '查询', '0');
INSERT INTO `menu` VALUES ('21', '17', 'menu.update', '更新', '0');
INSERT INTO `menu` VALUES ('22', '17', 'menu.delete', '删除', '0');

-- ----------------------------
-- Table structure for menu_role
-- ----------------------------
DROP TABLE IF EXISTS `menu_role`;
CREATE TABLE `menu_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `rID` int(10) NOT NULL COMMENT '角色id',
  `mID` int(10) NOT NULL COMMENT '菜单id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of menu_role
-- ----------------------------
INSERT INTO `menu_role` VALUES ('1', '1', '1');
INSERT INTO `menu_role` VALUES ('2', '1', '6');
INSERT INTO `menu_role` VALUES ('3', '1', '12');

-- ----------------------------
-- Table structure for position
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position` (
  `pID` int(3) NOT NULL AUTO_INCREMENT COMMENT '职位编号',
  `pName` varchar(200) DEFAULT NULL COMMENT '职位名',
  `pCategory` varchar(200) DEFAULT NULL COMMENT '职位分类',
  PRIMARY KEY (`pID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of position
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `rID` int(10) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `rCode` varchar(200) NOT NULL COMMENT '角色编码',
  `rName` varchar(200) NOT NULL COMMENT '角色名称',
  PRIMARY KEY (`rID`),
  UNIQUE KEY `角色id` (`rID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'admin', '超级管理员');
INSERT INTO `role` VALUES ('2', 'employee', '职员');
INSERT INTO `role` VALUES ('3', 'test', '测试人员');

-- ----------------------------
-- Table structure for salary
-- ----------------------------
DROP TABLE IF EXISTS `salary`;
CREATE TABLE `salary` (
  `sID` int(3) NOT NULL COMMENT '标准编号',
  `sName` double DEFAULT NULL COMMENT '标准名',
  `sBasic` double DEFAULT NULL COMMENT '基本工资',
  `sTransport` double DEFAULT NULL COMMENT '交通补助',
  `sLunch` double DEFAULT NULL COMMENT '午餐补助',
  `sCommunicate` double DEFAULT NULL COMMENT '通讯补助',
  `sPension` double DEFAULT NULL COMMENT '养老保险',
  `sMedical` double DEFAULT NULL COMMENT '医疗保险',
  `sUnemployment` double DEFAULT NULL COMMENT '失业保险',
  `sRecorder` int(12) DEFAULT NULL COMMENT '记录人',
  `sRecordDate` date DEFAULT NULL COMMENT '记录时间',
  `sMaker` varchar(50) DEFAULT NULL COMMENT '制定人',
  `sStatus` int(3) DEFAULT NULL COMMENT '标准状态',
  PRIMARY KEY (`sID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of salary
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uID` varchar(12) NOT NULL COMMENT '用户工号',
  `uName` varchar(200) DEFAULT NULL COMMENT '用户姓名',
  `uPassword` varchar(200) DEFAULT NULL COMMENT '用户密码',
  PRIMARY KEY (`uID`),
  UNIQUE KEY `uID` (`uID`) COMMENT '唯一uID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'sakta', '2EF6A6E4B3CAA4456C4326E912313EEC');
INSERT INTO `user` VALUES ('666', '点众对回', 'E10ADC3949BA59ABBE56E057F20F883E');
INSERT INTO `user` VALUES ('88', '越听参历命', '5B99BEDFE35C38E6E85D5D44AC5290A8');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uID` varchar(12) NOT NULL COMMENT '用户工号',
  `rID` int(10) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1');
INSERT INTO `user_role` VALUES ('10', '666', '3');
