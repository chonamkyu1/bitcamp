package com.mystudy.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentManager_Update {

	public static void main(String[] args) {
		// JDBC 이용한 DB연동 프로그래밍 작성 절차
		// 0. JDBC 라이브러리 개발환경 설정(빌드경로에 등록)
		// 1. JDBC 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println(">> 드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			System.out.println(">>[예외발생] 드라이버 로딩 실패!!");
			e.printStackTrace();
		}
		// 2. DB연결 - Connection 객체 생성 <- DriverManager
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdb" + "c:oracle:thin:@localhost:1521:xe", "mystudy", "mystudypw");
			System.out.println(">> DB연결 성공");
		} catch (SQLException e) {
			System.out.println("[예외발생] DB연결 실패!!!");
			e.printStackTrace();
		}
		// 3. Statement 문 실행(SQL 문 실행)
		Statement stmt = null;
		try {
			// 3-1. Connection 객체로부터 Statement 객체 생성  
			stmt = conn.createStatement();
			// 수정처리: 김유신2(2021004)의 점수 수정
			// 국어: 95, 영어: 85, 수학: 75로 수정
			// 3-2. SQL문 작성
			String sql = "";
			sql += "UPDATE STUDENT";
			sql += "   SET KOR = 90, ENG = 80, MATH = 70 ";
			//sql += " WHERE ID = '2021004' ";
			//sql += " WHERE NAME = '김유신2' ";
			sql += " WHERE NAME LIKE '김유신%' ";
			
			// SELECT: executeQuery(sql)
			// INSERT, UPDATE, DELETE:executeUpdate(sql)
			// 3-3. SQL 실행처리
			int result = stmt.executeUpdate(sql);

			// 4. SQL 실행 결과에 대한 처리
			// - SELECT: 조회(검색) 데이터 결과 값에 대한 처리
			// - INSERT, UPDATE, DELETE: INT 값(건수) 처리
			System.out.println("처리건수: " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 5. 클로징 처리에 의한 자원 반납
		if (stmt != null) {
			try {
				stmt.close();
				System.out.println(">> Statemet 객체 close");
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		if (conn != null) {
			try {
				conn.close();
				System.out.println(">> Connection 객체 close");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
