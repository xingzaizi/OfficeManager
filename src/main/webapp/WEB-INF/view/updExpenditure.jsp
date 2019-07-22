<%@ page import="cn.hutool.core.date.DateUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <title>Title</title>
    <link rel="stylesheet" href=<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/layui/css/layui.css">
    <script src="<%=request.getContextPath()%>/js/jquery-2.0.3.min.js"></script>
    <script src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/vue/vue.js"></script>
    <script src="<%=request.getContextPath()%>/layui/layui.js"></script>
    <style>
        td {
            margin-right: 50px;
        }
    </style>
</head>
<body style="background-color: #eee">
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
<div style="padding: 0px 20%;margin-bottom: 40px" id="zt">
    <%-- 面包屑 --%>
    <ul class="breadcrumb">
        <li><a href="${pageContext.request.contextPath}/expenditureShow">报销管理</a></li>
        <li class="active">查看报销信息</li>
    </ul>
    <form class="form-horizontal layui-card" role="form" style="padding: 5px">
        <h3 style="margin: 0px;margin-bottom:20px;padding: 10px 0px 10px 20px;border-bottom: 1px solid #eee">基本信息</h3>
        <div class="form-group">
            <label class="col-sm-1 control-label">姓名</label>
            <div class="col-sm-2">
                <input type="text" class="form-control" style="background-color: white" value="${data.createEmp.employeeName}" readonly="readonly">
            </div>
            <label class="col-sm-1 control-label">部门</label>
            <div class="col-sm-2">
                <input type="text" class="form-control" style="background-color: white" value="${data.createEmp.department.departmentName}" readonly="readonly">
            </div>
            <label class="col-sm-1 control-label">职位</label>
            <div class="col-sm-2">
                <input type="text" class="form-control" style="background-color: white" value="${data.createEmp.position.positionName}" readonly="readonly">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-1 control-label">总金额</label>
            <div class="col-sm-2">
                <input type="text" class="form-control" style="background-color: white" value="${data.totalMoney}" readonly="readonly" id="je">
            </div>
            <label class="col-sm-1 control-label">填报时间</label>
            <div class="col-sm-2">
                <input type="text" class="form-control" style="background-color: white" value="<%=DateUtil.now()%>" readonly="readonly">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-1 control-label">报销事由</label>
            <div class="col-sm-5">
                <textarea v-model="Expenditure.reason" type="text" class="form-control" name="reason" style="background-color: white;font-size: 20px;resize: none;height: 100px;width: 555px"></textarea>
            </div>
        </div>
    </form>
    <div class="layui-card" style="padding: 5px">
        <h3 style="margin: 0px;margin-bottom:20px;padding: 10px 0px 10px 20px;border-bottom: 1px solid #eee">报销明细</h3>
        <table class="table table-striped" style="width: 98%;margin: 0px 10px">
            <thead>
            <tr>
                <th>项目说明</th>
                <th>项目金额</th>
                <th>凭据截图</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${data.expenditureDetails}" var="i">
                <tr>
                    <td>${i.comment}</td>
                    <td>${i.money}</td>
                    <td><img src='<%=request.getContextPath()%>/static/${i.proveImage}' style='width: 60px;height: 80px;'></td>
                    <td>
                        <button type="button" class="layui-btn layui-btn-primary layui-btn-sm"
                                onclick="del(${i.expenditureDetailId},${i.money},${i.expenditureId})"><i class="layui-icon">&#x1006;</i></button>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td><input type="text" name="smm" autocomplete="off"></td>
                <td><input type="text" name="monii" required lay-verify="required"></td>
                <td><input type="file" name="tp" autocomplete="off"></td>
                <td>
                    <button type="button" class="layui-btn layui-btn-primary layui-btn-sm"
                            onclick="add(this)"><i class="layui-icon">&#xe654;</i></button>
                </td>
            </tr>
            </tbody>
        </table>
        <div style="border-top: 1px solid #eee;padding: 10px 0px;">
            <button type="button" class="btn btn-success" onclick="updExpenditure(-1)">保存</button>
            <button type="button" class="btn btn-success" onclick="updExpenditure(2)">提交</button>
            <button type="button" class="btn btn-warning"
                    onclick="location.href='<%=request.getContextPath()%>/expenditureShow'">返回
            </button>
        </div>

    </div>
    <div class="layui-card" style="padding: 5px">
        <h3 style="margin: 0px;padding: 10px 0px 10px 20px;border-bottom: 1px solid #eee">审查记录</h3>
        <table class="table table-striped" style="margin-bottom: 0px">
            <tr>
                <td>审查人</td>
                <td>审查意见</td>
                <td>审查时间</td>
                <td>审查结果</td>
            </tr>
            <c:if test="${data.reviewRecords.size()==0}">
                <tr>
                    <td colspan="4">暂无审查记录</td>
                </tr>
            </c:if>
            <c:forEach var="i" items="${data.reviewRecords}">
                <tr>
                    <td style="width: 200px;">${i.employee.employeeName}</td>
                    <td style="width: 200px;">${i.reviewIdea}</td>
                    <td style="width: 200px;"><fmt:formatDate value="${i.reviewDate}"
                                                              pattern="yyyy-MM-dd"></fmt:formatDate></td>
                    <td style="width: 200px;">${i.reviewState.reviewStateResult}</td>
                </tr>
            </c:forEach>
        </table>
        <div style="border-top: 1px solid #eee;padding: 10px 0px;">
            <c:if test="${cz eq 'ck'}">
                <button type="button" class="btn btn-info"
                        onclick="location.href='<%=request.getContextPath()%>/expenditureShow'">返回
                </button>
            </c:if>
            <c:if test="${cz eq 'sp'}">
                审批意见:<textarea name="reason" placeholder="请输入" class="layui-textarea" v-model="reviewrecord.reviewIdea"></textarea>
                <c:if test="${emp.positionId==6}">
                    <button type="button" class="layui-btn layui-btn-normal" @click="tj(1)">打钱</button>
                </c:if>
                <c:if test="${emp.positionId!=6}">
                    <button type="button" class="layui-btn layui-btn-normal" @click="tj(1)">审批通过</button>
                    <button type="button" class="layui-btn layui-btn-warm"  @click="tj(2)">打回</button>
                    <button type="button" class="layui-btn layui-btn-danger"  @click="tj(3)">审批拒绝</button>
                </c:if>

                <script>
                    var vue = new Vue({
                        el: "#main",
                        data: {
                            reviewrecord: {reviewIdea: "", reviewStateId: "", orderId: "${data.expenditureId}"}
                        },
                        methods: {
                            tj: function (yj) {
                                vue._data.reviewrecord.reviewStateId=yj
                                $.ajax({
                                    type: "POST",
                                    url: "<%=request.getContextPath()%>/addExamination",
                                    contentType: "application/json", //必须有
                                    dataType: "json", //表示返回值类型
                                    data: JSON.stringify(vue._data.reviewrecord),
                                    success: function (data) {
                                        if(data.code==200){
                                            location.href="<%=request.getContextPath()%>/expenditureShow"
                                        }
                                        alert(data.msg)
                                    }
                                })
                            }
                        }
                    })
                </script>
            </c:if>
        </div>
    </div>
</div>












</body>
<script>
    var vue = new Vue({
        el: "#zt",
        data: {
            Expenditure: {totalMoney: 0, reason: "${data.reason}", approvalStateId: 0}
        }
    })

    var urlk = ''
    $("[name=tp]").change(function () {
        var url = window.webkitURL.createObjectURL(this.files[0])
        urlk = url
    })


    //添加节点
    function add(th) {
        var formData = new FormData();
        formData.append('file', $('[name=tp]')[0].files[0]);  //添加图片信息的参数
        $.ajax({
            type: "POST",
            url: "<%=request.getContextPath()%>/fielUpload",
            data: formData,
            cache: false, //上传文件不需要缓存
            processData: false,// 告诉jQuery不要去处理发送的数据
            contentType: false,// 告诉jQuery不要去设置Content-Type请求头
            encType: "multipart/form-data",
            async:true,
            success: function (data) {
                if (data.code == 200) {
                    saveExdetail(data.msg,th)
                }
            }
        });
    }

    function saveExdetail(tp,th) {
        var sm = $("[name=smm]").val()
        var je = $("[name=monii]").val()
        $(th).parent().parent().before("<tr><td>" + sm + "</td><td>" + je + "</td><td><img src='" + urlk + "' style='width: 60px;height: 80px;'></td><td><button type=\"button\" class=\"layui-btn layui-btn-primary layui-btn-sm\"\n" +
            "onclick=\"del(this)\"><i class=\"layui-icon\">&#x1006;</i></button></td></tr>")
        $.getJSON("<%=request.getContextPath()%>/addDetail",{comment: sm, money: je,orderId:"${data.expenditureId}",proveImage:tp},function (data) {
            if(data.code==200){
                location.reload()
            }
        })
        $("[name=smm]").val("")
        $("[name=monii]").val("")
        $("[name=tp]").val("")
    }


    //删除节点
    function del(id,money,order) {
        $.getJSON("<%=request.getContextPath()%>/delDetail",{id:id,money:money,order:order},function (data) {
            if(data.code==200){
                location.reload()
            }
            alert(data.msg)
        })
    }

    function updExpenditure(status) {
        var reason = $("[name=reason]").val()
        $.ajax({
            type: "POST",
            url: "<%=request.getContextPath()%>/updExpenditure",
            dataType: "json", //表示返回值类型
            data: {orderId:"${data.expenditureId}",reason:reason,status:status},
            success: function (data) {
                if(data.code==200){
                    location.href="<%=request.getContextPath()%>/expenditureShow"
                }
                alert(data.msg)
            }
        })
    }

    //计算总金额
    /*    function jeShow() {
            var sum = 0.0;
            $.each(vue._data.Expenditure.expenditureDetails, function (i, item) {
                sum += parseFloat(item.money)
            })
            $("#je").html(sum)
            vue._data.Expenditure.totalMoney = sum
        }*/
</script>
</html>
