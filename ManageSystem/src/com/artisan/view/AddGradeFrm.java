package com.artisan.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.artisan.dao.GradeDao;
import com.artisan.model.Grade;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class AddGradeFrm extends JInternalFrame {
	private JTextField proTextField;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddGradeFrm frame = new AddGradeFrm();
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
	public AddGradeFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("Add Grade");
		setBounds(100, 100, 641, 474);
		
		JLabel lblModfullname = new JLabel("modfullname");
		lblModfullname.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel lblSndgrade = new JLabel("sndgrade");
		lblSndgrade.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel lblMayprogress = new JLabel("mayprogress");
		lblMayprogress.setFont(new Font("Arial", Font.PLAIN, 14));
		
		proTextField = new JTextField();
		proTextField.setColumns(10);
		
		JButton submitButton = new JButton("Enter the grade");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submitAct(ae);
			}
		});
		submitButton.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel lblRegno = new JLabel("regno");
		lblRegno.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel lblOverallgrade = new JLabel("overallgrade");
		lblOverallgrade.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel lblFstgrade = new JLabel("fstgrade");
		lblFstgrade.setFont(new Font("Arial", Font.PLAIN, 14));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(268, Short.MAX_VALUE)
					.addComponent(submitButton)
					.addGap(226))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(142)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblFstgrade, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblRegno, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblMayprogress)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(proTextField))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblModfullname)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblOverallgrade, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblSndgrade))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
									.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(269, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRegno, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblModfullname)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFstgrade, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSndgrade))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblOverallgrade, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMayprogress)
						.addComponent(proTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
					.addComponent(submitButton)
					.addGap(65))
		);
		getContentPane().setLayout(groupLayout);
	}
	protected void submitAct(ActionEvent ae) {
		// TODO Auto-generated method stub
	     int regno=Integer.parseInt(textField.getText().toString());
	     	String modfullname=textField_1.getText().toString();
			int fstgrade=Integer.parseInt(textField_2.getText().toString());
			int sndgrade=Integer.parseInt(textField_3.getText().toString());
		    int	overallgrade=Integer.parseInt(textField_4.getText().toString());
		    int mayprogress=Integer.parseInt(proTextField.getText().toString());

			Grade gradeObj = new Grade();
		    
		GradeDao gradeDao = new GradeDao();
		if(gradeDao.isAdd(gradeObj)){
			JOptionPane.showMessageDialog(this, "The grade has been entered, please do not repeat it!");
			return;
		}
		if(gradeDao.addGrade(gradeObj)){
			JOptionPane.showMessageDialog(this, "Results entered successfully£¡");
			proTextField.setText("");
		}else{
			JOptionPane.showMessageDialog(this, "Results entered failed£¡");
		}
		
	}



}
