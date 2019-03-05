package GameObjects;

import Geom.Point3D;

abstract class GameObject {

	public Point3D GpsPoint ; 

	
	public GameObject(Point3D Gps) {
		this.setGpsPoint(new Point3D(Gps)); 
	}


	public Point3D getGpsPoint() {
		return GpsPoint;
	}


	public void setGpsPoint(Point3D gpsPoint) {
		GpsPoint = gpsPoint;
	}
	
	
	
	
	
}
