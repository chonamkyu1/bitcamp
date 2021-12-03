<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 세션 초기화(무효화) --%>
<%
	// 세션 초기화(무효화)
	session.invalidate();

	// ex02_login.jsp 페이지로 이동(재요청처리)
	response.sendRedirect("ex02_login.jsp");
%>

