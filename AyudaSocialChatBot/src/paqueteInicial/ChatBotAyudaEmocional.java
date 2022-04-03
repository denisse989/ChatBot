package paqueteInicial;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class Chatbot extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea ca = new JTextArea();
	private JTextField cf = new JTextField();
	private JButton b = new JButton();
	private JLabel l = new JLabel();

	Chatbot() {
		
		JFrame f=new JFram ();
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setResizable(false);
		f.setLayout(null);
		f.setSize(400,400);
		f.getContentPane().setBackground(Color.cyan);
		f.setTitle("ChatBot");
		f.add(ca);
		f.add(cd);
		f.add(b);
		b.add(l);
		ca.setSize(300,310);
		ca.setLocation(1,1);
		ca.setBackground(Color.BLACK);
		b.setSize(400,20);

	}

}

public class ChatBotAyudaEmocional {

	public static void main(String[] args) {
		new Chatbot();
	}

}
