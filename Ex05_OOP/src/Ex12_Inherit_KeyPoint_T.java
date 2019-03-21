/*
시나리오(요구사항)
저희는 가전제품 매장





*/

class Product{ //전자제품
	int price;
	int bonuspoint;
	
	//Product()}
	Product(int price){
		this.price = price;
		this.bonuspoint = (int)(this.price/10.0);
	}
}

class KtTv extends Product{
	KtTv(){
		super(5000);
	}

	@Override
	public String toString() {
		return "KtTv";
	}
}

class Audio extends Product{
	Audio(){
		super(6000);
	}

	@Override
	public String toString() {
		return "Audio";
	}
}

class Notebook extends Product{
	Notebook(){
		super(10000);
	}

	@Override
	public String toString() {
		return "Notebook";
	}
}

class Buyer{


	int money = 10000;
	int bonuspoint = 0;
	
	void kttvBuy(KtTv kttv) { //구매 (상품정보) //KtTv parameter로
		if(this.money < kttv.price) {
			System.out.println("고객님 잔액이 부족합니다");
			return;
		}
		//실 구매행위
		this.money -= kttv.price;
		this.bonuspoint += kttv.bonuspoint;
		System.out.println("구매한 물건은 : " + kttv.toString());
	}
	
	void audioBuy(Audio audio) { //구매 (상품정보) //KtTv parameter로
		if(this.money < audio.price) {
			System.out.println("고객님 잔액이 부족합니다");
			return;
		}
		//실 구매행위
		this.money -= audio.price;
		this.bonuspoint += audio.bonuspoint;
		System.out.println("구매한 물건은 : " + audio.toString());
	}
	
	void notebookBuy(Notebook notebook) { //구매 (상품정보) //KtTv parameter로
		if(this.money < notebook.price) {
			System.out.println("고객님 잔액이 부족합니다");
			return;
		}
		//실 구매행위
		this.money -= notebook.price;
		this.bonuspoint += notebook.bonuspoint;
		System.out.println("구매한 물건은 : " + notebook.toString());
	}
	
	/*
	구매행위
	구매행위(잔액 - 제품가격, 포인트 정보 갱신)
	구매자는 매장에 있는 모든 제품을 구매할 수 있어야 함
	구매행위 하는 함수 구현
	KtTv, Audio, NoteBook 구매가능
	
	1차 오픈 문제가 없다면 하와이 휴가
	
	매장에 제품이 1000개 다른 제품이 추가(POS 등록 자동화)
	물건이 오면 매장에 자동 배치가됨
	세일 >> 고객 >> 핸드폰구매 
	kttv, audio, notebook 제외한 997개의 제품이 구매행위 불가
	...☆★ 제품이 추가 될 때마다 구매함수 구현해야만 하도록 만들어둠....☆★ 
	
	  요구사항 : 제품이 추가 되더라도 하와이에서 휴가....
	*/
}



public class Ex12_Inherit_KeyPoint_T {

	public static void main(String[] args) {
		KtTv tv = new KtTv();
		Notebook notebook = new Notebook();
		Audio audio = new Audio();
		
		Buyer buyer = new Buyer();
		buyer.kttvBuy(tv);
		buyer.notebookBuy(notebook);
		buyer.notebookBuy(notebook);
		buyer.audioBuy(audio);
//		System.out.println(tv.toString());
//		System.out.println(tv.price);
//		System.out.println(tv.bonuspoint);
		
		

		
		
	}

}
