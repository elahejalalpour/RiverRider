/*
 * In The Name Of God
 * ========================================
 * [] File Name : missiles.java
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

import java.util.logging.Level;
import java.util.logging.Logger;

public class missiles implements Runnable {

	public int xLocation;
	public int ylLocation;
	public int i;
	private boolean isAlive = true;

	public missiles(int xLocation, int yLocation) {
		isAlive = true;
		this.xLocation = xLocation;
		ylLocation = yLocation - 1;
		i = 0;
		Drawing.m[this.xLocation][ylLocation] = 1;
	}

	@Override
	public void run() {
		try {
			if (isAlive) {
				for (int a = 0; a < 11; a++) {
					if (ylLocation < 10 && ylLocation >= 0) {
						synchronized (this) {
							Thread.sleep(75);
						}
						ylLocation -= 1;
					} else {
						isAlive = false;
					}
				}

			}
		} catch (InterruptedException ex) {
			Logger.getLogger(missiles.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
