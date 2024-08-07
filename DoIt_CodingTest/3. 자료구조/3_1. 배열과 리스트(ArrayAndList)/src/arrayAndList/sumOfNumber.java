package arrayAndList;

import java.util.Scanner;

//p35, 3_1. 숫자의 합 구하기
//N개의 숫자가 공백 없이 써 있다. 이 숫자를 모두 합해 출력하는 프로그램을 작성하시오
//입력 : 1번째 줄에 숫자의 개수 N(1<=N<=100), 2번째 줄에 숫자 N개가 공백 없이 주어진다.
//출력 : 입력으로 주어진 숫자 N개의 합을 출력한다.

class sumOfNumber {
 public static void main(String[] args) {
//    1. 범위를 보니 인트형 숫자를 받아 합할 수 없다.
//    2. String 형 사용.
//    3. String -> char형으로 변형
//    4. 아스키코드로 인트형으로 표현 하고 합구하기
    
    Scanner sc = new Scanner(System.in);
    
    int cntNum = sc.nextInt();
    sc.nextLine();
    String sNum = sc.nextLine().replaceAll("\\s+", "");;
    
    if (sNum.length() != cntNum)
    {
  	 System.out.println("숫자의 갯수를 맞게 입력해주세요");
    } else {
	      char[] cNum = sNum.toCharArray();
	      int number = 0;
	      int sum = 0;
	      
	      for (int i = 0; i < cNum.length; i++)
	      {
	         number = cNum[i] - 48 ;
	         sum += number;
	      }
	      
	      System.out.println(sum);
    }
    sc.close();
 }
}
