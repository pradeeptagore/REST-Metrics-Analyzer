package com.rmat.app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JButton;

import com.rmat.restclient.RestClient;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ApplicationWindow {

	private JFrame frame;
	private JTextField textField;
	private JTextPane textPane;
	private JComboBox<String> comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationWindow window = new ApplicationWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ApplicationWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Url :");
		lblNewLabel.setBounds(12, 14, 48, 15);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(54, 10, 240, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		comboBox = new JComboBox<String>();
		comboBox.addItem("GET");
		comboBox.addItem("POST");
		comboBox.addItem("PUT");
		comboBox.addItem("DELETE");
		comboBox.setBounds(302, 9, 59, 24);
		frame.getContentPane().add(comboBox);
		
		textPane = new JTextPane();
		textPane.setBounds(12, 46, 426, 213);
		frame.getContentPane().add(textPane);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textPane.setText(new RestClient().getRestResponse(textField.getText(),comboBox.getSelectedItem().toString()));
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 8));
		btnNewButton.setBounds(373, 9, 54, 25);
		frame.getContentPane().add(btnNewButton);
		
	}
}
