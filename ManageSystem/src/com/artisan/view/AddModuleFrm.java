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

import com.artisan.dao.ModuleDao;
import com.artisan.dao.GradeDao;
import com.artisan.model.Module;
import com.artisan.model.Grade;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class AddModuleFrm extends JInternalFrame {
	private JTextField degfullnametextField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField3;
	private JTextField textField_4;
	private JTextField textField_5;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddModuleFrm frame = new AddModuleFrm();
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
	public AddModuleFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("Add Module");
		setBounds(100, 100, 641, 474);
		
		JLabel degcode = new JLabel("modcode");
		degcode.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JButton submitButton = new JButton("Enter the Module");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submitAct(ae);
			}
		});
		submitButton.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel lblRegno = new JLabel("modfullname");
		lblRegno.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel lblFstgrade = new JLabel("iscore");
		lblFstgrade.setFont(new Font("Arial", Font.PLAIN, 14));
		
		degfullnametextField = new JTextField();
		degfullnametextField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblCredit = new JLabel("credit");
		lblCredit.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel lblPeriod = new JLabel("period");
		lblPeriod.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel lblLevelcode = new JLabel("levelCode");
		lblLevelcode.setFont(new Font("Arial", Font.PLAIN, 14));
		
		textField3 = new JTextField();
		textField3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(260, Short.MAX_VALUE)
					.addComponent(submitButton)
					.addGap(226))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(206)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblRegno, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
								.addComponent(degcode)
								.addComponent(lblFstgrade, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
							.addGap(21)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(degfullnametextField, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCredit, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPeriod, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblLevelcode, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField3, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(168, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(63)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRegno, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(degfullnametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(degcode)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFstgrade, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCredit, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblPeriod, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblLevelcode, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
					.addComponent(submitButton)
					.addGap(65))
		);
		getContentPane().setLayout(groupLayout);
	}
	protected void submitAct(ActionEvent ae) {
		// TODO Auto-generated method stub
	     	String modfullname=degfullnametextField.getText().toString();
	     	String modcode=textField_1.getText().toString();
	     	String iscore=textField_2.getText().toString();
			int credit=Integer.parseInt(textField3.getText().toString());
			String period=textField_4.getText().toString();
			String levelCode=textField_5.getText().toString();

		Module Module = new Module();
		Module.setCredit(credit);
		Module.setIscore(iscore);
		Module.setLevelCode(levelCode);
		Module.setModcode(modcode);
		Module.setModfullname(modfullname);
		Module.setPeriod(period);
		    ModuleDao ModuleDao = new ModuleDao();
		
	
		if(ModuleDao.addModule(Module)){
			JOptionPane.showMessageDialog(this, "Results entered successfully£¡");
			
			degfullnametextField.setText("");
			  textField_1.setText("");
			  textField_2.setText("");
		}else{
			JOptionPane.showMessageDialog(this, "Results entered failed£¡");
		}
		
	}



}
