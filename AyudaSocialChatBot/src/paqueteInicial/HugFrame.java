package paqueteInicial;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;

public class HugFrame extends JFrame {

	private JPanel contentPane;
	private JLabel contentLab;
	private static List<String> listImag=new ArrayList<String>();
	private String imag="";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HugFrame frame = new HugFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void getImag(String g){
		imag=g;
		
	}

	/**
	 * Create the frame.
	 */
	public HugFrame() {
		 listImag.add("imagAbrazo1.jpg");
		   listImag.add("imagAbrazo2.jpg");
		   listImag.add("imagAbrazo3.jpg");
		   listImag.add("imagAbrazo4.jpg");
		   listImag.add("imagAbrazo5.jpg");
		   
		   
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(null);
		
		JLabel backgroundLabel = new JLabel("");
		backgroundLabel.setBounds(0, 0, 854, 459);
		ImageIcon selectImage= new ImageIcon(listImag.get(new Random().nextInt(4)+0));
		Image backgroundChess= selectImage.getImage().getScaledInstance(backgroundLabel.getWidth(), backgroundLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon BGIcon= new ImageIcon(backgroundChess);
		
		backgroundLabel.setIcon(BGIcon);
		contentPane.add(backgroundLabel);
		setVisible(true);
		
	}

}
