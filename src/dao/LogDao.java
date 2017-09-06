package dao;

import java.util.List;

import entity.Log;

public interface LogDao {
	void insertLog(Log log);
	List<Log> list();

}
