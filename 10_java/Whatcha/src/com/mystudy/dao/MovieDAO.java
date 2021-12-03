package com.mystudy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mystudy.util.CommonUtil;
import com.mystudy.vo.MovieVO;

public class MovieDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	// 전체리스트
	// 개별리스트
	// 수정
	// 업데이트
	// 삭제

	public List<MovieVO> selectAll() {
		List<MovieVO> list = null;
		try {
			conn = CommonUtil.getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT MOVIE_ID, TITLE, STORY, GRADE, OPENYEAR, CAMEO, DIRECTOR, CATEGORY, GENRE ");
			sql.append(" FROM MOVIE ");
			sql.append(" ORDER BY MOVIE_ID ");

			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
		
			list = new ArrayList<MovieVO>();
			while (rs.next()) {
				MovieVO vo = new MovieVO(rs.getInt("MOVIE_ID"), rs.getString("TITLE"), rs.getString("STORY"),
						rs.getString("GRADE"), rs.getString("OPENYEAR"), rs.getString("CAMEO"),
						rs.getString("DIRECTOR"), rs.getString("CATEGORY"), rs.getString("GENRE"));
				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CommonUtil.close(conn, pstmt, rs);
		}
		return list;
	}

	public MovieVO selectOne(int movieId) {
		MovieVO vo = null;
		try {
			conn = CommonUtil.getConnection();

			StringBuilder sql = new StringBuilder(); 
			sql.append("SELECT MOVIE_ID, TITLE, STORY, GRADE, OPENYEAR, CAMEO, DIRECTOR, CATEGORY, GENRE ");
			sql.append("FROM MOVIE ");
			sql.append("WHERE MOVIE_ID = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, movieId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo = new MovieVO(rs.getInt("MOVIE_ID"), rs.getString("TITLE"), rs.getString("STORY"),
						rs.getString("GRADE"), rs.getString("OPENYEAR"), rs.getString("CAMEO"),
						rs.getString("DIRECTOR"), rs.getString("CATEGORY"), rs.getString("GENRE"));
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CommonUtil.close(conn, pstmt, rs);
		}
		return vo;
	}

	public int insert(MovieVO vo) {
		int result = 0;

		try {
			conn = CommonUtil.getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO MOVIE ");
			sql.append("	(MOVIE_ID, TITLE, STORY, GRADE, OPENYEAR, CAMEO, DIRECTOR, CATEGORY, GENRE) ");
			sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, vo.getMovieId());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getStroy());
			pstmt.setString(4, vo.getGrade());
			pstmt.setString(5, vo.getOpenYear());
			pstmt.setString(6, vo.getCameo());
			pstmt.setString(7, vo.getDirector());
			pstmt.setString(8, vo.getCategory());
			pstmt.setString(9, vo.getGenre());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CommonUtil.close(conn, pstmt);
		}
		return result;
	}

	public int update(MovieVO vo) {
		int result = 0;

		try {
			conn = CommonUtil.getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE MOVIE ");
			sql.append("SET TITLE = ?, STORY = ?, GRADE = ?, OPENYEAR = ?"
					+ ", CAMEO = ?, DIRECTOR = ? ");
			sql.append("WHERE MOVIE_ID = ? ");
			
			int index = 1;
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(index++, vo.getTitle());
			pstmt.setString(index++, vo.getStroy());
			pstmt.setString(index++, vo.getGrade());
			pstmt.setString(index++, vo.getOpenYear());
			pstmt.setString(index++, vo.getCameo());
			pstmt.setString(index++, vo.getDirector());
			pstmt.setInt(index++, vo.getMovieId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CommonUtil.close(conn, pstmt);
		}
		return result;
	}
	
	public int delete(int movieId) {
		int result = 0;
		
		try {
		conn = CommonUtil.getConnection();
		
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM MOVIE WHERE MOVIE_ID = ? ");
		
		pstmt = conn.prepareStatement(sql.toString());
		pstmt.setInt(1, movieId);
		
		result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CommonUtil.close(conn, pstmt);
		}
		return result;
		
	}

}
