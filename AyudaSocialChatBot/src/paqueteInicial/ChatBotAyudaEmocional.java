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

	}

}

public class ChatBotAyudaEmocional {

	public static void main(String[] args) {
		new Chatbot();
	}

}
