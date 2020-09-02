package edu.neusoft.service;

import edu.neusoft.dao.UserDao;
import edu.neusoft.model.Area;
import edu.neusoft.model.User;

import java.util.List;

public class UserService {
    UserDao userDao = new UserDao();

    //�ṩ��ȡ�û����ķ���
    public int getUserRoleS(User user){
        return userDao.getUserRole(user);
    }

    //����û�
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    //��ѯ�����û�
    public List<User> searchAllUser(){
        return userDao.searchAllUser();
    }

    //��ѯ���и�����
    public List<User> searchPrincipal(){
        return userDao.searchAllUser();
    }

    //ɾ���û�
    public int delUserById(int userID) {
        return userDao.delUserByID(userID);
    }

    //�����û�
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

	public int getdist(String name) {
		// TODO �Զ����ɵķ������
		  return userDao.getDist(name);
	}
}
