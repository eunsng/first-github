<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="kr">
 <head>
  <meta charset="UTF-8">
	<title>deptWrite</title>
  
 </head>


<body>



<div style = "width:400px; padding-top:20px; margin:0 auto;">	

	<form name ="frm" method ="post" action = "deptWriteSave.do " style ="border: 1px solid #ccc; ">
	<table>
		<tr>
			<th>부서번호</th>
			<td><input type = "text" name = "deptno"></td>
		</tr>
		<tr>
			<th>부서이름</th>
			<td><input type = "text" name = "dname"></td>
		</tr>
		<tr>
			<th>부서위치</th>
			<td><input type = "text" name = "loc"></td>
		</tr>	
		<tr>
			<th colspan ="2">
			<button type = "submit">등록</button>
			<button type = "reset">취소</button>
			</th>
		</tr>		
	</table>
	<div style ="width:400px;
				 text-align:right;	
				 margin-top :10px; ">
	<button type = "button">목록으로</button>
	</div>
	</form>
</div>





</body>
</html>
