package com.mystudy.jdbc3_prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentManager_Delete {

	public static void main(String[] args) {
		// ID: 2021008 삭제 처리 JDBC 연동 프로그램 작성
		// JDBC 이용한 DB연동 프로그래밍 작성 절차
		// 0. JDBC 라이브러리 개발환경 설정(빌드경로에 등록)
		// 1. JDBC 드라이버 로딩
		// 2. DB 연결 - Connection 객체 생성한다 <- DriverManager
		// 3. Statement문 실행(SQL 문 실행)
		// 4. SQL 실행 결과에 대한 처리
		// - SELECT: 조회(검색) 데이터 결과 값에 대한 처리
		// - INSERT,UPDATE,DELETE: INT 값(건수) 처리
		// 5. 클로징 처리에 의한 자원 반납
		
		// ID
		Connection conn = null;
		PreparedStatement pstmt= null;
		
		try {
			// 1. JCBC 드라이버 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			
			// 2. DB 연결 - Connection 객체 생성한다 <- DriverManager
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe"
								, "mystudy", "mystudypw");
			
			
			// 3. Statement문 실행(SQL 문 실행)
			// 3-1. SQL 실행문을 위한 PrepardStatement 객체 생성
			String sql = "";
			sql += "DELETE FROM STUDENT WHERE ID = ? ";
			pstmt = conn.prepareStatement(sql);
			
			// 3-2. SQL문장의 ? 위치에 값 설정(매칭, 대입)
			String id = "2021008";
			pstmt.setString(1, id);
			
			// 3-3 SQL문 실행
			int result = pstmt.executeUpdate();
			
			// 4. SQL 실행 결과에 대한 처리
			// - SELECT: 조회(검색) 데이터 결과 값에 대한 처리
			// - INSERT,UPDATE,DELETE: INT 값(건수) 처리 
			System.out.println(">>처리건수: " +  result);
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
