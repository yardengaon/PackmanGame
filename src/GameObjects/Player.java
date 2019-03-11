package GameObjects;

import Coords.coords_converter;
import Coords.myCoords;
import Geom.Point3D;

/**
 * this class represent the Player (singleton) 
 */
public class Player {

	//Variable statements
	private static Player obj1 = null;
	private Point3D GpsPointe;

	/**
	 * Player Contractor
	 */
	private Player() {
		this.GpsPointe = new Point3D();
	}

	/**
	 * Contractor Player singeltone
	 */
	public static Player getInstance() {
		if(obj1 == null)
			obj1 = new Player();
		return obj1;
	}

	/**
	 * get the GpsPoint that represent the player location
	 * @return the current 6player location
	 */
	public Point3D getLocation() {
		return GpsPointe;
	}

	/**
	 * set the GpsPoint that represent the player location
	 * @param Gps the current player location represent by point3d
	 */
	public void setLocation(Point3D Gps) {
		this.GpsPointe = Gps;
	}

}
