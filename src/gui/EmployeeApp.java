package gui;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * MIS HW5
 * 12/09/2013
 * @author Jinwei Yuan
 *
 */


public class EmployeeApp extends JFrame{
	public static final int NUMEMPLOYEE = 8;
	
	private JPanel jp1, jp2, jp3, jp32;
	private JTextField jtID, jtName, jtSalary;
	private JButton jbNext, jbPrevious, jbUndo, jbSave;
	private JMenuItem jmiEdit, jmiExit;
	private JMenu jmModify, jmMisc;
	private JLabel jlInfo;
	
	private ArrayList<Employee> list;
	private int index;
	
	public EmployeeApp(){
		index = 0;
		readFile();
		
		JMenuBar jmb = new JMenuBar();
		setJMenuBar(jmb);
		
		JMenu jmFile = new JMenu("File");
		jmb.add(jmFile);
		
		jmFile.add(jmModify = new JMenu("Modify"));
		jmFile.add(jmMisc = new JMenu("Misc"));
		jmModify.add(jmiEdit = new JMenuItem("Edit"));
		jmMisc.add(jmiExit = new JMenuItem("Exit"));
		
		/* set panel text field */
		JPanel jp11 = new JPanel(new FlowLayout());
		jp11.add(new JLabel("Employee ID:"));
		jp11.add(jtID = new JTextField(4));
		JPanel jp12 = new JPanel(new FlowLayout());
		jp12.add(new JLabel("Employee Name:"));
		jp12.add(jtName = new JTextField(14));
		JPanel jp13 = new JPanel(new FlowLayout());
		jp13.add(new JLabel("Employee Salary:"));
		jp13.add(jtSalary = new JTextField(7));
		jp1 = new JPanel(new GridLayout(2,2));
		jp1.add(jp11);
		jp1.add(jp12);
		jp1.add(jp13);
		jp1.setBackground(Color.YELLOW);
		jp11.setBackground(Color.YELLOW);
		jp12.setBackground(Color.YELLOW);
		jp13.setBackground(Color.YELLOW);
		jtID.setEditable(false);
		jtName.setEditable(false);
		jtSalary.setEditable(false);
		showText(index);
		
		/* set panel labels */
		jp2 = new JPanel(new BorderLayout());
		jp2.add(jlInfo = new JLabel(""), BorderLayout.WEST);
		jp2.setBackground(Color.GRAY);
		jlInfo.setForeground(Color.WHITE);
		
		/* set panel buttons */
		JPanel jp31 = new JPanel(new FlowLayout());
		jp32 = new JPanel(new FlowLayout());
		jp31.add(jbPrevious = new JButton("Previous"));
		jp31.add(jbNext = new JButton("Next"));
		jp32.add(jbUndo = new JButton("Undo"));
		jp32.add(jbSave = new JButton("Save"));
		jp31.setBackground(Color.CYAN);
		jp32.setBackground(Color.CYAN);
		jp3 = new JPanel(new BorderLayout());
		jp3.add(jp31, BorderLayout.WEST);
		jp3.add(jp32, BorderLayout.EAST);
		jbUndo.setVisible(false);
		jbSave.setVisible(false);
		jp32.setVisible(false);

		setLayout(new BorderLayout());
		add(jp1, BorderLayout.NORTH);
		add(jp2, BorderLayout.CENTER);
		add(jp3, BorderLayout.SOUTH);
		
		// register listeners
		jbNext.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(index+1 >= NUMEMPLOYEE)
					jlInfo.setText("Already the last record");
				else{
					jlInfo.setText("");
					index += 1;
					showText(index);
				}
			}
		});
		
		jbPrevious.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(index-1 < 0)
					jlInfo.setText("Already the first record");
				else{
					jlInfo.setText("");
					index -= 1;
					showText(index);
				}
			}
		});
		
		jbUndo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				showText(index);
				jtID.setEditable(false); 
				jtName.setEditable(false);
				jtSalary.setEditable(false);
				jbUndo.setVisible(false);
				jbSave.setVisible(false);
				jp32.setVisible(false);
			}
		});
		
		jbSave.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int newID = (Integer.parseInt(jtID.getText().trim()));
				String newName = (jtName.getText().trim());
				double newSalary = (Double.parseDouble(jtSalary.getText().trim()));
				
				list.get(index).ID = newID;
				list.get(index).name = newName;
				list.get(index).salary = newSalary;
				
				showText(index);
				jtID.setEditable(false); 
				jtName.setEditable(false);
				jtSalary.setEditable(false);
				jbUndo.setVisible(false);
				jbSave.setVisible(false);
				jp32.setVisible(false);
			}
		});
		
		jmiEdit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				jtID.setEditable(true); 
				jtName.setEditable(true);
				jtSalary.setEditable(true);
				jbUndo.setVisible(true);
				jbSave.setVisible(true);
				jp32.setVisible(true);
			}
		});
		
		jmiExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
	}
	
	private void readFile(){
		list = new ArrayList<Employee>();
		try{
			ObjectInputStream input = new ObjectInputStream(new FileInputStream("data.dat"));
			for(int i=0; i<NUMEMPLOYEE; i++){
				list.add((Employee)input.readObject());
			}
			
			input.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}catch(ClassNotFoundException cex){
			cex.printStackTrace();
		}
		
	}
	
	private void showText(int i){
		jtID.setText("" + list.get(index).ID);
		jtName.setText("" + list.get(index).name);
		jtSalary.setText("" + list.get(index).salary);
	}
	
	
	
	public static void main(String args[]) throws ClassNotFoundException, IOException{
		
		Employee emp1 = new Employee(81, "Phillip", 1500);
		Employee emp2 = new Employee(18, "David", 3600);
		Employee emp3 = new Employee(45, "Jia-Ning", 8450);
		Employee emp4 = new Employee(76, "Patricia", 9500);
		Employee emp5 = new Employee(126, "Meghana", 1950);
		Employee emp6 = new Employee(93, "Phillip", 12000);
		Employee emp7 = new Employee(56, "Jill", 6150);
		Employee emp8 = new Employee(72, "Jordon", 8670);
		
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("data.dat"));
		output.writeObject(emp1);
		output.writeObject(emp2);
		output.writeObject(emp3);
		output.writeObject(emp4);
		output.writeObject(emp5);
		output.writeObject(emp6);
		output.writeObject(emp7);
		output.writeObject(emp8);
		output.close();
		
		EmployeeApp frame = new EmployeeApp();
		frame.pack();
		frame.setTitle("Employee Data");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(700, 300);
	}
	
	
	
}
