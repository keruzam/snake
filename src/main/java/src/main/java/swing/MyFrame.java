package src.main.java.swing;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * 
 * @author keruzam
 *
 */
public class MyFrame extends JFrame implements KeyListener {

	MyPanel panel;

	public MyFrame() {
		super();
		panel = new MyPanel();
		this.addKeyListener(this);
		this.add(panel);
		this.pack(); // resize to components

		this.setVisible(true);
		// this.setSize(420, 420);
		this.setTitle("Snake");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		ImageIcon icon = new ImageIcon("src/main/resources/snake2.png");
		this.setIconImage(icon.getImage());

		this.getContentPane().setBackground(new Color(31, 71, 42)); // 0x123456
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		// System.out.println("Key: " + key);
		panel.setKeyCode(key);
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}
