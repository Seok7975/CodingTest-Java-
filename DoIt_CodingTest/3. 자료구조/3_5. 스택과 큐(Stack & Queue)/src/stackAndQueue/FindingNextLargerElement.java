/*

p86 3_5_12. 오큰수 구하기

시간 제한 1초, 골드4, 백준 온라인 저지 17298번

크기가 N인 수열 A = A1, A2, ..., AN이 있다. 
수열의 각 원소 Ai에 대해서 오큰수 NGE(i)를 구하려고 한다. 
Ai의 오큰수는 오른쪽에 있으면서 Ai보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미한다. 그러한 수가 없는 경우에 오큰수는 -1이다.
예를 들어, A = [3, 5, 2, 7]인 경우 NGE(1) = 5, NGE(2) = 7, NGE(3) = 7, NGE(4) = -1이다. A = [9, 5, 4, 8]인 경우에는 
NGE(1) = -1, NGE(2) = 8, NGE(3) = 8, NGE(4) = -1이다.

입력
첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄에 수열 A의 원소 A1, A2, ..., AN (1 ≤ Ai ≤ 1,000,000)이 주어진다.

출력
총 N개의 수 NGE(1), NGE(2), ..., NGE(N)을 공백으로 구분해 출력한다.

예제 입력 1
4
3 5 2 7

예제 출력 1
5 7 7 -1

예제 입력 2
4
9 5 4 8

예제 출력 2
-1 8 8 -1

*/


package stackAndQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class FindingNextLargerElement {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 수열의 항 갯수
		int[] A = new int[N]; // 수열
		int[] answer = new int[N];	// 정답배열
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			System.out.print(A[i] + " ");
		}
		System.out.println();
		
		Stack<Integer> myStack = new Stack<>();
		myStack.push(0); // 첫 번째 원소부터 비교를 시작하기 위해서 0을 미리 넣음, Stack 0, A[0]
		//첫 번째 원소의 인덱스를 스택에 넣고, 그 이후의 원소들과 비교를 시작
		for(int i =1; i < N; i++) {
			while(!myStack.isEmpty() && A[myStack.peek()] < A[i]) {
				answer[myStack.pop()] = A[i]; // 인덱스를 제거하면서 A[i]가 다음 큰 요소임을 기록하게 함
			}
			myStack.push(i);
		}
		
		while(!myStack.empty()) {
			answer[myStack.pop()] = -1;
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0 ; i < N ; i++) {
			bw.write(answer[i] + " ");
			
		}
		bw.write("\n");
		bw.flush();
		/*
		 * int N = Integer.parseInt(br.readLine()); // 수열의 갯수 int[] A = new int[N]; //
		 * 수열 String[] str = br.readLine().split(" ");
		 */
	}
}

