/*
 Navicat MySQL Data Transfer

 Source Server         : Mysql
 Source Server Type    : MySQL
 Source Server Version : 50731 (5.7.31-log)
 Source Host           : localhost:3306
 Source Schema         : exam

 Target Server Type    : MySQL
 Target Server Version : 50731 (5.7.31-log)
 File Encoding         : 65001

 Date: 10/06/2023 18:01:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for carrier
-- ----------------------------
DROP TABLE IF EXISTS `carrier`;
CREATE TABLE `carrier`  (
  `CARRIER_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '承运商ID,主键自增',
  `CARRIER_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '承运商名称',
  `CARRIER_LEADER` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '承运商负责人',
  `CARRIER_TEL` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系电话',
  `CARRIER_EMAIL` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系邮箱',
  `CARRIER_ADDRESS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系地址',
  `CREATE_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) NULL DEFAULT 1 COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`CARRIER_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 66 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '承运商表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of carrier
-- ----------------------------
INSERT INTO `carrier` VALUES (1, '顺丰物流科技', 'jd管理001', '199999999999', 'bjcp@163.com', '北京市昌平区,北七家', '2021-12-12 20:12:11', '2022-11-12 22:17:45', 1);
INSERT INTO `carrier` VALUES (2, '申通科技', 'ST180', '18002222222', 'ST@163.COM', '上海市闸北区', '2022-11-13 06:17:32', '2022-11-12 22:17:50', 1);
INSERT INTO `carrier` VALUES (3, '1', '1', '1', '1', '1', '2023-06-05 22:25:17', '2023-06-05 22:25:17', 1);
INSERT INTO `carrier` VALUES (44, '顺丰物流科技0', '(bjcp@163.com', '18002222222', 'ST@163.COM', '北京市昌平区,北七家', '2023-06-05 22:30:54', '2023-06-06 17:32:22', 1);
INSERT INTO `carrier` VALUES (45, '顺丰物流科技1', '(bjcp@163.com', '18002222222', 'ST@163.COM', '北京市昌平区,北七家', '2023-06-05 22:30:54', '2023-06-06 17:32:24', 1);
INSERT INTO `carrier` VALUES (46, '顺丰物流科技2', '(bjcp@163.com', '18002222222', 'ST@163.COM', '北京市昌平区,北七家', '2023-06-05 22:30:54', '2023-06-06 17:32:29', 1);
INSERT INTO `carrier` VALUES (47, '顺丰物流科技3', '(bjcp@163.com', '18002222222', 'ST@163.COM', '北京市昌平区,北七家', '2023-06-05 22:30:54', '2023-06-06 17:32:29', 1);
INSERT INTO `carrier` VALUES (48, '顺丰物流科技4', '(bjcp@163.com', '18002222222', 'ST@163.COM', '北京市昌平区,北七家', '2023-06-05 22:30:54', '2023-06-06 17:32:29', 1);
INSERT INTO `carrier` VALUES (49, '顺丰物流科技5', '(bjcp@163.com', '18002222222', 'ST@163.COM', '北京市昌平区,北七家', '2023-06-05 22:30:54', '2023-06-06 17:32:29', 1);
INSERT INTO `carrier` VALUES (50, '顺丰物流科技6', '(bjcp@163.com', '18002222222', 'ST@163.COM', '北京市昌平区,北七家', '2023-06-05 22:30:54', '2023-06-06 17:32:29', 1);
INSERT INTO `carrier` VALUES (51, '顺丰物流科技7', '(bjcp@163.com', '18002222222', 'ST@163.COM', '北京市昌平区,北七家', '2023-06-05 22:30:54', '2023-06-06 17:32:29', 1);
INSERT INTO `carrier` VALUES (52, '顺丰物流科技8', '(bjcp@163.com', '18002222222', 'ST@163.COM', '北京市昌平区,北七家', '2023-06-05 22:30:54', '2023-06-06 17:32:29', 1);
INSERT INTO `carrier` VALUES (53, '顺丰物流科技9', '(bjcp@163.com', '18002222222', 'ST@163.COM', '北京市昌平区,北七家', '2023-06-05 22:30:54', '2023-06-06 17:32:29', 1);
INSERT INTO `carrier` VALUES (54, '顺丰物流科技10', '(bjcp@163.com', '18002222222', 'ST@163.COM', '北京市昌平区,北七家', '2023-06-05 22:30:54', '2023-06-06 17:32:29', 1);
INSERT INTO `carrier` VALUES (55, '顺丰物流科技11', '(bjcp@163.com', '18002222222', 'ST@163.COM', '北京市昌平区,北七家', '2023-06-05 22:30:54', '2023-06-06 17:32:29', 1);
INSERT INTO `carrier` VALUES (56, '顺丰物流科技12', '(bjcp@163.com', '18002222222', 'ST@163.COM', '北京市昌平区,北七家', '2023-06-05 22:30:54', '2023-06-06 17:32:29', 1);
INSERT INTO `carrier` VALUES (57, '顺丰物流科技13', '(bjcp@163.com', '18002222222', 'ST@163.COM', '北京市昌平区,北七家', '2023-06-05 22:30:54', '2023-06-06 17:32:29', 1);
INSERT INTO `carrier` VALUES (58, '顺丰物流科技14', '(bjcp@163.com', '18002222222', 'ST@163.COM', '北京市昌平区,北七家', '2023-06-05 22:30:54', '2023-06-06 17:32:29', 1);
INSERT INTO `carrier` VALUES (59, '顺丰物流科技15', '(bjcp@163.com', '18002222222', 'ST@163.COM', '北京市昌平区,北七家', '2023-06-05 22:30:54', '2023-06-06 17:32:29', 1);
INSERT INTO `carrier` VALUES (60, '顺丰物流科技16', '(bjcp@163.com', '18002222222', 'ST@163.COM', '北京市昌平区,北七家', '2023-06-05 22:30:54', '2023-06-06 17:32:29', 1);
INSERT INTO `carrier` VALUES (61, '顺丰物流科技17', '(bjcp@163.com', '11111111111', 'ST@163.COM', '北京市昌平区,北七家', '2023-06-05 22:30:54', '2023-06-06 17:33:06', 1);
INSERT INTO `carrier` VALUES (62, '顺丰物流科技18', '(bjcp@163.com', '18002222222', 'ST@163.COM', '北京市昌平区,北七家', '2023-06-05 22:30:54', '2023-06-06 17:32:29', 1);
INSERT INTO `carrier` VALUES (63, '顺丰物流科技19', '(bjcp@163.com', '18002222222', 'ST@163.COM', '北京市昌平区,北七家', '2023-06-05 22:30:54', '2023-06-06 17:32:29', 1);
INSERT INTO `carrier` VALUES (64, '1', '1', '1', '1', '北京市昌平区,北七家', '2023-06-05 23:19:21', '2023-06-06 17:32:29', 0);
INSERT INTO `carrier` VALUES (65, '2', '2', '2', '2', '北京市昌平区,北七家', '2023-06-06 15:10:28', '2023-06-06 17:32:29', 1);

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `CATEGORY_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '类目ID,主键自增',
  `CATEGORY_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类目名称',
  `LEVEL` int(11) NULL DEFAULT 1 COMMENT '层级',
  `PARENT_ID` int(11) NULL DEFAULT 0 COMMENT '父ID,关联主键(自关联),顶层父ID为0',
  `CREATE_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) NULL DEFAULT 1 COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`CATEGORY_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品类目表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '服饰', 1, 0, '2022-01-01 19:11:11', '2022-11-09 21:28:30', 1);
INSERT INTO `category` VALUES (2, '男装', 2, 1, '2022-01-01 19:11:11', '2022-11-09 21:30:12', 1);
INSERT INTO `category` VALUES (3, '夹克', 3, 2, '2022-01-01 19:11:11', '2022-11-09 22:27:55', 1);
INSERT INTO `category` VALUES (4, '家用电器', 1, 0, '2022-11-10 05:37:17', '2022-11-09 21:37:18', 1);
INSERT INTO `category` VALUES (5, '大家电', 2, 4, '2022-11-10 05:39:02', '2022-11-09 21:39:03', 1);
INSERT INTO `category` VALUES (6, '小家电', 2, 4, '2022-11-10 05:39:46', '2022-11-09 21:39:47', 1);
INSERT INTO `category` VALUES (7, '女装', 2, 1, '2022-11-10 05:39:57', '2022-11-09 21:39:58', 1);
INSERT INTO `category` VALUES (8, '连衣裙', 3, 7, '2022-11-03 05:40:10', '2022-11-09 22:16:35', 1);
INSERT INTO `category` VALUES (9, '洗衣机', 3, 5, '2022-11-10 05:40:32', '2023-06-06 11:15:26', 0);
INSERT INTO `category` VALUES (10, '电热水壶', 3, 6, '2000-12-12 20:12:12', '2022-11-09 22:11:17', 1);
INSERT INTO `category` VALUES (14, '上衣', 2, 1, '2023-06-06 10:39:27', '2023-06-06 10:39:29', 1);
INSERT INTO `category` VALUES (15, '衬衫', 3, 2, '2023-06-06 10:39:55', '2023-06-06 10:39:59', 1);
INSERT INTO `category` VALUES (16, '1', 3, 2, '2023-06-06 10:40:33', '2023-06-06 10:40:35', 1);
INSERT INTO `category` VALUES (17, '内衣', 3, 14, '2023-06-06 10:43:45', '2023-06-06 10:43:59', 1);
INSERT INTO `category` VALUES (18, '短裙', 3, 7, '2023-06-06 10:44:21', '2023-06-06 10:44:23', 0);
INSERT INTO `category` VALUES (20, '1', 1, 0, '2023-06-06 10:57:39', '2023-06-06 11:06:26', 1);
INSERT INTO `category` VALUES (21, '2', 2, 20, '2023-06-06 10:57:45', '2023-06-06 10:57:47', 1);
INSERT INTO `category` VALUES (22, '3', 3, 21, '2023-06-06 10:57:54', '2023-06-06 11:03:17', 0);
INSERT INTO `category` VALUES (23, '3-2', 3, 21, '2023-06-06 10:58:09', '2023-06-06 11:03:15', 0);
INSERT INTO `category` VALUES (24, '2', 1, 0, '2023-06-06 11:10:01', '2023-06-06 11:21:27', 1);
INSERT INTO `category` VALUES (25, '2-2', 2, 24, '2023-06-06 11:21:33', '2023-06-06 11:22:11', 1);
INSERT INTO `category` VALUES (26, '2-3', 3, 25, '2023-06-06 11:21:45', '2023-06-06 11:33:56', 0);
INSERT INTO `category` VALUES (27, '3', 1, 0, '2023-06-06 12:39:39', '2023-06-06 12:39:40', 1);
INSERT INTO `category` VALUES (28, '3-2', 2, 27, '2023-06-06 12:39:43', '2023-06-06 12:40:08', 1);
INSERT INTO `category` VALUES (29, '3-3', 3, 28, '2023-06-06 12:40:00', '2023-06-06 12:40:02', 1);
INSERT INTO `category` VALUES (30, '4', 3, 28, '2023-06-06 12:56:04', '2023-06-06 12:56:08', 1);
INSERT INTO `category` VALUES (31, '4', 1, 0, '2023-06-06 12:56:17', '2023-06-06 12:56:20', 1);
INSERT INTO `category` VALUES (32, '5', 1, 0, '2023-06-06 12:56:37', '2023-06-06 12:56:39', 1);
INSERT INTO `category` VALUES (33, '6', 1, 0, '2023-06-06 15:08:46', '2023-06-06 15:08:55', 1);
INSERT INTO `category` VALUES (34, '6-2', 2, 33, '2023-06-06 15:08:58', '2023-06-06 15:09:10', 1);
INSERT INTO `category` VALUES (35, '6-3', 3, 34, '2023-06-06 15:09:53', '2023-06-06 15:09:55', 1);
INSERT INTO `category` VALUES (36, '1', 3, 2, '2023-06-07 15:52:25', '2023-06-07 15:52:27', 1);
INSERT INTO `category` VALUES (37, '1', 1, 0, '2023-06-09 16:10:21', '2023-06-09 16:10:24', 1);
INSERT INTO `category` VALUES (38, '1', 2, 1, '2023-06-09 16:10:31', '2023-06-09 16:10:33', 1);

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `CUSTOMER_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户ID,主键自增',
  `CUSTOMER_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '客户名称,如果为公司,那么是公司名,如果为个人,那么填写个人名称',
  `CUSTOMER_LEADER` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '客户负责人,如果公司为个人,那么和CUSTOMER_NAME内容相同',
  `CUSTOMER_TEL` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系电话',
  `CUSTOMER_EMAIL` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系邮箱',
  `CUSTOMER_ADDRESS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系地址',
  `LEVEL_ID` int(11) NOT NULL COMMENT '客户级别,关联级别表主键',
  `SOURCE_ID` int(11) NOT NULL COMMENT '客户来源,关联来源表主键',
  `INDUSTRY_ID` int(11) NOT NULL COMMENT '客户行业,关联行业表主键',
  `CREATE_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) NULL DEFAULT 1 COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`CUSTOMER_ID`) USING BTREE,
  INDEX `LEVEL_ID`(`LEVEL_ID`) USING BTREE,
  INDEX `SOURCE_ID`(`SOURCE_ID`) USING BTREE,
  INDEX `INDUSTRY_ID`(`INDUSTRY_ID`) USING BTREE,
  CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`LEVEL_ID`) REFERENCES `level` (`LEVEL_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `customer_ibfk_2` FOREIGN KEY (`SOURCE_ID`) REFERENCES `source` (`SOURCE_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `customer_ibfk_3` FOREIGN KEY (`INDUSTRY_ID`) REFERENCES `industry` (`INDUSTRY_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '客户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (1, 's名字10', 's领导10', '12333333338', 's@163.com', '南京市建邺区10', 3, 3, 2, '2022-12-02 06:22:21', '2022-11-14 23:36:08', 1);
INSERT INTO `customer` VALUES (2, '客户名001', '联系人001', '33333333333', '233@163.com', '地址', 2, 6, 4, '2022-11-15 06:31:29', '2022-11-14 23:34:56', 1);
INSERT INTO `customer` VALUES (3, '客户名002', '联系人002', '22222222222', '222@163.com', '地址002', 3, 5, 5, '2022-11-15 06:33:04', '2022-11-14 23:35:10', 1);
INSERT INTO `customer` VALUES (4, '1', '1', '1', '1', '1', 1, 1, 1, '2023-06-06 18:49:59', '2023-06-09 14:42:47', 1);

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `DEPT_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门ID',
  `DEPT_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `LEVEL` int(11) NULL DEFAULT 1 COMMENT '层级',
  `PARENT_ID` int(11) NULL DEFAULT 0 COMMENT '父ID,自关联DEPT_ID',
  `CREATE_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) NULL DEFAULT 1 COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`DEPT_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, '北京千锋互联科技有限公司', 1, 0, '2022-11-03 05:08:35', '2022-11-19 20:14:28', 1);
INSERT INTO `department` VALUES (2, '千锋互联科技有限公司(北京分公司)', 2, 1, '2022-11-03 05:08:59', '2022-11-19 20:15:08', 1);
INSERT INTO `department` VALUES (3, '产品研发部', 3, 2, '2022-11-03 05:09:16', '2022-11-02 21:09:17', 1);
INSERT INTO `department` VALUES (4, '千锋互联科技有限公司(南京分公司)', 2, 1, '2022-11-03 05:09:43', '2022-11-19 20:15:13', 1);
INSERT INTO `department` VALUES (5, '市场部', 3, 4, '2022-11-03 05:10:52', '2022-11-02 21:10:53', 1);
INSERT INTO `department` VALUES (6, '技术科研部', 3, 2, '2022-11-03 05:11:15', '2022-11-02 21:11:16', 1);
INSERT INTO `department` VALUES (7, '公关部', 3, 4, '2022-11-03 05:11:27', '2022-11-02 21:11:28', 1);
INSERT INTO `department` VALUES (8, '1', 1, 0, '2023-06-06 12:32:10', '2023-06-06 13:02:00', 1);
INSERT INTO `department` VALUES (9, '1-2', 2, 8, '2023-06-06 13:01:31', '2023-06-06 13:02:17', 1);
INSERT INTO `department` VALUES (10, '1-3', 3, 9, '2023-06-06 13:01:40', '2023-06-06 14:50:19', 0);

-- ----------------------------
-- Table structure for industry
-- ----------------------------
DROP TABLE IF EXISTS `industry`;
CREATE TABLE `industry`  (
  `INDUSTRY_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '行业ID,主键自增',
  `INDUSTRY_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '行业名称',
  `CREATE_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) NULL DEFAULT 1 COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`INDUSTRY_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '客户行业表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of industry
-- ----------------------------
INSERT INTO `industry` VALUES (1, '教育', '2012-12-12 20:12:12', '2023-06-05 15:12:59', 0);
INSERT INTO `industry` VALUES (2, '化工', '2022-11-09 07:03:46', '2023-06-05 15:16:47', 0);
INSERT INTO `industry` VALUES (3, '金融', '2022-11-09 07:03:58', '2023-06-05 15:18:28', 0);
INSERT INTO `industry` VALUES (4, '食品', '2022-11-09 07:08:07', '2023-06-05 12:40:10', 1);
INSERT INTO `industry` VALUES (5, '互联网', '2022-11-09 07:08:16', '2023-06-05 11:31:35', 1);
INSERT INTO `industry` VALUES (6, '行业名称', '2023-06-05 11:19:56', '2023-06-05 11:19:56', 1);
INSERT INTO `industry` VALUES (7, '行业名称', '2023-06-05 11:57:31', '2023-06-05 11:57:31', 1);
INSERT INTO `industry` VALUES (8, '12', '2023-05-03 00:00:00', '2023-06-05 18:51:26', 0);
INSERT INTO `industry` VALUES (9, '11', '2023-05-03 00:00:00', '2023-06-06 11:43:01', 1);
INSERT INTO `industry` VALUES (10, '111', '2012-12-12 12:15:51', '2023-06-06 15:07:22', 1);
INSERT INTO `industry` VALUES (11, '1', '2023-06-05 15:45:51', '2023-06-06 15:07:35', 0);
INSERT INTO `industry` VALUES (12, '12', '2023-05-03 00:00:00', '2023-06-06 11:43:10', 0);
INSERT INTO `industry` VALUES (13, '13', '2023-06-05 22:56:11', '2023-06-06 15:07:32', 0);
INSERT INTO `industry` VALUES (14, '14', '2023-06-06 15:07:26', '2023-06-06 15:07:32', 0);

-- ----------------------------
-- Table structure for level
-- ----------------------------
DROP TABLE IF EXISTS `level`;
CREATE TABLE `level`  (
  `LEVEL_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户级别ID,主键自增',
  `LEVEL_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '客户级别名称',
  `CREATE_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) NULL DEFAULT 1 COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`LEVEL_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '客户级别表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of level
-- ----------------------------
INSERT INTO `level` VALUES (1, '青铜', '2022-11-06 04:56:10', '2022-11-05 21:50:59', 1);
INSERT INTO `level` VALUES (2, '白银', '2010-12-12 20:12:12', '2022-11-05 21:51:38', 1);
INSERT INTO `level` VALUES (3, '黄金', '2022-11-06 05:55:34', '2022-11-05 21:55:40', 1);
INSERT INTO `level` VALUES (4, '1客户测试数据1', '2023-06-05 20:50:59', '2023-06-05 20:50:59', 1);
INSERT INTO `level` VALUES (5, '客户测试数据1', '2023-06-05 20:56:57', '2023-06-05 20:56:57', 1);
INSERT INTO `level` VALUES (6, '11', '2023-06-05 21:17:45', '2023-06-05 21:20:42', 1);
INSERT INTO `level` VALUES (7, '1', '2023-06-05 21:18:33', '2023-06-09 16:25:12', 0);
INSERT INTO `level` VALUES (8, '22', '2023-06-05 22:00:59', '2023-06-05 22:01:12', 1);
INSERT INTO `level` VALUES (9, '9', '2023-06-06 15:08:27', '2023-06-06 15:08:34', 1);
INSERT INTO `level` VALUES (10, '1', '2023-06-09 16:10:39', '2023-06-09 16:10:42', 1);

-- ----------------------------
-- Table structure for menus
-- ----------------------------
DROP TABLE IF EXISTS `menus`;
CREATE TABLE `menus`  (
  `MENU_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID,主键自增',
  `MENU_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `MENU_URL` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单地址',
  `LEVEL` int(11) NULL DEFAULT 1 COMMENT '层级',
  `PARENT_ID` int(11) NULL DEFAULT NULL COMMENT '父ID,关联menus表主键,默认值为0,表示菜单第一级',
  `CREATE_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) NULL DEFAULT 1 COMMENT '菜单状态 0:删除 1:未删除',
  PRIMARY KEY (`MENU_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menus
-- ----------------------------
INSERT INTO `menus` VALUES (1, '仪表盘', '', 1, 0, '2022-11-02 05:09:10', '2022-11-01 21:14:21', 1);
INSERT INTO `menus` VALUES (2, '系统设置', '', 1, 0, '2022-11-02 05:09:19', '2022-11-01 21:09:20', 1);
INSERT INTO `menus` VALUES (3, '用户管理', '', 2, 2, '2022-11-02 05:09:29', '2022-11-01 21:09:30', 1);
INSERT INTO `menus` VALUES (4, '角色管理', '', 2, 2, '2022-11-02 05:09:44', '2022-11-01 21:09:45', 1);
INSERT INTO `menus` VALUES (5, '部门管理', '', 2, 2, '2022-11-02 05:09:54', '2022-11-01 21:09:55', 1);
INSERT INTO `menus` VALUES (6, '菜单管理', '', 2, 2, '2022-11-02 05:10:04', '2022-11-01 21:10:05', 1);
INSERT INTO `menus` VALUES (7, '基础数据', '', 1, 0, '2022-11-02 05:10:20', '2022-11-01 21:10:21', 1);
INSERT INTO `menus` VALUES (8, '产品管理', '', 2, 7, '2022-11-02 05:10:31', '2022-11-01 21:10:32', 1);
INSERT INTO `menus` VALUES (9, '客户管理', '', 2, 7, '2022-11-02 05:10:41', '2022-11-01 21:10:42', 1);
INSERT INTO `menus` VALUES (10, '供应商管理', '', 2, 7, '2022-11-02 05:10:53', '2022-11-01 21:10:54', 1);
INSERT INTO `menus` VALUES (11, '承运商管理', '', 2, 7, '2022-11-02 05:11:07', '2022-11-01 21:11:08', 1);
INSERT INTO `menus` VALUES (12, '仓库管理', '', 1, 0, '2022-11-02 05:11:33', '2022-11-01 21:11:34', 1);
INSERT INTO `menus` VALUES (13, '仓库管理', '', 2, 12, '2022-11-02 05:11:46', '2022-11-01 21:11:48', 1);
INSERT INTO `menus` VALUES (14, '货物入库', '', 2, 12, '2022-11-02 05:11:58', '2022-11-01 21:11:59', 1);
INSERT INTO `menus` VALUES (15, '货物出库', '', 2, 12, '2022-11-02 05:12:10', '2022-11-01 21:12:10', 1);
INSERT INTO `menus` VALUES (16, '库存查询', '', 2, 12, '2022-11-02 05:12:26', '2022-11-01 21:12:28', 1);
INSERT INTO `menus` VALUES (17, '字典管理', '', 1, 0, '2022-11-02 05:12:40', '2022-11-01 21:12:41', 1);
INSERT INTO `menus` VALUES (18, '产品类目', '', 2, 17, '2022-11-02 05:12:54', '2022-11-01 21:12:55', 1);
INSERT INTO `menus` VALUES (19, '客户级别', '', 2, 17, '2022-11-02 05:13:06', '2022-11-01 21:13:07', 1);
INSERT INTO `menus` VALUES (20, '客户来源', '', 2, 17, '2022-11-02 05:13:16', '2022-11-01 21:13:16', 1);
INSERT INTO `menus` VALUES (21, '日志管理', '', 1, 0, '2022-11-02 05:13:28', '2022-11-01 21:13:29', 1);
INSERT INTO `menus` VALUES (22, '系统日志', '', 2, 21, '2022-11-01 08:00:00', '2022-11-01 21:13:40', 1);
INSERT INTO `menus` VALUES (23, '登录日志', '', 2, 21, '2022-11-02 05:13:49', '2022-11-01 21:13:49', 1);
INSERT INTO `menus` VALUES (24, '商业智能', '', 2, 1, '2022-11-06 04:55:47', '2022-11-05 20:55:48', 1);
INSERT INTO `menus` VALUES (25, '1', NULL, 1, 0, '2023-06-06 14:45:18', '2023-06-06 14:45:20', 1);
INSERT INTO `menus` VALUES (26, '1', NULL, 1, 0, '2023-06-06 14:45:38', '2023-06-06 14:52:11', 0);
INSERT INTO `menus` VALUES (27, '1-2', NULL, 2, 25, '2023-06-06 14:46:00', '2023-06-06 14:46:08', 1);
INSERT INTO `menus` VALUES (28, '1-3', NULL, 3, 27, '2023-06-06 14:46:16', '2023-06-06 14:52:18', 1);
INSERT INTO `menus` VALUES (29, '1-2-1', NULL, 2, 26, '2023-06-06 14:52:26', '2023-06-06 14:53:41', 1);
INSERT INTO `menus` VALUES (30, '1-2-2', NULL, 2, 26, '2023-06-06 14:52:48', '2023-06-06 14:53:35', 1);
INSERT INTO `menus` VALUES (31, '1-3-1', NULL, 3, 29, '2023-06-06 14:52:53', '2023-06-06 14:53:04', 0);

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `PRODUCT_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '产品ID,主键自增',
  `PRODUCT_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品名称',
  `CATEGORY_ID` int(11) NOT NULL COMMENT '产品类目ID,关联类目表主键',
  `PRODUCT_SIZE` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品尺寸(长乘宽),单位 毫米(mm)',
  `PRODUCT_PRICE` double(16, 3) NULL DEFAULT NULL COMMENT '产品价格',
  `CREATE_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) NULL DEFAULT 1 COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`PRODUCT_ID`) USING BTREE,
  INDEX `CATEGORY_ID`(`CATEGORY_ID`) USING BTREE,
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`CATEGORY_ID`) REFERENCES `category` (`CATEGORY_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '产品信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, '衣服1', 3, '200*200', 1200.000, '2022-11-17 04:25:37', '2022-12-09 22:14:20', 1);
INSERT INTO `product` VALUES (2, '衣服2', 1, '200*200', 1200.000, '2022-11-17 04:25:37', '2023-06-06 19:45:09', 1);
INSERT INTO `product` VALUES (3, '衣服3', 2, '200*200', 1200.000, '2022-11-17 04:25:37', '2023-06-06 19:59:30', 1);
INSERT INTO `product` VALUES (4, '衣服4', 8, '200*200', 121.000, '2023-06-06 23:26:16', '2023-06-08 12:56:25', 1);
INSERT INTO `product` VALUES (5, '衣服5', 10, '2200*200', 122.000, '2023-06-06 23:34:54', '2023-06-08 12:56:28', 1);
INSERT INTO `product` VALUES (6, '衣服6', 10, '3200*200', 123.000, '2023-06-06 23:40:01', '2023-06-08 12:56:30', 1);
INSERT INTO `product` VALUES (7, '衣服7', 10, '4200*200', 12.000, '2023-06-06 23:41:03', '2023-06-08 12:56:33', 1);
INSERT INTO `product` VALUES (8, '衣服8', 17, '5200*200', 125.000, '2023-06-06 23:57:17', '2023-06-08 12:56:35', 1);
INSERT INTO `product` VALUES (9, '衣服9', 32, '1200*200', 121.000, '2023-06-07 00:15:44', '2023-06-08 12:56:37', 1);
INSERT INTO `product` VALUES (10, '衣服10', 29, '2200*200', 122.000, '2023-06-07 00:16:00', '2023-06-08 12:56:38', 1);
INSERT INTO `product` VALUES (11, '衣服11', 17, '3200*200', 123.000, '2023-06-07 01:00:01', '2023-06-08 12:56:41', 1);
INSERT INTO `product` VALUES (12, '衣服12', 23, '4200*200', 124.000, '2023-06-07 01:02:49', '2023-06-08 12:56:43', 1);
INSERT INTO `product` VALUES (13, '衣服13', 10, '5200*200', 125.000, '2023-06-07 01:03:35', '2023-06-08 12:56:44', 1);
INSERT INTO `product` VALUES (14, '衣服14', 26, '6200*200', 126.000, '2023-06-07 08:26:32', '2023-06-08 12:56:46', 1);
INSERT INTO `product` VALUES (15, '衣服15', 35, '7200*200', 127.000, '2023-06-07 08:54:20', '2023-06-08 12:56:50', 1);

-- ----------------------------
-- Table structure for record_in
-- ----------------------------
DROP TABLE IF EXISTS `record_in`;
CREATE TABLE `record_in`  (
  `RECORD_IN_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '入库ID,主键自增',
  `SUPPLIER_ID` int(11) NOT NULL COMMENT '供应商ID,关联供应商表主键',
  `PRODUCT_ID` int(11) NOT NULL COMMENT '产品ID,关联产品表主键',
  `RECORD_IN_NUMBER` int(11) NULL DEFAULT 0 COMMENT '入库数量',
  `RECORD_IN_TIME` datetime NULL DEFAULT NULL COMMENT '入库时间',
  `USER_ID` int(11) NOT NULL COMMENT '入库负责人ID,关联用户表主键',
  `REPO_ID` int(11) NOT NULL COMMENT '仓库ID,关联仓库表主键',
  `REMARKS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `CREATE_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) NULL DEFAULT 1 COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`RECORD_IN_ID`) USING BTREE,
  INDEX `SUPPLIER_ID`(`SUPPLIER_ID`) USING BTREE,
  INDEX `PRODUCT_ID`(`PRODUCT_ID`) USING BTREE,
  INDEX `USER_ID`(`USER_ID`) USING BTREE,
  CONSTRAINT `record_in_ibfk_1` FOREIGN KEY (`SUPPLIER_ID`) REFERENCES `supplier` (`SUPPLIER_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `record_in_ibfk_2` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `product` (`PRODUCT_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `record_in_ibfk_3` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 128 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '入库记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of record_in
-- ----------------------------
INSERT INTO `record_in` VALUES (1, 2, 1, 1, '2022-12-11 22:14:22', 1, 1, NULL, '2022-12-11 22:14:22', '2022-12-11 22:14:22', 1);
INSERT INTO `record_in` VALUES (2, 2, 1, 10, '2022-12-11 22:28:59', 1, 2, NULL, '2022-12-11 22:28:59', '2022-12-11 22:28:59', 1);
INSERT INTO `record_in` VALUES (3, 2, 1, 100, '2023-01-08 10:14:47', 1, 1, NULL, '2023-01-08 10:14:47', '2023-01-08 10:14:46', 1);
INSERT INTO `record_in` VALUES (4, 2, 1, 1, '2023-01-08 10:15:18', 1, 1, NULL, '2023-01-08 10:15:18', '2023-01-08 10:15:18', 1);
INSERT INTO `record_in` VALUES (5, 1, 10, 1, '2023-06-08 19:43:44', 1, 2, '', '2023-06-08 19:43:44', '2023-06-08 19:43:44', 1);
INSERT INTO `record_in` VALUES (6, 32, 15, 111111, '2023-06-08 20:33:04', 1, 3, '', '2023-06-08 20:33:04', '2023-06-08 20:33:04', 1);
INSERT INTO `record_in` VALUES (7, 32, 15, 111111, '2023-06-08 20:33:11', 1, 3, '', '2023-06-08 20:33:11', '2023-06-08 20:33:11', 1);
INSERT INTO `record_in` VALUES (8, 32, 1, 111111, '2023-06-08 20:33:32', 1, 3, '', '2023-06-08 20:33:32', '2023-06-08 20:33:32', 1);
INSERT INTO `record_in` VALUES (9, 32, 1, 111111, '2023-06-08 20:34:27', 1, 3, '', '2023-06-08 20:34:27', '2023-06-08 20:34:27', 1);
INSERT INTO `record_in` VALUES (10, 32, 1, 111111, '2023-06-08 20:35:01', 1, 3, '', '2023-06-08 20:35:01', '2023-06-08 20:35:01', 1);
INSERT INTO `record_in` VALUES (11, 32, 1, 111111, '2023-06-08 20:38:07', 1, 3, '', '2023-06-08 20:38:07', '2023-06-08 20:38:07', 1);
INSERT INTO `record_in` VALUES (12, 32, 1, 111111, '2023-06-08 20:40:26', 1, 3, '', '2023-06-08 20:40:26', '2023-06-08 20:40:26', 1);
INSERT INTO `record_in` VALUES (13, 32, 1, 111111, '2023-06-08 20:43:31', 1, 3, '', '2023-06-08 20:43:31', '2023-06-08 20:43:31', 1);
INSERT INTO `record_in` VALUES (14, 32, 1, 11111, '2023-06-08 20:44:53', 1, 1, '', '2023-06-08 20:44:53', '2023-06-08 20:44:53', 1);
INSERT INTO `record_in` VALUES (15, 32, 13, 11111, '2023-06-08 20:45:30', 1, 1, '', '2023-06-08 20:45:30', '2023-06-08 20:45:30', 1);
INSERT INTO `record_in` VALUES (16, 32, 10, 11111, '2023-06-08 20:45:41', 1, 1, '', '2023-06-08 20:45:41', '2023-06-08 20:45:41', 1);
INSERT INTO `record_in` VALUES (17, 32, 1, 1, '2023-06-08 22:07:49', 1, 1, '', '2023-06-08 22:07:49', '2023-06-08 22:07:49', 1);
INSERT INTO `record_in` VALUES (18, 2, 1, 1, '2023-06-08 22:21:41', 1, 1, '', '2023-06-08 22:21:41', '2023-06-08 22:21:41', 1);
INSERT INTO `record_in` VALUES (19, 2, 1, 1, '2023-06-08 22:58:13', 1, 1, '', '2023-06-08 22:58:13', '2023-06-08 22:58:13', 1);
INSERT INTO `record_in` VALUES (20, 2, 1, 11, '2023-06-08 22:58:15', 1, 1, '', '2023-06-08 22:58:15', '2023-06-08 22:58:15', 1);
INSERT INTO `record_in` VALUES (21, 2, 1, 111, '2023-06-08 22:58:18', 1, 1, '', '2023-06-08 22:58:18', '2023-06-08 22:58:18', 1);
INSERT INTO `record_in` VALUES (22, 2, 11, 1, '2023-06-08 23:04:56', 1, 3, '', '2023-06-08 23:04:56', '2023-06-08 23:04:56', 1);
INSERT INTO `record_in` VALUES (23, 30, 10, 11111, '2023-06-08 23:05:14', 1, 3, '', '2023-06-08 23:05:14', '2023-06-08 23:05:14', 1);
INSERT INTO `record_in` VALUES (24, 2, 10, 11111, '2023-06-08 23:18:23', 1, 3, '', '2023-06-08 23:18:23', '2023-06-08 23:18:23', 1);
INSERT INTO `record_in` VALUES (25, 2, 10, 12345, '2023-06-08 23:19:11', 1, 3, '', '2023-06-08 23:19:11', '2023-06-08 23:19:11', 1);
INSERT INTO `record_in` VALUES (26, 2, 10, 11111, '2023-06-08 23:25:34', 1, 1, '', '2023-06-08 23:25:34', '2023-06-08 23:25:34', 1);
INSERT INTO `record_in` VALUES (27, 2, 10, 1, '2023-06-08 23:25:39', 1, 1, '', '2023-06-08 23:25:39', '2023-06-08 23:25:39', 1);
INSERT INTO `record_in` VALUES (28, 2, 10, 2, '2023-06-08 23:25:46', 1, 1, '', '2023-06-08 23:25:46', '2023-06-08 23:25:46', 1);
INSERT INTO `record_in` VALUES (29, 32, 10, 111, '2023-06-08 23:26:08', 1, 3, '', '2023-06-08 23:26:08', '2023-06-08 23:26:08', 1);
INSERT INTO `record_in` VALUES (30, 2, 14, 1, '2023-06-08 23:26:50', 1, 3, '', '2023-06-08 23:26:50', '2023-06-08 23:26:50', 1);
INSERT INTO `record_in` VALUES (31, 2, 14, 1, '2023-06-08 23:26:55', 1, 1, '', '2023-06-08 23:26:55', '2023-06-08 23:26:55', 1);
INSERT INTO `record_in` VALUES (32, 2, 10, 1, '2023-06-08 23:30:29', 1, 1, '', '2023-06-08 23:30:29', '2023-06-08 23:30:29', 1);
INSERT INTO `record_in` VALUES (33, 2, 10, 11, '2023-06-08 23:30:59', 1, 3, '', '2023-06-08 23:30:59', '2023-06-08 23:30:59', 1);
INSERT INTO `record_in` VALUES (34, 2, 10, 11, '2023-06-08 23:31:16', 1, 1, '', '2023-06-08 23:31:16', '2023-06-08 23:31:16', 1);
INSERT INTO `record_in` VALUES (35, 2, 10, 11, '2023-06-08 23:31:21', 1, 1, '', '2023-06-08 23:31:21', '2023-06-08 23:31:21', 1);
INSERT INTO `record_in` VALUES (36, 2, 1, 1, '2023-06-08 23:36:18', 1, 3, '', '2023-06-08 23:36:18', '2023-06-08 23:36:18', 1);
INSERT INTO `record_in` VALUES (37, 2, 1, 1, '2023-06-08 23:38:20', 1, 3, '', '2023-06-08 23:38:20', '2023-06-08 23:38:20', 1);
INSERT INTO `record_in` VALUES (38, 2, 1, 1, '2023-06-08 23:38:42', 1, 3, '', '2023-06-08 23:38:42', '2023-06-08 23:38:42', 1);
INSERT INTO `record_in` VALUES (39, 2, 1, 1, '2023-06-08 23:39:02', 1, 3, '', '2023-06-08 23:39:02', '2023-06-08 23:39:02', 1);
INSERT INTO `record_in` VALUES (40, 2, 10, 1, '2023-06-08 23:49:42', 1, 3, '', '2023-06-08 23:49:42', '2023-06-08 23:49:42', 1);
INSERT INTO `record_in` VALUES (41, 2, 1, 1, '2023-06-09 00:04:43', 1, 1, '', '2023-06-09 00:04:43', '2023-06-09 00:04:43', 1);
INSERT INTO `record_in` VALUES (42, 2, 1, 1, '2023-06-09 00:05:17', 1, 1, '', '2023-06-09 00:05:17', '2023-06-09 00:05:17', 1);
INSERT INTO `record_in` VALUES (43, 2, 1, 1, '2023-06-09 00:05:18', 1, 1, '', '2023-06-09 00:05:18', '2023-06-09 00:05:18', 1);
INSERT INTO `record_in` VALUES (44, 2, 1, 1, '2023-06-09 00:05:19', 1, 1, '', '2023-06-09 00:05:19', '2023-06-09 00:05:19', 1);
INSERT INTO `record_in` VALUES (45, 2, 10, 11, '2023-06-09 00:05:28', 1, 3, '', '2023-06-09 00:05:28', '2023-06-09 00:05:28', 1);
INSERT INTO `record_in` VALUES (46, 2, 1, 1, '2023-06-09 00:16:06', 1, 1, '', '2023-06-09 00:16:06', '2023-06-09 00:16:06', 1);
INSERT INTO `record_in` VALUES (47, 2, 1, 1, '2023-06-09 00:16:08', 1, 1, '', '2023-06-09 00:16:08', '2023-06-09 00:16:08', 1);
INSERT INTO `record_in` VALUES (48, 2, 11, 1, '2023-06-09 00:16:27', 1, 3, '', '2023-06-09 00:16:27', '2023-06-09 00:16:27', 1);
INSERT INTO `record_in` VALUES (49, 2, 11, 1, '2023-06-09 00:16:28', 1, 3, '', '2023-06-09 00:16:28', '2023-06-09 00:16:28', 1);
INSERT INTO `record_in` VALUES (50, 2, 1, 1, '2023-06-09 00:24:15', 1, 1, '', '2023-06-09 00:24:15', '2023-06-09 00:24:15', 1);
INSERT INTO `record_in` VALUES (51, 2, 1, 1, '2023-06-09 00:24:17', 1, 1, '', '2023-06-09 00:24:17', '2023-06-09 00:24:17', 1);
INSERT INTO `record_in` VALUES (52, 2, 1, 1, '2023-06-09 00:36:25', 1, 1, '', '2023-06-09 00:36:25', '2023-06-09 00:36:25', 1);
INSERT INTO `record_in` VALUES (53, 2, 1, 1, '2023-06-09 00:36:26', 1, 1, '', '2023-06-09 00:36:26', '2023-06-09 00:36:26', 1);
INSERT INTO `record_in` VALUES (54, 2, 1, 1, '2023-06-09 00:36:27', 1, 1, '', '2023-06-09 00:36:27', '2023-06-09 00:36:27', 1);
INSERT INTO `record_in` VALUES (55, 2, 1, 1, '2023-06-09 00:36:28', 1, 1, '', '2023-06-09 00:36:28', '2023-06-09 00:36:28', 1);
INSERT INTO `record_in` VALUES (56, 2, 1, 1, '2023-06-09 00:36:29', 1, 1, '', '2023-06-09 00:36:29', '2023-06-09 00:36:29', 1);
INSERT INTO `record_in` VALUES (57, 2, 1, 11, '2023-06-09 00:36:38', 1, 1, '', '2023-06-09 00:36:38', '2023-06-09 00:36:38', 1);
INSERT INTO `record_in` VALUES (58, 2, 1, 111, '2023-06-09 01:01:54', 1, 1, '', '2023-06-09 01:01:54', '2023-06-09 01:01:54', 1);
INSERT INTO `record_in` VALUES (59, 2, 1, 111, '2023-06-09 01:01:56', 1, 1, '', '2023-06-09 01:01:56', '2023-06-09 01:01:56', 1);
INSERT INTO `record_in` VALUES (60, 2, 1, 1, '2023-06-09 01:05:28', 1, 1, '', '2023-06-09 01:05:28', '2023-06-09 01:05:28', 1);
INSERT INTO `record_in` VALUES (61, 2, 1, 1, '2023-06-09 02:07:58', 1, 1, '', '2023-06-09 02:07:58', '2023-06-09 02:07:58', 1);
INSERT INTO `record_in` VALUES (62, 2, 1, 1, '2023-06-09 08:53:04', 1, 1, '', '2023-06-09 08:53:04', '2023-06-09 08:53:04', 1);
INSERT INTO `record_in` VALUES (63, 2, 11, 1, '2023-06-09 10:52:25', 1, 3, '', '2023-06-09 10:52:25', '2023-06-09 10:52:25', 1);
INSERT INTO `record_in` VALUES (64, 2, 11, 1, '2023-06-09 10:52:26', 1, 3, '', '2023-06-09 10:52:26', '2023-06-09 10:52:26', 1);
INSERT INTO `record_in` VALUES (65, 2, 11, 1, '2023-06-09 10:52:26', 1, 3, '', '2023-06-09 10:52:26', '2023-06-09 10:52:26', 1);
INSERT INTO `record_in` VALUES (66, 2, 11, 1, '2023-06-09 10:52:26', 1, 3, '', '2023-06-09 10:52:26', '2023-06-09 10:52:26', 1);
INSERT INTO `record_in` VALUES (67, 2, 11, 1, '2023-06-09 10:52:26', 1, 3, '', '2023-06-09 10:52:26', '2023-06-09 10:52:26', 1);
INSERT INTO `record_in` VALUES (68, 2, 11, 1, '2023-06-09 10:52:27', 1, 3, '', '2023-06-09 10:52:27', '2023-06-09 10:52:27', 1);
INSERT INTO `record_in` VALUES (69, 2, 11, 1, '2023-06-09 10:52:27', 1, 3, '', '2023-06-09 10:52:27', '2023-06-09 10:52:27', 1);
INSERT INTO `record_in` VALUES (70, 2, 11, 1, '2023-06-09 10:52:27', 1, 3, '', '2023-06-09 10:52:27', '2023-06-09 10:52:27', 1);
INSERT INTO `record_in` VALUES (71, 2, 11, 1, '2023-06-09 10:52:27', 1, 3, '', '2023-06-09 10:52:27', '2023-06-09 10:52:27', 1);
INSERT INTO `record_in` VALUES (72, 2, 11, 1, '2023-06-09 10:52:27', 1, 3, '', '2023-06-09 10:52:27', '2023-06-09 10:52:27', 1);
INSERT INTO `record_in` VALUES (73, 2, 1, 1, '2023-06-09 10:52:50', 1, 1, '', '2023-06-09 10:52:50', '2023-06-09 10:52:50', 1);
INSERT INTO `record_in` VALUES (74, 2, 1, 1, '2023-06-09 10:53:44', 1, 1, '', '2023-06-09 10:53:44', '2023-06-09 10:53:44', 1);
INSERT INTO `record_in` VALUES (75, 2, 14, 11111, '2023-06-09 11:39:35', 1, 1, '', '2023-06-09 11:39:35', '2023-06-09 11:39:35', 1);
INSERT INTO `record_in` VALUES (76, 2, 14, 1, '2023-06-09 11:39:39', 1, 1, '', '2023-06-09 11:39:39', '2023-06-09 11:39:39', 1);
INSERT INTO `record_in` VALUES (77, 2, 10, 11, '2023-06-09 11:46:36', 1, 1, '', '2023-06-09 11:46:36', '2023-06-09 11:46:36', 1);
INSERT INTO `record_in` VALUES (78, 2, 10, 11, '2023-06-09 11:46:47', 1, 1, '', '2023-06-09 11:46:47', '2023-06-09 11:46:47', 1);
INSERT INTO `record_in` VALUES (79, 2, 10, 11, '2023-06-09 11:46:48', 1, 1, '', '2023-06-09 11:46:48', '2023-06-09 11:46:48', 1);
INSERT INTO `record_in` VALUES (80, 2, 1, 11, '2023-06-09 11:46:52', 1, 3, '', '2023-06-09 11:46:52', '2023-06-09 11:46:52', 1);
INSERT INTO `record_in` VALUES (81, 2, 1, 11, '2023-06-09 11:46:53', 1, 3, '', '2023-06-09 11:46:53', '2023-06-09 11:46:53', 1);
INSERT INTO `record_in` VALUES (82, 2, 2, 1, '2023-06-09 11:55:46', 1, 2, '', '2023-06-09 11:55:46', '2023-06-09 11:55:46', 1);
INSERT INTO `record_in` VALUES (83, 2, 1, 1, '2023-06-09 12:15:08', 1, 1, '', '2023-06-09 12:15:08', '2023-06-09 12:15:08', 1);
INSERT INTO `record_in` VALUES (84, 2, 1, 1, '2023-06-09 12:15:19', 1, 1, '', '2023-06-09 12:15:19', '2023-06-09 12:15:19', 1);
INSERT INTO `record_in` VALUES (85, 2, 1, 1, '2023-06-09 12:15:21', 1, 1, '', '2023-06-09 12:15:21', '2023-06-09 12:15:21', 1);
INSERT INTO `record_in` VALUES (86, 2, 1, 1, '2023-06-09 12:15:22', 1, 1, '', '2023-06-09 12:15:22', '2023-06-09 12:15:22', 1);
INSERT INTO `record_in` VALUES (87, 2, 1, 1, '2023-06-09 12:15:28', 1, 1, '', '2023-06-09 12:15:28', '2023-06-09 12:15:28', 1);
INSERT INTO `record_in` VALUES (88, 2, 1, 1, '2023-06-09 12:15:49', 1, 1, '', '2023-06-09 12:15:49', '2023-06-09 12:15:49', 1);
INSERT INTO `record_in` VALUES (89, 2, 12, 1, '2023-06-09 12:16:18', 1, 3, '', '2023-06-09 12:16:18', '2023-06-09 12:16:18', 1);
INSERT INTO `record_in` VALUES (90, 2, 12, 1, '2023-06-09 12:16:19', 1, 3, '', '2023-06-09 12:16:19', '2023-06-09 12:16:19', 1);
INSERT INTO `record_in` VALUES (91, 2, 12, 1, '2023-06-09 12:16:20', 1, 3, '', '2023-06-09 12:16:20', '2023-06-09 12:16:20', 1);
INSERT INTO `record_in` VALUES (92, 2, 11, 1, '2023-06-09 12:16:25', 1, 1, '', '2023-06-09 12:16:25', '2023-06-09 12:16:25', 1);
INSERT INTO `record_in` VALUES (93, 29, 15, 1, '2023-06-09 12:16:44', 1, 1, '', '2023-06-09 12:16:44', '2023-06-09 12:16:44', 1);
INSERT INTO `record_in` VALUES (94, 29, 15, 1, '2023-06-09 12:16:45', 1, 1, '', '2023-06-09 12:16:45', '2023-06-09 12:16:45', 1);
INSERT INTO `record_in` VALUES (95, 29, 15, 1, '2023-06-09 12:16:46', 1, 1, '', '2023-06-09 12:16:46', '2023-06-09 12:16:46', 1);
INSERT INTO `record_in` VALUES (96, 29, 15, 1, '2023-06-09 12:17:06', 1, 1, '', '2023-06-09 12:17:06', '2023-06-09 12:17:06', 1);
INSERT INTO `record_in` VALUES (97, 29, 15, 1, '2023-06-09 12:17:28', 1, 1, '', '2023-06-09 12:17:28', '2023-06-09 12:17:28', 1);
INSERT INTO `record_in` VALUES (98, 2, 1, 1, '2023-06-09 12:24:00', 1, 1, '', '2023-06-09 12:24:00', '2023-06-09 12:24:00', 1);
INSERT INTO `record_in` VALUES (99, 2, 1, 1, '2023-06-09 12:24:00', 1, 1, '', '2023-06-09 12:24:00', '2023-06-09 12:24:00', 1);
INSERT INTO `record_in` VALUES (100, 2, 3, 1, '2023-06-09 12:25:53', 1, 7, '', '2023-06-09 12:25:53', '2023-06-09 12:25:53', 1);
INSERT INTO `record_in` VALUES (101, 2, 3, 1, '2023-06-09 12:25:54', 1, 7, '', '2023-06-09 12:25:54', '2023-06-09 12:25:54', 1);
INSERT INTO `record_in` VALUES (102, 2, 3, 1, '2023-06-09 12:25:55', 1, 7, '', '2023-06-09 12:25:55', '2023-06-09 12:25:55', 1);
INSERT INTO `record_in` VALUES (103, 2, 14, 1, '2023-06-09 12:29:04', 1, 7, '', '2023-06-09 12:29:04', '2023-06-09 12:29:04', 1);
INSERT INTO `record_in` VALUES (104, 2, 14, 1, '2023-06-09 12:29:47', 1, 7, '', '2023-06-09 12:29:47', '2023-06-09 12:29:47', 1);
INSERT INTO `record_in` VALUES (105, 2, 14, 1, '2023-06-09 12:30:31', 1, 7, '', '2023-06-09 12:30:31', '2023-06-09 12:30:31', 1);
INSERT INTO `record_in` VALUES (106, 2, 14, 1, '2023-06-09 12:30:41', 1, 7, '', '2023-06-09 12:30:41', '2023-06-09 12:30:41', 1);
INSERT INTO `record_in` VALUES (107, 2, 14, 1, '2023-06-09 12:34:19', 1, 7, '', '2023-06-09 12:34:19', '2023-06-09 12:34:19', 1);
INSERT INTO `record_in` VALUES (108, 32, 12, 1, '2023-06-09 12:34:58', 1, 1, '', '2023-06-09 12:34:58', '2023-06-09 12:34:58', 1);
INSERT INTO `record_in` VALUES (109, 32, 12, 11, '2023-06-09 12:35:01', 1, 3, '', '2023-06-09 12:35:01', '2023-06-09 12:35:01', 1);
INSERT INTO `record_in` VALUES (110, 32, 15, 11, '2023-06-09 12:35:06', 1, 1, '', '2023-06-09 12:35:06', '2023-06-09 12:35:06', 1);
INSERT INTO `record_in` VALUES (111, 32, 15, 11, '2023-06-09 12:35:08', 1, 3, '', '2023-06-09 12:35:08', '2023-06-09 12:35:08', 1);
INSERT INTO `record_in` VALUES (112, 32, 15, 11, '2023-06-09 12:35:09', 1, 3, '', '2023-06-09 12:35:09', '2023-06-09 12:35:09', 1);
INSERT INTO `record_in` VALUES (113, 2, 1, 1, '2023-06-09 13:52:50', 1, 1, '', '2023-06-09 13:52:50', '2023-06-09 13:52:50', 1);
INSERT INTO `record_in` VALUES (114, 2, 1, 1, '2023-06-09 13:52:51', 1, 1, '', '2023-06-09 13:52:51', '2023-06-09 13:52:51', 1);
INSERT INTO `record_in` VALUES (115, 2, 1, 1, '2023-06-09 13:52:51', 1, 1, '', '2023-06-09 13:52:51', '2023-06-09 13:52:51', 1);
INSERT INTO `record_in` VALUES (116, 2, 1, 1, '2023-06-09 13:52:52', 1, 1, '', '2023-06-09 13:52:52', '2023-06-09 13:52:52', 1);
INSERT INTO `record_in` VALUES (117, 2, 1, 1, '2023-06-09 13:52:52', 1, 1, '', '2023-06-09 13:52:52', '2023-06-09 13:52:52', 1);
INSERT INTO `record_in` VALUES (118, 2, 1, 1, '2023-06-09 13:52:52', 1, 1, '', '2023-06-09 13:52:52', '2023-06-09 13:52:52', 1);
INSERT INTO `record_in` VALUES (119, 2, 10, 1, '2023-06-09 13:55:35', 1, 3, '', '2023-06-09 13:55:35', '2023-06-09 13:55:35', 1);
INSERT INTO `record_in` VALUES (120, 2, 10, 1, '2023-06-09 13:55:36', 1, 3, '', '2023-06-09 13:55:36', '2023-06-09 13:55:36', 1);
INSERT INTO `record_in` VALUES (121, 2, 1, 1, '2023-06-09 13:56:24', 1, 1, '', '2023-06-09 13:56:24', '2023-06-09 13:56:24', 1);
INSERT INTO `record_in` VALUES (122, 2, 1, 1, '2023-06-09 14:05:09', 1, 3, '', '2023-06-09 14:05:09', '2023-06-09 14:05:09', 1);
INSERT INTO `record_in` VALUES (123, 2, 10, 11111, '2023-06-09 14:05:28', 1, 3, '', '2023-06-09 14:05:28', '2023-06-09 14:05:28', 1);
INSERT INTO `record_in` VALUES (124, 2, 1, 1, '2023-06-09 14:31:53', 1, 1, '', '2023-06-09 14:31:53', '2023-06-09 14:31:53', 1);
INSERT INTO `record_in` VALUES (125, 2, 1, 1, '2023-06-09 14:31:55', 1, 1, '', '2023-06-09 14:31:55', '2023-06-09 14:31:55', 1);
INSERT INTO `record_in` VALUES (126, 2, 1, 1, '2023-06-09 14:32:23', 1, 3, '', '2023-06-09 14:32:23', '2023-06-09 14:32:23', 1);
INSERT INTO `record_in` VALUES (127, 2, 1, 1, '2023-06-09 14:43:58', 1, 1, '', '2023-06-09 14:43:58', '2023-06-09 14:43:58', 1);

-- ----------------------------
-- Table structure for record_out
-- ----------------------------
DROP TABLE IF EXISTS `record_out`;
CREATE TABLE `record_out`  (
  `RECORD_OUT_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '出库ID,主键自增',
  `CUSTOMER_ID` int(11) NOT NULL COMMENT '客户ID,关联客户表主键',
  `PRODUCT_ID` int(11) NOT NULL COMMENT '产品ID,关联产品表主键',
  `RECORD_OUT_NUMBER` int(11) NULL DEFAULT 0 COMMENT '出库数量',
  `RECORD_OUT_TIME` datetime NULL DEFAULT NULL COMMENT '出库时间',
  `USER_ID` int(11) NOT NULL COMMENT '出库负责人ID,关联用户表主键',
  `REPO_ID` int(11) NOT NULL COMMENT '仓库ID,关联仓库表主键',
  `REMARKS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `CREATE_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) NULL DEFAULT 1 COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`RECORD_OUT_ID`) USING BTREE,
  INDEX `CUSTOMER_ID`(`CUSTOMER_ID`) USING BTREE,
  INDEX `PRODUCT_ID`(`PRODUCT_ID`) USING BTREE,
  INDEX `USER_ID`(`USER_ID`) USING BTREE,
  CONSTRAINT `record_out_ibfk_1` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `customer` (`CUSTOMER_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `record_out_ibfk_2` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `product` (`PRODUCT_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `record_out_ibfk_3` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '出库记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of record_out
-- ----------------------------
INSERT INTO `record_out` VALUES (1, 1, 1, 1, '2022-12-10 23:56:03', 1, 1, NULL, '2022-12-10 23:56:03', '2022-12-10 23:56:02', 1);
INSERT INTO `record_out` VALUES (2, 1, 1, 1, '2022-12-10 23:56:29', 1, 1, NULL, '2022-12-10 23:56:29', '2022-12-10 23:56:28', 1);
INSERT INTO `record_out` VALUES (3, 1, 1, 1, '2022-12-11 22:15:27', 1, 1, NULL, '2022-12-11 22:15:27', '2022-12-11 22:15:27', 1);
INSERT INTO `record_out` VALUES (4, 1, 1, 2, '2022-12-11 22:15:37', 1, 1, NULL, '2022-12-11 22:15:37', '2022-12-11 22:15:36', 1);
INSERT INTO `record_out` VALUES (5, 2, 1, 100, '2023-01-08 10:15:40', 1, 1, NULL, '2023-01-08 10:15:40', '2023-01-08 10:15:39', 1);
INSERT INTO `record_out` VALUES (6, 2, 10, 0, '2023-06-09 11:19:13', 1, 1, '', '2023-06-09 11:19:13', '2023-06-09 11:19:13', 1);
INSERT INTO `record_out` VALUES (7, 2, 10, 0, '2023-06-09 11:19:16', 1, 1, '', '2023-06-09 11:19:16', '2023-06-09 11:19:16', 1);
INSERT INTO `record_out` VALUES (8, 2, 10, 0, '2023-06-09 11:19:38', 1, 1, '', '2023-06-09 11:19:38', '2023-06-09 11:19:38', 1);
INSERT INTO `record_out` VALUES (9, 2, 10, 0, '2023-06-09 11:20:48', 1, 1, '', '2023-06-09 11:20:48', '2023-06-09 11:20:48', 1);
INSERT INTO `record_out` VALUES (10, 1, 10, 0, '2023-06-09 11:21:06', 1, 1, '', '2023-06-09 11:21:06', '2023-06-09 11:21:06', 1);
INSERT INTO `record_out` VALUES (11, 1, 10, 0, '2023-06-09 11:23:14', 1, 1, '', '2023-06-09 11:23:14', '2023-06-09 11:23:14', 1);
INSERT INTO `record_out` VALUES (12, 1, 10, 0, '2023-06-09 11:25:11', 1, 1, '', '2023-06-09 11:25:11', '2023-06-09 11:25:11', 1);
INSERT INTO `record_out` VALUES (13, 1, 1, 1, '2023-06-09 11:34:09', 1, 1, '', '2023-06-09 11:34:09', '2023-06-09 11:34:09', 1);
INSERT INTO `record_out` VALUES (14, 2, 1, 1, '2023-06-09 11:35:36', 1, 1, '', '2023-06-09 11:35:36', '2023-06-09 11:35:36', 1);
INSERT INTO `record_out` VALUES (15, 4, 14, 1, '2023-06-09 11:39:19', 1, 1, '', '2023-06-09 11:39:19', '2023-06-09 11:39:19', 1);
INSERT INTO `record_out` VALUES (16, 1, 1, 1, '2023-06-09 11:42:26', 1, 1, '', '2023-06-09 11:42:26', '2023-06-09 11:42:26', 1);
INSERT INTO `record_out` VALUES (17, 1, 14, 13, '2023-06-09 11:46:06', 1, 1, '', '2023-06-09 11:46:06', '2023-06-09 11:46:06', 1);
INSERT INTO `record_out` VALUES (18, 1, 14, 11, '2023-06-09 11:46:11', 1, 1, '', '2023-06-09 11:46:11', '2023-06-09 11:46:11', 1);
INSERT INTO `record_out` VALUES (19, 1, 1, 1, '2023-06-09 13:57:33', 1, 1, '', '2023-06-09 13:57:33', '2023-06-09 13:57:33', 1);
INSERT INTO `record_out` VALUES (20, 1, 1, 11, '2023-06-09 13:57:35', 1, 1, '', '2023-06-09 13:57:35', '2023-06-09 13:57:35', 1);
INSERT INTO `record_out` VALUES (21, 1, 1, 1, '2023-06-09 13:57:39', 1, 1, '', '2023-06-09 13:57:39', '2023-06-09 13:57:39', 1);
INSERT INTO `record_out` VALUES (22, 1, 1, 1, '2023-06-09 13:57:50', 1, 1, '', '2023-06-09 13:57:50', '2023-06-09 13:57:50', 1);
INSERT INTO `record_out` VALUES (23, 1, 1, 1, '2023-06-09 13:57:52', 1, 1, '', '2023-06-09 13:57:52', '2023-06-09 13:57:52', 1);
INSERT INTO `record_out` VALUES (24, 1, 1, 1, '2023-06-09 13:57:58', 1, 1, '', '2023-06-09 13:57:58', '2023-06-09 13:57:58', 1);
INSERT INTO `record_out` VALUES (25, 1, 1, 1, '2023-06-09 13:59:21', 1, 1, '', '2023-06-09 13:59:21', '2023-06-09 13:59:21', 1);
INSERT INTO `record_out` VALUES (26, 1, 10, 1, '2023-06-09 14:05:18', 1, 3, '', '2023-06-09 14:05:18', '2023-06-09 14:05:18', 1);
INSERT INTO `record_out` VALUES (27, 1, 10, 11, '2023-06-09 14:05:37', 1, 3, '', '2023-06-09 14:05:37', '2023-06-09 14:05:37', 1);
INSERT INTO `record_out` VALUES (28, 1, 1, 1, '2023-06-09 14:32:36', 1, 1, '', '2023-06-09 14:32:36', '2023-06-09 14:32:36', 1);
INSERT INTO `record_out` VALUES (29, 1, 1, 1, '2023-06-09 15:02:48', 1, 1, '', '2023-06-09 15:02:48', '2023-06-09 15:02:48', 1);
INSERT INTO `record_out` VALUES (30, 1, 1, 1, '2023-06-09 15:02:49', 1, 1, '', '2023-06-09 15:02:49', '2023-06-09 15:02:49', 1);

-- ----------------------------
-- Table structure for record_stock
-- ----------------------------
DROP TABLE IF EXISTS `record_stock`;
CREATE TABLE `record_stock`  (
  `PRODUCT_ID` int(11) NOT NULL COMMENT '产品ID,关联产品表主键',
  `REPO_ID` int(11) NOT NULL COMMENT '仓库ID,关联仓库表主键',
  `PRODUCT_STOCK` int(11) NULL DEFAULT 0 COMMENT '库存数量',
  `CREATE_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) NULL DEFAULT 1 COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`PRODUCT_ID`, `REPO_ID`) USING BTREE,
  INDEX `REPO_ID`(`REPO_ID`) USING BTREE,
  CONSTRAINT `record_stock_ibfk_1` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `product` (`PRODUCT_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `record_stock_ibfk_2` FOREIGN KEY (`REPO_ID`) REFERENCES `repository` (`REPO_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '库存记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of record_stock
-- ----------------------------
INSERT INTO `record_stock` VALUES (1, 1, 21, '2023-06-09 15:07:36', '2023-06-09 15:07:40', 1);
INSERT INTO `record_stock` VALUES (1, 3, 24, '2023-06-09 14:32:23', '2023-06-09 14:32:23', 1);
INSERT INTO `record_stock` VALUES (2, 2, 1016, '2023-06-09 12:15:58', '2023-06-09 12:16:03', 1);
INSERT INTO `record_stock` VALUES (3, 3, 238477, '2022-12-09 22:14:37', '2023-06-09 00:03:30', 1);
INSERT INTO `record_stock` VALUES (3, 7, 3, '2023-06-09 12:33:46', '2023-06-09 12:33:48', 1);
INSERT INTO `record_stock` VALUES (4, 6, 1250, '2023-06-08 13:05:54', '2023-06-08 13:06:17', 0);
INSERT INTO `record_stock` VALUES (6, 1, 1002, '2022-12-11 22:28:59', '2023-06-08 13:02:34', 1);
INSERT INTO `record_stock` VALUES (7, 3, 1007, '2023-06-08 09:20:39', '2023-06-08 13:02:35', 1);
INSERT INTO `record_stock` VALUES (8, 1, 111, '2023-06-08 20:04:28', '2023-06-08 20:04:38', 1);
INSERT INTO `record_stock` VALUES (9, 2, 11111, '2023-06-08 20:04:28', '2023-06-08 20:21:49', 1);
INSERT INTO `record_stock` VALUES (10, 1, 33, '2023-06-09 12:16:05', '2023-06-09 12:16:07', 1);
INSERT INTO `record_stock` VALUES (10, 3, 11101, '2023-06-09 15:07:31', '2023-06-09 15:07:34', 1);
INSERT INTO `record_stock` VALUES (11, 1, 1, '2023-06-09 12:16:25', '2023-06-09 12:16:25', 1);
INSERT INTO `record_stock` VALUES (11, 3, 13, '2023-06-09 11:08:29', '2023-06-09 11:08:31', 1);
INSERT INTO `record_stock` VALUES (12, 1, 5016, '2023-06-09 12:34:58', '2023-06-09 12:34:58', 1);
INSERT INTO `record_stock` VALUES (12, 3, 14, '2023-06-09 12:35:01', '2023-06-09 12:35:01', 1);
INSERT INTO `record_stock` VALUES (13, 1, 11111, '2023-06-08 20:45:30', '2023-06-08 20:45:30', 1);
INSERT INTO `record_stock` VALUES (13, 3, 1, '2023-06-08 23:49:42', '2023-06-09 00:04:18', 1);
INSERT INTO `record_stock` VALUES (14, 1, 11089, '2023-06-09 12:16:11', '2023-06-09 12:16:12', 1);
INSERT INTO `record_stock` VALUES (14, 7, 5, '2023-06-09 12:34:19', '2023-06-09 12:34:19', 1);
INSERT INTO `record_stock` VALUES (15, 1, 11123, '2023-06-09 12:35:06', '2023-06-09 12:35:06', 1);
INSERT INTO `record_stock` VALUES (15, 3, 22, '2023-06-09 12:35:09', '2023-06-09 12:35:09', 1);
INSERT INTO `record_stock` VALUES (15, 4, 11111, '2023-06-08 20:23:15', '2023-06-09 00:03:23', 1);

-- ----------------------------
-- Table structure for repository
-- ----------------------------
DROP TABLE IF EXISTS `repository`;
CREATE TABLE `repository`  (
  `REPO_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '仓库ID,主键自增',
  `REPO_ADDRESS` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '仓库地址',
  `REPO_AREA` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '仓库面积,单位:平方米',
  `REPO_DESC` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '仓库描述(备注)',
  `REPO_STATUS` tinyint(4) NULL DEFAULT 1 COMMENT '仓库状态 0:故障 1:正常 2:已满 3:废弃',
  `CREATE_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) NULL DEFAULT 1 COMMENT '是否删除 0:删除 1:未删除',
  `REPO_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '仓库名称',
  PRIMARY KEY (`REPO_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '仓库信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of repository
-- ----------------------------
INSERT INTO `repository` VALUES (1, '南京市建邺区1', '100011平米', '大仓库12', 2, '2022-12-27 20:12:12', '2022-12-08 22:45:26', 1, '南京市建邺区仓库1');
INSERT INTO `repository` VALUES (2, '南京市江宁区2', '100', '小仓库2', 3, '2022-11-18 07:07:05', '2023-06-08 12:51:59', 1, '南京市江宁区仓库2');
INSERT INTO `repository` VALUES (3, '北京市昌平区北七家1', '200000', '混合仓库1', 1, '2023-01-08 10:16:54', '2023-06-08 00:02:42', 1, '北京昌平仓库1');
INSERT INTO `repository` VALUES (4, '南京市六合区', '120*200', '小型储物仓库', 1, '2023-06-08 00:02:52', '2023-06-08 08:47:14', 1, '南京六合区仓库');
INSERT INTO `repository` VALUES (5, '1', '1', '1', 1, '2023-06-08 08:48:04', '2023-06-08 23:42:53', 1, '北京昌平仓库2');
INSERT INTO `repository` VALUES (6, '2', '2', '2', 1, '2023-06-08 08:48:22', '2023-06-08 12:52:09', 1, '北京昌平仓库3');
INSERT INTO `repository` VALUES (7, '3', '3', '3', 2, '2023-06-08 09:15:46', '2023-06-08 12:52:13', 1, '北京昌平仓库4');
INSERT INTO `repository` VALUES (8, '4', '4', '4', 1, '2023-06-08 09:16:56', '2023-06-09 17:01:15', 1, '北京昌平仓库5');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `ROLE_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID,主键自增',
  `ROLE_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `CREATE_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) NULL DEFAULT 1 COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`ROLE_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '平台管理员', '2022-11-03 05:07:38', '2023-06-07 09:47:45', 1);
INSERT INTO `role` VALUES (2, '仓库管理员', '2022-11-03 05:07:49', '2023-06-07 09:51:11', 1);
INSERT INTO `role` VALUES (3, '1', '2023-06-07 09:53:05', '2023-06-07 09:53:09', 0);

-- ----------------------------
-- Table structure for role_menus
-- ----------------------------
DROP TABLE IF EXISTS `role_menus`;
CREATE TABLE `role_menus`  (
  `ROLE_ID` int(11) NOT NULL COMMENT '角色ID,关联角色表主键',
  `MENU_ID` int(11) NOT NULL COMMENT '菜单ID,关联菜单表主键',
  `CREATE_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) NULL DEFAULT 1 COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`ROLE_ID`, `MENU_ID`) USING BTREE,
  INDEX `MENU_ID`(`MENU_ID`) USING BTREE,
  CONSTRAINT `role_menus_ibfk_1` FOREIGN KEY (`ROLE_ID`) REFERENCES `role` (`ROLE_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `role_menus_ibfk_2` FOREIGN KEY (`MENU_ID`) REFERENCES `menus` (`MENU_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色菜单关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_menus
-- ----------------------------

-- ----------------------------
-- Table structure for source
-- ----------------------------
DROP TABLE IF EXISTS `source`;
CREATE TABLE `source`  (
  `SOURCE_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户来源ID,主键自增',
  `SOURCE_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '客户来源名称',
  `CREATE_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) NULL DEFAULT 1 COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`SOURCE_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '客户来源表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of source
-- ----------------------------
INSERT INTO `source` VALUES (1, '百度', '2021-12-12 20:12:12', '2022-11-08 22:32:27', 1);
INSERT INTO `source` VALUES (2, '转介绍', '2022-11-09 06:22:40', '2022-11-08 22:25:41', 1);
INSERT INTO `source` VALUES (3, '官网', '2022-11-09 06:22:52', '2022-11-08 22:27:53', 1);
INSERT INTO `source` VALUES (4, '客户线索', '2022-11-09 06:28:21', '2022-11-08 22:28:22', 1);
INSERT INTO `source` VALUES (5, '电话销售', '2022-11-09 06:28:31', '2023-06-06 15:07:44', 0);
INSERT INTO `source` VALUES (6, '自谈', '2022-11-09 06:28:41', '2022-11-08 22:28:42', 1);
INSERT INTO `source` VALUES (7, '客户来源名称', '2023-06-05 21:40:26', '2023-06-06 15:07:41', 0);
INSERT INTO `source` VALUES (8, '8', '2023-06-06 15:07:50', '2023-06-06 15:07:52', 1);

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier`  (
  `SUPPLIER_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '供应商ID,主键自增',
  `SUPPLIER_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '供应商信息,如果为个人(非公司),那么当前字段和SUPPLIER_LEADER信息相同,如果为公司,那么是公司名称',
  `SUPPLIER_LEADER` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '负责人,如果为个人(非公司),那么当前字段和SUPPLIER_NAME信息相同',
  `SUPPLIER_TEL` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系电话',
  `SUPPLIER_EMAIL` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱',
  `SUPPLIER_ADDRESS` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '地址',
  `CREATE_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) NULL DEFAULT 1 COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`SUPPLIER_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '供应商信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES (1, '河北防爆', '大萝卜', '129999999', 'hbfb@163.com', '北京市昌平区', '2022-12-12 20:12:12', '2022-11-10 22:33:00', 1);
INSERT INTO `supplier` VALUES (2, '供应商名字011', '供应商联系人022', '12345678901', 'gys@163.com', '南京市建邺区南苑街道', '2022-11-10 05:52:47', '2022-11-10 22:33:07', 1);
INSERT INTO `supplier` VALUES (3, '湖南重工', '小王', '11111111111', '1@163.com', '湖南……', '2023-06-05 17:56:29', '2023-06-05 19:53:14', 0);
INSERT INTO `supplier` VALUES (4, '湖南重工', '小王', '11111111111', '1@163.com', '湖南……', '2023-06-05 17:52:05', '2023-06-05 17:52:05', 0);
INSERT INTO `supplier` VALUES (5, '湖南重工3', '湖南重工3', '11111111111', '1@163.com', '湖南……', '2023-06-05 18:23:12', '2023-06-05 19:52:20', 0);
INSERT INTO `supplier` VALUES (6, '湖南重工', '湖南重工', '11111111111', '1@163.com', '湖南……', '2023-06-05 19:07:05', '2023-06-05 19:07:05', 1);
INSERT INTO `supplier` VALUES (7, '湖南重工', '湖南重工', '11111111111', '1@163.com', '湖南……', '2023-06-05 19:07:05', '2023-06-05 19:07:05', 1);
INSERT INTO `supplier` VALUES (8, '湖南重工', '湖南重工', '11111111111', '1@163.com', '湖南……', '2023-06-05 19:07:05', '2023-06-05 19:07:05', 1);
INSERT INTO `supplier` VALUES (9, '湖南重工', '湖南重工', '11111111111', '1@163.com', '湖南……', '2023-06-05 19:07:05', '2023-06-05 19:07:05', 1);
INSERT INTO `supplier` VALUES (10, '湖南重工', '湖南重工', '11111111111', '1@163.com', '湖南……', '2023-06-05 19:07:05', '2023-06-05 19:07:05', 1);
INSERT INTO `supplier` VALUES (11, '湖南重工', '湖南重工', '11111111111', '1@163.com', '湖南……', '2023-06-05 19:07:05', '2023-06-05 19:07:05', 1);
INSERT INTO `supplier` VALUES (12, '湖南重工', '湖南重工', '11111111111', '1@163.com', '湖南……', '2023-06-05 19:07:05', '2023-06-05 19:07:05', 1);
INSERT INTO `supplier` VALUES (13, '湖南重工', '湖南重工', '11111111111', '1@163.com', '湖南……', '2023-06-05 19:07:05', '2023-06-05 19:07:05', 1);
INSERT INTO `supplier` VALUES (14, '湖南重工', '湖南重工', '11111111111', '1@163.com', '湖南……', '2023-06-05 19:07:05', '2023-06-05 19:07:05', 1);
INSERT INTO `supplier` VALUES (15, '湖南重工', '湖南重工', '11111111111', '1@163.com', '湖南……', '2023-06-05 19:07:05', '2023-06-05 19:07:05', 1);
INSERT INTO `supplier` VALUES (16, '湖南重工', '湖南重工', '11111111111', '1@163.com', '湖南……', '2023-06-05 19:07:05', '2023-06-05 19:07:05', 1);
INSERT INTO `supplier` VALUES (17, '湖南重工', '湖南重工', '11111111111', '1@163.com', '湖南……', '2023-06-05 19:07:05', '2023-06-05 19:07:05', 1);
INSERT INTO `supplier` VALUES (18, '湖南重工', '湖南重工', '11111111111', '1@163.com', '湖南……', '2023-06-05 19:07:05', '2023-06-05 19:07:05', 1);
INSERT INTO `supplier` VALUES (19, '湖南重工', '湖南重工', '11111111111', '1@163.com', '湖南……', '2023-06-05 19:07:05', '2023-06-05 19:07:05', 1);
INSERT INTO `supplier` VALUES (20, '湖南重工', '湖南重工', '11111111111', '1@163.com', '湖南……', '2023-06-05 19:07:05', '2023-06-05 19:07:05', 1);
INSERT INTO `supplier` VALUES (21, '湖南重工', '湖南重工', '11111111111', '1@163.com', '湖南……', '2023-06-05 19:07:05', '2023-06-05 19:07:05', 1);
INSERT INTO `supplier` VALUES (22, '湖南重工', '湖南重工', '11111111111', '1@163.com', '湖南……', '2023-06-05 19:07:05', '2023-06-05 19:07:05', 1);
INSERT INTO `supplier` VALUES (23, '湖南重工', '湖南重工', '11111111111', '1@163.com', '湖南……', '2023-06-05 19:07:05', '2023-06-05 19:07:05', 1);
INSERT INTO `supplier` VALUES (24, '湖南重工', '湖南重工', '11111111111', '1@163.com', '湖南……', '2023-06-05 19:07:05', '2023-06-05 19:07:05', 1);
INSERT INTO `supplier` VALUES (25, '湖南重工', '湖南重工', '11111111111', '1@163.com', '湖南……', '2023-06-05 19:07:05', '2023-06-05 19:07:05', 1);
INSERT INTO `supplier` VALUES (26, '4', '4', '4', '4', '4', '2023-06-05 20:02:20', '2023-06-05 20:16:29', 1);
INSERT INTO `supplier` VALUES (27, '3', '3', '3', '3', '3', '2023-06-05 20:15:51', '2023-06-05 20:17:16', 1);
INSERT INTO `supplier` VALUES (28, '2', '2', '2', '2', '2', '2023-06-05 20:03:46', '2023-06-05 20:17:26', 1);
INSERT INTO `supplier` VALUES (29, '1', '1', '1', '1', '1', '2023-06-05 20:04:03', '2023-06-05 20:17:33', 1);
INSERT INTO `supplier` VALUES (30, '10', '10', '10', '10', '10', '2023-06-05 20:18:37', '2023-06-05 22:55:44', 0);
INSERT INTO `supplier` VALUES (31, '11', '11', '11', '11', '11', '2023-06-05 22:54:52', '2023-06-05 22:55:43', 0);
INSERT INTO `supplier` VALUES (32, '121', '121', '121', '121', '121', '2023-06-06 15:11:10', '2023-06-06 15:11:21', 1);

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志ID',
  `type` int(11) NULL DEFAULT 1 COMMENT '日志类型 1:登陆日志; 0:其他日志',
  `ip_addr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '请求地址',
  `method_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '请求方法名称',
  `method` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '请求方式',
  `nick_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`log_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 90 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '日志记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES (1, 0, '0:0:0:0:0:0:0:1', 'toLogin', 'GET', '匿名', '2023-01-06 23:09:33');
INSERT INTO `sys_log` VALUES (2, 0, '0:0:0:0:0:0:0:1', 'getVerifyCode', 'GET', '匿名', '2023-01-06 23:09:34');
INSERT INTO `sys_log` VALUES (3, 1, '0:0:0:0:0:0:0:1', 'login', 'POST', '匿名', '2023-01-06 23:09:39');
INSERT INTO `sys_log` VALUES (4, 0, '0:0:0:0:0:0:0:1', 'home', 'GET', '大萝卜张三', '2023-01-06 23:09:39');
INSERT INTO `sys_log` VALUES (5, 0, '0:0:0:0:0:0:0:1', 'getUserDetail', 'GET', '大萝卜张三', '2023-01-06 23:09:39');
INSERT INTO `sys_log` VALUES (6, 0, '0:0:0:0:0:0:0:1', 'getRepositoryPayloadStatistics', 'GET', '大萝卜张三', '2023-01-06 23:09:40');
INSERT INTO `sys_log` VALUES (7, 0, '0:0:0:0:0:0:0:1', 'getStatisticsInMonth', 'GET', '大萝卜张三', '2023-01-06 23:09:56');
INSERT INTO `sys_log` VALUES (8, 0, '0:0:0:0:0:0:0:1', 'getStatisticsOutMonth', 'GET', '大萝卜张三', '2023-01-06 23:09:56');
INSERT INTO `sys_log` VALUES (9, 0, '0:0:0:0:0:0:0:1', 'getStatisticsMonthMoney', 'GET', '大萝卜张三', '2023-01-06 23:09:56');
INSERT INTO `sys_log` VALUES (10, 0, '0:0:0:0:0:0:0:1', 'getLogs', 'GET', '大萝卜张三', '2023-01-06 23:13:48');
INSERT INTO `sys_log` VALUES (11, 0, '0:0:0:0:0:0:0:1', 'getLogs', 'GET', '大萝卜张三', '2023-01-06 23:13:50');
INSERT INTO `sys_log` VALUES (12, 0, '0:0:0:0:0:0:0:1', 'getCategoryList', 'GET', '大萝卜张三', '2023-01-06 23:14:09');
INSERT INTO `sys_log` VALUES (13, 0, '0:0:0:0:0:0:0:1', 'getLevelPage', 'GET', '大萝卜张三', '2023-01-06 23:14:19');
INSERT INTO `sys_log` VALUES (14, 0, '0:0:0:0:0:0:0:1', 'getSourcePage', 'GET', '大萝卜张三', '2023-01-06 23:14:23');
INSERT INTO `sys_log` VALUES (15, 0, '0:0:0:0:0:0:0:1', 'getIndustryPage', 'GET', '大萝卜张三', '2023-01-06 23:14:24');
INSERT INTO `sys_log` VALUES (16, 0, '0:0:0:0:0:0:0:1', 'getRepositoryPage', 'GET', '大萝卜张三', '2023-01-06 23:15:12');
INSERT INTO `sys_log` VALUES (17, 0, '0:0:0:0:0:0:0:1', 'getProductPage', 'GET', '大萝卜张三', '2023-01-06 23:15:17');
INSERT INTO `sys_log` VALUES (18, 0, '0:0:0:0:0:0:0:1', 'getCustomerPage', 'GET', '大萝卜张三', '2023-01-06 23:15:18');
INSERT INTO `sys_log` VALUES (19, 0, '0:0:0:0:0:0:0:1', 'getUserPage', 'GET', '大萝卜张三', '2023-01-06 23:15:19');
INSERT INTO `sys_log` VALUES (20, 0, '0:0:0:0:0:0:0:1', 'getRolePage', 'GET', '大萝卜张三', '2023-01-06 23:15:20');
INSERT INTO `sys_log` VALUES (21, 0, '0:0:0:0:0:0:0:1', 'getStatisticsInMonth', 'GET', '大萝卜张三', '2023-01-06 23:15:21');
INSERT INTO `sys_log` VALUES (22, 0, '0:0:0:0:0:0:0:1', 'getStatisticsMonthMoney', 'GET', '大萝卜张三', '2023-01-06 23:15:21');
INSERT INTO `sys_log` VALUES (23, 0, '0:0:0:0:0:0:0:1', 'getStatisticsOutMonth', 'GET', '大萝卜张三', '2023-01-06 23:15:21');
INSERT INTO `sys_log` VALUES (24, 0, '0:0:0:0:0:0:0:1', 'getStatisticsOutMonth', 'GET', '大萝卜张三', '2023-01-06 23:15:34');
INSERT INTO `sys_log` VALUES (25, 0, '0:0:0:0:0:0:0:1', 'getStatisticsInMonth', 'GET', '大萝卜张三', '2023-01-06 23:15:34');
INSERT INTO `sys_log` VALUES (26, 0, '0:0:0:0:0:0:0:1', 'getStatisticsMonthMoney', 'GET', '大萝卜张三', '2023-01-06 23:15:34');
INSERT INTO `sys_log` VALUES (27, 0, '0:0:0:0:0:0:0:1', 'home', 'GET', '大萝卜张三', '2023-01-06 23:15:53');
INSERT INTO `sys_log` VALUES (28, 0, '0:0:0:0:0:0:0:1', 'getUserDetail', 'GET', '大萝卜张三', '2023-01-06 23:15:53');
INSERT INTO `sys_log` VALUES (29, 0, '0:0:0:0:0:0:0:1', 'getRepositoryPayloadStatistics', 'GET', '大萝卜张三', '2023-01-06 23:15:53');
INSERT INTO `sys_log` VALUES (30, 0, '0:0:0:0:0:0:0:1', 'getUserDetail', 'GET', '大萝卜张三', '2023-01-06 23:18:37');
INSERT INTO `sys_log` VALUES (31, 0, '0:0:0:0:0:0:0:1', 'uploadFile', 'POST', '大萝卜张三', '2023-01-06 23:18:44');
INSERT INTO `sys_log` VALUES (32, 0, '0:0:0:0:0:0:0:1', 'updateUser', 'POST', '大萝卜张三', '2023-01-06 23:18:46');
INSERT INTO `sys_log` VALUES (33, 0, '0:0:0:0:0:0:0:1', 'home', 'GET', '大萝卜张三', '2023-01-06 23:18:46');
INSERT INTO `sys_log` VALUES (34, 0, '0:0:0:0:0:0:0:1', 'getUserDetail', 'GET', '大萝卜张三', '2023-01-06 23:18:46');
INSERT INTO `sys_log` VALUES (35, 0, '0:0:0:0:0:0:0:1', 'getRepositoryPayloadStatistics', 'GET', '大萝卜张三', '2023-01-06 23:18:46');
INSERT INTO `sys_log` VALUES (36, 0, '0:0:0:0:0:0:0:1', 'toLogin', 'GET', '匿名', '2023-01-08 10:13:44');
INSERT INTO `sys_log` VALUES (37, 0, '0:0:0:0:0:0:0:1', 'getVerifyCode', 'GET', '匿名', '2023-01-08 10:13:45');
INSERT INTO `sys_log` VALUES (38, 1, '0:0:0:0:0:0:0:1', 'login', 'POST', '匿名', '2023-01-08 10:13:49');
INSERT INTO `sys_log` VALUES (39, 0, '0:0:0:0:0:0:0:1', 'home', 'GET', '大萝卜张三', '2023-01-08 10:13:49');
INSERT INTO `sys_log` VALUES (40, 0, '0:0:0:0:0:0:0:1', 'getUserDetail', 'GET', '大萝卜张三', '2023-01-08 10:13:49');
INSERT INTO `sys_log` VALUES (41, 0, '0:0:0:0:0:0:0:1', 'getRepositoryPayloadStatistics', 'GET', '大萝卜张三', '2023-01-08 10:13:50');
INSERT INTO `sys_log` VALUES (42, 0, '0:0:0:0:0:0:0:1', 'getStatisticsInMonth', 'GET', '大萝卜张三', '2023-01-08 10:13:53');
INSERT INTO `sys_log` VALUES (43, 0, '0:0:0:0:0:0:0:1', 'getStatisticsOutMonth', 'GET', '大萝卜张三', '2023-01-08 10:13:53');
INSERT INTO `sys_log` VALUES (44, 0, '0:0:0:0:0:0:0:1', 'getStatisticsMonthMoney', 'GET', '大萝卜张三', '2023-01-08 10:13:53');
INSERT INTO `sys_log` VALUES (45, 0, '0:0:0:0:0:0:0:1', 'getUserPage', 'GET', '大萝卜张三', '2023-01-08 10:14:11');
INSERT INTO `sys_log` VALUES (46, 0, '0:0:0:0:0:0:0:1', 'getStatisticsInMonth', 'GET', '大萝卜张三', '2023-01-08 10:14:16');
INSERT INTO `sys_log` VALUES (47, 0, '0:0:0:0:0:0:0:1', 'getStatisticsMonthMoney', 'GET', '大萝卜张三', '2023-01-08 10:14:16');
INSERT INTO `sys_log` VALUES (48, 0, '0:0:0:0:0:0:0:1', 'getStatisticsOutMonth', 'GET', '大萝卜张三', '2023-01-08 10:14:16');
INSERT INTO `sys_log` VALUES (49, 0, '0:0:0:0:0:0:0:1', 'getSupplierList', 'GET', '大萝卜张三', '2023-01-08 10:14:28');
INSERT INTO `sys_log` VALUES (50, 0, '0:0:0:0:0:0:0:1', 'getProductList', 'GET', '大萝卜张三', '2023-01-08 10:14:31');
INSERT INTO `sys_log` VALUES (51, 0, '0:0:0:0:0:0:0:1', 'getProductList', 'GET', '大萝卜张三', '2023-01-08 10:14:36');
INSERT INTO `sys_log` VALUES (52, 0, '0:0:0:0:0:0:0:1', 'getProduct', 'GET', '大萝卜张三', '2023-01-08 10:14:37');
INSERT INTO `sys_log` VALUES (53, 0, '0:0:0:0:0:0:0:1', 'getRepositoryList', 'GET', '大萝卜张三', '2023-01-08 10:14:41');
INSERT INTO `sys_log` VALUES (54, 0, '0:0:0:0:0:0:0:1', 'getProduct', 'GET', '大萝卜张三', '2023-01-08 10:14:42');
INSERT INTO `sys_log` VALUES (55, 0, '0:0:0:0:0:0:0:1', 'inRecordStock', 'POST', '大萝卜张三', '2023-01-08 10:14:47');
INSERT INTO `sys_log` VALUES (56, 0, '0:0:0:0:0:0:0:1', 'getStatisticsInMonth', 'GET', '大萝卜张三', '2023-01-08 10:14:50');
INSERT INTO `sys_log` VALUES (57, 0, '0:0:0:0:0:0:0:1', 'getStatisticsOutMonth', 'GET', '大萝卜张三', '2023-01-08 10:14:50');
INSERT INTO `sys_log` VALUES (58, 0, '0:0:0:0:0:0:0:1', 'getStatisticsMonthMoney', 'GET', '大萝卜张三', '2023-01-08 10:14:50');
INSERT INTO `sys_log` VALUES (59, 0, '0:0:0:0:0:0:0:1', 'getSupplierList', 'GET', '大萝卜张三', '2023-01-08 10:15:09');
INSERT INTO `sys_log` VALUES (60, 0, '0:0:0:0:0:0:0:1', 'getProductList', 'GET', '大萝卜张三', '2023-01-08 10:15:12');
INSERT INTO `sys_log` VALUES (61, 0, '0:0:0:0:0:0:0:1', 'getProduct', 'GET', '大萝卜张三', '2023-01-08 10:15:13');
INSERT INTO `sys_log` VALUES (62, 0, '0:0:0:0:0:0:0:1', 'getRepositoryList', 'GET', '大萝卜张三', '2023-01-08 10:15:14');
INSERT INTO `sys_log` VALUES (63, 0, '0:0:0:0:0:0:0:1', 'getProduct', 'GET', '大萝卜张三', '2023-01-08 10:15:16');
INSERT INTO `sys_log` VALUES (64, 0, '0:0:0:0:0:0:0:1', 'inRecordStock', 'POST', '大萝卜张三', '2023-01-08 10:15:18');
INSERT INTO `sys_log` VALUES (65, 0, '0:0:0:0:0:0:0:1', 'getStatisticsInMonth', 'GET', '大萝卜张三', '2023-01-08 10:15:22');
INSERT INTO `sys_log` VALUES (66, 0, '0:0:0:0:0:0:0:1', 'getStatisticsOutMonth', 'GET', '大萝卜张三', '2023-01-08 10:15:22');
INSERT INTO `sys_log` VALUES (67, 0, '0:0:0:0:0:0:0:1', 'getStatisticsMonthMoney', 'GET', '大萝卜张三', '2023-01-08 10:15:22');
INSERT INTO `sys_log` VALUES (68, 0, '0:0:0:0:0:0:0:1', 'getCustomerList', 'GET', '大萝卜张三', '2023-01-08 10:15:31');
INSERT INTO `sys_log` VALUES (69, 0, '0:0:0:0:0:0:0:1', 'getProductList', 'GET', '大萝卜张三', '2023-01-08 10:15:34');
INSERT INTO `sys_log` VALUES (70, 0, '0:0:0:0:0:0:0:1', 'getProduct', 'GET', '大萝卜张三', '2023-01-08 10:15:34');
INSERT INTO `sys_log` VALUES (71, 0, '0:0:0:0:0:0:0:1', 'getRepositoryList', 'GET', '大萝卜张三', '2023-01-08 10:15:36');
INSERT INTO `sys_log` VALUES (72, 0, '0:0:0:0:0:0:0:1', 'getProduct', 'GET', '大萝卜张三', '2023-01-08 10:15:36');
INSERT INTO `sys_log` VALUES (73, 0, '0:0:0:0:0:0:0:1', 'outRecordStock', 'POST', '大萝卜张三', '2023-01-08 10:15:40');
INSERT INTO `sys_log` VALUES (74, 0, '0:0:0:0:0:0:0:1', 'getStatisticsInMonth', 'GET', '大萝卜张三', '2023-01-08 10:15:43');
INSERT INTO `sys_log` VALUES (75, 0, '0:0:0:0:0:0:0:1', 'getStatisticsOutMonth', 'GET', '大萝卜张三', '2023-01-08 10:15:43');
INSERT INTO `sys_log` VALUES (76, 0, '0:0:0:0:0:0:0:1', 'getStatisticsMonthMoney', 'GET', '大萝卜张三', '2023-01-08 10:15:43');
INSERT INTO `sys_log` VALUES (77, 0, '0:0:0:0:0:0:0:1', 'getUserDetail', 'GET', '大萝卜张三', '2023-01-08 10:15:53');
INSERT INTO `sys_log` VALUES (78, 0, '0:0:0:0:0:0:0:1', 'uploadFile', 'POST', '大萝卜张三', '2023-01-08 10:15:58');
INSERT INTO `sys_log` VALUES (79, 0, '0:0:0:0:0:0:0:1', 'updateUser', 'POST', '大萝卜张三', '2023-01-08 10:16:00');
INSERT INTO `sys_log` VALUES (80, 0, '0:0:0:0:0:0:0:1', 'home', 'GET', '大萝卜张三', '2023-01-08 10:16:00');
INSERT INTO `sys_log` VALUES (81, 0, '0:0:0:0:0:0:0:1', 'getUserDetail', 'GET', '大萝卜张三', '2023-01-08 10:16:01');
INSERT INTO `sys_log` VALUES (82, 0, '0:0:0:0:0:0:0:1', 'getRepositoryPayloadStatistics', 'GET', '大萝卜张三', '2023-01-08 10:16:01');
INSERT INTO `sys_log` VALUES (83, 0, '0:0:0:0:0:0:0:1', 'getRepositoryPage', 'GET', '大萝卜张三', '2023-01-08 10:16:24');
INSERT INTO `sys_log` VALUES (84, 0, '0:0:0:0:0:0:0:1', 'getRepositoryStatusList', 'GET', '大萝卜张三', '2023-01-08 10:16:25');
INSERT INTO `sys_log` VALUES (85, 0, '0:0:0:0:0:0:0:1', 'addRepository', 'POST', '大萝卜张三', '2023-01-08 10:16:56');
INSERT INTO `sys_log` VALUES (86, 0, '0:0:0:0:0:0:0:1', 'getRepositoryPage', 'GET', '大萝卜张三', '2023-01-08 10:16:56');
INSERT INTO `sys_log` VALUES (87, 0, '0:0:0:0:0:0:0:1', 'home', 'GET', '大萝卜张三', '2023-01-08 10:16:59');
INSERT INTO `sys_log` VALUES (88, 0, '0:0:0:0:0:0:0:1', 'getUserDetail', 'GET', '大萝卜张三', '2023-01-08 10:16:59');
INSERT INTO `sys_log` VALUES (89, 0, '0:0:0:0:0:0:0:1', 'getRepositoryPayloadStatistics', 'GET', '大萝卜张三', '2023-01-08 10:17:00');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID,主键自增',
  `USER_NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `USER_TEL` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系电话',
  `USER_EMAIL` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱',
  `USER_NICK` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'WMS' COMMENT '用户昵称',
  `PASSWORD` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `SALT` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '盐值',
  `CREATE_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) NULL DEFAULT 1 COMMENT '是否删除 0:删除 1:未删除',
  `AVATAR` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '/img/avatar.jpeg' COMMENT '头像',
  PRIMARY KEY (`USER_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '张三', '18288888888', 'z3@163.com', '大萝卜张三', 'a38b872c85e9096dd2d97b5dbe482861', '1', '2023-06-07 15:17:26', '2023-06-07 15:17:27', 1, '/pics/1ffa527f-ae9e-4d6c-b036-7abaf525de03.jpeg');
INSERT INTO `user` VALUES (2, '李四', '18333333321', 'q@q.com', '大萝卜123', '074a99bbd19a11ca921a7b12afffc8bc', '1667568835473', '2022-11-05 05:33:54', '2022-11-20 18:54:17', 1, '/img/avatar.jpeg');
INSERT INTO `user` VALUES (3, '李雷1', '13313676789', 'll@163.com', '雷子', '51b4f11a197f52d062d4825a47486cd4', '0.3175579183075884', '2022-11-21 02:11:17', '2023-06-07 15:59:05', 1, '/img/avatar.jpeg');
INSERT INTO `user` VALUES (4, 'admin', '1', '1', '1', '1', '', '2023-06-07 16:40:23', '2023-06-10 16:05:03', 1, '/img/avatar.jpeg');
INSERT INTO `user` VALUES (7, '3', '3', '3', '3', '3', '', '2023-06-07 16:45:48', '2023-06-10 10:47:40', 1, '/img/avatar.jpeg');
INSERT INTO `user` VALUES (8, '2', '2', '2', '2', '2', '', '2023-06-07 16:59:18', '2023-06-07 16:59:20', 1, '/img/avatar.jpeg');
INSERT INTO `user` VALUES (10, '31', '31', '31', '31', '31', '', '2023-06-07 17:16:08', '2023-06-09 15:54:25', 1, '/img/avatar.jpeg');

-- ----------------------------
-- Table structure for user_department
-- ----------------------------
DROP TABLE IF EXISTS `user_department`;
CREATE TABLE `user_department`  (
  `DEPT_ID` int(11) NOT NULL COMMENT '部门ID',
  `USER_ID` int(11) NOT NULL COMMENT '用户ID',
  `CREATE_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) NULL DEFAULT 1 COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`USER_ID`, `DEPT_ID`) USING BTREE,
  INDEX `DEPT_ID`(`DEPT_ID`) USING BTREE,
  CONSTRAINT `user_department_ibfk_1` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_department_ibfk_2` FOREIGN KEY (`DEPT_ID`) REFERENCES `department` (`DEPT_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户部门关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_department
-- ----------------------------
INSERT INTO `user_department` VALUES (3, 1, '2022-11-04 05:40:53', '2022-11-03 21:40:55', 1);
INSERT INTO `user_department` VALUES (5, 1, '2022-11-04 05:40:53', '2022-11-03 21:40:55', 1);
INSERT INTO `user_department` VALUES (6, 1, '2022-11-04 05:40:53', '2022-11-03 21:40:55', 1);
INSERT INTO `user_department` VALUES (7, 1, '2022-11-04 05:40:53', '2022-11-03 21:40:55', 1);
INSERT INTO `user_department` VALUES (5, 2, '2022-11-05 05:33:54', '2022-11-04 21:33:55', 1);
INSERT INTO `user_department` VALUES (7, 2, '2022-11-05 05:33:54', '2022-11-04 21:33:55', 1);
INSERT INTO `user_department` VALUES (6, 3, '2022-11-21 02:11:17', '2023-06-07 14:45:10', 0);
INSERT INTO `user_department` VALUES (3, 7, '2023-06-07 16:45:48', '2023-06-07 16:54:51', 1);
INSERT INTO `user_department` VALUES (5, 7, '2023-06-07 16:45:48', '2023-06-07 16:54:51', 1);
INSERT INTO `user_department` VALUES (6, 7, '2023-06-07 16:45:48', '2023-06-07 16:54:51', 1);
INSERT INTO `user_department` VALUES (7, 7, '2023-06-07 16:45:48', '2023-06-07 16:54:51', 1);
INSERT INTO `user_department` VALUES (3, 8, '2023-06-07 16:59:18', '2023-06-07 16:59:20', 1);
INSERT INTO `user_department` VALUES (5, 8, '2023-06-07 16:59:18', '2023-06-07 16:59:20', 1);
INSERT INTO `user_department` VALUES (6, 8, '2023-06-07 16:59:18', '2023-06-07 16:59:20', 1);
INSERT INTO `user_department` VALUES (7, 8, '2023-06-07 16:59:18', '2023-06-07 16:59:20', 1);
INSERT INTO `user_department` VALUES (10, 10, '2023-06-07 17:16:08', '2023-06-07 17:17:46', 0);

-- ----------------------------
-- Table structure for user_repository
-- ----------------------------
DROP TABLE IF EXISTS `user_repository`;
CREATE TABLE `user_repository`  (
  `REPO_ID` int(11) NOT NULL COMMENT '仓库ID',
  `USER_ID` int(11) NOT NULL COMMENT '用户ID',
  `CREATE_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) NULL DEFAULT 1 COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`REPO_ID`, `USER_ID`) USING BTREE,
  INDEX `USER_ID`(`USER_ID`) USING BTREE,
  CONSTRAINT `user_repository_ibfk_1` FOREIGN KEY (`REPO_ID`) REFERENCES `repository` (`REPO_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_repository_ibfk_2` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户仓库关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_repository
-- ----------------------------

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `USER_ID` int(11) NOT NULL COMMENT '用户ID,关联用户表主键',
  `ROLE_ID` int(11) NOT NULL COMMENT '角色ID,关联角色表主键',
  `CREATE_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '设置当前时间，并且自动更更新时间',
  `IS_DELETE` int(11) NULL DEFAULT 1 COMMENT '是否删除 0:删除 1:未删除',
  PRIMARY KEY (`USER_ID`, `ROLE_ID`) USING BTREE,
  INDEX `ROLE_ID`(`ROLE_ID`) USING BTREE,
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`ROLE_ID`) REFERENCES `role` (`ROLE_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1, '2022-11-04 05:40:53', '2022-11-03 21:40:55', 1);
INSERT INTO `user_role` VALUES (1, 2, '2022-11-04 05:40:53', '2022-11-03 21:40:55', 1);
INSERT INTO `user_role` VALUES (2, 1, '2022-11-05 05:33:54', '2022-11-04 21:33:55', 1);
INSERT INTO `user_role` VALUES (3, 1, '2022-11-21 02:11:17', '2023-06-07 14:45:10', 0);
INSERT INTO `user_role` VALUES (7, 1, '2023-06-07 16:45:48', '2023-06-07 16:54:51', 1);
INSERT INTO `user_role` VALUES (7, 2, '2023-06-07 16:45:48', '2023-06-07 16:54:51', 1);
INSERT INTO `user_role` VALUES (8, 1, '2023-06-07 16:59:18', '2023-06-07 16:59:20', 1);
INSERT INTO `user_role` VALUES (8, 2, '2023-06-07 16:59:18', '2023-06-07 16:59:20', 1);
INSERT INTO `user_role` VALUES (10, 1, '2023-06-07 17:16:08', '2023-06-07 17:17:46', 0);
INSERT INTO `user_role` VALUES (10, 2, '2023-06-07 17:16:08', '2023-06-07 17:17:46', 0);
INSERT INTO `user_role` VALUES (10, 3, '2023-06-07 17:16:08', '2023-06-07 17:17:46', 0);

SET FOREIGN_KEY_CHECKS = 1;
