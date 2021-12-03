package com.mystudy.socket04_echo_while;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TCPClientEchoWhile {
	public static void main(String[] args) {
		// 메시지를 작성해서 서버로 전송하고, 서버로부터 전달받은 메시지 수신 반복처리
		// 메시지작성: Scanner 객체 사용해서 콘솔에서 입력

		Socket socket = null;

		// byte 단위 입출력 처리 변수 선언
		InputStream is = null;
		OutputStream os = null;

		// 필터 추가
		InputStreamReader isr = null;
		BufferedReader br = null;
		PrintWriter pw = null;

		try {
			System.out.println("----- 클라이언트 -----");
			// socket 만든곳에 새로운 객체 생성
			socket = new Socket("localhost", 10000);
			System.out.println("---- 서버 접속 완료 -----");

			// 소켓과 연결된 I/O 객체 생성
			is = socket.getInputStream(); // 입력스트림 얻기
			os = socket.getOutputStream(); // 출력스트림 얻기

			// 바이트(byte) 처리 계열을 문자(char) 처리 계열로 변환
			isr = new InputStreamReader(is);

			// 버퍼(buffer) 사용으로 편리하게 라인단위 입출력
			br = new BufferedReader(isr);
			pw = new PrintWriter(os);

			// 쓰고, 읽기 반복 처리
			Scanner scan = new Scanner(System.in);
			while (true) {
				// 쓰고(서버쪽으로 전달)
				System.out.println("메시지작성> ");
				String msg = scan.nextLine();
				
				pw.println(msg);
				pw.flush(); // 버퍼 데이터 출력
				
				// 작성된 메시지 확인해서 "exit"인 경우 작업 종료
				if("exit".equalsIgnoreCase(msg)) {
					System.out.println(">>> 대화를 종료합니다.");
					break;
				}

				// 읽기(서버에서 보내온 메시지)
				String reMsg = br.readLine();
				System.out.println("from서버: " + reMsg);

			}
			scan.close();
			System.out.println("----- 클라이언트 정상 종료 -----");

		} catch (IOException e) {
			System.out.println("----- [예외발생] 비정상 종료 -----");
			e.printStackTrace();
		} finally {
			if (pw != null) {
				pw.close();
			}
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (socket != null) {
				try {
					socket.close();
					System.out.println(">>> 소켓 close");
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}

	}
}
