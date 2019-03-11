package Geom;

public interface Geom_element {
	
	/**
	 * calculate distance3D method
	 * @param p the point that we wont to calculate distance with this point
	 */
	public double distance3D(Point3D p) ;
	
	/**
	 * calculate distance2D method
	 * @param p the point that we wont to calculate distance with this point
	 */
	public double distance2D(Point3D p);
	
}
