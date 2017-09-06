package dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.NewsDao;
import entity.News;

public class NewsDaoImp implements NewsDao {

	@Override
	public List<News> list() {
		List<News> list =new ArrayList<News>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Connection conn=null;
		
		try {
			String sql="select * from t_news";
			conn=util.DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()){
				list.add(new News(rs.getString("tid"), rs.getString("title"), rs.getString("tcontent"), rs.getString("tpubdate")) );
			}
			
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

	@Override
	public News getNewsById(String id) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		Connection conn=null;
		News news=null;
		try {
			String sql="select * from t_news where tid=?";
			conn=util.DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			
			while(rs.next()){
				news=new News(rs.getString("tid"), rs.getString("title"), rs.getString("tcontent"), rs.getString("tpubdate")) ;
			}
			
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
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return news;
	}

}
