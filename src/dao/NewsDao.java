package dao;

import java.util.List;

import entity.News;

public interface NewsDao {
			List<News> list();
			News getNewsById(String id);
}
