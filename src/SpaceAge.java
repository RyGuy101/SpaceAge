import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.WindowConstants;

/*
 * 5/25/13
 */
public class SpaceAge extends JComponent implements ActionListener, KeyListener
{
	Image background;
	Image livablePlanet;
	Image planet0;
	Image planet1;
	Image planet2;
	Image planet3;
	Image planet4;
	Image planet5;
	Image spaceShip;
	int width = Toolkit.getDefaultToolkit().getScreenSize().width - 20;
	int height = width/2;
	int spaceX = width/2;
	int spaceY = height/2;
	boolean up = false;
	boolean down = false;
	boolean right = false;
	boolean left = false;
	int theXFactor = 0;
	int speed = height/60;
	int length = 10;
	boolean laserRelease = true;
	boolean laserPress = false;
	ArrayList<Integer> laserX = new ArrayList<Integer>();
	ArrayList<Integer> laserY = new ArrayList<Integer>();
	ArrayList<Integer> laserD = new ArrayList<Integer>();
	int[] randomX = {(int) (Math.random() * (width * length - height/2)), (int) (Math.random() * (width * length - height/2)), (int) (Math.random() * (width * length - height/2)), (int) (Math.random() * (width * length - height/2)), (int) (Math.random() * (width * length - height/2)), (int) (Math.random() * (width * length - height/2)), (int) (Math.random() * (width * length - height/2)), (int) (Math.random() * (width * length - height/2)), (int) (Math.random() * (width * length - height/2)), (int) (Math.random() * (width * length - height/2))};
	int[] randomY = {(int) (Math.random() * (height - height/4)), (int) (Math.random() * (height - height/4)), (int) (Math.random() * (height - height/4)), (int) (Math.random() * (height - height/4)), (int) (Math.random() * (height - height/4)), (int) (Math.random() * (height - height/4)), (int) (Math.random() * (height - height/4)), (int) (Math.random() * (height - height/4)), (int) (Math.random() * (height - height/4)), (int) (Math.random() * (height - height/4))};
	int[] randomP = {(int) (Math.random() * 5), (int) (Math.random() * 5), (int) (Math.random() * 5), (int) (Math.random() * 5), (int) (Math.random() * 5), (int) (Math.random() * 5), (int) (Math.random() * 5), (int) (Math.random() * 5), (int) (Math.random() * 5), (int) (Math.random() * 5)};
	
	public SpaceAge() throws IOException
	{
		background = ImageIO.read(getClass().getResource("stars.png")).getScaledInstance(-1, height/2, 0);
		livablePlanet = ImageIO.read(getClass().getResource("planet1.jpg")).getScaledInstance(height/4, height/4, 0);
		planet0 = ImageIO.read(getClass().getResource("planet2.jpg")).getScaledInstance(height/4, height/4, 0);
		planet1 = ImageIO.read(getClass().getResource("planet3.jpg")).getScaledInstance(height/4, height/4, 0);
		planet2 = ImageIO.read(getClass().getResource("planet4.jpg")).getScaledInstance(height/4, height/4, 0);
		planet3 = ImageIO.read(getClass().getResource("planet5.jpg")).getScaledInstance(height/4, height/4, 0);
		planet4 = ImageIO.read(getClass().getResource("planet6.jpg")).getScaledInstance(height/4, height/4, 0);
		planet5 = ImageIO.read(getClass().getResource("planet7.jpg")).getScaledInstance(height/4, height/4, 0);
		spaceShip = ImageIO.read(getClass().getResource("spaceShip.jpg")).getScaledInstance(height/4, -1, 0);
		spaceX -= spaceShip.getWidth(null)/2;
		spaceY -= spaceShip.getHeight(null)/2;
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
		return new Dimension(width, height);
	}
	@Override
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			up = true;
		} 
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			down = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			right = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			left = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE && laserRelease == true)
		{
			laserPress = true;
			laserRelease = false;
		}
	}
	@Override
	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			up = false;
		} 
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			down = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			right = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			left = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) 
		{
			laserRelease = true;
		}
	}
	@Override
	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void paint(Graphics g)
	{
		//moving controls
		if (up) 
		{
			if (spaceY > 0) 
			{
				spaceY -= speed;
			}
		}
		if (down) 
		{
			if (spaceY < height - spaceShip.getHeight(null)) 
			{
				spaceY += speed;
			}
		}
		if (right) 
		{
			if (spaceX < width * length - spaceShip.getWidth(null))
			{
				spaceX += speed;
			}
			if (spaceX >= width/2 - spaceShip.getWidth(null)/2 && theXFactor <  width * (length-1))
			{
				theXFactor += speed;
			}
		}
		if (left) 
		{
			if (spaceX > 0) 
			{
				spaceX -= speed;
			}
			if (theXFactor > 0 && spaceX <= width/2 - spaceShip.getWidth(null)/2 + theXFactor) 
			{
				theXFactor -= speed;
			}
		}
		//background
		for (int i = 0; i < 2; i++) 
		{
			for (int j = 0; j < 4 * length + 1; j++) 
			{
				g.drawImage(background, (background.getWidth(null) * j) - theXFactor, (background.getHeight(null) * i), null);
			}
		}
		//planets
		for (int i = 0; i < 10; i++) 
		{
			if (randomP[i] == 0) 
			{
				g.drawImage(planet0, randomX[i] - theXFactor, randomY[i], null);
			}
			else if (randomP[i] == 1) 
			{
				g.drawImage(planet1, randomX[i] - theXFactor, randomY[i], null);
			}
			else if (randomP[i] == 2) 
			{
				g.drawImage(planet2, randomX[i] - theXFactor, randomY[i], null);
			}
			else if (randomP[i] == 3) 
			{
				g.drawImage(planet3, randomX[i] - theXFactor, randomY[i], null);
			}
			else if (randomP[i] == 4) 
			{
				g.drawImage(planet4, randomX[i] - theXFactor, randomY[i], null);
			}
			else if (randomP[i] == 5) 
			{
				g.drawImage(planet5, randomX[i] - theXFactor, randomY[i], null);
			}
		}
		g.drawImage(livablePlanet, width * length - livablePlanet.getWidth(null) - theXFactor, height/2 - livablePlanet.getHeight(null)/2, null);
		//laser
		if (laserPress == true) 
		{
			laserPress = false;
			laserX.add(new Integer(spaceX + spaceShip.getWidth(null)));
			laserY.add(spaceY + spaceShip.getHeight(null)/2);
			laserD.add(new Integer(0));
		}
		for (int i = laserX.size() - 1; i >= 0; i--) 
		{
			if (laserX.get(i) - theXFactor >= width && laserD.get(i) >= width/2 - spaceShip.getWidth(null)/2) 
			{
				laserX.remove(i);
				laserY.remove(i);
			} 
			else
			{
				g.setColor(Color.RED);
				g.fillRect(laserX.get(i) - theXFactor, laserY.get(i), height/80, height/200);
				laserX.set(i, laserX.get(i) + speed * 4);
				laserD.set(i, laserD.get(i) + speed * 4);
			}
		}
		//space ship
		g.drawImage(spaceShip, spaceX - theXFactor, spaceY, null);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		repaint();
	}
}
