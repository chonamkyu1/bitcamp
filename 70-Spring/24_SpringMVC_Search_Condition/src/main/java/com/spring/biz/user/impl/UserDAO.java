package com.spring.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.spring.biz.board.BoardVO;
import com.spring.biz.common.JDBCUtil;
import com.spring.biz.user.UserVO;

@Repository
public class UserDAO {
	// JDBC 관련 변수(필드)
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	// SQL문
	private final String USER_GET
		= "SELECT * FROM USERS WHERE ID = ? AND PASSWORD = ? ";
	
	public UserDAO() {
		System.out.println(">> UserDAO 객체생성");
	}
	
	public UserVO getUser(UserVO vo) {
		System.out.println(">> JDBC로 GetUser() 실행");
		UserVO user = null;
		
		BoardVO board = new BoardVO();
		
		try {
			conn = JDBCUtil.getConnection();
			//stmt.setInt(1, vo.getSeq());
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			
			rs = stmt.executeQuery();
			if(rs.next()) {
				user = new UserVO( // VO에 객체 저장
						rs.getString("ID"),
						rs.getString("PASSWORD"),
						rs.getString("NAME"),
						rs.getString("ROLE"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, rs);
		}

		return user;
	}

}
