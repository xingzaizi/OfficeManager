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
<div style="background-color: white;" id="chart">
    <div class="layui-card">
        <div class="layui-card-header" style="height: auto;">
            <h3 style="padding-top: 12px">报销单月度统计</h3>
        </div>
        <div>
            <%-- 筛选条件 --%>
            <div class="form-group" style="padding: 10px 0px;overflow: hidden;clear: both;border-bottom: 1px solid #eee">
                <label class="control-label" style="float: left;padding: 7px 15px">年份</label>
                <select class="form-control" style="width: 100px;float: left;" id="year">
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
                <label class="control-label" style="float: left;padding: 7px 15px">开始月份</label>
                <select class="form-control" style="width: 100px;float: left;" id="startMonth">
                    <option value="-1">无</option>
                    <option value="1">1月</option>
                    <option value="2">2月</option>
                    <option value="3">3月</option>
                    <option value="4">4月</option>
                    <option value="5">5月</option>
                    <option value="6">6月</option>
                    <option value="7">7月</option>
                    <option value="8">8月</option>
                    <option value="9">9月</option>
                    <option value="10">10月</option>
                    <option value="11">11月</option>
                    <option value="12">12月</option>
                </select>
                <label class="control-label" style="float: left;padding: 7px 15px">结束月份</label>
                <select class="form-control" style="width: 100px;float: left;" id="endMonth">
                    <option value="-1">无</option>
                    <option value="1">1月</option>
                    <option value="2">2月</option>
                    <option value="3">3月</option>
                    <option value="4">4月</option>
                    <option value="5">5月</option>
                    <option value="6">6月</option>
                    <option value="7">7月</option>
                    <option value="8">8月</option>
                    <option value="9">9月</option>
                    <option value="10">10月</option>
                    <option value="11">11月</option>
                    <option value="12">12月</option>
                </select>
                <div>
                    <input type="button" value="查询" class="btn btn-info" style="margin-left: 15px" @click="pageHandler(page)">
                </div>
            </div>
            <div>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>编号</th>
                            <th>总计</th>
                            <th>年份</th>
                            <th>月份</th>
                            <c:if test="${emp.positionId!=4}">
                                <th>部门</th>
                            </c:if>

                            <th>操作</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(c,index) in list">
                            <td>{{index=index+1}}</td>
                            <td>{{c.totalMoney}}元</td>
                            <td>{{c.year}}年</td>
                            <td>{{c.month}}月</td>
                            <c:if test="${emp.positionId!=4}">
                                <td>{{c.department.departmentName}}</td>
                            </c:if>
                            <td>
                                <a :href="'${pageContext.request.contextPath}/chart/emp?year='+c.year+'&month='+c.month+'&where=byMonth'">
                                    <input type="button" value="查看" class="btn btn-info">
                                </a>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<%--分页--%>
<script src="vue/vue.js"></script>
<script src="vue/zpageNav.js"></script>
<script>
    var vm = new Vue({
        el: '#chart',
        data: {
            page: 1,  //显示的是哪一页
            pageSize: 10, //每一页显示的数据条数
            total: 150, //记录总数
            maxPage:9,  //最大页数
            list:{},
        },
        methods: {
            //pagehandler方法 跳转到page页
            pageHandler: function (pageNum) {
                var url = "${pageContext.request.contextPath}/chart/dep/?pageNum="+pageNum

                var year = $("#year").val();
                var startMonth = $("#startMonth").val();
                var endMonth = $("#endMonth").val();
                if (year!=-1){
                    url+="&year="+year
                }
                if (startMonth!=-1){
                    url+="&startMonth="+startMonth
                }
                if (endMonth!=-1){
                    url+="&endMonth="+endMonth
                }
                $.getJSON(url,function (data) {
                    vm.page=data.pageNum;
                    vm.pageSize=data.pageSize
                    vm.total=data.total
                    vm.list=data.list
                    console.log(data)
                })
            }
        },
        created:function(){
            //created  表示页面加载完毕，立即执行
            this.pageHandler(1);
        }
    });
</script>