<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<h3>部门列表</h3>
	
	<table class="table table-hover  table-striped">
		<tr>
			<td>did</td>
			<td>dname</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${page.list }" var="d">
			<tr>
				<td>${d.did }</td>
				<td>${d.dname }</td>
				<td>
					<a href="/depts/delete/${d.did }">删除</a>
					|
					<a href="/depts/updateUI/${d.did }">修改</a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="3">
				${page.p }/${page.maxPage }
				
				<a href="/depts/find?p=1">首页</a>
				<a href="/depts/find?p=${page.prev }">上一页</a>
				<c:forEach begin="${page.startPage }" end="${page.endPage }" var="x">
					<c:if test="${x == page.p }">
						<font color="red">
							${x }
						</font>
					</c:if>
					<c:if test="${x != page.p }">
						<a href="/depts/find?p=${x }">${x }</a>
					</c:if>
				</c:forEach>
				<a href="/depts/find?p=${page.next }">下一页</a>
				<a href="/depts/find?p=${page.maxPage }">末页</a>
				跳到第
				<form style="display:inline;" action="/depts/find">
					<input type="text" size="1" name="p"  />	
					<button type="submit">GO</button>
				</form>
				页
			</td>
		</tr>
	</table>
</body>
</html>