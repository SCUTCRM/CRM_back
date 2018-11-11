SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `stock_info`;
CREATE TABLE `stock_info` (
  `stock_info_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '库存id',
  `usage_unit` int(11) NOT NULL COMMENT '库存的使用单位',
  `qty_in_stock` int(11) NOT NULL COMMENT '库存数量',
  `unit` int(11) NOT NULL COMMENT '数量/单位',
  `qty_in_demand` int(11) NOT NULL COMMENT '需求量',
  PRIMARY KEY (`stock_info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `price`;
CREATE TABLE `price` (
  `price_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '价格id',
  `unit_price` double(11,2) NOT NULL COMMENT '单价',
  `commission_rate` double(4,2) NOT NULL COMMENT '佣金率',
  PRIMARY KEY (`price_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '产品id',
  `product_name` varchar(30) NOT NULL COMMENT '产品名称',
  `part_number` int(11) NOT NULL COMMENT '零件号',
  `sale_start_date` datetime NOT NULL COMMENT '销售开始日期',
  `product_category` varchar(30) NOT NULL COMMENT '产品种类',
  `active` varchar(2) NOT NULL COMMENT '产品是否在售',
  `sale_end_date` datetime NOT NULL COMMENT '销售结束日期',
  `product_number` int(11) NOT NULL COMMENT '产品编号',
  `website` varchar(30) NOT NULL COMMENT '网站',
  `ventor_name` varchar(30) NOT NULL COMMENT '供应商',
  `ventor_partno` int(11) NOT NULL COMMENT '供应商no',
  `create_time` datetime NOT NULL COMMENT '创造时间',
  `modified_time` datetime NOT NULL COMMENT '修改时间',
  `manufacturer` varchar(30) NOT NULL COMMENT '生产厂家',
  `description` varchar(150) NOT NULL COMMENT '描述',
  `update_info` varchar(30) NOT NULL COMMENT '更改',
  `price_id` int(11) NOT NULL COMMENT '价格id',
  `stock_info_id` int(11) NOT NULL COMMENT '库存id',
  PRIMARY KEY (`product_id`),
  FOREIGN KEY (`price_id`) REFERENCES `price` (`price_id`),
  FOREIGN KEY (`stock_info_id`) REFERENCES `stock_info` (`stock_info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization` (
  `organization_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '组织id',
  `organization_name` varchar(30) NOT NULL COMMENT '组织名称',
  `billing_city` varchar(30) NOT NULL COMMENT '城市',
  `website` varchar(30) NOT NULL COMMENT '网站',
  `primary_phone` int(20) NOT NULL COMMENT '电话',
  `assign_to` varchar(30) NOT NULL COMMENT '分配给',
  `update_info` varchar(30) NOT NULL COMMENT '更新',
  `is_from_lead` varchar(2) NOT NULL COMMENT '是否是来自于线索',
  `owner_ship` varchar(30) NOT NULL COMMENT '所有权',
  `annual_revenue` double(11,2) NOT NULL COMMENT '年收入',
  `member_of` varchar(30) NOT NULL COMMENT '成员',
  `employee` varchar(30) NOT NULL COMMENT '雇员',
  `industry` varchar(30) NOT NULL COMMENT '行业',
  `modified_time` datetime NOT NULL COMMENT '修改时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `address_id` int(11) NOT NULL COMMENT '地址id',
  `description` varchar(150) NOT NULL COMMENT '描述',
  PRIMARY KEY (`organization_id`),
  FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `leads`;
CREATE TABLE `leads` (
  `lead_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '线索id',
  `first_name` varchar(30) NOT NULL COMMENT '名字',
  `last_name` varchar(30) NOT NULL COMMENT '姓',
  `company` varchar(30) NOT NULL COMMENT '公司',
  `primary_phone` int(20) NOT NULL COMMENT '常用电话',
  `website` varchar(30) NOT NULL COMMENT '网站',
  `primary_email` varchar(30) NOT NULL COMMENT '常用邮箱',
  `assign_to` int(11) NOT NULL COMMENT '分配给',
  `annual_revenue` double(11,2) NOT NULL COMMENT '年收入',
  `phone` int(20) DEFAULT NULL COMMENT '电话',
  `email` varchar(30) NOT NULL COMMENT '邮箱',
  `update_info` varchar(30) NOT NULL COMMENT '更改',
  `description` varchar(150) NOT NULL COMMENT '描述',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modified_time` datetime NOT NULL COMMENT '修改时间',
  `product_id` int(11) NOT NULL COMMENT '产品id',
  `organization_id` int(11) NOT NULL COMMENT '组织id',
  `address_id` int(11) NOT NULL COMMENT '地址id',
  PRIMARY KEY (`lead_id`),
  FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  FOREIGN KEY (`organization_id`) REFERENCES `organization` (`organization_id`),
  FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `contact`;
CREATE TABLE `contact` (
  `contact_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '联系人id', 
  `first_name` varchar(30) NOT NULL COMMENT '名字',
  `last_name` varchar(30) NOT NULL COMMENT '姓',
  `title` varchar(30) NOT NULL COMMENT '称呼（头衔）',
  `primary_email` varchar(30) NOT NULL COMMENT '邮件',
  `office_phone` int(20) NOT NULL COMMENT '办公室电话',
  `assign_to` int(11) NOT NULL COMMENT '分配给',
  `is_from_lead` varchar(2) NOT NULL COMMENT '是否是来自于线索',
  `home_phone` int(20) NOT NULL COMMENT '家的电话',
  `update_info` varchar(30) NOT NULL COMMENT '更改',
  `lead_state` int(2) NOT NULL COMMENT '线索状态',
  `industry` varchar(30) NOT NULL COMMENT '行业',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modified_time` datetime NOT NULL COMMENT '改修时间',
  `day_of_birth` datetime NOT NULL COMMENT '出生时间',
  `department` varchar(30) NOT NULL COMMENT '部门',
  `assistant` varchar(30) NOT NULL COMMENT '助理',
  `assistant_phone` int(20) NOT NULL COMMENT '助理电话',
  `profile_picture` varchar(100) NOT NULL COMMENT'个人资料图片',
  `description` varchar(150) NOT NULL COMMENT '描述',
  `organization_id` int(11) NOT NULL COMMENT '组织id',
  `address_id` int(11) NOT NULL COMMENT '地址id',
  PRIMARY KEY (`contact_id`),
  FOREIGN KEY (`organization_id`) REFERENCES `organization` (`organization_id`),
  FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `user_name` varchar(30) NOT NULL COMMENT '用户姓名',
  `password` varchar(30) NOT NULL COMMENT '密码',
  `phone` int(20) NOT NULL COMMENT '电话',
  `email` varchar(30) NOT NULL COMMENT '邮件',
  `address_id` int(11) NOT NULL COMMENT '地址id',
  `title` varchar(30) NOT NULL COMMENT '称呼（头衔）',
  `lead_id` int(11) NOT NULL COMMENT '线索id',
  `contact_id` int(11) NOT NULL COMMENT '联系人id',
  PRIMARY KEY (`user_id`),
  FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`),
  FOREIGN KEY (`contact_id`) REFERENCES `contact` (`contact_id`),
  FOREIGN KEY (`lead_id`) REFERENCES `leads` (`lead_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `opportunity`;
CREATE TABLE `opportunity` (
  `opport_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '机会id',
  `opport_name` varchar(30) NOT NULL COMMENT '机会名字',
  `prob` double(4,2) NOT NULL COMMENT '概率',
  `forcast_amount` double(11,2) NOT NULL COMMENT '预测金额',
  `is_from_lead` varchar(2) NOT NULL COMMENT '是否是来自于线索',
  `assign_to` int(11) NOT NULL COMMENT '分配给',
  `organization_id` int(11) NOT NULL COMMENT '组织id',
  `sales_stage` varchar(30) NOT NULL COMMENT '销售阶段',
  `lead_source` varchar(30) NOT NULL COMMENT '线索来源',
  `update_info` varchar(30) NOT NULL COMMENT '更改',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modified_time` datetime NOT NULL COMMENT '修改时间',
  `opport_type` varchar(30) NOT NULL COMMENT '类型',
  `expected_close_date` datetime NOT NULL COMMENT '预期结束时间',
  `description` varchar(150) NOT NULL COMMENT '描述',
  `contact_id` int(11) NOT NULL COMMENT '联系人id',
  PRIMARY KEY (`opport_id`),
  FOREIGN KEY (`contact_id`) REFERENCES `contact` (`contact_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `ticket`;
CREATE TABLE `ticket` (
  `ticket_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '身份证id',
  `title` varchar(30) NOT NULL COMMENT '称号',
  `status` int(11) NOT NULL COMMENT '状态',
  `priority` int(11) NOT NULL COMMENT '优先权等级',
  `assign_to` int(11) NOT NULL COMMENT '分配给',
  `hour_num` varchar(5) NOT NULL COMMENT '小时',
  `category` varchar(30) NOT NULL COMMENT '种类',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modified_time` datetime NOT NULL COMMENT '修改时间',
  `severity` int(11) NOT NULL COMMENT '严重',
  `days` int(11) NOT NULL COMMENT '天数',
  `description` varchar(150) NOT NULL COMMENT '描述',
  `update_info` varchar(30) NOT NULL COMMENT '更改',
  `organization_id` int(11) NOT NULL COMMENT '组织id',
  `product_id` int(11) NOT NULL COMMENT '产品id',
  PRIMARY KEY (`ticket_id`),
  FOREIGN KEY (`organization_id`) REFERENCES `organization` (`organization_id`),
  FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `campaign`;
CREATE TABLE `campaign` (
  `campaign_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '活动id',
  `campaign_name` varchar(30) NOT NULL COMMENT '活动名字',
  `campaign_type` varchar(30) NOT NULL COMMENT '活动类型',
  `campaign_status` int(11) NOT NULL COMMENT '活动状态',
  `expected_revenue` double(11,2) NOT NULL COMMENT '预期收入',
  `expected_close_date` datetime NOT NULL COMMENT '预期结束时间',
  `assign_to` int(11) NOT NULL COMMENT '分配给',
  `target_size` int(5) NOT NULL COMMENT '目标大小',
  `num_sent` int(5) NOT NULL COMMENT '发送数量',
  `target_audience` varchar(30) NOT NULL COMMENT '目标听众',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modified_time` datetime NOT NULL COMMENT '修改时间',
  `sponsor` int(11) NOT NULL COMMENT '赞助',
  `description` varchar(30) NOT NULL COMMENT '联系人',
  `update_info` varchar(11) NOT NULL COMMENT '联系电话',
  `product_id` int(11) NOT NULL COMMENT '产品id',
  `exp_actual_id` int(11) NOT NULL COMMENT '预期和实际id',
  `opport_id` int(11) NOT NULL COMMENT '机会id',
  PRIMARY KEY (`campaign_id`),
  FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  FOREIGN KEY (`exp_actual_id`) REFERENCES `exp_actual` (`exp_actual_id`),
  FOREIGN KEY (`opport_id`) REFERENCES `opportunity` (`opport_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;