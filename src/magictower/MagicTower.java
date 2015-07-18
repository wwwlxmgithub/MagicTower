package magictower;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
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
			gb.setFont(new Font("幼圆", Font.PLAIN, 15));
			gb.drawString("姓名:",20, 50);
			gb.drawString("Hero",100, 50);
			
			gb.drawString("生命值:",20, 90);
			gb.drawString(life + "",100, 90);

			gb.drawString("攻击:",20, 130);
			gb.drawString(attack + "",100, 130);

			gb.drawString("防御:",20, 170);
			gb.drawString(defence + "",100, 170);

			gb.drawString("金币:",20, 210);
			gb.drawString(goldCoins + "",100, 210);

			gb.drawString("经验:",20, 250);
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
        private BufferedImage[][] pics = new BufferedImage[11][11];
        private Graphics gra;
       // private BufferedImage bi = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);
        public MapPanel() {
        	loadPics();
        }
		@Override
		public void paint(Graphics g) {
			g.setColor(Color.GRAY);
			g.fillRect(0, 0, getWidth(), getHeight());
			//System.out.println("w = " + getWidth());
			//System.out.println("h = " + getHeight());
			int bwidth =  pics[0][0].getWidth(), bheight = pics[0][0].getHeight(); 
			int brickNum = getWidth() / bwidth;
			//画砖块
			for(int i = 0; i <= brickNum; i++){
				for(int j = 0; j <= brickNum; j++){
					drawBrick(g, pics[0][0], i * bwidth, j * bheight);
				}
			}
        }
		@Override
		public void update(Graphics g) {
			paint(g);
		}
		private void loadPics(){
			try {
				for(int i = 0; i < 2; i++){
					for(int j = 0; j < 11; j++){
						pics[i][j] = ImageIO.read(getClass().getClassLoader().getResourceAsStream("pic/brick1.jpg"));
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		private void drawBrick(Graphics g, BufferedImage bi, int x, int y){
			g.drawImage(bi, x, y, bi.getWidth(), bi.getHeight(), null);
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
			gb.setColor(Color.BLUE);
			gb.setFont(new Font("幼圆", Font.PLAIN, 15));
			gb.drawString("黄钥匙:",20, 50);
			gb.drawString(yellowKeys + "",100, 50);

			gb.drawString("蓝钥匙:",20, 90);
			gb.drawString("" + blueKeys,100, 90);

			gb.drawString("红钥匙:",20, 130);
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
