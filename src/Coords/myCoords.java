package Coords;

import java.awt.Point;

import Geom.Point3D;

/**
 * This class is responsible for Converts coordinates
 */

public class myCoords implements coords_converter  {

	//Variable statements
	private static myCoords obj1 = null;
	private Point3D TipPoint1;
	private Point3D TipPoint2;

	/**
	 * Contractor myCoords
	 */
	private myCoords() {
		this.TipPoint1 = new Point3D(35.20234, 32.10584);
		this.TipPoint2 = new Point3D(35.21237, 32.10193);
	}

	/**
	 * Contractor myCoords singeltone
	 */
	public static myCoords getInstance() {
		if(obj1 == null)
			synchronized(myCoords.class) {
				myCoords obj2 = obj1;
				if(obj2 == null) {
					synchronized(myCoords.class) {
						obj1 = new myCoords();
					}
				}
			}
		return obj1;
	}

	@Override
	public Point3D add(Point3D gps, Point3D local_vector_in_meter) {
		Point3D newpoint3 = gpsToVector(gps);
		newpoint3.set_x(newpoint3.get_x() + local_vector_in_meter.get_x());
		newpoint3.set_y(newpoint3.get_y() + local_vector_in_meter.get_y());
		newpoint3.set_z(newpoint3.get_z() + local_vector_in_meter.get_z());

		return newpoint3;
	}

	@Override
	public double distance3d(Point3D gps0, Point3D gps1) {
		double distance3d;
		double diff = gps0.get_y() - gps1.get_y();
		double diff1 = gps0.get_x() - gps1.get_x();
		double diff2 = gps0.get_z() - gps1.get_z();
		double diff_radian = (diff * Math.PI) / 180;
		double diff_radian1 = (diff1 * Math.PI) / 180;
		double meter = Math.sin(diff_radian) * gps1.get_y();
		double meter1 = Math.sin(diff_radian1) * gps1.get_y() * gps1.get_x();
		distance3d = Math.sqrt(Math.pow(meter, 2) + Math.pow(meter1, 2) + Math.pow(diff2, 2));

		return distance3d;
	}

	@Override
	public Point3D vector3D(Point3D gps0, Point3D gps1) {
		Point3D newGps0 = gpsToVector(gps0);
		Point3D newGps1 = gpsToVector(gps1);
		newGps0.set_x(newGps0.get_x() - newGps1.get_x());
		newGps0.set_y(newGps0.get_y() - newGps1.get_y());
		newGps0.set_z(newGps0.get_z() - newGps1.get_z());
		return newGps0;
	}

	@Override
	public double[] azimuth_elevation_dist(Point3D gps0, Point3D gps1) {
		// TODO Auto-generated method stub


		return null;
	}

	@Override
	public boolean isValid_GPS_Point(Point3D p) {
		if(p.get_y() >= -90 && p.get_y() <= 90 && p.get_x() >= -180 && p.get_x() <= 180 && p.get_z() <= 10000 && p.get_z() >= -450 )
			return true;
		return false;
	}

	/**
	 * calculate the distance between 2 gps points
	 * @param gps0 the first gps point
	 * @param gps1 the second gps point
	 * @return distance between 2 gps points
	 */
	public double distance2d(Point3D gps0, Point3D gps1) {
		double distance3d;
		double diff = gps0.get_y() - gps1.get_y();
		double diff1 = gps0.get_x() - gps1.get_x();
		double diff_radian = (diff * Math.PI) / 180;
		double diff_radian1 = (diff1 * Math.PI) / 180;
		double meter = Math.sin(diff_radian) * gps1.get_y();
		double meter1 = Math.sin(diff_radian1) * gps1.get_y() * gps1.get_x();
		distance3d = Math.sqrt(Math.pow(meter, 2) + Math.pow(meter1, 2));

		return distance3d;
	}

	/**
	 * Convert from gps to vector
	 * @param gps the gps point that we wont to convert
	 * @return vector Point3D 
	 */
	public Point3D gpsToVector(Point3D gps) {

		double r = 6371000 + gps.get_z();
		double x = r * Math.sin(Math.toRadians(gps.get_x()));
		double y = r * 0.847091174 * Math.sin(Math.toRadians(gps.get_y()));

		return new Point3D(x,y,gps.z());
	}

	/**
	 * Convert from frame to gps point
	 * @param frame_x the value of x on the frame 
	 * @param frame_y the value of y on the frame
	 * @return gps Point3D  
	 */
	public Point3D frameToGps(double frame_x, double frame_y) {

		double vecX = TipPoint1.get_x();
		double vecY = TipPoint1.get_y();
		vecX += (TipPoint2.get_x() - TipPoint1.get_x()) * (frame_x/1432.0);
		vecY += (TipPoint2.get_y() - TipPoint1.get_y()) * (frame_y/642.0);

		return new Point3D(vecX, vecY);
	}

	/**
	 * Convert from vector to frame point
	 * @param vec the vector point that we wont to convert
	 * @param xFr value of x on the frame
	 * @param yFr value of y on the frame 
	 * @return frame Point3D 
	 */
	public Point3D VectorToframe(Point3D vec, double xFr, double yFr) {

		Point3D pStart = gpsToVector(this.TipPoint1);
		Point3D pEnd = gpsToVector(this.TipPoint2);
		double x = Math.abs(pStart.get_x() - pEnd.get_x());
		double y = Math.abs(pStart.get_y() - pEnd.get_y());
		double moveXMet = Math.abs(pStart.get_x() - vec.get_x());
		double moveYMet = Math.abs(pStart.get_y() - vec.get_y());
		double frameX = (xFr / x) * moveXMet;
		double frameY = (yFr / y) * moveYMet;

		return new Point3D(frameX, frameY);
	}

	/**
	 * calculate the distance between 2 vector points
	 * @param v0 the first vector point
	 * @param v1 the second vector point
	 * @return distance between 2 vector points 
	 */
	public double distanceV2d(Point3D v0, Point3D v1) {
		double distance3d;
		double diff = v0.get_y() - v1.get_y();
		double diff1 = v0.get_x() - v1.get_x();
		distance3d = Math.sqrt(Math.pow(diff, 2) + Math.pow(diff1, 2));

		return distance3d;
	}

	/**
	 * Convert from vector to gps
	 * @param v the vector point that we wont to convert
	 * @return gps Point3D 
	 */
	public Point3D VectorToGps(Point3D v) {

		double r = 6371000 + v.get_z();
		double x = (v.get_x()/r);
		x = Math.toDegrees(Math.asin(x));
		double y = (v.get_y()/r/0.847091174);
		y = Math.toDegrees(Math.asin(y));

		return new Point3D(x,y,v.z());
	}

	/**
	 * calculate the angle between 2 points
	 * @param lat1 value point1
	 * @param lon1 value point1
	 * @param lat2 value point2
	 * @param lon2 value point2
	 * @return angle between 2 points 
	 */
	public int azimuth(double lat1, double lon1, double lat2, double lon2){

		double latR1 = Math.toRadians(lat1);
		double latR2 = Math.toRadians(lat2);
		double longDiff= Math.toRadians(lon2-lon1);
		double y= Math.sin(longDiff)*Math.cos(latR2);
		double x=Math.cos(latR1)*Math.sin(latR2)-Math.sin(latR1)*Math.cos(latR2)*Math.cos(longDiff);
		return (int) (Math.toDegrees(Math.atan2(y, x))+360)%360;
	}

}
