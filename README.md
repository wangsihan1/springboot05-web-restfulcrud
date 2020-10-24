# CRUD

+ 基于spring boot的增删改查，本地Dao层模拟数据库，Rest风格接口。
+ 前端基于bootstrap+Thymeleaf模板引擎

## 主要功能

+ 登录页面实现国际化
+ 拦截器进行登录检查
+ 定制错误响应页面
+ 定制错误的json数据格式
+ 对接reCAPTCHA谷歌验证码API进行登录检查
+ thymeleaf公共页面元素抽取

### 运行
+ 修改LoginController中的String a的值。
+ 修改login.html中的data-sitekey值。



或者在cmd中执行 java -jar springboot05-web-restfulcrud-0.0.1-SNAPSHOT.jar 