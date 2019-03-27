package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DTO.Department2;
import UTILS.SingletonHelper;

public class DepartmentDao2 {

	Scanner sc;
	Department2 department2;
	String sql;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public DepartmentDao2() {
		sc = new Scanner(System.in);
		department2 = new Department2();
		sql = "";
		conn = SingletonHelper.getConnection("oracle");
	}

	// 메뉴판 출력 함수
	public void menu() {
		while (true) {
			System.out.println("**********************\r\n" + "*1.부서목록\r\n" + "*2.부서등록\r\n" + "*3.부서변경\r\n"
					+ "*4.부서삭제\r\n" + "*5.부서검색\r\n" + "*6.프로그램종료\r\n" + "**********************");

			System.out.println("번호를 선택해 주세요");
			int menu = Integer.parseInt(sc.nextLine());

			switch (menu) {
			case 1:
				inquireAll();
				break;
			case 2:
				insertDartment2();
				break;
			case 3:
				updateDartment2();
				break;
			case 4:
				deleteDartment2();
				break;
			case 5:
				searchDartment2();
				break;
			case 6:
				System.out.println("시스템을 종료합니다");
				System.exit(0);
			default:
				System.out.println("번호를 다시 입력해 주세요");
				break;
			} // end switch

		} // end while
	} // end method

	// 부서등록(insert) 함수
	public void insertDartment2() {
		System.out.println("부서등록을 시작합니다");

		try {
			sql = "insert into department(deptno, dname) values(?,?)"; // 쿼리문 입력
			pstmt = conn.prepareStatement(sql); // 주소값 할당해 명령 객체 얻어오기

			System.out.println("부서 번호를 입력해 주세요");
			int deptno = Integer.parseInt(sc.nextLine());

			System.out.println("부서 이름을 입력해 주세요");
			String dname = sc.nextLine();

			department2.setDeptno(deptno);
			department2.setDname(dname);

			pstmt.setInt(1, deptno);
			pstmt.setString(2, dname);

			int row = pstmt.executeUpdate(); // insert 실행

			if (row > 0) {
				System.out.println("부서등록이 완료되었습니다");
			} else {
				System.out.println("부서등록에 실패하였습니다");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(pstmt);
		}

	}

	// 전체조회함수
	public void inquireAll() {
		try {
			List<Department2> Department2List = new ArrayList<Department2>();
			sql = "select deptno, dname from department"; // 쿼리문 입력
			pstmt = conn.prepareStatement(sql); // 주소값 할당해 명령 객체 얻어오기

			rs = pstmt.executeQuery();

			while (rs.next()) {
				department2 = new Department2();

				department2.setDeptno(rs.getInt("deptno"));
				department2.setDname(rs.getString("dname"));

				Department2List.add(department2);
				System.out.println(department2.toString());
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(pstmt);
			SingletonHelper.close(rs);
		}

	}

	// 부서변경함수
	public void updateDartment2() {
		try {
			System.out.println("부서를 변경합니다");

			sql = "update department set dname=? where deptno=?"; // 쿼리문 입력
			pstmt = conn.prepareStatement(sql); // 주소값 할당해 명령 객체 얻어오기
			
			
			System.out.println("부서 번호를 입력해 주세요");
			int deptno = Integer.parseInt(sc.nextLine());
			
			System.out.println("부서 이름을 입력해 주세요");
			String dname = sc.nextLine();

			department2.setDeptno(deptno);
			department2.setDname(dname);

			pstmt.setString(1, dname);
			pstmt.setInt(2, deptno);

			int row = pstmt.executeUpdate();

			if (row > 0) {
				System.out.println("부서변경이 완료되었습니다");
			} else {
				System.out.println("부서변경이 실패하였습니다");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(pstmt);
		}

	}

	// 부서삭제함수
	public void deleteDartment2() {
		try {
			System.out.println("부서를 삭제합니다");
			sql = "delete from department where deptno=?"; // 쿼리문 입력
			pstmt = conn.prepareStatement(sql); // 주소값 할당해 명령 객체 얻어오기

			System.out.println("부서 번호를 입력해 주세요");
			int deptno = Integer.parseInt(sc.nextLine());
			department2.setDeptno(deptno);
			pstmt.setInt(1, deptno);

			int row = pstmt.executeUpdate();

			if (row > 0) {
				System.out.println("부서삭제가 완료되었습니다");
			} else {
				System.out.println("부서삭제가 실패하였습니다");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(pstmt);
		}

	}

	// 부서검색
	public void searchDartment2() {
		try {
			System.out.println("부서를 검색합니다");
			sql = "select deptno, dname from department where deptno=?"; // 쿼리문 입력
			pstmt = conn.prepareStatement(sql); // 주소값 할당해 명령 객체 얻어오기

			System.out.println("부서 번호를 입력해 주세요");
			int deptno = Integer.parseInt(sc.nextLine());
			department2.setDeptno(deptno);
			pstmt.setInt(1, deptno);

			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				department2 = new Department2();
				department2.setDeptno(rs.getInt("deptno"));
				department2.setDname(rs.getString("dname"));
				System.out.println(department2.toString());
			} else {
				System.out.println("부서가 없습니다");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(pstmt);
		}

	}

}
