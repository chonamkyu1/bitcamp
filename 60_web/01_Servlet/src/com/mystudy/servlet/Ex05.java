package com.mystudy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sungjuk")
public class Ex05 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// (실습) 전달받는 데이터를 연산처리 후 결과를 응답
		// 1. 전달받은 데이터(파라미터) 값 추출
		// 2. 연산처리(총점, 평균 구하기)
		// 3. 응답처리(브라우저 쪽으로 - HTML 태그 작성)
		
		// 1. 전달받은 데이터(파라미터) 값 추출
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int math = Integer.parseInt(request.getParameter("math"));
		System.out.println("name: " + name);
		System.out.println("kor: " + kor);
		System.out.println("eng: "  + eng);
		System.out.println("math: " + math);
		
		// 2. 연산처리(총점, 평균 구하기)
		int tot = kor + eng + math;
		double avg = tot * 100 / 3 / 100.0;
		System.out.println("tot: " + tot);
		System.out.println("avg: " + avg);
		
		// 3. 응답처리(브라우저 쪽으로 - HTML 태그 작성)		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println("<h3>성적처리결과</h3>");
		out.println("<p>이름: " + name + "</p>");
		out.println("<p>국어: " + kor + "</p>");
		out.println("<p>영어: " + eng + "</p>");
		out.println("<p>수학: " + math + "</p>");
		out.println("<p>총점: " + tot + "</p>");
		out.println("<p>평균: " + avg + "</p>");
		out.println("<hr><hr>");
	}

}
