/*

p91 3_5_14. 절댓값 힙 구현하기

시간 제한 2초, 실버1, 백준 온라인 저지 11286번

절댓값 힙은 다음과 같은 연산을 지원하는 자료구조이다.

1. 배열에 정수 x (x ≠ 0)를 넣는다.
2. 배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다. 
   절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.

프로그램은 처음에 비어있는 배열에서 시작하게 된다.

입력
첫째 줄에 연산의 개수 N(1≤N≤100,000)이 주어진다. 
다음 N개의 줄에는 연산에 대한 정보를 나타내는 정수 x가 주어진다. 
만약 x가 0이 아니라면 배열에 x라는 값을 넣는(추가하는) 연산이고, 
x가 0이라면 배열에서 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우이다. 
입력되는 정수는 -2^31보다 크고, 2^31보다 작다.

출력
입력에서 0이 주어진 횟수만큼 답을 출력한다. 만약 배열이 비어 있는 경우인데 절댓값이 가장 작은 값을 출력하라고 한 경우에는 0을 출력하면 된다.

예제 입력 
18	// 연산의 갯수
1
-1
0
0
0
1
1
-1
-1
2
-2
0
0
0
0
0
0
0

예제 출력 
-1
1
0
-1
-1
1
1
-2
2
0

*/

package stackAndQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class AbsoluteValueHeap {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> myQueue = new PriorityQueue<>((a1, a2) -> {
			// 우선순위 설정
			int first_abs = Math.abs(a1);
			int second_abs = Math.abs(a2);
			
			if (first_abs == second_abs) {
				return a1 > a2 ? 1 : -1;      //  a1이 양수 면 1 반환, a1이 음수면 -1 반환 => a1이 a2보다 뒤에 오게(rear에 가깝게)
			} else {
				return first_abs - second_abs; // 절댓값을 기준으로 정렬 => 음수이면 a1이 a2보다 앞에 오고, 양수이면 a1이 a2보다 뒤에(rear에 가깝게)
			}
		});
		
		ArrayList<Integer> result = new ArrayList<>();
		for(int i = 0 ; i < N ; i++) {
			int insertNum = Integer.parseInt(br.readLine());
			if (insertNum == 0) {
				if (myQueue.isEmpty()) {
					result.add(0);
				} else {
					result.add(myQueue.poll());
				}
			} else {
				myQueue.add(insertNum);
			}
		}
		
		for(int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}

//		for(int i = 0 ; i < N ; i++) {
//			int insertNum = Integer.parseInt(br.readLine());
//			if (insertNum == 0) {
//				if (myQueue.isEmpty()) {
//					System.out.println("0");
//				} else {
//					System.out.println(myQueue.poll());
//				}
//			} else {
//				myQueue.add(insertNum);
//			}
//			
//		}

		br.close();
	}
}

/*
 * 
 * 일반적인 큐(Queue)는 먼저 집어넣은 데이터가 먼저 나오는 FIFO (First In First Out) 구조로 저장하는 선형
 * 자료구조입니다.
 * 
 * 하지만 우선순위 큐(Priority Queue)는 들어간 순서에 상관없이 우선순위가 높은 데이터가 먼저 나오는 것을 말합니다.
 * 
 * 
 * 
 * 우선순위 큐는 다음과 같은 속성을 가지고 있습니다.
 * 
 * 모든 항목에는 우선순위가 있습니다. 우선 순위가 높은 요소는 우선 순위가 낮은 요소보다 먼저 queue에서 제외됩니다. 두 요소의 우선
 * 순위가 같으면 queue의 순서에 따라 제공됩니다.
 * 
 */