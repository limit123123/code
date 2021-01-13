/** 
* @author john: 
* @version 创建时间：2020年12月4日 下午4:39:29 
* 类说明 
*/ 

package com.artisan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.artisan.model.Degree;
import com.artisan.model.Grade;

/**
 * @author 10299
 *
 */
public class DegreeDao extends BaseDao {
	public List<Degree> getDegreeList(Degree degree){
		List<Degree> retList = new ArrayList<Degree>();
		StringBuffer sqlString = new StringBuffer("select * from Degree");
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				Degree d = new Degree();
				d.setDegcode(executeQuery.getString("degcode"));
				d.setDegfullname(executeQuery.getString("degfullname"));
				d.setModfullname(executeQuery.getString("modfullname"));
				d.setWithyearIndustry(executeQuery.getInt("withyearIndustry"));
				retList.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
	public boolean update(int w,  String s1, String s2, String s3) {
		//
		String sql = "update degree set degfullname=?, degcode=?,withyearIndustry=? where modfullname=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1,s1);
			preparedStatement.setString(2,s2);
			preparedStatement.setInt(3, w);
			preparedStatement.setString(4,s3);
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean delete(String degcode){
		String sql = "delete from degree where degcode=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, degcode);
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean addGrade(Degree degree) {
		String sql = "insert into degree values(?,?,?,?)";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, degree.getDegcode());
			preparedStatement.setString(2, degree.getDegfullname());
			preparedStatement.setString(3,"Cognitive Studies Seminar");
			preparedStatement.setInt(4, degree.getWithyearIndustry());
			if(preparedStatement.executeUpdate() > 0)return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


}
