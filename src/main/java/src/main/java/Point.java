package src.main.java;

/**
 * 
 * @author keruzam
 *
 */
public class Point {

	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point calcHeadPosition(int xVector, int yVector) {
		return new Point(x + xVector, y + yVector);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
