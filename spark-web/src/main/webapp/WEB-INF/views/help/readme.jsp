<html>
<head>
	<title>Spark-Framework Java Web项目基础框架 说明文档</title>
</head>

<body>


<div id="wmd-preview" class="wmd-preview wmd-preview-full-reader" data-medium-element="true" style="left: 0px;"><div class="md-section-divider"></div>

<div class="md-section-divider"></div>

<h1 data-anchor-id="8zx1" id="spark-framework  Java Web项目基础框架">Spark-Framework Java Web项目基础框架</h1>

<div class="md-section-divider"></div>

<h2 data-anchor-id="7wjy" id="搭建初衷">搭建初衷</h2>

<p data-anchor-id="cbk0">1.尽量不使用比较偏的技术框架和代码库; <br>
2.使用一些易于快速开发和迭代的技术; <br>
3.必须易于扩展,分层清晰;代码冗余度低,高内聚低耦合是设计初衷; <br>
4.必须易于上手,快速融于开发,更多的突出业务逻辑部分; <br>
5.接口与实现分离是设计原则,尽量做到实现都是可以替换的;</p>

<div class="md-section-divider"></div>

<h2 data-anchor-id="zlsm" id="框架简介">框架简介</h2>

<p data-anchor-id="sc8d">Spark-Framework是基于多个优秀的开源项目，高度整合封装而成的高效，高性能，高安全性的**开源**Java EE快速开发平台。</p>

<p data-anchor-id="4ptr">Spark-Framework本身是以Spring Framework为核心容器，Spring MVC为模型视图控制器，MyBatis为数据访问层， <br>
Apache Shiro为权限授权层，Ehcahe对常用数据进行缓存。</p>

<p data-anchor-id="d6dt">采用分层设计、双重验证、提交数据安全编码、密码加密、访问验证、数据权限验证。 <br>
使用Maven做项目管理，提高项目的易开发性、扩展性。 <br>
前端界面风格初步引入了结构简单、性能优良、容易上手的Twitter Bootstrap页面展示框架。</p>

<p data-anchor-id="2qxz">Spark-Framework 提供了常用工具的封装，包括日志工具、缓存工具、服务器端验证、数据字典、当前组登录用户数据 <br>
（用户、角色、权限）以及其它常用小工具等。 <br>
如果你使用了Spark-Framework基础框架，就可以很高效的快速开发出，优秀的互联网产品。</p>

<div class="md-section-divider"></div>

<h2 data-anchor-id="f6a3" id="为何选择spark-framework">为何选择Spark-Framework</h2>

<ol data-anchor-id="h275">
<li>使用 <a href="http://www.apache.org/licenses/LICENSE-2.0" target="_blank">Apache License 2.0</a> 协议，源代码闭源。</li>
<li>使用目前主流的Java EE开发框架，简单易学，学习成本低。</li>
<li>数据库无限制，目前支持MySql、Oracle，可扩充SQL Server、PostgreSQL、H2、MongoDB等。</li>
<li>模块化设计，层次结构清晰。</li>
<li>操作权限控制精密细致，对所有管理链接都进行权限验证，可控制到按钮。</li>
<li>数据权限控制精密细致，对指定数据集权限进行过滤，七种数据权限可供选择。</li>
<li>提供常用工具类封装，日志、缓存、验证、字典等，常用标签（taglib），获取当前字典等数据。</li>
</ol>

<div class="md-section-divider"></div>

<h2 data-anchor-id="z676" id="技术选型">技术选型</h2>

<p data-anchor-id="xuic">1、后端</p>

<ul data-anchor-id="4m3n">
<li>核心框架：Spring Framework 4.1.3</li>
<li>安全框架：Apache Shiro 1.2</li>
<li>视图框架：Spring MVC 4.1.3</li>
<li>服务端验证：Hibernate Validator 5.1</li>
<li>任务调度：Quartz</li>
<li>持久层框架：MyBatis 3.2</li>
<li>数据库连接池：Alibaba Druid 1.0</li>
<li>缓存框架：Ehcache 2.6、Redis</li>
<li>日志管理：SLF4J 1.7、Log4j</li>
<li>工具类：Google Guava、Apache Commons、Jackson 2.4、Xstream 1.4、Dozer 5.3、POI 3.9 </li>
<li>页面渲染：Velocity</li>
<li>SOA框架：Alibaba Dubbo、Apache CXF</li>
<li>消息队列：ActiveMQ 5.7.0、Apache Kafka</li>
<li>Web容器：Tomcat 7、Jetty 7、Jboss</li>
<li>通信框架：Apache Mina、Netty</li>
<li>搜索框架：Apache Lucene</li>
</ul>

<p data-anchor-id="w6v0">2、前端</p>

<ul data-anchor-id="50ib">
<li>JS框架：jQuery 1.9。</li>
<li>CSS框架：Twitter Bootstrap 2.3.1。</li>
<li>客户端验证：JQuery Validation Plugin 1.11。</li>
<li>富文本：</li>
<li>文件管理：</li>
<li>动态页签：</li>
<li>数据表格：jqGrid</li>
<li>对话框：</li>
<li>下拉选择框：</li>
<li>树结构控件：</li>
<li>日期控件： </li>
</ul>

<p data-anchor-id="vuus">3、平台</p>

<ul data-anchor-id="5fas">
<li>服务器中间件：在Java EE 5规范（Servlet 2.5、JSP 2.1）下开发，支持应用服务器中间件 <br>
有Tomcat 7、Jetty 7、Jboss 7、WebLogic 10、WebSphere 8。</li>
<li>数据库支持：目前仅提供MySql和Oracle数据库的支持，但不限于数据库，平台留有其它数据库支持接口， <br>
可方便更改为其它数据库，如：SqlServer 2008、PostgreSQL、MongoDB等</li>
<li>开发环境：Java EE、JDK 7+</li>
<li>开发工具：Eclipse(自主选择)、VIM</li>
<li>代码管理：Maven、Svn(Git)</li>
<li>团队协作：Jira、Tower</li>
<li>文档管理：Confluence</li>
<li>持续集成：Jenkins</li>
</ul>

<p data-anchor-id="ea07">3、前后端分离</p>

<p data-anchor-id="2u3d">前端JS,CSS,HTML代码和IMG图片,FRONT字体不放在J2EE项目代码中,单独在svn代码库中新建分支去管理;J2EE项目引用静态文件时是在svn中加个钩子; <br>
前端开发人员本地机器不需要拉下J2EE代码,静态文件引用指向本地电脑,修改Hosts即可;动态内容连接局域网内部测试服务器,或者远程测试服务器; <br>
局域网内部测试服务器安装并开启SMB服务,前端可直接修改服务器上Velocity模板,并提交到svn代码仓库;</p>

<p data-anchor-id="o1kj">4、必要的脚本支持</p>

<p data-anchor-id="kied">必要的shell脚本,python脚本,perl脚本以及Lua脚本支持</p>

<div class="md-section-divider"></div>

<h2 data-anchor-id="gg0f" id="安全考虑">安全考虑</h2>

<ol data-anchor-id="qq30">
<li>开发语言：系统采用Java 语言开发，具有卓越的通用性、高效性、平台移植性和安全性。</li>
<li>分层设计：（数据库层，数据访问层，业务逻辑层，展示层）层次清楚，低耦合，各层必须通过接口才能接入并进行参数校验（如：在展示层不可直接操作数据库），保证数据操作的安全。</li>
<li>双重验证：用户表单提交双验证：包括服务器端验证及客户端验证，防止用户通过浏览器恶意修改（如不可写文本域、隐藏变量篡改、上传非法文件等），跳过客户端验证操作数据库。</li>
<li>安全编码：用户表单提交所有数据，在服务器端都进行安全编码，防止用户提交非法脚本及SQL注入获取敏感数据等，确保数据安全。</li>
<li>密码加密：登录用户密码进行SHA1散列加密，<a href="http://drops.wooyun.org/papers/1066" target="_blank">256位银行级加密</a>，此加密方法是不可逆的。保证密文泄露后的安全问题。</li>
<li>强制访问：系统对所有管理端链接都进行用户身份权限验证，防止用户直接填写url进行访问。</li>
</ol>

<div class="md-section-divider"></div>

<h2 data-anchor-id="ax98" id="快速体验">快速体验</h2>

<ol data-anchor-id="woe1">
<li>具备运行环境：JDK1.7+、Maven3.0+、MySql5+或Oracle10g+。</li>
<li>修改src/main/resources/spark.properties文件中的数据库设置参数。</li>
<li>根据修改参数创建对应MySql或Oracle数据库用户和参数。</li>
<li>运行bin/init-db.sh脚本，即可导入表结构及演示数据(linux操作系统：在控制台中切换至项目根目录，运行命令：mvn antrun:run -Pinit-db)</li>
<li>运行bin/run-tomcat7.bat或bin/run-jetty.bat，启动Web服务器（第一次运行，需要下载依赖jar包，请耐心等待）。</li>
</ol>

<div class="md-section-divider"></div>

<h2 data-anchor-id="ttkl" id="常见问题">常见问题</h2>

<ol data-anchor-id="mzum">
<li>文字乱码：修改Tomcat的server.xml文件的Connector项，增加URIEncoding="UTF-8"</li>
<li>用一段时间提示内存溢出，请修改JVM参数：-Xmx512m -XX:MaxPermSize=256m</li>
</ol>

<div class="md-section-divider"></div>

<h2 data-anchor-id="z1tq" id="为何使用mybatis">为何使用MyBatis</h2>

<ul data-anchor-id="h891">
<li><p>学习成本：Hibernate的真正掌握要比Mybatis来得难不少。Mybatis框架相对简单很容易上手，也更加灵活。 <br>
对于学习过Hibernate的用户，学习起MyBatis也更容易上手。</p></li>
<li><p>开发成本：大家都说Hibernate开发效率高，个人认为MyBatis的开发效率并不比Hibernate低， <br>
通过代码生成器和封装开发效率不是问题，并且MyBatis可控性比较高，并更易于维护，便于运维人员，开发人员，数据库管理员能更细粒度的维护sql语句。</p></li>
<li><p>性能方面：由于Hibernate比较难以掌握，性能方面也成为了Hibernate的问题瓶颈，当然如果你对Hibernate非常熟， <br>
Hibernate性能上定不是问题。但对于大多数情况下，真正掌握Hibernate的人少之又少，然而的也就造就了项目风险加大。</p></li>
<li><p>多数据库支持：有些人说MyBatis对多数据库支持困难，我认为这个不是问题，虽说目前Spark-Framework仅提供对MySql或Oracle <br>
数据库的支持，但对于支持其它数据库的改动也不是很麻烦，SQL是被专门写在XML中，对于大多数SQL来说都是通用的， <br>
对于不同的数据库可通过dbName区分和修改各别的SQL片段即可，针对不同的数据库方言，用拦截器或者对应分页SQL解决。</p></li>
</ul>

<p data-anchor-id="xn93">上述纯属个人观点，欢迎指正（zhangxiongcai337@163.com）。</p>

<p data-anchor-id="xzdz">当然ORM层可以替换成Hibernate，请点击<a href="https://github.com/hibernate/hibernate-orm" target="_blank">下载Hibernate版本</a>。 <br>
或者ORM层可以替换成JPA，请点击<a href="https://github.com/spring-projects/spring-data-jpa" target="_blank">下载JPA版本</a>。</p>

<div class="md-section-divider"></div>

<h2 data-anchor-id="ien9" id="版权声明">版权声明</h2>

<p data-anchor-id="z88x">本软件使用 <a href="http://www.apache.org/licenses/LICENSE-2.0" target="_blank">Apache License 2.0</a> 协议，请严格遵照协议内容：</p>

<ol data-anchor-id="nuxw">
<li>需要给代码的用户一份Apache Licence。</li>
<li>如果你修改了代码，需要在被修改的文件中说明。</li>
<li><strong>在延伸的代码中（修改和有源代码衍生的代码中）需要带有原来代码中的协议，商标，专利声明和其他原来作者规定需要包含的说明。</strong></li>
<li>如果再发布的产品中包含一个Notice文件，则在Notice文件中需要带有Apache Licence。你可以在Notice中增加自己的许可，但不可以表现为对Apache Licence构成更改。</li>
<li>Apache Licence也是对商业应用友好的许可。使用者也可以在需要的时候修改代码来满足需要并作为开源或商业产品发布/销售</li>
</ol>

<div class="md-section-divider"></div>

<h2 data-anchor-id="migt" id="spark-framework框架示例">Spark-Framework框架示例</h2>

<p data-anchor-id="om30"><a href="http://120.25.251.53/spark/" target="_blank">TodoList应用演示</a>(包括用户登录注册,任务创建查看等操作,仅作示范)</p></div>



</body>
</html>