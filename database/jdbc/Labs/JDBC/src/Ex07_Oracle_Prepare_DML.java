import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.or.bit.utils.SingletonHelper;

public class Ex07_Oracle_Prepare_DML {
	
	public static void main (String[] args) {
		//INSERT
		//insert into dmlemp(empno,ename,deptno) values(?,?,?)
		
		//UPDATE
		//update dmlemp set ename='?', sal=?, job=? , deptno=?
		//where empno=?
		
		Connection conn = null;
		PreparedStatement pstmt = null;
//		ResultSet rs = null;
		
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "update dmlemp set ename=?, sal=?, job=? , deptno=? where empno=?";
			
			pstmt = conn.prepareStatement(sql);
			
			//parameter
			pstmt.setString(1, "방가");
			pstmt.setInt(2, 20000);
			pstmt.setString(3, "IT");
			pstmt.setInt(4, 20);
			pstmt.setInt(5, 7839);
			
			//실행
			int row = pstmt.executeUpdate();
			if(row > 0) {
				System.out.println("update row count : " + row);
			}else {
				System.out.println("row count : " + row);
			}

	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(pstmt);
		}
		
	}
}
