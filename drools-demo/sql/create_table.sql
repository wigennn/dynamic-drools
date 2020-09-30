DROP TABLE IF EXISTS `invoice_rule`;
CREATE TABLE `invoice_rule` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键规则id',
  `invoice_type` varchar(30) NOT NULL COMMENT '票种名称',
  `rule_detail` LONGTEXT NOT NULL COMMENT '规则详情',
  `is_deleted` tinyint(2) DEFAULT 0 COMMENT '是否删除 0-否 1-是',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='发票校验规则表';

DROP TABLE IF EXISTS `invoice_rule_detail`;
CREATE TABLE `invoice_rule_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键规则id',
  `invoice_type` varchar(30) NOT NULL COMMENT '票种名称',
  `invoice_field` varchar(50) NOT NULL COMMENT '票据字段',
  `compate_type` varchar(10) NOT NULL COMMENT '比较类型',
  `compare_val` varchar(50) DEFAULT NULL COMMENT '比较值',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_unique_invoice_field` (`invoice_type`, `invoice_field`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='发票校验规则详情表';