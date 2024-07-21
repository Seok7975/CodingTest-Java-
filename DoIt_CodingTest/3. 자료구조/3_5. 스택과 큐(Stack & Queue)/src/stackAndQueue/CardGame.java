/*

p91 3_5_13. 카드 게임

시간 제한 2초, 실버4, 백준 온라인 저지 2164번

N장의 카드가 있다. 각각의 카드는 차례로 1부터 N까지의 번호가 붙어 있으며, 1번 카드가 제일 위에, 
N번 카드가 제일 아래인 상태로 순서대로 카드가 놓여 있다.
이제 다음과 같은 동작을 카드가 한 장 남을 때까지 반복하게 된다. 우선, 제일 위에 있는 카드를 바닥에 버린다. 
그 다음, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.
예를 들어 N=4인 경우를 생각해 보자. 카드는 제일 위에서부터 1234 의 순서로 놓여있다. 1을 버리면 234가 남는다. 
여기서 2를 제일 아래로 옮기면 342가 된다. 3을 버리면 42가 되고, 4를 밑으로 옮기면 24가 된다. 마지막으로 2를 버리고 나면, 남는 카드는 4가 된다.
N이 주어졌을 때, 제일 마지막에 남게 되는 카드를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 정수 N(1 ≤ N ≤ 500,000)이 주어진다.

출력
첫째 줄에 남게 되는 카드의 번호를 출력한다.

예제 입력 
6     // 카드의 갯수

예제 출력 
4

*/


package stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CardGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> myQueue = new LinkedList<>();
		int N = sc.nextInt();
		
		for (int i = 1 ; i <= N ; i++) {
			myQueue.add(i);
		}

		while ( myQueue.size() > 1 ) {
			myQueue.poll();
			myQueue.add(myQueue.poll());
			System.out.println(myQueue);
		}
		System.out.println(myQueue.poll());
		sc.close();
	}
}

//

// queue(선입선출)
// 6 	5	 4	 3	 2	 1
// rear      			front   
//
//1. 삽입
//queue.add(value) : 삽입 성공 시 true, 실패 시 예외 발생
//queue.offer(value) : 삽입 성공 시 true, 실패 시 false
//
//2. 제거
//queue.remove() : 큐의 첫번째 요소를 삭제 및 요소 반환, 큐가 비어있으면 예외 발생
//queue.remove(value) : 큐의 첫번째 요소를 삭제 및 true 반환, 실패시 false 반환
//queue.poll() : 큐의 첫번째 요소를 삭제 및 요소 반환, 큐가 비어있으면 null 반환
//queue.clear() : 큐의 모든 요소를 삭제, 반환은 X
//
//3. 값 반환
//queue.element() : 큐의 front에 있는 value 반환만, 공백시 예외 발생
//queue.peek() : 큐의 front에 있는 value 반환만, 공백시 null 반환
//
