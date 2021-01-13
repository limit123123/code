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

import com.artisan.dao.GradeDao;

import com.artisan.dao.StudentDao;
import com.artisan.model.Grade;
import com.artisan.model.Student;

import com.artisan.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.awt.Color;

public class ShowStatusFrm extends JInternalFrame {
	private JTable GSLTable;
	private ButtonGroup editSexButtonGroup;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowStatusFrm frame = new ShowStatusFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @return 
	 * @throws Exception 
	 */
	public  ShowStatusFrm() throws Exception {
		setClosable(true);
		setIconifiable(true);
		setTitle("grade Calcul");
		setBounds(100, 100, 842, 561);
		
		JScrollPane scrollPane = new JScrollPane();
		
		editSexButtonGroup = new ButtonGroup();
		
		JButton btnGrade = new JButton("CalCulate");
		btnGrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				btnUpdateGradeAct(ae);	
			}
		});


		
		btnGrade.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel label = new JLabel("fstgrade");
		label.setFont(new Font("Arial", Font.PLAIN, 14));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("sndgrade");
		label_1.setFont(new Font("Arial", Font.PLAIN, 14));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("overallgrade");
		label_2.setFont(new Font("Arial", Font.PLAIN, 14));
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblWeightedlgrade = new JLabel("weightedlgrade");
		lblWeightedlgrade.setFont(new Font("Arial", Font.PLAIN, 14));
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(405, Short.MAX_VALUE)
					.addComponent(btnGrade)
					.addGap(326))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(224)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
							.addGap(54)
							.addComponent(lblWeightedlgrade, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 577, GroupLayout.PREFERRED_SIZE)
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblWeightedlgrade, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnGrade, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(58))
		);
		
		GSLTable = new JTable();
		GSLTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedTableRow(arg0);
			}
		});
		GSLTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"forename", "surname", "fstgrade", "sndgrade", "overallgrade"
			}
		));
		scrollPane.setViewportView(GSLTable);
		getContentPane().setLayout(groupLayout);
		//setStudentClassInfo();
		initTable();
	}
	protected void selectedTableRow(MouseEvent me) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) GSLTable.getModel();
		
		textField.setText(dft.getValueAt(GSLTable.getSelectedRow(), 2).toString());
		textField_1.setText(dft.getValueAt(GSLTable.getSelectedRow(), 3).toString());
		textField_2.setText(dft.getValueAt(GSLTable.getSelectedRow(), 4).toString());

		
	}
	private void btnUpdateGradeAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		int row =  GSLTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "Please select a line first£¡");
			return;
		}
		int score1 = Integer.parseInt(textField_1.getText().toString());
		int score2 = Integer.parseInt(textField_2.getText().toString());
		int score3 = Integer.parseInt(textField.getText().toString());
				int res=(score1+score2+score3);
				textField_3.setText("weighted:"+res/3);
	}


	private void initTable() throws Exception{
		getgradeList(new Grade());
	}
	@SuppressWarnings("unused")
	private void setTable(Grade grade) throws Exception{
		getgradeList(grade);
	}
	

	private void getgradeList(Grade grade) throws Exception{
		
		DefaultTableModel dft = (DefaultTableModel) GSLTable.getModel();
		dft.setRowCount(0);
		GradeDao gradeDao = new GradeDao();
		Student stu = new Student();
		
		ResultSet list  = gradeDao. list(grade,stu);
		
		while (list.next()) {
			Vector rowData = new Vector();
			rowData.add(list.getString("forename"));
			rowData.add(list.getString("surname"));
			rowData.add(list.getInt("fstgrade"));
			rowData.add(list.getInt("sndgrade"));
			rowData.add(list.getInt("overallgrade"));
			dft.addRow(rowData);
		}
			
			
		}
	}

