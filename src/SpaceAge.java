import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class SpaceAge extends JComponent implements ActionListener, KeyListener
{
	Image background;
	Image planet1;
	Image planet2;
	Image planet3;
	Image planet4;
	Image planet5;
	Image planet6;
	Image planet7;
	Image spaceShip;
	int spaceX = 1280/2;
	int spaceY = 719/2;
	public SpaceAge() throws IOException
	{
		background = ImageIO.read(getClass().getResource("stars.jpg"));
		planet1 = ImageIO.read(getClass().getResource("planet1.jpg"));
		planet2 = ImageIO.read(getClass().getResource("planet2.jpg"));
		planet3 = ImageIO.read(getClass().getResource("planet3.jpg"));
		planet4 = ImageIO.read(getClass().getResource("planet4.jpg"));
		planet5 = ImageIO.read(getClass().getResource("planet5.jpg"));
		planet6 = ImageIO.read(getClass().getResource("planet6.jpg"));
		planet7 = ImageIO.read(getClass().getResource("planet7.jpg"));
		spaceShip = ImageIO.read(getClass().getResource("spaceShip.jpg"));
	}
	public static void main(String[] args) throws IOException
	{
		JFrame window = new JFrame("Space Age Colonization");
		SpaceAge game = new SpaceAge();
		window.add(game);
		window.addKeyListener(game);
		window.pack();
		window.setVisible(true);
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Timer time = new Timer(50, game);
		time.start();
	}
	@Override
	public Dimension getPreferredSize()
	{
		return new Dimension(1280, 719);
	}
	@Override
	public void paint(Graphics g)
	{
		g.fillRect(100, 100, 100, 100);
		g.drawImage(background, 0, 0, null);
		g.drawImage(planet1, 100, 100, null);
		g.drawImage(planet2, 300, 300, null);
		g.drawImage(spaceShip, spaceX, spaceY, null);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		repaint();
	}
	@Override
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			spaceY -= 5;
		} 
		else if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			spaceY += 5;
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			spaceX += 5;
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			spaceX -= 5;
		}
	}
	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}
}
