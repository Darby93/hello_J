/*
��ü ���� ��� Ư¡
���, ĸ��ȭ, ������

ĸ��ȭ (����ȭ) -> private

[method overloading]
[�ϳ��� �̸�]���� [�������� ���]�� �ϴ� �Լ�
��� : System.out.println() ��ǥ���� ��
Ư¡ : overloading ������� ������ ���� �ʴ´�
     why) ���ϰ� ����Ϸ���  >> �����ڰ�
       ����� � ���� ���� : �Լ��� Ȱ���� ���� ���
       
���� : �Լ��� �̸��� ���� parameter�� [����]�� [Ÿ��]�� �޸��ϴ� ���
1. �Լ��� �̸��� ���ƾ� �Ѵ�
2. [parameter] ���� �Ǵ� [Type]�� �޶���Ѵ�
3. return Type overloading �Ǵܱ����� �ƴϴ�
4. parameter ������ �ٸ��� ����
*/

class Human{
	String name;
	int age;
}

class OverTest{
	
	void add(Human m) { // class == Type
		m.name = "ȫ�浿";
		m.age = 100;
		System.out.println(m);
	}
	
	int add(int i) {
		return 100+i;
	}
	String add(String s) {
		return "hello";
	}
	
//	void add(int k) {} (parameter type �浹)
	int add(int i , int j) {
		return i + j;
	}
	
	void add(int i , String s) {
		System.out.println("�����ε�");
	}
	
	void add(String s , int i) { //�Ķ������ ������ �޶� �����ȴ�
		System.out.println("�����ε�");
	}
	
	
	
	//�迭(Array) �������
	//�����߱�.....
	//int[] source = {10,20,30,40,50};
	int[] add (int[] param) {  //parameter��  int �迭�� �ּҰ��� �ްڴ�
		int [] target = new int[param.length];
		
		for(int i = 0; i < param.length; i++) {
			target[i] = param[i] + 1;
		}
		
		return target; //int Ÿ���� �迭�� �ּҰ�
	}
	
	Human[] add(Human[] human) {
		Human[] h = new Human[human.length];
		return h;
	}
	
	
	int[][] add(int[] so, int[] so2) {
		int [][] bam = new int[so.length][so2.length];
		
		for(int i = 0; i < so.length; i++) {
			for(int j = 0; j < so2.length; j++) {
				
			}
		}
		
		return bam;
	}
	
	
}

public class Ex11_method_overloading {

	public static void main(String[] args) {
		/*
		System.out.println(100);
		System.out.println("HELLO");
		
		OverTest ot = new OverTest();
		System.out.println(ot.add(100));
//		ot.add(3.1f);   //float Ÿ���� �����°� ����  add(float f){}
		
		ot.add(100, "H");
		
		
		Human human = new Human();
		ot.add(human);
		System.out.println(human.name);
		System.out.println(human.age);
		
		ot.add(new Human());  // �ٽ�Ȯ��
		*/
		
		OverTest ot = new OverTest();
		//int Ÿ���� �迭�� �ּҸ� �־��.....
		int [] source = {10,20,30,40,50};
		System.out.println(source);
		int[] target = ot.add(source); //@I@15db9742 �ּҰ�
		for(int i = 0; i < target.length; i++){
			System.out.println(target[i]);
		}
		
		int [] source2 = {1,2,3,4,5};
		int [] source3 = {6,7,8,9,10};
		
		int[][] bam = ot.add(source2, source3);
		
		
	}

}