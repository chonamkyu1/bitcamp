package stringbulider_exam;

import java.util.Arrays;
import java.util.StringTokenizer;

public class StringControls {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		String str1 = "홍길동 이순신    이순신 Tom 홍길동";
		String str2 = "    TOM    을지문덕 김유신 연개소문";
		String str = str1 + str2; // 문자열 붙이기
		sb.append(str1);
		sb.append(str2);
		System.out.println(str);

		// 2-1 sb문자열을 빈칸(" ")을 구분자로 잘라서 화면 출력(데이터확인)
		// String[] strArr = sb.toString().split(" ");
		// System.out.println(Arrays.toString(strArr));
		// for(String s : strArr) {
		// System.out.println("-" + s + "-");
		// }
		System.out.println("---------------------------------");
		StringTokenizer stk = new StringTokenizer(sb.toString(), " "); // 공백 빼고 값 출력
		System.out.println("토큰갯수: " + stk.countTokens()); // 토큰갯수값 공백 빼고 9개 출력
		System.out.println("---------------------------------");

		while (stk.hasMoreTokens()) { // 공백빼고 가지고있는 토큰들중에
			String name = stk.nextToken(); // 이름넣고 출력
			System.out.println("-" + name + "-");
		}
		System.out.println("토큰갯수: " + stk.countTokens()); // 토큰에 들어가서 출력되면 하나씩 차감되어 결국0값
		System.out.println("---------------------------------");

		// 2-2 문자열을 저장할 수 있는 배열변수(names)에 저장
		stk = new StringTokenizer(sb.toString(), " ");
		System.out.println("토큰갯수: " + stk.countTokens());
		System.out.println("----------------------------------");

		String[] names = new String[stk.countTokens()];

		int index = 0;
		while (stk.hasMoreTokens()) {
			names[index] = stk.nextToken();
			index++;
		}
		System.out.println(Arrays.toString(names));
		System.out.println("토큰갯수: " + stk.countTokens());

		System.out.println("==========3번========");

		// 3. 배열에 있는 값을 구분자 콤마(,)로 구분하여 한라인에 출력
		StringBuilder sb1 = new StringBuilder();
		for (int i = 0; i < names.length; i++) {
			// System.out.print(names[i] + ",");
			sb1.append(names[i]).append(",");
		}
		System.out.println(sb1.toString()); // 첫번째 출력값
		System.out.println("----------------------------------");
		System.out.println(sb1); // 두번째 출력값
		System.out.println("----------------------------------");

		// ------------------------------------
		sb1 = new StringBuilder();
		for (int i = 0; i < names.length; i++) {
			if (i == 0) {
				sb1.append(names[i]);
			} else {
				sb1.append(",").append(names[i]);

			}
		}
		System.out.println(sb1); // 세번째 출력값
		System.out.println("----------------------------------");

		sb1 = new StringBuilder();
		boolean isFirst = true;
		for (int i = 0; i < names.length; i++) {
			if (isFirst) { // 첫번째 데이터냐?
				sb1.append(names[i]);
				isFirst = false;
			} else {
				sb1.append(",").append(names[i]);
			}
		}
		System.out.println(sb1.toString()); // 네번재 출력값

		System.out.println("----------------------------------");
		sb1 = new StringBuilder();
		if (names.length > 0) {
			sb1.append(names[0]);
		}
		sb.append(names[0]);
		for (int i = 1; i < names.length; i++) {
			sb1.append(",").append(names[i]);
		}
		System.out.println(sb1.toString()); // 다섯번째 출력값
		
		// ---------------------------------------------
		System.out.println("=========4번======");
		// 4. 데이터의 첫글자만 추출해서 콤마(,)로 구분하여 한라인에 출력
		StringBuilder sb2 = new StringBuilder();
		if (names.length > 0) {
			sb2.append(names[0].charAt(0));
		}
		for (int i = 1; i < names.length; i++) {
			sb2.append(",").append(names[i].charAt(0));
		}
		System.out.println("sb2: " + sb2);

		System.out.println("======= 5번 ======");
		// 5. 배열의 문자열중 이름의 글자수가 4 이상인 값을 "인덱스번호:이름" 출력
		sb2.delete(0, sb2.length());
		// sb2.setLength(0);
		System.out.println("sb2: " + sb2);
		for (int i = 0; i < names.length; i++) { // names.length = 인덱스칸 총 9개
			if (names[i].length() >= 4) {
				sb2.append(i + ":" + names[i] + "\n");
			}
		}
		System.out.println(sb2);

		/*
		 * StringBuilder sb = new StringBuilder(); sb.append(str1); sb.append(str2);
		 * System.out.println("sb: " + sb);
		 * 
		 * String[] names = sb.toString().split(" "); System.out.println(names.length);
		 * 
		 * for(int i = 0; i < names.length; i++) { if(!names[i].equals("") ) {
		 * System.out.println("-" + names[i] + "-");
		 * 
		 * } } StringBuilder sb1 = new StringBuilder(sb); for(int i =0; i <
		 * names.length; i++) { // , 걸러주는역할 if(names[i].length() < 1) { continue; } if(i
		 * == 0 ) { System.out.print(names[i]); }else { System.out.print("," +
		 * names[i]); } }
		 * 
		 * 
		 * if(names.length > 0) { System.out.println(names[0].charAt(0)); } for(int i =
		 * 1; i < names.length; i++) { System.out.println("," + names[i].charAt(0)); }
		 * 
		 * 
		 * 
		 */

	}
}
