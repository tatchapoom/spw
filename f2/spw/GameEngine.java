package f2.spw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimerTask;
import javax.swing.Timer;


public class GameEngine implements KeyListener, GameReporter{
	GamePanel gp;
		
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
        private ArrayList<Weapon> weapon = new ArrayList<Weapon>();
	private SpaceShip v;	
	
	private Timer timer;
	private int life = 9;
	private long score = 0;
	private double difficulty = 0.2;
	
	public GameEngine(GamePanel gp, SpaceShip v) {
		this.gp = gp;
		this.v = v;		
		
		gp.sprites.add(v);
		
		timer = new Timer(50, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				process();
                                createWeapon();
			}
		});
		timer.setRepeats(true);
		
	}
	
	public void start(){
		timer.start();
	}
	
	private void generateEnemy(){
		Enemy e = new Enemy((int)(Math.random()*400), 0);
		gp.sprites.add(e);
		enemies.add(e);
	}
	
	private void process(){
		if(Math.random() < difficulty){
			generateEnemy();
		}
		
		Iterator<Enemy> e_iter = enemies.iterator();
		while(e_iter.hasNext()){
			Enemy e = e_iter.next();
			e.proceed();
			
			if(!e.isAlive()){
				e_iter.remove();
				gp.sprites.remove(e);
				score += 100;
			}
		}
		
                Iterator<Weapon> weapon_iter = weapon.iterator();
		while(weapon_iter.hasNext()){
			Weapon b = weapon_iter.next();
			b.proceed();
			if(!b.isAlive()){
				weapon_iter.remove();
				gp.sprites.remove(b);
				weapon.remove(b);
			}
		}

		gp.updateGameUI(this);
		
		Rectangle2D.Double vr = v.getRectangle();
		Rectangle2D.Double er;
		for(Enemy e : enemies){
			er = e.getRectangle();
			if(er.intersects(vr)){
				System.out.print(" 1 "); 
				life--;
				die();
				return;
			}
			else System.out.print(" 9 "); 
		}
	}
	
	public void die(){
		System.out.print(" 2 "); 
		if(life == 0){
			timer.stop();
		}
	}
	
	void controlVehicle(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			v.move(-1);
			break;
		case KeyEvent.VK_RIGHT:
			v.move(1);
			break;
		case KeyEvent.VK_D:
			difficulty += 0.1;
			break;
		}
	}

	public long getScore(){
		System.out.print(" 4 "); 
		return score;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		controlVehicle(e);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//do nothing
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//do nothing		
	}
        public long lifeScore(){
		System.out.print(" 7 "); 
		return life;
	}
        private void createWeapon(){
		Weapon h1 = new Weapon( this.v.x + (this.v.width/2) - 1,this.v.y);
                gp.sprites.add(h1);
		weapon.add(h1);
	}
}
