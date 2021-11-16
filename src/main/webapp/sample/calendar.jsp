<%@page import="java.util.Calendar"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
Calendar cal = Calendar.getInstance();
int yy = cal.get(Calendar.YEAR);
int mm = cal.get(Calendar.MONTH);
int dd = cal.get(Calendar.DATE);
%>
<%=yy%>년 <%= mm+1 %>월 <%=dd %>일

<p></p>

<%
//Math.random();
%>

<%
//기본적으로 0 < x <  1 사이의 x값 리턴
Random random = new Random();
//0~9 값을 얻기
out.print("0 ~ 9 : " + random.nextInt(10) + "<br>"  );
out.print("int : " + random.nextInt() + "<br>"  );
out.print("랜덤 boolean 얻기 : " + random.nextBoolean() + "<br>");
out.print("랜덤 long 얻기 : " + random.nextLong()+ "<br>");
out.print("랜덤 double 얻기 : " + random.nextDouble()+ "<br>");
%>
</body>
</html>