package service;

import entity.Order;
import service.OrderService;

public class OrderServiceImpl implements OrderService {
	private dao.OrderDao dao = new dao.imp.OrderDaoImpl();
	@Override
	public void insertOrder(Order order) {
		dao.insert(order);
	}

}
