package dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import dao.GoodsDao;
import entity.Goods;
import entity.PageInfo;

public class GoodsDaoImp implements GoodsDao {

	@Override
	public PageInfo<Goods> list(String id, int pagesize, int pageindex) {
PageInfo<Goods> pageinfo = new PageInfo<Goods>();
		
		List<Goods> list = new ArrayList<Goods>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			//1��ȡ����
			conn = DBUtil.getConnection();
			//2ͨ�����Ӵ���preparedstatement����;
			String sql="select t2.* from (select t1.* ,rownum rn from (select * from t_goods where cid=? order by to_number(gid)) t1 where rownum<=? ) t2 where rn>=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			int endindex = pagesize * pageindex;
			int startindex = (pageindex-1)*pagesize +1;
			ps.setInt(2, endindex);
			ps.setInt(3, startindex);
			//3ִ�в���
			rs = ps.executeQuery();
			//4ȡ����;
			Goods goods = null;
			while(rs.next()){
				goods = new Goods(rs.getString("gid"), rs.getString("gtitle"), rs.getString("gauthor"), rs.getString("gsaleprice"), rs.getString("ginprice"), rs.getString("gdesc"), rs.getString("gimg"), rs.getString("gclicks"), rs.getString("cid"), rs.getString("pid"));
				list.add(goods);
			}
			//��pageinfo����ֵ;
			pageinfo.setData(list);
			pageinfo.setIsfirstpage(pageindex==1);
			int totalnumber = this.totalRecords(id);
			int totalpage = totalnumber % pagesize ==0 ? totalnumber / pagesize : totalnumber /pagesize +1;
			pageinfo.setIslastpage(totalpage==pageindex);
			pageinfo.setPageindex(pageindex);
			pageinfo.setPagesize(pagesize);
			pageinfo.setTotalnumber(totalnumber);
			pageinfo.setTotalpage(totalpage);
			
		}catch(Exception e){
			
		}
		finally{
			//5�رն���
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//System.out.println(pageinfo);
		return pageinfo;
	}

	@Override
	public int totalRecords(String cid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int total = 0;
		try{
			//1��ȡ����
			conn = DBUtil.getConnection();
			//2ͨ�����Ӵ���preparedstatement����;
			String sql="select count(*) from t_goods where cid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, cid);
			//3ִ�в���
			rs = ps.executeQuery();
			//4ȡ����;
			if(rs.next()){
				total = rs.getInt(1);
			}
		}catch(Exception e){
			
		}
		finally{
			//5�رն���
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//System.out.println(total);
		return total;
	}

	@Override
	public Goods getGoodsById(String id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Goods goods = null;
		try{
			//1��ȡ����
			conn = DBUtil.getConnection();
			//2ͨ�����Ӵ���preparedstatement����;
			String sql="select * from t_goods where gid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			//3ִ�в���
			rs = ps.executeQuery();
			//4ȡ����;
			while(rs.next()){
				goods = new Goods(rs.getString("gid"), rs.getString("gtitle"), rs.getString("gauthor"), rs.getString("gsaleprice"), rs.getString("ginprice"), rs.getString("gdesc"), rs.getString("gimg"), rs.getString("gclicks"), rs.getString("cid"), rs.getString("pid"));
			}	
		}catch(Exception e){
			
		}
		finally{
			//5�رն���
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	//System.out.println(goods);
		return goods;
	}

	@Override
	public void insertGoods(Goods goods) {
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = DBUtil.getConnection();
			String sql="insert into t_goods values(?,?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			int index=1;
			ps.setString(index++,goods.getGid() );
			ps.setString(index++,goods.getGtitle() );
			ps.setString(index++,goods.getGauthor() );
			ps.setString(index++,goods.getGsaleprice() );
			ps.setString(index++,goods.getGinprice() );
			ps.setString(index++,goods.getGdesc() );
			ps.setString(index++,goods.getGimg() );
			ps.setString(index++,goods.getGclicks() );
			ps.setString(index++,goods.getCid() );
			ps.setString(index++,goods.getPid() );
            ps.executeUpdate();
		}catch(Exception e){
		}
		finally{
			try {
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void removeGoods(String id) {
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = DBUtil.getConnection();
			String sql="delete from t_goods where gid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
            ps.executeUpdate();
		}catch(Exception e){
		}
		finally{
			try {
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	@Override
	public void updateGoods(Goods goods) {
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = DBUtil.getConnection();
			String sql="update t_goods set gtitle=?,gauthor=?,gsaleprice=?,ginprice=?,gdesc=?,gimg=?,gclicks=?,cid=?,pid=? where gid=?";
			ps = conn.prepareStatement(sql);
			int index=1;
			ps.setString(index++,goods.getGtitle() );
			ps.setString(index++,goods.getGauthor() );
			ps.setString(index++,goods.getGsaleprice() );
			ps.setString(index++,goods.getGinprice() );
			ps.setString(index++,goods.getGdesc() );
			ps.setString(index++,goods.getGimg() );
			ps.setString(index++,goods.getGclicks() );
			ps.setString(index++,goods.getCid() );
			ps.setString(index++,goods.getPid() );
			ps.setString(index++,goods.getGid() );
            ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try {
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
