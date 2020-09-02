package edu.neusoft.service;

import edu.neusoft.dao.UserDao;
import edu.neusoft.model.Area;
import edu.neusoft.model.User;

import java.util.List;

public class UserService {
    UserDao userDao = new UserDao();

    //提供获取用户名的方法
    public int getUserRoleS(User user){
        return userDao.getUserRole(user);
    }

    //添加用户
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    //查询所有用户
    public List<User> searchAllUser(){
        return userDao.searchAllUser();
    }

    //查询所有负责人
    public List<User> searchPrincipal(){
        return userDao.searchAllUser();
    }

    //删除用户
    public int delUserById(int userID) {
        return userDao.delUserByID(userID);
    }

    //更新用户
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

	public int getdist(String name) {
		// TODO 自动生成的方法存根
		  return userDao.getDist(name);
	}
}
