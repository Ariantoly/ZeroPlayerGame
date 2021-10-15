import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu1 {

	private JFrame frame;

	public Menu1() {
		firstMenu();
	}
	
	private void firstMenu(){
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
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JLabel lblZeroPlayerGame = new JLabel("PROGRESS HUNTER");
		lblZeroPlayerGame.setFont(new Font("Tahoma", Font.PLAIN, 60));
		lblZeroPlayerGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblZeroPlayerGame.setBounds(0, 70, 578, 97);
		frame.getContentPane().add(lblZeroPlayerGame);
		
		JButton btnPlay = new JButton("PLAY");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Menu2();
			}
		});
		btnPlay.setForeground(Color.BLUE);
		btnPlay.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPlay.setBounds(227, 252, 124, 43);
		frame.getContentPane().add(btnPlay);
	}

}
