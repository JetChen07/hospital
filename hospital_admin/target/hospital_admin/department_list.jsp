<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2018/5/29
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>科室列表</title>
    <link rel="stylesheet" href="../css/index.css">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
</head>

<body>
<header>
    <div class="container">
        <c:forEach items="${CLIST}" var="depclass">
            <nav>
                <a href="" >${depclass.name}</a>
            </nav>
        </c:forEach>
        <nav>
            <a href="../depclass/list.do" >分类</a>
        </nav>

    </div>
</header>
<section class="banner">
    <div class="container">
        <div>
            <h1>科室</h1>
            <p>科室列表</p>
        </div>
    </div>
</section>
<section class="main">
    <div class="container">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>名称</th>
                <th>分类</th>
                <th>创建时间</th>
                <th>最后修改时间</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${LIST}" var="department">
                <tr>
                    <td>${department.name}</td>
                    <td>${department.did}</td>
                    <td>${department.createTime}</td>
                    <td>${department.modifyTime}</td>
                    <td>

                        <a href="toEdit.do?id=${department.id}">修改</a>&nbsp;&nbsp;
                        <a href="remove.do?id=${department.id}">删除</a>

                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</section>
<section class="page">
    <div class="container">
        <div id="fatie">
            <a href="toAdd.do"><button>新建</button></a>
        </div>
    </div>
</section>
<footer>
    copy@慕课网
</footer>
</body>
</html>
