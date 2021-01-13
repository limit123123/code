/** 
* @author john: 
* @version 创建时间：2020年12月4日 下午5:39:12 
* 类说明 
*/ 

package com.artisan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.artisan.model.Module;

/**
 * @author 10299
 *
 */
public class ModuleDao extends BaseDao {
	
	public List<Module> getModuleList(Module Module){
		List<Module> retList = new ArrayList<Module>();
		StringBuffer sqlString = new StringBuffer("select * from Module");
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				Module m = new Module();
				m.setCredit(executeQuery.getInt("credit"));
				m.setIscore(executeQuery.getString("iscore"));
				m.setModcode(executeQuery.getString("modcode"));
				m.setPeriod(executeQuery.getString("period"));
				m.setLevelCode(executeQuery.getString("levelCode"));
				m.setModfullname(executeQuery.getString("modfullname"));
				retList.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
	public boolean delete(String modcode){
		String sql = "delete from Module where modcode=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, modcode);
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean addModule(Module module) {
		String sql = "insert into Module values(?,?,?,?,?,?)";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, module.getModfullname());
			preparedStatement.setString(2, module.getLevelCode());
			preparedStatement.setString(3, module.getIscore());
			preparedStatement.setInt(4, module.getCredit());
			preparedStatement.setString(5, module.getPeriod());
			preparedStatement.setString(6,module.getModcode());
			
			if(preparedStatement.executeUpdate() > 0)return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
