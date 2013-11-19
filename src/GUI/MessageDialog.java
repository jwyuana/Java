package GUI;

import javax.swing.JOptionPane;

public class MessageDialog {

	public static void main(String[] args){
		JOptionPane.showMessageDialog(null, "Hello");
		
		JOptionPane.showMessageDialog(null, "Hi!", "From world", JOptionPane.INFORMATION_MESSAGE);
	}
}
