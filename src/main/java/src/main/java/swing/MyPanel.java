package src.main.java.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import src.main.java.Point;

/**
 * 
 * @author keruzam
 *
 */
public class MyPanel extends JPanel implements ActionListener {

	private static final int LEFT = 37;
	private static final int UP = 38;
	private static final int RIGHT = 39;
	private static final int DOWN = 40;

	public static final int WIDTH = 420;
	public static final int HEIGHT = 420;
	private static final int SPEED = 100;

	Image img;
	Timer timer;

	int vector = 10;
	int keyCode = UP;
	int size = 6;

	int score = 0;

	ArrayList<Point> snake = new ArrayList<Point>();
	Point food = new Point(30, 30);

	boolean isHit = false;
	boolean isFood = false;

	public MyPanel() {
		img = new ImageIcon("src/main/resources/bg.png").getImage();
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		initTimer();
		initSnake();
	}

	private void initTimer() {
		timer = new Timer(SPEED, this);
		timer.start();
	}

	private void initSnake() {
		for (int i = 0; i < size; i++) {
			int y = 190 + i * 10;
			snake.add(i, new Point(200, y));
		}
	}

	@Override
	public void paint(Graphics g) {
		if (!isHit) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.drawImage(img, 0, 0, null);
			if (isFood) {
				food = new Point(new Random().nextInt(WIDTH / 10) * 10, new Random().nextInt(HEIGHT / 10) * 10);
				snake.add(snake.get(size - 1));
				size = size + 1;
				score = score + 10;
				System.out.println("Score: " + score);
			}
			// g2d.drawRect(food.getX(), food.getY(), vector, vector);
			// g2d.setPaint(Color.RED);
			g2d.setPaint(Color.LIGHT_GRAY);
			g2d.drawOval(food.getX(), food.getY(), vector, vector);
			// g2d.setPaint(Color.GREEN);
			for (int i = size - 1; i >= 0; i--) {
				g2d.drawRect(snake.get(i).getX(), snake.get(i).getY(), vector, vector);
				if (i > 0) {
					snake.set(i, snake.get(i - 1));
				} else {
					snake.set(0, getNewSnakeHeadPosition());
				}
				checkIsHit();
				checkIsFood();
			}
		}
	}

	private void checkIsFood() {
		Point head = getSnakeHead();
		int x = head.getX();
		int y = head.getY();
		isFood = x == food.getX() && food.getY() == y;
	}

	private Point getSnakeHead() {
		return snake.get(0);
	}

	private void checkIsHit() {
		Point head = getSnakeHead();
		int x = head.getX();
		int y = head.getY();
		isHit = x < 0 || x > WIDTH - vector || y < 0 || y > HEIGHT - vector;
	}

	private Point getNewSnakeHeadPosition() {
		Point head = getSnakeHead();
		if (keyCode == UP) {
			return head.calcHeadPosition(0, -vector);
		} else if (keyCode == DOWN) {
			return head.calcHeadPosition(0, vector);
		} else if (keyCode == LEFT) {
			return head.calcHeadPosition(-vector, 0);
		} else if (keyCode == RIGHT) {
			return head.calcHeadPosition(vector, 0);
		}
		return head;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	public void setKeyCode(int keyCode) {
		this.keyCode = keyCode;
	}

}
