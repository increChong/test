package service;

import entity.Goods;
import entity.PageInfo;

public class GoodsServiceImp implements GoodsService {
			dao.GoodsDao dao=null;
			
			public GoodsServiceImp(){
				dao=new dao.imp.GoodsDaoImp();
			}
	@Override
	public PageInfo<Goods> goodsList(String id, int pagesize, int pageindex) {
		// TODO Auto-generated method stub
		return dao.list(id, pagesize, pageindex);
	}
	@Override
	public void insertGoods(Goods goods) {
		// TODO Auto-generated method stub
		dao.insertGoods(goods);
		
	}
	@Override
	public void removeGoods(String id) {
		// TODO Auto-generated method stub
		dao.removeGoods(id);
		
	}
	@Override
	public void updateGoods(Goods goods) {
		// TODO Auto-generated method stub
		dao.updateGoods(goods);
	}
	@Override
	public Goods getGoodsById(String id) {
		// TODO Auto-generated method stub
		return dao.getGoodsById(id);
	}

}
