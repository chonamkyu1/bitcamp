package baekjoon;

// 이 문제에는 표준 입력으로 두개의 정수 n과 m이 주어집니다.
// 별(*) 문자를 이용해 가로의 길이가 n, 세로의 길이가 m인 직사각형 형태를 출력해보자
import java.util.Scanner;

public class Solution2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		
		for (int i = 1; i <= a; i++) {
			System.out.println("");
		}
		for (int j = 0; j < b; j++) {
			System.out.println("*");
		}
			System.out.println(a + b);
	}
}