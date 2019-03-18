package Algorithem;

import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import Coords.myCoords;
import GameObjects.Game;
import GameObjects.GeoBox;
import GameObjects.Player;
import Geom.Point3D;
import graph.Graph;

/**
 * This class is responsible for calculate the algorithm
 */
public class algorithem {

	//Variable statements
	private static algorithem obj3 = null;
	private int a;

	/**
	 * Contractor algorithm
	 */
	private algorithem() {}

	/**
	 * Contractor algorithm singeltone
	 */
	public static algorithem getInstance() {
		if(obj3 == null)
			obj3 = new algorithem();
		return obj3;
	}

	/**
	 * create points from the rectangle
	 * @param g1 represent the game object  
	 */
	public void CreateRecPoints(Game g1) {
		g1.removeGeoP();
		for (int i=0 ; i<g1.geoSize() ; i++) {
			double x1 = g1.getGeo(i).getPointDown().get_x();
			double x2 = g1.getGeo(i).getPointUp().get_x();
			double y1 = g1.getGeo(i).getPointDown().get_y();
			double y2 = g1.getGeo(i).getPointUp().get_y();

			g1.GeoBoxsPointsArr().add(new Point3D(x1,y1));
			g1.GeoBoxsPointsArr().add(new Point3D(x1,y2));
			g1.GeoBoxsPointsArr().add(new Point3D(x2,y2));
			g1.GeoBoxsPointsArr().add(new Point3D(x2,y1));
		}
	}

	/**
	 * create extended points from the rectangle
	 * @param g1 represent the game object  
	 */
	public void CreateRecPoints2(Game g1) {
		g1.removeGeoP();
		for (int i=0 ; i<g1.geoSize() ; i++) {
			double x1 = g1.getGeo(i).getPointDown().get_x();
			double x2 = g1.getGeo(i).getPointUp().get_x();
			double y1 = g1.getGeo(i).getPointDown().get_y();
			double y2 = g1.getGeo(i).getPointUp().get_y();

			if(x1<x2 && y1<y2) {
				g1.GeoBoxsPointsArr().add(new Point3D(x1-20,y1-20));
				g1.GeoBoxsPointsArr().add(new Point3D(x1-20,y2+20));
				g1.GeoBoxsPointsArr().add(new Point3D(x2+20,y2+20));
				g1.GeoBoxsPointsArr().add(new Point3D(x2+20,y1-20));
			}
			if(x1>x2 && y1<y2) {
				g1.GeoBoxsPointsArr().add(new Point3D(x1+20,y1-20));
				g1.GeoBoxsPointsArr().add(new Point3D(x1+20,y2+20));
				g1.GeoBoxsPointsArr().add(new Point3D(x2-20,y2+20));
				g1.GeoBoxsPointsArr().add(new Point3D(x2-20,y1-20));
			}
			if(x1>x2 && y1>y2) {
				g1.GeoBoxsPointsArr().add(new Point3D(x1+20,y1+20));
				g1.GeoBoxsPointsArr().add(new Point3D(x1+20,y2-20));
				g1.GeoBoxsPointsArr().add(new Point3D(x2-20,y2-20));
				g1.GeoBoxsPointsArr().add(new Point3D(x2-20,y1+20));
			}
			if(x1<x2 && y1>y2) {
				g1.GeoBoxsPointsArr().add(new Point3D(x1-20,y1+20));
				g1.GeoBoxsPointsArr().add(new Point3D(x1-20,y2-20));
				g1.GeoBoxsPointsArr().add(new Point3D(x2+20,y2-20));
				g1.GeoBoxsPointsArr().add(new Point3D(x2+20,y1+20));
			}
		}
	}

	/**
	 * create lines from the rectangle
	 * @param g1 represent the game object  
	 */
	public void CreateRecLines(Game g1) {	
		g1.removeLine2D();
		for (int i=0 ; i<g1.geoSize() ; i++) {
			double x1 = g1.GeoBoxsPointsArr().get(i*4).get_x();
			double y1 = g1.GeoBoxsPointsArr().get(i*4).get_y();
			double x2 = g1.GeoBoxsPointsArr().get(i*4+1).get_x();
			double y2 = g1.GeoBoxsPointsArr().get(i*4+1).get_y();
			double x3 = g1.GeoBoxsPointsArr().get(i*4+2).get_x();
			double y3 = g1.GeoBoxsPointsArr().get(i*4+2).get_y();
			double x4 = g1.GeoBoxsPointsArr().get(i*4+3).get_x();
			double y4 = g1.GeoBoxsPointsArr().get(i*4+3).get_y();
			g1.getLine2Ds().add(new Line2D.Double(x1,y1,x2,y2));
			g1.getLine2Ds().add(new Line2D.Double(x2,y2,x3,y3));
			g1.getLine2Ds().add(new Line2D.Double(x3,y3,x4,y4));
			g1.getLine2Ds().add(new Line2D.Double(x4,y4,x1,y1));
		}
	}

	/**
	 * clean from problematic points and lines
	 * @param g1 represent the game object  
	 */
	public void cleanFromProblematicPointsLines(Game g1) {
		for (int i=0 ; i<g1.getLine2Ds().size() ; i++) {
			double x1 = g1.getLine2Ds().get(i).getX1();
			double x2 = g1.getLine2Ds().get(i).getX2();
			double y1 = g1.getLine2Ds().get(i).getY1();
			double y2 = g1.getLine2Ds().get(i).getY2();
			for (int k=0 ; k<g1.geoSize() ; k++) {
				double xUp = g1.getGeo(k).getPointUp().get_x();
				double xDo = g1.getGeo(k).getPointDown().get_x();
				double yUp = g1.getGeo(k).getPointUp().get_y();
				double yDo = g1.getGeo(k).getPointDown().get_y();
				//new Rectangle().c
				if(xUp<xDo && yUp<yDo) {
					if((((xUp<x1)&&(x1<xDo)) && ((yUp<y1)&&(y1<yDo))) && (((xUp<x2)&&(x2<xDo)) && ((yUp<y2)&&(y2<yDo)))) {
						g1.getLine2Ds().remove(i);
					}
				}
				if(xUp<xDo && yDo<yUp) {
					if((((xUp<x1)&&(x1<xDo)) && ((yDo<y1)&&(y1<yUp))) && (((xUp<x2)&&(x2<xDo)) && ((yDo<y2)&&(y2<yUp)))) {
						g1.getLine2Ds().remove(i);
					}
				}
				if(xDo<xUp && yUp<yDo) {
					if((((xDo<x1)&&(x1<xUp)) && ((yUp<y1)&&(y1<yDo))) && (((xDo<x2)&&(x2<xUp)) && ((yUp<y2)&&(y2<yDo)))) {
						g1.getLine2Ds().remove(i);
					}
				}
				if(xDo<xUp && yDo<yUp) {
					if((((xDo<x1)&&(x1<xUp)) && ((yDo<y1)&&(y1<yUp))) && (((xDo<x2)&&(x2<xUp)) && ((yDo<y2)&&(y2<yUp)))) {
						g1.getLine2Ds().remove(i);
					}
				}
			}
		}

		for (int i=0 ; i<g1.GeoBoxsPointsArr().size() ; i++) {
			double x = g1.GeoBoxsPointsArr().get(i).get_x();
			double y = g1.GeoBoxsPointsArr().get(i).get_y();
			for (int k=0 ; k<g1.geoSize() ; k++) {
				double x1 = g1.getGeo(k).getPointUp().get_x();
				double x2 = g1.getGeo(k).getPointDown().get_x();
				double y1 = g1.getGeo(k).getPointUp().get_y();
				double y2 = g1.getGeo(k).getPointDown().get_y();

				if(x1<x2 && y1<y2) {
					if(((x1<x)&&(x<x2)) && ((y1<y)&&(y<y2))) {
						g1.GeoBoxsPointsArr().remove(i);
					}
				}
				if(x2<x1 && y1<y2) {
					if(((x2<x)&&(x<x1)) && ((y1<y)&&(y<y2))) {
						g1.GeoBoxsPointsArr().remove(i);
					}
				}
				if(x1<x2 && y2<y1) {
					if(((x1<x)&&(x<x2)) && ((y2<y)&&(y<y1))) {
						g1.GeoBoxsPointsArr().remove(i);
					}
				}
				if(x2<x1 && y2<y1) {
					if(((x2<x)&&(x<x1)) && ((y2<y)&&(y<y1))) {
						g1.GeoBoxsPointsArr().remove(i);
					}
				}
			}
		}
	}

	/**
	 * check which every point in the GeoBoxsPointsWithSD arry can see 
	 * @param g1 represent the game object  
	 * @param G represent the Graph  
	 */
	public void HouISee(Game g1, Graph G) {
		for (int i=0 ; i<g1.GeoBoxsPointsWithSD().size() ; i++) {
			double x1 = g1.GeoBoxsPointsWithSD().get(i).get_x();
			double y1 = g1.GeoBoxsPointsWithSD().get(i).get_y();
			for (int k=i ; k<g1.GeoBoxsPointsWithSD().size() ; k++) {
				double x2 = g1.GeoBoxsPointsWithSD().get(k).get_x();
				double y2 = g1.GeoBoxsPointsWithSD().get(k).get_y();
				Line2D.Double L1 = new Line2D.Double(x1,y1,x2,y2);
				int counter = 0;
				if(g1.getLine2Ds().size() > 0 ) {
					for (int j=0 ; j<g1.getLine2Ds().size() ; j++) {
						Line2D L2 = g1.getLine2Ds().get(j);
						if(!(L1.intersectsLine(L2))) {
							counter++;	
						}
						if(counter == g1.getLine2Ds().size()) {
							counter = 0;
							//System.out.println(i + " " + k);
							G.addEdge(G.getNodeByIndex(i).get_name(), G.getNodeByIndex(k).get_name(), g1.GeoBoxsPointsWithSD().get(i).distance2D(g1.GeoBoxsPointsWithSD().get(k)));
						}
					}
				}
				else {G.addEdge(G.getNodeByIndex(i).get_name(), G.getNodeByIndex(k).get_name(), g1.GeoBoxsPointsWithSD().get(i).distance2D(g1.GeoBoxsPointsWithSD().get(k)));}
			}
		}
	}

	/**
	 * build in the GeoBoxsPointsWithSD source and destination 
	 * @param g1 represent the game object  
	 * @param k represent the destination (fruit)  
	 */
	public void buildArry(Game g1, int k) {
		g1.GeoBoxsPointsWithSD().add(0 ,Player.getInstance().getLocation());
		g1.GeoBoxsPointsWithSD().add(g1.getFru(k).GpsPoint);
	}

}




