package com.cubjava.lightbulb;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Icon;
import java.awt.GridLayout;

public class LightBulb extends JFrame
{

	private JPanel	contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try
				{
					LightBulb frame = new LightBulb();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LightBulb()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(0, 6));
		
		//JPanel panel = new JPanel();
		contentPane.setBackground(Color.WHITE);
		
		boolean[] initBulbs = {false, false, false, false, false, false, false, false, false, false, false, false,false, false, false, false, false, false,false, false, false, false, false, false};
		prepareContentPane(initBulbs);
		setContentPane(contentPane);

		//contentPane.add(panel, BorderLayout.CENTER);
	}

	protected ImageIcon createImageIcon(String path)
	{
		String imgURL = LightBulb.class.getResource(path).getFile();
		if (imgURL != null)
		{
			ImageIcon icon = new ImageIcon(imgURL);
			Image image = icon.getImage(); // transform it 
			Image newimg = image.getScaledInstance(32, 32,  java.awt.Image.SCALE_SMOOTH); // scale it 
			icon = new ImageIcon(newimg);  // transform it back
			return icon;
		}
		else
		{
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
	
	private void prepareContentPane(boolean[] bulbs)
	{
		ImageIcon red = createImageIcon("/com/cubjava/resources/redbutton.png");
		//JLabel lblRedButton = new JLabel(red);
		
		ImageIcon gray = createImageIcon("/com/cubjava/resources/graybutton.png");
		//JLabel lblGrayButton = new JLabel(gray);
		
		ImageIcon blue = createImageIcon("/com/cubjava/resources/bluebutton.png");
		//JLabel lblBlueButton = new JLabel(blue);
		
		for(boolean bulb : bulbs)
		{
			if(bulb)
			{
				JLabel lblRedButton = new JLabel(red);
				contentPane.add(lblRedButton);
			}
			else
			{
				JLabel lblGrayButton = new JLabel(gray);
				contentPane.add(lblGrayButton);
			}
		}
		
		//contentPane.add(lblRedButton);
		//contentPane.add(lblGrayButton);
		//contentPane.add(lblBlueButton);
	}
}
