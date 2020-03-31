<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<script>
		$(function() {
			$("select option[value='"+${emp.did}+"']").prop("selected","selected")
		});
	</script>
	<h3>修改员工</h3>
	<form action="/emps/update" method="post">
		<input type="hidden" value="${emp.eid }" name="eid" />
		姓名: <input name="ename" type="text" value="${emp.ename }" /> <br />
		性别: <input name="gender" type="radio" value="男"  ${emp.gender == '男'? 'checked':'' } />男
		    <input name="gender" type="radio" value="女"  ${emp.gender == '女'? 'checked':'' } />女
		 <br />
		月薪: <input name="sal" type="text"  value="${emp.sal }" /> <br />
		入职日期: <input name="hiredate" type="text" value="<fmt:formatDate value="${emp.hiredate }" pattern="yyyy/MM/dd"/>" /> <br />
		照片:  <input name="photo" type="file" /> <br />
		部门:  
			<select name="did">
				<c:forEach items="${deptList }" var="d">
					<option value="${d.did }">${d.dname }</option>
				</c:forEach>
			</select>
		 <br />
		<button type="submit">修改</button>
	</form>
	
	
	
	
</body>
</html>