package GameObjects;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import Geom.Point3D;

/**
 * this class represent a GeoBox
 */
public class Line extends Line2D {

	//Variable statements
	Point3D Point1 ; 
	Point3D Point2 ; 

	/**
	 * Line constructor
	 * @param p1 Point1
	 * @param p2 Point2
	 */
	public Line(Point3D p1 , Point3D p2) 
	{
		Point1 = p1 ; 
		Point2 = p2 ; 
	}

	/**
	 * Line constructor
	 * @param x1 value of x Point1
	 * @param y1 value of y Point1
	 * @param x2 value of x Point2
	 * @param y2 value of y Point2
	 */
	public Line(double x1, double y1, double x2, double y2) 
	{
		Point1 = new Point3D(x1, y1); 
		Point2 = new Point3D(x2, y2);
	}
	/**
	 * get the point3D that lower in the GeoBox
	 * @return the lower point3D that the GeoBox include
	 */
	public Point3D getPoint1() {
		return Point1;
	}

	/**
	 * get the point3D that higher in the GeoBox
	 * @return the higher point3D that the GeoBox include
	 */
	public Point3D getPoint2() {
		return Point2;
	}



	@Override
	public Rectangle2D getBounds2D() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getX1() {
		return Point1.get_x();
	}

	@Override
	public double getY1() {
		return Point1.get_y();
	}

	@Override
	public Point2D getP1() {
		return this.getP1();
	}

	@Override
	public double getX2() {
		return Point2.get_x();
	}

	@Override
	public double getY2() {
		return Point2.get_y();
	}

	@Override
	public Point2D getP2() {
		return this.getP2();
	}

	@Override
	public void setLine(double x1, double y1, double x2, double y2) {
		// TODO Auto-generated method stub

	}

}
