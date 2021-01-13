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

import com.artisan.dao.ModuleDao;

import com.artisan.dao.StudentDao;
import com.artisan.model.Module;
import com.artisan.model.Student;

import com.artisan.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class ManageModuletFrm extends JInternalFrame {
	private JTable  ModuleListTable;
	private ButtonGroup editSexButtonGroup;
	private JTextField regnoTextField;
	private JTextField modnametextField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField;
	private JTextField textField_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageModuletFrm frame = new ManageModuletFrm();
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
	public ManageModuletFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("Module manage");
		setBounds(100, 100, 842, 561);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel degfullname = new JLabel("modfullname");
		degfullname.setFont(new Font("Arial", Font.PLAIN, 14));
		
		regnoTextField = new JTextField();
		regnoTextField.setColumns(10);
		
		editSexButtonGroup = new ButtonGroup();
		
		JLabel degcode = new JLabel("modcode");
		degcode.setFont(new Font("Arial", Font.PLAIN, 14));
		
		modnametextField = new JTextField();
		modnametextField.setColumns(10);
		
		JLabel modfullname = new JLabel("iscore");
		modfullname.setFont(new Font("Arial", Font.PLAIN, 14));
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblOverallModule = new JLabel("credit");
		lblOverallModule.setFont(new Font("Arial", Font.PLAIN, 14));
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JButton btnDelModule = new JButton("delete Module");
		btnDelModule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				btnDelModuleAct(ae);	
			}
		});
		btnDelModule.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel lblPeriod = new JLabel("period");
		lblPeriod.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel lblLevelcode = new JLabel("levelCode");
		lblLevelcode.setFont(new Font("Arial", Font.PLAIN, 14));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(203)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(degcode, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
								.addComponent(degfullname)
								.addComponent(lblPeriod, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(modnametextField)
									.addComponent(regnoTextField, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
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
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblOverallModule, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblLevelcode, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
											.addGap(18)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
												.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)))))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(61)
									.addComponent(btnDelModule, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))))
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
						.addComponent(lblOverallModule, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(modnametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPeriod, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(8))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblLevelcode, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)))
					.addComponent(btnDelModule)
					.addGap(27))
		);
		
		ModuleListTable = new JTable();
		ModuleListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedTableRow(arg0);
			}
		});
		ModuleListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"modfullname", "modcode", "iscore", "credit", "period", "levelCode"
			}
		));
		scrollPane.setViewportView(ModuleListTable);
		getContentPane().setLayout(groupLayout);
		//setStudentClassInfo();
		initTable();
	}
	protected void selectedTableRow(MouseEvent me) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) ModuleListTable.getModel();

		
		regnoTextField.setText(dft.getValueAt(ModuleListTable.getSelectedRow(), 0).toString());
		modnametextField.setText(dft.getValueAt(ModuleListTable.getSelectedRow(), 1).toString());
		textField_2.setText(dft.getValueAt(ModuleListTable.getSelectedRow(),2).toString());
		textField_3.setText(dft.getValueAt(ModuleListTable.getSelectedRow(), 3).toString());
		
		textField.setText(dft.getValueAt(ModuleListTable.getSelectedRow(), 4).toString());
		textField_1.setText(dft.getValueAt(ModuleListTable.getSelectedRow(), 5).toString());
		
		
	}
	private void btnDelModuleAct(ActionEvent ae) {
		JOptionPane.showMessageDialog(this, "delete fail£¡Cannot delete or update a parent row");
		/*
		int row = ModuleListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "Please select a line first£¡");
			return;
		}
		String degcode=modnametextField.getText().toString();
		 ModuleDao ModuleDao = new ModuleDao();
		 if(ModuleDao.delete(degcode)){
				JOptionPane.showMessageDialog(this, "delete success£¡");
				modnametextField.setText("");
				regnoTextField.setText("");
				textField_2.setText("");
				textField_3.setText("");
				initTable();
			}else{
				JOptionPane.showMessageDialog(this, "delete fail£¡");
			}
			*/
		
	}
	private void initTable(){
		getModuleList(new Module());
	}
	private void setTable(Module Module){
		getModuleList(Module);
	}

	private void getModuleList(Module Module){
		
		DefaultTableModel dft = (DefaultTableModel) ModuleListTable.getModel();
		dft.setRowCount(0);
		ModuleDao ModuleDao = new ModuleDao();
		
		List<Module> ModuleList = ModuleDao.getModuleList(Module);
		
		for (Module mo : ModuleList) {
			Vector v = new Vector();
			v.add(mo.getModfullname());
			v.add(mo.getModcode());
			v.add(mo.getIscore());
			v.add(mo.getCredit());
			v.add(mo.getPeriod());
			v.add(mo.getLevelCode());
			dft.addRow(v);
		}
	}

}
