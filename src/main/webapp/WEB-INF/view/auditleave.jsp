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
<body style="background-color: #eeeeee">
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
<div style="padding: 0px 20%;margin-bottom: 40px">
    <%-- 面包屑 --%>
    <ul class="breadcrumb">
        <li><a href="${pageContext.request.contextPath}/leave">请假管理</a></li>
        <li class="active">审核请假信息</li>
    </ul>
    <form class="form-horizontal layui-card" role="form" action="${pageContext.request.contextPath}/leaves/leave" method="post" style="padding: 5px">

        <h3 style="margin: 0px;margin-bottom:20px;padding: 10px 0px 10px 20px;border-bottom: 1px solid #eee">基本信息</h3>
        <div class="form-group">
            <label class="col-sm-2 control-label">姓名</label>
            <div class="col-sm-2">
                <input type="text" class="form-control" style="background-color: white" value="${leaveRecord.leaveEmp.employeeName}" readonly="readonly">
            </div>
            <label class="col-sm-2 control-label">部门</label>
            <div class="col-sm-2">
                <input type="text" class="form-control" style="background-color: white" value="${leaveRecord.leaveEmp.department.departmentName}" readonly="readonly">
            </div>
        </div>
        <div>
            <div class="form-group">
                <label class="col-sm-2 control-label">开始时间</label>
                <div class="col-sm-2">
                    <input type="text" class="layui-input" id="startdate" name="startDate" style="width: 167px" value="<fmt:formatDate value="${leaveRecord.startDate}" pattern="yyyy-MM-dd"></fmt:formatDate>" readonly="readonly">
                </div>
                <label class="col-sm-2 control-label">结束时间</label>
                <div class="col-sm-3">
                    <input type="text" class="layui-input" id="enddate" name="endDate" style="width: 167px" value="<fmt:formatDate value="${leaveRecord.endDate}" pattern="yyyy-MM-dd"></fmt:formatDate>" readonly="readonly">
                </div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">请假天数</label>
            <div class="col-sm-1">
                <input type="text" class="form-control" name="leaveDays" style="background-color: white" value="${leaveRecord.leaveDays}" readonly="readonly" id="days">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">请假状态</label>
            <div class="col-sm-1">
                <input type="text" class="form-control" name="approvalStateId" style="background-color: white" value="${leaveRecord.approvalState.approvalStateName}" readonly="readonly">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">请假事由</label>
            <div class="col-sm-5">
                <textarea type="text" class="form-control" name="reason" style="background-color: white;font-size: 20px;resize: none;height: 100px;width: 555px" readonly="readonly">${leaveRecord.reason}</textarea>
            </div>
        </div>

    </form>
    <div class="layui-card" style="padding: 5px">
        <h3 style="margin: 0px;margin-bottom:20px;padding: 10px 0px 10px 20px;border-bottom: 1px solid #eee">审查记录</h3>
        <table class="table table-striped" style="width: 98%;margin: 0px 10px">
            <thead>
            <tr>
                <th>审查人</th>
                <th>审查意见</th>
                <th>审查时间</th>
                <th>审查结果</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${leaveRecord.reviewRecords}" var="review">
                <tr>
                    <td>${review.employee.employeeName}</td>
                    <td>${review.reviewIdea}</td>
                    <td><fmt:formatDate value="${review.reviewDate}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                    <td>${review.reviewState.reviewStateResult}</td>

                </tr>
            </c:forEach>
            <c:if test="${leaveRecord.reviewRecords.size()==0}">
                <tr>
                    <td colspan="4" style="background-color: white"><h3>暂无审查记录</h3></td>
                </tr>
            </c:if>
            </tbody>
        </table>
    </div>
    <c:if test="${audit==1}">
        <div class="layui-card" style="padding: 5px">
            <h3 style="margin: 0px;margin-bottom:20px;padding: 10px 0px 10px 20px;border-bottom: 1px solid #eee">审核</h3>
            <div class="form-group" style="margin-left: 10px;overflow: hidden;">
                <label class="col-sm-2 control-label">审批意见</label>
                <textarea type="text" class="form-control" name="reviewIdea" style="font-size: 20px;resize: none;height: 100px;" id="idea"></textarea>
                <div class="form-group">
                    <input type="hidden" name="orderId" value="${leaveRecord.leaveId}" id="orderId">
                    <div style="margin: 20px 0px 10px 0px">
                            <%-- 如果不是人事 --%>
                        <c:if test="${leaveRecord.disposeBy!=3}">
                            <button type="submit" class="btn btn-default" onclick="saveRecord(1)">审批通过</button>
                            <button type="submit" class="btn btn-default" onclick="saveRecord(3)">审批拒绝</button>
                        </c:if>
                            <%-- 如果是人事处理 --%>
                        <c:if test="${leaveRecord.disposeBy==3}">
                            <button type="submit" class="btn btn-default" onclick="saveRecord(1)">存档</button>
                        </c:if>
                        <a href="${pageContext.request.contextPath}/leave">
                            <button type="button" class="btn btn-default">返回</button>
                        </a>
                    </div>
                </div>
            </div>

        </div>
    </c:if>
</div>
</body>
</html>
<%-- 加载日期控件 --%>
<script>
    function saveRecord(stateId) {
        var record = {}
        record["orderId"]=$("#orderId").val()//订单号
        record["reviewStateId"]=stateId//审批状态
        record["reviewIdea"]=$("#idea").val()//审批意见
        $.ajax({
            url:"${pageContext.request.contextPath}/saveReviewRecord",
            type:"post",
            data:JSON.stringify(record),
            dataType:"JSON",
            contentType:"application/json",
            success:function (data) {
                alert(data.info)
                if(data.code=="200"){
                    location.href="${pageContext.request.contextPath}/"+data.path
                }
            }
        })
    }
</script>