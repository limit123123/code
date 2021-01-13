package com.artisan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.artisan.model.Grade;
import com.artisan.model.Graduation;
import com.artisan.model.Student;
import com.artisan.model.Studyperiod;
import com.artisan.model.User;
import com.artisan.util.StringUtil;


public class StudentDao extends BaseDao {
	
	public ResultSet Periodquery(Studyperiod studyperiod)throws Exception{
		
		StringBuffer sb=new StringBuffer("select * from studyperiod;");
		PreparedStatement pstmt=(PreparedStatement) con.prepareStatement(sb.toString());
	//	 pstmt.setString(1, user.getUsername());
		return pstmt.executeQuery();
		
	}
	public ResultSet graquery(Graduation graduation)throws Exception{
		
		StringBuffer sb=new StringBuffer("select * from graduation;");
		PreparedStatement pstmt=(PreparedStatement) con.prepareStatement(sb.toString());
	//	 pstmt.setString(1, user.getUsername());
		return pstmt.executeQuery();
		
	}
	public ResultSet userquery(User user)throws Exception{
		
		StringBuffer sb=new StringBuffer("select * from user");
		/*
		if(user.getUsername() != null){
			sb.append("where username = ?");
		}
		*/
		PreparedStatement pstmt=(PreparedStatement) con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
		
	}
	
	public ResultSet Gradequery(Grade grade)throws Exception{
		
		StringBuffer sb=new StringBuffer("select * from grade;");
		PreparedStatement pstmt=(PreparedStatement) con.prepareStatement(sb.toString());
	//	 pstmt.setString(1, user.getUsername());
		return pstmt.executeQuery();
		
	}
	public ResultSet stuquery(Student student)throws Exception{
		
		StringBuffer sb=new StringBuffer("select * from student;");
		PreparedStatement pstmt=(PreparedStatement) con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
		
	}
	
	/*
	
	
	public List<Student> getStudentList(Student student){
		List<Student> retList = new ArrayList<Student>();
		StringBuffer sqlString = new StringBuffer("select * from s_student");
		if(!StringUtil.isEmpty(student.getName())){
			sqlString.append(" and name like '%"+student.getName()+"%'");
		}
		if(student.getClassId() != 0){
			sqlString.append(" and classId ="+student.getClassId());
		}
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				Student s = new Student();
				s.setId(executeQuery.getInt("id"));
				s.setName(executeQuery.getString("name"));
				s.setClassId(executeQuery.getInt("classId"));
				s.setSex(executeQuery.getString("sex"));
				s.setPassword(executeQuery.getString("password"));
				retList.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
	public boolean delete(int id){
		String sql = "delete from s_student where id=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public String editPassword(Student student,String newPassword){
		String sql = "select * from s_student where id=? and password=?";
		PreparedStatement prst = null;
		int id = 0;
		try {
			prst = con.prepareStatement(sql);
			prst.setInt(1, student.getId());
			prst.setString(2, student.getPassword());
			ResultSet executeQuery = prst.executeQuery();
			if(!executeQuery.next()){
				String retString = "旧密码错误！";
				return retString;
			}
			id = executeQuery.getInt("id");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//把sql语句传给数据库操作对象
		String retString = "修改失败";
		String sqlString = "update s_student set password = ? where id = ?";
		try {
			prst = con.prepareStatement(sqlString);
			prst.setString(1, newPassword);
			prst.setInt(2, id);
			int rst = prst.executeUpdate();
			if(rst > 0){
				retString = "密码修改成功！";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//把sql语句传给数据库操作对象
		return retString;
	}
*/
	/**
	 * @return
	 */
	public List<Student> getList(Student student) {
		List<Student> retList = new ArrayList<Student>();
		StringBuffer sqlString = new StringBuffer("select * from student");
	
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				Student s = new Student();
				s.setRegno(executeQuery.getInt("regno"));
				s.setEmail(executeQuery.getString("email"));
				s.setTitle(executeQuery.getString("title"));
				s.setForename(executeQuery.getString("forename"));
				s.setSurname(executeQuery.getString("surname"));
				s.setTutor(executeQuery.getString("tutor"));
				retList.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
	public boolean update(Student student){
	//	update s_student set name=?, classId=?,sex=?,password=? where id=?
		String sql = "update student set email=?,title=?,forename=?,surname=?,tutor=? where regno=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, student.getEmail());
			preparedStatement.setString(2, student.getTitle());
			preparedStatement.setString(3, student.getForename());
			preparedStatement.setString(4, student.getSurname());
			preparedStatement.setString(5, student.getTutor());
			preparedStatement.setInt(6, student.getRegno());
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean addStudent(Student student){
		String sql = "insert into student values(?,?,?,?,?,?)";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, student.getRegno());
			preparedStatement.setString(2, student.getEmail());
			preparedStatement.setString(3, student.getTitle());
			preparedStatement.setString(4, student.getForename());
			preparedStatement.setString(5, student.getSurname());
			preparedStatement.setString(6, student.getTutor());
			
			if(preparedStatement.executeUpdate() > 0)return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}
