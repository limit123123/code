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

import com.artisan.dao.DepartmentDao;
import com.artisan.dao.GradeDao;
import com.artisan.model.Department;
import com.artisan.model.Grade;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class AddDepartmentFrm extends JInternalFrame {
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
					AddDepartmentFrm frame = new AddDepartmentFrm();
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
	public AddDepartmentFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("Add Department");
		setBounds(100, 100, 641, 474);
		
		JLabel lblSndgrade = new JLabel("depcode");
		lblSndgrade.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JButton submitButton = new JButton("Add Department!");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submitAct(ae);
			}
		});
		submitButton.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel lblOverallgrade = new JLabel("degcode");
		lblOverallgrade.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel lblFstgrade = new JLabel("depfullname");
		lblFstgrade.setFont(new Font("Arial", Font.PLAIN, 14));
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(142)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblOverallgrade, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSndgrade)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblFstgrade, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(221)
							.addComponent(submitButton)))
					.addContainerGap(284, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(109)
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
					.addPreferredGap(ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
					.addComponent(submitButton)
					.addGap(90))
		);
		getContentPane().setLayout(groupLayout);
	}
	protected void submitAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		String depfullname=textField_2.getText().toString();
		String  depcode=textField_3.getText().toString();
		String	deccode=textField_4.getText().toString();

			Department d = new Department();
			d.setDegcode(deccode);
			d.setDepcode(depcode);
			d.setDepfullname(depfullname);
			
			DepartmentDao dd = new DepartmentDao();
		if(dd.addDepartment(d)){
			JOptionPane.showMessageDialog(this, "Results entered successfully£¡");
		
		}else{
			JOptionPane.showMessageDialog(this, "Results entered failed£¡");
		}
		
	}



}
