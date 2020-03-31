<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>添加员工</h3>
	<form action="/emps/save" method="post">
		姓名: <input name="ename" type="text" /> <br />
		性别: <input name="gender" type="radio" value="男" checked="checked" />男
		    <input name="gender" type="radio" value="女" />女
		 <br />
		月薪: <input name="sal" type="text" /> <br />
		入职日期: <input name="hiredate" type="text" /> <br />
		照片:  <input name="photo" type="file" /> <br />
		部门:  
			<select name="did">
				<c:forEach items="${deptList }" var="d">
					<option value="${d.did }">${d.dname }</option>
				</c:forEach>
			</select>
		 <br />
		<button type="submit">添加</button>
	</form>
</body>
</html>