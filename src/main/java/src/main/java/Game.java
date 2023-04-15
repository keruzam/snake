package src.main.java;

import src.main.java.swing.MyFrame;
import src.main.java.swing.MyLabel;

/**
 * 
 * @author keruzam
 *
 */
public class Game {

	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		MyLabel label = new MyLabel("Snake");
		frame.add(label);
	}

}
