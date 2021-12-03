package com.mystudy.jdbc_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// DAO, dal: Data Access Object / Database Access Object 
// 데이터베이스(DB)와 연동해서 CRUD를 구현하는 클래스

public class StudentDAO {
	private static final String DRIVER = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "mystudy";
	private final String PASSWORD = "mystudypw";

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// static 초기화 구문
	static {
		// 1. JDBC 드라이버 로딩
		try {
			Class.forName(DRIVER);
			System.out.println(">> JDBC 드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("[예외발생] JDBC 드라이버 로딩 실패");
			e.printStackTrace();
		}
	}

	// SELECT: 테이블 전체 데이터 조회 - selectAll: List<StudentVO>
	// SELECT: 하나의 데이터 조회(ID) - selectOne: StudentVO
	// SELECT: 하나의 데이터 조회(VO) - selectOne: StudentVO
	// INSERT: VO 객체를 받아서 입력 - insert: int
	// UPDATE: VO 객체를 받아서 수정 - update: int
	// DELETE: VO 객체를 받아서 삭제 - delete: int
	// DELETE: 키값(ID)을 받아서 삭제 - delete: int

	// SELECT: 테이블 전체 데이터 조회 - selectAll: List<StudentVO>
	public List<StudentVO> selectAll() {
		List<StudentVO> list = null;

		try {
			// 2. DB 연결 - Connection 객체 생성하기 <- DriverManager 이욯
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			// 3. SQL문 실행
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ID, NAME, KOR, ENG, MATH, TOT, AVG ");
			sql.append(" FROM STUDENT ");
			sql.append("ORDER BY ID ");

			pstmt = conn.prepareStatement(sql.toString());

			rs = pstmt.executeQuery();

			// 4. SQL문 실행 결과에 대한 처리
			list = new ArrayList<StudentVO>();
			while (rs.next()) {
				// DB 데이터 하나를 StudentVO에 저장하고 리스트에 추가한다.
				StudentVO vo = new StudentVO(rs.getString("ID"), rs.getString("NAME"), rs.getInt("KOR"),
						rs.getInt("ENG"), rs.getInt("MATH"), rs.getInt("TOT"), rs.getDouble("AVG"));

				// 리스트에 추가한다
				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5. 사용객체 close 처리
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
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

		return list;
	}

	// SELECT: 하나의 데이터 조회(ID) - selectOne: StudentVO
	public StudentVO selectOne(String id) {
		StudentVO student = null;
		// (할일) DB연결하고 SQL문 실행해서 결과값을 vo 변수에 저장하고 리턴한다.

		try {
			// 2. DB연결 - Connection 객체 생성하기 <- DriverManager 이욯
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			// 3. SQL문 실행
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ID, NAME, KOR, ENG, MATH, TOT, AVG ");
			sql.append(" FROM STUDENT ");
			sql.append("WHERE ID = ? ");
			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			// 4. SQL 실행 결과에 대한 처리
			while (rs.next()) {
				student = new StudentVO(rs.getString("ID"), rs.getString("NAME"), rs.getInt("KOR"),
						rs.getInt("ENG"), rs.getInt("MATH"), rs.getInt("TOT"), rs.getDouble("AVG"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close(conn, pstmt, rs);
		}
		return student;
	}

	private void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
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

	// SELECT: 하나의 데이터 조회(VO) - selectOne: StudentVO
	public StudentVO selectOne(StudentVO vo) {
		StudentVO svo = null;
		try {
			// 2. DB연결 - Connection 객체 생성하기 <- DriverManager 이욯
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			// 3. SQL문 실행
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ID, NAME, KOR, ENG, MATH, TOT, AVG  " );
			sql.append("FROM STUDENT");
			sql.append("WHERE  ");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			rs = pstmt.executeQuery();
			
			
			// 4. SQL 실행결과에 대한 처리
			if (rs.next()) {
				//StudentVO vo = new StudentVO(rs.gets);
				svo = new StudentVO(rs.getString(1),
									rs.getString("NAME"),
									rs.getInt("KOR"),
									rs.getInt("ENG"),
									rs.getInt("MATH"),
									rs.getInt("TOT"),
									rs.getDouble("AVG"));

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return selectOne(vo.getId());
	}

	// SELECT: 이름으로 데이터 조회(name) - selectList: List<StudentVO>

	// INSERT: VO 객체를 받아서 입력 - insert: int
	public int insert(StudentVO vo) {
		int result = 0;

		try {
			// 2. DB연결 - Connection 객체 생성하기 <- DriverManager 이욯
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			// 3. SQL문 실행
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO STUDENT");
			sql.append(" (ID, NAME, KOR, ENG, MATH, TOT, AVG) ");
			sql.append("VALUES (?, ?, ?, ?, ?, ?, ?) ");
			pstmt = conn.prepareStatement(sql.toString());

			// ? 값 설정
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getName());
			pstmt.setInt(3, vo.getKor());
			pstmt.setInt(4, vo.getEng());
			pstmt.setInt(5, vo.getMath());
			pstmt.setInt(6, vo.getTot());
			pstmt.setDouble(7, vo.getAvg());

			// SQL 실행
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}

		return result;
	}

	private void close(Connection conn, PreparedStatement pstmt) {

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

	// UPDATE: VO 객체를 받아서 수정 - update: int
	// 국어, 영어, 수학, 총점, 평균 수정 처리
	public int update(StudentVO vo) {
		int result = 0;
		try {
			// 2. DB연결 - Connection 객체 생성하기 <- DriverManager 이욯
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			// 3. SQL문 실행
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE STUDENT");
			sql.append(" SET KOR = ? ");
			sql.append("   , ENG = ?  ");
			sql.append("   , MATH = ?  ");
			sql.append("   , TOT = ?  ");
			sql.append("   , AVG = ?  ");
			sql.append(" WHERE ID = ? ");

			pstmt = conn.prepareStatement(sql.toString());

			// 값 설정
			int idx = 1;
			pstmt.setInt(idx++, vo.getKor());
			pstmt.setInt(idx++, vo.getEng());
			pstmt.setInt(idx++, vo.getMath());
			pstmt.setInt(idx++, vo.getTot());
			pstmt.setDouble(idx++, vo.getAvg());
			pstmt.setString(idx++, vo.getId());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}

		return result;
	}

	// UPDATE: 이름 수정(id, name) - update : int

	// DELETE: VO 객체를 받아서 삭제 - delete: int
	// DELETE: 키값(ID)을 받아서 삭제 - delete: int
	public int delete(String id) {
		int result = 0;
		try {
			// 2. DB연결 - Connection 객체 생성하기 <- DriverManager 이욯
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			// 3. SQL문장
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM STUDENT WHERE ID = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			
			// ? 값 설정
			pstmt.setString(1, id);
		
			// 4. 결과 추출
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
		
		
		return result;
	}
}
