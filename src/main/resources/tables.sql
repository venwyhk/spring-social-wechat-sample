CREATE TABLE `m_user` (
  `id` int PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT '编号',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '最后修改时间',
  `email` varchar(128) NOT NULL COMMENT '邮箱',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `name` varchar(32) NOT NULL COMMENT '名称',
  `role` varchar(16) NOT NULL COMMENT '角色 (ADMIN:超级管理员,A_ADMIN:A类商户主账号,A_USER:A类商户业务员,B_ADMIN:B类商户主账号,B_USER:A类商户业务员)'
) ENGINE=InnoDB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8;
ALTER TABLE `m_user` ADD INDEX index_name (`username`);