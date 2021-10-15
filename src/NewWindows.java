import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class NewWindows {

	private JFrame frame;
	private String name;
	private String clan, playerClass;
	private Integer[] stat = new Integer[6];
	private Random rand = new Random();

	public NewWindows() {
		newWindows();
	}
	
	private void newWindows(){
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

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(15, 16, 69, 20);
		frame.getContentPane().add(lblName);
		
		JTextField textField;
		textField = new JTextField();
		textField.setBounds(82, 15, 261, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	
		JLabel lblClan = new JLabel("Clan");
		lblClan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblClan.setBounds(15, 63, 69, 20);
		frame.getContentPane().add(lblClan);
		
		ButtonGroup btnClan = new ButtonGroup();
		
		JRadioButton rdbtnOrc = new JRadioButton("Orc");
		rdbtnOrc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clan = "Orc";
			}
		});
		btnClan.add(rdbtnOrc);
		rdbtnOrc.setBounds(15, 95, 81, 29);
		frame.getContentPane().add(rdbtnOrc);
		
		JRadioButton rdbtnHuman = new JRadioButton("Human");
		rdbtnHuman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clan = "Human";
			}
		});
		btnClan.add(rdbtnHuman);
		rdbtnHuman.setBounds(15, 132, 155, 29);
		frame.getContentPane().add(rdbtnHuman);
		
		JRadioButton rdbtnElf = new JRadioButton("Elf");
		rdbtnElf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clan = "Elf";
			}
		});
		btnClan.add(rdbtnElf);
		rdbtnElf.setBounds(15, 169, 155, 29);
		frame.getContentPane().add(rdbtnElf);
		
		JRadioButton rdbtnDwarf = new JRadioButton("Dwarf");
		rdbtnDwarf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clan = "Dwarf";
			}
		});
		btnClan.add(rdbtnDwarf);
		rdbtnDwarf.setBounds(15, 206, 155, 29);
		frame.getContentPane().add(rdbtnDwarf);
		
		JRadioButton rdbtnHobbit = new JRadioButton("Hobbit");
		rdbtnHobbit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clan = "Hobbit";
			}
		});
		btnClan.add(rdbtnHobbit);
		rdbtnHobbit.setBounds(15, 243, 155, 29);
		frame.getContentPane().add(rdbtnHobbit);
		
		JLabel lblClass = new JLabel("Class");
		lblClass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblClass.setBounds(188, 63, 69, 20);
		frame.getContentPane().add(lblClass);
		
		ButtonGroup btnClass = new ButtonGroup();
		
		JRadioButton rdbtnFighter = new JRadioButton("Warrior");
		btnClass.add(rdbtnFighter);
		rdbtnFighter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerClass = "Warrior";
			}
		});
		rdbtnFighter.setBounds(188, 95, 155, 29);
		frame.getContentPane().add(rdbtnFighter);
		
		JRadioButton rdbtnAssassin = new JRadioButton("Assassin");
		btnClass.add(rdbtnAssassin);
		rdbtnAssassin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerClass = "Assassin";
			}
		});
		rdbtnAssassin.setBounds(188, 132, 155, 29);
		frame.getContentPane().add(rdbtnAssassin);
		
		JRadioButton rdbtnMage = new JRadioButton("Mage");
		btnClass.add(rdbtnMage);
		rdbtnMage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerClass = "Mage";
			}
		});
		rdbtnMage.setBounds(188, 169, 155, 29);
		frame.getContentPane().add(rdbtnMage);
		
		JRadioButton rdbtnArcher = new JRadioButton("Archer");
		btnClass.add(rdbtnArcher);
		rdbtnArcher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerClass = "Archer";
			}
		});
		rdbtnArcher.setBounds(188, 206, 155, 29);
		frame.getContentPane().add(rdbtnArcher);
		
		JRadioButton rdbtnPriest = new JRadioButton("Priest");
		btnClass.add(rdbtnPriest);
		rdbtnPriest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerClass = "Priest";
			}
		});
		rdbtnPriest.setBounds(188, 243, 155, 29);
		frame.getContentPane().add(rdbtnPriest);
		
		JLabel lblStat = new JLabel("Stat");
		lblStat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblStat.setBounds(426, 63, 69, 20);
		frame.getContentPane().add(lblStat);
		
		JLabel lblSTR = new JLabel("STR");
		lblSTR.setBounds(381, 99, 69, 20);
		frame.getContentPane().add(lblSTR);
		
		JLabel lblCON = new JLabel("CON");
		lblCON.setBounds(381, 136, 69, 20);
		frame.getContentPane().add(lblCON);
		
		JLabel lblDEX = new JLabel("DEX");
		lblDEX.setBounds(381, 173, 69, 20);
		frame.getContentPane().add(lblDEX);
		
		JLabel lblINT = new JLabel("INT");
		lblINT.setBounds(381, 210, 69, 20);
		frame.getContentPane().add(lblINT);
		
		JLabel lblWIS = new JLabel("WIS");
		lblWIS.setBounds(381, 247, 69, 20);
		frame.getContentPane().add(lblWIS);
		
		JLabel lblCHA = new JLabel("CHA");
		lblCHA.setBounds(381, 283, 69, 20);
		frame.getContentPane().add(lblCHA);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(465, 95, 41, 20);
		frame.getContentPane().add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		textPane_1.setBounds(465, 132, 41, 20);
		frame.getContentPane().add(textPane_1);
		
		JTextPane textPane_1_1 = new JTextPane();
		textPane_1_1.setEditable(false);
		textPane_1_1.setBounds(465, 169, 41, 20);
		frame.getContentPane().add(textPane_1_1);
		
		JTextPane textPane_1_2 = new JTextPane();
		textPane_1_2.setEditable(false);
		textPane_1_2.setBounds(465, 206, 41, 20);
		frame.getContentPane().add(textPane_1_2);
		
		JTextPane textPane_1_3 = new JTextPane();
		textPane_1_3.setEditable(false);
		textPane_1_3.setBounds(465, 243, 41, 20);
		frame.getContentPane().add(textPane_1_3);
		
		JTextPane textPane_1_4 = new JTextPane();
		textPane_1_4.setEditable(false);
		textPane_1_4.setBounds(465, 283, 41, 20);
		frame.getContentPane().add(textPane_1_4);
		
		JTextPane textPane_1_4_1 = new JTextPane();
		textPane_1_4_1.setEditable(false);
		textPane_1_4_1.setBounds(465, 340, 41, 20);
		frame.getContentPane().add(textPane_1_4_1);
		
		JButton btnRoll = new JButton("ROLL");
		btnRoll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer totalStat = 0;
				for(int i = 0; i < 6; i++){
					stat[i] = rand.nextInt(14) + 6;
					totalStat = totalStat + stat[i];
				}
				textPane.setText(stat[0].toString());
				textPane_1.setText(stat[1].toString());
				textPane_1_1.setText(stat[2].toString());
				textPane_1_2.setText(stat[3].toString());
				textPane_1_3.setText(stat[4].toString());
				textPane_1_4.setText(stat[5].toString());
				textPane_1_4_1.setText(totalStat.toString());
			}
		});
		btnRoll.setBounds(391, 384, 115, 29);
		frame.getContentPane().add(btnRoll);
		
		JLabel lblNewLabel = new JLabel("*please fill in all the blank bracket");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(358, 18, 216, 20);
		lblNewLabel.setVisible(false);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnPlay = new JButton("PLAY");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name = textField.getText();
				if(!name.equals("") && clan != null && playerClass != null && stat[0] != null){
					frame.dispose();
					new Main(name, clan, playerClass, stat);
				}
				lblNewLabel.setVisible(true);
				lblNewLabel.revalidate();
			}
		});
		btnPlay.setForeground(Color.BLUE);
		btnPlay.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnPlay.setBounds(82, 317, 175, 54);
		frame.getContentPane().add(btnPlay);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(381, 340, 69, 20);
		frame.getContentPane().add(lblTotal);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new Menu2();
			}
		});
		btnBack.setBounds(15, 399, 115, 29);
		frame.getContentPane().add(btnBack);
		
	}
}
