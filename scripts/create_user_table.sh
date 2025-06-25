#!/bin/bash

# 设置MySQL连接参数
MYSQL_HOST="10.185.9.108"
MYSQL_PORT="3307"
MYSQL_USER="root"
MYSQL_PASSWORD="121520"
MYSQL_DATABASE="house"

# 创建house_user表的SQL语句
cat > /tmp/create_user_table.sql << 'EOF'
-- Table structure for `house_user`
DROP TABLE IF EXISTS `house_user`;
CREATE TABLE `house_user` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(15) DEFAULT NULL,
  `user_password` varchar(15) DEFAULT NULL,
  `user_emial` varchar(20) DEFAULT NULL,
  `user_realname` varchar(20) DEFAULT NULL,
  `user_address` varchar(20) DEFAULT NULL,
  `user_zipcode` varchar(20) DEFAULT NULL,
  `user_type` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Records of house_user
INSERT INTO `house_user` VALUES ('1', 'test', '131313', '785193391@qq.com', '', '', '', 'normal');
INSERT INTO `house_user` VALUES ('2', 'aheizi', '121212', '785193391@qq.com', '黄阳全', 'longquan', '443000', 'normal');
INSERT INTO `house_user` VALUES ('3', 'aheizi', '121212', null, null, null, null, 'manager');
INSERT INTO `house_user` VALUES ('4', 'admin', 'admin', null, null, null, null, 'admin');
INSERT INTO `house_user` VALUES ('5', 'huang', '121212', null, null, null, null, 'manager');
INSERT INTO `house_user` VALUES ('6', 'aheizi1', '121212', '785193391@qq.com', '', '', '', 'normal');
INSERT INTO `house_user` VALUES ('7', 'hu', '121212', null, null, null, null, 'manager');
EOF

# 执行SQL文件
echo "正在创建house_user表..."
mysql -h $MYSQL_HOST -P $MYSQL_PORT -u $MYSQL_USER -p$MYSQL_PASSWORD $MYSQL_DATABASE < /tmp/create_user_table.sql

# 验证表是否创建成功
echo "验证表是否创建成功..."
mysql -h $MYSQL_HOST -P $MYSQL_PORT -u $MYSQL_USER -p$MYSQL_PASSWORD -e "USE $MYSQL_DATABASE; SHOW TABLES;"

echo "house_user表创建完成"