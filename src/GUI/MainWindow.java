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

import Algorithem.algorithem;
import Coords.myCoords;
import File_format.CsvToGame;
import File_format.replaceObjects;
import GUI.MainWindow.MyThread;
import GameObjects.Game;
import GameObjects.Ghost;
import GameObjects.Packman;
import GameObjects.Player;
import Geom.Point3D;
//import Geom.ShortestPathAlgo;
import Robot.Play;
import graph.Graph;
import graph.Graph_Algo;
import graph.Node;
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
	String file_name = "";
	Play play2;
	MyThread thread1 = new MyThread();
	MyThreadAlgorithem thread2 = new MyThreadAlgorithem();
	int rotate = 1;
	boolean flag55 = true;
	int frSize;
	double max = 100000000.0;
	Color c = new Color(0);

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
		MenuBar menuBar = new MenuBar();
		Menu menu = new Menu("Menu"); 
		MenuItem item1 = new MenuItem("run Algorithem");
		MenuItem item2 = new MenuItem("run with mouse");
		MenuItem item4 = new MenuItem("files/Load game");
		image1 = ImageIO.read(new File("Packman.png"));
		image2 = ImageIO.read(new File("Fruit.png"));
		image3 = ImageIO.read(new File("Ghost.png"));
		image4 = ImageIO.read(new File("Player.png"));
		menuBar.add(menu);
		menu.add(item1);
		menu.add(item2);
		menu.add(item4);
		this.setMenuBar(menuBar);

		/**
		 * create (add run Algorithem) button
		 */
		item1.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				thread2.start();
				repaint();
			}
		});

		/**
		 * create (add run with mouse) button
		 */
		item2.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				thread1.start();
				repaint();		
			}
		});

		/**
		 * create (files) button
		 */
		item4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) { 

				JPanel p = new JPanel(); 

				l = new JLabel("no file selected"); 

				// add panel to the frame 
				p.add(l); 

				// if the user presses the save button show the save dialog 
				String com = e.getActionCommand(); 

				if (com.equals("save")) { 
					// create an object of JFileChooser class 
					JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 

					// invoke the showsSaveDialog function to show the save dialog 
					int r = j.showSaveDialog(null); 

					// if the user selects a file 
					if (r == JFileChooser.APPROVE_OPTION) 

					{ 
						// set the label to the path of the selected file 
						l.setText(j.getSelectedFile().getAbsolutePath()); 
					} 
					// if the user cancelled the operation 
					else
						l.setText("the user cancelled the operation"); 
				} 

				// if the user presses the open dialog show the open dialog 
				else { 
					// create an object of JFileChooser class 
					JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 

					// invoke the showsOpenDialog function to show the save dialog 
					int r = j.showOpenDialog(null); 

					// if the user selects a file 
					if (r == JFileChooser.APPROVE_OPTION) 

					{ 
						// set the label to the path of the selected file 
						l.setText(j.getSelectedFile().getAbsolutePath()); 
						s = (j.getSelectedFile().getAbsolutePath()); 
					} 
					// if the user cancelled the operation 
					else
						l.setText("the user cancelled the operation"); 
				} 

				if(s != null) {
					CsvToGame cs = new CsvToGame();
					file_name = s;
					play2 = new Play(file_name);
					try {
						cs.Csv2Game(g1, s);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					flag = false;
					repaint();
					flag = true;
					repaint();
				}

			}
		});	
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
		g2d.setColor(c);
		for(int i=0 ; i<pacSize; i++) {
			double j = (this.getWidth()/1432.0) * g1.getPac(i).getGpsPoint().get_x();
			double k = (this.getHeight()/642.0) * g1.getPac(i).getGpsPoint().get_y();
			g2d.drawImage(image1, (int)j, (int)k, rootPane);
		}
		for(int i=0 ; i<fruSize; i++) {
			double j = (this.getWidth()/1432.0) * g1.getFru(i).getGpsPoint().get_x();
			double k = (this.getHeight()/642.0) * g1.getFru(i).getGpsPoint().get_y();
			g2d.drawImage(image2, (int)j, (int)k, rootPane);
		}
		for(int i=0 ; i<g1.GhoSize(); i++) {
			double j = (this.getWidth()/1432.0) * g1.getGho(i).getGpsPoint().get_x();
			double k = (this.getHeight()/642.0) * g1.getGho(i).getGpsPoint().get_y();
			g2d.drawImage(image3, (int)j, (int)k, rootPane);
		}
		for (int i=0; i<g1.geoSize(); i++) {
			int xU = (int) ((this.getWidth()/1432.0) * g1.getGeo(i).getPointUp().get_x());
			int yU = (int) ((this.getHeight()/642.0) * g1.getGeo(i).getPointUp().get_y());
			int xD = (int) ((this.getWidth()/1432.0) * g1.getGeo(i).getPointDown().get_x());
			int yD = (int) ((this.getHeight()/642.0) * g1.getGeo(i).getPointDown().get_y());
			if(xD<xU && yD<yU) {g2d.fillRect(xD,yD,Math.abs(xD-xU),Math.abs(yD-yU));}
			if(xD<xU && yU<yD) {g2d.fillRect(xD,yU,Math.abs(xD-xU),Math.abs(yD-yU));}
			if(xU<xD && yU<yD) {g2d.fillRect(xU,yU,Math.abs(xD-xU),Math.abs(yD-yU));}
			if(xU<xD && yD<yU) {g2d.fillRect(xU,yD,Math.abs(xD-xU),Math.abs(yD-yU));}
		}
		if(Player.getInstance() != null) {
			double j = (this.getWidth()/1432.0) * Player.getInstance().getLocation().get_x();
			double k = (this.getHeight()/642.0) * Player.getInstance().getLocation().get_y();
			g2d.drawImage(image4, (int)j, (int)k, rootPane);
		}
		Graphics2D g2dComponent = (Graphics2D) g;
		g2dComponent.drawImage(bufferedImage, null, 0, 0); 
	}

	@Override
	public void mouseClicked(MouseEvent arg) {

		Point3D p123 = (myCoords.getInstance().frameToGps(Player.getInstance().getLocation().get_x(), Player.getInstance().getLocation().get_y()));
		Point3D p12 = (myCoords.getInstance().frameToGps((arg.getX() * (1432.0/this.getWidth())), (arg.getY() * (642.0/this.getHeight()))));
		rotate = myCoords.getInstance().azimuth(p123.get_y(), p123.get_x(), p12.get_y(), p12.get_x()); 
	}

	/**
	 * a class that Responsible for run with mouse.
	 */
	public class MyThread extends Thread{

		public void run() {
			play2.setInitLocation(32.1040,35.2061);
			play2.start();
			ArrayList<String> board_data;
			play2.setInitLocation(32.1040,35.2061);
			while(play2.isRuning()) {
				play2.rotate(rotate); 
				String info = play2.getStatistics();
				board_data = play2.getBoard();
				g1.removeF();
				g1.removeP();
				g1.removeG();
				for(int a=0;a<board_data.size();a++) {
					try {rp.board2Game(g1, board_data.get(a));}
					catch (IOException e) {e.printStackTrace();}
				}
				try {Thread.sleep(30);}
				catch (InterruptedException e) {e.printStackTrace();}
				repaint();
			}
			String info = play2.getStatistics();
		}
	}

	/**
	 * a class that Responsible for run Algorithem.
	 */
	public class MyThreadAlgorithem extends Thread{

		public void run() {
			play2.setInitLocation(32.1040,35.2061);
			play2.start();
			ArrayList<String> board_data;
			while(play2.isRuning()) {
				max = 10000000000.0;
				play2.rotate(rotate); 
				String info = play2.getStatistics();
				board_data = play2.getBoard();
				g1.removeF();
				g1.removeP();
				g1.removeG();
				for(int a=0;a<board_data.size();a++) {
					try {rp.board2Game(g1, board_data.get(a));}
					catch (IOException e) {e.printStackTrace();}
				}	
				try {Thread.sleep(15);}
				catch (InterruptedException e) {e.printStackTrace();}
				repaint();
				info = play2.getStatistics();
				for (int k=0 ; k<g1.fruSize() ; k++) {
					flag55 = false;
					algorithem.getInstance().CreateRecPoints(g1);
					algorithem.getInstance().CreateRecLines(g1);
					algorithem.getInstance().CreateRecPoints2(g1);
					Graph G = new Graph();
					String source = "a";
					String target = "b";
					G.add(new Node(source)); // Node "a" (0)
					g1.removeGeoPSD();
					for(int f=0 ; f<g1.GeoBoxsPointsArr().size() ; f++) {
						g1.GeoBoxsPointsWithSD().add(g1.GeoBoxsPointsArr().get(f));
					}
					algorithem.getInstance().buildArry(g1, k);
					for(int j=1;j<g1.GeoBoxsPointsWithSD().size()-1;j++) {
						Node d = new Node(""+j);
						G.add(d);
					}
					G.add(new Node(target)); // Node "b" (15)
					algorithem.getInstance().HouISee(g1, G);
					Graph_Algo.dijkstra(G, source);
					Node b = G.getNodeByName(target);
					ArrayList<String> shortestPath = b.getPath();
					if(b.getDist() < max) {
						max = b.getDist();
						if(shortestPath.size()>1) {
							int f = Integer.parseInt(shortestPath.get(1));
							Point3D p1234567 = (myCoords.getInstance().frameToGps(Player.getInstance().getLocation().get_x(), Player.getInstance().getLocation().get_y()));
							Point3D p123456 = (myCoords.getInstance().frameToGps(g1.GeoBoxsPointsWithSD().get(f).get_x(), g1.GeoBoxsPointsWithSD().get(f).get_y()));
							rotate = myCoords.getInstance().azimuth(p1234567.get_y(), p1234567.get_x(), p123456.get_y(), p123456.get_x()); 
						}
						else {
							Point3D p12345 = (myCoords.getInstance().frameToGps(Player.getInstance().getLocation().get_x(), Player.getInstance().getLocation().get_y()));
							Point3D p1234 = (myCoords.getInstance().frameToGps(g1.getFru(k).GpsPoint.get_x(), g1.getFru(k).GpsPoint.get_y()));
							rotate = myCoords.getInstance().azimuth(p12345.get_y(), p12345.get_x(), p1234.get_y(), p1234.get_x()); 
						}
					}
					g1.GeoBoxsPointsWithSD().remove(g1.GeoBoxsPointsWithSD().size()-1);
					g1.GeoBoxsPointsWithSD().remove(0);
				}
			}
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


