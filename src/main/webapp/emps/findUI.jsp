<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<h3>员工列表</h3>
	
	<table class="table table-hover  table-striped">
		<tr>
			<td>eid</td>
			<td>ename</td>
			<td>gender</td>
			<td>sal</td>
			<td>hiredate</td>
			<td>photo</td>
			<td>dept</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${empList }" var="e">
			<tr>
				<td>${e.eid}</td>
				<td>${e.ename}</td>
				<td>${e.gender}</td>
				<td>${e.sal}</td>
				<td>
					<fmt:formatDate value="${e.hiredate }" pattern="yyyy/MM/dd" />
				</td>
				<td>${e.photo}</td>
				<td>${ empty e.dept.dname ? '暂无部门' :  e.dept.dname }</td>
				<td>
					<a href="/emps/delete/${e.eid }">删除</a>
					|
					<a href="/emps/updateUI/${e.eid }">修改</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>