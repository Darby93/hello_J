package Bank;

public class Transaction {
	private String transactionDate;
	private String transactionTime;
	private String kind;
	private long amount;
	private long balance;
	
	
	
	public Transaction(String transactionDate, String transactionTime, String kind, long amount, long balance) {
		this.transactionDate = transactionDate; // 거래일
		this.transactionTime = transactionTime; //거래시간
		this.kind = kind; // 구분
		this.amount = amount; // 거래금액
		this.balance = balance; // 잔고
	}
	
	@Override
	public String toString() {
		return " 거래 날짜 : " + this.transactionDate 
				+"\n 거래 시간 : " + this.transactionTime
				+"\n 구분 : " + this.kind
				+"\n 거래금액 : " + this.amount
				+"\n 잔고 : " + this.balance;
	}

	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(String transactionTime) {
		this.transactionTime = transactionTime;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	
	
	
}
