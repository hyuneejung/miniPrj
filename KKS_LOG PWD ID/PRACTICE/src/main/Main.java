package main;

import java.util.Scanner;

import member.EcoControll;
import member.EcoDto;
import member.MemberController;



public class Main {

		public static EcoDto LoginUser = null;
		
		public static void main(String[] args) {

			String name;
			EcoDto loginUser = null;
			
			
			Scanner sc = new Scanner(System.in);
			MemberController mc = new MemberController();
			EcoControll ec = new EcoControll();
			
			boolean isFinish = false;
		    while(!isFinish) {
			System.out.println("\n----- this.eco = money; -----");
			
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. 종료");
			System.out.println("4. 비번찾기");

			String input = sc.nextLine();

			switch (input) {
			case "1":
				ec.login();
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
			case "4": 
				ec.changePwd();
				break;
			
				
		    }
		}
	}

}
