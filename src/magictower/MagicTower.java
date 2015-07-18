package magictower;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MagicTower extends JFrame{
    private static final long serialVersionUID = -8811509889301673404L;
    private int life = 0, attack = 0, defence = 0, goldCoins = 0, expValue = 0;
	private int yellowKeys = 0, redKeys = 0, blueKeys = 0;
    public MagicTower() {
		setTitle("Magic Tower");
		
		JPanel mapPanel = new MapPanel();
		mapPanel.setPreferredSize(new Dimension(600, 600));
		mapPanel.setBackground(Color.PINK);
		
		JPanel showPanel = new JPanel(new BorderLayout());
		showPanel.setPreferredSize(new Dimension(200, 600));
		showPanel.setBackground(Color.BLACK);
	
		JPanel infoPanel = new InfoPanel();
		infoPanel.setBackground(Color.BLUE);
		infoPanel.setPreferredSize(new Dimension(200, 300));
		showPanel.add(infoPanel, BorderLayout.NORTH);
		
		JPanel keysPanel = new KeyPanel();
		keysPanel.setBackground(Color.GRAY);
		keysPanel.setPreferredSize(new Dimension(200, 300));
		showPanel.add(keysPanel, BorderLayout.CENTER);
		
		getContentPane().add(mapPanel, BorderLayout.CENTER);
		getContentPane().add(showPanel, BorderLayout.WEST);
		Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((scr.width-getWidth())/2,(scr.height - getHeight())/2);
		pack();
		setSize(800, 600);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	class InfoPanel extends JPanel{
        private static final long serialVersionUID = -3588770634829261104L;
		private BufferedImage bi = new BufferedImage(200, 300, BufferedImage.TYPE_INT_RGB);
		@Override
		public void paint(Graphics g) {
			Graphics gb = bi.getGraphics();
			gb.setColor(Color.BLUE);
			gb.fillRect(0, 0, getWidth(), getHeight());
			gb.setColor(Color.GREEN);
			gb.drawString("Name:" + "Hero",20, 50);
			gb.drawString("Hero",100, 50);
			
			gb.drawString("life:",20, 90);
			gb.drawString(life + "",100, 90);

			gb.drawString("Attack:",20, 130);
			gb.drawString(attack + "",100, 130);

			gb.drawString("Defence:",20, 170);
			gb.drawString(defence + "",100, 170);

			gb.drawString("GoldCoins:",20, 210);
			gb.drawString(goldCoins + "",100, 210);

			gb.drawString("ExpValue:",20, 250);
			gb.drawString(expValue + "",100, 250);

			g.drawImage(bi, 0, 0, null);
		}
		@Override
		public void update(Graphics g) {
		   paint(g);
		}
	}
	class MapPanel extends JPanel{
        private static final long serialVersionUID = -9161916079540390757L;
       // private BufferedImage bi = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);
		@Override
		public void paint(Graphics g) {
			g.setColor(Color.GRAY);
			g.fillRect(0, 0, getWidth(), getHeight());
        }
		@Override
		public void update(Graphics g) {
			paint(g);
		}
	}
	class KeyPanel extends JPanel{
        private static final long serialVersionUID = -7965082869055191104L;
        private BufferedImage bi = new BufferedImage(200, 300, BufferedImage.TYPE_INT_RGB);
		@Override
		public void paint(Graphics g) {
			Graphics gb = bi.getGraphics();
			gb.setColor(Color.PINK);
			gb.fillRect(0, 0, getWidth(), getHeight());
			gb.setColor(Color.BLACK);
			gb.drawString("YellowKey:",20, 50);
			gb.drawString(yellowKeys + "",100, 50);

			gb.drawString("BlueKey:",20, 90);
			gb.drawString("" + blueKeys,100, 90);

			gb.drawString("RedKey:",20, 130);
			gb.drawString("" + redKeys,100, 130);

			g.drawImage(bi, 0, 0, null);
		}
		@Override
		public void update(Graphics g) {
		    paint(g);
		}
	}
	public static void main(String[] args) {
	    new MagicTower();
    }
}
