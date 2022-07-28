package main;

import java.util.Scanner;

import member.MemberController;
import member.MemberDto;

public class Main {

	public static MemberDto loginUser = null;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		MemberController mc = new MemberController();
		
		boolean isFinish = false;
	    while(!isFinish) {
		System.out.println("\n----- this.eco = moneny; -----");
		
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("3. 종료");

		String input = sc.nextLine();

		switch (input) {
		case "1":
			break;
		case "2":
			int result = mc.join();
			if (result > 0)
				System.out.println("\n회원가입 성공!");
			else
				System.out.println("\n회원가입 실패");
			break;
		case "3":
			break;

		}
	   }
	}

}
