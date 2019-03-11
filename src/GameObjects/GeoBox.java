package GameObjects;

import Geom.Point3D;

/**
 * this class represent a GeoBox
 */
public class GeoBox {

	//Variable statements
	Point3D PointUp ; 
	Point3D PointDown ; 

	/**
	 * GeoBox constructor
	 * @param up the higher point3D in the GeoBox
	 * @param up the lower point3D in the GeoBox
	 */
	public GeoBox(Point3D up , Point3D down) 
	{
		PointUp = up ; 
		PointDown = down ; 
	}

	/**
	 * get the point3D that lower in the GeoBox
	 * @return the lower point3D that the GeoBox include
	 */
	public Point3D getPointDown() {
		return PointDown;
	}
	
	/**
	 * get the point3D that higher in the GeoBox
	 * @return the higher point3D that the GeoBox include
	 */
	public Point3D getPointUp() {
		return PointUp;
	}

}