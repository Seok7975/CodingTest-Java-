/*
p52 3_2_5. 나머지합 구하기, 시간 제한 1초 

골드3, 백준 온라인 저지 10986번

N개의 수 A1, A2, ..., An이 주어졌을 때 연속된 부분의 합이 M으로 나누어떨어지는 구간의 개수를 구하는 프로그램을 작성하시오.
즉, Ai + ... + Aj(i <= j)의 합이 M으로 나누어떨어지는 (i, j)쌍의 개수를 구하시오.

입력
1번째 줄에 N과 M(1 <= N <= 10^6, 2 <= M <= 10^3), 2번째 줄에 N개의 수 A1, A2, ..., An이 주어진다(0 <= Ai <= 10^9).

출력
1번째 줄에 연속된 부분의 합이 M으로 나누어떨어지는 구간의 개수를 출력한다.

예제입력
5 3
1 2 3 1 2

예제출력
7
*/
package prefixSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RemainderSum {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 수열의 갯수
		int M = Integer.parseInt(st.nextToken()); // 몫

		long[] S = new long[N]; // 합 배열 틀 만들기
		long[] count = new long[M]; //
		long answer = 0; // 최종 정답 갯수
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N; i++) {
			S[i] = S[i - 1] + Integer.parseInt(st.nextToken()); // 합 배열
		}

		for (int i = 0; i < N; i++) {
			int remainder = (int) (S[i] % M);
			
			if (remainder == 0) answer++; // 0 ~ i까지의 구간 합 자체가 0일 때 정답에 정답 더하기
			count[remainder]++; // 나머지가 같은 갯수의 카운트 배열 값 +1
		}
		
		// count 배열에서 원소 값이 같은 2개의 원소(i, j 구간)를 뽑는 모든 경우의 수를 구하고 더하기
		for (int i=0; i < M; i++) { 
			if (count[i] > 1) {
				answer = answer + (count[i] * (count[i] - 1) / 2); // 조합 공식(aCb)
			}
		}
		System.out.println(answer);

	}
}

//왜 나머지가 같은 쌍을 세는걸까?
/*
S[i]%M == S[j]%M일 때, S[j]-S[i]%M=0이다. (i<=j)
이는 S[i]부터 S[j] 구간합이 M으로 나눠 떨어진다는 것을 의미
*/