/*
 Navicat Premium Data Transfer

 Source Server         : hello
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : canteendb

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 10/06/2019 14:09:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_accountant
-- ----------------------------
DROP TABLE IF EXISTS `sys_accountant`;
CREATE TABLE `sys_accountant`  (
  `accountantId` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `accountantName` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`accountantId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_accountant
-- ----------------------------
INSERT INTO `sys_accountant` VALUES ('accountant', '刘强东', '1');

-- ----------------------------
-- Table structure for sys_buyer
-- ----------------------------
DROP TABLE IF EXISTS `sys_buyer`;
CREATE TABLE `sys_buyer`  (
  `buyerId` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `buyerName` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`buyerId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_buyer
-- ----------------------------
INSERT INTO `sys_buyer` VALUES ('618', '马化腾', '1');

-- ----------------------------
-- Table structure for sys_cashier
-- ----------------------------
DROP TABLE IF EXISTS `sys_cashier`;
CREATE TABLE `sys_cashier`  (
  `cashierId` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cashierName` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`cashierId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_cashier
-- ----------------------------
INSERT INTO `sys_cashier` VALUES ('cashier', '老王', '1');

-- ----------------------------
-- Table structure for sys_manager
-- ----------------------------
DROP TABLE IF EXISTS `sys_manager`;
CREATE TABLE `sys_manager`  (
  `managerNo` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `managerName` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`managerNo`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_manager
-- ----------------------------
INSERT INTO `sys_manager` VALUES ('1014', '张三', '1');

-- ----------------------------
-- Table structure for sys_meal
-- ----------------------------
DROP TABLE IF EXISTS `sys_meal`;
CREATE TABLE `sys_meal`  (
  `mealId` int(36) NOT NULL AUTO_INCREMENT,
  `mealName` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mealDescribe` varchar(124) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mealPrice` double(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`mealId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_meal
-- ----------------------------
INSERT INTO `sys_meal` VALUES (1, '苦瓜炒肉', '其中包含猪肉、苦瓜、米饭', 7.00);
INSERT INTO `sys_meal` VALUES (2, '咖喱牛肉', '包含牛肉、青菜、米饭', 8.00);
INSERT INTO `sys_meal` VALUES (4, '饺子', '玉米馅', 6.00);
INSERT INTO `sys_meal` VALUES (6, '饺子', '玉米馅', 6.50);
INSERT INTO `sys_meal` VALUES (10, '炒粉', '肉抄河粉', 6.00);
INSERT INTO `sys_meal` VALUES (11, '炒粉', '蛋炒粉', 6.00);

-- ----------------------------
-- Table structure for sys_order
-- ----------------------------
DROP TABLE IF EXISTS `sys_order`;
CREATE TABLE `sys_order`  (
  `orderId` int(36) NOT NULL AUTO_INCREMENT,
  `mealName` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `orderNumber` int(4) NULL DEFAULT NULL,
  `orderTime` datetime(6) NULL DEFAULT NULL,
  `orderName` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mealId` int(36) NULL DEFAULT NULL,
  `mealPrice` double(6, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`orderId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_order
-- ----------------------------
INSERT INTO `sys_order` VALUES (13, '苦瓜炒肉', 4, '2019-06-10 10:36:06.000000', 'worker', 1, 7.00);
INSERT INTO `sys_order` VALUES (14, '咖喱牛肉', 4, '2019-06-10 10:37:46.000000', 'worker', 2, 8.00);
INSERT INTO `sys_order` VALUES (15, '咖喱牛肉', 43, '2019-06-10 10:43:22.000000', 'worker', 2, 8.00);

-- ----------------------------
-- Table structure for sys_purchase
-- ----------------------------
DROP TABLE IF EXISTS `sys_purchase`;
CREATE TABLE `sys_purchase`  (
  `purchaseId` int(36) NOT NULL AUTO_INCREMENT,
  `foodName` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `foodPrice` double(10, 2) NULL DEFAULT NULL,
  `totalAmount` double(10, 2) NULL DEFAULT NULL,
  `totalPrice` double(10, 2) NULL DEFAULT NULL,
  `number` int(10) NULL DEFAULT NULL,
  `supplier` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `purchaseTime` datetime(6) NULL DEFAULT NULL,
  `buyer` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0',
  `opinion` varchar(126) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`purchaseId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_purchase
-- ----------------------------
INSERT INTO `sys_purchase` VALUES (1, '牛肉', 16.00, 640.00, 160.00, 10, '小张', '2019-06-08 21:37:13.000000', '李四', '0', NULL);
INSERT INTO `sys_purchase` VALUES (4, '鱼', 14.00, 140.00, 140.00, 10, '老李', '2019-06-08 23:45:19.000000', '张三', '1', '666');
INSERT INTO `sys_purchase` VALUES (6, '鱼', 14.00, 140.00, 140.00, 10, '老李', '2019-06-08 23:47:59.000000', '张三', '0', NULL);
INSERT INTO `sys_purchase` VALUES (8, '鱼', 14.00, 140.00, 140.00, 10, '老李', '2019-06-09 13:06:45.000000', '马化腾', '0', NULL);
INSERT INTO `sys_purchase` VALUES (10, '鱼', 14.00, 140.00, 140.00, 10, '老李', '2019-06-09 13:36:37.000000', '马化腾', '2', '11111');
INSERT INTO `sys_purchase` VALUES (11, '牛肉', 16.00, 160.00, 160.00, 10, '老张', '2019-06-10 13:17:48.000000', '马化腾', '0', NULL);
INSERT INTO `sys_purchase` VALUES (13, '牛肉', 16.00, 160.00, NULL, 10, '老张', '2019-06-10 13:17:48.000000', '马化腾', '2', '444');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `utype` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userName` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_worker
-- ----------------------------
DROP TABLE IF EXISTS `sys_worker`;
CREATE TABLE `sys_worker`  (
  `workerId` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `workerName` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`workerId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_worker
-- ----------------------------
INSERT INTO `sys_worker` VALUES ('116', '马玉', '1');
INSERT INTO `sys_worker` VALUES ('worker', '马云', '1');

SET FOREIGN_KEY_CHECKS = 1;
