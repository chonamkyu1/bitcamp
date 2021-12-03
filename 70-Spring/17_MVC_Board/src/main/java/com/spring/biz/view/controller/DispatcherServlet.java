package com.spring.biz.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;
import com.spring.biz.user.UserVO;
import com.spring.biz.user.impl.UserDAO;
import com.spring.biz.view.board.DeleteBoardController;
import com.spring.biz.view.board.GetBoardController;
import com.spring.biz.view.board.GetBoardListController;
import com.spring.biz.view.board.InsertBoardController;
import com.spring.biz.view.board.UpdateBoardController;
import com.spring.biz.view.user.LoginController;
import com.spring.biz.view.user.LogoutController;


public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HandlerMapping hanlerHandlerMapping;
	private ViewResolver viewResolver;
	
	@Override
	public void init() throws ServletException {
		hanlerHandlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSufix(".jsp");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println(">>DispatcherServlet.process() : *.do 요청에 대한 처리");
		
		// 1. 클라이언트에서 어떤 작업을 요청했는지 확인하기
		String uri = request.getRequestURI();
		System.out.println("uri : " + uri); //  /biz/login.do
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println("path : " + path); //  /login.do
		
		// 2. 클라이언트의 요청형태에 따른 작업 처리
		Controller controller = hanlerHandlerMapping.getContreller(path);
		System.out.println(">> controller : " + controller);
		String viewName = controller.handleRequest(request, response);
		System.out.println(">> viewName : " + viewName);
		
		
		// 3. 이동할 view 이름 정보를 작성하고
		// viewName 에 ".do" 가 없으면 뷰리졸버 적용
		// viewName 에 ".do" 가 있으면 그대로 요청처리
		
		String view = null;
		if (viewName.contains(".do")) {
			view = viewName;
		} else {
			view = viewResolver.getView(viewName);
		}
		System.out.println(">> view : " + view);
		
		// 4. 응답페이지 호출
		response.sendRedirect(view);
		
		/*
		 * if ("/login.do".equals(path)) { Controller controller = new
		 * LoginController(); String view = controller.handleRequest(request, response);
		 * response.sendRedirect(view); } else if ("/logout.do".equals(path)) {
		 * Controller controller = new LogoutController(); String view =
		 * controller.handleRequest(request, response); response.sendRedirect(view); }
		 * else if ("/getBoardList.do".equals(path)) { Controller controller = new
		 * GetBoardListController(); String view = controller.handleRequest(request,
		 * response); response.sendRedirect(view); } else if
		 * ("/getBoard.do".equals(path)) { Controller controller = new
		 * GetBoardController(); String view = controller.handleRequest(request,
		 * response); response.sendRedirect(view); } else if
		 * ("/insertBoard.do".equals(path)) { Controller controller = new
		 * InsertBoardController(); String view = controller.handleRequest(request,
		 * response); response.sendRedirect(view); } else if
		 * ("/updateBoard.do".equals(path)) { Controller controller = new
		 * UpdateBoardController(); String view = controller.handleRequest(request,
		 * response); response.sendRedirect(view); } else if
		 * ("/deleteBoard.do".equals(path)) { Controller controller = new
		 * DeleteBoardController(); String view = controller.handleRequest(request,
		 * response); response.sendRedirect(view); }
		 */
	}
	
	

}









/*
 * package com.spring.biz.view.controller;
 * 
 * import java.io.IOException; import java.util.List;
 * 
 * import javax.servlet.ServletException; import javax.servlet.http.HttpServlet;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse; import
 * javax.servlet.http.HttpSession;
 * 
 * import com.spring.biz.board.BoardVO; import
 * com.spring.biz.board.impl.BoardDAO; import com.spring.biz.user.UserVO; import
 * com.spring.biz.user.impl.UserDAO; import
 * com.spring.biz.view.board.DeleteBoardController; import
 * com.spring.biz.view.board.GetBoardController; import
 * com.spring.biz.view.board.GetBoardListController; import
 * com.spring.biz.view.board.InsertBoardController; import
 * com.spring.biz.view.board.UpdateBoardController; import
 * com.spring.biz.view.user.LoginController; import
 * com.spring.biz.view.user.LogoutController;
 * 
 * public class DispatcherServlet extends HttpServlet { private static final
 * long serialVersionUID = 1L;
 * 
 * protected void doGet(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException { process(request, response);
 * }
 * 
 * protected void doPost(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException {
 * request.setCharacterEncoding("UTF-8"); process(request, response); }
 * 
 * private void process(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException {
 * System.out.println("Dispatcherservlet.process() : *.do 요청에 대한 응답처리");
 * 
 * // 1. 클라이언트에서 어떤 작업을 요청했는지 확인하기 String uri = request.getRequestURI();
 * System.out.println("uri: " + uri); String path =
 * uri.substring(uri.lastIndexOf("/")); System.out.println("path: " + path);
 * 
 * // 2. 클라이언트의 요청형태에 따른 작업 처리 if ("/login.do".equals(path)) { Controller
 * controller = new LoginController(); String view =
 * controller.handleRequest(request, response); response.sendRedirect(view); }
 * else if ("/logout.do".equals(path)) { LogoutController controller = new
 * LogoutController(); String view = controller.handleRequest(request,
 * response); response.sendRedirect(view); } else if
 * ("/getBoardList.do".equals(path)) { Controller controller = new
 * GetBoardListController(); String view = controller.handleRequest(request,
 * response); response.sendRedirect(view); } else if
 * ("/getBoard.do".equals(path)) { Controller controller = new
 * GetBoardController(); String view = controller.handleRequest(request,
 * response); response.sendRedirect(view); } else if
 * ("/insertBoard.do".equals(path)) { Controller controller = new
 * InsertBoardController(); String view = controller.handleRequest(request,
 * response); response.sendRedirect(view); } else if
 * ("/updateBoard.do".equals(path)) { Controller controller = new
 * UpdateBoardController(); String view = controller.handleRequest(request,
 * response); response.sendRedirect(view); } else if
 * ("/deleteBoard.do".equals(path)) { Controller controller = new
 * DeleteBoardController(); String view = controller.handleRequest(request,
 * response); response.sendRedirect(view); } } }
 */