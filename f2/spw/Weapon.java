/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f2.spw;

/**
 *
 * @author TSD
 */
import java.awt.Color;
import java.awt.Graphics2D;

public class Weapon extends Sprite{
	public static final int Y_TO_DIE = 10;
	
	private int step = 10;
	private boolean alive= true;
	
	public Weapon(int x, int y) {
		super(x, y, 1, 3);
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.BLUE);
		g.fillOval(x, y, width, height);
	}

	public void proceed(){
		y -= step;
		if(y <= Y_TO_DIE){
			alive = false;
		}
	}
	
	public boolean isAlive(){
		return alive;
	}
	
	public void isDie(){
		alive = false;
	}
}
