package game;

import swing.MyFrame;
import swing.MyLabel;

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
