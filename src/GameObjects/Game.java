package GameObjects;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import Geom.Point3D;
/**
 * this class represent a game 
 */
public class Game {

	//Variable statements
	private ArrayList<Fruit> Fruits ;
	private ArrayList<Packman> Packmans ; 
	private ArrayList<Ghost> Ghosts ;
	private ArrayList<GeoBox> GeoBoxs ;
	private ArrayList<Point3D> GeoBoxsPoints;
	private ArrayList<Point3D> GeoBoxsPointsWithSD;
	private ArrayList<Line2D> Line2Ds;
	
	/**
	 * Game constructor
	 */
	public Game() {
		Fruits = new ArrayList<Fruit>();
		Packmans = new ArrayList<Packman>();
		Ghosts = new ArrayList<Ghost>();
		GeoBoxs = new ArrayList<GeoBox>();
		GeoBoxsPoints = new ArrayList<Point3D>();
		GeoBoxsPointsWithSD = new ArrayList<Point3D>();
		Line2Ds = new ArrayList<Line2D>();
	}
	
	/**
	 * add GeoBox method
	 * @param ge the GeoBox that we wont to add
	 */
	public void addGeo(GeoBox ge) {
		GeoBoxs.add(ge);
	}
	
	/**
	 * size method
	 * @return the size of the GeoBoxs array
	 */
	public int geoSize() {
		return GeoBoxs.size();
	}
	
	/**
	 * get a specific GeoBox from the GeoBoxs array
	 * @param i the index that the GeoBox localized
	 * @return the specific GeoBox from the array
	 */
	public GeoBox getGeo(int index) {
		return GeoBoxs.get(index);
	}
	
	/**
	 * get Line2Ds array
	 * @return the Line2Ds array
	 */
	public ArrayList<Line2D> getLine2Ds() {
		return Line2Ds;
	}
	
	/**
	 * get GeoBoxs array
	 * @return the GeoBoxs array
	 */
	public ArrayList<GeoBox> getGeoArr() {
		return GeoBoxs;
	}
	
	/**
	 * get GeoBoxsPoints array
	 * @return the GeoBoxsPoints array
	 */
	public ArrayList<Point3D> GeoBoxsPointsArr() {
		return GeoBoxsPoints;
	}
	
	/**
	 * get GeoBoxsPointsWithSD array
	 * @return the GeoBoxsPointsWithSD array
	 */
	public ArrayList<Point3D> GeoBoxsPointsWithSD() {
		return GeoBoxsPointsWithSD;
	}
	
	/**
	 * add Fruit method
	 * @param fr the Fruit that we wont to add
	 */
	public void addFru(Fruit fr) {
		Fruits.add(fr);
	}
	
	/**
	 * add Packman method
	 * @param pa the Packman that we wont to add
	 */
	public void addPac(Packman pa) {
		Packmans.add(pa);
	}
	
	/**
	 * add Ghost method
	 * @param gh the Ghost that we wont to add
	 */
	public void addGho(Ghost gh) {
		Ghosts.add(gh);
	}
	
	/**
	 * size method
	 * @return the size of the Packmans array
	 */
	public int pacSize() {
		return Packmans.size();
	}
	
	/**
	 * size method
	 * @return the size of the Fruits array
	 */
	public int fruSize() {
		return Fruits.size();
	}
	
	/**
	 * size method
	 * @return the size of the Ghosts array
	 */
	public int GhoSize() {
		return Ghosts.size();
	}
	
	/**
	 * get a specific Fruit from the Fruits array
	 * @param i the index that the Fruits localized
	 * @return the specific Fruits from the array
	 */
	public Fruit getFru(int index) {
		return Fruits.get(index);
	}
	
	/**
	 * get a specific Packman from the Packmans array
	 * @param i the index that the Packman localized
	 * @return the specific Packman from the array
	 */
	public Packman getPac(int index) {
		return Packmans.get(index);
	}
	
	/**
	 * get a specific Ghost from the Ghosts array
	 * @param i the index that the Ghost localized
	 * @return the specific Ghost from the array
	 */
	public Ghost getGho(int index) {
		return Ghosts.get(index);
	}
	
	/**
	 * remove method, removed all the fruits
	 */
	public void removeF() {
		while(!Fruits.isEmpty()) {Fruits.remove(0);}
	}
	
	/**
	 * remove method removed all the Ghosts
	 */
	public void removeG() {
		while(!Ghosts.isEmpty()) {Ghosts.remove(0);}
	}
	
	/**
	 * remove method removed all the Packmans
	 */
	public void removeP() {
		while(!Packmans.isEmpty()) {Packmans.remove(0);}
	}
	
	/**
	 * remove method removed all the geoboxes
	 */
	public void removeGeoP() {
		while(!GeoBoxsPoints.isEmpty()) {GeoBoxsPoints.remove(0);}
	}
	
	/**
	 * remove method removed all the geoboxes + source, destination 
	 */
	public void removeGeoPSD() {
		while(!GeoBoxsPointsWithSD.isEmpty()) {GeoBoxsPointsWithSD.remove(0);}
	}
	
	/**
	 * remove method removed all the lines 
	 */
	public void removeLine2D() {
		while(!Line2Ds.isEmpty()) {Line2Ds.remove(0);}
	}
	
	
	
	
}
