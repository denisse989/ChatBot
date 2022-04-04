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
	    GREETING,
	    MEETME,
	    MEETCREATORS,
	    HOWAREYOU, 
	    GENDER, 
	    BYE, 
	    MYNAME, TALKING, JOKE, QUOTE, TIP, HUG
	  }
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1607209291460002573L;
	
	private final JTextArea ca = new JTextArea();
	private JPanel contentPane;
	private boolean openFrame=false;
	String lastReply = "";
	String username = "";
	
	boolean vent = false;
	boolean joke=false;
	
	boolean afirmative = false;
	
	private static Map<String, IntentChat> clientmap = new HashMap<String, IntentChat>();
	
	private static List<String> badfeelings=new ArrayList<String>();
	private static List<String> goodfeelings=new ArrayList<String>();
	private static List<String> phrasesForTheDay=new ArrayList<String>();
	private static List<String> tipsForTheDay=new ArrayList<String>();
	
	
    

	
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
	    
	    clientmap.put("how are you",IntentChat.HOWAREYOU);
	    clientmap.put("what's up",IntentChat.HOWAREYOU);
	    
	    clientmap.put("your name",IntentChat.MEETME);
	    
	    clientmap.put("created you", IntentChat.MEETCREATORS);
	    clientmap.put("made you", IntentChat.MEETCREATORS);
	    clientmap.put("coded you", IntentChat.MEETCREATORS);
	    clientmap.put("authors", IntentChat.MEETCREATORS);
	    clientmap.put("creators", IntentChat.MEETCREATORS);
	    
	    clientmap.put("you a man",IntentChat.GENDER);
	    clientmap.put("you a woman",IntentChat.GENDER);
	    clientmap.put("what gender are you",IntentChat.GENDER);
	    clientmap.put("your gender",IntentChat.GENDER);
	    
	   clientmap.put("see ya", IntentChat.BYE);
	   clientmap.put("bye", IntentChat.BYE);
	   clientmap.put("until later", IntentChat.BYE);
	  
	   clientmap.put("im", IntentChat.TALKING);
	   clientmap.put("i feel",IntentChat.TALKING);
	   
	   clientmap.put("who am i",IntentChat.MYNAME);
	   clientmap.put("who i am",IntentChat.MYNAME);
	   clientmap.put("know me",IntentChat.MYNAME);
	   
	   
	   clientmap.put("a joke",IntentChat.JOKE);
	   clientmap.put("laugh", IntentChat.JOKE);
	   
	   clientmap.put("quote",IntentChat.QUOTE);
	   clientmap.put("famous word",IntentChat.QUOTE);
	   
	   clientmap.put("advice",IntentChat.TIP);
	   clientmap.put("tips",IntentChat.TIP);
	   clientmap.put("to do",IntentChat.TIP);
	   
	   clientmap.put("hug",IntentChat.HUG);
	   
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
	   tipsForTheDay.add("Give yourself fewer choices when you cant make the decision");
	   tipsForTheDay.add("Smile to improve your day");
	   tipsForTheDay.add("Channelize your brain with thoughts of what you want to become. And you will, eventually.");
	   tipsForTheDay.add("Treasure the little things in your life");
	   
	   
	   phrasesForTheDay.add("The secret of getting ahead is getting started");
	   phrasesForTheDay.add("You dont have to be great to start, but you have to start to be great");
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
		ImageIcon img=new ImageIcon("feelMax.png");
		Image img1= img.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon BGIcon= new ImageIcon(img1);
		label.setIcon(BGIcon);
		contentPane.add(label);
		
		
		
		
		ca.setEditable(false);
		ca.setForeground(new Color(51, 255, 102));
		ca.setBackground(new Color(0, 0, 0));
		Font font = new Font("Arial", Font.BOLD, 10);
	    ca.setFont(font);
		
		JScrollPane pane=new JScrollPane(ca);
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
		txtpnHelloFriendI.setText("Hello, friend! I can:\r\n- Listen to your state of attitude\r\n- Tell a joke or give you a hug\r\n- Give information about me \r\n- Give you advices and famous quotes\r\n- Remember your name\r\nTry my services! :D");
		txtpnHelloFriendI.setBounds(10, 412, 300, 100);
		
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
	
	public void analyze(String text){	
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
				&& !text.contains("happy") && !text.contains("down") && !text.contains("ok")
				&& !text.contains("good")) {
			replyMeth("Nice to meet you "
					+ Arrays.toString(text.split("im")).substring(4,
							Arrays.toString(text.split("im")).length() - 1)
					+ "!" + "\n" + "I'm Feelmax, you emotional assistant ;)");

			username = Arrays.toString(text.split("im")).substring(4,
					Arrays.toString(text.split("im")).length() - 1);

		} else if (text.contains("who created you?") || text.contains("who created you")) {
			replyMeth("Well, my creators are:" + "\n" + "	- Denisse Baldivieso" + "\n"
					+ "	- Llubitza Linares" + "\n" + "	- Nicole Góngora" + "\n" + "	- Benjamin Soto"
					+ "\n" + "	- Ricardo Valencia");
			lastReply = "Well, my creators are:" + "\n" + "	- Denisse Baldivieso" + "\n"
					+ "	- Llubitza Linares" + "\n" + "	- Nicole Góngora" + "\n" + "	- Benjamin Soto"
					+ "\n" + "	- Ricardo Valencia";

		} else if (text.contains("bye") || text.contains("good bye")) {
			lastReply = "See you later, partner! :)";
			replyMeth("See you later, partner! :)");
			closeWindow();

		} else if (text.contains("i feel bad") || text.contains("i feel sad") || text.contains("im sad")
				|| text.contains("im not ok") || text.contains("im feeling bad")
				|| text.contains("im feeling sad") || text.contains("im feeling blue")
				|| text.contains("im feeling low") || text.contains("i feel down")
				|| text.contains("im feeling down")) {
			lastReply = "Sorry to hear that, Do you wanna talk about it?";
			replyMeth("Sorry to hear that, Do you wanna talk about it?");
			System.out.println(lastReply);

		} else if (text.contains("i feel well") || text.contains("im feeling good")
				|| text.contains("i feel great") || text.contains("im feeling great")
				|| text.contains("im feeling amazing") || text.contains("im ok") || text.contains("im good")
				|| text.contains("i feel very well") || text.contains("i feel so well")) {

			lastReply = "I'm glad you feel like that! :D" + "\n" + "This is one of my advices for today: "
					+ "\n" + tipsForTheDay.get(new Random().nextInt(tipsForTheDay.size() - 1) + 0);
			replyMeth(lastReply);

		} else if (text.equals("yes") || text.equals("ok") || text.equals("yeah") || text.equals("yeh")
				|| text.equals("yep")) {
			if (lastReply.equals("Sorry to hear that, Do you wanna talk about it?")) {
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

		} else if (text.contains("hug")) {
			lastReply = "Here, have a hug from Feelmax!";
			replyMeth(lastReply);
			callframe();

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
		} else if (text.contains("quote") || text.contains("famous word")) {
			lastReply = "This is a famous quote I want to share with you: " + "\n"
					+ phrasesForTheDay.get((int) Math.floor(Math.random() * (5 - 0 + 1) + 0));
			replyMeth(lastReply);

		} else if (text.contains("advice") || text.contains("tip") || text.contains("to do") || text.contains("can do")) {
			lastReply = "This is one of my advices for today: " + "\n"
					+ tipsForTheDay.get(new Random().nextInt(tipsForTheDay.size() - 1) + 0);
			replyMeth(lastReply);
		} else {

			if (vent) {
				replyMeth("Sorry to hear that :(" + "\n" + "Is there anything I can do for you?");
				lastReply = "Sorry to hear that :(" + "\n" + "Is there anything I can do for you?";
			} else {
				replyMeth("I Can't Understand," + "\n" + " Can you change the words?");
				lastReply = "I Can't Understand," + "\n" + " Can you change the words?";
			}
		}
					
	}
	
	
	
	public void callframe(){
		
		new HugFrame();
	}
	
			

	public void replyMeth(String s) { // Reply Method
		ca.append("ChatBot-->" + s + "\n");
	}
}
