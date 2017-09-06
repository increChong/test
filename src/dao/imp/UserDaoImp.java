package dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.UserDao;
import entity.Category;
import entity.User;

public class UserDaoImp implements UserDao {

	@Override
	public void insertUser(User user) {
		PreparedStatement ps=null;
		Connection conn=null;
		try {
			String sql="insert into t_user values(?,?,?,?,?,?,?,?,?)";
			conn=util.DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			int index=1;
			ps.setString(index++,user.getUserid());
			ps.setString(index++,user.getUemail());
			ps.setString(index++,user.getUloginid());
			ps.setString(index++,user.getUpassword());
			ps.setString(index++,user.getUsex());
			ps.setString(index++,user.getUaddress());
			ps.setString(index++,user.getUtel());
			ps.setString(index++,user.getUstateid());
			ps.setString(index++,user.getUroleid());
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
	public User getUserByLoginId(String id) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		Connection conn=null;
		User user=null;
		try {
			String sql="select * from t_user where uloginid=?";
			conn=util.DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
				user=rs.next()?new User(rs.getString("userid"), rs.getString("uemail"), rs.getString("uloginid"), rs.getString("upassword"), rs.getString("usex"), rs.getString("uaddress"), rs.getString("utel"), rs.getString("ustateid"), rs.getString("uroleid")):null ;
			//System.out.println(user);
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
		//System.out.println(user);
		return user;
	}

	public void update(User user){
		PreparedStatement ps=null;
		Connection conn=null;
		try {
			String sql="update t_user set uemail=?,uloginid=?,upassword=?,usex=?,uaddress=?,utel=?,ustateid=?,uroleid=? where uloginid=?";
			conn=util.DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			int index=1;
			ps.setString(index++,user.getUemail());
			ps.setString(index++,user.getUloginid());
			ps.setString(index++,user.getUpassword());
			ps.setString(index++,user.getUsex());
			ps.setString(index++,user.getUaddress());
			ps.setString(index++,user.getUtel());
			ps.setString(index++,user.getUstateid());
			ps.setString(index++,user.getUroleid());
			ps.setString(index++,user.getUloginid());
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
	public List<User> list() {
		List<User> list =new ArrayList<User>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Connection conn=null;
		
		try {
			String sql="select * from t_user where uroleid='116F9526C319462780B9CA72F6BB9B41'";
			conn=util.DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			User user=null;
			while(rs.next()){
				user=new User(rs.getString("userid"), rs.getString("uemail"), rs.getString("uloginid"), rs.getString("upassword"), rs.getString("usex"), rs.getString("uaddress"), rs.getString("utel"), rs.getString("ustateid"), rs.getString("uroleid"));
				list.add(user);
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

	@Override
	public void removeUser(String id) {
		PreparedStatement ps=null;
		Connection conn=null;
		try {
			String sql="delete  from T_PASSWORDANSWER where userid=?";
			conn=util.DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
			//System.out.println(user);
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
		try {
			String sql="delete  from t_user where userid=?";
			conn=util.DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
			//System.out.println(user);
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
	


