import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.toedter.components.JSpinField;
import com.toedter.calendar.JDateChooser;

public class AdminPanl extends JFrame {

	private JPanel contentPane;
	private static AdminPanl frame = new AdminPanl();
	static Searchpanel sp = new Searchpanel();
	private JTextField idtextField;
	private JTextField fntextField_2;
	private JTextField lntextField_3;
	private JTextField dptextField_4;
	private JTextField emailtextField_6;
	private JTextField mobtextField_7;
	private JTextField addtextField_8;
	private JTextField upidtextField;
	private JDateChooser dateChooser;
	public int temp;
	private JPanel Managepanel;
	private JButton btnDelete;
	private JButton btnDelete_1;
	private JButton button_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminPanl() {
		setResizable(false);
		
		setBounds(100, 100, 1319, 772);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(1151, 43, 117, 39);
		btnLogout.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogout.setToolTipText("logout");
		btnLogout.setIcon(new ImageIcon("E:\\java projects\\Record management\\icons\\Logout-icon (1).png"));
		btnLogout.setForeground(new Color(255, 255, 255));
		btnLogout.setBackground(new Color(204, 0, 0));
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sp.btnCancel.setVisible(true);
				sp.btnCancle3.setVisible(false);
				sp.btnCancle_1.setVisible(false);
				
				sp.btnAdminLogin.setVisible(true);
				sp.label_1.setVisible(true);
				sp.AdminPan.dispose();
				frame.dispose();
				sp.setVisible(true);
				sp.setLocationRelativeTo(null);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnLogout);
		
		JLabel lblAdminPanel = new JLabel("Admin Panel");
		lblAdminPanel.setBounds(495, 25, 323, 89);
		lblAdminPanel.setForeground(new Color(255, 255, 255));
		lblAdminPanel.setFont(new Font("Tahoma", Font.BOLD, 50));
		contentPane.add(lblAdminPanel);
		
		JPanel normalsearch = new JPanel();
		normalsearch.setBounds(10, 248, 1362, 616);
		normalsearch.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.2f));
		
		JPanel idpanel = new JPanel();
		idpanel.setBounds(486, 127, 389, 186);
		idpanel.setVisible(false);
		contentPane.add(idpanel);
		idpanel.setLayout(null);
		idpanel.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.2f));
		
		upidtextField = new JTextField();
		upidtextField.setFont(new Font("Tahoma", Font.BOLD, 14));
		upidtextField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(upidtextField.getText().equalsIgnoreCase("Enter id to Update Details")) {
					upidtextField.setText("");
				}
			}
		});
		
		upidtextField.setToolTipText("Enter id");
		upidtextField.setText("Enter id to Update Details");
		upidtextField.setHorizontalAlignment(SwingConstants.CENTER);
		upidtextField.setColumns(10);
		upidtextField.setBounds(12, 45, 365, 34);
		idpanel.add(upidtextField);
		
		 button_2 = new JButton("Submit");
		button_2.setHorizontalAlignment(SwingConstants.LEFT);
		button_2.setIcon(new ImageIcon("E:\\java projects\\Record management\\icons\\telegram-icon.png"));
		//lable 9
		JLabel label_9 = new JLabel("ADD DETAILS");
		//addpanel
		JPanel Addpanel =  new JPanel();
		Addpanel.setBounds(318, 43, 614, 643);
		///////update your detail lable
		JLabel lblUpdateDetails = new JLabel("Update Details");
		
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblUpdateDetails.setVisible(true);
				
				
				String url="jdbc:oracle:thin:@localhost:1521:xe";
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					//Driver loding
					Connection con=DriverManager.getConnection(url,"system","tiger");
				//	System.out.println("connected");
					Statement stm = con.createStatement();
					String s="select * from EMP_DETAILS where EMP_ID='"+upidtextField.getText()+"'";
					ResultSet 	 ps1 = stm.executeQuery(s);
					if(ps1.next()==true)
					{
						Addpanel.setVisible(true);
						label_9.setVisible(false);
						
						idpanel.setVisible(false);
						String s1="select * from EMP_DETAILS where EMP_ID='"+upidtextField.getText()+"'";
						ResultSet 	 ps2 = stm.executeQuery(s1);
						ps2.next();
						idtextField.setText(ps2.getString(1)); 
						
						fntextField_2.setText(ps2.getString(2));
						
						
						lntextField_3.setText(ps2.getString(3));
						dptextField_4.setText(ps2.getString(4));
						
						   java.util.Date date = new SimpleDateFormat("dd/MM/yyyy").parse( ps2.getString(5));
						
						dateChooser.setDate(date);
						
				        emailtextField_6.setText(ps2.getString(6));
						
				        mobtextField_7.setText(ps2.getString(7));
				        addtextField_8.setText(ps2.getString(8));
						
						
						
					}
					else {
						JOptionPane.showMessageDialog(frame,"ID not found");
						
						
					}
					
				}
				catch(Exception ex){
				//	JFrame fam = new JFrame();
					//JOptionPane.showMessageDialog(fam,"insert proper detail");

					System.out.println(ex.getMessage());
			}
			}
		});
		button_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_2.setBackground(new Color(0, 153, 204));
		button_2.setBounds(28, 117, 113, 25);
		idpanel.add(button_2);
		
		JButton button_3 = new JButton("Cancel");
		button_3.setIcon(new ImageIcon("E:\\java projects\\Record management\\icons\\Actions-window-close-icon.png"));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idpanel.setVisible(false);
				Managepanel.setVisible(true);
			}
		});
		button_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_3.setBackground(new Color(255, 51, 51));
		button_3.setBounds(219, 117, 113, 25);
		idpanel.add(button_3);
		
		btnDelete_1 = new JButton("Delete");
		btnDelete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String url="jdbc:oracle:thin:@localhost:1521:xe";
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					//Driver loding
					Connection con=DriverManager.getConnection(url,"system","tiger");
				//	System.out.println("connected");
					Statement stm = con.createStatement();
					String s="select * from EMP_DETAILS where EMP_ID='"+upidtextField.getText()+"'";
					ResultSet 	 ps1 = stm.executeQuery(s);
					if(ps1.next()==true)
					{
						
						int result = JOptionPane.showConfirmDialog(frame,"Sure? You want to Delete?", "Swing Tester",
					               JOptionPane.YES_NO_OPTION,
					               JOptionPane.QUESTION_MESSAGE);
					            if(result == JOptionPane.YES_OPTION){
					            	
					            	String s3="DELETE from EMP_DETAILS where EMP_ID='"+upidtextField.getText()+"'";
									stm.executeQuery(s3);
									JOptionPane.showMessageDialog(frame,"Deletion Process is Sucessful");
					            }else {
					            	JOptionPane.showMessageDialog(frame,"Operation is Terminated");
					            
					            }
						
						
						
						
						
					}
					
					else {
						JOptionPane.showMessageDialog(frame,"ID not found");
						
						
					}
	         	}
					catch(Exception ex){
						//	JFrame fam = new JFrame();
							//JOptionPane.showMessageDialog(fam,"insert proper detail");

							System.out.println(ex.getMessage());
					}
				
			}
		});
		btnDelete_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDelete_1.setIcon(new ImageIcon("E:\\java projects\\Record management\\icons\\Document-Delete-icon.png"));
		btnDelete_1.setBounds(28, 117, 113, 25);
		idpanel.add(btnDelete_1);
		contentPane.add(Addpanel);
		Addpanel.setVisible(false);
		
		
		
		Addpanel.setLayout(null);
		
		JLabel label = new JLabel("Emp-Id");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(54, 124, 137, 32);
		Addpanel.add(label);
		
		JLabel label_2 = new JLabel("First Name");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(54, 183, 137, 32);
		Addpanel.add(label_2);
		
		JLabel label_3 = new JLabel("Last Name");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_3.setBounds(54, 240, 137, 32);
		Addpanel.add(label_3);
		
		JLabel label_4 = new JLabel("Department ");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_4.setBounds(54, 296, 137, 32);
		Addpanel.add(label_4);
		
		JLabel label_5 = new JLabel("Date of Joining");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_5.setBounds(54, 346, 137, 32);
		Addpanel.add(label_5);
		
		JLabel label_6 = new JLabel("Email-Id");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_6.setBounds(54, 391, 137, 32);
		Addpanel.add(label_6);
		
		JLabel label_7 = new JLabel("Mobile No.");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_7.setBounds(54, 436, 137, 32);
		Addpanel.add(label_7);
		
		JLabel label_8 = new JLabel("Address");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_8.setBounds(54, 498, 137, 32);
		Addpanel.add(label_8);
		
		idtextField = new JTextField();
		idtextField.setFont(new Font("Tahoma", Font.BOLD, 14));
		idtextField.setToolTipText("Must be in number");
		idtextField.setColumns(10);
		idtextField.setBounds(246, 124, 199, 32);
		Addpanel.add(idtextField);
		
		fntextField_2 = new JTextField();
		fntextField_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		fntextField_2.setColumns(10);
		fntextField_2.setBounds(246, 189, 199, 32);
		Addpanel.add(fntextField_2);
		
		lntextField_3 = new JTextField();
		lntextField_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lntextField_3.setColumns(10);
		lntextField_3.setBounds(246, 246, 199, 32);
		Addpanel.add(lntextField_3);
		
		dptextField_4 = new JTextField();
		dptextField_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		dptextField_4.setColumns(10);
		dptextField_4.setBounds(246, 302, 199, 32);
		Addpanel.add(dptextField_4);
		
		 dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.setBounds(256, 346, 178, 32);
		Addpanel.add(dateChooser);
		
		
		emailtextField_6 = new JTextField();
		emailtextField_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		emailtextField_6.setToolTipText("10 digit");
		emailtextField_6.setColumns(10);
		emailtextField_6.setBounds(246, 392, 199, 32);
		Addpanel.add(emailtextField_6);
		
		mobtextField_7 = new JTextField();
		mobtextField_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		mobtextField_7.setColumns(10);
		mobtextField_7.setBounds(246, 442, 199, 32);
		Addpanel.add(mobtextField_7);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(208, 504, 280, 42);
		Addpanel.add(scrollPane);
		
		addtextField_8 = new JTextField();
		scrollPane.setViewportView(addtextField_8);
		addtextField_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		addtextField_8.setColumns(10);
		
		JButton button = new JButton("ADD");
		button.setVisible(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String url="jdbc:oracle:thin:@localhost:1521:xe";
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					//Driver loding
					 Connection con=DriverManager.getConnection(url,"system","tiger");
			//	System.out.println("connected");
					Statement stm = con.createStatement();
					String s="select * from EMP_DETAILS where EMP_ID='"+idtextField.getText()+"'";
					ResultSet 	 ps1 = stm.executeQuery(s);
					
				if(ps1.next()==false) {
					
					PreparedStatement ps=con.prepareStatement("insert into EMP_DETAILS values(?,?,?,?,?,?,?,?)");
					
					ps.setString(1,idtextField.getText()); 
					
					ps.setString(2,fntextField_2.getText());
					
					
					ps.setString(3,lntextField_3.getText());
					ps.setString(4,dptextField_4.getText());
					DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					String date =  df.format(dateChooser.getDate()).toString();
					
			        ps.setString(5,date);
					
			     	ps.setString(6,emailtextField_6.getText());
					if((mobtextField_7.getText().length()==10)/*&&(Integer.parseInt(mobtextField_7.getText())>0)*/) 
					{
						ps.setString(7,mobtextField_7.getText());
						
					}
					else {
						JOptionPane.showMessageDialog(frame,"Mob. No must be 10 Digit & must be a number");
						con.close();
						
					}
					ps.setString(7,mobtextField_7.getText());
					ps.setString(8,addtextField_8.getText());
					ps.executeUpdate();
					JOptionPane.showMessageDialog(frame,"EMP Detail is Added");
					con.close();
					
					
				}
				else {
					JOptionPane.showMessageDialog(frame,"EMP_ID is already present");
					
				}
				
			}
				catch(Exception ex){
					JFrame fam = new JFrame();
					JOptionPane.showMessageDialog(fam,"insert proper detail");

					//System.out.println(ex.getMessage());
			}
			}
				
			
		});
		button.setIcon(new ImageIcon("E:\\java projects\\Record management\\icons\\Button-Add-icon.png"));
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		button.setBackground(new Color(0, 51, 204));
		button.setBounds(102, 606, 97, 25);
		Addpanel.add(button);
		
		JButton button_1 = new JButton("Cancel");
		button_1.setIcon(new ImageIcon("E:\\java projects\\Record management\\icons\\Actions-window-close-icon.png"));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Addpanel.setVisible(false);
				idtextField.setText("");
				
				fntextField_2.setText("");
				lntextField_3.setText("");
				dptextField_4.setText("");
				//dojtextField_5.setText("");
				emailtextField_6.setText("");
				mobtextField_7.setText("");
				addtextField_8.setText("");
				idpanel.setVisible(false);
				Managepanel.setVisible(true);
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_1.setBackground(new Color(0, 51, 204));
		button_1.setBounds(428, 607, 113, 25);
		Addpanel.add(button_1);
		
		JButton btnUpdate12 = new JButton("UPDATE");
		btnUpdate12.setVisible(false);
		btnUpdate12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String url="jdbc:oracle:thin:@localhost:1521:xe";
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					//Driver loding
					Connection con=DriverManager.getConnection(url,"system","tiger");
				//	System.out.println("connected");
					Statement stm = con.createStatement();
					/*String s="select * from EMP_DETAILS where EMP_ID='"+idtextField.getText()+"'";
					ResultSet 	 ps1 = stm.executeQuery(s);*/
					
					
					
					PreparedStatement ps=con.prepareStatement("update   EMP_DETAILS set FIRST_NAME = ?,LAST_NAME = ? ,DEPARTMENT = ? , DATE_OF_JOIONING = ?  ,Email_id = ? ,MOBILE_NO = ?, ADDRESS = ? where EMP_ID ='"+upidtextField.getText()+"'");
//ps.setInt(1,Integer.parseInt(idtextField.getText())); 
					 
					ps.setString(1,fntextField_2.getText());
					
					
					ps.setString(2,lntextField_3.getText());
					ps.setString(3,dptextField_4.getText());
					
					
					
					DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	               String date =  df.format(dateChooser.getDate()).toString();
	               //System.out.print(date);
					
			        ps.setString(4,date);
					
			     	ps.setString(5,emailtextField_6.getText());
					
			     	
			     	if((mobtextField_7.getText().length()==10)/*&&(Integer.parseInt(mobtextField_7.getText())>0)*/) 
					{
						ps.setString(6,mobtextField_7.getText());
						
					}
					else {
						JOptionPane.showMessageDialog(frame,"Mob. No must be 10 Digit & must be a number");
						con.close();
						
					}
					ps.setString(7,addtextField_8.getText());
					ps.executeUpdate();
					JOptionPane.showMessageDialog(frame,"Updation Sucessful");
					con.close();
				
			}
				catch(Exception ex){
					JOptionPane.showMessageDialog(frame,"insert proper details");
					
					

					System.out.println(ex.getMessage());
			}
			
				
			}
		});
		btnUpdate12.setIcon(new ImageIcon("E:\\java projects\\Record management\\icons\\Actions-edit-undo-icon.png"));
		btnUpdate12.setForeground(Color.WHITE);
		btnUpdate12.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnUpdate12.setBounds(208, 607, 127, 25);
		Addpanel.add(btnUpdate12);
		
		
		label_9.setForeground(new Color(204, 255, 255));
		label_9.setFont(new Font("Tahoma", Font.BOLD, 30));
		label_9.setBounds(219, 42, 237, 55);
		Addpanel.add(label_9);
		
		
		lblUpdateDetails.setForeground(new Color(255, 255, 255));
		lblUpdateDetails.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblUpdateDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateDetails.setBounds(149, 48, 359, 42);
		Addpanel.add(lblUpdateDetails);
		
		JLabel label_11 = new JLabel("");
		label_11.setIcon(new ImageIcon("E:\\java projects\\Record management\\icons\\Actions-contact-new-icon.png"));
		label_11.setBounds(30, 13, 97, 98);
		Addpanel.add(label_11);
		
		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon("E:\\java projects\\Record management\\24726649430330fe8d90d1c1287bff3a.jpg"));
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setBounds(0, 0, 611, 643);
		Addpanel.add(label_10);
		contentPane.add(normalsearch);
		normalsearch.setLayout(null);
		
		JButton normalsearchbutton = new JButton("Search");
		normalsearchbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sp.btnCancel.setVisible(false);
				sp.btnCancle3.setVisible(true);
				sp.btnCancle_1.setVisible(true);
				sp.setVisible(true);
				sp.btnAdminLogin.setVisible(false);
				sp.label_1.setVisible(false);
				sp.panel_1.setVisible(false);
				sp.setLocationRelativeTo(null);
			}
			
		
		});
		
		JLabel lblClickSerchButton = new JLabel("Click Serch button to Search EMP Details");
		lblClickSerchButton.setBounds(400, 0, 561, 49);
		normalsearch.add(lblClickSerchButton);
		lblClickSerchButton.setForeground(new Color(255, 0, 0));
		lblClickSerchButton.setBackground(Color.WHITE);
		lblClickSerchButton.setFont(new Font("Tahoma", Font.BOLD, 27));
		normalsearchbutton.setIcon(new ImageIcon("E:\\java projects\\Record management\\icons\\Search-icon (2).png"));
		normalsearchbutton.setForeground(Color.CYAN);
		normalsearchbutton.setFont(new Font("Tahoma", Font.BOLD, 15));
		normalsearchbutton.setBackground(Color.BLUE);
		normalsearchbutton.setBounds(635, 201, 114, 41);
		normalsearch.add(normalsearchbutton);
		//manage button
		
		JButton btnManage = new JButton("Click to Manage");
		btnManage.setBounds(863, 93, 185, 31);
		btnManage.setToolTipText("Click to go Manage Panel");
		
		btnManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnManage.setVisible(false);
				normalsearch.setVisible(false);
				Managepanel.setVisible(true);
				
			}
		});
		btnManage.setForeground(new Color(255, 255, 255));
		btnManage.setBackground(new Color(204, 0, 51));
		btnManage.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(btnManage);
		//manage panal add or update
		Managepanel = new JPanel();
		Managepanel.setBounds(486, 127, 337, 185);
		contentPane.add(Managepanel);
		Managepanel.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.2f));
		Managepanel.setVisible(false);
		Managepanel.setLayout(null);
		
		JButton btnAddNewEmp = new JButton("ADD New");
		btnAddNewEmp.setIcon(new ImageIcon("E:\\java projects\\Record management\\icons\\Button-Add-icon.png"));
		btnAddNewEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblUpdateDetails.setVisible(false);
				Managepanel.setVisible(false);
				Addpanel.setVisible(true);
				btnUpdate12.setVisible(false);
				button.setVisible(true);
				
			}
		});
		btnAddNewEmp.setForeground(new Color(255, 255, 255));
		btnAddNewEmp.setBackground(new Color(0, 51, 204));
		btnAddNewEmp.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAddNewEmp.setBounds(0, 26, 141, 37);
		Managepanel.add(btnAddNewEmp);
		
		JButton btnUpdateEmp = new JButton("Update EMP");
		btnUpdateEmp.setIcon(new ImageIcon("E:\\java projects\\Record management\\icons\\Actions-edit-undo-icon.png"));
		btnUpdateEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button_2.setVisible(true);
				btnDelete_1.setVisible(false);
				idpanel.setVisible(true);
				Managepanel.setVisible(false);
				btnUpdate12.setVisible(true);
				button.setVisible(false);
			
				
				
			}
		});
		btnUpdateEmp.setForeground(new Color(255, 255, 255));
		btnUpdateEmp.setBackground(new Color(0, 51, 204));
		btnUpdateEmp.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnUpdateEmp.setBounds(177, 26, 160, 37);
		Managepanel.add(btnUpdateEmp);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setHorizontalAlignment(SwingConstants.LEFT);
		btnCancel.setIcon(new ImageIcon("E:\\java projects\\Record management\\icons\\Actions-window-close-icon.png"));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Managepanel.setVisible(false);
				btnManage.setVisible(true);
				normalsearch.setVisible(true);
			}
		});
		btnCancel.setBackground(new Color(255, 0, 51));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancel.setBounds(121, 121, 113, 25);
		Managepanel.add(btnCancel);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(255, 0, 0));
		btnDelete_1.setVisible(false);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idpanel.setVisible(true);
				Managepanel.setVisible(false);
				button_2.setVisible(false);
				btnDelete_1.setVisible(true);
				
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDelete.setIcon(new ImageIcon("E:\\java projects\\Record management\\icons\\Document-Delete-icon.png"));
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setBounds(121, 76, 113, 36);
		Managepanel.add(btnDelete);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(10, 0, 1362, 724);
		label_1.setIcon(new ImageIcon("E:\\java projects\\Record management\\a1393964-2ce3-42b8-8824-a232b3788325.jpg"));
		contentPane.add(label_1);
	}
}
