package dao;

import entity.Goods;
import entity.PageInfo;

public interface GoodsDao {
		public PageInfo<Goods> list(String id,int pagesize,int pageindex);
		public int totalRecords(String cid);
		public Goods getGoodsById(String id);
		void insertGoods(Goods goods);
		void removeGoods(String id);
		void updateGoods(Goods goods);
}
