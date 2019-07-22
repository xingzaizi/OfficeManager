<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: XingYu Yi
  Date: 2019/6/21
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>报销统计</title>
    <link rel="stylesheet" href=${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css>
    <script src="${pageContext.request.contextPath}/js/jquery-2.0.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/layui/css/layui.css">
    <script src="<%=request.getContextPath()%>/layui/layui.js"></script>

    <%--分页--%>
    <link href="${pageContext.request.contextPath}/vue/zpageNav.css" rel="stylesheet" />

    <script src="${pageContext.request.contextPath}/js/jquery-2.0.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/echarts/echarts.min.js"></script>
</head>
<body style="background-color: #eee">
<nav class="navbar navbar-default" role="navigation" >
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/index">办公管理系统</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        报销管理 <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="<%=request.getContextPath()%>/add">新增报销单</a></li>
                        <li class="divider"></li>
                        <li><a href="<%=request.getContextPath()%>/expenditureShow">查看报销单</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        请假管理 <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/editleave">请假</a></li>
                        <li class="divider"></li>
                        <li><a href="${pageContext.request.contextPath}/leave">查看请假</a></li>
                    </ul>
                </li>
                <li class="dropdown active">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        统计报表 <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/chartbymonth">报销单月度统计</a></li>
                        <li class="divider"></li>
                        <li><a href="${pageContext.request.contextPath}/chart/dep/year">报销单年度统计</a></li>
                    </ul>
                </li>
                <li><a href="${pageContext.request.contextPath}/back">退出系统</a></li>
            </ul>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <c:if test="${not empty emp}">
                <li><a href="javascript:;"><span class="glyphicon glyphicon-user"></span>【登录角色：${emp.position.positionName}】欢迎您，${emp.employeeName}</a></li>
            </c:if>
            <c:if test="${empty emp}">
                <li><a href="${pageContext.request.contextPath}/login"><span class="glyphicon glyphicon-user"></span> 注册</a></li>
                <li><a href="${pageContext.request.contextPath}/login"><span class="glyphicon glyphicon-log-in"></span> 登录</a></li>
            </c:if>
        </ul>
    </div>
</nav>
<div style="background-color: white;padding-bottom: 20px" id="chart">
    <div class="layui-card">
        <div class="layui-card-header" style="height: auto;">
            <h3 style="padding-top: 12px">报销单月度统计</h3>
        </div>
        <div>
            <%-- 筛选条件 --%>
            <div class="form-group" style="padding: 10px 0px;overflow: hidden;clear: both;border-bottom: 1px solid #eee">
                <%-- 筛选条件 --%>
                <div class="form-group" style="padding: 10px 0px;overflow: hidden;clear: both;border-bottom: 1px solid #eee">
                    <label class="control-label" style="float: left;padding: 7px 15px">开始年份</label>
                    <select class="form-control" style="width: 100px;float: left;" id="startYear">
                        <option value="-1">无</option>
                        <option value="2010">2010</option>
                        <option value="2011">2011</option>
                        <option value="2012">2012</option>
                        <option value="2013">2013</option>
                        <option value="2014">2014</option>
                        <option value="2015">2015</option>
                        <option value="2016">2016</option>
                        <option value="2017">2017</option>
                        <option value="2018">2018</option>
                        <option value="2019">2019</option>
                    </select>
                    <label class="control-label" style="float: left;padding: 7px 15px">结束年份</label>
                    <select class="form-control" style="width: 100px;float: left;" id="endYear">
                        <option value="-1">无</option>
                        <option value="2010">2010</option>
                        <option value="2011">2011</option>
                        <option value="2012">2012</option>
                        <option value="2013">2013</option>
                        <option value="2014">2014</option>
                        <option value="2015">2015</option>
                        <option value="2016">2016</option>
                        <option value="2017">2017</option>
                        <option value="2018">2018</option>
                        <option value="2019">2019</option>
                    </select>
                    <input type="button" class="btn btn-info" value="查询" id="sel">
                </div>
                <script>
                    $("#sel").click(function () {
                        var url = "${pageContext.request.contextPath}/chart/dep/year"
                        var startYear = $("#startYear").val();
                        var endYear = $("#endYear").val();
                        if (startYear!=-1&&endYear!=-1){
                            url+="?startYear="+startYear+"&endYear="+endYear
                        }else if(startYear!=-1){
                            url+="?startYear="+startYear
                        }else if(endYear!=-1){
                            url+="?endYear="+endYear
                        }
                        location.href=url
                    })
                </script>
            </div>
            <div>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>编号</th>
                        <th>报销总额</th>
                        <th>年份</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${voDep}" var="dep" varStatus="i">
                        <tr>
                            <td>${i.count}</td>
                            <td>${dep.totalMoney}元</td>
                            <td>${dep.year}年</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/chart/emp?year=${dep.year}&where=byYear">
                                    <input type="button" class="btn btn-info" value="查看">
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div style="padding:5%;height: 600px;border-top:2px solid #eee;border-bottom:2px solid #eee;margin-bottom: 20px">
                <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
                <div id="main" style="width:40%;height: 500px;float: left;"></div>
                <div id="pie" style="width:40%;height: 500px;float: left;"></div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<%--分页--%>
<script src="${pageContext.request.contextPath}/vue/vue.js"></script>
<script src="${pageContext.request.contextPath}/vue/zpageNav.js"></script>
