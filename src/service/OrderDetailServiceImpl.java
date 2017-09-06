package service;

import entity.OrderDetail;
import service.OrderDetailService;

public class OrderDetailServiceImpl implements OrderDetailService {
	private dao.OrderDetailDao dao = new dao.imp.OrderDetaiDaoImpl();
	@Override
	public void insertOrderDetail(OrderDetail detail) {
		dao.insert(detail);
	}

}
