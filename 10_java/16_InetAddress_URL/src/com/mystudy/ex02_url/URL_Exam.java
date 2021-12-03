package com.mystudy.ex02_url;

import java.net.MalformedURLException;
import java.net.URL;

public class URL_Exam {
	public static void main(String[] args) throws MalformedURLException {
		// 프로토콜://호스트(서버):포트/경로(패스)?질의(query)
		// https://m.sports.naver.com/game/VVOWTEAM6QFNL000200
		
		// URL(String protocol, String host, int port, String file)
		// https://java.mystudy.com:8080/aaa/bbb/index.jsp?id=hong&password=1234#content 
		URL url = new URL("http", "com.mystudy.java", 8080
				, "aaa/bbb/index.jsp?id=hong&password=1234#content");
		url = new URL("http://java.mystudy.com:8080"
				+ "/aaa/bbb/index.jsp?id=hong&password=1234#content");
		String protocol = url.getProtocol();
		String host = url.getHost();
		int port = url.getPort();
		int defaultport = url.getDefaultPort();
		String path = url.getPath();
		String query = url.getQuery();
		String ref = url.getRef();
		
		System.out.println("프로토콜(protocol): " + protocol);
		System.out.println("서버명(host): " + host);
		System.out.println("포트번호(port): " + port);
		System.out.println("포트번호(defaultport): " + defaultport);
		System.out.println("경로-path(path): " + path);
		System.out.println("쿼리-질문(query): " + query);
		System.out.println("참조(ref): " + ref);
		
		System.out.println("---------------------------------");
		url = new URL("https://java.mystudy.com:8080/aaa/bbb/index.jsp?id=hong&password=1234#content");
		protocol = url.getProtocol();
		host = url.getHost();
		port = url.getPort();
		defaultport = url.getDefaultPort();
		path = url.getPath();
		query = url.getQuery();
		ref = url.getRef();
		
		System.out.println("프로토콜(protocol): " + protocol);
		System.out.println("서버명(host): " + host);
		System.out.println("포트번호(port): " + port);
		System.out.println("포트번호(defaultport): " + defaultport); // 443: default
		System.out.println("경로-path(path): " + path);
		System.out.println("쿼리-질문(query): " + query);
		System.out.println("참조(ref): " + ref);
		
	}
}
