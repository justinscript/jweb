# Spark-Framework Java Web项目基础框架

## 搭建初衷

1.尽量不使用比较偏的技术框架和代码库;
2.使用一些易于快速开发和迭代的技术;
3.必须易于扩展,分层清晰;代码冗余度低,高内聚低耦合是设计初衷;
4.必须易于上手,快速融于开发,更多的突出业务逻辑部分;
5.接口与实现分离是设计原则,尽量做到实现都是可以替换的;

## 框架简介

Spark-Framework是基于多个优秀的开源项目，高度整合封装而成的高效，高性能，高安全性的**开源**Java EE快速开发平台。

Spark-Framework本身是以Spring Framework为核心容器，Spring MVC为模型视图控制器，MyBatis为数据访问层，
Apache Shiro为权限授权层，Ehcahe对常用数据进行缓存。

采用分层设计、双重验证、提交数据安全编码、密码加密、访问验证、数据权限验证。
使用Maven做项目管理，提高项目的易开发性、扩展性。
前端界面风格初步引入了结构简单、性能优良、容易上手的Twitter Bootstrap页面展示框架。

Spark-Framework 提供了常用工具的封装，包括日志工具、缓存工具、服务器端验证、数据字典、当前组登录用户数据
（用户、角色、权限）以及其它常用小工具等。
如果你使用了Spark-Framework基础框架，就可以很高效的快速开发出，优秀的互联网产品。

## 为何选择Spark-Framework

1. 使用 [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0) 协议，源代码闭源。
2. 使用目前主流的Java EE开发框架，简单易学，学习成本低。
3. 数据库无限制，目前支持MySql、Oracle，可扩充SQL Server、PostgreSQL、H2、MongoDB等。
4. 模块化设计，层次结构清晰。
5. 操作权限控制精密细致，对所有管理链接都进行权限验证，可控制到按钮。
6. 数据权限控制精密细致，对指定数据集权限进行过滤，七种数据权限可供选择。
7. 提供常用工具类封装，日志、缓存、验证、字典等，常用标签（taglib），获取当前字典等数据。

## 技术选型

1、后端

* 核心框架：Spring Framework 4.1.3
* 安全框架：Apache Shiro 1.2
* 视图框架：Spring MVC 4.1.3
* 服务端验证：Hibernate Validator 5.1
* 任务调度：Quartz
* 持久层框架：MyBatis 3.2
* 数据库连接池：Alibaba Druid 1.0
* 缓存框架：Ehcache 2.6、Redis
* 日志管理：SLF4J 1.7、Log4j
* 工具类：Google Guava、Apache Commons、Jackson 2.4、Xstream 1.4、Dozer 5.3、POI 3.9 
* 页面渲染：Velocity
* SOA框架：Alibaba Dubbo、Apache CXF
* 消息队列：ActiveMQ 5.7.0、Apache Kafka
* Web容器：Tomcat 7、Jetty 7、Jboss
* 通信框架：Apache Mina、Netty
* 搜索框架：Apache Lucene

2、前端

* JS框架：jQuery 1.9。
* CSS框架：Twitter Bootstrap 2.3.1。
* 客户端验证：JQuery Validation Plugin 1.11。
* 富文本：
* 文件管理：
* 动态页签：
* 数据表格：jqGrid
* 对话框：
* 下拉选择框：
* 树结构控件：
* 日期控件： 

3、平台

* 服务器中间件：在Java EE 5规范（Servlet 2.5、JSP 2.1）下开发，支持应用服务器中间件
有Tomcat 7、Jetty 7、Jboss 7、WebLogic 10、WebSphere 8。
* 数据库支持：目前仅提供MySql和Oracle数据库的支持，但不限于数据库，平台留有其它数据库支持接口，
可方便更改为其它数据库，如：SqlServer 2008、PostgreSQL、MongoDB等
* 开发环境：Java EE、JDK 7+
* 开发工具：Eclipse(自主选择)、VIM
* 代码管理：Maven、Svn(Git)
* 团队协作：Jira、Tower
* 文档管理：Confluence
* 持续集成：Jenkins

3、前后端分离

前端JS,CSS,HTML代码和IMG图片,FRONT字体不放在J2EE项目代码中,单独在svn代码库中新建分支去管理;J2EE项目引用静态文件时是在svn中加个钩子;
前端开发人员本地机器不需要拉下J2EE代码,静态文件引用指向本地电脑,修改Hosts即可;动态内容连接局域网内部测试服务器,或者远程测试服务器;
局域网内部测试服务器安装并开启SMB服务,前端可直接修改服务器上Velocity模板,并提交到svn代码仓库;

4、必要的脚本支持

必要的shell脚本,python脚本,perl脚本以及Lua脚本支持

## 安全考虑

1. 开发语言：系统采用Java 语言开发，具有卓越的通用性、高效性、平台移植性和安全性。
2. 分层设计：（数据库层，数据访问层，业务逻辑层，展示层）层次清楚，低耦合，各层必须通过接口才能接入并进行参数校验（如：在展示层不可直接操作数据库），保证数据操作的安全。
3. 双重验证：用户表单提交双验证：包括服务器端验证及客户端验证，防止用户通过浏览器恶意修改（如不可写文本域、隐藏变量篡改、上传非法文件等），跳过客户端验证操作数据库。
4. 安全编码：用户表单提交所有数据，在服务器端都进行安全编码，防止用户提交非法脚本及SQL注入获取敏感数据等，确保数据安全。
5. 密码加密：登录用户密码进行SHA1散列加密，[256位银行级加密](http://drops.wooyun.org/papers/1066)，此加密方法是不可逆的。保证密文泄露后的安全问题。
6. 强制访问：系统对所有管理端链接都进行用户身份权限验证，防止用户直接填写url进行访问。

## 快速体验

1. 具备运行环境：JDK1.7+、Maven3.0+、MySql5+或Oracle10g+。
2. 修改src/main/resources/spark.properties文件中的数据库设置参数。
3. 根据修改参数创建对应MySql或Oracle数据库用户和参数。
4. 运行bin/init-db.sh脚本，即可导入表结构及演示数据(linux操作系统：在控制台中切换至项目根目录，运行命令：mvn antrun:run -Pinit-db)
5. 运行bin/run-tomcat7.bat或bin/run-jetty.bat，启动Web服务器（第一次运行，需要下载依赖jar包，请耐心等待）。

## 常见问题

1. 文字乱码：修改Tomcat的server.xml文件的Connector项，增加URIEncoding="UTF-8"
2. 用一段时间提示内存溢出，请修改JVM参数：-Xmx512m -XX:MaxPermSize=256m

## 为何使用MyBatis

* 学习成本：Hibernate的真正掌握要比Mybatis来得难不少。Mybatis框架相对简单很容易上手，也更加灵活。
对于学习过Hibernate的用户，学习起MyBatis也更容易上手。

* 开发成本：大家都说Hibernate开发效率高，个人认为MyBatis的开发效率并不比Hibernate低，
通过代码生成器和封装开发效率不是问题，并且MyBatis可控性比较高，并更易于维护，便于运维人员，开发人员，数据库管理员能更细粒度的维护sql语句。

* 性能方面：由于Hibernate比较难以掌握，性能方面也成为了Hibernate的问题瓶颈，当然如果你对Hibernate非常熟，
Hibernate性能上定不是问题。但对于大多数情况下，真正掌握Hibernate的人少之又少，然而的也就造就了项目风险加大。

* 多数据库支持：有些人说MyBatis对多数据库支持困难，我认为这个不是问题，虽说目前Spark-Framework仅提供对MySql或Oracle
数据库的支持，但对于支持其它数据库的改动也不是很麻烦，SQL是被专门写在XML中，对于大多数SQL来说都是通用的，
对于不同的数据库可通过dbName区分和修改各别的SQL片段即可，针对不同的数据库方言，用拦截器或者对应分页SQL解决。

上述纯属个人观点，欢迎指正（zhangxiongcai337@163.com）。

当然ORM层可以替换成Hibernate，请点击[下载Hibernate版本](https://github.com/hibernate/hibernate-orm)。
或者ORM层可以替换成JPA，请点击[下载JPA版本](https://github.com/spring-projects/spring-data-jpa)。

## 版权声明

本软件使用 [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0) 协议，请严格遵照协议内容：

1. 需要给代码的用户一份Apache Licence。
2. 如果你修改了代码，需要在被修改的文件中说明。
3. **在延伸的代码中（修改和有源代码衍生的代码中）需要带有原来代码中的协议，商标，专利声明和其他原来作者规定需要包含的说明。**
4. 如果再发布的产品中包含一个Notice文件，则在Notice文件中需要带有Apache Licence。你可以在Notice中增加自己的许可，但不可以表现为对Apache Licence构成更改。
3. Apache Licence也是对商业应用友好的许可。使用者也可以在需要的时候修改代码来满足需要并作为开源或商业产品发布/销售

## Spark-Framework框架示例

TodoList应用演示(包括用户登录注册,任务创建查看等操作,仅作示范)