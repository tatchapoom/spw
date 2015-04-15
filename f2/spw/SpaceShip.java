package f2.spw;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class SpaceShip extends Sprite{

	int step = 8;
	
	public SpaceShip(int x, int y, int width, int height) {
		super(x, y, width, height);
		
	}

	@Override
	public void draw(Graphics2D g) {
	if(n == 1)
			g.setColor(Color.RED);
		if(n == 2)
			g.setColor(Color.YELLOW);
		if(n == 3)
			g.setColor(Color.GREEN);
		if(n == 4)
			g.setColor(Color.PINK);
		if(n == 5)
			g.setColor(Color.ORANGE);
		if(n == 6)
			g.setColor(Color.WHITE);
		if(n == 7)
			g.setColor(Color.BLUE);
	g.fillRect(x, y, width, height);
		
	}

	Random rand = new Random();
	int  n = rand.nextInt(7) + 1;

	public void move(int direction){
		x += (step * direction);
		if(x < 0)
			x = 0;
		if(x > 400 - width)
			x = 400 - width;
	}

}
