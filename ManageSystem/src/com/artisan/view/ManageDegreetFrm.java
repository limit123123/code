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

import com.artisan.dao.StudentDao;
import com.artisan.model.Degree;
import com.artisan.model.Student;

import com.artisan.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class ManageDegreetFrm extends JInternalFrame {
	private JTable  DegreeListTable;
	private ButtonGroup editSexButtonGroup;
	private JTextField regnoTextField;
	private JTextField modnametextField;
	private JTextField textField_2;
	private JTextField textField_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageDegreetFrm frame = new ManageDegreetFrm();
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
	public ManageDegreetFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("Degree manage");
		setBounds(100, 100, 842, 561);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel degfullname = new JLabel("degfullname");
		degfullname.setFont(new Font("Arial", Font.PLAIN, 14));
		
		regnoTextField = new JTextField();
		regnoTextField.setColumns(10);
		
		editSexButtonGroup = new ButtonGroup();
		
		JLabel degcode = new JLabel("degcode");
		degcode.setFont(new Font("Arial", Font.PLAIN, 14));
		
		modnametextField = new JTextField();
		modnametextField.setColumns(10);
		
		JLabel modfullname = new JLabel("modfullname");
		modfullname.setFont(new Font("Arial", Font.PLAIN, 14));
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblOverallDegree = new JLabel("WithyearIndustry");
		lblOverallDegree.setFont(new Font("Arial", Font.PLAIN, 14));
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JButton btnDelDegree = new JButton("delete Degree");
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
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(203)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(degcode, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
								.addComponent(degfullname))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(modnametextField)
								.addComponent(regnoTextField, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
							.addGap(60)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(39)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(modfullname, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblOverallDegree, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(61)
									.addComponent(btnDelDegree, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(176)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 577, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(degfullname)
						.addComponent(modfullname, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(regnoTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(degcode, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblOverallDegree, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(modnametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addComponent(btnDelDegree)
					.addGap(27))
		);
		
		DegreeListTable = new JTable();
		DegreeListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedTableRow(arg0);
			}
		});
		DegreeListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"degfullname", "degcode", "modfullname", "WithyearIndustry"
			}
		));
		scrollPane.setViewportView(DegreeListTable);
		getContentPane().setLayout(groupLayout);
		//setStudentClassInfo();
		initTable();
	}
	protected void selectedTableRow(MouseEvent me) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) DegreeListTable.getModel();
		
		regnoTextField.setText(dft.getValueAt(DegreeListTable.getSelectedRow(), 0).toString());
		modnametextField.setText(dft.getValueAt(DegreeListTable.getSelectedRow(), 1).toString());
		textField_2.setText(dft.getValueAt(DegreeListTable.getSelectedRow(),2).toString());
		textField_3.setText(dft.getValueAt(DegreeListTable.getSelectedRow(), 3).toString());
		
		
		//String className = dft.getValueAt(DegreeListTable.getSelectedRow(), 2).toString();
	}
	private void btnDelDegreeAct(ActionEvent ae) {
		int row = DegreeListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "Please select a line first£¡");
			return;
		}
		String degcode=modnametextField.getText().toString();
		 DegreeDao DegreeDao = new DegreeDao();
		 if(DegreeDao.delete(degcode)){
				JOptionPane.showMessageDialog(this, "delete success£¡");
				modnametextField.setText("");
				regnoTextField.setText("");
				textField_2.setText("");
				textField_3.setText("");
				initTable();
			}else{
				JOptionPane.showMessageDialog(this, "delete fail£¡");
			}
		
	}
	private void initTable(){
		getDegreeList(new Degree());
	}
	private void setTable(Degree Degree){
		getDegreeList(Degree);
	}

	private void getDegreeList(Degree Degree){
		
		DefaultTableModel dft = (DefaultTableModel) DegreeListTable.getModel();
		dft.setRowCount(0);
		DegreeDao DegreeDao = new DegreeDao();
		
		List<Degree> DegreeList = DegreeDao.getDegreeList(Degree);
		
		for (Degree d : DegreeList) {
			Vector v = new Vector();
			v.add(d.getDegfullname());
			v.add(d.getDegcode());
			v.add(d.getModfullname());
			v.add(d.getWithyearIndustry());
			dft.addRow(v);
		}
	}

}
