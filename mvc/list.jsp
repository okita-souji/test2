<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
  	<table width="500" border="1">
  		<caption>
  			<a href="ctrl?action=add">添加</a>
  		</caption>
  		<tr>
  		  <th>学号</th>
  		  <th>姓名</th>
  		  <th>性别</th>
  		  <th>操作</th>
  		</tr>
  		<c:forEach items="${stus}" var="stu">
  			<tr>
  				<td>${stu.xh }</td>
  				<td>${stu.name }</td>
  				<td>${stu.sex }</td>
  				<td>
  				  <a href="./ctrl?action=edit&xh=${stu.xh }">编辑</a>
  				  <a href="./ctrl?action=delete&xh=${stu.xh }">删除</a>
  				</td>
  			</tr>
  			
  		</c:forEach>
  	</table>
  	
  </body>
</html>
