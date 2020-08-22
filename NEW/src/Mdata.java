import javax.swing.*;
import java.awt.*;
public class Mdata{

	public static void main(String[] args) {
		JFrame jframe= new JFrame("AARSSG Travel's");
			jframe.setVisible(true);
			jframe.getContentPane().setBackground(Color.CYAN);
			 jframe.setLayout(new BorderLayout());
			 ImageIcon ii = new ImageIcon("C:\\Users\\ABHISHEK\\Desktop\\inked.jpg");
		      JLabel lable = new JLabel(ii);
		      jframe.add(lable);
			jframe.setSize(800, 800);
			jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		
	}

}