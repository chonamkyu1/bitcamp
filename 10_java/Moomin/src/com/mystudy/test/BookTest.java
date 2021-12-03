package com.mystudy.test;

import java.util.ArrayList;
import java.util.List;

import com.mystudy.dao.BookDAO;
import com.mystudy.vo.BookVO;

public class BookTest {

	public static void main(String[] args) {
		BookDAO dao = new BookDAO();
		List<String> list = new ArrayList<String>();
		int i = 1;
		
		list = dao.selectAll();
		for (String str : list) {
		System.out.println(str);
		}
		
		BookVO vo = dao.selectOne(1);
		System.out.println(vo);
		
		//int result = dao.bkselectOne();
		
		
			
		vo = new BookVO(3, 1, 210001, 1, 30000, 1);
		dao.bookinsert(vo);
		System.out.println("insert 처리: " + dao.selectOne(3));
		
		
		
		vo = new BookVO(3, 1, 210001, 1, 20000, 1);
		int change = dao.bookUpdate(vo);
		System.out.println("update 처리 : " + change);
		System.out.println(dao.selectOne(3));
		
		change = dao.bookUpdate(3, 15000);
		System.out.println("update 처리 : " + change);
		System.out.println(dao.selectOne(3));
		
		change = dao.bookDelete(3);

		System.out.println("delete 처리 : " + change);
		System.out.println(dao.selectOne(3));
		
		
		
		
	}

}
