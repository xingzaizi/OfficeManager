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
    <link rel="stylesheet" href=<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/layui/css/layui.css">
    <script src="<%=request.getContextPath()%>/js/jquery-2.0.3.min.js"></script>
    <script src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/vue/vue.js"></script>
    <script src="<%=request.getContextPath()%>/layui/layui.js"></script>
    <link href="${pageContext.request.contextPath}/vue/zpageNav.css" rel="stylesheet" />
    <script src="vue/zpageNav.js"></script>
</head>
<body style="background: #eeeeee">
<nav class="navbar navbar-default" role="navigation" >
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/index">办公管理系统</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li class="dropdown active">
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
<%--主体--%>
<div>
    <div class="layui-card" id="tab">
        <div class="layui-card-header" style="height: auto;">
            <h3 style="padding-top: 12px">报销单列表</h3>
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
        <table class="table table-hover" >
            <thead>
            <tr>
                <th>编号</th>
                <th>填报日期</th>
                <th>填报人</th>
                <th>总金额</th>
                <th>状态</th>
                <th>待处理人</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="i in list">
                <td>{{i.expenditureId}}</td>
                <td>{{i.createDate}}</td>
                <td>{{i.createEmp.employeeName}}</td>
                <td>{{i.totalMoney}}</td>
                <td>{{i.approvalState.approvalStateName}}</td>
                <template v-if="i.disposeBy==0">
                    <td>无</td>
                </template>
                <td v-if="i.disposeBy!=0">{{i.disposeEmp.employeeName}}</td>
                <td>
                    <%--提交按钮--%>
                    <input type="button" class="btn btn-success" value="提交" v-if="i.approvalStateId==1 && i.createBy==${emp.employeeId}" onclick="sub(this)">
                    <%--审核按钮--%>
                    <input type="button" class="btn btn-info" value="审核" v-if="i.disposeBy==${emp.employeeId} && i.approvalStateId==2 ||i.disposeBy==${emp.employeeId} && i.approvalStateId==3 " onclick="look(this,'sp')">
                    <%--删除按钮--%>
                    <input type="button" class="btn btn-danger" value="删除" v-if="i.approvalStateId==1 && i.createBy==${emp.employeeId}" onclick="del(this)">
                    <%--修改按钮--%>
                    <input type="button" class="btn btn-info" value="修改" v-if="i.approvalStateId==1&& i.createBy==${emp.employeeId} ||  i.createBy==${emp.employeeId}&&i.approvalStateId==6" onclick="xg(this)">
                    <%--查询anniu--%>
                    <input type="button" class="btn btn-info" value="查看" onclick="look(this,'ck')">
                </td>
            </tr>
            </tbody>
        </table>
        <!-- pagination start-->
        <div class="wrap" >
            <zpagenav v-bind:page="page" v-bind:page-size="pageSize" v-bind:total="total"
                      v-bind:max-page="maxPage"  v-on:pagehandler="pageHandler">
            </zpagenav>
        </div>
        <!-- pagination end-->
    </div>
</div>
<script>
    function xg(th) {
        var id = $(th).parent().parent().find(":first").html()
        location.href="<%=request.getContextPath()%>/ex/"+id
    }
    //提交
    function sub(th) {
        if (confirm('你确定要提交吗?')) {
            var id = $(th).parent().parent().find(":first").html()
            var moni = $(th).parent().parent().find("td:eq(3)").html()

            $.getJSON("<%=request.getContextPath()%>/submit", {id: id,moni:moni}, function (data) {
                if (data.code == 200) {
                    location.href="<%=request.getContextPath()%>/expenditureShow"
                }
                alert(data.msg)
            })
        }
    }

    function del(th) {
        if (confirm('你确定要删除吗?')) {
            var id = $(th).parent().parent().find(":first").html()
            $.getJSON("<%=request.getContextPath()%>/delExpenditure", {id: id}, function (data) {
                if (data.code == 200) {
                    $(th).parent().parent().remove()
                }
                alert(data.msg)
            })
        }
    }

    function look(th, cz) {
        var id = $(th).parent().parent().find(":first").html()
        location.href = "<%=request.getContextPath()%>/getExpenditureInfo/" + id + "/" + cz
    }


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
                $.post("<%=request.getContextPath()%>/findExpenditure", {page: pageNum,stateId:stateId}, function (data) {
                    vm.page=data.pageNum;
                    vm.pageSize=data.pageSize
                    vm.total=data.total
                    vm.list=data.list
                })
            }
        },
        created:function(){
            //created  表示页面加载完毕，立即执行
            this.pageHandler(1);
        }
    });
</script>
</body>
</html>
