package dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CategoryDao;
import entity.Category;
import entity.News;

public class CategoryDaoImp  implements CategoryDao{

	@Override
	public List<Category> list() {
		
			List<Category> list =new ArrayList<Category>();
			PreparedStatement ps=null;
			ResultSet rs=null;
			Connection conn=null;
			
			try {
				String sql="select * from T_CATEGORY";
				conn=util.DBUtil.getConnection();
				ps=conn.prepareStatement(sql);
				rs=ps.executeQuery();
				Category cate=null;
				while(rs.next()){
					cate=new Category(rs.getString("cid"), rs.getString("cname")) ;
					list.add(cate);
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
