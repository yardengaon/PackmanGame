package File_format;

import java.io.IOException;

import Coords.myCoords;
import GameObjects.Fruit;
import GameObjects.Game;
import GameObjects.Ghost;
import GameObjects.Packman;
import GameObjects.Player;
import Geom.Point3D;

public class replaceObjects {
	
	/**
	 * updating the game for the new state from the server
	 * @param game current game object
	 * @param str1 represent an object in the game  
	 */
	public void board2Game(Game game, String str1) throws IOException {
		switch(str1.charAt(0)) {
		case 'P' :BuildPackman1(game,str1);
		break;
		case 'F' :BuildFruit1(game,str1);
		break;
		case 'G' :BuildGhost1(game,str1);
		break;
		case 'M' :BuildMe1(game,str1);
		break;
		case 'B' :break;
		}
	}
	
	/**
	 * calculate where to put the player
	 * @param game current game object 
	 * @param str line from the server represent were put the player
	 */
	private void BuildMe1(Game game, String str) {
		String[] data = str.split(",");
		Point3D p1 = new Point3D(Double.parseDouble(data[2]),Double.parseDouble(data[3]),Double.parseDouble(data[4]));
		Player.getInstance().setLocation(new Point3D(myCoords.getInstance().VectorToframe(new Point3D(myCoords.getInstance().gpsToVector(p1)) ,1433, 642)));
	}
	
	/**
	 * calculate where to put the Packmans
	 * @param game current game object 
	 * @param str line from the server represent were put the Packmans
	 */
	private void BuildPackman1(Game game, String str) {
		String[] data = str.split(",");
		Point3D p1 = new Point3D(Double.parseDouble(data[2]),Double.parseDouble(data[3]),Double.parseDouble(data[4]));
		game.addPac(new Packman(new Point3D(myCoords.getInstance().VectorToframe(new Point3D(myCoords.getInstance().gpsToVector(p1)) ,1433, 642))));
	}
	
	/**
	 * calculate where to put the Ghosts
	 * @param game current game object 
	 * @param str line from the server represent were put the Ghosts
	 */
	private void BuildGhost1(Game game, String str) {
		String[] data = str.split(",");
		Point3D p1 = new Point3D(Double.parseDouble(data[2]),Double.parseDouble(data[3]),Double.parseDouble(data[4]));
		game.addGho(new Ghost(new Point3D(myCoords.getInstance().VectorToframe(new Point3D(myCoords.getInstance().gpsToVector(p1)) ,1433, 642))));
	}
	
	/**
	 * calculate where to put the Fruits
	 * @param game current game object 
	 * @param str line from the server represent were put the Fruits
	 */
	private void BuildFruit1(Game game, String str) {
		String[] data = str.split(",");
		Point3D p1 = new Point3D(Double.parseDouble(data[2]),Double.parseDouble(data[3]),Double.parseDouble(data[4]));
		game.addFru(new Fruit(new Point3D(myCoords.getInstance().VectorToframe(new Point3D(myCoords.getInstance().gpsToVector(p1)) ,1433, 642))));
	}
	
}
