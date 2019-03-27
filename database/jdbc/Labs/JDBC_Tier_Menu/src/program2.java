import java.util.List;
import java.util.Scanner;

import DAO.DepartmentDao;
import DTO.Department;





public class program2 {
	
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DepartmentDao dao = new DepartmentDao();

		
		//메뉴판
		while (true) {
			System.out.println("**********************\r\n" + 
					"*1.부서목록\r\n" + 
					"*2.부서등록\r\n" + 
					"*3.부서변경\r\n" + 
					"*4.부서삭제\r\n" + 
					"*5.부서검색\r\n" + 
					"*6.프로그램종료\r\n" + 
					"**********************");
			
			
			System.out.println("작업번호선택 : ");
            int menu = Integer.parseInt(sc.nextLine());

            switch (menu) {
                case 1:
                	System.out.println("부서 목록을 출력합니다");
                	dao.AllDepartment();
                	break;
                case 2:
                	System.out.println("부서를 등록합니다");
                	dao.insertDepartment();
                	break;
                case 3:
                
                case 4:
                	
                case 5:


                case 6:
                    System.exit(0);
                default:
                    System.out.println("제시된 번호 중에 선택해 주세요");
                    break;
            }
        }
		
		
		
		
	}

}
