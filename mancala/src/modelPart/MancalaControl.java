package modelPart;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MancalaControl extends JFrame  {
	Model data;
	public MancalaControl()
	{
		JPanel contentPanel = new JPanel();
		
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Select number of Stones!");
		Font font = new Font("Arial", 32, 34);
		label.setFont(font);
		final JButton stone3 = new JButton("3");
		stone3.setBounds(58, 122, 97, 43);
		
		final JButton stone4 = new JButton("4");
		stone3.setPreferredSize(new Dimension(40, 20));
		stone4.setPreferredSize(new Dimension(40, 20));
		stone3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				data.stones = (Integer.valueOf(stone3.getText()));
				// option of board design can go here
				dispose();
			}	
		});
		
		stone4.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				data.stones = (Integer.valueOf(stone4.getText()));
				// option of board design can go here
				dispose();
			}
		});
		
		setLayout(new BorderLayout());
		panel.setLayout(new GridLayout(0, 2));
		
		panel.add(stone3);//, BorderLayout.WEST);
		panel.add(stone4);//, BorderLayout.EAST);
		
		add(label, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
		setSize(500,300);
		setLocation(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
