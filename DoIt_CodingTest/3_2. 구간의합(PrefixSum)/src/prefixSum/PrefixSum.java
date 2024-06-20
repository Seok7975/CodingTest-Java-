/*
p44 문제3_3. 구간 합 구하기, 시간제한 0.5초, 실버3, 백준 온라인 저지 11659번

수 N개가 주어졌을 때 i번째 수에서 j번째 수까지의 합을 구하는 프로그램을 작성하시오.

입력
1번째 줄에 수의 개수N(1 <= N <= 100,000), 합을 구해야하는 횟수 M (1 <= M <= 1000,000),
2번째 줄에 N개의 수가 주어진다. 각 수는 1,000보다 작거나 같은 자연수다.
3번째 줄부터는 M개의 줄에 합을 구해야 하는 구간 i와 j가 주어진다.

출력
총 M개의 줄에 입력으로 주어진 i번째 수에서 j번째 수까지의 합을 출력한다.

예제 입력
5 3         // 데이터의 개수, 질의 개수
5 4 3 2 1   // 구간 합을 구할 대상 배열
1 3
2 4
5 5

예제 출력
12
9
1
*/

/*
최악의 경우의 수가 10만 x 10만 = 1억회 이상이므로 평범한 Scanner입력을 받으면 출력시간이 1초이상이 되므로 문제에 적합하지않다.
따라서 구간의 합을 이용해야 한다. => BufferReader와 StringTokenizer를 이용

ex) Scanner : 하나씩 일일이 입력,  Buffer : 입력한 뭉탱이들을 하나의 바구니에 넣고 바구니 통째로 입력하는 느낌
*/

package prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PrefixSum {
    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용하여 입력을 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄을 읽고 공백을 기준으로 분리
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 첫 번째 값은 숫자의 개수
        int numberOfNumber = Integer.parseInt(st.nextToken());
        
        // 두 번째 값은 퀴즈의 개수
        int numberOfQuiz = Integer.parseInt(st.nextToken());
        
        // 누적 합을 저장할 배열을 선언, 인덱스 1부터 사용하기 위해 크기를 numberOfNumber + 1로 설정
        long[] s = new long[numberOfNumber + 1];
        
        // 두 번째 줄을 읽고 공백을 기준으로 분리
        st = new StringTokenizer(br.readLine());
        
        // 누적 합 배열을 채움
        for(int i = 1; i <= numberOfNumber; i++) {
            // 현재 인덱스의 값은 이전 인덱스의 값에 현재 입력된 값을 더한 것
            s[i] = s[i - 1] + Integer.parseInt(st.nextToken());
        }
        
        // 퀴즈의 개수만큼 반복
        for(int q = 0; q < numberOfQuiz; q++) {
            // 각 퀴즈에서 i와 j 값을 읽음
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            
            // i부터 j까지의 구간 합을 출력
            // s[j]는 1부터 j까지의 합, s[i-1]는 1부터 i-1까지의 합
            // 따라서 s[j] - s[i-1]은 i부터 j까지의 합
            System.out.println(s[j] - s[i - 1]);
        }
    }
}
