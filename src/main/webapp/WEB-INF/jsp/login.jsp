<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%--<%--%>
    <%--String path = request.getContextPath();--%>
    <%--String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()--%>
            <%--+ path + "/";--%>
<%--%>--%>
<html>
<head>

    <%--<base href="<%=basePath%>">--%>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <title>Web 2.0 Login Form</title>

    <!--- CSS --->
    <link rel="stylesheet" href="css/style.css" type="text/css" />


    <!--- Javascript libraries (jQuery and Selectivizr) used for the custom checkbox --->

    <!--[if (gte IE 6)&(lte IE 8)]>
    <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="js/selectivizr.js"></script>
    <noscript><link rel="stylesheet" href="css/fallback.css" /></noscript>
    <![endif]-->
</head>

<body>
<div id="container">
    <form action="userCtrl/login" method="post">
        <div class="login">LOGIN</div>
        <div class="username-text" >Username:</div>
        <div class="password-text" >Password:</div>
        <div class="username-field">
            <input type="text" id = "user_name" name = "user_name" />
        </div>
        <div class="password-field">
            <input type="password"  id = "pwd" name = "pwd" />
        </div>
        <input type="checkbox" name="remember-me" id="remember-me" /><label for="remember-me">Remember me</label>
        <div class="forgot-usr-pwd">Forgot <a href="#">username</a> or <a href="#">password</a>?</div>
        <input type="submit" name="submit" value="GO" />
    </form>
</div>
<div id="footer">
    Copyright &copy; 2014.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a>
</div>
<%--<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript'--%>
                                  <%--charset='gb2312'></script></div>--%>
</body>
</html>