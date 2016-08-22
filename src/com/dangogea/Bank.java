package com.dangogea;

import java.util.Scanner;

public class Bank {
	
	private final int deposit = 1;
	private final int withdraw = 2;
	private final int exit = 3;
	// final : 초기화가 된 후로 변경이 안된다. 

	private Account account;

	public void turnOn() {
		Scanner input = new Scanner(System.in);

		System.out.println("안녕하세요. ㅇㅇ은행입니다.");

		System.out.println("예금주를 입력하세요.");
		String accountHolder = input.nextLine();

		System.out.println("계좌 번호를 입력하세요.");
		String accountNumber = input.nextLine();

		System.out.println("개설일자를 입력하세요.");
		String createDate = input.nextLine();

		System.out.println("입금 금액을 입력하세요.");
		long balance = input.nextLong();

		account = new Account(accountNumber, accountHolder, createDate, balance);

		long money = 0;
		int selectedMenu = 0;
		boolean showBalance = false;
		while (true) {
			while (true) {
				System.out.println("업무를 선택하세요.");
				System.out.println("1. 입금");
				System.out.println("2. 출금");
				System.out.println("3. 종료");

				selectedMenu = input.nextInt();

				if (selectedMenu > 0 && selectedMenu < 4) {
					break;
				}

				System.out.println("잘못 선택하셨습니다.");
			}

			if (selectedMenu == deposit) {
				System.out.println("입금 금액을 입력하세요.");
				money = input.nextLong();
				showBalance = account.deposit(money);
			} else if (selectedMenu == withdraw) {
				while (true) {
					System.out.println("출금 금액을 입력하세요.");
					money = input.nextLong();
					showBalance = account.withdraw(money);
					if (showBalance) {
						break;
					}
				}

			} else if (selectedMenu == exit) {
				System.out.println("안녕히 가세요.");
				break;
			}

			if (showBalance) {
				account.showMyBalance();
				showBalance = false;
			}

		}
	}

	public static void main(String[] args) {
		new Bank().turnOn();
	}
}
