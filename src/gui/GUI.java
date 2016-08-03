package gui;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import implication.Implication;
import java.awt.Image;
import java.awt.Toolkit;

public class GUI extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 14414932636266107L;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JTextField word1, word2;
	private JButton submit;
	
	
	public GUI(){
		
		
		
		textArea = new JTextArea();
		scrollPane = new JScrollPane(textArea);
		textArea.setFont(new Font("Serif",Font.PLAIN,20));
		textArea.setEditable(false);
		
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		word1 = new JTextField();
		word1.setFont(new Font("Serif",Font.PLAIN,20));
		
		word2 = new JTextField();
		word2.setFont(new Font("Serif",Font.PLAIN,20));
		
		submit = new JButton("Submit");
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		JMenuItem openSave = new JMenuItem("Import from and export to files");
		
		menu.add(openSave);
		menuBar.add(menu);
		
//		word1.getInputContext().selectInputMethod(new Locale("ar_JO"));
//		word2.getInputContext().selectInputMethod(new Locale("ar_JO"));
//		textArea.getInputContext().selectInputMethod(new Locale("ar_JO"));
//		word1.getInputContext().selectInputMethod(new Locale("ar"));
//		word2.getInputContext().selectInputMethod(new Locale("ar_JO"));
//		textArea.getInputContext().selectInputMethod(new Locale("ar_JO"));
		word1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		word2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
//		textArea.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
//		scrollPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		
		JPanel buttons = new JPanel();
		
		buttons.setLayout(new GridLayout(2, 3, 5, 5));
		buttons.add(new JLabel("Word One"));
		buttons.add(new JLabel("Word Two"));
		buttons.add(new JLabel(""));
		buttons.add(word1);
		buttons.add(word2);
		buttons.add(submit);
		buttons.setBorder(new TitledBorder("Input"));
		
		
		JPanel output = new JPanel();
		
		output.setLayout(new BorderLayout());
		
		output.setBorder(new TitledBorder("Results"));
		output.add(scrollPane, BorderLayout.CENTER);
		
		
		setLayout(new BorderLayout());
		add(output, BorderLayout.CENTER);
		add(buttons, BorderLayout.SOUTH);
		//add(menu, BorderLayout.NORTH);
		this.setJMenuBar(menuBar);
		
		submit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Implication i = new Implication(word1.getText(), word2.getText());
				textArea.append("\n");
				textArea.append(i.toString());
				textArea.append("\n" + i.getImplicationDistance());
				//textArea.append("\n" + Arrays.deepToString(i.getDistanceTable()) + "\n");
				
			}
			
		});
		
		openSave.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File("./assets"));
				fileChooser.showOpenDialog(null);
				File inputFile = fileChooser.getSelectedFile();
				try {
					FileInputStream inputStream = new FileInputStream(inputFile);
					InputStreamReader inputReader = new InputStreamReader(inputStream, "utf-8");
					BufferedReader in = new BufferedReader(inputReader);
					
					fileChooser.showSaveDialog(null);
					File outputFile = fileChooser.getSelectedFile();
					FileOutputStream outputStream = new FileOutputStream(outputFile);
					OutputStreamWriter outputReader = new OutputStreamWriter(outputStream, "utf-8");
					BufferedWriter out = new BufferedWriter(outputReader);
					
					String[] words;
					int count = 1;
					
					String temp;
					while ((temp = in.readLine()) != null){
						System.out.println("Line: " + count++);
						words = temp.split("\t"); 
						if(words.length == 2){
							Implication j = new Implication(words[0], words[1]);
							out.append(temp);
							out.append("\t");
							out.append(j.getImplicationDistance());
							out.append("\n");
						} else if(words.length == 3){
							Implication j = new Implication(words[1], words[2]);
							out.append(temp);
							out.append("\t");
							out.append(j.getImplicationDistance());
							out.append("\n");
						} else if(words.length == 5){
							Implication j = new Implication(words[1], words[4]);
							out.append(temp);
							out.append("\t");
							out.append(j.getImplicationDistance());
							out.append("\n");
						} else {
							Implication j = new Implication(words[1], words[2]);
							out.append(temp);
							out.append("\t");
							out.append(j.getImplicationDistance());
							out.append("\n");
						}
					}
					in.close();
					out.close();
					System.out.println("Write to file complete");
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		
                        try {
                Toolkit kit = Toolkit.getDefaultToolkit();
                Image img = kit.createImage("./tree.png");
                setIconImage(img);
            } catch (Exception e){
                e.printStackTrace();
            }
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		
	}
	
	
	
	

}
