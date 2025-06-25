#!/bin/bash

# 设置变量
MYSQL_ROOT_PASSWORD="121520"
MYSQL_DATABASE="house"
CONTAINER_NAME="house-mysql"
SQL_FILE="./doc/house.sql"

echo "开始创建MySQL Docker容器..."

# 检查容器是否已存在，如果存在则删除
if [ "$(docker ps -a -q -f name=$CONTAINER_NAME)" ]; then
    echo "容器 $CONTAINER_NAME 已存在，正在删除..."
    docker stop $CONTAINER_NAME
    docker rm $CONTAINER_NAME
fi

# 拉取MySQL镜像
echo "拉取MySQL镜像..."
docker pull mysql:8.0

# 创建MySQL容器
echo "创建并启动MySQL容器..."
docker run --name $CONTAINER_NAME \
    -p 3307:3306 \
    -e MYSQL_ROOT_PASSWORD=$MYSQL_ROOT_PASSWORD \
    -e MYSQL_DATABASE=$MYSQL_DATABASE \
    -e MYSQL_ROOT_HOST='%' \
    -d mysql:8.0 \
    --character-set-server=utf8mb4 \
    --collation-server=utf8mb4_unicode_ci \
    --default-authentication-plugin=mysql_native_password

# 等待MySQL启动
echo "等待MySQL启动..."
sleep 20

# 检查SQL文件是否存在
if [ ! -f "$SQL_FILE" ]; then
    echo "错误: SQL文件 $SQL_FILE 不存在!"
    exit 1
fi

# 将SQL文件复制到容器中
echo "将SQL文件复制到容器中..."
docker cp $SQL_FILE $CONTAINER_NAME:/tmp/init.sql

# 执行SQL文件初始化表结构
echo "执行SQL文件初始化表结构..."
docker exec -i $CONTAINER_NAME mysql -uroot -p$MYSQL_ROOT_PASSWORD $MYSQL_DATABASE -e "source /tmp/init.sql"

# 验证数据库是否成功初始化
echo "验证数据库是否成功初始化..."
docker exec -i $CONTAINER_NAME mysql -uroot -p$MYSQL_ROOT_PASSWORD -e "USE $MYSQL_DATABASE; SHOW TABLES;"

echo "MySQL容器已成功启动，数据库已初始化"
echo "容器名称: $CONTAINER_NAME"
echo "数据库名称: $MYSQL_DATABASE"
echo "端口映射: 3307:3306"
echo "可以通过以下方式连接数据库:"
echo "  - 主机: localhost 或 本机IP"
echo "  - 端口: 3307"
echo "  - 用户名: root"
echo "  - 密码: $MYSQL_ROOT_PASSWORD"
echo "  - 数据库: $MYSQL_DATABASE"