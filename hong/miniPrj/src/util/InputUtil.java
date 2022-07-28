package util;

import java.util.Random;
import java.util.Scanner;

public class InputUtil {

	public static final Scanner sc = new Scanner(System.in);
	   
	   public static int getInt() {
	      return Integer.parseInt(sc.nextLine());
	   }
	   
	   public static String getString() {
	      return sc.nextLine();
	   }

	   public static String toUpperCase(String str) { //유틸에 넣으면 될듯 자동 대문자 변환
	      return (str == null) ? "" : str.toUpperCase();
	   }
	   
	   public static String randomNum(int len, int dupCd) { //~~~랜덤숫자생성~~~~~
	      // len : 생성할 난수의 길이
	      // dupCd : 중복 허용 여부 (1: 중복허용, 2: 중복제거)
	      Random rd = new Random();
	      String numStr = "";
	      
	      for(int i = 0; i < len ; i++) {
	         String rdn = Integer.toString(rd.nextInt(10));//난수생성
	         if(dupCd == 1 ) {
	            numStr += rdn;//증복 허용 시 numStr에 보냄
	         }else if(dupCd == 2) {
	            //증복 허용 안할 시 증복 검사
	            if(!numStr.contains(rdn)) {
	               //증복 값 없으면 numStr에 보냄
	               numStr += rdn;
	            }else {
	               //생성된 난수가 증복되면 루틴 다시 시작
	               i -= 1;
	            }
	         }
	      }
	      return numStr;
	   }//randomNum

	
}
