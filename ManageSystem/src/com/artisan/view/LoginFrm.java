package com.artisan.view;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.artisan.dao.UserDao;
import com.artisan.model.User;
import com.artisan.model.UserType;
import com.artisan.util.StringUtil;



public class LoginFrm extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTextField;
	private JPasswordField passwordTextField;
	private JComboBox userTypeComboBox;
	private  StudentFrm studentFrm;
	public static User currentUser;


	/**
	 * Launch the application.
	 */


	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrm frame = new LoginFrm();
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
	public LoginFrm() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		JLabel label = new JLabel("Information Login Entrance");
	
		label.setFont(new Font("Arial", Font.BOLD, 18));
		
		JLabel label_1 = new JLabel("username");
	
		label_1.setFont(new Font("Arial", Font.PLAIN, 14));
		
		userNameTextField = new JTextField();
		userNameTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("password");
		label_2.setFont(new Font("Arial", Font.PLAIN, 14));
	
		
		passwordTextField = new JPasswordField();
		passwordTextField.setColumns(10);
		
		JLabel label_3 = new JLabel("usertype");
		
		label_3.setFont(new Font("Arial", Font.PLAIN, 14));
		
		userTypeComboBox = new JComboBox();
		userTypeComboBox.setModel(new DefaultComboBoxModel(new UserType[] {UserType.ADMIN,UserType.REGISTRAR,UserType.TEACHER, UserType.STUDENT}));
		userTypeComboBox.setFont(new Font(" Arial", Font.PLAIN, 14));
		
		JButton loginButton = new JButton("LOGIN");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				loginAct(ae);
			}
		});
		
		loginButton.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JButton resetButton = new JButton("RESET");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				restValue(ae);
			}
		});
	
		resetButton.setFont(new Font("Arial", Font.PLAIN, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(118, Short.MAX_VALUE)
							.addComponent(label))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(134)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(label_1)
										.addComponent(label_2))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(passwordTextField, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
										.addComponent(userNameTextField, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(userTypeComboBox, 0, 162, Short.MAX_VALUE)))))
					.addGap(116))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(156)
					.addComponent(loginButton)
					.addGap(61)
					.addComponent(resetButton)
					.addContainerGap(127, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(26)
					.addComponent(label)
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(passwordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(userTypeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(resetButton)
						.addComponent(loginButton))
					.addGap(22))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void loginAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		String userName = userNameTextField.getText().toString();
		String password = passwordTextField.getText().toString();

		// index -> role
		int index = this.userTypeComboBox.getSelectedIndex();
		//角色  A管理员  T Teacher   R Registrar   S Student
		
	//	UserType selectedItem = (UserType)userTypeComboBox.getSelectedItem();
		if(StringUtil.isEmpty(userName)){
			JOptionPane.showMessageDialog(this, "The username cannot be empty！");
			return;
		}
		if(StringUtil.isEmpty(password)){
			JOptionPane.showMessageDialog(this, "The password cannot be empty！");
			return;
		}
		User user = new User();
			user.setUsername(userName);
			user.setPassword(password);
			if (index == 0) {
				user.setRole("A");
			} else if(index==1) {
				user.setRole("R");
			}
			 else if(index==2) {
					user.setRole("T");
				}
			 else if(index==3) {
					user.setRole("S");
				}
		
			User userlogin=null;
			UserDao userDao = new UserDao();
			userlogin=userDao.login(user);
			currentUser =userlogin;
			
			if(userlogin == null){
				JOptionPane.showMessageDialog(this, "Wrong username or password！");
				return;
			}
			else {
				JOptionPane.showMessageDialog(this, "Login Succcess");
				if (index == 0) {
					//A r t s
					this.dispose();
					new AdminFrm().setVisible(true);
					
				} else if(index==1) {
					this.dispose();
					new RegFrm().setVisible(true);
			
				}
				 else if(index==2) {
						this.dispose();
						new TeacherFrm().setVisible(true);
					}
				 else if(index==3) {
						this.dispose();
						new StudentFrm().setVisible(true);
					}
			
					
					
			}
			
	}
		
	

	protected void restValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		userNameTextField.setText("");
		passwordTextField.setText("");
		userTypeComboBox.setSelectedIndex(0);
	}
}
