CREATE DATABASE test1;
USE test1;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `dep_id` int(11) NOT NULL AUTO_INCREMENT,
  `dep_name` varchar(50) NOT NULL COMMENT '部门名称',
  PRIMARY KEY (`dep_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', 'java');
INSERT INTO `department` VALUES ('2', 'css');
INSERT INTO `department` VALUES ('3', 'html');
INSERT INTO `department` VALUES ('4', 'c');
INSERT INTO `department` VALUES ('5', 'c++');
INSERT INTO `department` VALUES ('6', 'jdbc');
INSERT INTO `department` VALUES ('7', 'jdbc2');
INSERT INTO `department` VALUES ('9', 'jdbc4');
INSERT INTO `department` VALUES ('12', 'jdbc5');
INSERT INTO `department` VALUES ('14', '54444');
INSERT INTO `department` VALUES ('15', '研发部');
INSERT INTO `department` VALUES ('17', '研发部1');
INSERT INTO `department` VALUES ('19', '研发部3');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(50) NOT NULL COMMENT '用户名',
  `emp_age` int(11) DEFAULT NULL,
  `emp_sex` int(11) DEFAULT '1' COMMENT '性别 1= 男  ，0 = 女',
  `password` int(11) DEFAULT NULL,
  `dep_id` int(11) DEFAULT NULL,
  `delete_flag` varchar(255) NOT NULL DEFAULT '1' COMMENT '1 就是有效 ， 0就是无效',
  PRIMARY KEY (`emp_id`),
  UNIQUE KEY `empName` (`emp_name`),
  KEY `depId` (`dep_id`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`dep_id`) REFERENCES `department` (`dep_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', 'waner', '12', '1', '123', null, '1');
INSERT INTO `employee` VALUES ('2', 'wangba', '12', '1', '123', null, '1');
INSERT INTO `employee` VALUES ('3', '张三', '12', '2', '123', null, '1');
INSERT INTO `employee` VALUES ('4', '李四', '12', '1', '123', null, '1');
INSERT INTO `employee` VALUES ('7', 'waner2', '12', '1', '123', null, '1');
INSERT INTO `employee` VALUES ('8', 'wangba2', '12', '2', '123', null, '1');
INSERT INTO `employee` VALUES ('9', 'waner3', '12', '1', '123', null, '1');
INSERT INTO `employee` VALUES ('10', 'wangba3', '12', '1', '123', null, '1');
INSERT INTO `employee` VALUES ('11', 'hahah', '22', '2', null, '5', '1');
INSERT INTO `employee` VALUES ('12', '123', '22', '2', null, '5', '1');
INSERT INTO `employee` VALUES ('13', 'ddddd', '22', '2', null, '5', '1');
INSERT INTO `employee` VALUES ('14', 'ffff', null, '1', null, null, '1');
INSERT INTO `employee` VALUES ('16', '12312', null, '1', null, null, '1');
INSERT INTO `employee` VALUES ('17', '54321', null, '1', null, null, '1');
INSERT INTO `employee` VALUES ('19', '54322', '88', '1', null, null, '1');
INSERT INTO `employee` VALUES ('20', '54333', '66', '1', null, null, '1');
INSERT INTO `employee` VALUES ('25', '54444', '33', '1', null, '14', '1');
INSERT INTO `employee` VALUES ('26', '20180110', null, '1', '123456789', '15', '1');
INSERT INTO `employee` VALUES ('30', '20180111', null, '1', '123456789', '19', '1');

-- ----------------------------
-- Table structure for idcard
-- ----------------------------
DROP TABLE IF EXISTS `idcard`;
CREATE TABLE `idcard` (
  `cardId` int(11) NOT NULL AUTO_INCREMENT,
  `cardNo` varchar(30) NOT NULL,
  `address1` varchar(100) NOT NULL,
  PRIMARY KEY (`cardId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of idcard
-- ----------------------------
INSERT INTO `idcard` VALUES ('1', '123', 'ssss');
INSERT INTO `idcard` VALUES ('2', '42342', 'dsfs');
INSERT INTO `idcard` VALUES ('3', 'qwe', 'eqw');
INSERT INTO `idcard` VALUES ('4', 'xxxx', 'xxxxx');

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `personId` int(10) NOT NULL AUTO_INCREMENT,
  `personName` varchar(50) NOT NULL,
  `personAge` varchar(3) DEFAULT NULL,
  `cardId` int(11) NOT NULL,
  PRIMARY KEY (`personId`),
  KEY `personName` (`personName`),
  KEY `cardId` (`cardId`),
  CONSTRAINT `person_ibfk_1` FOREIGN KEY (`cardId`) REFERENCES `idcard` (`cardId`)
) ENGINE=InnoDB AUTO_INCREMENT=1003 DEFAULT CHARSET=utf8 COMMENT='xxxx';

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('1000', '张三', '12', '1');
INSERT INTO `person` VALUES ('1001', '李四', '55', '2');
INSERT INTO `person` VALUES ('1002', '王二', '33', '3');

-- ----------------------------
-- Table structure for sousuo
-- ----------------------------
DROP TABLE IF EXISTS `sousuo`;
CREATE TABLE `sousuo` (
  `sousuo_id` int(10) NOT NULL AUTO_INCREMENT,
  `sousuo_name` varchar(255) NOT NULL,
  PRIMARY KEY (`sousuo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sousuo
-- ----------------------------
INSERT INTO `sousuo` VALUES ('1', 'aaaa');
INSERT INTO `sousuo` VALUES ('2', 'abbbb');
INSERT INTO `sousuo` VALUES ('3', 'acccc');
INSERT INTO `sousuo` VALUES ('4', 'fsgrsd');
INSERT INTO `sousuo` VALUES ('5', 'htynghc');
INSERT INTO `sousuo` VALUES ('6', 'vdfxsd');
INSERT INTO `sousuo` VALUES ('7', 'vfdghty');
INSERT INTO `sousuo` VALUES ('8', 'trynbgfx');
INSERT INTO `sousuo` VALUES ('9', 'hykfdgs');
INSERT INTO `sousuo` VALUES ('10', 'gsrtr');
INSERT INTO `sousuo` VALUES ('11', 'csrevx');
INSERT INTO `sousuo` VALUES ('12', 'vsrtgsdf');
INSERT INTO `sousuo` VALUES ('13', 'bffff');
INSERT INTO `sousuo` VALUES ('14', 'bkkkk');
INSERT INTO `sousuo` VALUES ('15', 'cdddd');
INSERT INTO `sousuo` VALUES ('16', 'cccccc');
INSERT INTO `sousuo` VALUES ('17', 'aggggg');
INSERT INTO `sousuo` VALUES ('18', 'adddd');
INSERT INTO `sousuo` VALUES ('19', 'arrrr');

-- ----------------------------
-- Table structure for t
-- ----------------------------
DROP TABLE IF EXISTS `t`;
CREATE TABLE `t` (
  `id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t
-- ----------------------------
INSERT INTO `t` VALUES ('1');
INSERT INTO `t` VALUES ('100');
INSERT INTO `t` VALUES ('0');
INSERT INTO `t` VALUES ('99');
INSERT INTO `t` VALUES ('88');

-- ----------------------------
-- Table structure for t1
-- ----------------------------
DROP TABLE IF EXISTS `t1`;
CREATE TABLE `t1` (
  `id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t1
-- ----------------------------
INSERT INTO `t1` VALUES ('88');

-- ----------------------------
-- Table structure for t2
-- ----------------------------
DROP TABLE IF EXISTS `t2`;
CREATE TABLE `t2` (
  `t_id` int(11) NOT NULL,
  `t_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t2
-- ----------------------------
INSERT INTO `t2` VALUES ('1', '222');

-- ----------------------------
-- Procedure structure for test
-- ----------------------------
DROP PROCEDURE IF EXISTS `test`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `test`()
BEGIN
		select * from t;
		select * from t;
		select * from t;
	END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for test2
-- ----------------------------
DROP PROCEDURE IF EXISTS `test2`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `test2`(in param1 INT,out param2 int ,INOUT param3 VARCHAR(22))
BEGIN
			SET param1 = 20;
			set param2 = param1 * param1;
			SET	param3 = CONCAT(param3,'aaaa','bbbb');
		END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for test3
-- ----------------------------
DROP PROCEDURE IF EXISTS `test3`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `test3`(in param1 INT,OUT param2 VARCHAR(50))
BEGIN
		IF (param1 > 0) THEN
			select '我大于0' into param2;
		ELSEIF (param1 < 0) THEN
			select '我小于0' into param2;
		ELSE
			select '我等于0' into param2;
		END IF;
	END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for f
-- ----------------------------
DROP FUNCTION IF EXISTS `f`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `f`() RETURNS varchar(55) CHARSET utf8
BEGIN
			return 'zzzzz';
		END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for f2
-- ----------------------------
DROP FUNCTION IF EXISTS `f2`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `f2`(param VARCHAR(55)) RETURNS varchar(55) CHARSET utf8
BEGIN
			select empName into param from employee where empId =1;
			return param;
		END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for f3
-- ----------------------------
DROP FUNCTION IF EXISTS `f3`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `f3`() RETURNS varchar(55) CHARSET utf8
BEGIN
			-- 声明一个参数 -- 
			DECLARE str VARCHAR(50);
			--  初始化参数 -- 
			set str = 'aaaa';
			select empName into str from employee where empId =1;
			return str;
		END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for f4
-- ----------------------------
DROP FUNCTION IF EXISTS `f4`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `f4`(p int) RETURNS int(11)
BEGIN 
		DECLARE param int;
		SET param = 0;
		IF (p>0) THEN
			SELECT p INTO param;
		ELSE
			select -p into param;
		END IF;
		return param;
	END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `t_TRIGGER`;
DELIMITER ;;
CREATE TRIGGER `t_TRIGGER` BEFORE INSERT ON `t` FOR EACH ROW BEGIN
			IF new.id < 0 THEN
				SET new.id = 0;
			ELSEIF new.id > 100 THEN
				SET new.id = 100;
			END IF;
		END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `t_TRIGGER3`;
DELIMITER ;;
CREATE TRIGGER `t_TRIGGER3` BEFORE INSERT ON `t` FOR EACH ROW BEGIN
		insert INTO t1 VALUES(new.id);
	END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `t_TRIGGER4`;
DELIMITER ;;
CREATE TRIGGER `t_TRIGGER4` BEFORE INSERT ON `t` FOR EACH ROW BEGIN
		DELETE from t where id = 0;
	END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `t_TRIGGER2`;
DELIMITER ;;
CREATE TRIGGER `t_TRIGGER2` BEFORE UPDATE ON `t` FOR EACH ROW BEGIN
		if new.id = 10 THEN
			SET new.id = old.id;
		END IF;
	END
;;
DELIMITER ;
