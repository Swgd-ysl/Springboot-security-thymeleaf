/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : huashuohair

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2022-02-09 14:07:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_app_department
-- ----------------------------
DROP TABLE IF EXISTS `tb_app_department`;
CREATE TABLE `tb_app_department` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `department_name` varchar(128) DEFAULT NULL COMMENT '部门名称',
  `parent_id` int(8) DEFAULT NULL COMMENT '父id',
  `parent_name` varchar(128) DEFAULT NULL COMMENT '父名称',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `sort` int(3) DEFAULT '0' COMMENT '排序',
  `create_time` varchar(128) DEFAULT NULL COMMENT '创建时间',
  `create_user_id` varchar(128) DEFAULT NULL COMMENT '创建人',
  `last_update_time` varchar(128) DEFAULT NULL COMMENT '最后更新时间',
  `last_update_user_id` varchar(128) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Records of tb_app_department
-- ----------------------------

-- ----------------------------
-- Table structure for tb_app_permission
-- ----------------------------
DROP TABLE IF EXISTS `tb_app_permission`;
CREATE TABLE `tb_app_permission` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `permission_name` varchar(128) DEFAULT NULL COMMENT '名称',
  `url` varchar(128) DEFAULT NULL COMMENT '权限url',
  `type` int(2) DEFAULT NULL COMMENT '1,目录 2,菜单 3,按钮',
  `code` varchar(128) DEFAULT NULL COMMENT '权限标识',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `parent_id` int(8) DEFAULT NULL COMMENT '父菜单id',
  `parent_name` varchar(128) DEFAULT NULL COMMENT '父菜单名称',
  `icon` varchar(128) DEFAULT NULL COMMENT '图标',
  `sort` int(4) DEFAULT '0' COMMENT '排序',
  `status` int(4) DEFAULT '1' COMMENT '是否有效:1,有效 0,无效',
  `create_time` varchar(128) DEFAULT NULL COMMENT '创建时间',
  `create_user_id` varchar(128) DEFAULT NULL COMMENT '创建人',
  `last_update_time` varchar(128) DEFAULT NULL COMMENT '最后更新时间',
  `last_update_user_id` varchar(128) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of tb_app_permission
-- ----------------------------
INSERT INTO `tb_app_permission` VALUES ('1', '用户列表', null, '3', 'listUser', null, null, null, null, null, '0', '1', null, null, null, null);
INSERT INTO `tb_app_permission` VALUES ('2', '新增用户', null, '3', 'addUser', null, null, null, null, null, '0', '1', null, null, null, null);
INSERT INTO `tb_app_permission` VALUES ('3', '权限列表', null, '3', 'listPermission', null, null, null, null, null, '0', '1', null, null, null, null);
INSERT INTO `tb_app_permission` VALUES ('4', '新增权限', null, '3', 'addPermission', null, null, null, null, null, '0', '1', null, null, null, null);
INSERT INTO `tb_app_permission` VALUES ('5', '角色列表', null, '3', 'listRole', null, null, null, null, null, '0', '1', null, null, null, null);
INSERT INTO `tb_app_permission` VALUES ('6', '新增角色', null, '3', 'addRole', null, null, null, null, null, '0', '1', null, null, null, null);
INSERT INTO `tb_app_permission` VALUES ('7', '系统管理', null, '1', 'systemManager', '对系统相关设置', '非系统管理员禁止此操作', null, null, null, '0', '1', null, null, null, null);
INSERT INTO `tb_app_permission` VALUES ('8', '用户管理', '/User/ToUserPage', '2', 'listUser', '用户管理页面', null, '7', '系统管理', null, '0', '1', null, null, null, null);
INSERT INTO `tb_app_permission` VALUES ('9', '角色管理', '/Role/ToRolePage', '2', 'listRole', '角色管理页面', null, '7', '系统管理', null, '1', '1', null, null, null, null);
INSERT INTO `tb_app_permission` VALUES ('10', '权限管理', '/Permission/ToPermissionPage', '2', 'listPermission', '权限管理页面', null, '7', '系统管理', null, '2', '1', null, null, null, null);
INSERT INTO `tb_app_permission` VALUES ('11', '部门管理', '/Department/ToDepartmentPage', '2', 'listDepartment', '部门管理页面', null, '7', '系统管理', null, '3', '1', null, null, null, null);

-- ----------------------------
-- Table structure for tb_app_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_app_role`;
CREATE TABLE `tb_app_role` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_name` varchar(128) DEFAULT NULL COMMENT '角色名称',
  `code` varchar(255) DEFAULT NULL COMMENT '角色标识',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` varchar(128) DEFAULT NULL COMMENT '创建时间',
  `create_user_id` varchar(128) DEFAULT NULL COMMENT '创建人',
  `last_update_time` varchar(128) DEFAULT NULL COMMENT '最后更新时间',
  `last_update_user_id` varchar(128) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of tb_app_role
-- ----------------------------
INSERT INTO `tb_app_role` VALUES ('1', '管理员', 'AdminManager', null, null, null, null, null, null);
INSERT INTO `tb_app_role` VALUES ('2', '普通用户', 'CommonUser', null, null, null, null, null, null);
INSERT INTO `tb_app_role` VALUES ('3', '测试', 'Test', '测试springdoc openApi接口', 'test', '2021-10-26 11:30:49', null, null, null);

-- ----------------------------
-- Table structure for tb_app_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `tb_app_role_permission`;
CREATE TABLE `tb_app_role_permission` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` int(8) DEFAULT NULL COMMENT '角色id',
  `permission_id` int(8) DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='角色权限表';

-- ----------------------------
-- Records of tb_app_role_permission
-- ----------------------------
INSERT INTO `tb_app_role_permission` VALUES ('1', '1', '1');
INSERT INTO `tb_app_role_permission` VALUES ('2', '1', '2');
INSERT INTO `tb_app_role_permission` VALUES ('3', '1', '3');
INSERT INTO `tb_app_role_permission` VALUES ('4', '1', '4');
INSERT INTO `tb_app_role_permission` VALUES ('5', '1', '5');
INSERT INTO `tb_app_role_permission` VALUES ('6', '1', '6');
INSERT INTO `tb_app_role_permission` VALUES ('7', '2', '1');
INSERT INTO `tb_app_role_permission` VALUES ('8', '2', '2');

-- ----------------------------
-- Table structure for tb_app_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_app_user`;
CREATE TABLE `tb_app_user` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account` varchar(128) DEFAULT NULL COMMENT '账号',
  `password` varchar(128) DEFAULT NULL COMMENT '加密密码',
  `orginal_password` varchar(128) DEFAULT NULL COMMENT '真实密码',
  `salt` varchar(128) DEFAULT NULL COMMENT '加密盐值',
  `real_name` varchar(128) DEFAULT NULL COMMENT '真实姓名',
  `sex` varchar(128) DEFAULT NULL COMMENT '性别',
  `telephone` varchar(128) DEFAULT NULL COMMENT '手机号',
  `email` varchar(128) DEFAULT NULL COMMENT '邮箱',
  `birthday` varchar(128) DEFAULT NULL COMMENT '出生日期',
  `address` varchar(128) DEFAULT NULL COMMENT '住址',
  `department_id` int(8) DEFAULT NULL COMMENT '部门id',
  `depaetment_name` varchar(128) DEFAULT NULL COMMENT '部门名称',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `status` int(4) DEFAULT '1' COMMENT '是否有效:1,有效 0,无效',
  `create_time` varchar(128) DEFAULT NULL COMMENT '创建时间',
  `create_user_id` varchar(128) DEFAULT NULL COMMENT '创建人',
  `last_update_time` varchar(128) DEFAULT NULL COMMENT '最后更新时间',
  `last_update_user_id` varchar(128) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of tb_app_user
-- ----------------------------
INSERT INTO `tb_app_user` VALUES ('1', 'zhangsan', '123456', '123456', 'zhangsan', '张三', null, null, null, null, null, null, null, null, '1', null, null, null, null);
INSERT INTO `tb_app_user` VALUES ('2', 'lisi', '123456', '123456', 'lisi', '李四', null, null, null, null, null, null, null, null, '1', null, null, null, null);

-- ----------------------------
-- Table structure for tb_app_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_app_user_role`;
CREATE TABLE `tb_app_user_role` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(8) DEFAULT NULL COMMENT '账户id',
  `role_id` int(8) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户角色表';

-- ----------------------------
-- Records of tb_app_user_role
-- ----------------------------
INSERT INTO `tb_app_user_role` VALUES ('1', '1', '1');
INSERT INTO `tb_app_user_role` VALUES ('2', '2', '2');
INSERT INTO `tb_app_user_role` VALUES ('3', '1', '2');
