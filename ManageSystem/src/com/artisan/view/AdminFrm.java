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

import com.artisan.dao.StudentDao;
import com.artisan.model.Grade;
import com.artisan.model.Graduation;
import com.artisan.model.Studyperiod;
import com.artisan.model.User;
import com.artisan.model.UserType;

public class AdminFrm extends JFrame {


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


	public AdminFrm() {
		setTitle("Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 580);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu1 = new JMenu("Account");
		JMenu menu3 = new JMenu("Departments");
		JMenu menu4 = new JMenu("Degrees");
		JMenu menu6 = new JMenu("Modules");
		menuBar.add(menu1);
		menuBar.add(menu3);
		
		JMenuItem mntmAdd = new JMenuItem("Add");
		menu3.add(mntmAdd);
		
		JMenuItem mntmRemove = new JMenuItem("Remove");
		menu3.add(mntmRemove);
		menuBar.add(menu4);
		
		JMenuItem mntmAdd_1 = new JMenuItem("Add");
		menu4.add(mntmAdd_1);
	
		mntmAdd_1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
		AddDegreeFrm af = new AddDegreeFrm();
				  af.setVisible(true);
				  desktopPane.add(af);
			}
		});
		mntmRemove.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ManageDepartFrm mdfm=new ManageDepartFrm();
				  mdfm.setVisible(true);
				  desktopPane.add(mdfm);
			}
		});
		mntmAdd.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				AddDepartmentFrm  adef=new AddDepartmentFrm();
				  adef.setVisible(true);
				  desktopPane.add(adef);
			}
		});
	
		JMenuItem mntmRemove_1 = new JMenuItem("Remove");
		menu4.add(mntmRemove_1);
		mntmRemove_1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
			ManageDegreetFrm mdf = new ManageDegreetFrm();
				  mdf.setVisible(true);
				  desktopPane.add(mdf);
			}
		});
		menuBar.add(menu6);
		
		JMenuItem mntmAdd_3 = new JMenuItem("Add");
		menu6.add(mntmAdd_3);
		mntmAdd_3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				AddModuleFrm amr = new AddModuleFrm();
				 amr.setVisible(true);
				  desktopPane.add(amr);
			}
		});
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Remove");
		menu6.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ManageModuletFrm mmf = new ManageModuletFrm();
				 mmf.setVisible(true);
				  desktopPane.add(mmf);
			}
		});

		
		JMenuItem menuItem = new JMenuItem("AddAccount");
		JMenuItem menuItem2 = new JMenuItem("RemoveAccount");
		JMenuItem menuItem3 = new JMenuItem("exit");
		menu1.add(menuItem);
		menu1.add(menuItem2);
		menu1.add(menuItem3);
		menuItem.addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
			AddAccountFrm addAccountFrm = new AddAccountFrm();
			addAccountFrm.setVisible(true);
			desktopPane.add(addAccountFrm);
			}
		});
		menuItem2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
						ManageUserFrm muf = new ManageUserFrm();
				  muf.setVisible(true);
				  desktopPane.add(muf);
			}
		});
		JMenu mnExit = new JMenu("Exit");
		menuBar.add(mnExit);
		
		JMenuItem mntmExit = new JMenuItem("exit");
		mnExit.add(mntmExit);
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(AdminFrm.this, "Are you sure to exit£¿") == JOptionPane.OK_OPTION){
					System.exit(0);
				}
			}
		});
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			}
		});
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(0, 128, 128));
		contentPane.add(desktopPane, BorderLayout.CENTER);
		setLocationRelativeTo(null);
	
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
				new AdminFrm().setVisible(true);
			}
		});
	}

}
