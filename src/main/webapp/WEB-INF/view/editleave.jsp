<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: XingYu Yi
  Date: 2019/6/16
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>查看请假</title>
    <link rel="stylesheet" href=${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css>
    <script src="${pageContext.request.contextPath}/js/jquery-2.0.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>

    <script src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layui/css/layui.css">
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
                <li class="dropdown active">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        请假管理 <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/editleave">请假</a></li>
                        <li class="divider"></li>
                        <li><a href="${pageContext.request.contextPath}/leave">查看请假</a></li>
                    </ul>
                </li>
                <li class="dropdown">
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
<div style="padding: 0px 20%">
    <%-- 面包屑 --%>
    <ul class="breadcrumb">
        <li><a href="${pageContext.request.contextPath}/leave">请假管理</a></li>
        <li class="active">填写请假信息</li>
    </ul>
    <div class="layui-card" style="padding: 5px">
        <h3 style="margin: 0px;margin-bottom:20px;padding: 10px 0px 10px 20px;border-bottom: 1px solid #eee">基本信息</h3>
        <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/leaves/leave" method="post">
            <div class="form-group">
                <label class="col-sm-3 control-label">姓名</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" style="background-color: white" value="${emp.employeeName}" readonly="readonly">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">部门</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" style="background-color: white" value="${emp.department.departmentName}" readonly="readonly">
                </div>
            </div>
            <div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">开始时间</label>
                    <div class="col-sm-1">
                        <input type="text" class="layui-input" id="startdate" name="startDate" style="width: auto">
                    </div>
                    <label class="col-sm-2 control-label">结束时间</label>
                    <div class="col-sm-1">
                        <input type="text" class="layui-input" id="enddate" name="endDate" style="width: auto">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">请假天数</label>
                <div class="col-sm-1">
                    <input type="text" class="form-control" style="background-color: white"  name="leaveDays" value="1" readonly="readonly" id="days">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">请假事由</label>
                <div class="col-sm-5">
                    <textarea type="text" class="form-control"  name="reason"  placeholder="请输入事由" style="width: 560px;height: 60px"></textarea>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-5" style="margin-left: 370px">
                    <button type="submit" class="btn btn-default" style="width: 200px">保存</button>
                    <a href="${pageContext.request.contextPath}/leave">
                        <button type="button" class="btn btn-default" style="width: 200px">返回</button>
                    </a>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
<%-- 加载日期控件 --%>
<script>
    layui.use('laydate', function () {
        var laydate = layui.laydate;
        var now = new Date();
        var nownext = new Date();
        nownext.setDate(now.getDate() + 1)
        //执行一个laydate实例
        var startdate = laydate.render({
            elem: '#startdate' //指定元素
            , min: 'now'
            , type: "date"
            , value: now
            , done: function (value, date) {
                // alert('你选择的日期是：' + value + '\n获得的对象是' + JSON.stringify(date));
                enddate.config.min = {
                    year: date.year,
                    month: date.month - 1, //关键
                    date: date.date,
                };
                //控件选择完毕后的回调
                var start = $("#startdate").val();
                var end = $("#enddate").val();
                var days = getDays(end,start);
                if(days==0){
                    days=1
                }
                $("#days").val(days);
                console.log(value); //得到日期生成的值，如：2017-08-18
                console.log(date); //得到日期时间对象：{year: 2017, month: 8, date: 18, hours: 0, minutes: 0, seconds: 0}
                console.log(endDate); //得结束的日期时间对象，开启范围选择（range: true）才会返回。对象成员同上。
            }
        });
        var enddate = laydate.render({
            elem: '#enddate' //指定元素
            , min: 'nownext'
            , type: "date"
            , value: nownext
            , done: function (value, date) {
                // alert('你选择的日期是：' + value + '\n获得的对象是' + JSON.stringify(date));
                startdate.config.max = {
                    year: date.year,
                    month: date.month - 1, //关键
                    date: date.date,
                };
                //控件选择完毕后的回调
                var start = $("#startdate").val();
                var end = $("#enddate").val();
                var days = getDays(end,start);
                if(days==0){
                    days=1
                }
                $("#days").val(days);
                console.log(value); //得到日期生成的值，如：2017-08-18
                console.log(date); //得到日期时间对象：{year: 2017, month: 8, date: 18, hours: 0, minutes: 0, seconds: 0}
                console.log(endDate); //得结束的日期时间对象，开启范围选择（range: true）才会返回。对象成员同上。
            }
        })
    });

    function getDays(date1 , date2){
        var date1Str = date1.split("-");//将日期字符串分隔为数组,数组元素分别为年.月.日
        //根据年 . 月 . 日的值创建Date对象
        var date1Obj = new Date(date1Str[0],(date1Str[1]-1),date1Str[2]);
        var date2Str = date2.split("-");
        var date2Obj = new Date(date2Str[0],(date2Str[1]-1),date2Str[2]);
        var t1 = date1Obj.getTime();
        var t2 = date2Obj.getTime();
        var dateTime = 1000*60*60*24; //每一天的毫秒数
        var minusDays = Math.floor(((t2-t1)/dateTime));//计算出两个日期的天数差
        var days = Math.abs(minusDays);//取绝对值
        return days;
    }
</script>