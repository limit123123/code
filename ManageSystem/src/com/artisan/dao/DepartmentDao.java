/** 
* @author john: 
* @version 创建时间：2020年12月4日 下午8:31:09 
* 类说明 
*/ 

package com.artisan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.artisan.model.Department;

/**
 * @author 10299
 *
 */
public class DepartmentDao extends BaseDao {

	
	public List<Department> getdepartmentList(Department department){
		List<Department> retList = new ArrayList<Department>();
		StringBuffer sqlString = new StringBuffer("select * from department");
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				Department d = new Department();
				d.setDepfullname(executeQuery.getString("depfullname"));
				d.setDepcode(executeQuery.getString("depcode"));
				d.setDegcode(executeQuery.getString("degcode"));
				retList.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
	public boolean delete(String depcode){
		String sql = "delete from department where depcode=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, depcode);
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean addDepartment(Department department) {
		String sql = "insert into department values(?,?,?)";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1,department.getDepfullname());
			preparedStatement.setString(2,department.getDepcode());
			preparedStatement.setString(3, department.getDegcode());
			if(preparedStatement.executeUpdate() > 0)return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
