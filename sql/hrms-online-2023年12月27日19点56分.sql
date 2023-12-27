-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- 主机： localhost
-- 生成日期： 2023-12-27 19:56:14
-- 服务器版本： 5.6.50-log
-- PHP 版本： 7.2.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 数据库： `hrms`
--

-- --------------------------------------------------------

--
-- 表的结构 `bonus`
--

CREATE TABLE `bonus` (
  `bID` int(11) NOT NULL,
  `bReward` decimal(10,2) DEFAULT NULL COMMENT '奖励奖金',
  `bReduce` decimal(10,2) DEFAULT NULL COMMENT '应扣奖金',
  `eID` varchar(12) DEFAULT NULL COMMENT '档案编号,eID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `bonus`
--

INSERT INTO `bonus` (`bID`, `bReward`, `bReduce`, `eID`) VALUES
(3, '100.00', '0.00', '202310111101'),
(4, '500.00', '0.00', '202310111102'),
(5, '0.00', '0.00', '202310111201'),
(6, '0.00', '0.00', '202310111202');

-- --------------------------------------------------------

--
-- 表的结构 `employee`
--

CREATE TABLE `employee` (
  `eID` varchar(20) NOT NULL COMMENT '档案编号',
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
  `eRecodDate` datetime DEFAULT NULL COMMENT '登记时间',
  `eStatus` int(3) DEFAULT '0' COMMENT '档案状态'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `employee`
--

INSERT INTO `employee` (`eID`, `eL1InstID`, `eL2InstID`, `eL3InstID`, `ePositionCategory`, `ePositionName`, `eJobTitle`, `eName`, `eGender`, `eAge`, `eEmail`, `eFixedPhone`, `eCellPhone`, `eQQ`, `eAddress`, `ePostcode`, `eBirthday`, `eBirthplace`, `eAvatar`, `eIDcard`, `eSSC`, `eCountry`, `eEthnic`, `eReligion`, `ePolitical`, `eEducation`, `eMajor`, `eSalary`, `eBankName`, `eBankAccount`, `eHobby`, `eSpecicalty`, `eResume`, `eFamily`, `eRemarks`, `eRecoders`, `eRecodDate`, `eStatus`) VALUES
('202310111101', '10', '11', '111', '技术', '软件工程师', 'Java后端工程师', '黄睿', '男', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.freeimg.cn/i/2023/12/25/65894055eed2f.jpg', NULL, NULL, NULL, '汉', NULL, NULL, '本科', NULL, '9', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'tests', '2023-12-27 17:53:52', 1),
('202310111102', '10', '11', '111', '技术', '软件工程师', '全栈工程师', '石晨锋', '男', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.freeimg.cn/i/2023/12/27/658bf43f8cae5.png', NULL, NULL, NULL, '汉', NULL, NULL, '本科', NULL, '9', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'tests', '2023-12-27 17:54:21', 1),
('202310111201', '10', '11', '112', '技术', '测试工程师', '接口测试', '毛孝明', '男', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.freeimg.cn/i/2023/12/26/658a4bf73d382.jpg', NULL, NULL, NULL, '汉', NULL, NULL, '本科', NULL, '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'tests', '2023-12-27 17:57:42', 1),
('202310111202', '10', '11', '112', '技术', '测试工程师', '前端页面测试', '许蓝琪', '女', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'https://www.freeimg.cn/i/2023/12/27/658bf52ad39df.jpg', NULL, NULL, NULL, '汉', NULL, NULL, '本科', NULL, '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'tests', '2023-12-27 17:58:12', 0);

-- --------------------------------------------------------

--
-- 表的结构 `institution`
--

CREATE TABLE `institution` (
  `iID` varchar(6) NOT NULL COMMENT '机构编号',
  `iName` varchar(200) NOT NULL COMMENT '机构名',
  `iLevel` int(3) NOT NULL COMMENT '机构等级',
  `iParent` varchar(6) DEFAULT NULL COMMENT '上级机构编号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `institution`
--

INSERT INTO `institution` (`iID`, `iName`, `iLevel`, `iParent`) VALUES
('10', '总公司', 1, NULL),
('11', '人力资源部', 2, '10'),
('111', '开发组', 3, '11'),
('112', '测试组', 3, '11'),
('12', '财务部', 2, '10'),
('20', '分公司 A', 1, NULL),
('21', '销售部', 2, '20'),
('22', '宣传部', 2, '20'),
('221', '会计组', 3, '22'),
('222', '财务分析组', 3, '22'),
('30', '分公司B', 1, NULL),
('31', '投资部门', 2, '30');

-- --------------------------------------------------------

--
-- 表的结构 `menu`
--

CREATE TABLE `menu` (
  `id` int(10) NOT NULL COMMENT '主键',
  `parentId` int(10) DEFAULT NULL COMMENT '父级id',
  `mCode` varchar(200) DEFAULT NULL COMMENT '资源编号user.add',
  `mName` varchar(200) DEFAULT NULL COMMENT '名字',
  `sort` int(3) DEFAULT '0' COMMENT '优先级'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `menu`
--

INSERT INTO `menu` (`id`, `parentId`, `mCode`, `mName`, `sort`) VALUES
(1, NULL, 'user.*', '用户管理', 0),
(2, 1, 'user.add', '添加', 0),
(3, 1, 'user.all', '列表', 0),
(4, 1, 'user.delete', '删除', 0),
(5, 1, 'user.update', '更新', 0),
(6, NULL, 'role.*', '角色管理', 0),
(7, 6, 'role.all', '列表', 0),
(8, 6, 'role.add', '添加', 0),
(9, 6, 'role.delete', '删除', 0),
(10, 6, 'role.update', '更新', 0),
(11, 1, 'user.get', '查询', 0),
(12, NULL, 'auth.*', '权限管理', 0),
(13, 12, 'auth.add', '分配角色', 0),
(14, 12, 'auth.update', '更新', 0),
(15, 12, 'auth.delete', '删除', 0),
(16, 12, 'auth.get', '查询', 0),
(17, NULL, 'menu.*', '菜单管理', 0),
(18, 17, 'menu.add', '添加', 0),
(19, 17, 'menu.all', '列表', 0),
(20, 17, 'menu.get', '查询', 0),
(21, 17, 'menu.update', '更新', 0),
(22, 17, 'menu.delete', '删除', 0),
(23, NULL, 'position.*', '职位管理', 0),
(24, 23, 'position.all', '职位列表查询', 0),
(25, 23, 'position.get', '职位详细信息查询', 0),
(26, 23, 'position.add', '职位添加', 0),
(27, 23, 'position.update', '职位编辑', 0),
(28, 23, 'position.delete', '职位删除', 0),
(29, NULL, 'employee.*', '档案管理', 0),
(30, 29, 'employee.get', '查询', 0),
(31, 29, 'employee.add', '添加', 0),
(32, 29, 'employee.all', '列表', 0),
(33, 29, 'employee.update', '编辑', 0),
(34, 29, 'employee.delete', '删除', 0),
(35, NULL, 'institution.*', '机构管理', 0),
(36, 35, 'institution.get', '查询', 0),
(37, 35, 'institution.all', '列表', 0),
(38, 35, 'institution.add', '添加', 0),
(39, 35, 'institution.update', '编辑', 0),
(40, 35, 'institution.delete', '删除', 0),
(41, NULL, 'salary.*', '薪酬管理', 0),
(42, 41, 'salary.all', '列表', 0),
(43, 41, 'salary.get', '查询', 0),
(44, 41, 'salary.add', '添加', 0),
(45, 41, 'salary.update', '编辑', 0),
(46, 41, 'salary.delete', '删除', 0),
(47, 29, 'employee.recover', '恢复档案', 0),
(48, 29, 'employee.approved', '审核档案', 0),
(50, 41, 'salary.approved', '薪酬复核', 0),
(51, NULL, 'bonus.*', '奖金', 0),
(52, 51, 'bonus.get', '获取', 0),
(53, 51, 'bonus.update', '更新', 0),
(54, 51, 'bonus.add', '新增', 0),
(55, 51, 'bonus.delete', '发放删除', 0);

-- --------------------------------------------------------

--
-- 表的结构 `menu_role`
--

CREATE TABLE `menu_role` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `rID` int(10) NOT NULL COMMENT '角色id',
  `mID` int(10) NOT NULL COMMENT '菜单id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `menu_role`
--

INSERT INTO `menu_role` (`id`, `rID`, `mID`) VALUES
(1, 1, 1),
(2, 1, 6),
(3, 1, 12),
(4, 3, 6),
(5, 3, 12),
(6, 3, 17),
(7, 3, 23),
(8, 3, 29),
(9, 3, 35),
(10, 3, 41),
(11, 3, 1),
(12, 1, 2),
(13, 1, 4),
(14, 1, 5),
(15, 1, 9),
(16, 1, 8),
(17, 1, 3),
(18, 1, 13),
(19, 1, 11),
(20, 1, 7),
(21, 1, 10),
(22, 1, 16),
(23, 1, 14),
(24, 1, 15),
(25, 1, 18),
(26, 1, 22),
(27, 1, 19),
(28, 1, 20),
(29, 1, 25),
(30, 1, 21),
(31, 1, 24),
(32, 1, 32),
(33, 1, 27),
(34, 1, 28),
(35, 1, 31),
(36, 1, 26),
(37, 1, 30),
(38, 1, 34),
(39, 1, 37),
(40, 1, 39),
(41, 1, 36),
(42, 1, 38),
(43, 1, 33),
(44, 1, 43),
(45, 1, 44),
(46, 1, 46),
(47, 1, 42),
(48, 1, 45),
(49, 1, 40),
(50, 8, 32),
(51, 8, 31),
(52, 8, 33),
(53, 8, 30),
(54, 9, 30),
(55, 9, 47),
(56, 9, 34),
(57, 9, 32),
(58, 9, 48),
(59, 8, 36),
(60, 8, 43),
(61, 8, 42),
(62, 9, 36),
(63, 9, 42),
(64, 8, 24),
(65, 9, 24),
(66, 1, 48),
(67, 1, 47),
(68, 1, 50),
(69, 3, 2),
(70, 3, 5),
(71, 3, 4),
(72, 3, 3),
(73, 3, 7),
(74, 3, 11),
(75, 3, 8),
(76, 3, 10),
(77, 3, 15),
(78, 3, 9),
(79, 3, 14),
(80, 3, 13),
(81, 3, 16),
(82, 3, 22),
(83, 3, 20),
(84, 3, 19),
(85, 3, 18),
(86, 3, 24),
(87, 3, 21),
(88, 3, 25),
(89, 3, 26),
(90, 3, 27),
(91, 3, 31),
(92, 3, 30),
(93, 3, 28),
(94, 3, 32),
(95, 3, 33),
(96, 3, 48),
(97, 3, 47),
(98, 3, 36),
(99, 3, 34),
(100, 3, 37),
(101, 3, 38),
(102, 3, 40),
(103, 3, 39),
(104, 3, 43),
(105, 3, 42),
(106, 3, 44),
(107, 3, 45),
(108, 3, 46),
(109, 3, 50),
(110, 3, 52),
(111, 3, 53),
(112, 3, 54),
(113, 3, 55);

-- --------------------------------------------------------

--
-- 表的结构 `payroll`
--

CREATE TABLE `payroll` (
  `pID` int(11) NOT NULL COMMENT '薪酬发放单编号',
  `pL1InstName` varchar(6) DEFAULT NULL COMMENT '一级机构名称',
  `pL2InstName` varchar(6) DEFAULT NULL COMMENT '二级机构名称',
  `pL3InstName` varchar(6) DEFAULT NULL COMMENT '三级机构名称',
  `pCount` int(11) DEFAULT NULL COMMENT '人数',
  `pSalarySum` decimal(10,2) DEFAULT NULL COMMENT '基本薪资总额',
  `pL3InstID` int(11) DEFAULT NULL COMMENT '三级机构编号',
  `pStatus` int(11) DEFAULT NULL,
  `pMaker` varchar(12) DEFAULT NULL,
  `pPayslips` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `payroll`
--

INSERT INTO `payroll` (`pID`, `pL1InstName`, `pL2InstName`, `pL3InstName`, `pCount`, `pSalarySum`, `pL3InstID`, `pStatus`, `pMaker`, `pPayslips`) VALUES
(12, '总公司', '人力资源部', '开发组', 2, '24000.00', 111, 1, '123456', '[{\"stransport\":150,\"slunch\":150,\"scommunicate\":150,\"spension\":960,\"smedical\":243,\"sunemployment\":60,\"shouse\":960,\"sbasic\":12000,\"breward\":100,\"breduce\":0,\"eid\":\"202310111101\",\"ename\":\"黄睿\"},{\"stransport\":150,\"slunch\":150,\"scommunicate\":150,\"spension\":960,\"smedical\":243,\"sunemployment\":60,\"shouse\":960,\"sbasic\":12000,\"breward\":500,\"breduce\":0,\"eid\":\"202310111102\",\"ename\":\"石晨锋\"}]');

-- --------------------------------------------------------

--
-- 表的结构 `position`
--

CREATE TABLE `position` (
  `pID` int(3) NOT NULL COMMENT '职位编号',
  `pName` varchar(200) DEFAULT NULL COMMENT '职位名',
  `pCategory` varchar(200) DEFAULT NULL COMMENT '职位分类'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `position`
--

INSERT INTO `position` (`pID`, `pName`, `pCategory`) VALUES
(1, '总经理', '管理'),
(2, '总裁', '管理'),
(3, '人力资源专员', '人力资源'),
(4, '财务分析师', '财务'),
(101, '软件工程师', '技术'),
(102, '人力资源专员', '人力资源'),
(103, '销售经理', '销售'),
(104, '财务分析师', '财务'),
(105, '测试工程师', '技术'),
(106, '客户服务代表', '客户服务'),
(107, '市场营销专员', '市场营销'),
(108, '会计', '财务'),
(109, '产品经理', '产品'),
(110, '行政助理', '行政'),
(112, '网络宣传专员', '市场营销');

-- --------------------------------------------------------

--
-- 表的结构 `role`
--

CREATE TABLE `role` (
  `rID` int(10) NOT NULL COMMENT '角色ID',
  `rCode` varchar(200) NOT NULL COMMENT '角色编码',
  `rName` varchar(200) NOT NULL COMMENT '角色名称'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `role`
--

INSERT INTO `role` (`rID`, `rCode`, `rName`) VALUES
(1, 'admin', '超级管理员'),
(2, 'employee', '职员'),
(3, 'test', '测试人员'),
(8, 'Personnel Commissioner', '人事专员'),
(9, 'Personnel Manager', '人事经理');

-- --------------------------------------------------------

--
-- 表的结构 `salary`
--

CREATE TABLE `salary` (
  `sID` int(11) NOT NULL COMMENT '标准编号',
  `sName` varchar(200) DEFAULT NULL COMMENT '标准名',
  `sBasic` decimal(10,2) DEFAULT NULL COMMENT '基本工资',
  `sTransport` decimal(10,2) DEFAULT NULL COMMENT '交通补助',
  `sLunch` decimal(10,2) DEFAULT NULL COMMENT '午餐补助',
  `sCommunicate` decimal(10,2) DEFAULT NULL COMMENT '通讯补助',
  `sPension` decimal(10,2) DEFAULT NULL COMMENT '养老保险',
  `sMedical` decimal(10,2) DEFAULT NULL COMMENT '医疗保险',
  `sUnemployment` decimal(10,2) DEFAULT NULL COMMENT '失业保险',
  `sHouse` decimal(10,2) DEFAULT NULL COMMENT '住房公积金',
  `sRecorder` varchar(200) DEFAULT NULL COMMENT '记录人,uid',
  `sRecordDate` datetime DEFAULT NULL COMMENT '记录时间',
  `sMaker` varchar(200) DEFAULT NULL COMMENT '制定人,uid',
  `sChecker` varchar(200) DEFAULT NULL COMMENT '审核人,uid',
  `sStatus` int(11) DEFAULT '0' COMMENT '标准状态',
  `sOpinion` text COMMENT '复核意见'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `salary`
--

INSERT INTO `salary` (`sID`, `sName`, `sBasic`, `sTransport`, `sLunch`, `sCommunicate`, `sPension`, `sMedical`, `sUnemployment`, `sHouse`, `sRecorder`, `sRecordDate`, `sMaker`, `sChecker`, `sStatus`, `sOpinion`) VALUES
(1, 'T1', '5000.00', '0.00', '0.00', '0.00', '400.00', '103.00', '25.00', '400.00', '123456', '2023-12-27 01:09:21', '张三', '123456', 1, NULL),
(2, 'T2', '6000.00', '0.00', '0.00', '0.00', '480.00', '123.00', '30.00', '480.00', '123456', '2023-12-27 11:41:50', '123456', '123456', 1, NULL),
(3, 'T3', '7000.00', '0.00', '0.00', '0.00', '560.00', '143.00', '35.00', '560.00', '123456', '2023-12-27 11:48:16', '123456', '123456', 1, NULL),
(4, 'T4', '8000.00', '0.00', '0.00', '0.00', '640.00', '163.00', '40.00', '640.00', '123456', '2023-12-27 11:48:36', '123456', NULL, 0, NULL),
(5, 'S1', '10000.00', '100.00', '100.00', '100.00', '800.00', '203.00', '50.00', '800.00', '123456', '2023-12-27 12:53:38', '123456', '123456', 1, '我觉得很好'),
(9, 'S2', '12000.00', '150.00', '150.00', '150.00', '960.00', '243.00', '60.00', '960.00', '123456', '2023-12-27 15:50:50', '123456', '123456', 1, NULL);

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE `user` (
  `uID` varchar(12) NOT NULL COMMENT '用户工号',
  `uName` varchar(200) DEFAULT NULL COMMENT '用户姓名',
  `uPassword` varchar(200) DEFAULT NULL COMMENT '用户密码'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `user`
--

INSERT INTO `user` (`uID`, `uName`, `uPassword`) VALUES
('1', 'sakta', 'D41D8CD98F00B204E9800998ECF8427E'),
('10086', '人事专员', 'E10ADC3949BA59ABBE56E057F20F883E'),
('1008611', '人事经理', 'E10ADC3949BA59ABBE56E057F20F883E'),
('123456', 'tests', 'E10ADC3949BA59ABBE56E057F20F883E'),
('666', '点众对回', 'E10ADC3949BA59ABBE56E057F20F883E'),
('88', '率位育', '8F0FF08573444847E3D90AD9B1891482');

-- --------------------------------------------------------

--
-- 表的结构 `user_role`
--

CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `uID` varchar(12) NOT NULL COMMENT '用户工号',
  `rID` int(10) NOT NULL COMMENT '角色ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `user_role`
--

INSERT INTO `user_role` (`id`, `uID`, `rID`) VALUES
(1, '1', 1),
(10, '666', 3),
(11, '123456', 3),
(12, '88', 7),
(13, '10086', 8),
(14, '1008611', 9);

--
-- 转储表的索引
--

--
-- 表的索引 `bonus`
--
ALTER TABLE `bonus`
  ADD PRIMARY KEY (`bID`);

--
-- 表的索引 `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`eID`);

--
-- 表的索引 `institution`
--
ALTER TABLE `institution`
  ADD PRIMARY KEY (`iID`);

--
-- 表的索引 `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `menu_role`
--
ALTER TABLE `menu_role`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `payroll`
--
ALTER TABLE `payroll`
  ADD PRIMARY KEY (`pID`);

--
-- 表的索引 `position`
--
ALTER TABLE `position`
  ADD PRIMARY KEY (`pID`);

--
-- 表的索引 `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`rID`),
  ADD UNIQUE KEY `角色id` (`rID`);

--
-- 表的索引 `salary`
--
ALTER TABLE `salary`
  ADD PRIMARY KEY (`sID`);

--
-- 表的索引 `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`uID`),
  ADD UNIQUE KEY `uID` (`uID`) COMMENT '唯一uID';

--
-- 表的索引 `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`id`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `bonus`
--
ALTER TABLE `bonus`
  MODIFY `bID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- 使用表AUTO_INCREMENT `menu`
--
ALTER TABLE `menu`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键', AUTO_INCREMENT=56;

--
-- 使用表AUTO_INCREMENT `menu_role`
--
ALTER TABLE `menu_role`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键', AUTO_INCREMENT=114;

--
-- 使用表AUTO_INCREMENT `payroll`
--
ALTER TABLE `payroll`
  MODIFY `pID` int(11) NOT NULL AUTO_INCREMENT COMMENT '薪酬发放单编号', AUTO_INCREMENT=19;

--
-- 使用表AUTO_INCREMENT `position`
--
ALTER TABLE `position`
  MODIFY `pID` int(3) NOT NULL AUTO_INCREMENT COMMENT '职位编号', AUTO_INCREMENT=113;

--
-- 使用表AUTO_INCREMENT `role`
--
ALTER TABLE `role`
  MODIFY `rID` int(10) NOT NULL AUTO_INCREMENT COMMENT '角色ID', AUTO_INCREMENT=10;

--
-- 使用表AUTO_INCREMENT `salary`
--
ALTER TABLE `salary`
  MODIFY `sID` int(11) NOT NULL AUTO_INCREMENT COMMENT '标准编号', AUTO_INCREMENT=10;

--
-- 使用表AUTO_INCREMENT `user_role`
--
ALTER TABLE `user_role`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键', AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
