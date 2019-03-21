import kr.or.bit.Employee;

public class Ex14_Constructor {

	public static void main(String[] args) {
		Employee emp = new Employee(); // default
		emp.EmployeeInfoPrint();
		System.out.println(emp.getName());

		Employee emp2 = new Employee(201901, "È«±æµ¿", "¿µ¾÷ÆÀ");

		emp2.EmployeeInfoPrint();

		System.out.println(emp2.getName());

		emp2.setJob("IT°³¹ßÆÀ");
		emp2.EmployeeInfoPrint();

		// Array ¸¦ »ç¿ëÇØ¼­ »ç¿ø 3¸íÀ» ¸¸µé¾î º¸¼¼¿ä
		Employee[] emplist = { new Employee(1, "±è¾¾", "IT"), new Employee(2, "Á¤¾¾", "¿µ¾÷ÆÀ"), new Employee(3, "Àå¾¾", "È¸°èÆÀ") };

		for (Employee em : emplist) {

		}

	}
}
