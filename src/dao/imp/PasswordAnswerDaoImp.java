package dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.PasswordAnswerDao;
import entity.PasswordAnswer;

public class PasswordAnswerDaoImp implements PasswordAnswerDao {

	@Override
	public void insertPasswordAnswer(PasswordAnswer passwordAnswer) {
		PreparedStatement ps=null;
		Connection conn=null;
		try {
			String sql="insert into t_passwordanswer values(?,?,?,?,?)";
			conn=util.DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			int index=1;
			ps.setString(index++,passwordAnswer.getAnswerid());
			ps.setString(index++,passwordAnswer.getSquestion());
			ps.setString(index++,passwordAnswer.getSanswer());
			ps.setString(index++,passwordAnswer.getUbackupemail());
			ps.setString(index++,passwordAnswer.getUserid());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(ps!=null)
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
	}

}
