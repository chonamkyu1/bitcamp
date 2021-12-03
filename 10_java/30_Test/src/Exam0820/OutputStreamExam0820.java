package Exam0820;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class OutputStreamExam0820 {
	public static void main(String[] args) {
		
		// 객체 선언
		BufferedReader br = null;
		BufferedWriter bw = null;
		FileReader fr = null;
		FileWriter fw = null;
		PrintWriter pw = null;
		
		List<String> list = new ArrayList<String>();
		int sum;
		double avg;
		
		try {
			// 파일 읽기
			// 버퍼(buffer) 기능이 구현되어 있는 클래스
			// BufferedReader, BufferedWriter
			// File -> FileReader -> BufferedReader
			// File -> FileWriter -> (BufferedWriter)-> PrintWriter
			
			File inFile = new File("data_utf8");
			fr = new FileReader(inFile);
			br = new BufferedReader(fr);
			
			// 파일 쓰기
			File outFile = new File("result.txt");
			fw = new FileWriter(outFile);
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);
			
			String str;
			StringBuilder sb = new StringBuilder();
			
			while (true) {
				str = br.readLine();
				if (str != null) {
					list.add(str);
				} else {
					break;
				}
			}
			// 합계
			for (int i = 0; i < list.size(); i++) {
				String[] strArr = list.get(i).split(",");
				sum = Integer.parseInt(strArr[2]) + Integer.parseInt(strArr[3]) + Integer.parseInt(strArr[4]);
				// 평균
				avg = sum / 3.0;

				for (int j = 0; j < strArr.length; j++) {
					sb.append(strArr[j]);
					sb.append(",");
				}
				sb.append(sum);
				sb.append(",");
				sb.append(String.format("%.2f", avg));
				sb.append("\n");
			}
			System.out.println(sb);

			pw.print(sb);
		pw.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
}
