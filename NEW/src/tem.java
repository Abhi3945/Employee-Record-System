import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class tem extends JFrame {

	private JPanel contentPane;
	public static tem frame;
	private DefaultTableModel model;
	public static  String id;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new tem();
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
	public tem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1180, 712);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		model= new DefaultTableModel();
		
		JButton btnButton = new JButton("button");
		btnButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {  
			 
				 try {
					  String url="jdbc:oracle:thin:@localhost:1521:xe";
			    	  Class.forName("oracle.jdbc.driver.OracleDriver");
						//Driver loding
						Connection con=DriverManager.getConnection(url,"system","tiger");
					//	System.out.println("connected");
						Statement stm = con.createStatement();
						String s="select * from EMP_DETAILS";//where EMP_ID"//='"+upidtextField.getText()+"'";
						ResultSet 	 ps1 = stm.executeQuery(s);
			      File myObj = new File("E:\\java projects\\Record management\\Textfile\\filename.txt");
			      if (myObj.createNewFile()) {
			        //System.out.println("File created: " + myObj.getName());
			    	  FileWriter myWriter = new FileWriter("E:\\java projects\\Record management\\Textfile\\filename.txt");
			    	  myWriter.write("Emp_id \t \t Firse_name \t\t Last_name \t\t Department \t \tDate_of_Joining \t \t Email \t \t Mobile No. \t \t Address");
			          //myWriter.close();
			        while(ps1.next()) {
			        	  myWriter.write("\n"+ps1.getString(1)+"\t \t"+ps1.getString(2)+"\t  \t"+ps1.getString(3)+"\t  \t  \t"+ps1.getString(4)+"\t \t \t"+ps1.getString(5)+"\t \t"+ps1.getString(6)+" \t"+ps1.getString(7)+"\t \t"+ps1.getString(8));
			        	
			        }
			        myWriter.close();
			      } else {
			    	  FileWriter myWriter = new FileWriter("E:\\java projects\\Record management\\Textfile\\filename.txt");
			    	  myWriter.write("Emp_id \t \t Firse_name \t\t Last_name \t\t Department \t \tDate_of_Joining \t \t Email \t \t Mobile No. \t \t Address");
			    	  while(ps1.next()) {
			        	   myWriter.write("\n"+ps1.getString(1)+"\t \t"+ps1.getString(2)+"\t  \t"+ps1.getString(3)+"\t  \t  \t"+ps1.getString(4)+"\t \t \t"+ps1.getString(5)+"\t \t"+ps1.getString(6)+" \t"+ps1.getString(7)+"\t \t"+ps1.getString(8));
			        	
			        }
			    	  myWriter.close();
						
			       // System.out.println("File already exists.");
			      }
			    
			    } catch (Exception e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();
			    }
		            
				
				
			}
			
		});
	btnButton.setBounds(693, 63, 97, 25);
		contentPane.add(btnButton);
	}
}
//}
