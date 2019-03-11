package GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileSystemView;

import Coords.myCoords;
import File_format.CsvToGame;
import File_format.replaceObjects;
import GUI.MainWindow.MyThread;
import GameObjects.Game;
import GameObjects.Ghost;
import GameObjects.Packman;
import GameObjects.Player;
import Geom.Point3D;
import Robot.Play;
import GameObjects.Fruit;

/**
 * This class is responsible on the gui
 */
public class MainWindow extends JFrame implements MouseListener, ActionListener
{
	/**
	 * Variable statements
	 */
	private static final long serialVersionUID = 1L;
	Map obj2 = Map.getInstance();
	public BufferedImage myImage = obj2.getImage();
	public boolean flag = true;
	public boolean flag5 = true;
	public boolean flag10 = true;
	public boolean flag15 = true;
	static JLabel l;
	String s = null;
	BufferedImage image1;
	BufferedImage image2;
	BufferedImage image3;
	BufferedImage image4;
	String paint = "";
	Game g1 = new Game();
	CsvToGame cs = new CsvToGame();
	replaceObjects rp = new replaceObjects();
	String file_name = "data/Ex4_OOP_example8.csv";
	Play play2 = new Play(file_name);
	MyThread thread1 = new MyThread();
	int rotate;

	/**
	 * MainWindow constructor
	 */
	public MainWindow() {
		try {
			initGUI();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		this.addMouseListener(this); 
	}

	/**
	 * create a menu button in GUI
	 */
	private void initGUI() throws IOException 
	{
		image1 = ImageIO.read(new File("Packman.png"));
		image2 = ImageIO.read(new File("Fruit.png"));
		image3 = ImageIO.read(new File("Ghost.png"));
		image4 = ImageIO.read(new File("Player.png"));
	}


	/**
	 * Responsible for drawing the packmans and fruits to the screen 
	 * @param g the graphics
	 */
	public void paint(Graphics g)
	{
		BufferedImage bufferedImage = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = bufferedImage.createGraphics();
		g2d.drawImage(myImage, 0,0, this.getWidth(), this.getHeight(), this);
		int pacSize = g1.pacSize();
		int fruSize = g1.fruSize();
		{
			for(int i=0 ; i<pacSize; i++) {
				double j = (this.getWidth()/1432.0) * g1.getPac(i).getGpsPoint().get_x();
				double k = (this.getHeight()/642.0) * g1.getPac(i).getGpsPoint().get_y();
				g2d.drawImage(image1, (int)j-7, (int)k-7, rootPane);
			}
			for(int i=0 ; i<fruSize; i++) {
				double j = (this.getWidth()/1432.0) * g1.getFru(i).getGpsPoint().get_x();
				double k = (this.getHeight()/642.0) * g1.getFru(i).getGpsPoint().get_y();
				g2d.drawImage(image2, (int)j-7, (int)k-7, rootPane);
			}

			for(int i=0 ; i<g1.GhoSize(); i++) {
				double j = (this.getWidth()/1432.0) * g1.getGho(i).getGpsPoint().get_x();
				double k = (this.getHeight()/642.0) * g1.getGho(i).getGpsPoint().get_y();
				g2d.drawImage(image3, (int)j-7, (int)k-7, rootPane);
			}

			for (int i=0; i<g1.geoSize(); i++) {
				int xU = (int) ((this.getWidth()/1432.0) * g1.getGeo(i).getPointUp().get_x());
				int yU = (int) ((this.getHeight()/642.0) * g1.getGeo(i).getPointUp().get_y());
				int xD = (int) ((this.getWidth()/1432.0) * g1.getGeo(i).getPointDown().get_x());
				int yD = (int) ((this.getHeight()/642.0) * g1.getGeo(i).getPointDown().get_y());
				if(xD<xU && yD<yU) {g2d.fillRect(xD,yD+3,Math.abs(xD-xU)-2,Math.abs(yD-yU)-2);}
				if(xD<xU && yU<yD) {g2d.fillRect(xD,yU+3,Math.abs(xD-xU)-2,Math.abs(yD-yU)-2);}
				if(xU<xD && yU<yD) {g2d.fillRect(xU,yU+3,Math.abs(xD-xU)-2,Math.abs(yD-yU)-2);}
				if(xU<xD && yD<yU) {g2d.fillRect(xU,yD+3,Math.abs(xD-xU)-2,Math.abs(yD-yU)-2);}
			}

			if(Player.getInstance() != null) {
				double j = (this.getWidth()/1432.0) * Player.getInstance().getLocation().get_x();
				double k = (this.getHeight()/642.0) * Player.getInstance().getLocation().get_y();
				g2d.drawImage(image4, (int)j-7, (int)k-7, rootPane);
			}
			//			double j = (this.getWidth()/1432.0) * g1.getpla().getGpsPoint().get_x();
			//			double k = (this.getHeight()/642.0) * g1.getpla().getGpsPoint().get_y();
			//			g2d.drawImage(image4, (int)j-7, (int)k-7, rootPane);

			//			double j = (this.getWidth()/1432.0) * (int) g1.getPac(0).getGpsPoint().get_x();
			//			double k = (this.getHeight()/642.0) * (int) g1.getPac(0).getGpsPoint().get_y();
			//			g2d.drawImage(image1, (int)j-7, (int)k-7, rootPane);
			//
		}

		Graphics2D g2dComponent = (Graphics2D) g;
		g2dComponent.drawImage(bufferedImage, null, 0, 0); 
	}


	@Override
	public void mouseClicked(MouseEvent arg) {
		if((flag15 == false) && (flag10 == true)) {
			thread1.start();
			flag10 = false;
		}

		if((flag10 == true)  && (flag15 == true)) {
			try {
				cs.Csv2Game(g1);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			flag15 = false;
			repaint();
		}
		
		Point3D p123 = (myCoords.getInstance().frameToGps(Player.getInstance().getLocation().get_x(), Player.getInstance().getLocation().get_y()));
		Point3D p12 = (myCoords.getInstance().frameToGps((arg.getX() * (1432.0/this.getWidth())), (arg.getY() * (642.0/this.getHeight()))));
		rotate = myCoords.getInstance().azimuth(p123.get_y(), p123.get_x(), p12.get_y(), p12.get_x()); 

	}

	/**
	 * a class that Responsible for calculating the location of the fruit and the pacmans painting in real time.
	 * and create the kml file.
	 */
	public class MyThread extends Thread{

		/**
		 * thread run method
		 */
		public void run() {
			//mouseClicked(null);
			
			play2.setInitLocation(32.1040,35.2061);
			play2.start();
			ArrayList<String> board_data;
			play2.setInitLocation(32.1040,35.2061);
			// 7) "Play" as long as there are "fruits" and time
			//	for(int i=0;i<10;i++) {
			int i=0;
			while(play2.isRuning()) {
				i++;
				// 7.1) this is the main command to the player (on the server side)
				play2.rotate(rotate); 
				System.out.println("***** "+i+"******");

				// 7.2) get the current score of the game
				String info = play2.getStatistics();
				System.out.println(info);
				// 7.3) get the game-board current state
				board_data = play2.getBoard();
				g1.removeF();
				g1.removeP();
				g1.removeG();
				for(int a=0;a<board_data.size();a++) {
					System.out.println(board_data.get(a));
					try {
						rp.board2Game(g1, board_data.get(a));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				repaint();
				System.out.println();
			}
			// 8) stop the server - not needed in the real implementation.
			//play1.stop();
			System.out.println("**** Done Game (user stop) ****");

			// 9) print the data & save to the course DB
			String info = play2.getStatistics();
			System.out.println(info);
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}


