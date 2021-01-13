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
import java.awt.Color;

public class ManageGradetFrm extends JInternalFrame {
	private JTable GradeListTable;
	private ButtonGroup editSexButtonGroup;
	private JTextField regnoTextField;
	private JTextField modnametextField;
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
					ManageGradetFrm frame = new ManageGradetFrm();
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
	public ManageGradetFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("grade manage");
		setBounds(100, 100, 842, 561);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblRegno = new JLabel("regno");
		lblRegno.setFont(new Font("Arial", Font.PLAIN, 14));
		
		regnoTextField = new JTextField();
		regnoTextField.setColumns(10);
		
		editSexButtonGroup = new ButtonGroup();
		
		JLabel lblModfullname = new JLabel("modfullname");
		lblModfullname.setFont(new Font("Arial", Font.PLAIN, 14));
		
		modnametextField = new JTextField();
		modnametextField.setColumns(10);
		
		JLabel lblFstgrade = new JLabel("fstgrade");
		lblFstgrade.setFont(new Font("Arial", Font.PLAIN, 14));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblSndgrade = new JLabel("sndgrade");
		lblSndgrade.setFont(new Font("Arial", Font.PLAIN, 14));
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblOverallgrade = new JLabel("overallgrade");
		lblOverallgrade.setFont(new Font("Arial", Font.PLAIN, 14));
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel lblMayprogress = new JLabel("mayprogress");
		lblMayprogress.setFont(new Font("Arial", Font.PLAIN, 14));
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JButton btnUpdateGrade = new JButton("update grade");
		btnUpdateGrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				btnUpdateGradeAct(ae);	
			}
		});
		btnUpdateGrade.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JButton btnAddGrade = new JButton("add grade");
		btnAddGrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				btnAddGradeAct(ae);	
			}
		});
		btnAddGrade.setFont(new Font("Arial", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(203)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblModfullname, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblRegno))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(regnoTextField, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
										.addComponent(modnametextField, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(btnUpdateGrade)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblFstgrade, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))))
							.addGap(4)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(39)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblSndgrade, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblOverallgrade, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblMayprogress, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(61)
									.addComponent(btnAddGrade, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(176)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 577, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(73, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRegno)
						.addComponent(lblSndgrade, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(regnoTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblModfullname, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblOverallgrade, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(modnametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFstgrade, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnUpdateGrade, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAddGrade)))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMayprogress, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(27))
		);
		
		GradeListTable = new JTable();
		GradeListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedTableRow(arg0);
			}
		});
		GradeListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"regno", "modfullname", "fstgrade", "sndgrade", "overallgrade", "mayprogress"
			}
		));
		scrollPane.setViewportView(GradeListTable);
		getContentPane().setLayout(groupLayout);
		//setStudentClassInfo();
		initTable();
	}
	protected void selectedTableRow(MouseEvent me) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) GradeListTable.getModel();
		regnoTextField.setText(dft.getValueAt(GradeListTable.getSelectedRow(), 0).toString());
		modnametextField.setText(dft.getValueAt(GradeListTable.getSelectedRow(), 1).toString());
		textField_1.setText(dft.getValueAt(GradeListTable.getSelectedRow(), 2).toString());
		textField_2.setText(dft.getValueAt(GradeListTable.getSelectedRow(),3).toString());
		textField_3.setText(dft.getValueAt(GradeListTable.getSelectedRow(), 4).toString());
		textField_4.setText(dft.getValueAt(GradeListTable.getSelectedRow(), 5).toString());
		
		//String className = dft.getValueAt(GradeListTable.getSelectedRow(), 2).toString();
	}
	private void btnAddGradeAct(ActionEvent ae) {
		JOptionPane.showMessageDialog(this, "First:you should add to tables:student,module ,because FK£¡");
	}
	private void btnUpdateGradeAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		int row = GradeListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "Please select a line first£¡");
			return;
		}
		int reg = Integer.parseInt(regnoTextField.getText().toString());
		int score1 = Integer.parseInt(textField_1.getText().toString());
		int score2 = Integer.parseInt(textField_2.getText().toString());
		int score3 = Integer.parseInt(textField_3.getText().toString());
		
		 GradeDao gradeDao = new GradeDao();
		if(gradeDao.update(reg,score1,score2,score3)){
			JOptionPane.showMessageDialog(this, "update success£¡");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			initTable();
		}else{
			JOptionPane.showMessageDialog(this, "update fail£¡");
		}
		
	}
	private void initTable(){
		getgradeList(new Grade());
	}
	private void setTable(Grade grade){
		getgradeList(grade);
	}

	private void getgradeList(Grade grade){
		
		DefaultTableModel dft = (DefaultTableModel) GradeListTable.getModel();
		dft.setRowCount(0);
		GradeDao gradeDao = new GradeDao();
		
		List<Grade> gradeList = gradeDao.getGradeList(grade);
		
		for (Grade g : gradeList) {
			Vector v = new Vector();
			v.add(g.getRegno());
			v.add(g.getModfullname());
			v.add(g.getFstgrade());
			v.add(g.getSndgrade());
			v.add(g.getOverallgrade());
			v.add(g.getMayprogress());
			dft.addRow(v);
		}
	}
	/*
	private void setStudentClassInfo(){
		ClassDao classDao = new ClassDao();
		studentClassList = classDao.getClassList(new StudentClass());
		for (StudentClass sc : studentClassList) {
			searchStudentComboBox.addItem(sc);
			editStudentClassComboBox.addItem(sc);
		}
		classDao.closeDao();
	}
	private String getClassNameById(int id){
		for (StudentClass sc : studentClassList) {
			if(sc.getId() == id)return sc.getName();
		}
		return "";
	}
*/
}
