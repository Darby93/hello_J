package kr.or.bit;

public class InitTest {
	public static int cv = 1;  //static ����, class ����!!  -  Ŭ���� �ε��ɶ�  
	public int iv = 1;   //������ �ʱ�ȭ 
	
    static { cv = 2;} //static �ʱ�ȭ ����, class �ʱ�ȭ ����    -  Ŭ���� �ε��ɶ�  
    { iv = 2;}  // �ν��Ͻ� �ʱ�ȭ ���� 
	
	public InitTest() { //������ �Լ� ( �ʱ�ȭ ���� : instance variable �ʱ�ȭ)
		iv = 3 ;
	}
	
	
	
	
	
}