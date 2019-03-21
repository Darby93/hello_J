package kr.or.bit;

/*
책은 이름과 가격을 가지고있다
책이 출판되면 반드시 책은 책의 이름과 가격을 가지고 있어야 한다
책의 이름과 가격 정보는 특정 기능을 통해서만 볼 수 있고
출판된 이후에는 수정할 수 없다
책이름과 가격정보는 각각 정보를 읽을 수 있다
*/
public class Book {
	private String name;
	private int price;
	
	public Book(String name, int price){
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
	
	public void Print() {
		System.out.println(name);
		System.out.println(price);
	}
	
	


	
}
