package com.mystudy.jdbc3_prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentManager_Select {

	public static void main(String[] args) {
		// JDBC 이용한 DB연동 프로그래밍 작성 절차
		// 0. JDBC 라이브러리 개발환경 설정(빌드경로에 등록)
		// 1. JDBC 드라이버 로딩
		// 2. DB연결 - Connection 객체 생성 <- DriverManager
		// 3. Statement 문 실행(SQL 문 실행)
		// 4. SQL 실행 결과에 대한 처리
		// - SELECT: 조회(검색) 데이터 결과 값에 대한 처리
		// - INSERT, UPDATE, DELETE: INT 값(건수) 처리
		// 5. 클로징 처리에 의한 자원 반납

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1. JDBC 드라이버 로딩
			Class.forName("oracle.jdbc.OracleDriver");

			// 2. DB연결 - Connection 객체 생성 <- DriverManager
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "mystudy", "mystudypw");
		
			// 3. Statement 문 실행(SQL 문 실행)
			String sql = "";
			sql += "SELECT ID, NAME, KOR, ENG, MATH, TOT, AVG ";
			sql += " FROM STUDENT ";
			sql += " WHERE ID = ? ";
			// 3-1 Connection 객체로부터 PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// 3.2 ?(바인트변수) 위치에 값 대입
			String id = "2021008";
			pstmt.setString(1, id);
			// 3.3 Statement(PreparedStatement) 실행
			rs = pstmt.executeQuery();

			conn.prepareStatement(sql);

			// 4. SQL 실행 결과에 대한 처리
			// - SELECT: 조회(검색) 데이터 결과 값에 대한 처리
			while (rs.next()) {
				String str = "";
				str += rs.getString("ID") + "\t";
				str += rs.getString("NAME") + "\t";
				str += rs.getInt("KOR") + "\t";
				str += rs.getInt("ENG") + "\t";
				str += rs.getInt("MATH") + "\t";
				str += rs.getInt("TOT") + "\t";
				str += rs.getDouble("AVG") + "\t";

				System.out.println(str);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
			if(pstmt != null) {
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
