import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.channels.Pipe.SourceChannel;
import java.nio.file.*;
import java.nio.file.StandardCopyOption;

import javax.swing.*;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import sun.text.normalizer.Replaceable;

public class Engine implements ActionListener{

	Main parent;
	String source = null;
	String destination = null;
	SourceChannel sourceChannel, destChannel;
	
	
	
	

	InputStream in;
	
	OutputStream out;
	
	Engine(Main main){
		this.parent = main;
	}

	public void actionPerformed(ActionEvent e) {
		
		JButton clickedButton = (JButton) e.getSource();
		
		if (clickedButton == parent.fromButton){
			
			JFileChooser fileChooser = new JFileChooser();
		
			fileChooser.setDialogTitle("����� �����");
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			int result = fileChooser.showOpenDialog(parent.frame);
			if (result == JFileChooser.APPROVE_OPTION )
				source  = fileChooser.getSelectedFile().toString();
			parent.pathFrom.setText(source);
						
		
			} else if (clickedButton == parent.toButton){
							
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("����� ����������");
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int result = fileChooser.showSaveDialog(parent.frame);
				if (result == JFileChooser.APPROVE_OPTION )
				parent.pathTo.setText(fileChooser.getSelectedFile().toString());
				
		
			}else if (clickedButton == parent.startButton){
				if(!parent.pathTo.getText().equals(""))
					
				destination = parent.pathTo.getText();
				if (source!=null && destination!=null) {
					
					
				/*
				 * ��� ������� �����	
					FileChannel sourceChannel = null;
					FileChannel destChannel = null;
					try {
						sourceChannel = new FileInputStream(source).getChannel();
						destChannel = new FileOutputStream(destination).getChannel();
						destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
						sourceChannel.close();
						destChannel.close();
						JOptionPane.showMessageDialog(parent.frame,"��� �������������");
						
					} catch (Exception e1) {
						
						e1.printStackTrace();
							}
				*/
					
					
					/*
					 * ��� ���� ������� �����	
					File sourceFile = new File(source);
					File destinationFile = new File(destination);
					try {
						FileUtils.copyFile(sourceFile, destinationFile);
						JOptionPane.showMessageDialog(parent.frame,"��� �������������");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					*/
					
					
					Path sourPath = new File(source).toPath();
					Path destPath = new File(destination).toPath();
					CopyOption[] co =  new CopyOption[] {StandardCopyOption.REPLACE_EXISTING};
			      
					try {
						Files.copy(sourPath,destPath, co);
						JOptionPane.showMessageDialog(parent.frame,"��� �������������");
						
					
					} catch (IOException e1) {
						
						JOptionPane.showMessageDialog(parent.frame,"��� �� �� ���");
					}
					
			    				
				
		
			}
		
	}
	
	}

}
