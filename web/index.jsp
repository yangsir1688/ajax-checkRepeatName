<%--
  Created by IntelliJ IDEA.
  User: Mryang
  Date: 2019/7/9
  Time: 8:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="zh">
<head>
  <meta charset="UTF-8">
  <title>使用Ajax校验用户名是否可用</title>
  <script src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>

</head>
<body>
<form>
  <input type="text" id="username" name="username" placeholder="请输入用户名">
  <span id="span_username"></span>

  <br/>
  <input type="password" name="password" placeholder="请输入密码"><br>
  <input type="submit" value="戳我来注册"><br>
</form>

</body>
</html>
<script>
    //在页面加载完成后
    $(function () {
        //给username绑定blur(失焦)事件 | 光标离开username区域后
        $("#username").blur(function () {
            //获取username文本输入框的值
            var username = $(this).val();
            //发送ajax请求
            //如果可用则显示:"此用户名太受欢迎,请更换一个"
            //如果不可用则:"用户名可用"
            $.get("showUserServlet",{username:username},function (data) {
                var span = $("#span_username");
                if(data.userExsit){
                    //用户名存在
                    span.css("color","red");
                    span.html(data.msg);
                }else{
                    //用户名不存在
                    span.css("color","green");
                    span.html(data.msg);
                }
            });
        });
    });
</script>