import kr.or.bit.Employee;

public class Ex14_Constructor {

	public static void main(String[] args) {
		Employee emp = new Employee(); // default
		emp.EmployeeInfoPrint();
		System.out.println(emp.getName());

		Employee emp2 = new Employee(201901, "ȫ�浿", "������");

		emp2.EmployeeInfoPrint();

		System.out.println(emp2.getName());

		emp2.setJob("IT������");
		emp2.EmployeeInfoPrint();

		// Array �� ����ؼ� ��� 3���� ����� ������
		Employee[] emplist = { new Employee(1, "�达", "IT"), new Employee(2, "����", "������"), new Employee(3, "�徾", "ȸ����") };

		for (Employee em : emplist) {

		}

	}
}
