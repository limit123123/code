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

import com.artisan.dao.DegreeDao;
import com.artisan.dao.DepartmentDao;
import com.artisan.dao.StudentDao;
import com.artisan.model.Degree;
import com.artisan.model.Department;
import com.artisan.model.Student;

import com.artisan.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class ManageDepartFrm extends JInternalFrame {
	private JTable  DepartListTable;
	private ButtonGroup editSexButtonGroup;
	private JTextField modnametextField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageDepartFrm frame = new ManageDepartFrm();
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
	public ManageDepartFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("Delete Department");
		setBounds(100, 100, 842, 561);
		
		JScrollPane scrollPane = new JScrollPane();
		
		editSexButtonGroup = new ButtonGroup();
		
		JLabel degcode = new JLabel("depcode");
		degcode.setFont(new Font("Arial", Font.PLAIN, 14));
		
		modnametextField = new JTextField();
		modnametextField.setColumns(10);
		
		JButton btnDelDegree = new JButton("delete Department");
		btnDelDegree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				btnDelDegreeAct(ae);	
			}
		});
		btnDelDegree.setFont(new Font("Arial", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(176)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 577, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(40, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(336, Short.MAX_VALUE)
					.addComponent(degcode, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(modnametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(306))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(364, Short.MAX_VALUE)
					.addComponent(btnDelDegree, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
					.addGap(294))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(modnametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(degcode, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addComponent(btnDelDegree)
					.addGap(70))
		);
		
		DepartListTable = new JTable();
		DepartListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedTableRow(arg0);
			}
		});
		DepartListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"depfullname", "depcode", "degcode"
			}
		));
		scrollPane.setViewportView(DepartListTable);
		getContentPane().setLayout(groupLayout);
		initTable();
	}
	protected void selectedTableRow(MouseEvent me) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) DepartListTable.getModel();
		
		modnametextField.setText(dft.getValueAt(DepartListTable.getSelectedRow(), 1).toString());
		
		
	}
	private void btnDelDegreeAct(ActionEvent ae) {
		int row = DepartListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "Please select a line first£¡");
			return;
		}
		String degcode=modnametextField.getText().toString();
		DepartmentDao departmentDao = new DepartmentDao();
		 if(departmentDao.delete(degcode)){
				JOptionPane.showMessageDialog(this, "delete success£¡");
				modnametextField.setText("");
				initTable();
			}else{
				JOptionPane.showMessageDialog(this, "delete fail£¡");
			}
		
	}
	private void initTable(){
		getDepartmentList(new Department());
	}
	private void setTable(Department Department){
		getDepartmentList(Department);
	}

	private void getDepartmentList(Department Department){
		
		DefaultTableModel dft = (DefaultTableModel) DepartListTable.getModel();
		dft.setRowCount(0);
		DepartmentDao dd = new DepartmentDao();
		Department de = new Department();
		List<Department> DepartmentList = dd.getdepartmentList(de);
		
		for (Department d : DepartmentList) {
			Vector v = new Vector();
			v.add(d.getDepfullname());
			v.add(d.getDepcode());
			v.add(d.getDegcode());
			
			
			dft.addRow(v);
		}
	}

}
