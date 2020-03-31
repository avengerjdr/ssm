<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row" style="height: 700px;">
			<div class="col-md-2">
				<ul>
					<li>
						部门管理
						<ul>
							<li><a href="/depts/find" target="mainFrame">查看部门</a></li>
							<li><a href="/depts/saveUI.jsp" target="mainFrame">添加部门</a></li>
						</ul>
					</li>
					<li>
						员工管理
						<ul>
							<li><a href="/emps/find" target="mainFrame">查看员工</a></li>
							<li><a href="/emps/saveUI" target="mainFrame">添加员工</a></li>
						</ul>  
					</li>
				</ul>
			</div>
			<div class="col-md-10">
				<iframe name="mainFrame" width="100%" height="100%"></iframe>
			</div>
		</div>
	</div>
</body>
</html>