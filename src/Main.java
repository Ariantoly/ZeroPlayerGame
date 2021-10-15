import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Vector;

public class Main {

	private JFrame frame;
	private JPanel panel = new JPanel(), panel_1_1 = new JPanel();
	public JProgressBar progressBar, progressBar_1, progressBar_2; 
	private JLabel lblNewLabel, lblGold, lblGold_1, lblWeapon_1, lblShield_1, lblHelm_1, lblBodyArmor_1, lblPrologue, 
	lblAct, lblAct_1, lblAct_2, lblFinalAct;
	private JTextPane txtpnNameClanClass_1;
	private JCheckBox chckbxPrologue, chckbxAct, chckbxAct_1, chckbxAct_2, chckbxFinalAct;
	private JTextArea textArea, textArea_1;
	
	private Player player;
	private Integer[] stat;
	private Vector<Bag> vecInventory = new Vector<Bag>();
	private Integer gold = 0, stopFlag = 0;
	private Random rand = new Random();
	private Object objPlayerDev = new Object(), objSell = new Object(), objOtw = new Object();
	private Vector<Equipment> equipMart = new Vector<Equipment>();
	private Equipment weapon = new Equipment(""), shield = new Equipment(""), helm = new Equipment(""), 
			bodyArmor = new Equipment("");

	public static void main(String[] args) {
		new Menu1();
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public Main(String name, String clan, String playerClass, Integer[] stat) {
		createWindows();
		player = new Player(name, clan, playerClass, stat);
		this.stat = player.getStat();
		Menu2.vecPlayer.add(player);
		initEquipMart();
	}
	
	private void initEquipMart(){
		for(int i = 0; i < 40; i++){
			equipMart.add(new Equipment("Equipment " + (i + 1)));
		}
	}

	private void createWindows(){
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
		frame.setResizable(false);
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCharacterSheet = new JLabel("Character Sheet");
		lblCharacterSheet.setBounds(15, 16, 196, 20);
		frame.getContentPane().add(lblCharacterSheet);
		
		panel.setBackground(Color.WHITE);
		panel.setBounds(15, 40, 196, 266);
		panel.setLayout(null);
		
		JLabel lblTrait = new JLabel("Trait");
		lblTrait.setBackground(Color.WHITE);
		lblTrait.setBounds(12, 12, 69, 20);
		panel.add(lblTrait);
		
		JLabel lblValue = new JLabel("Value");
		lblValue.setBounds(96, 12, 69, 20);
		panel.add(lblValue);
		
		JTextPane txtpnNameClanClass = new JTextPane();
		txtpnNameClanClass.setText("Name\r\nClan\r\nClass\r\nLevel");
		txtpnNameClanClass.setEditable(false);
		txtpnNameClanClass.setBounds(12, 40, 69, 86);
		panel.add(txtpnNameClanClass);
		
		txtpnNameClanClass_1 = new JTextPane();
		txtpnNameClanClass_1.setText(player.getName() + "\n" + player.getClan() + "\n" + player.getPlayerClass() +
				"\n" + player.getLevel());
		txtpnNameClanClass_1.setEditable(false);
		txtpnNameClanClass_1.setBounds(96, 40, 90, 86);
		panel.add(txtpnNameClanClass_1);
		
		JTextPane txtpnStrConDex = new JTextPane();
		txtpnStrConDex.setText("STR\r\nCON\r\nDEX\r\nINT\r\nWIS\r\nCHA");
		txtpnStrConDex.setEditable(false);
		txtpnStrConDex.setBounds(12, 152, 63, 126);
		panel.add(txtpnStrConDex);
		
		JTextPane txtpnStrConDex_1 = new JTextPane();
		txtpnStrConDex_1.setText(stat[0] + "\n" + stat[1] + "\n" + stat[2] + "\n" + stat[3] + "\n" + stat[4] + "\n" +
		stat[5]);
		txtpnStrConDex_1.setEditable(false);
		txtpnStrConDex_1.setBounds(96, 152, 63, 126);
		panel.add(txtpnStrConDex_1);
		
		JLabel lblValue_1 = new JLabel("Value");
		lblValue_1.setBounds(96, 127, 69, 20);
		panel.add(lblValue_1);
		
		JLabel lblStat = new JLabel("Stat");
		lblStat.setBounds(12, 127, 69, 20);
		panel.add(lblStat);
		
		frame.getContentPane().add(panel);
		
		JLabel lblEquipment = new JLabel("Equipment");
		lblEquipment.setBounds(226, 16, 91, 20);
		frame.getContentPane().add(lblEquipment);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(223, 40, 140, 187);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblWeapon = new JLabel("Weapon");
		lblWeapon.setBounds(12, 12, 55, 16);
		panel_1.add(lblWeapon);
		
		JLabel lblShield = new JLabel("Shield");
		lblShield.setBounds(12, 55, 55, 16);
		panel_1.add(lblShield);
		
		JLabel lblHelm = new JLabel("Helm");
		lblHelm.setBounds(12, 97, 55, 16);
		panel_1.add(lblHelm);
		
		JLabel lblBodyArmor = new JLabel("Body Armor");
		lblBodyArmor.setBounds(12, 140, 77, 16);
		panel_1.add(lblBodyArmor);
		
		lblWeapon_1 = new JLabel(weapon.getName());
		lblWeapon_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblWeapon_1.setBounds(12, 29, 116, 16);
		panel_1.add(lblWeapon_1);
		
		lblShield_1 = new JLabel(shield.getName());
		lblShield_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblShield_1.setBounds(12, 71, 116, 16);
		panel_1.add(lblShield_1);
		
		lblHelm_1 = new JLabel(helm.getName());
		lblHelm_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblHelm_1.setBounds(12, 112, 116, 16);
		panel_1.add(lblHelm_1);
		
		lblBodyArmor_1 = new JLabel(bodyArmor.getName());
		lblBodyArmor_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblBodyArmor_1.setBounds(12, 159, 116, 16);
		panel_1.add(lblBodyArmor_1);
		
		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new Menu2();
			}
		});
		btnHome.setBounds(448, 399, 115, 29);
		frame.getContentPane().add(btnHome);
		
		JLabel lblPlotDevelopment = new JLabel("Plot Development");
		lblPlotDevelopment.setBounds(229, 232, 140, 20);
		frame.getContentPane().add(lblPlotDevelopment);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(223, 253, 140, 149);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		chckbxPrologue = new JCheckBox("");
		chckbxPrologue.setBounds(8, 6, 21, 24);
		chckbxPrologue.setBackground(Color.WHITE);
		chckbxPrologue.setEnabled(false);
		panel_2.add(chckbxPrologue);
		
		chckbxAct = new JCheckBox("");
		chckbxAct.setBounds(8, 34, 21, 24);
		chckbxAct.setBackground(Color.WHITE);
		chckbxAct.setEnabled(false);
		chckbxAct.setVisible(false);
		panel_2.add(chckbxAct);
		
		chckbxAct_1 = new JCheckBox("");
		chckbxAct_1.setBounds(8, 62, 21, 24);
		chckbxAct_1.setBackground(Color.WHITE);
		chckbxAct_1.setEnabled(false);
		chckbxAct_1.setVisible(false);
		panel_2.add(chckbxAct_1);
		
		chckbxAct_2 = new JCheckBox("");
		chckbxAct_2.setBounds(8, 90, 21, 24);
		chckbxAct_2.setBackground(Color.WHITE);
		chckbxAct_2.setEnabled(false);
		chckbxAct_2.setVisible(false);
		panel_2.add(chckbxAct_2);
		
		chckbxFinalAct = new JCheckBox("");
		chckbxFinalAct.setBounds(8, 117, 21, 24);
		chckbxFinalAct.setEnabled(false);
		chckbxFinalAct.setBackground(Color.WHITE);
		chckbxFinalAct.setVisible(false);
		panel_2.add(chckbxFinalAct);
		
		lblPrologue = new JLabel("Prologue");
		lblPrologue.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblPrologue.setBounds(32, 6, 75, 24);
		panel_2.add(lblPrologue);
		
		lblAct = new JLabel("Act 1");
		lblAct.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblAct.setBounds(32, 34, 75, 24);
		lblAct.setVisible(false);
		panel_2.add(lblAct);
		
		lblAct_1 = new JLabel("Act 2");
		lblAct_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblAct_1.setBounds(32, 62, 75, 24);
		lblAct_1.setVisible(false);
		panel_2.add(lblAct_1);
		
		lblAct_2 = new JLabel("Act 3");
		lblAct_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblAct_2.setBounds(32, 90, 75, 24);
		lblAct_2.setVisible(false);
		panel_2.add(lblAct_2);
		
		lblFinalAct = new JLabel("Final Act");
		lblFinalAct.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblFinalAct.setBounds(32, 117, 75, 24);
		lblFinalAct.setVisible(false);
		panel_2.add(lblFinalAct);
		
		progressBar = new JProgressBar();
		progressBar.setForeground(new Color(144, 238, 144));
		progressBar.setBackground(Color.LIGHT_GRAY);
		progressBar.setBounds(15, 414, 421, 14);
		progressBar.setValue(0);
		frame.getContentPane().add(progressBar);
		
		progressBar_1 = new JProgressBar();
		progressBar_1.setForeground(new Color(144, 238, 144));
		progressBar_1.setBackground(Color.LIGHT_GRAY);
		progressBar_1.setBounds(15, 318, 196, 14);
		frame.getContentPane().add(progressBar_1);
		
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(375, 40, 193, 303);
		frame.getContentPane().add(panel_1_1);
		
		JLabel lblItem = new JLabel("Item\r\n");
		lblItem.setBounds(12, 12, 45, 16);
		panel_1_1.add(lblItem);
		
		JLabel lblQty = new JLabel("Qty");
		lblQty.setBounds(121, 12, 55, 16);
		panel_1_1.add(lblQty);
		
		lblGold = new JLabel("Gold");
		lblGold.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblGold.setBounds(12, 40, 97, 16);
		panel_1_1.add(lblGold);
		
		lblGold_1 = new JLabel();
		lblGold_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblGold_1.setBounds(121, 40, 55, 16);
		lblGold_1.setText(gold.toString());
		panel_1_1.add(lblGold_1);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(12, 57, 97, 234);
		panel_1_1.add(textArea);
		
		textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setBounds(121, 57, 60, 234);
		panel_1_1.add(textArea_1);
		
		JLabel lblInventory = new JLabel("Inventory");
		lblInventory.setBounds(375, 18, 55, 16);
		frame.getContentPane().add(lblInventory);
		
		JLabel lblEncumbrance = new JLabel("Encumbrance");
		lblEncumbrance.setBounds(375, 355, 91, 16);
		frame.getContentPane().add(lblEncumbrance);
		
		progressBar_2 = new JProgressBar();
		progressBar_2.setForeground(new Color(144, 238, 144));
		progressBar_2.setBackground(Color.LIGHT_GRAY);
		progressBar_2.setBounds(375, 374, 188, 14);
		frame.getContentPane().add(progressBar_2);
		
		lblNewLabel = new JLabel();
		lblNewLabel.setBounds(15, 386, 190, 16);
		frame.getContentPane().add(lblNewLabel);
		
		go();
		playerDev();
		encumbrance();
		plotDev();
	}
	
	private void progress(){
		int i = progressBar.getValue();
		progressBar.setValue(i + 2);
		progressBar.revalidate();
	}
	
	private void go(){
		Thread progress = new Thread(new Runnable() {
			public void run() {
				try{
					while(stopFlag != 1){
						lblNewLabel.setText("Executing a creature...");
						lblNewLabel.revalidate();
						if(progressBar.getValue() >= 100){
							hunting();
							updateInventory();
							Thread.sleep(100);
							progressBar.setValue(0);
							synchronized(objPlayerDev){
								objPlayerDev.notifyAll();
							}
						}
						if(progressBar_2.getValue() >= 100){
							lblNewLabel.setText("Heading to market to sell loots...");
							lblNewLabel.revalidate();
							progressBar.setValue(0);
							progressBar.revalidate();
							while(progressBar.getValue() < 100) {
								progress();
								Thread.sleep(100);
							}
							synchronized(objOtw){
								objOtw.notify();
							}
							progressBar.setValue(0);
							progressBar.revalidate();
							synchronized(objSell){
								objSell.wait();
							}
						}
						progress();
						Thread.sleep(100);
					}
				} catch (InterruptedException e){
					
				}
				progressBar.setValue(0);
				progressBar.revalidate();
			}
		});
		progress.start();
	}
	
	private void development(int lvlInc) {
		int i = progressBar_1.getValue();
		progressBar_1.setValue(i + lvlInc);
		progressBar_1.revalidate();
	}
	
	private void playerDev(){
		Thread playerDev = new Thread(new Runnable() {
			public void run() {
				int lvlInc = 5;
				try {
					while(stopFlag != 1){
						synchronized(objPlayerDev){
							objPlayerDev.wait();
						}
						development(lvlInc);
						if(progressBar_1.getValue() >= 100){
							Thread.sleep(100);
							player.setLevel(player.getLevel() + 1);
							txtpnNameClanClass_1.setText(player.getName() + "\n" + player.getClan() + "\n" + player.getPlayerClass() +
									"\n" + player.getLevel());
							txtpnNameClanClass_1.revalidate();
							progressBar_1.setValue(0);
							if(lvlInc != 1) lvlInc -= 1;
						}
					}
				} catch (InterruptedException e) {
					
				}
				progressBar_1.setValue(0);
				progressBar_1.revalidate();
			}
		});
		playerDev.start();
	}
	
	private void encumbrance(){
		Thread encum = new Thread(new Runnable() {
			public void run() {
				while(stopFlag != 1){
					try {
						synchronized(objPlayerDev){
							objPlayerDev.wait();
						}
						int i = progressBar_2.getValue();
						progressBar_2.setValue(i + 10);
						progressBar_2.revalidate();
						if(progressBar_2.getValue() >= 100){
							Thread.sleep(2000);
							synchronized(objOtw){
								objOtw.wait();
							}
							sell();
							synchronized(objSell){
								objSell.wait();
							}
						}
					} catch (InterruptedException e) {
						
					}
				}
				progressBar_2.setValue(0);
				progressBar_2.revalidate();
			}
		});
		encum.start();
	}
	
	private void sell(){
		Thread sell = new Thread(new Runnable() {
			int i = vecInventory.size() - 1;
			public void run() {
				Inventory temp;
				int x = 100 / vecInventory.size();
				lblNewLabel.setText("Selling loots...");
				lblNewLabel.revalidate();
				while(!vecInventory.isEmpty()){
					temp = (Inventory) vecInventory.get(i);
					try{
						vecInventory.remove(i);
						updateInventory();
						int j = progressBar_2.getValue();
						if(vecInventory.size() == 1) {
							progressBar_2.setValue(0);
							progressBar_2.revalidate();
						}
						else{
							progressBar_2.setValue(j - x);
							progressBar_2.revalidate();
						}
						gold(temp.getPrice() * temp.getQty());
						Thread.sleep(500);
						i--;
					}catch (InterruptedException e) {
						
					}
				}
				textArea.setText("");
				textArea_1.setText("");
				textArea.revalidate();
				textArea.revalidate();
				lblNewLabel.setText("Buying Equipment...");
				lblNewLabel.revalidate();
				try {
					Thread.sleep(1000);
					buy();
					Thread.sleep(2000);
				} catch (InterruptedException e) {

				}
				synchronized(objSell){
					objSell.notifyAll();
				}
				
			}
		});
		sell.start();
	}
	
	private void gold(int angka){
		gold += angka;
		lblGold_1.setText(gold.toString());
		lblGold_1.revalidate();
	}
	
	private void hunting(){
		String item = "Item " + (rand.nextInt(30) + 1);
		Inventory inv = new Inventory(item);
		for(int i = 0; i < vecInventory.size(); i++){
			if(item.equals(vecInventory.get(i).getName())){
				Inventory temp = (Inventory) vecInventory.get(i);
				temp.setQty(temp.getQty() + inv.getQty());
				return;
			}
		}
		vecInventory.add(inv);
	}
	
	private void updateInventory(){
		String dataItem = "", dataQty = "";
		for(int i = 0; i < vecInventory.size(); i++){
			Inventory temp = (Inventory) vecInventory.get(i);
			dataItem = dataItem + "\n" + temp.getName();
			dataQty = dataQty + "\n" + temp.getQty();
		}
		textArea.setText(dataItem);
		textArea_1.setText(dataQty);
		textArea.revalidate();
		textArea_1.revalidate();
	}
	
	private void buy(){
		if(!equipMart.isEmpty()){
			int idx = 0;
			do{
				idx = rand.nextInt(equipMart.size());
			} while(equipMart.get(idx).getPrice() > gold);
			
			Equipment temp = (Equipment) equipMart.get(idx);
			gold -= temp.getPrice();
			lblGold_1.setText(gold.toString());
			lblGold_1.revalidate();
			equipMart.remove(idx);
			if(temp.getEquipType() == "Weapon") {
				weapon.setName(temp.getName());
				lblWeapon_1.setText(weapon.getName());
				lblWeapon_1.revalidate();
			}
			else if(temp.getEquipType() == "Shield") {
				shield.setName(temp.getName());
				lblShield_1.setText(shield.getName());
				lblShield_1.revalidate();
			}
			else if(temp.getEquipType() == "Helm") {
				helm.setName(temp.getName());
				lblHelm_1.setText(helm.getName());
				lblHelm_1.revalidate();
			}
			else if(temp.getEquipType() == "Body Armor") {
				bodyArmor.setName(temp.getName());
				lblBodyArmor_1.setText(bodyArmor.getName());
				lblBodyArmor_1.revalidate();
			}
		
		}
	}

	private void plotDev(){
		Thread plot = new Thread(new Runnable() {
			
			public void run() {
				try {
					Thread.sleep(60000);
					prologueEnd();
					
					Thread.sleep(600000);
					act1End();
					
					Thread.sleep(1200000);
					act2End();
					
					Thread.sleep(1500000);
					act3End();
					
					Thread.sleep(600000);
					finalActEnd();
					
					stopFlag = 1;
				} catch (InterruptedException e) {
				
				}
				
			}

		});
		
		plot.start();
	}
	
	private void finalActEnd() {
		chckbxFinalAct.setSelected(true);
		lblFinalAct.setEnabled(false);
		chckbxFinalAct.revalidate();
		lblFinalAct.revalidate();
		
	}

	private void act3End() {
		chckbxAct_2.setSelected(true);
		lblAct_2.setEnabled(false);
		chckbxFinalAct.setVisible(true);
		lblFinalAct.setVisible(true);
		chckbxAct_2.revalidate();
		lblAct_2.revalidate();
		chckbxFinalAct.revalidate();
		lblFinalAct.revalidate();
	}

	private void act2End() {
		chckbxAct_1.setSelected(true);
		lblAct_1.setEnabled(false);
		chckbxAct_2.setVisible(true);
		lblAct_2.setVisible(true);
		chckbxAct_1.revalidate();
		lblAct_1.revalidate();
		chckbxAct_2.revalidate();
		lblAct_2.revalidate();
	}

	private void act1End() {
		chckbxAct.setSelected(true);
		lblAct.setEnabled(false);
		chckbxAct_1.setVisible(true);
		lblAct_1.setVisible(true);
		chckbxAct.revalidate();
		lblAct.revalidate();
		chckbxAct_1.revalidate();
		lblAct_1.revalidate();
	}
	
	private void prologueEnd(){
		chckbxPrologue.setSelected(true);
		lblPrologue.setEnabled(false);
		chckbxAct.setVisible(true);
		lblAct.setVisible(true);
		chckbxPrologue.revalidate();
		lblPrologue.revalidate();
		chckbxAct.revalidate();
		lblAct.revalidate();
	}
}
