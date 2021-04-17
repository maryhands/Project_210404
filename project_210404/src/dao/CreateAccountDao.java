package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateAccountDao  {
   Connection con = null;
   PreparedStatement pstmt = null;
   DBConnectionMgr dbMgr = null;
   
   public void insert(CreateAccountVO caVO){//오라클에  회원 정보를 넣는 부분
      StringBuilder sql_insert = new StringBuilder();
      sql_insert.append("insert into");
      sql_insert.append(" wk_member(member_num, id, pw, deptno, name, email, gender)");
      sql_insert.append(" values(seq_member.NEXTVAL,?,?,?,?,?,?)");
      dbMgr = DBConnectionMgr.getInstance();
      try {
         con = dbMgr.getConnection();
         pstmt = con.prepareStatement(sql_insert.toString());
         int i=1;
         pstmt.setString(i++, caVO.getId());
         pstmt.setString(i++, caVO.getPw());
         pstmt.setString(i++, caVO.getDeptno());
         pstmt.setString(i++, caVO.getName());
         pstmt.setString(i++, caVO.getEmail());
         pstmt.setString(i++, caVO.getGender());
      } catch (SQLException se) {
         System.out.println("[[sql_insert]]" +sql_insert);
      } catch (Exception e) {
         e.printStackTrace();
      } 
      try {
         int result = pstmt.executeUpdate();
         if(result > 0) {
            System.out.println("ok");
         }else {
            System.out.println("fail");
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         dbMgr.freeConnection(con, pstmt);
      }
   }
}