/*
Today Point : [��� ����]���� override : ��Ӱ��迡���� �޼��� �� ����
- ��Ӱ��迡�� �ڽ�Ŭ������ �θ�Ŭ������ �޼ҵ带 ������
- ������ : �Լ��� ���´� ��ȭ�� ���� ..... ���븸 �ٲ��������������̴� ��
       : Ʋ�� ��ȭ�� �Ƴ��� ������ ��ȭ {�Լ��� ���� �� ���� ����}

����)
1. �θ��Լ��� �̸��� ����
2. �θ��Լ��� parameter ����
3. �θ��Լ��� return type ����
4. �ᱹ���� { ��ȣ�ȿ� ���� ���� } \

*/

class Point5 {
	int x = 4;
	int y = 5;
	String getPosition() {
		return " x : " + this.x + " y : " + this.y;
	}
}

//3���� ���� �ʿ��ϴ�
//2���� ���� ������ �ִ� ���赵 ...

class Point3D extends Point5 {
	int z = 6;
	
//	���콺 ��Ŭ�� �ҽ��� ���ͼ��� ó�� �������̵� ����� �� ����
//	@Override
//	String getPosition() {
//		// TODO Auto-generated method stub
//		return super.getPosition();
//	}
	
    //	String getPosition() {return " x : " + this.x + " y : " + this.y +  " z : " + z}
	// Ʋ���� �ƴѵ� �������̵带���� ��
	
	//�����Ǹ� �����ϴ� ���
	//@Override ���� (Annotation)
	//Annotation : JAVA code ������ ������ �� ���� �ΰ����� ����
	//[�����Ϸ�]�� [������] �����ϴ� ���
	
//	@Override : ������ �˻�.....
	@Override
	String getPosition() {
		return " x : " + this.x + " y : " + this.y + " z : " + z; //������!  ���븸!
	}
	
	
	
}


public class Ex04_Inherit_override {

	public static void main(String[] args) {
		Point3D point = new Point3D();
		point.x = 3;
		point.y = 6;
		point.z = 9;
		
		String result = point.getPosition();
		System.out.println(result);
		
	}

}
