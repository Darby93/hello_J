package Bank2;

import java.util.ArrayList;

public class Bank {
	private ArrayList<Account> accounts;
	private int totalAccount;
	
	public Bank(){
		this.accounts = new ArrayList();
		totalAccount = 0;
	}
	
	public void addAccount(String accountNo, String name) {
		accounts.add(new Account(accountNo, name));
		totalAccount++;
	}
	
	public Account getAccount(String account) {
		for(int i = 0; i < accounts.size(); i++) {
			
		}
		return null;
	}
	
}
