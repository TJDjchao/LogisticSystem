# LogisticSystem
Web Service and SOA course project
## 环境
- 若无法运行，需要将 Oracle JDBC Driver 手动添加到本地 Maven 仓库 [下载页](https://www.oracle.com/technetwork/database/features/jdbc/default-2280470.html)，下载`ojdbc7.jar`，之后在下载目录以管理员身份打开命令行执行
```
mvn install:install-file -Dfile=ojdbc7.jar  -DgroupId=com.oracle -DartifactId=ojdbc7 -Dversion=12.1.0.2 -Dpackaging=jar
```
