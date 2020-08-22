import javax.swing.*;
import java.awt.*;
public class Quiz extends JFrame{
	 JLabel lable,l;
	 ImageIcon ii;
	Quiz(String a){
		super(a);
	}
	
	public static void main(String[] args) {	
			Quiz qz = new Quiz("Axis Quiz");
			
			qz.getContentPane().setBackground(Color.CYAN);
			qz.setVisible(true);
			qz.setSize(800, 800);
			qz.welcomcomponent();
			
			qz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		
	}
 void welcomcomponent() {
      l = new JLabel("Welcom to Quiz");
      l.setFont(new Font("Arial",Font.ITALIC ,80));
      l.setForeground(Color.RED);
    l.setBounds(101,100,1000,200);
    setLayout(null);
    add(l);
    
    
      
	
}	

}