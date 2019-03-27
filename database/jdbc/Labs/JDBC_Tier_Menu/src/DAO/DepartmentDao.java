package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DTO.Department;

import UTILS.SingletonHelper;

public class DepartmentDao {
	
	
	public static void DepartmentPrint(Department department) {
		System.out.println(department.toString());
	}
	
	public static void DepartmentPrint(List<Department> list) {
		for(Department data : list) {
			System.out.println(data.toString());
		}
	}
//	public DepartmentDao() {
//		
//	}
	
	//1. 전체 조회
	
	public List<Department> AllDepartment(){
		
		List<Department> dpList = new ArrayList<Department>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "select deptno, dname from department";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Department department = new Department();
				department.setDeptno(rs.getInt("deptno"));
				department.setDname(rs.getString("dname"));
				dpList.add(department);
			}
			
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		} finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
			
		}
		
		
		if(dpList != null) {
			DepartmentPrint(dpList);
		}
		
		return dpList;
	}
	
	
	//2. 조건조회
	public void inquireDepartment() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Department department = null;
		Scanner sc = new Scanner(System.in);
		
		
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "select deptno, dname, loc from department where where deptno = ?";
			
			pstmt = conn.prepareStatement(sql); //커리문을 oracle로 보내서 컴파일 ....
			
			System.out.println("부서번호를 입력하세요");
			int deptno = Integer.parseInt(sc.nextLine());
			pstmt.setInt(1, deptno); 
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				do {
					department = new Department();
					department.setDeptno(rs.getInt("deptno"));
					department.setDname(rs.getString("dname"));
					
				}while(rs.next());
			}else {
				System.out.println("조회된 데이터가 없습니다");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
			
		}

	}
	
	//3. 데이터 삽입
	public void insertDepartment() {
		//insert into dept(deptno, dname, loc) values(?,?,?)
	   	 Department insertDepartment = new Department();
		 Connection conn = null;
		 PreparedStatement pstmt=null;
		 Scanner sc = new Scanner(System.in);
		 int deptno = 0;
		 String dname = "";
		 
		 int rowcount = 0;
		 
		 try {
			 conn = SingletonHelper.getConnection("oracle");
			 String sql="insert into department(deptno,dname) values(?,?)";
			 pstmt = conn.prepareStatement(sql);
			 
			 System.out.println("삽입할 부서번호를 입력하세요");
			 deptno = Integer.parseInt(sc.nextLine());
			 insertDepartment.setDeptno(deptno);
			 pstmt.setInt(1, deptno);
			 
			 System.out.println("삽입할 부서명을 입력하세요");
			 dname = sc.nextLine();
			 insertDepartment.setDname(dname);
			 pstmt.setString(2, dname);
			 
			 rowcount = pstmt.executeUpdate(); 

		 }catch (Exception e) {
			 e.printStackTrace();
			 System.out.println(e.getMessage());
		 }finally {
			 SingletonHelper.close(pstmt);
		 }
		 
		 System.out.println("데이터가 삽입 되었습니다");
		 
	}
	//4. 데이터 수정
	
	//5. 데이터 삭제
	
	
	
	
	
	
	
	
	
}
