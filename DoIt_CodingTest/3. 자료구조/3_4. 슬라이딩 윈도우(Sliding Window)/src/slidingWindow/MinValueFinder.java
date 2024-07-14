/*

<개인적으로 너어어엉어ㅓ어어어어어어무 어려움>
p74 3_4_10. 최솟값 찾기 

시간 제한 2.4초, 플래티넘, 백준 온라인 저지 11003번

N개의 수 A1, A2, ..., AN과 L이 주어진다.
Di = Ai-L+1 ~ Ai 중의 최솟값이라고 할 때, D에 저장된 수를 출력하는 프로그램을 작성하시오. 이때, i ≤ 0 인 Ai는 무시하고 D를 구해야 한다.

입력
첫째 줄에 N과 L이 주어진다. (1 ≤ L ≤ N ≤ 5,000,000)

둘째 줄에는 N개의 수 Ai가 주어진다. (-10^9 ≤ Ai ≤ 10^9)

출력
첫째 줄에 Di를 공백으로 구분하여 순서대로 출력한다.

예제 입력
12 3						// 숫자의 개수, 슬라이딩 윈도우의 크기
1 5 2 3 6 2 3 7 3 5 2 6

예제 출력
1 1 1 2 2 2 2 2 3 3 2 2

*/


package slidingWindow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;


public class MinValueFinder {
//	public static final Scanner scanner = new Scanner(System.in); 
	
	public static void main(String[] args) throws Exception {
		// 첫 번째 줄 입력 처리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 숫자의 갯수
		int L = Integer.parseInt(st.nextToken()); // 최솟값을 구하는 범위
		
		// 두 번째 줄 입력 처리
		st = new StringTokenizer(br.readLine());
		
		// Deque(양방향 큐) 생성, 최솟값을 찾기 위해 사용
		Deque<Node> mydeque = new LinkedList<>();
		
		for(int i = 0 ; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());
			
			// Deque의 마지막 요소가 현재 값보다 크면 제거
			while( !mydeque.isEmpty() && mydeque.getLast().value > now ) {
				mydeque.removeLast();
			}
			
			// 현재 값을 Deque의 마지막에 추가
			mydeque.addLast(new Node(now, i));
			
			// Deque의 첫 번째 값(인덱스)이 현재 범위를 벗어나면 첫 번째 값을 제거
			if (mydeque.getFirst().index <= i - L) {
				mydeque.removeFirst();
			}
			// 현재 범위의 최솟값을 출력
			bw.write(mydeque.getFirst().value + " ");
		}
		
		// 출력 버퍼를 비우고 닫음
		bw.flush();
		bw.close();
		
		// 입력 버퍼를 닫음
		br.close();
	}
	    // Node 클래스 정의 : 값과 인덱스를 저장하기 위해 사용
	    static class Node {
	        int value;
	        int index;

	        Node(int value, int index) {
	            this.value = value;
	            this.index = index;
	        }
	    }
	}
	
