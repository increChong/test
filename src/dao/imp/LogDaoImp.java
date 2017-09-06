package dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.LogDao;
import entity.Log;
import entity.User;

public class LogDaoImp implements LogDao{

	@Override
	public void insertLog(Log log) {
			PreparedStatement ps=null;
			Connection conn=null;
			try {
				String sql="insert into t_log values(?,?,?,?,?)";
				conn=util.DBUtil.getConnection();
				ps=conn.prepareStatement(sql);
				int index=1;
				ps.setString(index++,log.getAdminid());
				ps.setString(index++,log.getDone());
				ps.setString(index++,log.getObj());
				ps.setString(index++,log.getObjid());
				ps.setDate(index++,log.getDdate());
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
		


	@Override
	public List<Log> list() {
		List<Log> list =new ArrayList<Log>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Connection conn=null;
		
		try {
			String sql="select * from t_log ";
			conn=util.DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			Log log=null;
			while(rs.next()){
				log=new Log(rs.getString("adminid"), rs.getString("done"), rs.getString("obj"), rs.getString("objid"), rs.getDate("ddate"));
				list.add(log);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
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
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return list;

	}

}
