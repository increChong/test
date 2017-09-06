package util;

import java.util.ArrayList;
import java.util.List;

import service.GoodsServiceImp;
import entity.Cart;
import entity.CookieItem;
import entity.Goods;

public class CartUtil {
	public static List<Cart> convertCookieItemListToCartList(List<CookieItem> list){
		
		if(list==null) return null;
		
		List<Cart> cart = new ArrayList<Cart>();
		Cart c = null;
		service.GoodsService gs = new GoodsServiceImp();
		for(int i=0;i<list.size();i++){
			CookieItem item = list.get(i);
			Goods goods = gs.getGoodsById(item.getGid());
			c =new Cart(item.getGid(), goods.getGtitle(), goods.getGsaleprice(), goods.getGinprice(), item.getAmount());
			cart.add(c);
		}
		return cart;
	}
}
