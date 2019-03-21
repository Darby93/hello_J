package kr.or.bit;


/*	
�Լ� : ����� �ּ� ����(method)		

�Լ��� ����

*void (�����ִ� ���� ����) : return value �� ����
*return Type : [8���� �⺻ Ÿ��] + String + ����� ����(class) + Array + Collection + Interface
** �Լ��� return Type( ex. public int calc(){ return 100; } �ִٸ�
    �ݵ�� { ������� } �ȿ� return ������ ������ �־�� �Ѵ� !!!!�١ڡ١�
    
*parameter :  [8���� �⺻ Ÿ��] + String + ����� ����(class) + Array + Collection + Interface
    
    
1. void, prameter(0) �Ķ�������� : public void print (String str){ System.out.println(str) }
2. void, prameter() �Ķ��������x : public void print(){ System.out.println("hello") }
3. return Type, parameter(0) �Ķ�������� : public int call(int i) { return i + 100; }
4. return Type, parameter() �Ķ��������x : public int call( ) { return 1000; }
                 (�Ű�����)
�Լ�(method) �ݵ�� ȣ�� (Call) �Ǿ�� ���� �Ѵ� : ...........

*/	
public class FunctionClass {	
	
	public void m() { //�Լ��� �̸��� �ǹ��ִ� �ܾ��� ���� : getChannelNumber()
		System.out.println("�Ϲ��Լ� : void , prameter(x)");
	}
	
	public void m2(int i) {
		System.out.println("prameter value : " + i);
		System.out.println("�Ϲ��Լ� : void , prameter(o)");
	}
	
	public int m3() { //m3 �Լ��� ȣ���ϸ� 100��� ���� �����W
		return 100;
	}
	
	public int m4(int data) {
		return data + 100;
	}
	
	//������(������) : private �Լ�
	//� �ǹ��� �ڵ� : class ���ο��� ��� (�ٸ� �Լ��� �����ִ� ��Ȱ)
	//�ٸ� �������� �Լ��� ������ [�������� ����]�� �� ���� �Լ��� ��Ƽ� ����� ����
	//�������� (����) ����
	private int operationMethod(int data) {
		return data * 100;
	}
	
	public int sum(int data) {
		return operationMethod(data); // ���� ��Ȳ���δ� ������ �ڵ�! ������ ������ �پ� ���� x
	}
	
	public int sum2(int data) {
		int result = operationMethod(data);
		return result;
	}
	
	//Ȯ���Լ� (parameter ���� ������)
	public int sum3(int i, int j , int k) {
		return i + j + k; //������ ������ �����!
	}
	
	// ���� Quiz �ѻ�!
	//a �� b ���߿� ū ���� return �ϴ� �Լ��� ���弼��
	// public int max(int a , int b){ }
	//ȣ�� : max(100, 3) --> 100
	/*	
	30��
	if(a > b){
	   return a;
	}else{
	   return b;
	}
    
    60��
    int result = 0;
    if(a > b){
      result = a;
    }else{
      result = b;
    return result;
	*/	
	public int max (int a, int b) { //���� ������ Ȱ��
		return (a > b) ? a : b; // a��ũ�� b��ũ�� a��ũ��  a b��ũ�� b
	                            // ���� ? ������ �� Ʋ���� ��
		//return�� �ǵ��� �ϳ���
		//int max = (a > b) ? a : b
		//return max;
	}
	
	public String concat(String s, String s2, String s3) {
		return s + "/" + s2 + "/" + s3;
	}
	
	//��������� ������
	// Ŭ���� == Ÿ���̴� (Tv t; t = new Tv();
	//public int call() {return 100;}
	//public Tv call() {Tv t = new Tv(); return t;} //�ּҰ�
	//public Tv call() {return new Tv();} //�ּҰ�
	
	//public void call(Tv t){ System.out.println(t.name); }
	//Tv tt = new Tv();
	//tt.name = "�Ｚ";
	//call(tt);
	
	public Tv objMethod() { //Tv Ÿ���� ���� �ּҰ��� return
		Tv tt = new Tv(); //heap ��ü ����� �ּҰ� tt �� �Ҵ�
		tt.brandname = "������";
		return tt;
	}
	
	public Tv objMethod2() {
		return new Tv(); //heap ��ü ����� �ּҰ� return
	}
	
	public void objMethod3(Tv t) {
		System.out.println("Tv Ÿ�� ���� : " + t);
		System.out.println("ä�� ���� : " + t.ch);
		System.out.println("�귣���̸� : " + t.brandname);
	}
	

	
	
	
}