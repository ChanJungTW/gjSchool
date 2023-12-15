package dao;

import java.util.List;

import model.student;

public interface studentDao {
	
	
	
	
	//create
	void add(student s);//建立一個add方法(引數為stuent物件)
	
	
	//read
	String queryAll();
	List<student> queryAll2();
	
	
	//update
	
	
	//delete

}
