package com.john.limit.service;

import com.john.limit.dao.UserDao;
import com.john.limit.domain.User;

public class UserService {

	public User  login(String name, String pwd) throws Exception {
		UserDao userDao=new UserDao();
		User user=UserDao.checkUser(name,pwd);
		
		if(user==null) {
			throw new Exception ("用户名或密码错误");
		}
		else {
			return user;
		}
	}
	}


