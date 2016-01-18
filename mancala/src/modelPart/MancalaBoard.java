package modelPart;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class MancalaBoard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MancalaBoard frame = new MancalaBoard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MancalaBoard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton playBtn = new JButton("Play");
		playBtn.setFont(new Font("Tahoma", Font.PLAIN, 24));
		playBtn.setBounds(151, 173, 97, 43);
		panel.add(playBtn);
		
		JLabel lblNewLabel = new JLabel("Select # of Stones");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(12, 31, 232, 25);
		panel.add(lblNewLabel);
		
		JRadioButton radioButton3 = new JRadioButton("3");
		radioButton3.setBounds(236, 36, 55, 20);
		panel.add(radioButton3);
		
		JRadioButton radioButton4 = new JRadioButton("4");
		radioButton4.setBounds(295, 36, 127, 25);
		panel.add(radioButton4);
		
		ButtonGroup stoneBtnGroup = new ButtonGroup();
		stoneBtnGroup.add(radioButton3);
		stoneBtnGroup.add(radioButton4);
		
		JLabel lblSelectAView = new JLabel("Select a View");
		lblSelectAView.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblSelectAView.setBounds(12, 103, 232, 25);
		panel.add(lblSelectAView);
		
		JRadioButton rdbtnClassic = new JRadioButton("Classic");
		rdbtnClassic.setBounds(180, 103, 78, 25);
		panel.add(rdbtnClassic);
		
		JRadioButton rdbtnModern = new JRadioButton("Modern");
		rdbtnModern.setBounds(295, 103, 127, 25);
		panel.add(rdbtnModern);
		
		ButtonGroup viewBtnGroup = new ButtonGroup();
		viewBtnGroup.add(rdbtnClassic);
		viewBtnGroup.add(rdbtnModern);
	}
}
