package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import util.DBUtil;

public class DbTest {
	@Test
	public void test() throws Exception{
		Connection conn = DBUtil.getConnection();
		System.out.println(conn);
		String sql="select * from emp";
		Statement st = conn.createStatement();
		System.out.println(st);
		ResultSet rs = st.executeQuery(sql);
		System.out.println(rs.getRow());
	}
}
