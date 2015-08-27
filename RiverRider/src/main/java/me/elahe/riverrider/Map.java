/*
 * In The Name Of God
 * ========================================
 * [] File Name : Map.java
 *
 * [] Creation Date : 27-08-2015
 *
 * [] Created By : Elahe Jalalpour (el.jalalpour)
 * =======================================
*/
/**
 * @author Elahe Jalalpour
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.elahe.riverrider;

/**
 *
 * @elahe
 */
public class Map {

    public int[][] map;
    public int[][] planeslist;
    public static int[][] missiles;

    public Map() {
        map = new int[7][1000];
        planeslist = new int[7][1000];
        missiles = new int[7][10];


    }

    public void setMap() {
        int i;
        int j;
        for (i = 0; i < 7; i++) {
            for (j = 0; j < 1000; j++) {
                switch (i) {
                    case 0:
                    case 1:
                        map[i][j] = 0;
                        break;
                    case 2:
                    case 3:
                    case 4:
                        map[i][j] = 1;
                        break;
                    case 5:
                    case 6:
                        map[i][j] = 0;
                        break;
                }
            }
        }
    }

    public void setPlanes() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 1000; j++) {
                switch ((int) (Math.random() * 50)) {

                    case 4:
                        planeslist[i][j] = 1;
                        break;
                    case 5:
                        planeslist[i][j] = 2;
                        break;
                    default:
                        planeslist[i][j] = 0;
                }

            }
        }
    }
}
