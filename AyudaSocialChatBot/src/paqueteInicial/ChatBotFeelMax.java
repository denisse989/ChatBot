package paqueteInicial;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Label;
import javax.swing.JTextArea;
import java.awt.TextArea;
import java.awt.TextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.JTextPane;

public class ChatBotFeelMax extends JFrame {

	enum IntentChat {
		GREETING, MEETME, MEETCREATORS, HOWAREYOU, GENDER, BYE, MYNAME, TALKING, JOKE, QUOTE, TIP, HUG
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -1607209291460002573L;

	private final JTextArea ca = new JTextArea();
	private boolean lastreplied = false;
	private boolean dontUnderstand = true;
	private boolean gotit = false;
	private boolean closeThis = false;
	private JPanel contentPane;
	String lastReply = "";
	String username = "";

	boolean vent = false;
	boolean joke = false;

	boolean afirmative = false;

	private static Map<String, IntentChat> clientmap = new HashMap<String, IntentChat>();

	private static List<String> badfeelings = new ArrayList<String>();
	private static List<String> goodfeelings = new ArrayList<String>();
	private static List<String> phrasesForTheDay = new ArrayList<String>();
	private static List<String> tipsForTheDay = new ArrayList<String>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initializeIntents();
					ChatBotFeelMax frame = new ChatBotFeelMax();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	protected static void initializeIntents() {
		clientmap.put("hi", IntentChat.GREETING);
		clientmap.put("hello", IntentChat.GREETING);

		clientmap.put("how are you", IntentChat.HOWAREYOU);
		clientmap.put("what's up", IntentChat.HOWAREYOU);

		clientmap.put("your name", IntentChat.MEETME);
		clientmap.put("who are you", IntentChat.MEETME);

		clientmap.put("created you", IntentChat.MEETCREATORS);
		clientmap.put("made you", IntentChat.MEETCREATORS);
		clientmap.put("coded you", IntentChat.MEETCREATORS);
		clientmap.put("authors", IntentChat.MEETCREATORS);
		clientmap.put("creators", IntentChat.MEETCREATORS);

		clientmap.put("you a man", IntentChat.GENDER);
		clientmap.put("you a woman", IntentChat.GENDER);
		clientmap.put("what gender are you", IntentChat.GENDER);
		clientmap.put("your gender", IntentChat.GENDER);

		clientmap.put("see ya", IntentChat.BYE);
		clientmap.put("bye", IntentChat.BYE);
		clientmap.put("until later", IntentChat.BYE);

		clientmap.put("im", IntentChat.TALKING);
//	   clientmap.put("my name is", IntentChat.TALKING);
		clientmap.put("i feel", IntentChat.TALKING);
		clientmap.put("im feeling", IntentChat.TALKING);

		clientmap.put("who am i", IntentChat.MYNAME);
		clientmap.put("who i am", IntentChat.MYNAME);
		clientmap.put("know me", IntentChat.MYNAME);
//	   clientmap.put("my name is", IntentChat.TALKING);

		clientmap.put("a joke", IntentChat.JOKE);
		clientmap.put("laugh", IntentChat.JOKE);

		clientmap.put("quote", IntentChat.QUOTE);
		clientmap.put("famous word", IntentChat.QUOTE);

		clientmap.put("advice", IntentChat.TIP);
		clientmap.put("tips", IntentChat.TIP);
		clientmap.put("to do", IntentChat.TIP);

		clientmap.put("hug", IntentChat.HUG);

		badfeelings.add("blue");
		badfeelings.add("sad");
		badfeelings.add("bad");
		badfeelings.add("low");
		badfeelings.add("down");

		goodfeelings.add("nice");
		goodfeelings.add("awesome");
		goodfeelings.add("good");
		goodfeelings.add("fine");
		goodfeelings.add("happy");

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

	public ChatBotFeelMax() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 328, 552);
		setTitle("FeelMax");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(null);

		JLabel label = new JLabel("");
		label.setBounds(99, 11, 126, 126);
		ImageIcon img = new ImageIcon("feelMax.png");
		Image img1 = img.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon BGIcon = new ImageIcon(img1);
		label.setIcon(BGIcon);
		contentPane.add(label);

		ca.setEditable(false);
		ca.setForeground(new Color(51, 255, 102));
		ca.setBackground(new Color(0, 0, 0));
		Font font = new Font("Arial", Font.BOLD, 10);
		ca.setFont(font);

		JScrollPane pane = new JScrollPane(ca);
		pane.setSize(300, 226);
		pane.setLocation(10, 135);
		contentPane.add(pane);

		final TextField cf = new TextField();
		cf.setBackground(new Color(204, 153, 255));
		cf.setBounds(10, 384, 214, 22);
		contentPane.add(cf);

		final JButton b = new JButton("SEND");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		b.setBackground(new Color(51, 0, 255));
		b.setBounds(230, 383, 89, 23);
		contentPane.add(b);

		JTextPane txtpnHelloFriendI = new JTextPane();
		txtpnHelloFriendI.setEditable(false);
		txtpnHelloFriendI.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		txtpnHelloFriendI.setBackground(new Color(153, 102, 204));
		txtpnHelloFriendI.setText(
				"Hello, friend! I can:\r\n- Listen to your state of attitude\r\n- Tell a joke or give you a hug\r\n- Give information about me \r\n- Give you advices and famous quotes\r\n- Remember your name\r\nTry my services! :D");
		txtpnHelloFriendI.setBounds(6, 412, 300, 100);

		StyledDocument doc = txtpnHelloFriendI.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		contentPane.add(txtpnHelloFriendI);

		ca.append("Hello there" + "\n" + "	I'm FeelMax! your emotional assistant ;)" + "\n" + "\n");
		ca.append("\n");

		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == b) { // Message sents on Click button

					String text = cf.getText().toLowerCase();
					ca.setForeground(Color.GREEN);
					ca.append("You--> " + text + "\n");
					cf.setText("");
					analyze(text);
				}
			}

		});

	}

	public void closeWindow() {
		System.exit(0); // stop program
		dispose(); // close window
		setVisible(false); // hide window
	}

	public void analyze(String text) {
		gotit = false;

		String analyzer = text.toLowerCase();

		if (text.contains("yes") || text.contains("ok") || text.contains("sure")) {
			if (lastReply.equals("Sorry about that, Do you wanna talk about it?")) {
				replyMeth("Ok, let's vent!" + "\n" + "Tell me about your problem" + "\n" + "	I'm all ears! ;)");
				vent = true;
			} else if (lastReply.contains("Is there anything I can do for you?")) {
				replyMeth("Let's make you laugh ;)");
				replyMeth("Did you hear about  the claustrophobic astronaut?");
				replyMeth("He just needed a little space!");
				vent = false;
			} else {
				replyMeth("Ok!");
			}

		} else if (text.contains("no")) {
			if (lastReply.equals("Sorry about that, Do you wanna talk about it?")) {
				replyMeth("Ok, I will respect your feelings");
			} else if (lastReply.contains("Is there anything I can do for you?")) {
				replyMeth("Ok, I will let you get better");
				vent = false;
			}
		} else if (text.equals("") && !vent) {
			replyMeth("You didn't say anything" + "\n" + "	It's everything ok?");
		} else {

			for (Map.Entry<String, IntentChat> entry : clientmap.entrySet()) {
				if (analyzer.contains(entry.getKey())) {
					gotit = true;
					if (!vent) {
						switch (entry.getValue()) {

						case GREETING: {
							lastReply = "Hi there";
							lastreplied = true;
							break;
						}
						case MEETME: {
							lastReply = "I'm your emotional assistant Feelmax!";
							lastreplied = true;
							break;
						}
						case MEETCREATORS: {
							lastReply = "Well, my creators are:" + "\n" + "	- Denisse Baldivieso" + "\n"
									+ "	- Llubitza Linares" + "\n" + "	- Nicole G�ngora" + "\n" + "	- Benjamin Soto"
									+ "\n" + "	- Ricardo Valencia";
							lastreplied = true;
							break;
						}
						case HOWAREYOU: {
							lastReply = "I'm Good :D.Thank you for asking!";
							lastreplied = true;
							break;
						}
						case GENDER: {
							lastReply = "I have no gender, I'm a bot!";
							lastreplied = true;
							break;

						}
						case BYE: {
							lastReply = "See you later, partner! :)";
							lastreplied = true;
							closeThis = true;
							break;
						}
						case TIP: {
							lastReply = "This is one of my advices for today: " + "\n"
									+ tipsForTheDay.get(new Random().nextInt(tipsForTheDay.size() - 1) + 0);
							lastreplied = true;
							break;
						}
						case QUOTE: {
							lastReply = "This is a famous quote I want to share with you: " + "\n"
									+ phrasesForTheDay.get(new Random().nextInt(phrasesForTheDay.size() - 1) + 0);
							lastreplied = true;
							break;
						}
						case HUG: {
							callframe();
							lastReply = "Here, have a hug from Feelmax!";
							lastreplied = true;
							break;
						}
						case JOKE: {
							replyMeth("Ok!" + "\n" + "	NOC! NOC!");
							lastReply = "NOC! NOC!";
							joke = true;
							lastreplied = false;
							break;
						}
						case MYNAME: {
							if (username.equals("")) {
								replyMeth("You didn't tell me your name :(");
							} else {
								replyMeth("You are " + username + " as I remember ;)");
							}
							lastreplied = false;
							break;
						}
						case TALKING: {
							String getSub = "";
							if (entry.getKey().equals("im") && !entry.getKey().contains("feeling")) {
								getSub = "im";
							}

							if (!getSub.equals("")) {
								for (String value : badfeelings) {
									if (analyzer.contains(value)) {
										lastReply = "Sorry about that, Do you wanna talk about it?";

									} else {
										username = Arrays.toString(text.split(getSub)).substring(getSub.length() + 2,
												Arrays.toString(text.split(getSub)).length() - 1);
										lastReply = "Nice to meet you " + username + "!" + "\n"
												+ "I'm Feelmax, you emotional assistant ;)";

									}
									lastreplied = true;
								}
								for (String value : goodfeelings) {
									if (analyzer.contains(value)) {
										lastReply = "I'm glad you feel good";

									} else {
										username = Arrays.toString(text.split(getSub)).substring(getSub.length() + 2,
												Arrays.toString(text.split(getSub)).length() - 1);
										lastReply = "Nice to meet you " + username + "!" + "\n"
												+ "I'm Feelmax, you emotional assistant ;)";

									}
									lastreplied = true;
								}

							} else if (entry.getKey().equals("i feel") || entry.getKey().equals("im feeling")) {
								if (!analyzer.contains("hug")) {
									lastReply = "What? :/";
									for (String value : badfeelings) {
										if (analyzer.contains(value)) {
											lastReply = "Sorry about that, Do you wanna talk about it?";
										}
									}
									for (String value : goodfeelings) {
										if (analyzer.contains(value)) {
											lastReply = "I'm glad you feel like that! :D" + "\n"
													+ "This is one of my advices for today: " + "\n" + tipsForTheDay
															.get(new Random().nextInt(tipsForTheDay.size() - 1) + 0);
											;

										}
									}
								} else {
									callframe();
									lastReply = "Here, have a hug from Feelmax!";
								}

								lastreplied = true;
							}
							break;
						}
						default:
							if (vent) {
								lastReply = "Sorry I hear that :(" + "\n" + "Is there anything I can do for you?";
							} else {
								lastReply = "I can't Understand," + "\n" + " Can you change the words?";
							}
							lastreplied = true;
							break;
						}
					} else if (vent) {
						lastReply = "Sorry hear that :(" + "\n" + "Is there anything I can do for you?";
						lastreplied = true;
						vent = false;
					} else if (joke) {
						if (lastReply.equals("NOC! NOC!")) {
							if (analyzer.contains("who is")) {
								lastReply = "Ach";

							} else {
								lastReply = "NOC! NOC!";

							}
							lastreplied = true;
						} else if (lastReply.equals("Ach")) {
							if (analyzer.contains("who")) {
								lastReply = "Bless you! ;P";
								lastreplied = true;
							} else {
								replyMeth("I Can't Understand," + "\n" + " Can you change the words?");
								lastreplied = false;
							}

						} else if (lastReply.equals("Bless you! ;P")) {
							if (analyzer.contains("jaj") || analyzer.contains("hah")) {
								replyMeth("I'm glad you liked it");
							} else {
								replyMeth("Oh, sorry. I think that joke wasn't funny");

							}
							lastreplied = false;
							joke = false;
						}
					}

				}
			}
			if (!gotit) {
				if (vent) {
					lastReply = "Sorry I hear that :(" + "\n" + "Is there anything I can do for you?";
				} else {
					lastReply = "I can't Understand," + "\n" + " Can you change the words?";
				}
				lastreplied = true;
			}

			if (lastreplied) {
				replyMeth(lastReply);
				if (closeThis) {
					closeWindow();
				}
			}

		}

	}

	public void callframe() {
		new HugFrame();
	}

	public void replyMeth(String s) { // Reply Method
		ca.append("ChatBot-->" + s + "\n");
	}
}
