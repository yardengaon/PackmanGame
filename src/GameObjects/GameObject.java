package GameObjects;

import Geom.Point3D;

/**
 * this class represent an Game Object, the other classes will exstends from this class
 */
abstract class GameObject {

	//Variable statements
	public Point3D GpsPoint ; 

	/**
	 * GameObject constructor
	 * @param Gps point3D that represent the gameObject
	 */
	public GameObject(Point3D Gps) {
		this.setGpsPoint(new Point3D(Gps)); 
	}

	/**
	 * get the point3D that GameObject include
	 * @return the point3D that the GameObject include
	 */
	public Point3D getGpsPoint() {
		return GpsPoint;
	}

	/**
	 * set the point3D that GameObject include
	 * @param gpsPoint the point3D that we want to insert to the GameObject
	 */
	public void setGpsPoint(Point3D gpsPoint) {
		GpsPoint = gpsPoint;
	}
	
	
	
	
	
}
