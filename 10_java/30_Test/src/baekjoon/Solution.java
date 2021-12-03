package baekjoon;
/* 1. 입력된 수가 짝수라면 2로 나누기 -> 1이 될때까지 
   2. 입력된 수가 홀수라면 3을 곱하고 1을 더한다.
   3. 결과로 나온 수에 같은 작업을 1이 될때까지 반복한다.
   예들들어, 입력된 수가 6이라면 6-> 3-> 5> 16->8 ->4->2->1이 되어 총 8번만에 1이 된다.
   위 작업을 몇번이나 반복해야하는지 반환하는 함수, solution 을완성해라
   단, 작업을 500번을 반복해도 1이 되지 않는다면 -1 반환

	입력된 수, num은 1이상 8000000 미만 정수
  
 */


class Solution {

	public int solution(int num) {
		int answer = 0;

		while (num != 1) { // 1이되면 반복문을 나가게끔 구조를 만들어라
			if (num % 2 == 0) { // 입력된 수가 짝수면
				num = num / 2; // 입력값 나누기 2
			} else if (num % 2 == 1) { // 입력된 수가 홀수면
				num = num * 3 + 1; // 입력된 값 * 3 + 1
			} 
			answer++;
			if (num == 500) {
				answer = -1;
			}
		}
		

		return answer;
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(626331));
	}
}
