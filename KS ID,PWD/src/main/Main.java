package main;

import java.util.Scanner;

import eco.EcoControll;
import eco.EcoDto;
import utill.InputUtill;

public class Main {

	public static EcoDto loginUser = null;

	public static void main(String[] args) {
		
		String name;
		
		
		Scanner sc = new Scanner(System.in);
		EcoControll ec = new EcoControll();
		
		boolean isFinish = true;
		while(isFinish) {
			System.out.println("=========어서오세요============= ");
			System.out.println("=====  Eco.is = money   =====");
			
			System.out.println("1.회원가입 ");
			System.out.println("2. 로그인 ");
			System.out.println("3. 아이디 찾기");
			System.out.println("4. 비밀번호 찾기");
			
			
			String ip = sc.nextLine();
			
			switch(ip) {
			case "1" :
				break;
			case "2":
				ec.login();
				break;
			case "3":
				ec.findUser();
				break;
			case "4" :
				ec.changePwd2();
				break;
			
			    
				
			}
			
		}

	}

}
