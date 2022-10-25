/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : t_shop

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 04/04/2022 20:50:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'username',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'password',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT 'time',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', '123', '2022-03-24 22:34:02');
INSERT INTO `admin` VALUES (2, 'mtycode', '123', '2022-03-25 10:43:50');

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `gid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'good',
  `num` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'quantity',
  `uid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'user',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT 'time',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cart
-- ----------------------------

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Category',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'description',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT 'time',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (3, 'sea cucumber', 'sea cucumber', '2022-03-27 10:33:01');
INSERT INTO `category` VALUES (4, 'crab', 'crab', '2022-03-27 10:33:28');
INSERT INTO `category` VALUES (5, 'fish', 'fish', '2022-03-27 11:20:20');
INSERT INTO `category` VALUES (6, 'shellfish', 'shellfish', '2022-03-27 11:20:28');
INSERT INTO `category` VALUES (7, 'shrimp', 'shrimp', '2022-03-27 11:45:57');
INSERT INTO `category` VALUES (8, 'seafood products', 'seafood products', '2022-03-29 21:36:56');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `image` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'good image',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'name',
  `cid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Category',
  `money` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'price',
  `content` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'good description',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT 'time',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (22, 'http://localhost:8081/upload/bda58125-1711-42f3-9fd8-a307f0078f7b.jpg', 'Authentic golden soup Buddha jumps over the wall', '8', '49', '<p>Fuzhou Pavilion Huaxiang Authentic Golden Soup Buddha Jumps Over the Wall 220g Single serving Abalone, Sea Cucumber, Fish Maw, Big Potted Vegetables, Seafood Instant Dish, Golden Soup Buddha Jumps Over the Wall 220g<br></p>', '2022-04-04 18:24:46');
INSERT INTO `goods` VALUES (23, 'http://localhost:8081/upload/e17f840c-2819-48ce-b2d3-62c791fc1b25.jpg', 'Dried squid in the East China Sea', '8', '178', '<p>绿帝 东海墨鱼干乌贼淡晒福建漳州海产品特产海鲜干货目鱼干454g</p>', '2022-04-04 18:25:58');
INSERT INTO `goods` VALUES (24, 'http://localhost:8081/upload/63bb4f34-6704-4920-be82-92518ff39a6f.png', '沃鲜汇国产大虾', '7', '121', '<p>虾 沃鲜汇国产 大虾 青虾鲜虾海虾基围虾冷冻生鲜 虾类 白虾 【推荐】14-16厘米(90%客户选择4斤加量装) 加量4斤装【推荐 虾更多】<br></p>', '2022-04-04 18:30:04');
INSERT INTO `goods` VALUES (25, 'http://localhost:8081/upload/57d94bf6-0d4e-4ee6-b2e1-40e6e2f9db86.png', '农谣人国产大号青虾仁', '7', '99', '<p>【第2件 5折】农谣人国产大号青虾仁 活剥去虾线翡翠生白青虾仁冷冻生鲜虾海鲜水产 青虾仁1000g/约80-120个<br></p>', '2022-04-04 18:30:45');
INSERT INTO `goods` VALUES (26, 'http://localhost:8081/upload/c6ba79f8-38db-47f9-adf1-356d09e264c9.jpg', '冷冻大鲍鱼', '6', '69', '<p>沃派 冷冻大鲍鱼 鲍鱼捞饭食材 500g 9-11头 袋装 生鲜水产 海鲜年货 送礼佳品<br></p>', '2022-04-04 18:31:52');
INSERT INTO `goods` VALUES (27, 'http://localhost:8081/upload/fa8d61a0-4499-4e0e-bf24-9783287a6463.jpg', '冷冻特大扇贝肉', '6', '49', '<p>沃派 冷冻特大扇贝肉 大帆立贝肉 粉丝扇贝原料 500g 袋装 火锅烧烤食材 生鲜水产<br></p>', '2022-04-04 18:32:31');
INSERT INTO `goods` VALUES (28, 'http://localhost:8081/upload/6b259209-dcbb-48f9-b3f5-3726c0f4ba15.jpg', '鲜拔头筹红石斑鱼', '5', '69', '<p>3条仅 69 】鲜拔头筹 红石斑鱼3条装 4.5斤 大眼鱼富贵鱼深海鱼 海鲜水产 3条 4.5斤<br></p>', '2022-04-04 18:33:26');
INSERT INTO `goods` VALUES (29, 'http://localhost:8081/upload/108b2957-a3af-43f5-a39e-86d400a0dbeb.jpg', '三去多宝鱼', '5', '69', '<p>三去多宝鱼（去鳞去腮去内脏）生鲜 鱼类海鲜似鲽鱼 净重400g/条深海鱼冷冻比目鱼 已处理 开袋即烹<br></p>', '2022-04-04 18:34:20');
INSERT INTO `goods` VALUES (30, 'http://localhost:8081/upload/4c947a7e-9a49-4820-b054-2165ef0422ad.jpg', '青岛大鲅鱼', '5', '399', '<p>鲜源澜湾 青岛大鲅鱼5-20斤大鲅鱼马鲛鱼新鲜海鲜水产冷冻1条礼品伴手礼 10斤左右整条<br></p>', '2022-04-04 18:35:04');
INSERT INTO `goods` VALUES (31, 'http://localhost:8081/upload/66599966-de32-4681-b6fc-606da0ba1ad2.jpg', ' 挪威三文鱼冰鲜', '5', '133', '<p>尝鲜生 挪威三文鱼冰鲜 (大西洋鲑)日式刺身拼盘生鲜鱼类刺身精选中段健康轻食 500g【整块1-3块 】<br></p>', '2022-04-04 18:36:09');
INSERT INTO `goods` VALUES (32, 'http://localhost:8081/upload/f43518f5-f893-4d26-8677-f8bbeceaa346.jpg', '帝王蟹', '4', '398', '<p>礼盒包装 海渔链 帝王蟹帝皇蟹 熟冻 大螃蟹长脚蟹海鲜生鲜 ( 2.4斤-2.8斤)/只礼盒装顺丰24H发货<br></p>', '2022-04-04 18:36:50');
INSERT INTO `goods` VALUES (33, 'http://localhost:8081/upload/650a77b4-7273-4ed1-99a2-8063b52eadc5.jpg', '梭子蟹', '4', '110', '<p>梭子蟹活冻蟹梭子蟹鲜活速冻海蟹带箱10斤50只左右 生鲜 罗菲迪新 梭子蟹<br></p>', '2022-04-04 18:37:43');
INSERT INTO `goods` VALUES (34, 'http://localhost:8081/upload/ff16f70a-d9fa-494c-a4bb-90810ad664af.jpg', '蟹家长大闸蟹', '4', '99', '<p>蟹家长大闸蟹鲜活小螃蟹现货批发新鲜毛蟹河蟹稻田蟹海鲜活物 五元蟹18送2只<br></p>', '2022-04-04 18:38:24');
INSERT INTO `goods` VALUES (35, 'http://localhost:8081/upload/476ee928-9955-4bf1-8db9-8798ab060483.jpg', '海鲜组合套装麻辣小海鲜', '8', '28', '<p>海鲜晟 海鲜组合套装麻辣小海鲜熟食组合网红零食八爪鱼大爆头罐头即食小吃鱿鱼仔鲍鱼海螺生蚝罐头 八爪+鱿鱼+海兔+扇贝+蛤蜊【5罐】<br></p>', '2022-04-04 18:39:38');
INSERT INTO `goods` VALUES (36, 'http://localhost:8081/upload/e3fa3c6d-c2b4-4e73-8dbd-c37db774c0ec.jpg', '福建正宗佛跳墙', '8', '138', '<p>海鲜煌 福建正宗佛跳墙1250g加热即食鲍鱼海参花胶海鲜水产大盆菜生鲜盒装 佛跳墙1250g<br></p>', '2022-04-04 18:40:27');
INSERT INTO `goods` VALUES (37, 'http://localhost:8081/upload/c4d6bb3e-7899-4854-9682-7db8dbb7c12b.jpg', '首鲜道鲍鱼', '8', '136', '<p>首鲜道鲍鱼海参佛跳墙大盆菜加热即食海鲜制品年货送礼海鲜礼盒年货盆菜盘菜 佛跳墙 超大1250g 金汤熬制（京东仓直发）<br></p>', '2022-04-04 18:41:30');

-- ----------------------------
-- Table structure for order_item
-- ----------------------------
DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `oid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'order',
  `gid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'good',
  `num` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'quantity',
  `money` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'price',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT 'time',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_item
-- ----------------------------
INSERT INTO `order_item` VALUES (31, '10', '35', '2', '28', '2022-04-04 19:43:29');
INSERT INTO `order_item` VALUES (32, '11', '30', '1', '399', '2022-04-04 19:48:43');
INSERT INTO `order_item` VALUES (33, '11', '34', '1', '99', '2022-04-04 19:48:43');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'order number',
  `num` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'quantity',
  `total` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'total price',
  `uid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'user',
  `remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'remake',
  `status` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'status',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT 'time',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (10, '20220404194328', '2', '56', '1', NULL, '02', '2022-04-04 19:43:29');
INSERT INTO `orders` VALUES (11, '20220404194843', '2', '498', '1', NULL, '02', '2022-04-04 19:48:43');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'phone',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'password',
  `realname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'name',
  `sex` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'gender',
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'address',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT 'time',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '15263232325', '123456', 'zhaoyuyan', 'female', 'beijing', '2022-03-24 23:16:15');
INSERT INTO `user` VALUES (2, '18541414141', '123456', 'sample', 'male', 'beijing', '2022-03-29 21:46:24');

SET FOREIGN_KEY_CHECKS = 1;
