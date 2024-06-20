/*
p56 3_3_6. 연속된 자연수의 합 구하기 

시간 제한 2초, 실버5, 백준 온라인 저지 2018번

어떠한 자연수 N은, 몇 개의 연속된 자연수의 합으로 나타낼 수 있다. 
당신은 어떤 자연수 N(1 ≤ N ≤ 10,000,000)에 대해서, 
이 N을 몇 개의 연속된 자연수의 합으로 나타내는 가지수를 알고 싶어한다. 이때, 사용하는 자연수는 N이하여야 한다.
예를 들어, 15를 나타내는 방법은 15, 7+8, 4+5+6, 1+2+3+4+5의 4가지가 있다. 반면에 10을 나타내는 방법은 10, 1+2+3+4의 2가지가 있다.
N을 입력받아 가지수를 출력하는 프로그램을 작성하시오.

입력
첫 줄에 정수 N이 주어진다.

출력
입력된 자연수 N을 몇 개의 연속된 자연수의 합으로 나타내는 가지수를 출력하시오

예제 입력
15 // N

예제 출력
4
*/

package twoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOfConsecutiveNatualNumbers {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 어떤 자연수 N
		int count = 1; // 0이 아닌 1로 놓는 이유 : 자기자신일 경우를 미리 셈
		int startIndex = 1;
		int endIndex = 1;
		int sum = 1;
		
		while(endIndex != N) {
			if (sum == N) {
				count++;
				endIndex++;
				sum = sum + endIndex; 
			} else if (sum > N) {
				sum = sum - startIndex;
				startIndex++;
			} else {
				endIndex++;
				sum = sum + endIndex;
			}
		}
		System.out.println(count);
		
	}
}
