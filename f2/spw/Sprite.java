package f2.spw;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.Random;

public abstract class Sprite {
	int x;
	int y;
	int width;
	int height;
	
	public Sprite(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		
		Random rand = new Random();
		int  n = rand.nextInt(7) + 1;
		if(n == 1)
		this.width = 5;
		this.height = 5;
		if(n == 2)
		this.width = 10;
		this.height = 10;
		if(n == 3)
		this.width = 15;
		this.height = 15;
		if(n == 4)
		this.width = 20;
		this.height = 20;
		if(n == 5)
		this.width = 25;
		this.height = 25;
		if(n == 6)
		this.width = 30;
		this.height = 30;
		if(n == 7)
		this.width = width;
		this.height = height;
	}

	abstract public void draw(Graphics2D g);
	
	public Double getRectangle() {
		return new Rectangle2D.Double(x, y, width, height);
	}
}
