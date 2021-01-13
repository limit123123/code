/** 
* @author john: 
* @version 创建时间：2020年12月3日 上午9:26:27 
* 类说明 
*/ 

package com.artisan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.artisan.model.Degree;
import com.artisan.model.Student;
import com.artisan.model.User;

/**
 * @author 10299
 *
 */
public class UserDao extends BaseDao {
	
	public User login(User user){
		String sql = "select * from user WHERE username=? and password=? and role=?;";
		User UserRst = null;
		try {
			PreparedStatement prst = con.prepareStatement(sql);//把sql语句传给数据库操作对象
			prst.setString(1, user.getUsername());
			prst.setString(2, user.getPassword());
			prst.setString(3, user.getRole());
			ResultSet executeQuery = prst.executeQuery();
			if(executeQuery.next()){
				UserRst = new User();
				UserRst.setSurname(executeQuery.getString("surname"));
				UserRst.setForename(executeQuery.getString("forename"));
				UserRst.setUsername(executeQuery.getString("username"));
				UserRst.setPassword(executeQuery.getString("password"));
				UserRst.setRole(executeQuery.getString("role"));
				UserRst.setTitle(executeQuery.getString("title"));
				UserRst.setDepartmentCode(executeQuery.getString("departmentCode"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return UserRst;
	}
	public boolean addUser(User user){
		String sql = "insert into user values(?,?,?,?,?,?,'COM')";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, user.getTitle());
			preparedStatement.setString(2, user.getSurname());
			preparedStatement.setString(3, user.getForename());
			preparedStatement.setString(4, user.getUsername());
			preparedStatement.setString(5, user.getPassword());
			preparedStatement.setString(6, user.getRole());
			if(preparedStatement.executeUpdate() > 0)return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean delete(String s1,String s2){
		//delete from degree where degcode=?
		String sql = "delete from user where surname=? and forename=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, s1);
			preparedStatement.setString(2, s2);
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public List<User> getUserList(User user){
		List<User> retList = new ArrayList<User>();
		StringBuffer sqlString = new StringBuffer("select * from user");
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				User u=new User();
				u.setDepartmentCode(executeQuery.getString("departmentCode"));
				u.setForename(executeQuery.getString("forename"));
				u.setPassword(executeQuery.getString("password"));
				u.setRole(executeQuery.getString("role"));
				u.setSurname(executeQuery.getString("surname"));
				u.setTitle(executeQuery.getString("title"));
				u.setUsername(executeQuery.getString("username"));
				retList.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
	

}
