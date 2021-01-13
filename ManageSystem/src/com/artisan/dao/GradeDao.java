/** 
* @author john: 
* @version 创建时间：2020年12月3日 下午7:51:32 
* 类说明 
*/ 

package com.artisan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.artisan.model.Grade;
import com.artisan.model.Student;
import com.artisan.util.StringUtil;

/**
 * @author 10299
 *
 */
public class GradeDao extends BaseDao {
	public List<Grade> getGradeList(Grade grade){
		List<Grade> retList = new ArrayList<Grade>();
		StringBuffer sqlString = new StringBuffer("select * from grade");
		/*
		if(!StringUtil.isEmpty(student.getName())){
			sqlString.append(" and name like '%"+student.getName()+"%'");
		}
		if(student.getClassId() != 0){
			sqlString.append(" and classId ="+student.getClassId());
		}
		*/
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				Grade g = new Grade();
				g.setRegno(executeQuery.getInt("regno"));
				g.setModfullname(executeQuery.getString("modfullname"));
				g.setFstgrade(executeQuery.getInt("fstgrade"));
				g.setSndgrade(executeQuery.getInt("sndgrade"));
				g.setOverallgrade(executeQuery.getInt("overallgrade"));
				g.setMayprogress(executeQuery.getInt("mayprogress"));
				retList.add(g);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}

	/**
	 * @param reg
	 * @param score1
	 * @param score2
	 * @param score3
	 * @return
	 */
	public boolean update(int reg, int score1, int score2, int score3) {
		//
		String sql = "update grade set fstgrade=?, sndgrade=?,overallgrade=? where regno=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, score1);
			preparedStatement.setInt(2, score2);
			preparedStatement.setInt(3, score3);
			preparedStatement.setInt(4, reg);
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @param gradeObj
	 * @return
	 */
	public boolean isAdd(Grade gradeObj) {
		String sql = "select * from grade where regno= ?";
		try {
			PreparedStatement prst = con.prepareStatement(sql);//把sql语句传给数据库操作对象
			prst.setInt(1,gradeObj.getRegno());
			ResultSet executeQuery = prst.executeQuery();
			if(executeQuery.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @param gradeObj
	 * @return
	 */
	public boolean addGrade(Grade gradeObj) {
		String sql = "insert into grade values(?,?,?,?,?,?)";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, gradeObj.getRegno());
			preparedStatement.setString(2, gradeObj.getModfullname());
			preparedStatement.setInt(3, gradeObj.getFstgrade());
			preparedStatement.setInt(4, gradeObj.getSndgrade());
			preparedStatement.setInt(5, gradeObj.getOverallgrade());
			preparedStatement.setInt(6, gradeObj.getMayprogress());
			if(preparedStatement.executeUpdate() > 0)return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @param grade
	 * @return
	 * @throws Exception 
	 */
	public ResultSet list (Grade grade,Student stu) throws Exception {
		String sql = "select forename,surname,fstgrade,sndgrade,overallgrade from grade,student where grade.regno=student.regno;";
		PreparedStatement pstmt=(PreparedStatement) con.prepareStatement(sql);
		return pstmt.executeQuery();
	}
	



	

}
