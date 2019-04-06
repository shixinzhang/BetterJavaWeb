2019年4月6日星期六



# 9.Servlet RequestURI 和 RequestURL 区别



```

final String uri = request.getRequestURI();
final String url = request.getRequestURL().toString();

System.out.println(uri + "\n" + url);
```



第一个返回的是 path，第二个是完整地址：



```

/developer/api/developers

http://localhost:8080/developer/api/developers

```



# 8.查询结果里字段值反了



查询结果里的字段要和数据库里的顺序一致



# 7.``Servlet`` 访问 404





使用注解的话，检查有没有在 ``WebServlet`` 里配置 ``urlPatterns``，**这个参数表示支持访问的 path 名，支持多个！**

>别漏了前面的斜杠 ``/``



然后重启 server，访问  ``urlPatterns`` 里配置的路径即可。

# 6.部署 Servlet


# 5.新建没有 ``Servlet`` 选项



刷新 maven





# 4.运行 hello world 都有问题，几种情况



1. 只显示 Tomcat 猫 -》``shutdown.sh``

2. 无法找到服务，看看 log 里说啥，有可能端口占用了



>同时如果运行多个项目，需要关闭其他的。



# 3.Deploy 时找不到 war 包






去设置里允许 maven 自动导包：




# 2.Mysql密码



升级最新的不知道为什么启动有问题，还是使用旧的 5.7.X 吧



TYyxwt=9j+hP，新密码：root




# 1.Tomcat 启动失败






解决办法：



删掉 logs 目录下的那个没有权限的文件，反正也是日志文件，没关系。



>这个 ``catalina.out`` 里有报错信息，遇到问题可以去看看。