# 基础镜像依赖
FROM openjdk:17-slim
# 安装命令支持
RUN apt-get update \
    && apt-get install procps -y
# 暴露端口
EXPOSE 80
# 先将文件出复制目录
COPY authserver.jar /home/authserver/bin/
#设置工作目录
WORKDIR /home/authserver/bin/
# 解压文件 并切换工作目录
RUN jar -xvf /home/authserver/bin/authserver.jar \
    && rm /home/authserver/bin/authserver.jar
#定义时区参数
ENV TZ=Asia/Shanghai
#设置时区
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime \
    && echo '$TZ' > /etc/timezone
# 启动Springboot应用
ENTRYPOINT ["java", "-cp", "/home/authserver/bin","org.springframework.boot.loader.JarLauncher","--spring.profiles.active=prod"]
