package com.mystudy.test;

import java.util.List;

import com.mystudy.dao.MovieInfoDAO;
import com.mystudy.vo.MovieInfoVO;

public class MovieInfoTest {

	public static void main(String[] args) {
		MovieInfoDAO dao = new MovieInfoDAO();
		List<MovieInfoVO> list = dao.selectAll();
		for(MovieInfoVO vo : list) {
			System.out.println(vo);
		}
		
		MovieInfoVO vo = dao.selectOne(210001);
		System.out.println("selectOne : " + vo);
		System.out.println("selectOne : " + vo.getTitle());
		
		
		vo = new MovieInfoVO(210003, "어벤져스", "히어로물", "12세");
		int result = dao.mvInsert(vo);
		System.out.println("처리결과 : " + result);
		vo = dao.selectOne(210003);
		System.out.println("mvInsert : " + vo);
		
		
		vo = new MovieInfoVO(210003, "어벤져스2", "히어로물", "12세");
		result = dao.mvUpdate(vo);
		System.out.println("처리결과 : " + result);
		vo = dao.selectOne(210003);
		System.out.println("mvUpdate : " + vo);
		
		
		result = dao.mvDelete(210003);
		vo = dao.selectOne(210003);
		for(MovieInfoVO vo1 : list) {
			System.out.println(vo1);
		}
	}

}
