<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: XingYu Yi
  Date: 2019/6/11
  Time: 7:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href=${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css>
    <script src="${pageContext.request.contextPath}/js/jquery-2.0.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
    <%--分页--%>
    <link href="${pageContext.request.contextPath}/vue/zpageNav.css" rel="stylesheet" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/layui/css/layui.css">
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
<div style="background-color: white;" id="tab">
    <div class="layui-card">
        <div class="layui-card-header" style="height: auto;">
            <h3 style="padding-top: 12px">请假列表</h3>
        </div>
        <div style="padding: 20px 0px;border-bottom: 1px solid #eee ">
            <select id="stateId" class="form-control" style="width: 100px;float: left;margin:0px 20px">
                <option value="-1">请选择</option>
                <option value="1">新创建</option>
                <option value="2">待审批</option>
                <option value="3">审批中</option>
                <option value="4">已审批</option>
                <option value="5">已付款</option>
                <option value="6">已打回</option>
                <option value="7">已存档</option>
                <option value="8">已通过</option>
                <option value="9">已拒绝</option>
            </select>
            <input type="button" class="btn btn-info" value="查询" @click="pageHandler(page)">
        </div>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>请假单号</th>
            <th>开始时间</th>
            <th>结束时间</th>
            <th>请假天数</th>
            <th>请假事由</th>
            <th>请假人</th>
            <th>待处理人</th>
            <th>审批状态</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <tr v-if="list.length==0">
            <td colspan="9">暂无数据</td>
        </tr>
        <tr v-for="le in list">
            <td>{{le.leaveId}}</td>
            <td>{{le.startDate}}</td>
            <td>{{le.endDate}}</td>
            <td>{{le.leaveDays}}</td>
            <td>{{le.reason}}</td>
            <td>{{le.leaveEmp.employeeName}}</td>
            <td v-if="le.disposeEmp!=null">{{le.disposeEmp.employeeName}}</td>
            <td v-if="le.disposeEmp==null">无</td>
            <td>{{le.approvalState.approvalStateName}}</td>
            <td>
                <button class="btn btn-success" v-if="le.approvalStateId==1&&le.leaveBy==${emp.employeeId}" @click="submitLeaveRecord(le.leaveId)" >提交</button>
                <a :href="'${pageContext.request.contextPath}/leaves/leave/'+le.leaveId+'/0'">
                    <button class="btn btn-info" v-if="le.approvalStateId!=1">查看</button>
                </a>
                <a :href="'${pageContext.request.contextPath}/leaves/leave/'+le.leaveId+'/1'">
                    <button class="btn btn-info" v-if="le.disposeBy==${emp.employeeId}">审批</button>
                </a>
            </td>
        </tr>
        </tbody>
    </table>
    <!-- pagination start-->
    
        <zpagenav v-bind:page="page" v-bind:page-size="pageSize" v-bind:total="total"
                  v-bind:max-page="maxPage"  v-on:pagehandler="pageHandler">
        </zpagenav>
    </div>
    <!-- pagination end-->
    </div>
</div>
</body>
</html>

<%--分页--%>
<script src="vue/vue.js"></script>
<script src="vue/zpageNav.js"></script>
<script>
    var vm = new Vue({
        el: '#tab',
        data: {
            page: 1,  //显示的是哪一页
            pageSize: 10, //每一页显示的数据条数
            total: 150, //记录总数
            maxPage:9,  //最大页数
            list:{}
        },
        methods: {
            //pagehandler方法 跳转到page页
            pageHandler: function (pageNum) {
                var stateId = $("#stateId").val();
                var url = "${pageContext.request.contextPath}/pageLeave?pageNum="+pageNum+"&stateId="+stateId
                $.getJSON(url,function (data) {
                    vm.page=data.pageNum;
                    vm.pageSize=data.pageSize
                    vm.total=data.total
                    vm.list=data.list
                    console.log(data)
                })
            },
            //提交请假信息
            submitLeaveRecord: function (leaveId) {
                var leave = {}
                leave["leaveId"] = leaveId;
                leave["approvalStateId"] = 2;//2为待审批
                $.ajax({
                    url:"${pageContext.request.contextPath}/leaves/leave",
                    type:"put",
                    data:JSON.stringify(leave),
                    dataType:"JSON",
                    contentType:"application/json",
                    success:function (data) {
                        if(data.code=="200"){
                            alert("提交成功")
                            vm.pageHandler(1)
                        }else{
                            alert(data.info)
                        }
                    }
                })
            }
        },
        created:function(){
            //created  表示页面加载完毕，立即执行
            this.pageHandler(1);
        }
    });
</script>