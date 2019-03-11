package Coords;

import Geom.Point3D;

/**
 * This interface represents a basic coordinate system converter, including:
 * 1. The 3D vector between two lat,lon, alt points 
 * 2. Adding a 3D vector in meters to a global point.
 * 3. convert a 3D vector from meters to polar coordinates
 * @author Boaz Ben-Moshe
 *
 */
public interface coords_converter {
	/** computes a new point which is the gps point transformed by a 3D vector (in meters)
	 * @param gps gps point
	 * @param local_vector_in_meter the vector that added
	 * @return the new point after the calculate
	 */
	public Point3D add(Point3D gps, Point3D local_vector_in_meter);
	/** computes the 3D distance (in meters) between the two gps like points 
	 * @param gps0 first gps point
	 * @param gps1 second gps point
	 * @return distance between to gps points
	 */
	public double distance3d(Point3D gps0, Point3D gps1);
	/** computes the 3D vector (in meters) between two gps like points 
	 * @param gps0 first gps point
	 * @param gps1 second gps point
	 * @return point3d vector between tow gps points
	 */
	public Point3D vector3D(Point3D gps0, Point3D gps1);
	/** computes the polar representation of the 3D vector be gps0, gps1 
	 * @param gps0 first gps point
	 * @param gps1 second gps point
	 * @return the azimuth between the gps points
	 * Note: this method should return an azimuth (aka yaw), elevation (pitch), and distance*/
	public double[] azimuth_elevation_dist(Point3D gps0, Point3D gps1);
	/**
	 * return true iff this point is a valid lat, lon , lat coordinate: [-180,+180],[-90,+90],[-450, +inf]
	 * @param p gps point
	 * @return true if is valid gps point else false
	 */
	public boolean isValid_GPS_Point(Point3D p);
	
}
