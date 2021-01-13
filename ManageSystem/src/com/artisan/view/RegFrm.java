package com.artisan.view;


import java.awt.BorderLayout;
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

import com.artisan.dao.StudentDao;
import com.artisan.model.Grade;
import com.artisan.model.Graduation;
import com.artisan.model.Studyperiod;
import com.artisan.model.User;
import com.artisan.model.UserType;
import com.sun.prism.paint.Color;

public class RegFrm extends JFrame {
	private JPanel contentPane;
	private JDesktopPane desktopPane;

	public static UserType userType;
	public static Object userObject;
	private JLabel studentNameLabel;
	private User user;
	private Grade grade;
	private Graduation graduation;
	private Studyperiod studyperiod;
	
	StudentDao studentDao = new StudentDao();
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	/** Creates new form UserMainFrm */


	public RegFrm() {
		setTitle("Registrar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 940, 780);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnStudentManage = new JMenu("Student Manage");
		menuBar.add(mnStudentManage);
		
		JMenuItem mntmManage = new JMenuItem("Update");
		mnStudentManage.add(mntmManage);
		
		JMenuItem mntmAdd = new JMenuItem("Add");
		mnStudentManage.add(mntmAdd);
		
		JMenu menu1 = new JMenu("Degree");
		JMenu menu7 = new JMenu("Exit");
		JMenu menu3 = new JMenu("Modules");
		menuBar.add(menu3);
		
		JMenuItem mntmCheck = new JMenuItem("check");
		menu3.add(mntmCheck);
		mntmCheck.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ManageModuletFrm mmf = new ManageModuletFrm();
				 mmf.setVisible(true);
				  desktopPane.add(mmf);
			}
		});
		menuBar.add(menu1);
		
		JMenuItem mntmManagedegree = new JMenuItem("ManageDegree");
		menu1.add(mntmManagedegree);
		
		JMenuItem mntmAdd_1 = new JMenuItem("Add");
		menu1.add(mntmAdd_1);
		JMenu menu2 = new JMenu("Period");
		menuBar.add(menu2);
		
		JMenuItem mntmModify = new JMenuItem("check");
		menu2.add(mntmModify);
		menuBar.add(menu7);
		
		JMenuItem mntmExit = new JMenuItem("exit");
		menu7.add(mntmExit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(java.awt.Color.WHITE);
	
		contentPane.add(desktopPane, BorderLayout.CENTER);
		setLocationRelativeTo(null);
	
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(RegFrm.this, "Are you sure you want to quit?") == JOptionPane.OK_OPTION){
					System.exit(0);
				}
			}
		});
		mntmAdd_1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
		AddDegreeFrm af = new AddDegreeFrm();
				  af.setVisible(true);
				  desktopPane.add(af);
			}
		});
		mntmManagedegree.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
			ManageDegreetFrm mdf = new ManageDegreetFrm();
				  mdf.setVisible(true);
				  desktopPane.add(mdf);
			}
		});
		
		mntmManage.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ManageStudentFrm msfrm = new ManageStudentFrm();
				  msfrm.setVisible(true);
				  desktopPane.add(msfrm);
			}
		});
		mntmAdd.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				AddStuFrm asfrm = new AddStuFrm();
				  asfrm.setVisible(true);
				  desktopPane.add(asfrm);
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
				new RegFrm().setVisible(true);
			}
		});
	}
}
