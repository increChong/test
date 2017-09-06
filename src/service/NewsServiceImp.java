package service;

import java.util.List;

import dao.NewsDao;
import entity.News;

public class NewsServiceImp implements NewsService {
			dao.NewsDao dao=null;
			
			public NewsServiceImp(){
				dao= new dao.imp.NewsDaoImp();
			}
	@Override
	public List<News> newsList() {
		// TODO Auto-generated method stub
		return dao.list();
	}
	@Override
	public News getNewsById(String id) {
		// TODO Auto-generated method stub
		return dao.getNewsById(id);
	}

}
