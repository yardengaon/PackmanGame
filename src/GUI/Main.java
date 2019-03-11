package GUI;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Main class 
 */
public class Main {

	/**
	 * Main method 
	 * create mainwindow and open the map
	 */
	public static void main(String[] args) throws IOException
	{
		MainWindow window = new MainWindow();
		window.setVisible(true);
		window.setSize(window.myImage.getWidth(),window.myImage.getHeight());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
