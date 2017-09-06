package service;

import java.util.List;

import entity.Log;

public interface LogService {
	void insertLog(Log log);
	List<Log> list();
}
