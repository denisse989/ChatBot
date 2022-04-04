package paqueteInicial;

import java.awt.Color;
import java.awt.Font;
import java.awt.desktop.ScreenSleepEvent;
import java.awt.desktop.SystemSleepEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class Chatbot extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextArea ca = new JTextArea();
	private JScrollPane sc=new JScrollPane(ca);
	private JTextField cf = new JTextField();
	private JButton b = new JButton();
	private JLabel l = new JLabel();
	String lastReply = "";
	String username = "";
	boolean vent = false;
	boolean afirmative = false;


	Chatbot() {
		

		JFrame f = new JFrame();
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setResizable(false);
		f.setLayout(null);
		f.setSize(400, 400);
		f.getContentPane().setBackground(Color.cyan);
		f.setTitle("Feelmax");
		f.add(ca);
		f.add(cf);
		ca.setSize(400, 310);
		ca.setLocation(1, 1);
		ca.setBackground(Color.BLACK);
		cf.setSize(300, 20);
		cf.setLocation(1, 320);
		f.add(b);
		l.setText("SEND");
		b.add(l);
		b.setSize(400, 20);
		b.setLocation(300, 320);
		ca.setForeground(Color.GREEN);
		ca.append("Hello there" + "\n" + "	I'm Feelmax! your emotional assistant ;)" + "\n" + "\n"
				+ "[NOTE: allways write in lowercase]" + "\n");
		ca.append("\n");
//		ca.setFont(new Font("Arial Black", Font.BOLD, 12)); //change font and size
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == b) { // Message sents on Click button

					String text = cf.getText().toLowerCase();
					ca.setForeground(Color.GREEN);
					ca.append("You--> " + text + "\n");
					cf.setText("");

					if (text.contains("hi") || text.contains("hello")) {// input Checking
						lastReply = "Hi there";
						replyMeth("Hi there");

					} else if (text.contains("how are you") || text.contains("how are you?")) {
						lastReply = "I'm Good :D.Thankyou for asking";
						replyMeth("I'm Good :D.Thankyou for asking");

					} else if (text.contains("what is your name") || text.contains("what is your name?")) {
						lastReply = "I'm your emotional assistant Feelmax!";
						replyMeth("I'm your emotional assistant Feelmax!");

					} else if (text.contains("are you a man?") || text.contains("are you a man")
							|| text.contains("are you a woman?") || text.contains("are you a woman")
							|| text.contains("what gender are you?") || text.contains("what gender are you")) {
						lastReply = "I have no gender, I'm a bot!";
						replyMeth("I have no gender, I'm a bot!");

					} else if (text.contains("im") && !text.contains("sad") && !text.contains("blue")
							&& !text.contains("happy") && !text.contains("down")) {
						replyMeth("Nice to meet you "
								+ Arrays.toString(text.split("im")).substring(4,
										Arrays.toString(text.split("im")).length() - 1)
								+ "!" + "\n" + "I'm Feelmax, you emotional assistant ;)");

						username = Arrays.toString(text.split("im")).substring(4,
								Arrays.toString(text.split("im")).length() - 1);

					} else if (text.contains("who created you?") || text.contains("who created you")) {
						replyMeth("Well, my creators are:" + "\n" + "	- Denisse Baldivieso" + "\n"
								+ "	- Llubitza Linares" + "\n" + "	- Nicole G�ngora" + "\n" + "	- Benjamin Soto"
								+ "\n" + "	- Ricardo Valencia");
						lastReply = "Well, my creators are:" + "\n" + "	- Denisse Baldivieso" + "\n"
								+ "	- Llubitza Linares" + "\n" + "	- Nicole G�ngora" + "\n" + "	- Benjamin Soto"
								+ "\n" + "	- Ricardo Valencia";

					} else if (text.contains("bye") || text.contains("good bye")) {
						lastReply = "See you later, partner! :)";
						replyMeth("See you later, partner! :)");

					} else if (text.contains("i feel bad") || text.contains("i feel sad") || text.contains("im sad")
							|| text.contains("im not ok") || text.contains("im feeling bad")
							|| text.contains("im feeling sad") || text.contains("im feeling blue")
							|| text.contains("im feeling low") || text.contains("i feel down")
							|| text.contains("im feeling down")) {
						lastReply = "Sorry hear that, Do you wanna talk about it?";
						replyMeth("Sorry hear that, Do you wanna talk about it?");
						System.out.println(lastReply);

					} else if (text.equals("yes") || text.equals("ok")) {
						if (lastReply.equals("Sorry hear that, Do you wanna talk about it?")) {
							replyMeth("Ok, let's vent!" + "\n" + "Tell me about your problem" + "\n"
									+ "	I'm all ears! ;)");
							vent = true;
						} else if (lastReply.contains("Is there anything I can do for you?")) {
							replyMeth("Let's make you laugh ;)");
							replyMeth("Did you hear about  the claustrophobic astronaut?");
							replyMeth("He just needed a little space!");
						} else
							replyMeth("Ok!");

					} else if (text.contains("tell me a joke")) {
						replyMeth("Ok!" + "\n" + "	NOC! NOC!");
						lastReply = "NOC! NOC!";


					} else if (text.contains("jaja")) {
						replyMeth("Funny! ;P " + "\n" + "	jajaja");
					} else if (text.contains("who is") || text.contains("who is?")) {
						if (lastReply.equals("NOC! NOC!")) {
							replyMeth("Ach");
						} else
							replyMeth("Who is who?");

					} else if (text.contains("ach who") || text.contains("ach who?")) {
						if (lastReply.contains("Ach"))
							replyMeth("Bless you! ;P");
						else
							replyMeth("I Can't Understand," + "\n" + " Can you change the words?");

					} else if (text.equals("")) {
						replyMeth("You didn't say anything" + "\n" + "	It's everything ok?");

					} else if (text.contains("bye") || text.contains("good bye")) {
						lastReply = "See you later, partner! :)";
						replyMeth("See you later, partner! :)");

						closeWindow();

					} else if (text.contains("you know me") || text.contains("what is my name")) {
						if (username.equals(""))
							replyMeth("You didn't tell me your name :(");
						else
							replyMeth("You are " + username + " as I remember ;)");
					} else {

						if (vent) {
							replyMeth("Sorry hear that :(" + "\n" + "Is there anything I can do for you?");
							lastReply = "Sorry hear that :(" + "\n" + "Is there anything I can do for you?";
						} else {
							replyMeth("I Can't Understand," + "\n" + " Can you change the words?");
							lastReply = "I Can't Understand," + "\n" + " Can you change the words?";
						}
					}
				}

			}

		});

	}

	public void closeWindow() { // TODO doesn't close the program :c
		System.exit(0); // stop program
		dispose(); // close window
		setVisible(false); // hide window
	}

	public void replyMeth(String s) { // Reply Method
		ca.append("ChatBot-->" + s + "\n");
	}

}

public class ChatBotAyudaEmocional { // Driver Class

	public static void main(String[] args) { // main class

		new Chatbot(); // instantiation
	}

}