package util;

import java.awt.Point;
import java.io.Serializable;

public class Linea implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Point lineaP1, lineaP2;
	//private Point lineaMid;

	public Linea(Point _lineaP1, Point _lineaP2) {
		lineaP1 = _lineaP1;
		lineaP2 = _lineaP2;
		//lineaMid = new Point((_lineaP1.x + _lineaP2.x)/2,(_lineaP1.y + _lineaP2.y)/2);
		}
	
	
	public Point getLineaP1() {
		return lineaP1;
	}

	public void setLineaP1(Point lineaP1) {
		this.lineaP1 = lineaP1;
	}

	public Point getLineaP2() {
		return lineaP2;
	}

	public void setLineaP2(Point lineaP2) {
		this.lineaP2 = lineaP2;
	}
}
