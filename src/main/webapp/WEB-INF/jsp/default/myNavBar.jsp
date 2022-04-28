<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>
<link href="${contextRoot}/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="${contextRoot}/">超級留言板</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="${contextRoot}/">首頁 <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${contextRoot}/about">關於</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${contextRoot}/message/add">留言板</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">另一個選單</a>
      </li>
    </ul>
  </div>
</nav>

<script src="${contextRoot}/js/jquery-3.6.0.min.js" type="text/javascript"></script>
<script src="${contextRoot}/js/bootstrap.bundle.min.js" type="text/javascript"></script>
</body>
</html>