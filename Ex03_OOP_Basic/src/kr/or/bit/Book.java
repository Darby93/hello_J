package kr.or.bit;

/*
å�� �̸��� ������ �������ִ�
å�� ���ǵǸ� �ݵ�� å�� å�� �̸��� ������ ������ �־�� �Ѵ�
å�� �̸��� ���� ������ Ư�� ����� ���ؼ��� �� �� �ְ�
���ǵ� ���Ŀ��� ������ �� ����
å�̸��� ���������� ���� ������ ���� �� �ִ�
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
