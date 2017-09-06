package service;

import entity.PasswordAnswer;

public class PasswordAnswerServiceImp implements PasswordAnswerService {

	dao.PasswordAnswerDao dao=new dao.imp.PasswordAnswerDaoImp();
	@Override
	public void insertPasswordAnswer(PasswordAnswer passwordAnswer) {
		
		dao.insertPasswordAnswer(passwordAnswer);
	}

}
