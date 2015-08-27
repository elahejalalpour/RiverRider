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
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Drawing extends JPanel {

	int[][] map;
	int[][] p;
	public static int[][] m = new int[7][10];
	BufferedImage grass;
	BufferedImage myplane;
	BufferedImage enemy;
	BufferedImage zamin;
	BufferedImage fuel;
	BufferedImage missile;
	BufferedImage lost;
	BufferedImage stop;
	BufferedImage win;
	public static int t;
	public static int k = 1000;
	public static int he = 3;
	public static int enemyl;

	public static ArrayList<missiles> mis;
	private Timer timer = new Timer(800, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			missiles ma;
			ma = new missiles(Drawing.he, 9);
			new Thread(ma).start();
			mis.add(ma);

		}
	});

	public Drawing(int[][] map, int[][] p) {
		timer.start();
		mis = new ArrayList<missiles>();

		this.map = map;
		this.p = p;
		try {
			win = ImageIO.read(new File("win.jpg"));
		} catch (IOException e) {
		}
		try {
			stop = ImageIO.read(new File("stop.jpg"));
		} catch (IOException e) {
		}
		try {
			lost = ImageIO.read(new File("lost.jpg"));
		} catch (IOException e) {
		}
		try {
			grass = ImageIO.read(new File("grass.jpg"));
		} catch (IOException e) {
		}
		try {
			myplane = ImageIO.read(new File("mplane.png"));
		} catch (IOException e) {
		}
		try {
			enemy = ImageIO.read(new File("enemy1.png"));
		} catch (IOException e) {
		}
		try {
			zamin = ImageIO.read(new File("2.png"));
		} catch (IOException e) {
		}
		try {
			fuel = ImageIO.read(new File("4.png"));
		} catch (IOException e) {
		}
		try {
			missile = ImageIO.read(new File("Rocket.png"));
		} catch (IOException e) {
		}
		setVisible(true);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponents(g);

		Graphics2D g2d = (Graphics2D) g;

		if (p[he][k - 1] != 1 && map[1][k - 1] != 9 && Manager.fuel > 0 && Drawing.enemyl < 10) {

			for (int i = 0; i < 7; i++) {
				for (int j = k - 10; j < k; j++) {
					if (map[i][j] == 0) {
						g2d.drawImage(grass, 64 * i, 64 * (j - (k - 9)) + Drawing.t, 64, 64, null);
					} else if (map[i][j] == 1) {
						g2d.drawImage(zamin, 64 * i, 64 * (j - (k - 9)) + Drawing.t, 64, 64, null);
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

			for (int i = 0; i < mis.size(); i++) {

				g2d.drawImage(missile, mis.get(i).xLocation * 64 + 28, mis.get(i).ylLocation * 64 - 10, 10, 64, this);
				if (p[mis.get(i).xLocation][Drawing.k - 1 - mis.get(i).ylLocation + 1] == 1) {
					p[mis.get(i).xLocation][Drawing.k - 1 - mis.get(i).ylLocation + 1] = 0;
					Drawing.enemyl++;


				}

			}
			g2d.drawImage(myplane, 64 * he, 64 * (8), 64, 64, null);
		} else if (map[1][k - 1] == 9) {
			g2d.clearRect(0, 0, 1000, 1000);
			g2d.drawImage(stop, 100, 100, 300, 300, null);

		} else if (Drawing.enemyl >= 10) {
			g2d.clearRect(0, 0, 1000, 1000);
			g2d.drawImage(win, 100, 100, 300, 300, null);
		} else {
			g2d.clearRect(0, 0, 1000, 1000);
			g2d.setBackground(Color.blue);
			g2d.drawImage(lost, 100, 100, 300, 300, null);

		}

	}
}
