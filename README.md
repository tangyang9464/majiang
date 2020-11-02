#majiang论坛

### 项目简介
课余时间写的论坛项目,主要功能包括用户登录,发帖,回帖,分页展示等.采用了springboot+mybatis+mysql等技术

### 主要功能
1.用户登录(只支持github登录)

2.提问(即是发帖,内容为:标题+正文+标签)

3.回帖(包括一级评论和二级评论)

4.关键词搜索问题 

5.分页展示问题

6.其他(有一些功能只有页面,但是暂时还没做出来)

### 技术栈

|  技术框架   | 用处 |
|  ----  | ----  |
| SpringBoot  | MVC框架  |
| MyBatis  | 持久层框架 |
| MySql8.0+  | 数据库 |
| JustAuth  | 第三方登录认证 |
| flyway | 自动执行sql建表 |
| MBG | 自动生成dao层操作代码 |

### 使用
1.安装mysql8.0+(项目使用的是8.0+)
2.解压代码导入idea
3.建立数据库,名称为majiang
4.修改resource/application.yml下的数据库名称和密码
5.运行

###个人完成的功能
1.用户登录:使用JustAuth,完成github第三登录认证.然后将获取的token放入cooike用于保持登录状态
    
    注:共两步,发起授权-地址回调
    OAuth2认证过程:1.用户授权 2.客户端获取code 3.code换取token 4.token换取信息
    参考:https://www.ruanyifeng.com/blog/2014/05/oauth_2_0.html

2.发帖,回帖:表单提交,后台获取数据后更新数据库

3.分页展示:利用分页插件,设置好页数和每页的展示数量,然后数据库查询

    简单的步骤:设置关键参数:curPage当前页 PageSize每页展示数量
        根据参数计算,select出相关数据,保存在page对象中
        page对象应该包括page的所有信息,比如当前页,最大数,相关数据data等
