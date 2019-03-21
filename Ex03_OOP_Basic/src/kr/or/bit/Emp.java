package kr.or.bit;

/*
������ : ȫ�浿
��¥ : 2019-02-08
���� : Emp.java(�������)

class = ���赵 = Ÿ��
���赵�� �⺻���� ������Ҵ� (����, �������� + ��������)
                   (�Ӽ�(�ʵ�, ����) + ���(�Լ�, method))
                                      
*/
public class Emp {
	public int empno; // ��� (���� > ���� > member field > instance variable)
	public String ename; //�̸�
	public String job; //����
	
	private int sal; //�޿� (ĸ��ȭ, ����ȭ : �����Ҵ�)
	//sal ���� write(set), read(get)
	
	public int getSal(){ //read
		return sal;
	}
	
	public void setSal(int sal) { //write
		if(sal < 0) {
			this.sal = 0;
		}else {
			this.sal = sal;
		}
	}
	
	private int ngr; //������ ���

	public int getNgr() { //read (getter)
		return ngr;
	}

	public void setNgr(int ngr) { //write �ڵ����� �ϴ°� ���� (setter)
		this.ngr = ngr;
	}
	
	//��� (�Լ�)
	public String getEmpInfo() {
		return empno + "/" + ename + "/" + job + "/" + sal;
	}
	
	
	
	
}
