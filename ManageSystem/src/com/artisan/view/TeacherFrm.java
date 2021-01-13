package com.artisan.view;


import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.artisan.dao.GradeDao;
import com.artisan.dao.StudentDao;
import com.artisan.model.Grade;
import com.artisan.model.Graduation;
import com.artisan.model.Student;
import com.artisan.model.Studyperiod;
import com.artisan.model.User;
import com.artisan.model.UserType;

public class TeacherFrm extends JFrame {
	private JPanel contentPane;
	private JDesktopPane desktopPane;
	public static UserType userType;
	public static Object userObject;
	private JLabel studentNameLabel;
	private User user;
	private Grade grade;
	private Graduation graduation;
	private Studyperiod studyperiod;
	private Student student;
	
	StudentDao studentDao = new StudentDao();
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	/** Creates new form UserMainFrm */


	public TeacherFrm() {
		setTitle("Teacher");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 200, 940, 680);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		
		JMenu menu1 = new JMenu("Grade Manage");
		JMenu menu2 = new JMenu("Calculate");
		JMenu menu3 = new JMenu("Pass");
		JMenu menu4 = new JMenu("Show status");		
		JMenu menu5 = new JMenu("exit");		
		menuBar.add(menu1);
		menuBar.add(menu2);
		menuBar.add(menu3);
		menuBar.add(menu4);
		menuBar.add(menu5);
		JMenuItem menuItem = new JMenuItem(" grade manage");
	//	JMenuItem menuItem2 = new JMenuItem("update  grade");
		JMenuItem menuItem3 = new JMenuItem("about graduation");
		JMenuItem menuItem4 = new JMenuItem("about student");
		JMenuItem menuItem5 = new JMenuItem("exit");
		menu5.add(menuItem5);
		JMenuItem CalmenuItem = new JMenuItem("Calculate");
		menu2.add(CalmenuItem);
		menu3.add(menuItem3);
		menu4.add(menuItem4);
		menuItem3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menuItem3ActionPerformed(evt);
			}

			private void menuItem3ActionPerformed(ActionEvent evt) {
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
		menuItem4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				menuItem4ActionPerformed(evt);
			}

			private void menuItem4ActionPerformed(ActionEvent evt) {
				try {
					ResultSet rs = studentDao.stuquery(student);
					JTable table = new JTable(buildTableModel(rs));
					JOptionPane.showMessageDialog(null, new JScrollPane(table));
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				
			}
		});
		
		
		
		CalmenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					calmenuItemActionPerformed(evt);
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}

			private void calmenuItemActionPerformed(ActionEvent evt) throws Exception {		
				try {
					  CalCulGradetFrm cfrm = new CalCulGradetFrm() ;
					  cfrm.setVisible(true);
					desktopPane.add(cfrm);
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		});
		menuItem5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(TeacherFrm.this, "Are you sure you want to quit?") == JOptionPane.OK_OPTION){
					System.exit(0);
				}
			}
		});
		
		menu1.add(menuItem);
	//	menu1.add(menuItem2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(0, 128, 128));
		contentPane.add(desktopPane, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		
		menuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				  ManageGradetFrm mrm = new ManageGradetFrm() ;
				 mrm.setVisible(true);
				desktopPane.add(mrm);
			}
		});
		
	
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
				new TeacherFrm().setVisible(true);
			}
		});
	}

}
