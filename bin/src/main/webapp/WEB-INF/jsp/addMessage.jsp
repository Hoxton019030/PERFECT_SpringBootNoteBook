<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>

<jsp:include page="default/myNavBar.jsp" />

<html>
<head>
<meta charset="UTF-8">
<title>新增留言</title>
</head>

<body>
	<div class="row justify-content-center">
		<div class="col-6">
			<h1>新增留言</h1>
			<div class="container">
				<div class="card">
					<div class="card-header">新增訊息</div>
					<div class="card-body">

						<form:form action="${contextRoot}/message/add" method="post"
							modelAttribute="workMessages">
							<div class="input-group">
								<form:textarea path="text" class="form-control" />
							</div>
							<input type="submit" name="submit" value="新增訊息">
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>