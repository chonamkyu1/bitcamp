package com.mystudy.viewer;

import java.util.List;
import java.util.Scanner;

import com.mystudy.dao.MovieDAO;
import com.mystudy.util.ScannerUtil;
import com.mystudy.vo.MovieVO;

public class MovieViewer {
	private MovieDAO movieDAO;
	private MovieVO movieVO;
	private Scanner scanner;

	public MovieViewer() {
		movieDAO = new MovieDAO();
		movieVO = new MovieVO();
		scanner = new Scanner(System.in);
	}

	public void showMenu() {
		List<MovieVO> list = movieDAO.selectAll();
		if (list.isEmpty()) {
			System.out.println("아직 등록된 영화가 없습니다.");
		}
		while (true) {
			System.out.println("---------영화 리스트----------");
			for (MovieVO vo : list) {
				System.out.println(vo.getMovieId() + ", [영화제목]: " + vo.getTitle() +  ", [줄거리]: " +  vo.getStroy());
			}
			String message = "1. 개별영화보여주기 2. 뒤로가기";
			int userChoice = ScannerUtil.nextInt(scanner, message);
			if (userChoice == 1) {
				selectOne(userChoice);
				userChoice = ScannerUtil.nextInt(scanner, message);
				
			} else if (userChoice == 2) {
				validate();
			}

		}
	}

	public void selectOne(int movieId) {
		movieVO = movieDAO.selectOne(movieId);
		System.out.println("[영화제목]: " + movieVO.getTitle() + ", [줄거리]: " +  movieVO.getStroy() + ", [등급]: " +  movieVO.getGrade());
	}

	// 뒤로가기 메소드
	public int validate() {
		int result = 0;
		String message = "상세보기할 번호나 뒤로가시려면 0번을 입력해주세요.";
		result = ScannerUtil.nextInt(scanner, message);
		movieDAO.selectOne(result);  //상세보기할 번호
		while (true) {
			if (result == 0) {
				System.out.println();
			} else if (result != 0 || movieVO == null) {
				System.out.println("잘못입력하셨습니다. 다시 상세보기할 번호를입력해주세요.");
				result = ScannerUtil.nextInt(scanner, message);
				movieDAO.selectOne(result);  //상세보기할 번호
			}

			return result;
		}
	}

	/*
	 * public void showMenu() { while (true) { String message =
	 * "1. 인기영화 2. 한국영화 3. 외국영화 0. 뒤로가기 "; // 로그인창? int userChoice =
	 * ScannerUtil.nextInt(scanner, message); if (userChoice == 1) { // 인기영화
	 * bestMovie } else if (userChoice == 2) { // 한국영화 koreanMovie } else if
	 * (userChoice == 3) { // 외국영화 foreignMovie } else { break; } } }
	 * 
	 * // 카테고리 메소드 public void category() { while (true) { String message =
	 * "1. 카테고리 목록 2. 뒤로가기"; int userChoice = ScannerUtil.nextInt(scanner, message);
	 * if (userChoice == 1) { // 목록 보기 } else if (userChoice == 2) { // 뒤로가기 } }
	 * 
	 * }
	 */
}
