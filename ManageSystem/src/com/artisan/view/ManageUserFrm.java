package com.artisan.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.artisan.dao.UserDao;

import com.artisan.dao.StudentDao;
import com.artisan.model.User;
import com.artisan.model.Student;

import com.artisan.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class ManageUserFrm extends JInternalFrame {
	private JTable  UserListTable;
	private ButtonGroup editSexButtonGroup;
	private JTextField textField;
	private JTextField textField_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageUserFrm frame = new ManageUserFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ManageUserFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("Remove Account");
		setBounds(100, 100, 842, 561);
		
		JScrollPane scrollPane = new JScrollPane();
		
		editSexButtonGroup = new ButtonGroup();
		
		JButton btnDelUser = new JButton("Remove Account");
		btnDelUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				btnDelUserAct(ae);	
			}
		});
		btnDelUser.setFont(new Font("Arial", Font.PLAIN, 14));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblForename = new JLabel("forename");
		lblForename.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel lblSurname = new JLabel("surname");
		lblSurname.setFont(new Font("Arial", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(176)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 577, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(73, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(376, Short.MAX_VALUE)
					.addComponent(btnDelUser, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
					.addGap(246))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(244)
					.addComponent(lblForename, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
					.addComponent(lblSurname)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
					.addGap(133))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblForename, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSurname, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addComponent(btnDelUser)
					.addGap(99))
		);
		
		UserListTable = new JTable();
		UserListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedTableRow(arg0);
			}
		});
		UserListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"title", "surname", "forename", "username","password","role","departmentCode"
			}
		));
		scrollPane.setViewportView(UserListTable);
		getContentPane().setLayout(groupLayout);
		//setStudentClassInfo();
		initTable();
	}
	protected void selectedTableRow(MouseEvent me) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) UserListTable.getModel();
	 textField.setText(dft.getValueAt(UserListTable.getSelectedRow(), 1).toString());
	 textField_1.setText(dft.getValueAt(UserListTable.getSelectedRow(), 2).toString());
	
		//String className = dft.getValueAt(UserListTable.getSelectedRow(), 2).toString();
	}
	
	private void btnDelUserAct(ActionEvent ae) {
		int row = UserListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "Please select a line first£¡");
			return;
		}
		String s=textField_1.getText().toString();
		String t=textField.getText().toString();
		User user = new User();
		  user.setForename(s);
		  user.setSurname(t);
		 UserDao UserDao = new UserDao();
		 if(UserDao.delete(t,s)){
				JOptionPane.showMessageDialog(this, "delete success£¡");
				 textField_1.setText("");
				 textField.setText("");
				initTable();
			}else{
				JOptionPane.showMessageDialog(this, "delete fail£¡");
			}
		
	}
	private void initTable(){
		getUserList(new User());
	}
	private void setTable(User User){
		getUserList(User);
	}

	private void getUserList(User User){
		
		DefaultTableModel dft = (DefaultTableModel) UserListTable.getModel();
		dft.setRowCount(0);
		UserDao UserDao = new UserDao();
		
		List<User> UserList = UserDao.getUserList(User);
		
		for (User u : UserList) {
			Vector v = new Vector();
			v.add(u.getTitle());
			v.add(u.getSurname());
			v.add(u.getForename());
			v.add(u.getUsername());
			v.add(u.getPassword());
			v.add(u.getRole());
			v.add(u.getDepartmentCode());
		
			dft.addRow(v);
		}
	}

}
