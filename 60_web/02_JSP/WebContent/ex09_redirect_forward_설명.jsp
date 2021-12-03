<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 리다이렉트(redirect), 포워딩(forward)
1. 리다이렉트(redirect): response.sendRedirect("이동위치")
	단순한 페이지 전환(새로운 페이지 다시 요청하도록)
	-> request, response 객체가 다시 생성된다.
	-> 최초 요청시 요청 파라미터 값을 전달 할 수 없다.
	-> 요청 URL이 변경된다.

2. 포워당(forward): 전달(또는 위임)의 개념
	1) RequestDispatcher rd = request.getRequestDispatcher("이동위치");
	   rd.forward(request, response);
 	2) request.getRequestDispatcher("이동위치").forward(request, response);
 	-> 최초요청 request, response 객체를 전달 할 수 있다.
 	-> 최초 요청시 전달된 파라미터 값 전달 가능하다.(위임 받은 곳에서 사용 가능하다)
 	-> 요청 URL 변경이 없다.(최초 요청 주소 그대로 표시된다.) 
 --%>
