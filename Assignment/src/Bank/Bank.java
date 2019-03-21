package Bank;

import java.util.ArrayList;
import java.util.Iterator;

public class Bank {
	private ArrayList<Account> accounts;
	private int totalAccount;
	
	Bank(){
		accounts = new ArrayList<Account>();
		totalAccount = 0;
		
	}
	
	public void addAccount(String accountNo, String name) {
		accounts.add(new Account(accountNo, name));
	}
	
	public Account getAccount(String accountNo) {
		Iterator<Account> arr = accounts.iterator();
		Account account = null;
		while(arr.hasNext()) {
			Account account2 = arr.next();
			if(accountNo.equals(account2.getAccountNo())) {
				account = account2;
			}
		}
		
		if(account == null) {
			System.out.println("계좌가없다이놈아");
		}else {
			System.out.println(account);
		}
		
		
		return account;
		
	}
	
//	public Account findAccount(String name) {
//		Iterator<Account> arr = accounts.iterator();
//		Account account = null;
//		while(arr.hasNext()) {
//			Account account2 = arr.next();
//			if(name.equals(account.getAccountNo())) {
//				account = account2;
//			}
//		}
//		
//		if(account == null) {
//			System.out.println("계좌가없다이놈아");
//		}else {
//			System.out.println(account);
//		}
//		
//		
//		return account;
//		
//	}
	
	public ArrayList<Account> getAccounts(){
		Iterator<Account> it = accounts.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		return accounts;
	}
	
	public int getTotalAccount() {
		totalAccount = accounts.size();
		return totalAccount;
	}
	
}
