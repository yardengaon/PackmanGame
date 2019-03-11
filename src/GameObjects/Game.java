package GameObjects;

import java.util.ArrayList;

import Geom.Point3D;
/**
 * this class represent a simple fruit 
 */
public class Game {

	//Variable statements
	private ArrayList<Fruit> Fruits ;
	private ArrayList<Packman> Packmans ; 
	private ArrayList<Ghost> Ghosts ;
	private ArrayList<GeoBox> GeoBoxs ;
	
	/**
	 * Game constructor
	 */
	public Game() {
		Fruits = new ArrayList<Fruit>();
		Packmans = new ArrayList<Packman>();
		Ghosts = new ArrayList<Ghost>();
		GeoBoxs = new ArrayList<GeoBox>();
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
	
	
	
	
}
