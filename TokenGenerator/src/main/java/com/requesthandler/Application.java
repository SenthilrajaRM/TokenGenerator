package com.requesthandler;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Application {
	
	public static void main(String[] args)
	{
		JFrame f = new JFrame("Apple Radar Token Generator");
		JPanel frame = new JPanel();
		frame.setLayout(new BoxLayout(frame, BoxLayout.Y_AXIS));
		JPanel group = new JPanel();
		JLabel lab = new JLabel("Token Generator");
		Font font = new Font("Times New Roman",Font.BOLD,18);
		lab.setFont(font);
		group.add(lab);
		frame.add(group);
		JPanel group1 = new JPanel();
		JLabel label = new JLabel("Environment:");
		group1.add(label);
		String options[] = {"--Select--","PROD",  "UAT"};
		final JComboBox<String> env = new JComboBox<String>(options);
		group1.add(env);
		frame.add(group1);
		
		JPanel group2 = new JPanel();
		JLabel label1 = new JLabel("URL:");
		group2.add(label1);
		String options1[] = {"--Select","https://radar-webservices-alt.apple.com","https://radar-uat2.apple.com"};
		final JComboBox<String> env1 = new JComboBox<String>(options1);
		group2.add(env1);
		frame.add(group2);
		
		
		JPanel group7 = new JPanel();
		JLabel label7 = new JLabel("TOKEN TYPE:");
		group2.add(label7);
		String options7[] = {"--Select","WebToken"};
		final JComboBox<String> env7 = new JComboBox<String>(options7);
		group2.add(env7);
		frame.add(group7);
		
		JPanel group3 = new JPanel();
		JLabel label2 = new JLabel("Apple Connect Name:");
		group3.add(label2);
		final JTextField user = new JTextField(10);
		group3.add(user);
		frame.add(group3);
		
		JPanel group4 = new JPanel();
		JLabel label3 = new JLabel("Apple Connect Password:");
		group4.add(label3);
		final JPasswordField pass = new JPasswordField(10);
		group4.add(pass);
		frame.add(group4);

		JButton button = new JButton("Send");
		JPanel group6 = new JPanel();
		JLabel label5 = new JLabel("Access Token:");
		final JTextField accessToken = new JTextField(50);
		group6.add(label5);
		group6.add(accessToken);
		frame.add(button);
		frame.add(group6);
		frame.add(group7);
		frame.add(new JLabel(" "));
		f.add(frame);
		f.setSize(new Dimension(720, 480));
		f.setResizable(false);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println((String) env.getSelectedItem());
				String envir = (String) env.getSelectedItem();
				String urlValue = (String) env1.getSelectedItem();
				String tokentype = (String) env7.getSelectedItem();
				String userValue = user.getText();
				String passValue = pass.getText();
				
				Handler h = new Handler(urlValue, envir, tokentype, userValue, passValue,0);
				accessToken.setText(h.getResponse());
			
			}
			
		});
	}

}
