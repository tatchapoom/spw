package f2.spw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.Toolkit;
import java.awt.Image;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
	
	private BufferedImage bi;
        private Image imgbg;	
	Graphics2D big;
	ArrayList<Sprite> sprites = new ArrayList<Sprite>();

	public GamePanel() {
		bi = new BufferedImage(400, 600, BufferedImage.TYPE_INT_ARGB);
		big = (Graphics2D) bi.getGraphics();
		//big.setBackground(Color.WHITE);
                imgbg = Toolkit.getDefaultToolkit().getImage("C:/Users/TSD/Documents/GitHub/spw/f2/spw/img/bg.jpg");
		big.drawImage(imgbg, 0, 0, 400, 600,null);
		
	}

	public void updateGameUI(GameReporter reporter){
		big.clearRect(0, 0, 400, 600);
		big.drawImage(imgbg, 0, 0, 400, 600,null);
		big.setColor(Color.RED);		
		big.drawString(String.format("Score = %08d", reporter.getScore()), 280, 20);
                big.drawString(String.format("Life Point = %d", reporter.lifeScore()/3), 200, 20);
                
                
		for(Sprite s : sprites){
			s.draw(big);
		}
		
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(bi, null, 0, 0);
	}

}
