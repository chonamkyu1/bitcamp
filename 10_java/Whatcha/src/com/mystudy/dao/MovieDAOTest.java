package com.mystudy.dao;

import java.util.List;

import com.mystudy.vo.MovieVO;

public class MovieDAOTest {

	public static void main(String[] args) {
		MovieDAO mdao = new MovieDAO();
		
		List<MovieVO> list = mdao.selectAll();
		for(MovieVO vo : list) {
			System.out.println(vo);
		}
		
		mdao.selectOne(1);
		
		
//		MovieVO insertVo = new MovieVO(10,"1","2","3","4","5","6");
//		int result = mdao.insert(insertvo);
//		System.out.println(result);
		
//		mdao.delete(10);
		
//		MovieVO updateVo = new MovieVO("신세계2", "느와르2", "청소년불가2", "2013", "황정민, 이정재","박훈정", 1);
		
//		MovieVO updateVO = new MovieVO("신세계", "느와르", "청소년불가", "2012", "이정재, 황정민","박훈정", 1);
//		int updateResult = mdao.update(updateVO);
//		System.out.println(updateResult);
//	
	
	}

}
