/*
 * In The Name Of God
 * ========================================
 * [] File Name : Drawing.java
 *
 * [] Creation Date : 27-08-2015
 *
 * [] Created By : Elahe Jalalpour (el.jalalpour)
 * =======================================
*/
/**
 * @author Elahe Jalalpour
 */
package me.elahe.riverrider;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class Drawing extends JPanel {

	int[][] map;
	int[][] p;
	public static int[][] m = new int[7][10];
	private BufferedImage grass;
	private BufferedImage myPlane;
	private BufferedImage enemy;
	private BufferedImage ground;
	private BufferedImage fuel;
	private BufferedImage missile;
	private BufferedImage lost;
	private BufferedImage stop;
	private BufferedImage win;
	public static int t;
	public static int k = 1000;
	public static int he = 3;
	public static int enemy_l;

	public static ArrayList<missiles> mis;

	public Drawing(int[][] map, int[][] p) {
		Timer timer = new Timer(800, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				missiles ma;
				ma = new missiles(Drawing.he, 9);
				new Thread(ma).start();
				mis.add(ma);

			}
		});
		timer.start();
		mis = new ArrayList<>();

		this.map = map;
		this.p = p;
		try {
			win = ImageIO.read(ClassLoader.getSystemResourceAsStream("win.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			stop = ImageIO.read(ClassLoader.getSystemResourceAsStream("stop.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			lost = ImageIO.read(ClassLoader.getSystemResourceAsStream("lost.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			grass = ImageIO.read(ClassLoader.getSystemResourceAsStream("grass.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			myPlane = ImageIO.read(ClassLoader.getSystemResourceAsStream("myPlane.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			enemy = ImageIO.read(ClassLoader.getSystemResourceAsStream("enemy_1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ground = ImageIO.read(ClassLoader.getSystemResourceAsStream("ground.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fuel = ImageIO.read(ClassLoader.getSystemResourceAsStream("fuel.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			missile = ImageIO.read(ClassLoader.getSystemResourceAsStream("Rocket.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setVisible(true);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponents(g);

		Graphics2D g2d = (Graphics2D) g;

		if (p[he][k - 1] != 1 && map[1][k - 1] != 9 && Manager.fuel > 0 && Drawing.enemy_l < 10) {

			for (int i = 0; i < 7; i++) {
				for (int j = k - 10; j < k; j++) {
					if (map[i][j] == 0) {
						g2d.drawImage(grass, 64 * i, 64 * (j - (k - 9)) + Drawing.t, 64, 64, null);
					} else if (map[i][j] == 1) {
						g2d.drawImage(ground, 64 * i, 64 * (j - (k - 9)) + Drawing.t, 64, 64, null);
					}
				}
			}
			for (int i = 0; i < 7; i++) {
				for (int j = k - 10; j < k; j++) {
					if (p[i][j] == 1) {
						g2d.drawImage(enemy, 64 * i, 64 * (j - (k - 9)) + Drawing.t, 64, 64, null);
					} else if (p[i][j] == 2) {
						g2d.drawImage(fuel, 64 * i, 64 * (j - (k - 9)) + Drawing.t, 30, 30, null);
					}
				}
			}

			for (missiles mi : mis) {
				g2d.drawImage(missile, mi.xLocation * 64 + 28, mi.ylLocation * 64 - 10, 10, 64, this);
				if (p[mi.xLocation][Drawing.k - 1 - mi.ylLocation + 1] == 1) {
					p[mi.xLocation][Drawing.k - 1 - mi.ylLocation + 1] = 0;
					Drawing.enemy_l++;
				}

			}
			g2d.drawImage(myPlane, 64 * he, 64 * (8), 64, 64, null);
		} else if (map[1][k - 1] == 9) {
			g2d.clearRect(0, 0, 1000, 1000);
			g2d.drawImage(stop, 100, 100, 300, 300, null);

		} else if (Drawing.enemy_l >= 10) {
			g2d.clearRect(0, 0, 1000, 1000);
			g2d.drawImage(win, 100, 100, 300, 300, null);
		} else {
			g2d.clearRect(0, 0, 1000, 1000);
			g2d.setBackground(Color.blue);
			g2d.drawImage(lost, 100, 100, 300, 300, null);

		}

	}
}
