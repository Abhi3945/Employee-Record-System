import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Searchpanel extends JFrame {

	private JPanel contentPane;
	
	private  static Searchpanel frame;
	static AdminPanl AdminPan = new AdminPanl();
	private JTextField textField;
	private JTextField textField_1;
	public JButton btnAdminLogin;
	private JTable table;
	private DefaultTableModel model;
	public JLabel label_1;
	public 	JButton btnCancel;
	public JButton btnCancle3;
	public JButton btnCancle_1;
	public JPanel panel_1;
	private JButton btnAllEmployes;
	private JTextField Searchbar;
	private int fl;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Searchpanel();
					frame.setTitle("Record Management");
				//	frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setLocationRelativeTo(null);
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
	public Searchpanel() {
		
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100,1008 , 581);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel_1 = new JPanel();
		/////buttons
		//radio buttons of search panel
		
		
		JRadioButton rdbtnBranch = new JRadioButton("Department");
		JRadioButton rdbtnSearchById= new JRadioButton("Id");
		JRadioButton rdbtnName = new JRadioButton("Name");
		JPanel panel = new JPanel();
		panel.setBounds(0, 187, 1002, 359);

		
		
		btnAdminLogin = new JButton("Login");
		btnAdminLogin.setBounds(838, 24, 114, 41);
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		//	
			panel.setVisible(false);
			panel_1.setVisible(true);
			
				
				
			}
		});
		contentPane.setLayout(null);
		btnAdminLogin.setToolTipText("Only for Admin");
		btnAdminLogin.setForeground(new Color(255, 255, 255));
		btnAdminLogin.setBackground(new Color(255, 102, 51));
		btnAdminLogin.setFont(new Font("Tahoma", Font.BOLD, 17));
		contentPane.add(btnAdminLogin);
		
		label_1 = new JLabel("");
		label_1.setBounds(756, 24, 56, 45);
		label_1.setIcon(new ImageIcon("E:\\java projects\\Record management\\download (1).jpg"));
		contentPane.add(label_1);
		
		JLabel lblNewLabel = new JLabel("Employee Records");
		lblNewLabel.setBounds(377, 14, 245, 54);
		lblNewLabel.setForeground(new Color(220, 20, 60));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		contentPane.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setVisible(false);
		panel_2.setBackground(new Color(0.0f,0.0f,0.0f,0.3f));
		panel_2.setBounds(0, 82, 1002, 464);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 978, 411);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.setForeground(Color.BLACK);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Search");
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int result = JOptionPane.showConfirmDialog(frame,"Select Yes if you want to Generate Text File", "Swing Tester",
			               JOptionPane.YES_NO_OPTION,
			               JOptionPane.QUESTION_MESSAGE);
			            if(result == JOptionPane.YES_OPTION){

							 try {
								  String url="jdbc:oracle:thin:@localhost:1521:xe";
						    	  Class.forName("oracle.jdbc.driver.OracleDriver");
									//Driver loding
									Connection con=DriverManager.getConnection(url,"system","tiger");
								//	System.out.println("connected");
									Statement stm = con.createStatement();
									
									if(rdbtnSearchById.isSelected()==true) {
									String s="select * from EMP_DETAILS where EMP_ID='"+Searchbar.getText()+"'";
								ResultSet ps4= stm.executeQuery(s);
								File	myObj = new File("E:\\java projects\\Record management\\Textfile\\EMP_Details_EMP_ID.txt");
								 if (myObj.createNewFile()) {
								       // System.out.println("File created: " + myObj.getName());
								    
								    	 
								          //myWriter.close();
								    	  
								    	
								    		  FileWriter myWriter = new FileWriter("E:\\java projects\\Record management\\Textfile\\EMP_Details_EMP_ID.txt");
												
								    	  
								    	  myWriter.write("Emp_id \t \t Firse_name \t\t Last_name \t\t Department \t \tDate_of_Joining \t \t Email \t \t Mobile No. \t \t Address");
								    	  
								    	  
								        while(ps4.next()) {
								        	  myWriter.write("\n"+ps4.getString(1)+"\t \t"+ps4.getString(2)+"\t  \t"+ps4.getString(3)+"\t  \t  \t"+ps4.getString(4)+"\t \t \t"+ps4.getString(5)+"\t \t"+ps4.getString(6)+" \t"+ps4.getString(7)+"\t \t"+ps4.getString(8));
								        	
								        }
								        myWriter.close();
								      } else {
								    	 //System.out.println("File created: " + myObj.getName());
								    	
								    		  FileWriter myWriter = new FileWriter("E:\\java projects\\Record management\\Textfile\\EMP_Details_EMP_ID.txt");
												
								    	  myWriter.write("Emp_id \t \t Firse_name \t\t Last_name \t\t Department \t \tDate_of_Joining \t \t Email \t \t Mobile No. \t \t Address");
								    	  while(ps4.next()) {
								        	   myWriter.write("\n"+ps4.getString(1)+"\t \t"+ps4.getString(2)+"\t  \t"+ps4.getString(3)+"\t  \t  \t"+ps4.getString(4)+"\t \t \t"+ps4.getString(5)+"\t \t"+ps4.getString(6)+" \t"+ps4.getString(7)+"\t \t"+ps4.getString(8));
								        	
								        }
								    	  myWriter.close();
											
								       // System.out.println("File already exists.");
								      }
									}
									
									else if(rdbtnName.isSelected()==true) {
										String s="select * from EMP_DETAILS where FIRST_NAME='"+Searchbar.getText()+"'";
									ResultSet	ps4= stm.executeQuery(s);
									File	myObj = new File("E:\\java projects\\Record management\\Textfile\\EMP_Details_byName.txt");
									  if (myObj.createNewFile()) {
									       
													FileWriter myWriter = new FileWriter("E:\\java projects\\Record management\\Textfile\\EMP_Details_byName.txt");
													
									    	  
									    	  myWriter.write("Emp_id \t \t Firse_name \t\t Last_name \t\t Department \t \tDate_of_Joining \t \t Email \t \t Mobile No. \t \t Address");
									    	  
									    	  
									        while(ps4.next()) {
									        	  myWriter.write("\n"+ps4.getString(1)+"\t \t"+ps4.getString(2)+"\t  \t"+ps4.getString(3)+"\t  \t  \t"+ps4.getString(4)+"\t \t \t"+ps4.getString(5)+"\t \t"+ps4.getString(6)+" \t"+ps4.getString(7)+"\t \t"+ps4.getString(8));
									        	
									        }
									        myWriter.close();
									      } else {
									    	
									    	  FileWriter myWriter = new FileWriter("E:\\java projects\\Record management\\Textfile\\EMP_Details_byName.txt");
												
									    	  myWriter.write("Emp_id \t \t Firse_name \t\t Last_name \t\t Department \t \tDate_of_Joining \t \t Email \t \t Mobile No. \t \t Address");
									    	  while(ps4.next()) {
									        	   myWriter.write("\n"+ps4.getString(1)+"\t \t"+ps4.getString(2)+"\t  \t"+ps4.getString(3)+"\t  \t  \t"+ps4.getString(4)+"\t \t \t"+ps4.getString(5)+"\t \t"+ps4.getString(6)+" \t"+ps4.getString(7)+"\t \t"+ps4.getString(8));
									        	
									        }
									    	  myWriter.close();
												
									       
									      }
									    
									/////
									}
									else if(rdbtnBranch.isSelected()==true) 
									{
										 String s="select * from EMP_DETAILS where DEPARTMENT='"+Searchbar.getText()+"'";
									ResultSet	 ps4= stm.executeQuery(s);
									File	 myObj = new File("E:\\java projects\\Record management\\Textfile\\EMP_Details_byDepartmentName.txt");
									  if (myObj.createNewFile()) {
									     
														FileWriter myWriter = new FileWriter("E:\\java projects\\Record management\\Textfile\\EMP_Details_byDepartmentName.txt");
													
									    	  
									    	  myWriter.write("Emp_id \t \t Firse_name \t\t Last_name \t\t Department \t \tDate_of_Joining \t \t Email \t \t Mobile No. \t \t Address");
									    	  
									    	  
									        while(ps4.next()) {
									        	  myWriter.write("\n"+ps4.getString(1)+"\t \t"+ps4.getString(2)+"\t  \t"+ps4.getString(3)+"\t  \t  \t"+ps4.getString(4)+"\t \t \t"+ps4.getString(5)+"\t \t"+ps4.getString(6)+" \t"+ps4.getString(7)+"\t \t"+ps4.getString(8));
									        	
									        }
									        myWriter.close();
									      } else {
									    	   
									    	  FileWriter myWriter = new FileWriter("E:\\java projects\\Record management\\Textfile\\EMP_Details_byDepartmentName.txt");
													
									    	  myWriter.write("Emp_id \t \t Firse_name \t\t Last_name \t\t Department \t \tDate_of_Joining \t \t Email \t \t Mobile No. \t \t Address");
									    	  while(ps4.next()) {
									        	   myWriter.write("\n"+ps4.getString(1)+"\t \t"+ps4.getString(2)+"\t  \t"+ps4.getString(3)+"\t  \t  \t"+ps4.getString(4)+"\t \t \t"+ps4.getString(5)+"\t \t"+ps4.getString(6)+" \t"+ps4.getString(7)+"\t \t"+ps4.getString(8));
									        	
									        }
									    	  myWriter.close();
												
									       // System.out.println("File already exists.");
									      }
									}
									if (fl==1) {
										String s="select * from EMP_DETAILS ";//where EMP_ID='"+Searchbar.getText()+"'";
										//System.out.println("File created: " + myObj.getName());
										ResultSet ps4= stm.executeQuery(s);
										
									File	myObj = new File("E:\\java projects\\Record management\\Textfile\\All_Employes.txt");
									
									 if (myObj.createNewFile()) {
									       
													
														FileWriter  myWriter = new FileWriter("E:\\java projects\\Record management\\Textfile\\All_Employes.txt");
											
									    	  myWriter.write("Emp_id \t \t Firse_name \t\t Last_name \t\t Department \t \tDate_of_Joining \t \t Email \t \t Mobile No. \t \t Address");
									    	  
									    	  
									        while(ps4.next()) {
									        	  myWriter.write("\n"+ps4.getString(1)+"\t \t"+ps4.getString(2)+"\t  \t"+ps4.getString(3)+"\t  \t  \t"+ps4.getString(4)+"\t \t \t"+ps4.getString(5)+"\t \t"+ps4.getString(6)+" \t"+ps4.getString(7)+"\t \t"+ps4.getString(8));
									        	
									        }
									        myWriter.close();
									      } else {
									    	
													
														  FileWriter myWriter = new FileWriter("E:\\java projects\\Record management\\Textfile\\All_Employes.txt");
														
												
									    	  myWriter.write("Emp_id \t \t Firse_name \t\t Last_name \t\t Department \t \tDate_of_Joining \t \t Email \t \t Mobile No. \t \t Address");
									    	  while(ps4.next()) {
									        	   myWriter.write("\n"+ps4.getString(1)+"\t \t"+ps4.getString(2)+"\t  \t"+ps4.getString(3)+"\t  \t  \t"+ps4.getString(4)+"\t \t \t"+ps4.getString(5)+"\t \t"+ps4.getString(6)+" \t"+ps4.getString(7)+"\t \t"+ps4.getString(8));
									        	
									        }
									    	  myWriter.close();
												
									       // System.out.println("File already exists.");
									      }
									
										
									}
							            //ps4= stm.executeQuery(s);
									
						      con.close();
						     
						    
						    } catch (Exception e) {
						      System.out.println("An error occurred.");
						      e.printStackTrace();
						    }
			            	
			            fl=0;
							JOptionPane.showMessageDialog(frame,"Writting Process is Sucessful");
			            }else {
			            	JOptionPane.showMessageDialog(frame,"Operation is Terminated");
			            
			            }
			
				
					
				    panel_2.setVisible(false);
					btnNewButton.setVisible(true);
					btnAdminLogin.setVisible(true);
					lblNewLabel.setVisible(true);
					label_1.setVisible(true);
					DefaultTableModel dm = (DefaultTableModel) table.getModel();
				    dm.getDataVector().removeAllElements();
				    revalidate();
					
				
			}
		});
		btnCancel.setIcon(new ImageIcon("E:\\java projects\\Record management\\icons\\Actions-window-close-icon.png"));
		btnCancel.setBounds(722, 422, 123, 25);
		panel_2.add(btnCancel);
		//search panel
		
		panel_1.setBounds(265, 121, 465, 243);
		contentPane.add(panel_1);
		panel_1.setVisible(false);
		
		//username text field 
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				textField.setText("");
				
			}
		});
		textField_1= new JTextField();
		textField_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textField_1.setText("");
			}
		});
		
		
		panel_1.setBackground(new Color(0.0f,0.0f,0.0f,0.3f));
		panel_1.setLayout(null);
		
		JLabel label_2 = new JLabel("User Name");
		label_2.setForeground(new Color(255, 255, 255));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_2.setBounds(12, 68, 103, 30);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("Password");
		label_3.setForeground(new Color(255, 255, 255));
		label_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_3.setBounds(12, 124, 103, 30);
		panel_1.add(label_3);
		
		
		textField.setColumns(10);
		textField.setBounds(127, 73, 198, 22);
		panel_1.add(textField);
		
		
		textField_1.setColumns(10);
		textField_1.setBounds(127, 129, 198, 22);
		panel_1.add(textField_1);
		
		JLabel label_4 = new JLabel("Admin Login");
		label_4.setForeground(new Color(255, 255, 255));
		label_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_4.setBounds(165, 13, 114, 31);
		panel_1.add(label_4);
		
		JButton button = new JButton("Login");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().contentEquals("admin")&&textField_1.getText().equals("admin123#")) {
					
					//frame.dispose();
					frame.dispose();
					 AdminPan.setVisible(true);
					 AdminPan.setLocationRelativeTo(null);
					 AdminPanl.sp.dispose();
					 
					 textField_1.setText("");
					 textField.setText("");
					}
				else {
				JFrame	m= new JFrame();
				JOptionPane.showMessageDialog(m,"USER Name or Password is wrong ");
					
				}
			}

				
		});
		button.setBounds(224, 164, 97, 25);
		panel_1.add(button);
		
		JButton button_1 = new JButton("Cancel");
		button_1.setHorizontalAlignment(SwingConstants.LEFT);
		button_1.setIcon(new ImageIcon("E:\\java projects\\Record management\\icons\\Actions-window-close-icon.png"));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				panel.setVisible(true);
			}
		});
		button_1.setBounds(344, 205, 109, 25);
		panel_1.add(button_1);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon("E:\\java projects\\Record management\\icons\\secrecy-icon.png"));
		label_5.setBounds(29, 13, 48, 54);
		panel_1.add(label_5);
		
		
		panel.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.1f));
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		rdbtnSearchById.setBounds(281, 9, 45, 31);
		panel.add(rdbtnSearchById);
		rdbtnSearchById.setHorizontalAlignment(SwingConstants.CENTER);
		
		rdbtnSearchById.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnName.setSelected(false);
				rdbtnBranch.setSelected(false);
				rdbtnSearchById.setSelected(true);
			}
		});
		rdbtnSearchById.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnSearchById.setForeground(new Color(128, 0, 128));
		rdbtnSearchById.setBackground(new Color(248, 248, 255));
		
		Searchbar = new JTextField();
		Searchbar.setBounds(270, 49, 478, 41);
		panel.add(Searchbar);
		Searchbar.setFont(new Font("Tahoma", Font.BOLD, 15));
		Searchbar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Searchbar.setText("");
				
			}
		});
		Searchbar.setOpaque(true);
		Searchbar.setText("Enter id/name/department");
		Searchbar.setColumns(10);
		
		rdbtnName.setBounds(456, 9, 75, 31);
		panel.add(rdbtnName);
		rdbtnName.setHorizontalAlignment(SwingConstants.CENTER);
		//*******************************
		
		
		//event handling
		rdbtnName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				rdbtnSearchById.setSelected(false);
				rdbtnBranch.setSelected(false);
				rdbtnName.setSelected(true);
			}
		});
		
		
		rdbtnName.setBackground(new Color(240, 255, 255));
		rdbtnName.setForeground(new Color(128, 0, 128));
		rdbtnName.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		rdbtnBranch.setBounds(634, 9, 111, 31);
		panel.add(rdbtnBranch);
		rdbtnBranch.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnBranch.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		rdbtnBranch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnName.setSelected(false);
				rdbtnSearchById.setSelected(false);
				rdbtnBranch.setSelected(true);
			}
		});
		rdbtnBranch.setForeground(new Color(128, 0, 128));
		rdbtnBranch.setBackground(new Color(240, 255, 255));
		
		/////table 
		model= new DefaultTableModel();
		table.setModel(model);
		
		btnCancle3 = new JButton("Cancle");
		btnCancle3.setVisible(false);
		btnCancle3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int result = JOptionPane.showConfirmDialog(frame,"Select Yes if you want to Generate Text File", "Swing Tester",
			               JOptionPane.YES_NO_OPTION,
			               JOptionPane.QUESTION_MESSAGE);
			            if(result == JOptionPane.YES_OPTION){

							 try {
								  String url="jdbc:oracle:thin:@localhost:1521:xe";
						    	  Class.forName("oracle.jdbc.driver.OracleDriver");
									//Driver loding
									Connection con=DriverManager.getConnection(url,"system","tiger");
								//	System.out.println("connected");
									Statement stm = con.createStatement();
									
									if(rdbtnSearchById.isSelected()==true) {
									String s="select * from EMP_DETAILS where EMP_ID='"+Searchbar.getText()+"'";
								ResultSet ps4= stm.executeQuery(s);
								File	myObj = new File("E:\\java projects\\Record management\\Textfile\\EMP_Details_EMP_ID.txt");
								 if (myObj.createNewFile()) {
								        System.out.println("File created: " + myObj.getName());
								    
								    	 
								          //myWriter.close();
								    	  
								    	
								    		  FileWriter myWriter = new FileWriter("E:\\java projects\\Record management\\Textfile\\EMP_Details_EMP_ID.txt");
												
								    	  
								    	  myWriter.write("Emp_id \t \t Firse_name \t\t Last_name \t\t Department \t \tDate_of_Joining \t \t Email \t \t Mobile No. \t \t Address");
								    	  
								    	  
								        while(ps4.next()) {
								        	  myWriter.write("\n"+ps4.getString(1)+"\t \t"+ps4.getString(2)+"\t  \t"+ps4.getString(3)+"\t  \t  \t"+ps4.getString(4)+"\t \t \t"+ps4.getString(5)+"\t \t"+ps4.getString(6)+" \t"+ps4.getString(7)+"\t \t"+ps4.getString(8));
								        	
								        }
								        myWriter.close();
								      } else {
								    	 //System.out.println("File created: " + myObj.getName());
								    	
								    		  FileWriter myWriter = new FileWriter("E:\\java projects\\Record management\\Textfile\\EMP_Details_EMP_ID.txt");
												
								    	  myWriter.write("Emp_id \t \t Firse_name \t\t Last_name \t\t Department \t \tDate_of_Joining \t \t Email \t \t Mobile No. \t \t Address");
								    	  while(ps4.next()) {
								        	   myWriter.write("\n"+ps4.getString(1)+"\t \t"+ps4.getString(2)+"\t  \t"+ps4.getString(3)+"\t  \t  \t"+ps4.getString(4)+"\t \t \t"+ps4.getString(5)+"\t \t"+ps4.getString(6)+" \t"+ps4.getString(7)+"\t \t"+ps4.getString(8));
								        	
								        }
								    	  myWriter.close();
											
								       // System.out.println("File already exists.");
								      }
									}
									
									else if(rdbtnName.isSelected()==true) {
										String s="select * from EMP_DETAILS where FIRST_NAME='"+Searchbar.getText()+"'";
									ResultSet	ps4= stm.executeQuery(s);
									File	myObj = new File("E:\\java projects\\Record management\\Textfile\\EMP_Details_byName.txt");
									  if (myObj.createNewFile()) {
									       
													FileWriter myWriter = new FileWriter("E:\\java projects\\Record management\\Textfile\\EMP_Details_byName.txt");
													
									    	  
									    	  myWriter.write("Emp_id \t \t Firse_name \t\t Last_name \t\t Department \t \tDate_of_Joining \t \t Email \t \t Mobile No. \t \t Address");
									    	  
									    	  
									        while(ps4.next()) {
									        	  myWriter.write("\n"+ps4.getString(1)+"\t \t"+ps4.getString(2)+"\t  \t"+ps4.getString(3)+"\t  \t  \t"+ps4.getString(4)+"\t \t \t"+ps4.getString(5)+"\t \t"+ps4.getString(6)+" \t"+ps4.getString(7)+"\t \t"+ps4.getString(8));
									        	
									        }
									        myWriter.close();
									      } else {
									    	
									    	  FileWriter myWriter = new FileWriter("E:\\java projects\\Record management\\Textfile\\EMP_Details_byName.txt");
												
									    	  myWriter.write("Emp_id \t \t Firse_name \t\t Last_name \t\t Department \t \tDate_of_Joining \t \t Email \t \t Mobile No. \t \t Address");
									    	  while(ps4.next()) {
									        	   myWriter.write("\n"+ps4.getString(1)+"\t \t"+ps4.getString(2)+"\t  \t"+ps4.getString(3)+"\t  \t  \t"+ps4.getString(4)+"\t \t \t"+ps4.getString(5)+"\t \t"+ps4.getString(6)+" \t"+ps4.getString(7)+"\t \t"+ps4.getString(8));
									        	
									        }
									    	  myWriter.close();
												
									       
									      }
									    
									/////
									}
									else if(rdbtnBranch.isSelected()==true) 
									{
										 String s="select * from EMP_DETAILS where DEPARTMENT='"+Searchbar.getText()+"'";
									ResultSet	 ps4= stm.executeQuery(s);
									File	 myObj = new File("E:\\java projects\\Record management\\Textfile\\EMP_Details_byDepartmentName.txt");
									  if (myObj.createNewFile()) {
									     
														FileWriter myWriter = new FileWriter("E:\\java projects\\Record management\\Textfile\\EMP_Details_byDepartmentName.txt");
													
									    	  
									    	  myWriter.write("Emp_id \t \t Firse_name \t\t Last_name \t\t Department \t \tDate_of_Joining \t \t Email \t \t Mobile No. \t \t Address");
									    	  
									    	  
									        while(ps4.next()) {
									        	  myWriter.write("\n"+ps4.getString(1)+"\t \t"+ps4.getString(2)+"\t  \t"+ps4.getString(3)+"\t  \t  \t"+ps4.getString(4)+"\t \t \t"+ps4.getString(5)+"\t \t"+ps4.getString(6)+" \t"+ps4.getString(7)+"\t \t"+ps4.getString(8));
									        	
									        }
									        myWriter.close();
									      } else {
									    	   
									    	  FileWriter myWriter = new FileWriter("E:\\java projects\\Record management\\Textfile\\EMP_Details_byDepartmentName.txt");
													
									    	  myWriter.write("Emp_id \t \t Firse_name \t\t Last_name \t\t Department \t \tDate_of_Joining \t \t Email \t \t Mobile No. \t \t Address");
									    	  while(ps4.next()) {
									        	   myWriter.write("\n"+ps4.getString(1)+"\t \t"+ps4.getString(2)+"\t  \t"+ps4.getString(3)+"\t  \t  \t"+ps4.getString(4)+"\t \t \t"+ps4.getString(5)+"\t \t"+ps4.getString(6)+" \t"+ps4.getString(7)+"\t \t"+ps4.getString(8));
									        	
									        }
									    	  myWriter.close();
												
									       // System.out.println("File already exists.");
									      }
									}
									if (fl==1) {
										String s="select * from EMP_DETAILS ";//where EMP_ID='"+Searchbar.getText()+"'";
										//System.out.println("File created: " + myObj.getName());
										ResultSet ps4= stm.executeQuery(s);
										
									File	myObj = new File("E:\\java projects\\Record management\\Textfile\\All_Employes.txt");
									
									 if (myObj.createNewFile()) {
									       
													
														FileWriter  myWriter = new FileWriter("E:\\java projects\\Record management\\Textfile\\All_Employes.txt");
											
									    	  myWriter.write("Emp_id \t \t Firse_name \t\t Last_name \t\t Department \t \tDate_of_Joining \t \t Email \t \t Mobile No. \t \t Address");
									    	  
									    	  
									        while(ps4.next()) {
									        	  myWriter.write("\n"+ps4.getString(1)+"\t \t"+ps4.getString(2)+"\t  \t"+ps4.getString(3)+"\t  \t  \t"+ps4.getString(4)+"\t \t \t"+ps4.getString(5)+"\t \t"+ps4.getString(6)+" \t"+ps4.getString(7)+"\t \t"+ps4.getString(8));
									        	
									        }
									        myWriter.close();
									      } else {
									    	
													
														  FileWriter myWriter = new FileWriter("E:\\java projects\\Record management\\Textfile\\All_Employes.txt");
														
												
									    	  myWriter.write("Emp_id \t \t Firse_name \t\t Last_name \t\t Department \t \tDate_of_Joining \t \t Email \t \t Mobile No. \t \t Address");
									    	  while(ps4.next()) {
									        	   myWriter.write("\n"+ps4.getString(1)+"\t \t"+ps4.getString(2)+"\t  \t"+ps4.getString(3)+"\t  \t  \t"+ps4.getString(4)+"\t \t \t"+ps4.getString(5)+"\t \t"+ps4.getString(6)+" \t"+ps4.getString(7)+"\t \t"+ps4.getString(8));
									        	
									        }
									    	  myWriter.close();
												
									       // System.out.println("File already exists.");
									      }
									
										
									}
							            //ps4= stm.executeQuery(s);
									
						      con.close();
						     
						    
						    } catch (Exception e) {
						      System.out.println("An error occurred.");
						      e.printStackTrace();
						    }
			            	
			            fl=0;
							JOptionPane.showMessageDialog(frame,"Writting Process is Sucessful");
			            }else {
			            	JOptionPane.showMessageDialog(frame,"Operation is Terminated");
			            
			            }
			
				DefaultTableModel dm = (DefaultTableModel) table.getModel();
			    dm.getDataVector().removeAllElements();
			    revalidate();
			    panel_2.setVisible(false);
			    btnAdminLogin.setVisible(false);
				btnNewButton.setVisible(true);
			//	btnAdminLogin.setVisible(true);
				lblNewLabel.setVisible(true);
				//AdminPan.sp.dispose();
				
			}
		});
		btnCancle3.setIcon(new ImageIcon("E:\\java projects\\Record management\\icons\\Actions-window-close-icon.png"));
		btnCancle3.setBounds(818, 422, 123, 25);
		panel_2.add(btnCancle3);
		model.addColumn("EMP_ID");
		model.addColumn("FIRST_NAME");
		model.addColumn("LAST_NAME");
		model.addColumn("DEPARTMENT");
		model.addColumn("DATE of Joinig");
		model.addColumn("EMAIL");
		model.addColumn("MOBILE_NO");
		model.addColumn("ADDRESS");
		
		
		
		
		btnNewButton.setIcon(new ImageIcon("E:\\java projects\\Record management\\icons\\Search-icon (2).png"));
		btnNewButton.setBounds(456, 103, 121, 41);
		panel.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(Searchbar.getText().equals(""))
				{
					JOptionPane.showMessageDialog(frame,"SearchBar could not be blank");
					
				}
				else 
				{
				String url="jdbc:oracle:thin:@localhost:1521:xe";
				try {
					 Searchpanel sb= new Searchpanel();
				Class.forName("oracle.jdbc.driver.OracleDriver");
				//Driver loding
				Connection con=DriverManager.getConnection(url,"system","tiger");
				//System.out.println("connected");
				Statement stm = con.createStatement();
			
				
				if(rdbtnSearchById.isSelected()==true) 
				{
					String s="select * from EMP_DETAILS where EMP_ID='"+Searchbar.getText()+"'";
					
					///String s="select * from EMP_DETAILS where EMP_ID='"+"12345"+"'";
						ResultSet 	 ps1 = stm.executeQuery(s);
					panel_2.setVisible(true);
					btnAdminLogin.setVisible(false);
					lblNewLabel.setVisible(false);
					label_1.setVisible(false);
					btnNewButton.setVisible(false);
				
				if(ps1.next()==true) {
				
				
				
			
			model.addRow(new Object[]{
				ps1.getString(1),
				ps1.getString(2),
				ps1.getString(3),
				ps1.getString(4),
				ps1.getString(5),
				ps1.getString(6),
				ps1.getString(7),
				ps1.getString(8)
				
			});

			
			 table.getColumnModel().getColumn(1).setPreferredWidth(100);
			 table.getColumnModel().getColumn(5).setPreferredWidth(150);
			// table.getColumnModel().getColumn(1).setPreferredWidth(200);
			 DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
		      cellRenderer.setHorizontalAlignment(JLabel.CENTER);
				}
				else {
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame,"EMP_ID is not present");
					
				}
				}
				else if(rdbtnName.isSelected()==true) {
					String s="select * from EMP_DETAILS where FIRST_NAME='"+Searchbar.getText()+"'";
					
					///String s="select * from EMP_DETAILS where EMP_ID='"+"12345"+"'";
						ResultSet 	 ps1 = stm.executeQuery(s);
					

					panel_2.setVisible(true);
					btnAdminLogin.setVisible(false);
					lblNewLabel.setVisible(false);
					label_1.setVisible(false);
					btnNewButton.setVisible(false);
				int flag=0;
				while(ps1.next()==true) {
				flag=1;
			
			model.addRow(new Object[]{
				ps1.getString(1),
				ps1.getString(2),
				ps1.getString(3),
				ps1.getString(4),
				ps1.getString(5),
				ps1.getString(6),
				ps1.getString(7),
				ps1.getString(8)
				
			});

			
			 table.getColumnModel().getColumn(1).setPreferredWidth(100);
			 table.getColumnModel().getColumn(5).setPreferredWidth(150);
		//	 table.getColumnModel().getColumn(1).setPreferredWidth(200);
			 DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
		      cellRenderer.setHorizontalAlignment(JLabel.CENTER);
				}
			
				if(flag==0){
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame,"name is not present");
					
				}
				}
				else if(rdbtnBranch.isSelected()==true) {
					
                    String s1="select * from EMP_DETAILS where DEPARTMENT='"+Searchbar.getText()+"'";
					
					///String s="select * from EMP_DETAILS where EMP_ID='"+"12345"+"'";
						ResultSet 	 ps2 = stm.executeQuery(s1);
					

					panel_2.setVisible(true);
					btnAdminLogin.setVisible(false);
					lblNewLabel.setVisible(false);
					label_1.setVisible(false);
					btnNewButton.setVisible(false);
				int flag1=0;
				while(ps2.next()==true) {
				flag1=1;
			
			model.addRow(new Object[]{
				ps2.getString(1),
				ps2.getString(2),
				ps2.getString(3),
				ps2.getString(4),
				ps2.getString(5),
				ps2.getString(6),
				ps2.getString(7),
				ps2.getString(8)
				
			});

			
			 table.getColumnModel().getColumn(1).setPreferredWidth(100);
			 table.getColumnModel().getColumn(5).setPreferredWidth(150);
			// table.getColumnModel().getColumn(1).setPreferredWidth(200);
			 DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
		      cellRenderer.setHorizontalAlignment(JLabel.CENTER);
				}
			
				if(flag1==0){
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame,"Department Details  is not present");
					
				}
					
					
					
					
				}
					
				else if(rdbtnSearchById.isSelected()==false||rdbtnName.isSelected()==false||rdbtnBranch.isSelected()==false){
					JOptionPane.showMessageDialog(frame,"plese Select id / branch / department button");
					
				}
				
				
			}
				catch(Exception ex){
					JFrame fam = new JFrame();
					JOptionPane.showMessageDialog(fam,"insert proper detail");

					System.out.println(ex.getMessage());
			}

			}
		}
			
		});
		btnNewButton.setBackground(new Color(0, 0, 255));
		btnNewButton.setForeground(new Color(240, 255, 255));
		
		btnCancle_1 = new JButton("Cancle");
		btnCancle_1.setVisible(false);
		btnCancle_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminPan.sp.dispose();
			}
		});
		btnCancle_1.setToolTipText("go back");
		btnCancle_1.setIcon(new ImageIcon("E:\\java projects\\Record management\\icons\\Actions-window-close-icon.png"));
		btnCancle_1.setBounds(624, 206, 144, 25);
		panel.add(btnCancle_1);
		
		btnAllEmployes = new JButton("All Employees");
		btnAllEmployes.setToolTipText("Get all Details i one Click");
		btnAllEmployes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fl =1;
				String url="jdbc:oracle:thin:@localhost:1521:xe";
				try {
					 Searchpanel sb= new Searchpanel();
				Class.forName("oracle.jdbc.driver.OracleDriver");
				//Driver loding
				Connection con=DriverManager.getConnection(url,"system","tiger");
				//System.out.println("connected");
				Statement stm = con.createStatement();
			
				
			
					String s="select * from EMP_DETAILS ";//where EMP_ID='"+Searchbar.getText()+"'";
					
					///String s="select * from EMP_DETAILS where EMP_ID='"+"12345"+"'";
						ResultSet 	 ps1 = stm.executeQuery(s);
					panel_2.setVisible(true);
					btnAdminLogin.setVisible(false);
					lblNewLabel.setVisible(false);
					label_1.setVisible(false);
					btnNewButton.setVisible(false);
				int flag=1;
				while(ps1.next()==true) {
				
				
				flag=1;
			
			model.addRow(new Object[]{
				ps1.getString(1),
				ps1.getString(2),
				ps1.getString(3),
				ps1.getString(4),
				ps1.getString(5),
				ps1.getString(6),
				ps1.getString(7),
				ps1.getString(8)
				
			});

			
			 table.getColumnModel().getColumn(1).setPreferredWidth(100);
			 table.getColumnModel().getColumn(5).setPreferredWidth(150);
			// table.getColumnModel().getColumn(1).setPreferredWidth(200);
			 DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
		      cellRenderer.setHorizontalAlignment(JLabel.CENTER);
				}
				if(flag==0)
				{
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame,"Record is Empty");
					
				}
				con.close();
				}
				catch(Exception ex){
					JFrame fam = new JFrame();
					JOptionPane.showMessageDialog(fam,ex.getMessage());

				//	System.out.println(ex.getMessage());
			}
				
				
			}
		});
		btnAllEmployes.setForeground(new Color(0, 0, 128));
		btnAllEmployes.setBackground(new Color(230, 230, 250));
		btnAllEmployes.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAllEmployes.setBounds(440, 157, 162, 41);
		panel.add(btnAllEmployes);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 1002, 546);
		label.setIcon(new ImageIcon("E:\\java projects\\Record management\\16bd6e42-d114-4a2c-82dd-ec69ea398c73.jpg"));
		contentPane.add(label);
	}
}
