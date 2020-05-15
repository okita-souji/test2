<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'edit.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="ctrl?action=save" method="post">
    	学号：<input type="text" name="xh" value="${stu.xh}"/><br />
    	姓名：<input type="text" name="name"  value="${stu.name}"/><br />
    	性别：<label><input type="radio" name="sex" value="男"
    	       <c:if test="${stu.sex == '男' }">checked</c:if>
    	     >男</label>    	     
    		  <label><input type="radio" name="sex" value="女"
    		  <c:if test="${stu.sex == '女' }">checked</c:if>
    		  >女</label>
    		  <input type="hidden" name="oldXh" value="${stu.xh}">
    	<button type="submit">保存</button>
    </form>
  </body>
</html>
