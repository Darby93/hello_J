package Bank2;

import java.util.ArrayList;

public class Account {
	private String accountNo;
	private String name;
	private long balance;
	private ArrayList<Transaction> transactions;
	
	
	
	public Account(String accountNo, String name) {
		this.accountNo = accountNo;
		this.name = name;
		balance = 0;
		transactions = new ArrayList<Transaction>();
	}





	

	

	public void deposit(long amount) {
		this.balance += amount;
		transactions.add(new Transaction("2","4","입금",amount,this.balance));
	}
	
	public void withdraw(long amount) {
		if(balance > amount) {
		this.balance -= amount;
		transactions.add(new Transaction("2","4","입금",amount,this.balance));
		}else {
			System.out.println("잔액이 부족합니다");
		}
	}
	
	public void getBalance() {
		System.out.println(this.balance);
	}
	
	public ArrayList<Transaction> getTransactions(){
		return transactions;
	}
	
}
