package File_format;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileSystemView;

import Coords.myCoords;
import GameObjects.Game;
import GameObjects.GeoBox;
import GameObjects.Ghost;
import GameObjects.Packman;
import GameObjects.Player;
import Geom.Point3D;
import GameObjects.Fruit;

/**
 * This class is responsible for create from a csv file a game
 */
public class CsvToGame {
	
	/**
	 * create from a csv file a game
	 * @param game the csv keeped as a game object  
	 */
	public void Csv2Game(Game game, String s) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(s));
		String str = "start";
		while(str != null) {
			str = br.readLine();
			if(str != null) {
				switch(str.charAt(0)) {
				case 'P' :BuildPackman(game,str);
				break;
				case 'F' :BuildFruit(game,str);
				break;
				case 'G' :BuildGhost(game,str);
				break;
				case 'B' :BuildGeoBox(game,str);
				break;
				case 'M' :BuildMe(game,str);
				break;
				}
			}
		}
		br.close();
	}

	/**
	 * calculate where to put the fruit
	 * @param game the csv keeped as a game object  
	 * @param str line from the csv file
	 */
	private void BuildFruit(Game game, String str) {
		String[] data = str.split(",");
		Point3D p1 = new Point3D(Double.parseDouble(data[3]),Double.parseDouble(data[2]),Double.parseDouble(data[4]));
		game.addFru(new Fruit(new Point3D(myCoords.getInstance().VectorToframe(new Point3D(myCoords.getInstance().gpsToVector(p1)) ,1433, 642))));
	}
	
	/**
	 * calculate where to put the player
	 * @param game the csv keeped as a game object  
	 * @param str line from the csv file
	 */
	private  void BuildMe(Game game, String str) {
		String[] data = str.split(",");
		Point3D p1 = new Point3D(Double.parseDouble(data[3]),Double.parseDouble(data[2]),Double.parseDouble(data[4]));
		Player.getInstance().setLocation(new Point3D(myCoords.getInstance().VectorToframe(new Point3D(myCoords.getInstance().gpsToVector(p1)) ,1433, 642)));
	}

	/**
	 * calculate where to put the packmans 
	 * @param game the csv keeped as a game object  
	 * @param str line from the csv file
	 */
	private void BuildPackman(Game game, String str) {
		String[] data = str.split(",");
		Point3D p1 = new Point3D(Double.parseDouble(data[3]),Double.parseDouble(data[2]),Double.parseDouble(data[4]));
		game.addPac(new Packman(new Point3D(myCoords.getInstance().VectorToframe(new Point3D(myCoords.getInstance().gpsToVector(p1)) ,1433, 642))));
	}
	
	/**
	 * calculate where to put the Ghost 
	 * @param game the csv keeped as a game object  
	 * @param str line from the csv file
	 */
	private void BuildGhost(Game game, String str) {
		String[] data = str.split(",");
		Point3D p1 = new Point3D(Double.parseDouble(data[3]),Double.parseDouble(data[2]),Double.parseDouble(data[4]));
		game.addGho(new Ghost(new Point3D(myCoords.getInstance().VectorToframe(new Point3D(myCoords.getInstance().gpsToVector(p1)) ,1433, 642))));
	}
	
	/**
	 * calculate where to put the GeoBox 
	 * @param game the csv keeped as a game object  
	 * @param str line from the csv file
	 */
	private void BuildGeoBox(Game game, String str) {
		String[] data = str.split(",");
		Point3D p1 = new Point3D(Double.parseDouble(data[3]),Double.parseDouble(data[2]),Double.parseDouble(data[4]));
		Point3D p2 = new Point3D(Double.parseDouble(data[6]),Double.parseDouble(data[5]),Double.parseDouble(data[7]));
		game.addGeo(new GeoBox((new Point3D(myCoords.getInstance().VectorToframe(new Point3D(myCoords.getInstance().gpsToVector(p1)) ,1433, 642))),(new Point3D(myCoords.getInstance().VectorToframe(new Point3D(myCoords.getInstance().gpsToVector(p2)) ,1433, 642)))));		
	}
	
}
