package utill;

import java.util.Scanner;

public class InputUtil {

	public static final Scanner sc = new Scanner(System.in);

	public static int getInt() {
		return Integer.parseInt(sc.nextLine());
		
	}
	//자동 대문자 변환 메소드
	public static String toUpperCase(String str) { // 유틸에 넣으면 될듯 자동 대문자 변환
		return (str == null) ? "" : str.toUpperCase();
	}

	public static String getString() {
		return sc.nextLine();
	}

}


