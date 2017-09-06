package service;

import java.util.List;

import entity.Category;

public class CategoryServiceImp implements CategoryService {

	dao.CategoryDao dao=null;
	public CategoryServiceImp(){
		dao=new dao.imp.CategoryDaoImp();
	}
	@Override
	public List<Category> listCategory() {
		// TODO Auto-generated method stub
		return dao.list();
	}

}
