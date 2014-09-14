<%@page import="java.util.*"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Server Details</title>
</head>
<body>
<table border="1">
<tr><td><b>Env Names</b></td>
<td><b>Env Values</b></td></tr>
<%
Map<String, String> env = System.getenv();
Set<Map.Entry<String, String>> entrySet = env.entrySet();
for (Map.Entry<String, String> entry : entrySet) {
 String pname = entry.getKey();
 String pvalue = entry.getValue();
%>
<tr>
<td><%= pname %></td>
<td><%= pvalue %></td>
</tr>
<%}%>
</table>
<hr>
<table border="1">
<tr><td><b>Property Names</b></td>
<td><b>Property Values</b></td></tr>
<%
Properties prop = System.getProperties();
Set<Map.Entry<Object, Object>> entrySet1 = prop.entrySet();
for (Map.Entry<Object, Object> entry : entrySet1) {
 String pname = (String)entry.getKey();
 String pvalue = (String) entry.getValue();
%>
<tr>
<td><%= pname %></td>
<td><%= pvalue %></td>
</tr>
<% } %>


</body>
</html>