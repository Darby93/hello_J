import kr.or.bit.Book;

/*
  ������ �Լ�(constructor) : �ʱ�ȭ(member field) �Լ�
  1. Ư���� ������ ������ �Լ�(�ʱ�ȭ)
  2. �ʱ�ȭ(instance variable : member field)
  
  �Ϲ��Լ��� �ٸ���
 1. �Լ��� �̸��� ����(class �̸��� �ݵ�� �����ϰ� �ؾ���)
      �Ϲ��Լ��� �̸��� �پ�!
 2. ������ �Լ��� : return Ÿ���� (x), void(x)
    why : �������� ...   ��ü ������ ���ÿ� ȣ�� ���� �ѱ� ���� ����
 
 ���� : �����Ǵ� ��ü���� �ٸ� �ʱⰪ�� ������ ���� ��
 
 ������ �Լ� : overloading�� �����ϴ�(prameter�� ������ Ÿ���� �޸��ؼ�)
 
 class Car{
 int door; 
 Car(){ door = 10;}
 }
 ���� : Car c = new Car();
     1. stack ���� c ���� > default > null 
     2. Heap Car ��ü�� ���� > ������ ���� > memberfield�ε�(instance variable)
        > ������ �Լ� ȣ�� (�ε��� member field �ʱ�ȭ)
     3. class ������ default �����ڴ� ��������
       (���� ���� �������� �ʾƵ� �����Ϸ��� �˾Ƽ� ����)
       
 Tip) ������ �Լ��� overloading ���� ������ �� �Ⱦ��� ?
*/


class Car {
	String name;
	//����� ���� �������� �ʾƵ�
	//�����Ϸ��� �����ڰ� �ִٰ� ����
	//Car(){} ����(default) ������
}

class Car2 {
	String name;
	Car2(){
		System.out.println("���� ������ �Լ�");
		System.out.println("before : " + name);
		name = "mony";
		System.out.println("after : " + name);
	}
}

class Car3{
	int number;
	//������� : �ڵ�󿡼� default �����ڴ� �Ϲ������� ����
	Car3(){}
}

class Car4{
	int door;
	int wheel;
	
	Car4(){
		//default
		System.out.println("default");
	}
	
	Car4(int num){ //overloading
		door = num;
		System.out.println("overloading door : " + door);
	}
	
	Car4(int num, int num2){ //overloading
		door = num;
		wheel = num2;
		System.out.println("overloading door : " + door);
		System.out.println("overloading wheel : " + wheel);
	}
	
}

class Apt{
	String color;
	
	Apt(String color){
		this.color = color;
		//����Ʈ�� ������ ������ ������ ���� .... ������
		// Apt apt = new Apt();  ��� �Ұ���
		// Apt apt = new Apt("blue");  ��� ����
	}
}

class Apt2{
	String color;
	Apt2(){
		System.out.println("default");
	}
	Apt2(String color){
		this.color = color;
		//����Ʈ�� ������ ������ ������ ���� .... ������
		// Apt apt = new Apt();  ��� �Ұ���
		// Apt apt = new Apt("blue");  ��� ����
	}
}

public class Ex13_Constructor_Function {

	public static void main(String[] args) {
//		Car c = new Car();
//		Car2 c2 = new Car2();
//		Car3 c3 = new Car3();
		
		// new ġ��   ctrl + space ���� Ȯ���غ���
		Car4 c4 = new Car4(); //default ȣ���ؼ� ��ü ����
		System.out.println();
		Car4 c5 = new Car4(2); //param 1�� ȣ���ؼ� ��ü ����
		System.out.println();
		Car4 c6 = new Car4(3, 4); //param 2�� ȣ���ؼ� ��ü ����
		
		//�ڡ١ڡ�  �����ε��� �����ڸ� ������� ����Ʈ �����ڸ� ������ �ʾҴٸ� 
		//  ����Ʈ������  ��� �Ұ� >> �ڵ����� xx
		// ex) Apt apt = new Apt();
		//���赵�� �������� �ο��Ѵ� (overloading �� ���� ����ϰ� �ϰ����)
		
		Apt2 apt2 = new Apt2();
		Apt2 apt3 = new Apt2("gold");

//1. class ������ ������ �Լ� �������� ������ ... (default ������ �ڵ�����)
//ex) class Tv{String name;}


//2. class ������ overloading ������ �Լ��� �ϳ��� �����ߴٸ�
// **default ������ ��� �� �� ����**
// ������ ���� ����
//ex) class Tv(String name; Tv(String n){name = n}
		
//3. class ���� default, overloading �Ѵٱ���...
//�ʿ信 ���� default �� overloading ��� ���� ��
//ex) class Tv{(String name; Tv(){} Tv(String n){name = n}}
		
		System.out.println();
		Book book = new Book("BB",50000);
		book.Print();
		System.out.println(book.getName());
		System.out.println(book.getPrice());
		
		Book book2 = new Book("CC",999999);
		book2.Print();
		
		
		
	}

}
