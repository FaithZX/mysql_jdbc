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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

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
