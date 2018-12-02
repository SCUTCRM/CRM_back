/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : crm

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2018-11-20 18:26:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `address`
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '地址id',
  `mail_street` varchar(30) NOT NULL COMMENT '街道',
  `mail_po_box` varchar(30) NOT NULL COMMENT '邮箱',
  `mail_city` varchar(30) NOT NULL COMMENT '城市',
  `mail_country` varchar(30) NOT NULL COMMENT '乡村',
  `mail_state` varchar(30) NOT NULL COMMENT '州',
  `other_street` varchar(30) NOT NULL COMMENT '街道',
  `other_po_box` varchar(30) NOT NULL COMMENT '邮箱',
  `other_city` varchar(30) NOT NULL COMMENT '城市',
  `other_country` varchar(30) NOT NULL COMMENT '国家',
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('1', '小谷围街道', '邮箱2', '蕉岭', '梅州', '中国', '桂岭大道', '邮箱2', '蕉岭', '梅州');
INSERT INTO `address` VALUES ('2', '小谷围街道', '邮箱2', '蕉岭', '梅州', '中国', '桂岭大道', '邮箱2', '蕉岭', '梅州');
INSERT INTO `address` VALUES ('3', '小谷围街道', '邮箱1', '番禺', '广州', '美国', '桂岭大道', '邮箱2', '蕉岭', '梅州');

-- ----------------------------
-- Table structure for `campaign`
-- ----------------------------
DROP TABLE IF EXISTS `campaign`;
CREATE TABLE `campaign` (
  `campaign_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '活动id',
  `campaign_name` varchar(30) NOT NULL COMMENT '活动名字',
  `campaign_type` varchar(30) NOT NULL COMMENT '活动类型',
  `campaign_status` int(11) NOT NULL COMMENT '活动状态',
  `expected_revenue` double(11,2) NOT NULL COMMENT '预期收入',
  `expected_close_date` datetime NOT NULL COMMENT '预期结束时间',
  `assign_to` varchar(30) NOT NULL COMMENT '分配给',
  `target_size` int(5) NOT NULL COMMENT '目标大小',
  `num_sent` int(5) NOT NULL COMMENT '发送数量',
  `target_audience` varchar(30) NOT NULL COMMENT '目标听众',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modified_time` datetime NOT NULL COMMENT '修改时间',
  `sponsor` int(11) NOT NULL COMMENT '赞助',
  `description` varchar(30) NOT NULL COMMENT '联系人',
  `update_info` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '更改信息',
  `product_id` int(11) NOT NULL COMMENT '产品id',
  `exp_actual_id` int(11) NOT NULL COMMENT '预期和实际id',
  `opport_id` int(11) NOT NULL COMMENT '机会id',
  PRIMARY KEY (`campaign_id`),
  KEY `product_id` (`product_id`),
  KEY `exp_actual_id` (`exp_actual_id`),
  KEY `opport_id` (`opport_id`),
  CONSTRAINT `campaign_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `campaign_ibfk_2` FOREIGN KEY (`exp_actual_id`) REFERENCES `exp_actual` (`exp_actual_id`),
  CONSTRAINT `campaign_ibfk_3` FOREIGN KEY (`opport_id`) REFERENCES `opportunity` (`opport_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of campaign
-- ----------------------------
INSERT INTO `campaign` VALUES ('1', '足球活动', '足球', '1', '100.00', '2018-11-12 09:12:59', '1', '1', '1', 'Liu Bin', '2018-11-12 09:12:59', '2018-11-12 09:12:59', '100', '测试', '测试更改', '1', '1', '1', '1');
INSERT INTO `campaign` VALUES ('3', '篮球活动', '篮球', '1', '100.00', '2018-11-15 09:12:39', '1', '1', '1', '刘斌', '2018-11-15 09:12:39', '2018-11-15 09:12:39', '100', '测试', '测试插入', '1', '1', '1', '1');
INSERT INTO `campaign` VALUES ('4', '篮球活动', '篮球', '1', '100.00', '2018-11-15 09:13:22', '1', '1', '1', '刘斌', '2018-11-15 09:13:22', '2018-11-15 09:13:22', '100', '测试', '测试插入', '1', '1', '1', '1');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `comment` varchar(100) NOT NULL COMMENT '评论',
  `user_id` int(11) NOT NULL COMMENT '评论人',
  PRIMARY KEY (`comment_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for `contact`
-- ----------------------------
DROP TABLE IF EXISTS `contact`;
CREATE TABLE `contact` (
  `contact_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '联系人id',
  `first_name` varchar(30) NOT NULL COMMENT '名字',
  `last_name` varchar(30) NOT NULL COMMENT '姓',
  `title` varchar(30) NOT NULL COMMENT '称呼（头衔）',
  `primary_email` varchar(30) NOT NULL COMMENT '邮件',
  `office_phone` varchar(11) NOT NULL COMMENT '办公室电话',
  `assign_to` varchar(30) NOT NULL COMMENT '分配给',
  `is_from_lead` varchar(2) NOT NULL COMMENT '是否是来自于线索',
  `home_phone` varchar(11) NOT NULL COMMENT '家的电话',
  `update_info` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '更改',
  `lead_state` int(2) NOT NULL COMMENT '线索状态',
  `industry` varchar(30) NOT NULL COMMENT '行业',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modified_time` datetime NOT NULL COMMENT '改修时间',
  `day_of_birth` datetime NOT NULL COMMENT '出生时间',
  `department` varchar(30) NOT NULL COMMENT '部门',
  `assistant` varchar(30) NOT NULL COMMENT '助理',
  `assistant_phone` varchar(11) NOT NULL COMMENT '助理电话',
  `profile_picture` varchar(100) NOT NULL COMMENT '个人资料图片',
  `description` varchar(150) NOT NULL COMMENT '描述',
  `organization_id` int(11) NOT NULL COMMENT '组织id',
  `address_id` int(11) NOT NULL COMMENT '地址id',
  `document_id` int(11) NOT NULL COMMENT '文件id',
  PRIMARY KEY (`contact_id`),
  KEY `organization_id` (`organization_id`),
  KEY `address_id` (`address_id`),
  KEY `contact_ibfk_3` (`document_id`),
  CONSTRAINT `contact_ibfk_1` FOREIGN KEY (`organization_id`) REFERENCES `organization` (`organization_id`),
  CONSTRAINT `contact_ibfk_2` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`),
  CONSTRAINT `contact_ibfk_3` FOREIGN KEY (`document_id`) REFERENCES `document` (`document_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of contact
-- ----------------------------
INSERT INTO `contact` VALUES ('1', '刘', '斌', '学生', '1145054472@qq.com', '788', '1', 'Y', '788722', '更改Contact', '1', '教育', '2018-11-12 08:42:07', '2018-11-12 08:42:07', '3898-06-05 16:00:00', '华工软件', '狗辉', '1576698', 'c://picture', '测试', '1', '1', '1');
INSERT INTO `contact` VALUES ('3', '刘', '斌', '学生', '1145054472@qq.com', '788', '1', 'Y', '7887227', '插入Contact', '1', '教育', '2018-11-15 10:10:30', '2018-11-15 10:10:30', '3898-06-05 16:00:00', '华工软件', '林少辉', '1576698', 'c://picture', '测试', '1', '1', '1');

-- ----------------------------
-- Table structure for `document`
-- ----------------------------
DROP TABLE IF EXISTS `document`;
CREATE TABLE `document` (
  `document_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文件id',
  `title` varchar(30) NOT NULL COMMENT '标题',
  `file_name` varchar(30) NOT NULL COMMENT '文件名',
  `document_no` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件No',
  `assign_to` varchar(30) NOT NULL COMMENT '分配给',
  `create_time` datetime NOT NULL COMMENT '创造时间',
  `modified_time` datetime NOT NULL COMMENT '修改时间',
  `update_info` varchar(150) NOT NULL COMMENT '更改',
  `description` varchar(150) NOT NULL COMMENT '描述',
  PRIMARY KEY (`document_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of document
-- ----------------------------
INSERT INTO `document` VALUES ('1', '数据挖掘比赛', '数据挖掘', '1', '1', '2018-11-15 08:00:27', '2018-11-15 08:00:27', '插入文件', '测试');
INSERT INTO `document` VALUES ('2', '数据挖掘比赛', '机器学习', '2', '1', '2018-11-15 08:05:05', '2018-11-15 08:05:05', '修改文件', '测试');

-- ----------------------------
-- Table structure for `exp_actual`
-- ----------------------------
DROP TABLE IF EXISTS `exp_actual`;
CREATE TABLE `exp_actual` (
  `exp_actual_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '实际花费id',
  `budget_cost` double(11,2) NOT NULL COMMENT '预算成本',
  `actual_cost` double(11,2) NOT NULL COMMENT '实际成本',
  `exp_response` varchar(11) NOT NULL COMMENT '预期的回应',
  `actual_response` varchar(11) NOT NULL COMMENT '实际的回应',
  `exp_sale_count` int(11) NOT NULL COMMENT '预期的数量',
  `actual_sale_count` int(11) NOT NULL COMMENT '实际的数量',
  `exp_roi` double(4,2) NOT NULL COMMENT '期望的roi(投资回报率)',
  `actual_roi` double(4,2) NOT NULL COMMENT '实际的roi',
  PRIMARY KEY (`exp_actual_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exp_actual
-- ----------------------------
INSERT INTO `exp_actual` VALUES ('1', '100.00', '110.00', '降低价格', '提高价格', '1000', '2000', '2.10', '10.50');
INSERT INTO `exp_actual` VALUES ('3', '100.00', '110.00', '降低价格', '提高价格', '1000', '2000', '2.10', '10.50');

-- ----------------------------
-- Table structure for `leads`
-- ----------------------------
DROP TABLE IF EXISTS `leads`;
CREATE TABLE `leads` (
  `lead_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '线索id',
  `first_name` varchar(30) NOT NULL COMMENT '名字',
  `last_name` varchar(30) NOT NULL COMMENT '姓',
  `company` varchar(30) NOT NULL COMMENT '公司',
  `primary_phone` varchar(11) NOT NULL COMMENT '常用电话',
  `website` varchar(30) NOT NULL COMMENT '网站',
  `primary_email` varchar(30) NOT NULL COMMENT '常用邮箱',
  `assign_to` varchar(30) NOT NULL COMMENT '分配给',
  `annual_revenue` double(11,2) NOT NULL COMMENT '年收入',
  `phone` varchar(11) DEFAULT NULL COMMENT '电话?',
  `email` varchar(30) NOT NULL COMMENT '邮箱',
  `update_info` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '更改',
  `description` varchar(150) NOT NULL COMMENT '描述',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modified_time` datetime NOT NULL COMMENT '修改时间',
  `product_id` int(11) NOT NULL COMMENT '产品id',
  `organization_id` int(11) NOT NULL COMMENT '组织id',
  `address_id` int(11) NOT NULL COMMENT '地址id',
  `document_id` int(11) DEFAULT NULL COMMENT '文件id',
  `comment_id` int(11) DEFAULT NULL COMMENT '评论id',
  PRIMARY KEY (`lead_id`),
  KEY `product_id` (`product_id`),
  KEY `organization_id` (`organization_id`),
  KEY `address_id` (`address_id`),
  KEY `leads_ibfk_4` (`document_id`),
  CONSTRAINT `leads_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `leads_ibfk_2` FOREIGN KEY (`organization_id`) REFERENCES `organization` (`organization_id`),
  CONSTRAINT `leads_ibfk_3` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`),
  CONSTRAINT `leads_ibfk_4` FOREIGN KEY (`document_id`) REFERENCES `document` (`document_id`),
  CONSTRAINT `leads_ibfk_5` FOREIGN KEY (`comment_id`) REFERENCES `comment` (`comment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of leads
-- ----------------------------
INSERT INTO `leads` VALUES ('1', '刘', '斌', '谷歌', '15766345459', 'www.baidu.com', '1145054472@qq.com', '1', '100.00', '7887227', 'liubin2018v@gmail.com', '插入潜在客户', '测试', '2018-11-12 08:45:58', '2018-11-12 08:45:58', '1', '1', '1', '1');
INSERT INTO `leads` VALUES ('3', '刘', '斌', '谷歌', '1576634545', 'www.baidu.com', '1145054472@qq.com', '1', '100.00', '7887227', 'liubin2018v@gmail.com', '插入潜在客户', '测试', '2018-11-15 10:11:18', '2018-11-15 10:11:18', '1', '1', '1', '1');

-- ----------------------------
-- Table structure for `opportunity`
-- ----------------------------
DROP TABLE IF EXISTS `opportunity`;
CREATE TABLE `opportunity` (
  `opport_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '机会id',
  `opport_name` varchar(30) NOT NULL COMMENT '机会名字',
  `prob` double(4,2) NOT NULL COMMENT '概率',
  `forcast_amount` int(11) NOT NULL COMMENT '预测金额',
  `is_from_lead` varchar(2) NOT NULL COMMENT '是否是来自于线索',
  `assign_to` varchar(30) NOT NULL COMMENT '分配给',
  `sales_stage` varchar(30) NOT NULL COMMENT '销售阶段',
  `lead_source` varchar(30) NOT NULL COMMENT '线索来源',
  `update_info` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '更改',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modified_time` datetime NOT NULL COMMENT '修改时间',
  `opport_type` varchar(30) NOT NULL COMMENT '类型',
  `expected_close_date` datetime NOT NULL COMMENT '预期结束时间',
  `description` varchar(150) NOT NULL COMMENT '描述',
  `contact_id` int(11) NOT NULL COMMENT '联系人id',
  `document_id` int(11) NOT NULL COMMENT '文件id',
  PRIMARY KEY (`opport_id`),
  KEY `contact_id` (`contact_id`),
  KEY `opportunity_ibfk_2` (`document_id`),
  CONSTRAINT `opportunity_ibfk_1` FOREIGN KEY (`contact_id`) REFERENCES `contact` (`contact_id`),
  CONSTRAINT `opportunity_ibfk_2` FOREIGN KEY (`document_id`) REFERENCES `document` (`document_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of opportunity
-- ----------------------------
INSERT INTO `opportunity` VALUES ('1', 'offor', '11.00', '11.00', 'Y', '1', '结束阶段', '手册', '更改机会', '2018-11-12 09:08:24', '2018-11-12 09:08:24', '工作', '2018-11-12 09:08:24', '测试', '1', '1');
INSERT INTO `opportunity` VALUES ('4', 'offor', '11.00', '11.00', 'Y', '1', '开始阶段', '手册', '插入机会', '2018-11-15 10:12:04', '2018-11-15 10:12:04', '工作', '2018-11-15 10:12:04', '测试', '1', '1');

-- ----------------------------
-- Table structure for `organization`
-- ----------------------------
DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization` (
  `organization_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '组织id',
  `organization_name` varchar(30) NOT NULL COMMENT '组织名称',
  `organization_number` varchar(4) NOT NULL COMMENT '组织Number',
  `website` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '网站',
  `primary_phone` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '主电话',
  `member_of` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '成员',
  `employee` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '雇员',
  `assign_to` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分配给',
  `update_info` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '更改',
  `billing_city` varchar(30) NOT NULL COMMENT '城市',
  `is_from_lead` varchar(2) NOT NULL COMMENT '是否是来自于线索',
  `owner_ship` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所有权',
  `annual_revenue` double(11,2) NOT NULL COMMENT '年收入',
  `industry` varchar(30) NOT NULL COMMENT '行业',
  `modified_time` datetime NOT NULL COMMENT '修改时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `address_id` int(11) NOT NULL COMMENT '地址id',
  `description` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  `product_id` int(11) NOT NULL COMMENT '产品id',
  `document_id` int(11) NOT NULL COMMENT '文件id',
  `comment_id` int(11) DEFAULT NULL COMMENT '评论id',
  PRIMARY KEY (`organization_id`),
  KEY `address_id` (`address_id`),
  KEY `organization_ibfk_2` (`product_id`),
  KEY `organization_ibfk_3` (`document_id`),
  KEY `organization_ibfk_4` (`comment_id`),
  CONSTRAINT `organization_ibfk_1` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`),
  CONSTRAINT `organization_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `organization_ibfk_3` FOREIGN KEY (`document_id`) REFERENCES `document` (`document_id`),
  CONSTRAINT `organization_ibfk_4` FOREIGN KEY (`comment_id`) REFERENCES `comment` (`comment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of organization
-- ----------------------------
INSERT INTO `organization` VALUES ('1', '华工', '', 'www.scut.edu.cn', '123456', '软件学院', '老师', '1', '修改组织', '广州', 'Y', '教育部', '1000000.00', '教育', '2018-11-12 08:39:09', '2018-11-12 08:39:09', '1', '测试', '1', '1', null);
INSERT INTO `organization` VALUES ('3', '华工', '', 'www.scut.edu.cn', '123456', '软件学院', '老师', '1', '修改组织', '广州', 'Y', '教育部', '1000000.00', '教育', '2018-11-14 12:58:35', '2018-11-14 12:58:35', '1', '测试', '3', '1', null);
INSERT INTO `organization` VALUES ('4', '华工', '', 'www.scut.edu.cn', '123456', '软件学院', '老师', '1', '插入组织', '广州', 'Y', '教育部', '1000000.00', '教育', '2018-11-15 10:12:49', '2018-11-15 10:12:49', '1', '测试', '3', '1', null);

-- ----------------------------
-- Table structure for `parent_product`
-- ----------------------------
DROP TABLE IF EXISTS `parent_product`;
CREATE TABLE `parent_product` (
  `father_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '父代信息id',
  `product_id` int(11) NOT NULL COMMENT '产品id',
  `parent_id` int(11) DEFAULT NULL COMMENT '父代产品id',
  PRIMARY KEY (`father_id`),
  KEY `product_id` (`product_id`),
  KEY `parent_id` (`parent_id`),
  CONSTRAINT `parent_product_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `parent_product_ibfk_2` FOREIGN KEY (`parent_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of parent_product
-- ----------------------------

-- ----------------------------
-- Table structure for `price`
-- ----------------------------
DROP TABLE IF EXISTS `price`;
CREATE TABLE `price` (
  `price_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '价格id',
  `unit_price` double(11,2) NOT NULL COMMENT '单价',
  `commission_rate` double(4,2) NOT NULL COMMENT '佣金率',
  PRIMARY KEY (`price_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of price
-- ----------------------------
INSERT INTO `price` VALUES ('1', '13500.00', '0.00');
INSERT INTO `price` VALUES ('2', '15000.00', '0.00');
INSERT INTO `price` VALUES ('3', '14000.00', '0.00');
INSERT INTO `price` VALUES ('4', '14880.00', '0.00');

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '产品id',
  `product_no` varchar(100) NOT NULL COMMENT '产品no' unique,
  `product_name` varchar(50) NOT NULL COMMENT '产品名称',
  `part_number` varchar(30) NOT NULL COMMENT '零件号',
  
  `product_number` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品编号',
  `product_category` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '产品种类',
  `active` int(2) NOT NULL COMMENT '产品是否在售',
  `sale_start_date` varchar(1024) DEFAULT NULL COMMENT '销售开始日期',
  `sale_end_date` varchar(1024) DEFAULT NULL COMMENT '销售结束日期',
  `website` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '网站',
  `ventor_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '供应商',
  `ventor_partno` int(11) DEFAULT NULL COMMENT '供应商no',
  `create_time` datetime NOT NULL COMMENT '创造时间',
  `modified_time` datetime NOT NULL COMMENT '修改时间',
  `manufacturer` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '生产厂家',
  `description` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '描述',
  `update_info` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '更改',
  `price_id` int(11) NOT NULL COMMENT '价格id',
  `document_id` int(11) NOT NULL COMMENT '文件id',
  `stock_info_id` int(11) NOT NULL COMMENT '库存id',
  `father_id` int(11) DEFAULT NULL COMMENT '父类id',
  `bundle_id` int(11) DEFAULT NULL COMMENT '绑定id',
  PRIMARY KEY (`product_id`),
  KEY `price_id` (`price_id`),
  KEY `stock_info_id` (`stock_info_id`),
  KEY `product_ibfk_3` (`document_id`),
  KEY `product_ibfk_4` (`father_id`),
  KEY `product_ibfk_5` (`bundle_id`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`price_id`) REFERENCES `price` (`price_id`),
  CONSTRAINT `product_ibfk_2` FOREIGN KEY (`stock_info_id`) REFERENCES `stock_info` (`stock_info_id`),
  CONSTRAINT `product_ibfk_3` FOREIGN KEY (`document_id`) REFERENCES `document` (`document_id`),
  CONSTRAINT `product_ibfk_4` FOREIGN KEY (`father_id`) REFERENCES `parent_product` (`father_id`),
  CONSTRAINT `product_ibfk_5` FOREIGN KEY (`bundle_id`) REFERENCES `product_bundles` (`bundle_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', 'EVOS FLoid Cell Imaging Station\r\n', '4471136\r\n', 'PRO1', '', '1', '', '', '', '', null, '2018-11-12 08:34:19', '2018-11-12 08:34:19', '', 'Designed in collaboration with fluorescence microscopy users, the EVOS FLoid Cell Imaging Station captures high-quality, three-color fluorescent cell images right at your benchtop, with an interface that is so simple even novice users can collect data in just a few clicks of the mouse.\r\n', '更改产品', '1', '1', '1', null, null);
INSERT INTO `product` VALUES ('2', 'EVOS FL Cell Imaging System\r\n', 'AMEFC4300\r\n', 'PRO2', '', '1', '', '', '', '', null, '2018-11-15 10:14:22', '2018-11-15 10:14:22', '', 'The powerful yet easy-to-use EVOS™ FL Cell Imaging System provides the flexibility to fit most epifluorescence microscopy applications. Combining precision components with unique design functionality, the EVOS FL Cell Imaging System has revolutionized fluorescent microscopy.\r\n', '插入产品', '2', '1', '1', null, null);
INSERT INTO `product` VALUES ('3', 'Invitrogen EVOS FL Auto Cell Imaging System', 'AMAFD1000\r\n', 'PRO3', '', '1', '', '', '', '', null, '2018-11-13 14:43:57', '2018-11-13 14:43:57', '', 'The Invitrogen™ EVOS™ FL Auto Imaging System brings the simplicity of the entire EVOS line to an automated imaging platform capable of live cell imaging, area scanning, image stitching, and time-lapse imaging with a simple touch of the monitor—all at a price that is affordable for any lab.', '更改产品', '3', '1', '1', null, null);
INSERT INTO `product` VALUES ('4', 'EVOS Onstage Incubator\r\n', 'AMC1000\r\n', 'PRO4', null, '1', null, null, null, null, null, '2018-11-16 18:18:08', '2018-11-16 18:18:12', null, 'The EVOS® Onstage Incubator is an environmental chamber designed specifically for the EVOS® FL Auto Imaging System. It enables precise control of temperature, humidity, and three gases for time-lapse imaging of live cells under both physiological and non-physiological conditions. Environmental settings and image acquisition parameters are all seamlessly integrated into the EVOS® FL Auto interface, creating a high-performance inverted imaging system with excellent flexibility, ease of use, and a superb optical performance for demanding live cell time-lapse imaging experiments.\r\n', '插入产品', '4', '1', '2', null, null);

-- ----------------------------
-- Table structure for `product_bundles`
-- ----------------------------
DROP TABLE IF EXISTS `product_bundles`;
CREATE TABLE `product_bundles` (
  `bundle_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '捆绑信息id',
  `bundle1_id` int(11) NOT NULL COMMENT '捆绑产品1id',
  `bundle2_id` int(11) NOT NULL COMMENT '捆绑产品2id',
  PRIMARY KEY (`bundle_id`),
  KEY `bundle1_id` (`bundle1_id`),
  KEY `bundle2_id` (`bundle2_id`),
  CONSTRAINT `product_bundles_ibfk_1` FOREIGN KEY (`bundle1_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `product_bundles_ibfk_2` FOREIGN KEY (`bundle2_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_bundles
-- ----------------------------

-- ----------------------------
-- Table structure for `stock_info`
-- ----------------------------
DROP TABLE IF EXISTS `stock_info`;
CREATE TABLE `stock_info` (
  `stock_info_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '库存id',
  `usage_unit` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '鎼存挸鐡ㄩ惃鍕▏閻劌宕熸担?',
  `qty_in_stock` int(11) NOT NULL COMMENT '库存数量',
  `unit` int(11) NOT NULL COMMENT '数量/单位',
  `qty_in_demand` int(11) NOT NULL COMMENT '需求量',
  PRIMARY KEY (`stock_info_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stock_info
-- ----------------------------
INSERT INTO `stock_info` VALUES ('1', '', '0', '0', '0');
INSERT INTO `stock_info` VALUES ('2', 'Carton\r\n', '0', '0', '0');

-- ----------------------------
-- Table structure for `ticket`
-- ----------------------------
DROP TABLE IF EXISTS `ticket`;
CREATE TABLE `ticket` (
  `ticket_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '身份证id',
  `title` varchar(30) NOT NULL COMMENT '称号',
  `status` int(11) NOT NULL COMMENT '状态',
  `priority` int(11) NOT NULL COMMENT '优先权等级',
  `assign_to` varchar(30) NOT NULL COMMENT '分配给',
  `hour_num` varchar(5) NOT NULL COMMENT '小时',
  `category` varchar(30) NOT NULL COMMENT '种类',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modified_time` datetime NOT NULL COMMENT '修改时间',
  `severity` int(11) NOT NULL COMMENT '严重',
  `days` int(11) NOT NULL COMMENT '天数',
  `description` varchar(150) NOT NULL COMMENT '描述',
  `update_info` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '鏇存敼',
  `organization_id` int(11) NOT NULL COMMENT '组织id',
  `product_id` int(11) NOT NULL COMMENT '产品id',
  `document_id` int(11) NOT NULL COMMENT '文件id',
  PRIMARY KEY (`ticket_id`),
  KEY `organization_id` (`organization_id`),
  KEY `product_id` (`product_id`),
  KEY `ticket_ibfk_3` (`document_id`),
  CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`organization_id`) REFERENCES `organization` (`organization_id`),
  CONSTRAINT `ticket_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `ticket_ibfk_3` FOREIGN KEY (`document_id`) REFERENCES `document` (`document_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ticket
-- ----------------------------
INSERT INTO `ticket` VALUES ('1', 'macbookpro售后', '1', '1', '1', '5小时', '电脑', '2018-11-12 08:56:51', '2018-11-12 08:56:51', '1', '5', '测试', '更改售后服务', '1', '1', '1');
INSERT INTO `ticket` VALUES ('3', 'thinkpad售后', '1', '1', '1', '5小时', '电脑', '2018-11-15 10:14:56', '2018-11-15 10:14:56', '1', '5', '测试', '插入售后服务', '1', '1', '1');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(30) NOT NULL COMMENT '用户姓名',
  `password` varchar(30) NOT NULL COMMENT '密码',
  `phone` varchar(11) NOT NULL COMMENT '电话',
  `email` varchar(30) NOT NULL COMMENT '邮件',
  `address_id` int(11) NOT NULL COMMENT '地址id',
  `title` varchar(30) NOT NULL COMMENT '称呼（头衔）',
  `lead_id` int(11) NOT NULL COMMENT '线索id',
  `contact_id` int(11) NOT NULL COMMENT '联系人id',
  PRIMARY KEY (`user_id`),
  KEY `address_id` (`address_id`),
  KEY `contact_id` (`contact_id`),
  KEY `lead_id` (`lead_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`),
  CONSTRAINT `user_ibfk_2` FOREIGN KEY (`contact_id`) REFERENCES `contact` (`contact_id`),
  CONSTRAINT `user_ibfk_3` FOREIGN KEY (`lead_id`) REFERENCES `leads` (`lead_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
