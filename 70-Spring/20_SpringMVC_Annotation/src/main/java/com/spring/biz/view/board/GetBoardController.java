package com.spring.biz.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

@Controller
public class GetBoardController {
	@RequestMapping("/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println(">>> 게시글 상세 보여주기");
		System.out.println("getBoard vo: " + vo);
		BoardVO board = boardDAO.getBoard(vo);
		mav.addObject("board", board);
		mav.setViewName("getBoard.jsp");
		return mav;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * @Override public ModelAndView handleRequest(HttpServletRequest request,
	 * HttpServletResponse response) { System.out.println(">>> 게시글 상세 보여주기"); // 1.
	 * 전달받은 데이터 추출(확인) String seq = request.getParameter("seq");
	 * 
	 * // 2. 게시글 목록 조회(SELECT) BoardVO vo = new BoardVO();
	 * vo.setSeq(Integer.parseInt(seq)); BoardDAO boardDAO = new BoardDAO(); BoardVO
	 * board = boardDAO.getBoard(vo);
	 * 
	 * // 3. 검색결과를 세션에 저장(뷰에서 사용할 수 있게) //HttpSession session =
	 * request.getSession(); //session.setAttribute("board", board);
	 * 
	 * // 4. 상세보기 화면으로 이동 //response.sendRedirect("getBoard.jsp"); ModelAndView mav
	 * = new ModelAndView(); mav.addObject("board", board);
	 * mav.setViewName("getBoard.jsp"); return mav; }
	 */
}
