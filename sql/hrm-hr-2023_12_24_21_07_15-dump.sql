-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: hrm
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
  `eAge` smallint DEFAULT NULL COMMENT '年龄',
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
  `eStatus` int DEFAULT '0' COMMENT '档案状态',
  PRIMARY KEY (`eID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('1','一级机构','二级机构','三级机构','测试类','测试职位','测试职称','test','男性',11,'test@gmail.com','0763','12345678901','123456','测试地址','513400','2023-12-23','湛江','头像url','441882202311111111','123456789','中国','瑶族','无','群众','本科','软件工程','10','建设银行','11111111','唱跳rap篮球','唱跳rap篮球','简介测试','家庭关系测试','备注','管理员','2023-12-23',0);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `institution`
--

DROP TABLE IF EXISTS `institution`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `institution` (
  `iID` varchar(6) NOT NULL COMMENT '机构编号',
  `iName` varchar(200) NOT NULL COMMENT '机构名',
  `iLevel` int NOT NULL COMMENT '机构等级',
  `iParent` varchar(6) DEFAULT NULL COMMENT '上级机构编号',
  PRIMARY KEY (`iID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `institution`
--

LOCK TABLES `institution` WRITE;
/*!40000 ALTER TABLE `institution` DISABLE KEYS */;
INSERT INTO `institution` VALUES ('1','一级机构测试',1,NULL),('2','二级机构测试',2,'1'),('3','三级机构测试',3,'2');
/*!40000 ALTER TABLE `institution` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parent_id` int DEFAULT NULL COMMENT '父级id',
  `mCode` varchar(200) DEFAULT NULL COMMENT '资源编号user.add',
  `mName` varchar(200) DEFAULT NULL COMMENT '名字',
  `sort` int DEFAULT '0' COMMENT '优先级',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,NULL,'user.*','用户管理',0),(2,1,'user.add','添加',0),(3,1,'user.all','列表',0),(4,1,'user.delete','删除',0),(5,1,'user.update','更新',0),(6,NULL,'role.*','角色管理',0),(7,6,'role.all','列表',0),(8,6,'role.add','添加',0),(9,6,'role.delete','删除',0),(10,6,'role.update','更新',0),(11,1,'user.get','查询',0),(12,NULL,'auth.*','权限管理',0),(13,12,'auth.add','分配角色',0),(14,12,'auth.update','更新',0),(15,12,'auth.delete','删除',0),(16,12,'auth.get','查询',0),(17,NULL,'menu.*','菜单管理',0),(18,17,'menu.add','添加',0),(19,17,'menu.all','列表',0),(20,17,'menu.get','查询',0),(21,17,'menu.update','更新',0),(22,17,'menu.delete','删除',0),(23,NULL,'position.*','职位管理',0),(24,23,'position.all','职位列表查询',0),(25,23,'position.get','职位详细信息查询',0),(26,23,'position.add','职位添加',0),(27,23,'position.update','职位编辑',0),(28,23,'position.delete','职位删除',0),(29,NULL,'employee.*','档案管理',0),(30,29,'employee.get','查询',0),(31,29,'employee.add','添加',0),(32,29,'employee.all','列表',0),(33,29,'employee.update','编辑',0),(34,29,'employee.delete','删除',0),(35,NULL,'institution.*','机构管理',0),(36,35,'institution.get','查询',0),(37,35,'institution.all','列表',0),(38,35,'institution.add','添加',0),(39,35,'institution.update','编辑',0),(40,35,'institution.delete','删除',0),(41,NULL,'salary.*','薪酬管理',0),(42,41,'salary.all','列表',0),(43,41,'salary.get','查询',0),(44,41,'salary.add','添加',0),(45,41,'salary.update','编辑',0),(46,41,'salary.delete','删除',0);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu_role`
--

DROP TABLE IF EXISTS `menu_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu_role` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `rID` int NOT NULL COMMENT '角色id',
  `mID` int NOT NULL COMMENT '菜单id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu_role`
--

LOCK TABLES `menu_role` WRITE;
/*!40000 ALTER TABLE `menu_role` DISABLE KEYS */;
INSERT INTO `menu_role` VALUES (1,1,1),(2,1,6),(3,1,12);
/*!40000 ALTER TABLE `menu_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position`
--

DROP TABLE IF EXISTS `position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `position` (
  `pID` int NOT NULL AUTO_INCREMENT COMMENT '职位编号',
  `pName` varchar(200) DEFAULT NULL COMMENT '职位名',
  `pCategory` varchar(200) DEFAULT NULL COMMENT '职位分类',
  PRIMARY KEY (`pID`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position`
--

LOCK TABLES `position` WRITE;
/*!40000 ALTER TABLE `position` DISABLE KEYS */;
INSERT INTO `position` VALUES (1,'职位测试','测试类');
/*!40000 ALTER TABLE `position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `rID` int NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `rCode` varchar(200) NOT NULL COMMENT '角色编码',
  `rName` varchar(200) NOT NULL COMMENT '角色名称',
  PRIMARY KEY (`rID`),
  UNIQUE KEY `角色id` (`rID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'admin','超级管理员'),(2,'employee','职员'),(3,'test','测试人员');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salary`
--

DROP TABLE IF EXISTS `salary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salary` (
  `sID` int NOT NULL COMMENT '标准编号',
  `sName` varchar(200) DEFAULT NULL COMMENT '标准名',
  `sBasic` double DEFAULT NULL COMMENT '基本工资',
  `sTransport` double DEFAULT NULL COMMENT '交通补助',
  `sLunch` double DEFAULT NULL COMMENT '午餐补助',
  `sCommunicate` double DEFAULT NULL COMMENT '通讯补助',
  `sPension` double DEFAULT NULL COMMENT '养老保险',
  `sMedical` double DEFAULT NULL COMMENT '医疗保险',
  `sUnemployment` double DEFAULT NULL COMMENT '失业保险',
  `sRecorder` varchar(200) DEFAULT NULL COMMENT '记录人,uid',
  `sRecordDate` date DEFAULT NULL COMMENT '记录时间',
  `sMaker` varchar(200) DEFAULT NULL COMMENT '制定人,uid',
  `sStatus` int DEFAULT '0' COMMENT '标准状态',
  PRIMARY KEY (`sID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary`
--

LOCK TABLES `salary` WRITE;
/*!40000 ALTER TABLE `salary` DISABLE KEYS */;
INSERT INTO `salary` VALUES (1,'薪资测试',1000,100,500,129,123,50,300,'1','2023-12-23','2',0);
/*!40000 ALTER TABLE `salary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `uID` varchar(12) NOT NULL COMMENT '用户工号',
  `uName` varchar(200) DEFAULT NULL COMMENT '用户姓名',
  `uPassword` varchar(200) DEFAULT NULL COMMENT '用户密码',
  PRIMARY KEY (`uID`),
  UNIQUE KEY `uID` (`uID`) COMMENT '唯一uID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('1','sakta','2EF6A6E4B3CAA4456C4326E912313EEC'),('666','点众对回','E10ADC3949BA59ABBE56E057F20F883E'),('88','越听参历命','5B99BEDFE35C38E6E85D5D44AC5290A8');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uID` varchar(12) NOT NULL COMMENT '用户工号',
  `rID` int NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,'1',1),(10,'666',3);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-24 21:07:16
