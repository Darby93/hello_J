package Bank;

import java.util.ArrayList;
import java.util.Iterator;

public class Account {
	private String accountNo;
	private String name;
	private long balance;
	private ArrayList<Transaction> transactions;
	
	
	
	@Override
	public String toString() {
		
		return " 계좌 번호 : " + accountNo + " 이름 : " + name;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Account(String accountNo) {
		this.accountNo = accountNo;
	}

	public Account(String accountNo, String name){
		this.accountNo = accountNo;
		this.name = name;
		balance = 0;
		transactions = new ArrayList<Transaction>();
	}
	
	public void deposit(long amount) {
		balance += amount;
		transactions.add(new Transaction("20190228","3시53분10초","입금",amount,balance));
	}
	
	public void withdraw(long amount) {
		if(balance < amount) {
			System.out.println("잔액 없어 이새끼야 ㅡㅡ  ㅛㅛ");
			return;
		}
		balance -= amount;
		
		transactions.add(new Transaction("20190228","3시53분10초","출금",amount,balance));
	}
	
	public long getBalance() {
		System.out.println("잔액은 : " + balance + "원 입니다.");
		return balance;	
	}
	
	public ArrayList<Transaction> getTransactions() {
		
		Iterator<Transaction> arr = transactions.iterator();
		while(arr.hasNext()) {
			System.out.println(arr.next());
		}
		
		return transactions;
	}
	
	
	
}
