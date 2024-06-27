/*

<개인적으로 너어어엉어ㅓ어어어어어어무 어려움>
p63 3_4_9. DNA 비밀번호 

시간 제한 2초, 실버4, 백준 온라인 저지 12891번

평소에 문자열을 가지고 노는 것을 좋아하는 민호는 DNA 문자열을 알게 되었다. 
DNA 문자열은 모든 문자열에 등장하는 문자가 {‘A’, ‘C’, ‘G’, ‘T’} 인 문자열을 말한다. 
예를 들어 “ACKA”는 DNA 문자열이 아니지만 “ACCA”는 DNA 문자열이다. 
이런 신비한 문자열에 완전히 매료된 민호는 임의의 DNA 문자열을 만들고 만들어진 DNA 문자열의 부분문자열을 비밀번호로 사용하기로 마음먹었다.
하지만 민호는 이러한 방법에는 큰 문제가 있다는 것을 발견했다. 
임의의 DNA 문자열의 부분문자열을 뽑았을 때 “AAAA”와 같이 보안에 취약한 비밀번호가 만들어 질 수 있기 때문이다. 
그래서 민호는 부분문자열에서 등장하는 문자의 개수가 특정 개수 이상이여야 비밀번호로 사용할 수 있다는 규칙을 만들었다.
임의의 DNA문자열이 “AAACCTGCCAA” 이고 민호가 뽑을 부분문자열의 길이를 4라고 하자. 
그리고 부분문자열에 ‘A’ 는 1개 이상, ‘C’는 1개 이상, ‘G’는 1개 이상, ‘T’는 0개 이상이 등장해야 비밀번호로 사용할 수 있다고 하자. 
이때 “ACCT” 는 ‘G’ 가 1 개 이상 등장해야 한다는 조건을 만족하지 못해 비밀번호로 사용하지 못한다. 
하지만 “GCCA” 은 모든 조건을 만족하기 때문에 비밀번호로 사용할 수 있다.
민호가 만든 임의의 DNA 문자열과 비밀번호로 사용할 부분분자열의 길이, 
그리고 {‘A’, ‘C’, ‘G’, ‘T’} 가 각각 몇번 이상 등장해야 비밀번호로 사용할 수 있는지 순서대로 주어졌을 때 
민호가 만들 수 있는 비밀번호의 종류의 수를 구하는 프로그램을 작성하자. 
단 부분문자열이 등장하는 위치가 다르다면 부분문자열이 같다고 하더라도 다른 문자열로 취급한다.

입력
첫 번째 줄에 민호가 임의로 만든 DNA 문자열 길이 |S|와 비밀번호로 사용할 부분문자열의 길이 |P| 가 주어진다. (1 ≤ |P| ≤ |S| ≤ 1,000,000)
두번 째 줄에는 민호가 임의로 만든 DNA 문자열이 주어진다.
세번 째 줄에는 부분문자열에 포함되어야 할 {‘A’, ‘C’, ‘G’, ‘T’} 의 최소 개수가 공백을 구분으로 주어진다. 
각각의 수는 |S| 보다 작거나 같은 음이 아닌 정수이며 총 합은 |S| 보다 작거나 같음이 보장된다.

출력
첫 번째 줄에 민호가 만들 수 있는 비밀번호의 종류의 수를 출력해라.

예제 입력 1
9 8                   // DNA 문자열의 길이, 부분 문자열의 길이
CCTGGATTG             // DNA 문자열
2 0 1 1               // 부분 문자열에 포함돼야 할 A, C, G, T의 최소 개수

예제 출력 1
0

예제 입력 2
4 2                   // DNA 문자열의 길이, 부분 문자열의 길이
GATA                  // DNA 문자열
1 0 0 1               // 부분 문자열에 포함돼야 할 A, C, G, T의 최소 개수

예제 출력 2
2

*/

package slidingWindow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DNAPassword {
	static int correctCount = 0; // A C G T가 있는지의 카운트 변수
	// 로컬 변수로 사용하면 각 메서드가 이 변수를 공유하지 않기 때문에
	 
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int stringLength = Integer.parseInt(st.nextToken()); // DNA 문자열의 길이
		int partsStringLength = Integer.parseInt(st.nextToken()); // 부분 문자열의 길이
		int checkArr[] = new int[4]; // A C G T 비밀번호 체크 배열
		int myDNAArr[] = new int[4]; // 내 문자열에서의 A C G T 갯수 담을 배열
		int result = 0;

		char[] DNAArr = new char[stringLength]; // DNA 문자열
		DNAArr = bf.readLine().toCharArray(); // DNA 문자열을 char배열로 변환

		st = new StringTokenizer(bf.readLine()); // 새로운 입력을 받기 위한 st객체 생성
		for (int i = 0; i < 4; i++) {
			checkArr[i] = Integer.parseInt(st.nextToken()); // A C G T의 최소 갯수 설정해 배열에 저장

			// 최소 갯수가 0이면, 해당 문자는 없어도 되므로 카운트를 올림
			if (checkArr[i] == 0) {
				correctCount++;
			}
		}

		// 부분 문자열 처리 부분
		for (int i = 0; i < partsStringLength; i++) {
			addDNACode(DNAArr[i], myDNAArr, checkArr);
		}
		
		if (correctCount == 4) {
			result++;
		}
		
//		System.out.println(result);
		
		// 슬라이딩 윈도우
		for (int i = partsStringLength; i < stringLength; i++) {
			int j = i - partsStringLength;
            removeDNACode(DNAArr[j], myDNAArr, checkArr);
            addDNACode(DNAArr[i], myDNAArr, checkArr);
//            System.out.println(result);	
			
			if (correctCount == 4) {
				result++;
			}
		} 
		System.out.println(result);
		bf.close();
	}
	
	public static void addDNACode(char DNACode, int[] myDNAArr, int[] checkArr) {
		switch (DNACode) {
		case 'A':
			myDNAArr[0]++;
			if ( myDNAArr[0] == checkArr[0]) {
				correctCount++;
			}
			break;
		
		case 'C':
			myDNAArr[1]++;
			if ( myDNAArr[1] == checkArr[1]) {
				correctCount++;
			}
			break;

		
		case 'G':
			myDNAArr[2]++;
			if ( myDNAArr[2] == checkArr[2]) {
				correctCount++;
			}
			break;
		
		case 'T':
			myDNAArr[3]++;
			if ( myDNAArr[3] == checkArr[3]) {
				correctCount++;
			}
			break;
		}
	}
	
	public static void removeDNACode(char DNACode, int[] myDNAArr, int[] checkArr) {
		switch (DNACode) {
		case 'A':
			if ( myDNAArr[0] == checkArr[0]) {
				correctCount--;
			}
			myDNAArr[0]--;
			break;
		
		case 'C':
			if ( myDNAArr[1] == checkArr[1]) {
				correctCount--; 
			}
			myDNAArr[1]--;
			break;

		
		case 'G':
			if ( myDNAArr[2] == checkArr[2]) {
				correctCount--;
			}
			myDNAArr[2]--;
			break;
		
		case 'T':
			if ( myDNAArr[3] == checkArr[3]) {
				correctCount--;
			}
			myDNAArr[3]--;
			break;
		}
	}
}
