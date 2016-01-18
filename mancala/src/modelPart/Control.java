package modelPart;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

public class Control extends JFrame{
	private JPanel contentPane;
	Model data;
/////////////////////////////////////////////////////////////
////This Block is to Test the frame
	public static void main(String[] args) {
					Control frame = new Control();
					frame.setVisible(true);
	
	}
//////////////////////////////////////////////////////////////	
	public Control()
	{
		this.data = new Model();
		data.setNumberOfStones(3);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select # of Stones");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(12, 31, 232, 25);
		panel.add(lblNewLabel);
		
		final JRadioButton radioButton3 = new JRadioButton("3");
		radioButton3.setFont((new Font("Tahoma", Font.PLAIN, 24)));
		radioButton3.setBounds(236, 36, 55, 20);
/*		radioButton3.addActionListener(new ActionListener()
			{
			@Override
			public void actionPerformed(ActionEvent e) {
				data.setNumberOfStones(Integer.valueOf(e.getActionCommand()));	
			}
		});
*/		panel.add(radioButton3);
		
		JRadioButton radioButton4 = new JRadioButton("4");
		radioButton4.setFont((new Font("Tahoma", Font.PLAIN, 24)));
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
		rdbtnClassic.setFont((new Font("Tahoma", Font.PLAIN, 24)));
		rdbtnClassic.setBounds(180, 103, 95, 25);
		panel.add(rdbtnClassic);
		
		JRadioButton rdbtnModern = new JRadioButton("Modern");
		rdbtnModern.setFont((new Font("Tahoma", Font.PLAIN, 24)));
		rdbtnModern.setBounds(295, 103, 127, 25);
		panel.add(rdbtnModern);
		
		ButtonGroup viewBtnGroup = new ButtonGroup();
		viewBtnGroup.add(rdbtnClassic);
		viewBtnGroup.add(rdbtnModern);
		
		JButton playBtn = new JButton("Play");
		playBtn.setFont(new Font("Tahoma", Font.PLAIN, 24));
		playBtn.setBounds(151, 173, 97, 43);
		panel.add(playBtn);
		
		playBtn.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) 
					{
						int stones = (radioButton3.isSelected()) ? 3:4;
						data.setNumberOfStones(stones);
						System.out.println(stones);
						dispose();
						JFrame boardFrame = new JFrame();
						JPanel viewPanel = new JPanel();
						// Add view to thePanel and resize frame if needed
						
						boardFrame.setSize(500, 300);
						boardFrame.setLocation(400, 200);
						boardFrame.setResizable(false);
						boardFrame.add(viewPanel);
						boardFrame.setVisible(true);
						boardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					}		
				});	
	}// end constructor

}
