package magictower;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MagicTower extends JFrame{
    private static final long serialVersionUID = -8811509889301673404L;
	public MagicTower() {
		Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((scr.width-getWidth())/2,(scr.height - getHeight())/2);
		setSize(200, 400);
		setResizable(false);
		/*setForeground(SystemColor.inactiveCaption);
		// setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setType(Type.UTILITY);
		getContentPane().setLayout(new BorderLayout(0, 0));
		Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((scr.width-getWidth())/2,(scr.height - getHeight())/2);
		setSize(400, 600);
		JTextField name = new JTextField("nnnnnn");
		
		name.setBackground(Color.blue);
		name.setForeground(Color.cyan);
		name.setSize(180, 250);
		getContentPane().add(name, BorderLayout.WEST);
		JTextField info = new JTextField("hhhhh");
		info.setBackground(Color.blue);
		info.setForeground(Color.cyan);
		info.setSize(180, 250);
		getContentPane().add(info, BorderLayout.WEST);
		JTextField map = new JTextField("iiiiii");
		map.setBackground(Color.blue);
		map.setForeground(Color.cyan);
		map.setSize(360, 500);
		getContentPane().add(map, BorderLayout.EAST);*/
		JPanel a = new JPanel();
		a.setBackground(Color.cyan);
		JLabel l = new JLabel();
		l.setText("aaaa");
		a.add(l);
		//a.setSize(200, 200);
		JPanel b = new JPanel();
		b.setBackground(Color.blue);
		
		//b.setSize(100, 200);
		getContentPane().add(b, BorderLayout.WEST);
		getContentPane().add(a, BorderLayout.CENTER);
		JPanel bbb = new JPanel();
		bbb.setBackground(Color.gray);
		JLabel l1 = new JLabel();
		l1.setText("bbbb");
		bbb.add(l1);
		
		JPanel bb = new JPanel();
		bb.setBackground(Color.green);
		b.add(bb, BorderLayout.SOUTH);
		b.add(bbb, BorderLayout.NORTH);
		//getContentPane().add(a, BorderLayout.NORTH);
		pack();
		
		setVisible(true);
		//setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	public static void main(String[] args) {
	    new MagicTower();
    }
}
