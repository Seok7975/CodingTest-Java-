/*
p59 3_3_7. 주몽의 명령 

시간 제한 2초, 실버4, 백준 온라인 저지 1940번

주몽은 철기군을 양성하기 위한 프로젝트에 나섰다. 그래서 야철대장에게 철기군이 입을 갑옷을 만들라고 명령했다.
야철대장은 주몽의 명령에 따르기 위해 연구에 착수하던 중 갑옷을 만드는 재료들은 각각 고유한 번호가 있고,
갑옷은 2개의 재료로 만드는 데 2가지 재료의 고유한 번호를 합쳐(1 <= M <= 10,000,000)이 되면 갑옷이 만들어진다는 사실을 발견했다.
야철대장은 자신이 만들고 있는 재료로 갑옷을 몇 개나 만들 수 있는지 궁금해졌다.
야철대장의 궁금증을 풀어 주기 위해 N(1 <= N <= 15,000)개의 재료와 M이 주어졌을 때 몇개의 갑옷을
만들 수 있는지를 구하는 프로그램을 작성하시오.

입력
1번째 줄에 재료의 개수 N(1 <= N <= 15,000),
2번째 줄에 갑옷을 만드는 데 필요한 수 M(1<= M <= 10,000,000)이 주어진다.
3번째 줄에는 N개의 재료들이 가진 고유한 번호들이 공백을 사이에 두고 주어진다.
고유한 번호는 100,000보다 작거나 같은 자연수다.

출력
1번째 줄에 갑옷을 만들 수 있는 개수를 출력한다.

예제 입력
6 // 재료의 개수
9 // 갑옷이 완성되는 번호의 합
2 7 4 1 5 3 // 재료들

예제 출력
2

*/

package twoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JumongsOrders {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine()); // 재료의 개수
		int M = Integer.parseInt(bf.readLine()); // 갑옷이 완성되는 번호의 합
		int[] ingredient = new int[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());

		for (int i = 0; i < N; i++) {
			ingredient[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(ingredient); // ingredient배열 오름차순으로 정렬

		int count = 0; // 갑옷을 만들 수 있는 개수(경우의 수)
		int x = 0; // 투포인터의 작은 수
		int y = N - 1; // 투포인터의 큰 수

		while (x < y) {
			if (ingredient[x] + ingredient[y] < M) {
				x++;
			} else if (ingredient[x] + ingredient[y] > M) {
				y--;
			} else {
				x++;
				y--;
				count++;
			}
		}

		System.out.println(count);
		bf.close();
	}
}
