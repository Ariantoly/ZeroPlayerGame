import java.awt.*;
import java.awt.event.*;
//import java.io.*;
//import java.util.Scanner;
import java.util.Vector;

import javax.swing.*;

public class Menu2 {

	private JFrame frame;
//	private Scanner fr;
	public static Vector<Player> vecPlayer = new Vector<Player>();

	public Menu2() {
		secondMenu();
	}
	
	private void secondMenu(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initialize();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
//	private void readFile(String fileName){
//		File file = new File(fileName);
//		try {
//			fr = new Scanner(file);
//		} catch (FileNotFoundException e) {
//			System.out.println("File doesn't exist");
//		}
//	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 500);
		frame.getContentPane().setBackground(Color.WHITE);;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JLabel lblZeroPlayerGame = new JLabel("PROGRESS HUNTER");
		lblZeroPlayerGame.setFont(new Font("Tahoma", Font.PLAIN, 60));
		lblZeroPlayerGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblZeroPlayerGame.setBounds(0, 70, 578, 97);
		frame.getContentPane().add(lblZeroPlayerGame);
		
		JButton btnStart = new JButton("NEW");
		btnStart.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new NewWindows();
			}
		});
		btnStart.setBounds(209, 236, 160, 41);
		frame.getContentPane().add(btnStart);
		
		JButton btnContinue = new JButton("CONTINUE");
		btnContinue.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnContinue.setBounds(209, 292, 160, 41);
//		readFile("Save.txt");
//		if(!fr.hasNextLine()) btnContinue.setEnabled(false);;
		btnContinue.setEnabled(false);
		frame.getContentPane().add(btnContinue);
		
		JButton btnStart_1_1 = new JButton("BACK");
		btnStart_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Menu1();
			}
		});
		btnStart_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnStart_1_1.setBounds(209, 347, 160, 41);
		frame.getContentPane().add(btnStart_1_1);
	}

}
