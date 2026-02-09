CREATE  DATABASE QStock;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `stock_block_rt_info`;
CREATE TABLE `stock_block_rt_info`  (
                                        `id` bigint(20) NOT NULL COMMENT '板块主键ID（业务无关）',
                                        `label` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '表示，如：new_blhy-玻璃行业',
                                        `block_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '板块名称',
                                        `company_num` int(11) NULL DEFAULT NULL COMMENT '公司数量',
                                        `avg_price` decimal(10, 3) NULL DEFAULT NULL COMMENT '平均价格',
                                        `updown_rate` decimal(10, 3) NULL DEFAULT NULL COMMENT '涨跌幅',
                                        `trade_amount` bigint(20) NULL DEFAULT NULL COMMENT '交易量',
                                        `trade_volume` decimal(18, 3) NULL DEFAULT NULL COMMENT '交易金额',
                                        `cur_time` datetime(0) NULL DEFAULT NULL COMMENT '当前日期（精确到秒）',
                                        PRIMARY KEY (`id`) USING BTREE,
                                        UNIQUE INDEX `unique_name_time`(`cur_time`, `label`) USING BTREE COMMENT '板块表示与时间组成唯一索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '股票板块详情信息表' ROW_FORMAT = COMPACT;

DROP TABLE IF EXISTS `stock_business`;
CREATE TABLE `stock_business`  (
                                   `stock_code` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT ' 股票编码',
                                   `stock_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '股票名称',
                                   `block_label` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '股票所属行业|板块标识',
                                   `block_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '行业板块名称',
                                   `business` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主营业务',
                                   `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
                                   PRIMARY KEY (`stock_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '主营业务表' ROW_FORMAT = COMPACT;

DROP TABLE IF EXISTS `stock_market_index_info`;
CREATE TABLE `stock_market_index_info`  (
                                            `id` bigint(20) NOT NULL COMMENT '主键字段（无业务意义）',
                                            `market_code` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '大盘编码',
                                            `market_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '指数名称',
                                            `pre_close_point` decimal(18, 2) NULL DEFAULT NULL COMMENT '前收盘点数',
                                            `open_point` decimal(18, 2) NULL DEFAULT NULL COMMENT '开盘点数',
                                            `cur_point` decimal(18, 2) NULL DEFAULT NULL COMMENT '当前点数',
                                            `min_point` decimal(18, 2) NULL DEFAULT NULL COMMENT '最低点数',
                                            `max_point` decimal(18, 2) NULL DEFAULT NULL COMMENT '最高点数',
                                            `trade_amount` bigint(20) NULL DEFAULT NULL COMMENT '成交量(手)',
                                            `trade_volume` decimal(18, 2) NULL DEFAULT NULL COMMENT '成交金额（元）',
                                            `cur_time` datetime(0) NOT NULL COMMENT '当前时间',
                                            PRIMARY KEY (`id`) USING BTREE,
                                            UNIQUE INDEX `unique_id_time`(`cur_time`, `market_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '国内大盘数据详情表' ROW_FORMAT = COMPACT;

DROP TABLE IF EXISTS `stock_outer_market_index_info`;
CREATE TABLE `stock_outer_market_index_info`  (
                                                  `id` bigint(20) NOT NULL COMMENT '主键ID',
                                                  `market_code` char(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '大盘编码',
                                                  `market_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '大盘名称',
                                                  `cur_point` decimal(10, 2) NULL DEFAULT NULL COMMENT '大盘当前点',
                                                  `updown` decimal(10, 2) NULL DEFAULT NULL COMMENT '大盘涨跌值',
                                                  `rose` decimal(10, 2) NULL DEFAULT NULL COMMENT '大盘涨幅',
                                                  `cur_time` datetime(0) NOT NULL COMMENT '当前时间',
                                                  PRIMARY KEY (`id`) USING BTREE,
                                                  UNIQUE INDEX `unique_mcode_date`(`cur_time`, `market_code`) USING BTREE COMMENT '大盘id与日期组成唯一索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '外盘详情信息表' ROW_FORMAT = COMPACT;

DROP TABLE IF EXISTS `stock_rt_info`;
CREATE TABLE `stock_rt_info`  (
                                  `id` bigint(20) NOT NULL COMMENT '主键字段（无业务意义）',
                                  `stock_code` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '股票代码',
                                  `stock_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '股票名称',
                                  `pre_close_price` decimal(8, 2) NULL DEFAULT NULL COMMENT '前收盘价| 昨日收盘价',
                                  `open_price` decimal(8, 2) NULL DEFAULT NULL COMMENT '开盘价',
                                  `cur_price` decimal(8, 2) NOT NULL COMMENT '当前价格',
                                  `min_price` decimal(8, 2) NULL DEFAULT NULL COMMENT '今日最低价',
                                  `max_price` decimal(8, 2) NULL DEFAULT NULL COMMENT '今日最高价',
                                  `trade_amount` bigint(20) NULL DEFAULT NULL COMMENT '成交量',
                                  `trade_volume` decimal(18, 2) NULL DEFAULT NULL COMMENT '成交金额',
                                  `cur_time` datetime(0) NOT NULL COMMENT '当前时间',
                                  PRIMARY KEY (`id`) USING BTREE,
                                  UNIQUE INDEX `cur_time_idx`(`cur_time`, `stock_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '个股详情信息表' ROW_FORMAT = COMPACT;

DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
                            `id` bigint(20) NOT NULL COMMENT '主键',
                            `user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
                            `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
                            `operation` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户操作：DELETE ADD GET UPDATE',
                            `time` int(11) NULL DEFAULT NULL COMMENT '响应时间,单位毫秒',
                            `method` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求方法（控制层方法全限定名）',
                            `params` varchar(5000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求参数',
                            `ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'IP地址',
                            `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
                            PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统日志' ROW_FORMAT = COMPACT;

DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
                                   `id` bigint(20) NOT NULL COMMENT '主键',
                                   `code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单权限编码(前端按钮权限标识)',
                                   `title` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单权限名称',
                                   `icon` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '菜单图标(侧边导航栏图标)',
                                   `perms` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'SpringSecurity授权标识(如：sys:user:add)',
                                   `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '访问地址URL',
                                   `method` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源请求类型',
                                   `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT 'name与前端vue路由name约定一致',
                                   `pid` bigint(20) NULL DEFAULT 0 COMMENT '父级菜单权限id，pid等于0 为顶层权限',
                                   `order_num` int(11) NULL DEFAULT 0 COMMENT '排序',
                                   `type` tinyint(4) UNSIGNED ZEROFILL NULL DEFAULT 0001 COMMENT '菜单权限类型(1:目录;2:菜单;3:按钮)',
                                   `status` tinyint(4) NULL DEFAULT 1 COMMENT '状态1:正常 0：禁用',
                                   `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
                                   `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
                                   `deleted` tinyint(4) NULL DEFAULT 1 COMMENT '是否删除(1未删除；0已删除)',
                                   PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限表（菜单）' ROW_FORMAT = COMPACT;

DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
                             `id` bigint(20) NOT NULL COMMENT '主键',
                             `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
                             `description` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
                             `status` tinyint(4) NULL DEFAULT 1 COMMENT '状态(1:正常0:弃用)',
                             `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
                             `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
                             `deleted` tinyint(4) NULL DEFAULT 1 COMMENT '是否删除(1未删除；0已删除)',
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = COMPACT;

DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission`  (
                                        `id` bigint(20) NOT NULL COMMENT '主键',
                                        `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色id',
                                        `permission_id` bigint(20) NULL DEFAULT NULL COMMENT '菜单权限id',
                                        `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
                                        PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色权限表' ROW_FORMAT = COMPACT;

DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
                             `id` bigint(20) NOT NULL COMMENT '用户id',
                             `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账户',
                             `password` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码密文',
                             `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
                             `real_name` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实名称',
                             `nick_name` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
                             `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱(唯一)',
                             `status` tinyint(4) NULL DEFAULT 1 COMMENT '账户状态(1.正常 2.锁定 )',
                             `sex` tinyint(4) NULL DEFAULT 1 COMMENT '性别(1.男 2.女)',
                             `deleted` tinyint(4) NULL DEFAULT 1 COMMENT '是否删除(1未删除；0已删除)',
                             `create_id` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
                             `update_id` bigint(20) NULL DEFAULT NULL COMMENT '更新人',
                             `create_where` tinyint(4) NULL DEFAULT 1 COMMENT '创建来源(1.web 2.android 3.ios )',
                             `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
                             `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
                             PRIMARY KEY (`id`) USING BTREE,
                             UNIQUE INDEX `unique_username`(`username`) USING BTREE COMMENT '用户名唯一'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = COMPACT;

DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
                                  `id` bigint(20) NOT NULL COMMENT '主键',
                                  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
                                  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色id',
                                  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
                                  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色表' ROW_FORMAT = COMPACT;
