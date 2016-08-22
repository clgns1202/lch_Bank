package com.dangogea;

public class Account {

	private String accountNumber;
	private String accountHolder;
	private String createDate;
	private long balance;

	public Account() {

	}

	public Account(String accountNumber, String accountHolder, String createDate, long balance) {
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.createDate = createDate;
		this.balance = balance;

		System.out.println("계좌가 생성되었습니다.");
		showMyBalance();
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public boolean deposit(long money) {
		balance += money;
		System.out.printf("%,d원 입금 되었습니다.", money);
		return true;
	}

	public boolean withdraw(long money) {
		if (balance >= money) {
			balance -= money;
			return true;
		} else {
			System.out.println("잔액이 모자랍니다. 출금 할 수 없습니다.");
			return false;
		}
	}

	public void showMyBalance() {
		System.out.printf("[계좌번호: %s, 예금주: %s] 잔액: %,d\n", accountNumber, accountHolder, balance);
	}
}
