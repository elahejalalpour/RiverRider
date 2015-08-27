/*
 * In The Name Of God
 * ========================================
 * [] File Name : Frame.java
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
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Frame extends JFrame implements KeyListener, ActionListener {

	private JSlider diameterJSlider;
	int[][] map = new int[7][1000];
	int[][] setplane = new int[7][1000];
	int[][] mis = new int[7][11];
	JPanel p = new JPanel();
	JButton stop = new JButton("stop");
	JButton pause = new JButton("pause");
	Drawing r;
	GridLayout b = new GridLayout(1, 2, 1, 1);
	JLabel l = new JLabel("enemy Down:    ");
	JLabel li = new JLabel("enemy Missed:    ");
	JLabel lii = new JLabel("         empty                                      half full                                                      full                          ");
	JLabel liii = new JLabel("                                      ");
	JPanel j = new JPanel();
	JPanel ja = new JPanel();
	JPanel jaa = new JPanel();
	JTextField f = new JTextField(2);
	JTextField fa = new JTextField(2);
	Manager manager;

	public Frame(int[][] map, int[][] setplane, Manager manager) {
		diameterJSlider = new JSlider();
		this.manager = manager;
		setVisible(false);
		setSize(900, 640);
		this.map = map;
		this.setplane = setplane;
		r = new Drawing(this.map, this.setplane);
		r.repaint();
		r.setSize(600, 640);
		setLayout(b);
		add(r);
		stop.setFocusable(false);
		stop.setBackground(Color.yellow);
		pause.setFocusable(false);
		pause.setBackground(Color.yellow);
		f.setFocusable(false);
		fa.setFocusable(false);
		diameterJSlider.setFocusable(false);
		p.setSize(100, 100);
		p.setBackground(Color.blue);
		BorderLayout pa = new BorderLayout();
		p.setLayout(pa);
		j.setLayout(new GridLayout(3, 1, 1, 1));
		j.add(diameterJSlider);
		j.add(liii);
		j.add(lii);
		p.add(j, BorderLayout.NORTH);
		ja.setLayout(new GridLayout(3, 2, 10, 200));
		ja.add(l);
		ja.add(fa);
		ja.add(liii);
		ja.add(li);
		ja.add(f);
		ja.add(liii);
		p.add(ja, BorderLayout.CENTER);
		jaa.setLayout(new GridLayout(2, 2, 20, 20));
		jaa.add(stop);
		jaa.add(pause);
		jaa.add(liii);
		jaa.add(liii);
		p.add(jaa, BorderLayout.SOUTH);
		this.addKeyListener(this);

		Component add = add(p);
		setVisible(true);

		stop.addActionListener(this);
		pause.addActionListener(this);
	}

	public void setfuel() {
		diameterJSlider.setValue(Manager.fuel);
	}

	public void setenemy() {
		f.setText("" + Manager.enemy);
	}

	public void setenemymissed() {
		fa.setText("" + Drawing.enemyl);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == 36) {
			if (Drawing.he < 7 && Drawing.he > 0) {
				Drawing.he--;
			}
		}

		if (e.getKeyChar() == 39) {
			if (Drawing.he < 6 && Drawing.he >= 0) {
				Drawing.he++;
			}
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == e.VK_LEFT) {
			if (Drawing.he < 7 && Drawing.he > 0) {
				Drawing.he--;
			} else {
			}
		}

		if (e.getKeyCode() == e.VK_RIGHT) {
			if (Drawing.he < 6 && Drawing.he >= 0) {
				Drawing.he++;
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == stop) {
			map[1][Drawing.k - 2] = 9;
		} else if (e.getSource() == pause) {
			Manager.isRun = !Manager.isRun;
		}
	}
}
