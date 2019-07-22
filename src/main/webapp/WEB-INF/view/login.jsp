<%--
  Created by IntelliJ IDEA.
  User: XingYu Yi
  Date: 2019/5/27
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>登陆/注册</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/loginstyle.css">
    <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
    <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/icon?family=Material+Icons'>
</head>
<body>

<div class="cotn_principal">
    <div class="cont_centrar">
        <div class="cont_login">
            <div class="cont_info_log_sign_up">
                <div class="col_md_login">
                    <div class="cont_ba_opcitiy">
                        <h2>登陆</h2>
                        <p>欢迎回来</p>
                        <button class="btn_login" onClick="cambiar_login()">登陆</button>
                    </div>
                </div>
                <div class="col_md_sign_up">
                    <div class="cont_ba_opcitiy">
                        <h2>注册</h2>
                        <p>成为我们的会员</p>
                        <button class="btn_sign_up" onClick="cambiar_sign_up()">注册</button>
                    </div>
                </div>
            </div>
            <div class="cont_back_info">
                <div class="cont_img_back_grey"><img src="po.jpg" alt=""/></div>
            </div>
            <div class="cont_forms">
                <div class="cont_img_back_"><img src="po.jpg" alt=""/></div>
                <div class="cont_form_login"><a href="#" onClick="ocultar_login_sign_up()"><i class="material-icons">&#xE5C4;</i></a>
                    <h2>登录</h2>
                    <form action="${pageContext.request.contextPath}/log_in" method="post">
                        <input type="text" placeholder="用户名" name="employeeName"/>
                        <input type="password" placeholder="密码" name="password"/>
                        <button class="btn_login" onClick="cambiar_login()">登陆
                        </button>
                    </form>
                </div>
                <div class="cont_form_sign_up"><a href="#" onClick="ocultar_login_sign_up()"><i class="material-icons">&#xE5C4;</i></a>
                    <h2>注册</h2>
                    <form action="${pageContext.request.contextPath}/sign_in" method="post">
                        <input type="text" placeholder="用户名" name="employeeName"/>
                        <input type="password" placeholder="密码" name="password"/>
                        <input type="password" placeholder="确认密码"/>
                        <button class="btn_sign_up" onClick="cambiar_sign_up()">注册</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/js/login.js"></script>

</body>
</html>