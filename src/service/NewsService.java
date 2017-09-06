package service;

import java.util.List;

import entity.News;

public interface NewsService {
	public List<News> newsList();
	News getNewsById(String id);
}
