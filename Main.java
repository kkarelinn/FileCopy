import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Main {
	
	Engine en = new Engine(this);
	JFrame frame;
	JPanel MainPanel = new JPanel();
	JPanel InputPanel = new JPanel();
	JPanel OutputPanel = new JPanel();
	JPanel StartPanel = new JPanel();
	
	JLabel from = new JLabel("Copy from: ");
	JLabel to = new JLabel("      Copy to: ");
	
	JTextField pathFrom = new JTextField(30);
	JTextField pathTo = new JTextField(30);
	
	JButton fromButton = new JButton("Browse");
	JButton toButton = new JButton("Browse");
	
	JButton startButton = new JButton("Start!");
	
	Main(){
	MainPanel.setLayout(new BorderLayout());
	InputPanel.setLayout(new FlowLayout());
	OutputPanel.setLayout(new FlowLayout());
	StartPanel.setLayout(new FlowLayout());
	
	MainPanel.add("North",InputPanel);
	MainPanel.add("Center",OutputPanel);
	MainPanel.add("South",StartPanel);
	
	InputPanel.add(from);
	InputPanel.add(pathFrom);
	InputPanel.add(fromButton);
	
	OutputPanel.add(to);
	OutputPanel.add(pathTo);
	OutputPanel.add(toButton);
	
	StartPanel.add(startButton);
	
	fromButton.addActionListener(en);
	toButton.addActionListener(en);
	startButton.addActionListener(en);
	
	frame = new JFrame("File copy window");
	frame.setContentPane(MainPanel);
	frame.pack();

	frame.setVisible(true);
	
	}
//	CalculatorEngine calcEngine = new CalculatorEngine(this);
	
	public static void main(String[] args) {
		new Main();
	}

}
