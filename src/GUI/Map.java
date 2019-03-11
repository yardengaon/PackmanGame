package GUI;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 * This class is responsible for create a map
 */
public class Map extends JFrame {

	//Variable statements
	private static final long serialVersionUID = 1L;
	private BufferedImage myImage1;
	private static Map obj2 = null;

	/**
	 * Contractor Map singeltone
	 * @return Map an a singeltone map 
	 */
	public static Map getInstance() {
		if(obj2 == null)
			obj2 = new Map();
		return obj2;
	}

	private Map() {
		try {
			initGUI();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	/**
	 * create a main picture in GUI
	 */
	private void initGUI() throws IOException {
		myImage1 = ImageIO.read(new File("Ariel1.png"));

		try {
			myImage1 = ImageIO.read(new File("Ariel1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * create a main picture in GUI
	 * @return the main picture in GUI 
	 */
	public BufferedImage getImage() {
		return myImage1;
	}


}
