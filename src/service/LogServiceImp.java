package service;

import java.util.List;

import entity.Log;

public class LogServiceImp implements LogService{
		dao.LogDao dao=new dao.imp.LogDaoImp();
	@Override
	public void insertLog(Log log) {
		// TODO Auto-generated method stub
			dao.insertLog(log);
		
	}

	@Override
	public List<Log> list() {
		// TODO Auto-generated method stub
		return dao.list();
	}

}
