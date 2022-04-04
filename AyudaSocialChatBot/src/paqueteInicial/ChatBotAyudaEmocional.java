package paqueteInicial;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.desktop.ScreenSleepEvent;
import java.awt.desktop.SystemSleepEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.MatteBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

class Chatbot extends JFrame {

	private static List<String> phrasesForTheDay = new ArrayList<String>();
	private static List<String> tipsForTheDay = new ArrayList<String>();

	protected static void initializeIntents() {
		tipsForTheDay.add("Write down your thoughts when you feel stressed or anxious");
		tipsForTheDay.add("Give yourself fewer choices when you can�t make the decision");
		tipsForTheDay.add("Smile to improve your day");
		tipsForTheDay.add("Channelize your brain with thoughts of what you want to become. And you will, eventually.");
		tipsForTheDay.add("Treasure the little things in your life");

		phrasesForTheDay.add("The secret of getting ahead is getting started");
		phrasesForTheDay.add("You don�t have to be great to start, but you have to start to be great");
		phrasesForTheDay.add("I believe that the only courage anybody ever needs is the courage to follow your dreams");
		phrasesForTheDay.add("All our dreams will come true, if we have the courage to pursue them");
		phrasesForTheDay.add("Imagine your life is perfect in every respect; what would it look like?");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextArea ca = new JTextArea();
	private JScrollPane sc = new JScrollPane(ca);
	private JTextField cf = new JTextField();
	private JButton b = new JButton();
	private JLabel l = new JLabel();
	private JPanel contentPane;
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
				initializeIntents();
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

					} else if (text.contains("what is your name") || text.contains("what is your name?")
							|| text.contains("who are you")) {
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
							lastReply = "Ach";
						} else
							replyMeth("Who is who?");

					} else if (text.contains("ach who") || text.contains("ach who?")) {
						if (lastReply.contains("Ach"))
							replyMeth("Bless you! ;P");
						else
							replyMeth("I Canxdt Understand," + "\n" + " Can you change the words?");

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
					} else if (text.contains("quote") || text.contains("famous word")) {
						lastReply = "This is a famous quote I want to share with you: " + "\n"
								+ phrasesForTheDay.get((int) Math.floor(Math.random() * (5 - 0 + 1) + 0));
						replyMeth(lastReply);

					} else if (text.contains("advice") || text.contains("tips") || text.contains("to do")) {
						lastReply = "This is one of my advices for today: " + "\n"
								+ tipsForTheDay.get(new Random().nextInt(tipsForTheDay.size() - 1) + 0);
						replyMeth(lastReply);
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