package Exam0820;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InputStreamExam0820 {
	public static void main(String[] args) {
		File file = new File("data_utf8");
		FileReader fr = null;
		FileInputStream fis = null;

		
		try {
			// 1. 객체 생성
			fr = new FileReader(file);

			// 2. 객체 사용 작업
			try {
				int readChar = 0;
				
				while (readChar != -1) {

					readChar = fr.read();
					System.out.print((char) readChar);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}
