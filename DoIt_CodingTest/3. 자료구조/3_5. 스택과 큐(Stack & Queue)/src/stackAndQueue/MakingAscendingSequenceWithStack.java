/*

p74 3_5_11. 스택으로 오름차순 수열 만들기 

시간 제한 2초, 실버3, 백준 온라인 저지 1874번

1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다. 
이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자. 
임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 
있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다. 이를 계산하는 프로그램을 작성하라.

입력
첫 줄에 n (1 ≤ n ≤ 100,000)이 주어진다. 
둘째 줄부터 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 하나씩 순서대로 주어진다. 
물론 같은 정수가 두 번 나오는 일은 없다.

출력
입력된 수열을 만들기 위해 필요한 연산을 한 줄에 한 개씩 출력한다. 
push연산은 +로, pop 연산은 -로 표현하도록 한다. 불가능한 경우 NO를 출력한다.

예제 입력 1
8
4
3
6
8
7
5
2
1

예제 출력 1
+
+
+
+
-
-
+
+
-
+
+
-
-
-
-
-

예제 입력 2
5
1
2
5
3
4

예제 출력 2
NO

힌트
1부터 n까지에 수에 대해 차례로 
[push, push, push, push, pop, pop, push, push, pop, push, push, pop, pop, pop, pop, pop] 연산을 수행하면 
수열 [4, 3, 6, 8, 7, 5, 2, 1]을 얻을 수 있다.

*/

package stackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class MakingAscendingSequenceWithStack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 수열의 항 갯수
		int[] A = new int[N]; // 수열
		for(int i = 0; i < N ; i++) {
			A[i] = sc.nextInt();
		}
		
		Stack<Integer> stack = new Stack<>();
		StringBuffer sb = new StringBuffer();
		int num = 1;
		boolean result = true;
		
		for(int i = 0; i < A.length; i++) {
			int currentNum = A[i]; // 현재 수열 값
			if(currentNum >= num) {
				while( currentNum >= num) {
					stack.push(num++);
					sb.append("+\n");
				}
				stack.pop();
				sb.append("-\n");
			} else {
				int stackTop = stack.pop();
				
				if( stackTop > currentNum) {
					System.out.println("NO");
					result = false;
					break;
				} else {
					sb.append("-\n");
				}
			}
		}
		
		if(result) {
			System.out.println(sb.toString());
		}
	}
}
