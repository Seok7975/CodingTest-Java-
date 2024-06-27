/*
p63 3_3_8. '좋은 수' 구하기 

시간 제한 2초, 골드4, 백준 온라인 저지 1253번

주어진 N개의 수에서 다른 두 수의 합으로 표현되는 수가 있다면 그 수를 '좋은 수'라고 한다. 
N개의 수 중 좋은 수가 총 몇개인지 출력하시오.

입력
1번째 줄에 수의 개수 N(1 <= N <= 2,000),
2번째 N개의 수의 값(Ai)이 주어진다(|Ai| <= 1,000,000,000, Ai는 정수).

출력
좋은 수의 개수를 출력한다.

예제 입력
10                   // 수의 개수
1 2 3 4 5 6 7 8 9 10 

예제 출력
8

*/

package twoPointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GoodNumberFinding {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine()); // 수의 갯수

		long[] arr = new long[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(arr);

		int count = 0;
		for (int i = 0; i < N; i++) {
			long findNum = arr[i];
			int x = 0;
			int y = N - 1;
			while (x < y) {
				if (arr[x] + arr[y] < findNum) {
					x++;
				} else if (arr[x] + arr[y] > findNum) {
					y--;
				} else {
					if (x != i && y != i) {
						count++;
						break;
					} else if (x == i) {
						x++;
					} else if (y == i) {
						y--;
					}
				}
			}
		}
		System.out.println(count);
		bf.close();

	}
}

/*
 * 1940번 문제: 두 포인터가 배열의 양 끝에서 시작하여 서로를 향해 이동하기 때문에 같은 인덱스를 두 번 사용할 일이 없습니다.
 * 1253번 문제: 배열의 각 요소가 다른 두 수의 합으로 표현될 수 있는지를 확인해야 하므로, 같은 인덱스를 두 번 사용하는 것을 방지하기
 * 위해 i != k와 j != k 조건이 필요합니다.
 */