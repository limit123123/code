package com.artisan.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
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
import java.awt.BorderLayout;
import java.awt.Color;

public class ManageStudentFrm extends JInternalFrame {
	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private JTable StudentListTable;
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
					ManageStudentFrm frame = new ManageStudentFrm();
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
	public ManageStudentFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("student manage");
		setBounds(100, 100, 842, 561);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblRegno = new JLabel("regno");
		lblRegno.setFont(new Font("Arial", Font.PLAIN, 14));
		
		regnoTextField = new JTextField();
		regnoTextField.setColumns(10);
		
		editSexButtonGroup = new ButtonGroup();
		
		JLabel lblModfullname = new JLabel("email");
		lblModfullname.setFont(new Font("Arial", Font.PLAIN, 14));
		
		modnametextField = new JTextField();
		modnametextField.setColumns(10);
		
		JLabel lblFstgrade = new JLabel("title");
		lblFstgrade.setFont(new Font("Arial", Font.PLAIN, 14));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblSndgrade = new JLabel("forename");
		lblSndgrade.setFont(new Font("Arial", Font.PLAIN, 14));
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblOverallgrade = new JLabel("surname");
		lblOverallgrade.setFont(new Font("Arial", Font.PLAIN, 14));
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel lblMayprogress = new JLabel("tutor");
		lblMayprogress.setFont(new Font("Arial", Font.PLAIN, 14));
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JButton btnUpdateStu = new JButton("update student");
		btnUpdateStu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				btnUpdateStudentAct(ae);	
			}
		});
		btnUpdateStu.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(0, 128, 128));
		contentPane.add(desktopPane, BorderLayout.CENTER);
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
									.addComponent(btnUpdateStu)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblFstgrade, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))))
							.addGap(43)
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
							.addGap(176)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 577, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(63, Short.MAX_VALUE))
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
							.addComponent(btnUpdateStu, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMayprogress, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(27))
		);
		
	StudentListTable = new JTable();
	StudentListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedTableRow(arg0);
			}
		});
	StudentListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"regno", "email", "title", "forename", "surname", "tutor"
			}
		));
		scrollPane.setViewportView(StudentListTable);
		getContentPane().setLayout(groupLayout);
		//setStudentClassInfo();
		initTable();
	}
	protected void selectedTableRow(MouseEvent me) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) StudentListTable.getModel();
		regnoTextField.setText(dft.getValueAt(StudentListTable.getSelectedRow(), 0).toString());
		modnametextField.setText(dft.getValueAt(StudentListTable.getSelectedRow(), 1).toString());
		textField_1.setText(dft.getValueAt(StudentListTable.getSelectedRow(), 2).toString());
		textField_2.setText(dft.getValueAt(StudentListTable.getSelectedRow(),3).toString());
		textField_3.setText(dft.getValueAt(StudentListTable.getSelectedRow(), 4).toString());
		textField_4.setText(dft.getValueAt(StudentListTable.getSelectedRow(), 5).toString());
		
		//String className = dft.getValueAt(GradeListTable.getSelectedRow(), 2).toString();
	}
	private void btnUpdateStudentAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		int row = StudentListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "Please select a line first£¡");
			return;
		}
		int reg = Integer.parseInt(regnoTextField.getText().toString());

		String s =modnametextField.getText().toString();
		String s2=textField_1.getText().toString();
		String s3=textField_2.getText().toString();
		String s4=textField_3.getText().toString();
		String s5=textField_4.getText().toString();
		
	
		StudentDao studentDao = new StudentDao();
		Student student = new Student();
		student.setRegno(reg);
		student.setEmail(s);
		student.setTitle(s2);
		student.setForename(s3);
		student.setSurname(s4);
		student.setTutor(s5);
		if(studentDao.update(student)){
			JOptionPane.showMessageDialog(this, "update success£¡");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			modnametextField.setText("");
			regnoTextField.setText("");
			initTable();
		}else{
			JOptionPane.showMessageDialog(this, "update fail£¡");
		}
		
	}
	private void initTable(){
		getstuList(new Student());
	}
	private void setTable(Student student){
		getstuList(student);
	}

	private void getstuList(Student student){
		
		DefaultTableModel dft = (DefaultTableModel) StudentListTable.getModel();
		dft.setRowCount(0);
		StudentDao studentDao = new StudentDao();
		
		List<Student> studentList =studentDao.getList(student);
		
		for (Student s : studentList) {
			Vector v = new Vector();
			v.add(s.getRegno());
			v.add(s.getEmail());
			v.add(s.getTitle());
			v.add(s.getForename());
			v.add(s.getSurname());
			v.add(s.getTutor());
			dft.addRow(v);
		}
	}

}
