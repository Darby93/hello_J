package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DTO.Dept;
import UTILS.SingletonHelper;

//DAO 목적 
//1. DB 연결
//2. CRUD 작업
//3. 5가지 method(select ALL, select where, insert, update, delete)

public class DeptDao {
	
	/*
	한번 해주면 밑에거 빼줄필요 x
	Connection conn = null;
	public DeptDao() {
		conn = SingletonHelper.getConnection("oracle");
	}
	*/
	
	
	
	
	//1. 전체 조회 >> select 결과 >> return multi row
	public List<Dept> getDeptAllList(){
		//여러건의 데이터 담는 클래스
		List<Dept> deptlist = new ArrayList<Dept>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "select deptno, dname, loc from dept";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Dept dept = new Dept(); // 하나의 row 담기 위한 객체
				// 이걸 밖으로 빼면 오버라이트 되다가 마지막 것만 들어감
				
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
				deptlist.add(dept); //배열에 객체 담는 것
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		}
		return deptlist;
	}
	
	//2. 조건조회 >> select 결과(where deptno=?) >> return single row
	public Dept getDeptListByDeptno(int deptno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Dept dept = null;
		
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "select deptno, dname, loc from dept where deptno = ?";
			
			pstmt = conn.prepareStatement(sql); //커리문을 oracle로 보내서 컴파일 ....
	
			pstmt.setInt(1, deptno); 
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				do {
					dept = new Dept();
					dept.setDeptno(rs.getInt("deptno"));
					dept.setDname(rs.getString("dname"));
					dept.setLoc(rs.getString("loc"));
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
		
		return dept;
	}
	
	//3. 데이터 삽입
	//public int insertDept(int deptno, String dname, String loc).... (X)
	public int insertDept(Dept dept) {
		//insert into dept(deptno, dname, loc) values(?,?,?)
		 Connection conn = null;
		 PreparedStatement pstmt=null;
		 int rowcount = 0;
		 
		 try {
			 conn = SingletonHelper.getConnection("oracle");
			 String sql="insert into dept(deptno,dname,loc) values(?,?,?)";
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setInt(1, dept.getDeptno());
			 pstmt.setString(2, dept.getDname());
			 pstmt.setString(3, dept.getLoc());
			 rowcount = pstmt.executeUpdate(); 
			 
		 }catch (Exception e) {
			 e.printStackTrace();
			 System.out.println(e.getMessage());
		 }finally {
			 SingletonHelper.close(pstmt);
		 }
		 
		 return rowcount;
	}
		
	//4. 데이터 수정
	public int updateDept(Dept dept) {
		//update dept set dname=? , loc=? where deptno=?
		Connection conn = null;
		 PreparedStatement pstmt=null;
		 int rowcount = 0;
		 
		 try {
			 conn = SingletonHelper.getConnection("oracle");
			 String sql="update dept set dname=? , loc=? where deptno=?";
			 pstmt = conn.prepareStatement(sql);
			 
			 pstmt.setString(1, dept.getDname());
			 pstmt.setString(2, dept.getLoc());
			 pstmt.setInt(3, dept.getDeptno());
			 
			 rowcount = pstmt.executeUpdate(); 
			 
		 }catch (Exception e) {
			 e.printStackTrace();
			 System.out.println(e.getMessage());
		 }finally {
			 SingletonHelper.close(pstmt);
		 }
		 
		 return rowcount;
	}
	
	//5. 데이터 삭제
	public int deleteDept(int deptno) {
		//delete from dept where deptno=?
		Connection conn = null;
		 PreparedStatement pstmt = null;
		 int rowcount = 0;
		 
		 try {
			 conn = SingletonHelper.getConnection("oracle");
			 String sql="delete from dept where deptno=?";
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setInt(1, deptno);
			 rowcount = pstmt.executeUpdate();
		 }catch (Exception e) {
			 e.printStackTrace();
			 System.out.println(e.getMessage());
		 }finally {
			 SingletonHelper.close(pstmt);
		 }
		 
		 return rowcount;
	}
	
	
}
