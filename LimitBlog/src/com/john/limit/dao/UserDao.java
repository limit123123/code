package com.john.limit.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import com.john.limit.domain.User;
import com.john.limit.utils.JdbcUtil;


public class UserDao {

	public static User checkUser(String name, String pwd) throws Exception {
		QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
		User user=null;
		String sql="select * from user where user_name=? and user_password=?";
		 user = qr.query(sql, new BeanHandler<User>(User.class),name,pwd);
		return user;
}
}