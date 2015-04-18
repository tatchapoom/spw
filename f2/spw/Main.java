package f2.spw;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args){
		JFrame frame = new JFrame("Space War");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 650);
		frame.getContentPane().setLayout(new BorderLayout());
		SpaceShip v = new SpaceShip(200, 570, 20, 20);
		//Random rand = new Random();
		//int  n = rand.nextInt(7) + 1;
		//if(n == 1)
		//SpaceShip v = new SpaceShip(120, 490, 20, 20);
		//if(n == 2)
		//SpaceShip v = new SpaceShip(130, 500, 20, 20);
		//if(n == 3)
		//SpaceShip v = new SpaceShip(140, 510, 20, 20);
		//if(n == 4)
		//SpaceShip v = new SpaceShip(150, 520, 20, 20);
		//if(n == 5)
		//SpaceShip v = new SpaceShip(160, 530, 20, 20);
		//if(n == 6)
		//SpaceShip v = new SpaceShip(170, 540, 20, 20);
		//if(n == 7)
		//SpaceShip v = new SpaceShip(180, 550, 20, 20);
		GamePanel gp = new GamePanel();
		GameEngine engine = new GameEngine(gp, v);
		frame.addKeyListener(engine);
		frame.getContentPane().add(gp, BorderLayout.CENTER);
		frame.setVisible(true);
		
		engine.start();
	}
}
