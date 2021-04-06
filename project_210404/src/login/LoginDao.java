package login;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
public class LoginDao {
	Connection con = null;
	CallableStatement cstmt = null;
	DBConnectionMgr dbMgr = null;
	public String login(String p_id, String p_pw) {
		String msg = "";
		dbMgr = DBConnectionMgr.getInstance();
		try {
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call p_login(?,?,?)}");
			cstmt.setString(1, p_id);
			cstmt.setString(2, p_pw);
			cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
			int result = 0;
			result = cstmt.executeUpdate();
			if(result==1) {
				msg = cstmt.getString(3);
			}
			System.out.println(cstmt.getNString(3));
		} catch (SQLException se) {

		} catch (Exception e) {
			
		} finally {
			dbMgr.freeConnection(con, cstmt);
		}
		return msg;
	}
	public static void main(String[] args) {
		LoginDao ld = new LoginDao();
		System.out.println("만세!!!!!");
		ld.login("","");
	}
}
