<%@page import="com.bc.mybatis.DBService"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.bc.mybatis.GuestbookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 전달받은 데이터(암호)와 DB 저장 암호 일치 여부 확인 후 처리 
	비교값: 전달받은 pwd 파라미터값과 session의 pwd 값과 비교 
	- 일치하면: DB데이터 삭제 후 목록페이지
	- 불일치하면: 이전페이지로 이동	
--%>
<%
	// 0. 한글처리를 위한 encoding 처리
	request.setCharacterEncoding("UTF-8");
	
	String pwd = request.getParameter("pwd");
	GuestbookVO vo = (GuestbookVO)session.getAttribute("guestbookVO");
	System.out.println("param pwd: " +  pwd + ", vo pwd: " + vo.getPwd());
%>
	<jsp:useBean id="guestbookVO" class="com.bc.mybatis.GuestbookVO"/>
	<jsp:setProperty property="*" name="guestbookVO"/>
<% 	
	
	// 암호 일치 여부
	if (pwd.equals(vo.getPwd())) { // 일치하면
		// (실습) 암호 일치하는 경우 - DB데이터 삭제처리 후 목록페이지로 이동
		SqlSession ss = DBService.getFactory().openSession(true);
		try{
		ss.delete("guestbook.delete", vo);
%>
	<script>
		alert("정상처리되었습니다. 목록페이지로 이동");
		location.href="list.jsp";
	</script>
<% 	
		} catch(Exception e) {
		e.printStackTrace();
%>
	<script>
		alert("[예외발생] 삭제실패!! 목록페이지로 이동");
		location.href="list.jsp";
	</script>
<% 				
		} finally {
			ss.close();
		}
	}
%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>암호불일치</title>
<script>
	alert("암호불일치, 암호를 확인하세요");
	history.back();
	
</script>
</head>
<body>

</body>
</html>