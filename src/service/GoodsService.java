package service;

import entity.Goods;
import entity.PageInfo;

public interface GoodsService {
          public PageInfo<Goods> goodsList(String id,int pagesize,int pageindex);
          void insertGoods(Goods goods);
  		void removeGoods(String id);
  		void updateGoods(Goods goods);
  		public Goods getGoodsById(String id);
}
