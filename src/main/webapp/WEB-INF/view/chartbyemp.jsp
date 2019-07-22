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
            <c:if test="${where=='byMonth'}">
                <h3 style="padding-top: 12px">报销月度统计</h3>
            </c:if>
            <c:if test="${where=='byYear'}">
                <h3 style="padding-top: 12px">报销年度统计</h3>
            </c:if>
        </div>
        <div>
            <%-- 筛选条件 --%>
            <div class="form-group" style="padding: 10px 0px;overflow: hidden;clear: both;border-bottom: 1px solid #eee">
                <div style="float: left;padding: 7px 15px">
                    <c:if test="${where=='byMonth'}">
                        <span>年份:<span id="year"><b>${exVoEmp.get(0).year}</b></span></span>
                        <span>月份:<span id="month"><b>${exVoEmp.get(0).month}</b></span></span>
                    </c:if>
                    <c:if test="${where=='byYear'}">
                        <span>年份:<span id="year"><b>${exVoEmp.get(0).year}</b></span></span>
                    </c:if>

                </div>

                <div style="float: left;">
                    <a href="${pageContext.request.contextPath}/excel/saveEmp?year=${exVoEmp.get(0).year}&month=${exVoEmp.get(0).month}&depId=${exVoEmp.get(0).department.departmentId}&fangfa=${fangfa}&where=${where}">
                        <input type="button" value="导出报表" class="btn btn-info" style="margin-left: 15px">
                    </a>
                </div>
            </div>
            <div>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <c:if test="${where=='byMonth'}">
                            <th>编号</th>
                            <th>报销人</th>
                            <th>报销总额</th>
                            <th>年份</th>
                            <th>月份</th>
                            <th>部门</th>
                        </c:if>
                        <c:if test="${where=='byYear'}">
                            <th>编号</th>
                            <th>报销人</th>
                            <th>报销总额</th>
                            <th>年份</th>
                        </c:if>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${where=='byMonth'}">
                        <c:forEach items="${exVoEmp}" var="voEmp" varStatus="i">
                            <tr>
                                <td>${i.count}</td>
                                <td>${voEmp.empName}</td>
                                <td>${voEmp.totalMoney}元</td>
                                <td>${voEmp.year}年</td>
                                <td>${voEmp.month}月</td>
                                <td>${voEmp.department.departmentName}</td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td></td>
                            <td>总计</td>
                            <td>{{totalMoney}}元</td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                    </c:if>
                    <c:if test="${where=='byYear'}">
                        <c:forEach items="${exVoEmp}" var="voEmp" varStatus="i">
                            <tr>
                                <td>${i.count}</td>
                                <td>${voEmp.empName}</td>
                                <td>${voEmp.totalMoney}元</td>
                                <td>${voEmp.year}年</td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td></td>
                            <td>总计</td>
                            <td>{{totalMoney}}元</td>
                            <td></td>
                        </tr>
                    </c:if>

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
<script>
    var vm = new Vue({
        el: '#chart',
        data: {
            totalMoney:0
        },
        created:function(){
            var sum = 0;
            //created  表示页面加载完毕，立即执行
            <c:forEach items="${exVoEmp}" var="dx">
            sum+=${dx.totalMoney}
                </c:forEach>
                this.totalMoney=sum;
        }
    });
    $(function () {
        initPieChart();//初始化饼图
        initOtherChart();//初始化其他类型的统计图
    })
    //饼图
    function initPieChart() {
        //统计图
        var names = new Array();
        var nums = new Array();
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('pie'));
        // 指定图表的配置项和数据
        //created  表示页面加载完毕，立即执行
        <c:forEach items="${exVoEmp}" var="dx">
        names.push("${dx.empName}")
        nums.push(${dx.totalMoney})
        </c:forEach>
        option = {
            title : {
                <c:if test="${where=='byMonth'}">
                    text: '${exVoEmp.get(0).year}年${exVoEmp.get(0).month}月${exVoEmp.get(0).department.departmentName}月度报销统计图',
                </c:if>
                <c:if test="${where=='byYear'}">
                    text: '${exVoEmp.get(0).year}年${exVoEmp.get(0).department.departmentName}年度报销统计图',
                </c:if>

                x:'center'
            },
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                left: 'right',
                data: names
            },
            series : [
                {
                    name: '报销总额',
                    type: 'pie',
                    radius : '55%',
                    center: ['50%', '60%'],
                    data:[
                        <c:forEach items="${exVoEmp}" var="dx">
                        {value:${dx.totalMoney}, name:'${dx.empName}'},
                        </c:forEach>
                    ],
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    }
    //初始化柱状、线性统计图
    function initOtherChart() {
        //统计图
        var names = new Array();
        var nums = new Array();
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));
        // 指定图表的配置项和数据
        //created  表示页面加载完毕，立即执行
        <c:forEach items="${exVoEmp}" var="dx">
            names.push("${dx.empName}")
            nums.push(${dx.totalMoney})
        </c:forEach>
        option = {
            title : {
                <c:if test="${where=='byMonth'}">
                text: '${exVoEmp.get(0).year}年${exVoEmp.get(0).month}月${exVoEmp.get(0).department.departmentName}月度报销统计图',
                </c:if>
                <c:if test="${where=='byYear'}">
                text: '${exVoEmp.get(0).year}年${exVoEmp.get(0).department.departmentName}年度报销统计图',
                </c:if>
            },
            tooltip : {
                trigger: 'axis'
            },
            legend: {
                data:['报销总额']
            },
            toolbox: {
                show : true,
                feature : {
                    dataView : {show: true, readOnly: false},
                    magicType : {show: true, type: ['line', 'bar']},
                    restore : {show: true},
                    saveAsImage : {show: true}
                }
            },
            calculable : true,
            xAxis : [
                {
                    type : 'category',
                    data : names,
                }
            ],
            yAxis : [
                {
                    type : 'value'
                }
            ],
            series : [
                {
                    name:'报销总额',
                    type:'bar',
                    data:nums,
                    markPoint : {
                        data : [
                            {type : 'max', name: '最大值'},
                            {type : 'min', name: '最小值'}
                        ]
                    },
                    markLine : {
                        data : [
                            {type : 'average', name: '平均值'}
                        ]
                    }
                }
            ]
        };
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    }
</script>