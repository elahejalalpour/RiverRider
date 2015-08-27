/*
 * In The Name Of God
 * ========================================
 * [] File Name : Manager.java
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

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Manager implements Runnable {

	public int i;
	public Map r;
	public static int fuel;
	public static int enemy;
	public Frame f;
	public static boolean isRun = true;

	public Manager() {
		fuel = 100;
		r = new Map();
		r.setMap();
		r.setPlanes();
		f = new Frame(r.map, r.planeslist, this);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

	}

	@Override
	public void run() {
		try {
			for (i = 0; i < 900; i++) {
				if (fuel > 0 && r.planeslist[Drawing.he][Drawing.k - 1] != 1 && r.map[1][Drawing.k - 1] != 9) {
					for (int ja = 0; ja < 64; ja++) {
						Drawing.t++;
						Thread.sleep(10);
						f.r.repaint();
					}

					Drawing.t = 0;
					Drawing.k--;
					f.r.repaint();
					fuel -= 3;
					f.setfuel();
					f.setenemy();
					f.setenemymissed();
					if (r.planeslist[Drawing.he][Drawing.k - 1] == 2) {
						r.planeslist[Drawing.he][Drawing.k - 1] = 0;
						fuel += 25;
					}
				} else if (fuel <= 0) {
					System.out.println("you lost the game!!!!(fuel)");
					break;
				}
				if (r.planeslist[Drawing.he][Drawing.k] == 1) {
					System.out.println("you lost the game!!!!(enemy)");
					break;
				}
				if (Drawing.enemy_l >= 10) {
					System.out.println("you win the game");
					break;
				}

				if (r.map[1][Drawing.k - 1] == 9) {
					break;
				}
				if (r.planeslist[0][Drawing.k] == 1) {
					Manager.enemy++;
				}
				if (r.planeslist[1][Drawing.k] == 1) {
					Manager.enemy++;
				}
				if (r.planeslist[2][Drawing.k] == 1) {
					Manager.enemy++;
				}
				if (r.planeslist[3][Drawing.k] == 1) {
					Manager.enemy++;
				}
				if (r.planeslist[4][Drawing.k] == 1) {
					Manager.enemy++;
				}
				if (r.planeslist[5][Drawing.k] == 1) {
					Manager.enemy++;
				}
				if (r.planeslist[6][Drawing.k] == 1) {
					Manager.enemy++;
				}
			}
		} catch (InterruptedException ex) {
			Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
