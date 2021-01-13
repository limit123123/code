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

import com.artisan.dao.DegreeDao;
import com.artisan.dao.GradeDao;
import com.artisan.model.Degree;
import com.artisan.model.Grade;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class AddDegreeFrm extends JInternalFrame {
	private JTextField degfullnametextField;
	private JTextField textField_1;
	private JTextField textField_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddDegreeFrm frame = new AddDegreeFrm();
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
	public AddDegreeFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("Add Degree");
		setBounds(100, 100, 641, 474);
		
		JLabel degcode = new JLabel("degcode");
		degcode.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JButton submitButton = new JButton("Enter the degree");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submitAct(ae);
			}
		});
		submitButton.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel lblRegno = new JLabel("degfullname");
		lblRegno.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel lblFstgrade = new JLabel("WithyearIndustry");
		lblFstgrade.setFont(new Font("Arial", Font.PLAIN, 14));
		
		degfullnametextField = new JTextField();
		degfullnametextField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(268, Short.MAX_VALUE)
					.addComponent(submitButton)
					.addGap(226))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(206)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblFstgrade, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addGap(14))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblRegno, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
									.addGap(18))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(degcode)
									.addGap(53)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
								.addComponent(degfullnametextField, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
							.addGap(15)))
					.addContainerGap(122, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(63)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRegno, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(degfullnametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(degcode)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(55)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFstgrade, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
					.addComponent(submitButton)
					.addGap(65))
		);
		getContentPane().setLayout(groupLayout);
	}
	protected void submitAct(ActionEvent ae) {
		// TODO Auto-generated method stub
	     	String degfullname=degfullnametextField.getText().toString();
	     	String degcode=textField_1.getText().toString();
			int with=Integer.parseInt(textField_2.getText().toString());


		Degree degree = new Degree();
		    degree.setDegcode(degcode);
		    degree.setDegfullname(degfullname);
		    degree.setWithyearIndustry(with);
		    DegreeDao degreeDao = new DegreeDao();
		
	
		if(degreeDao.addGrade(degree)){
			JOptionPane.showMessageDialog(this, "Results entered successfully£¡");
			
			degfullnametextField.setText("");
			  textField_1.setText("");
			  textField_2.setText("");
		}else{
			JOptionPane.showMessageDialog(this, "Results entered failed£¡");
		}
		
	}



}
