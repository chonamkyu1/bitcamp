<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 세션 초기화(무효화) --%>
<%
  	// 세션 초기화(무효화)
  	session.invalidate();

	// 재요청처리(ex01_session.jsp 페이지로 이동)
	response.sendRedirect("ex01_session.jsp");
%>