package com.john.limit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.alibaba.druid.util.JdbcUtils;
import com.john.limit.domain.User;
import com.john.limit.utils.JdbcUtil;


public class ActiveDao {
	QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
	public void addUser(User user){
        String username=user.getUserName();
        String userpassword=user.getUserPassword();
        String useremail=user.getUserEmail();
        //Ȩֵ
        String userrights="1";
       
            String sql="INSERT INTO user(user_name,user_password,user_email,user_rights) VALUES (?,?,?,?)";
        	try {
				qr.update(sql,user.getUserName(),user.getUserPassword(),user.getUserEmail(),user.getUserRights());
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}

    }
	public void forbiden(int userid) {
        	String sql="UPDATE gg_user SET user_rights=3  WHERE user_id="+userid;
            	try {
					qr.update(sql,userid);
				} catch (SQLException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
	}
}