/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : oa

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2019-02-21 14:07:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_department
-- ----------------------------
DROP TABLE IF EXISTS `t_department`;
CREATE TABLE `t_department` (
  `department_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '部门ID，作为主键',
  `department_name` varchar(60) DEFAULT NULL COMMENT '部门名称',
  `department_manager_id` int(20) DEFAULT NULL COMMENT '部门经理ID',
  `department_parent_id` int(20) DEFAULT NULL COMMENT '上级部门ID',
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_department
-- ----------------------------
INSERT INTO `t_department` VALUES ('1', '总部门', '7', null);
INSERT INTO `t_department` VALUES ('2', '技术部', '5', '1');
INSERT INTO `t_department` VALUES ('3', '销售部', '6', '1');

-- ----------------------------
-- Table structure for t_employee
-- ----------------------------
DROP TABLE IF EXISTS `t_employee`;
CREATE TABLE `t_employee` (
  `employee_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '员工ID,作为主键',
  `employee_name` varchar(60) DEFAULT NULL COMMENT '员工姓名',
  `password` varchar(60) DEFAULT NULL COMMENT '密码',
  `department_id` int(20) DEFAULT NULL COMMENT '部门ID',
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_employee
-- ----------------------------
INSERT INTO `t_employee` VALUES ('1', 'emp1', '1', '2');
INSERT INTO `t_employee` VALUES ('2', 'emp2', '1', '2');
INSERT INTO `t_employee` VALUES ('3', 'emp3', '1', '3');
INSERT INTO `t_employee` VALUES ('4', 'emp4', '1', '3');
INSERT INTO `t_employee` VALUES ('5', 'manager1', '1', '2');
INSERT INTO `t_employee` VALUES ('6', 'manager2', '1', '3');
INSERT INTO `t_employee` VALUES ('7', 'boss', '1', '1');
