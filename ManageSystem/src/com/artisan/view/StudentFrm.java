package com.artisan.view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.artisan.dao.StudentDao;
import com.artisan.model.Grade;
import com.artisan.model.Graduation;
import com.artisan.model.Studyperiod;
import com.artisan.model.User;
import com.artisan.model.UserType;
import com.artisan.util.DbUtil;

public class StudentFrm extends JFrame {


	public static UserType userType;
	public static Object userObject;
	private JLabel studentNameLabel;
	private User user;
	private Grade grade;
	private Graduation graduation;
	private Studyperiod studyperiod;          
	private DbUtil db;

	StudentDao studentDao = new StudentDao();
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	/** Creates new form UserMainFrm */


	public StudentFrm() {
	
		setTitle("Student");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("Show Status");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("about grade");
		JMenuItem menuItem2 = new JMenuItem("about graduation");
		JMenuItem menuItem3 = new JMenuItem("about period");
		JMenuItem menuItem4 = new JMenuItem("about user");
		JMenuItem menuItem5 = new JMenuItem("exit");
		menu.add(menuItem);
		menu.add(menuItem2);
		menu.add(menuItem3);
		menu.add(menuItem4);
		menu.add(menuItem5);
			
	
		menuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					menuItemActionPerformed(evt);
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}

			private void menuItemActionPerformed(ActionEvent evt) throws Exception {		
				try {
					ResultSet rs = studentDao.Gradequery(grade);
					JTable table = new JTable(buildTableModel(rs));
					JOptionPane.showMessageDialog(null, new JScrollPane(table));
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		});
		menuItem2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menuItem2ActionPerformed(evt);
			}

			private void menuItem2ActionPerformed(ActionEvent evt) {
				try {
					ResultSet rs = studentDao.graquery(graduation);
					JTable table = new JTable(buildTableModel(rs));
					JOptionPane.showMessageDialog(null, new JScrollPane(table));
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				
			}
		});
		menuItem3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menuItem3ActionPerformed(evt);
			}

			private void menuItem3ActionPerformed(ActionEvent evt) {
				try {
					ResultSet rs = studentDao.Periodquery(studyperiod);
					JTable table = new JTable(buildTableModel(rs));
					JOptionPane.showMessageDialog(null, new JScrollPane(table));
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		});
		menuItem5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menuItem5ActionPerformed(evt);
			}

			private void menuItem5ActionPerformed(ActionEvent evt) {
			
				System.exit(0);
			}
			});
		
		menuItem4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menuItem4ActionPerformed(evt);
			}

			private void menuItem4ActionPerformed(ActionEvent evt) {
			
				try {
				
			
					ResultSet rs = studentDao.userquery(user);
					JTable table = new JTable(buildTableModel(rs));
					JOptionPane.showMessageDialog(null, new JScrollPane(table));
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				
			}
		});
		//studentNameLabel.setText(user.getUsername());
	
	
			}
		
			
	public static DefaultTableModel buildTableModel(ResultSet rs)
		    throws SQLException {

		ResultSetMetaData metaData = rs.getMetaData();

		// names of columns
		Vector<String> columnNames = new Vector<String>();
		int columnCount = metaData.getColumnCount();
		for (int column = 1; column <= columnCount; column++) {
		    columnNames.add(metaData.getColumnName(column));
		}

		// data of the table
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		while (rs.next()) {
		    Vector<Object> vector = new Vector<Object>();
		    for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
		        vector.add(rs.getObject(columnIndex));
		    }
		    data.add(vector);
		}

		return new DefaultTableModel(data, columnNames);

		}
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new StudentFrm().setVisible(true);
			}
		});
	}

}
