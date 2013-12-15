import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.WindowConstants;

/*
 * 12/14/13
 * Updated BOOM!
 */
public class SpaceAge extends JComponent implements ActionListener, KeyListener
{
	static SpaceAge game;
	static JFrame window = new JFrame("Space Age Colonization");
	static Timer time;
	Image background;
	Image livablePlanet;
	Image planet0;
	Image planet1;
	Image planet2;
	Image planet3;
	Image planet4;
	Image planet5;
	Image spaceShip;
	Image boom;
	int width = Toolkit.getDefaultToolkit().getScreenSize().width - 20;
	int height = width / 2;
	int spaceX = width / 2;
	int spaceY = height / 2;
	int boomX;
	int boomY;
	int numOfPlanets = 20;
	boolean up = false;
	boolean down = false;
	boolean right = false;
	boolean left = false;
	boolean intersectPlan = true;
	int theXFactor = 0;
	int speed = height / 70;
	int length = 5;
	boolean laserRelease = true;
	boolean laserPress = false;
	boolean start = true;
	ArrayList<Integer> laserX = new ArrayList<Integer>();
	ArrayList<Integer> laserY = new ArrayList<Integer>();
	ArrayList<Integer> laserD = new ArrayList<Integer>();
	ArrayList<Integer> randomX = new ArrayList<Integer>();
	ArrayList<Integer> randomY = new ArrayList<Integer>();
	ArrayList<Integer> randomP = new ArrayList<Integer>();
	ArrayList<Ellipse2D> planets = new ArrayList<Ellipse2D>();
	int drawBoom = 0;
	boolean die = false;

	public SpaceAge() throws IOException
	{
		background = ImageIO.read(getClass().getResource("stars.png")).getScaledInstance(-1, (int) (height / 2.0), 0);
		livablePlanet = ImageIO.read(getClass().getResource("planet1.jpg")).getScaledInstance((int) (height / 4.0), (int) (height / 4.0), 0);
		planet0 = ImageIO.read(getClass().getResource("planet2.jpg")).getScaledInstance((int) (height / 4.0), (int) (height / 4.0), 0);
		planet1 = ImageIO.read(getClass().getResource("planet3.jpg")).getScaledInstance((int) (height / 4.0), (int) (height / 4.0), 0);
		planet2 = ImageIO.read(getClass().getResource("planet4.jpg")).getScaledInstance((int) (height / 4.0), (int) (height / 4.0), 0);
		planet3 = ImageIO.read(getClass().getResource("planet5.jpg")).getScaledInstance((int) (height / 4.0), (int) (height / 4.0), 0);
		planet4 = ImageIO.read(getClass().getResource("planet6.jpg")).getScaledInstance((int) (height / 4.0), (int) (height / 4.0), 0);
		planet5 = ImageIO.read(getClass().getResource("planet7.jpg")).getScaledInstance((int) (height / 4.0), (int) (height / 4.0), 0);
		spaceShip = ImageIO.read(getClass().getResource("spaceShip.jpg")).getScaledInstance((int) (height / 4.0), -1, 0);
		boom = ImageIO.read(getClass().getResource("boom.png")).getScaledInstance((int) (spaceShip.getWidth(null) * 1.2), -1, 0);
		spaceX -= spaceShip.getWidth(null) / 2;
		spaceY -= spaceShip.getHeight(null) / 2;
	}

	public static void main(String[] args) throws IOException
	{
		game = new SpaceAge();
		window.add(game);
		window.addKeyListener(game);
		window.pack();
		window.setVisible(true);
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		time = new Timer(42, game);
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
		if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W)
		{
			up = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S)
		{
			down = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D)
		{
			right = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A)
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
		if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W)
		{
			up = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S)
		{
			down = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D)
		{
			right = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A)
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
	}

	@Override
	public void paint(Graphics g)
	{
		width = window.getWidth();
		height = width / 2;
		// moving controls
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
			if (spaceX >= width / 2 - spaceShip.getWidth(null) / 2 && theXFactor < width * (length - 1))
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
			if (theXFactor > 0 && spaceX <= width / 2 - spaceShip.getWidth(null) / 2 + theXFactor)
			{
				theXFactor -= speed;
			}
		}
		boomX = (int) (spaceX - spaceShip.getWidth(null) * 0.15);
		boomY = spaceY - boom.getHeight(null) / 2 + spaceShip.getHeight(null) / 2;
		// background
		for (int i = 0; i < 2; i++)
		{
			for (int j = 0; j < 4 * length + 1; j++)
			{
				g.drawImage(background, (background.getWidth(null) * j) - theXFactor / 2, (background.getHeight(null) * i), null);
			}
		}
		// stuff to do at very start
		if (start)
		{
			start = false;
			// set planet positions
			for (int i = 0; i < numOfPlanets; i++)
			{
				randomX.add((int) (Math.random() * (width * length - height / 2 - width / 2 - spaceShip.getWidth(null) / 2)));
				randomY.add((int) (Math.random() * (height - height / 4)));
				randomP.add((int) (Math.random() * 5));
			}
			while (intersectPlan)
			{
				intersectPlan = false;
				for (int i = 0; i < numOfPlanets - 1; i++)
				{
					for (int j = i + 1; j < numOfPlanets; j++)
					{
						if (randomX.get(j) - randomX.get(i) < height / 4 + spaceShip.getWidth(null) && randomY.get(j) - randomY.get(i) < height / 4 + spaceShip.getHeight(null) && randomX.get(j) - randomX.get(i) > (height / 4 + spaceShip.getWidth(null)) * -1 && randomY.get(j) - randomY.get(i) > (height / 4 + spaceShip.getHeight(null)) * -1)
						{
							randomX.set(j, (int) (Math.random() * (width * length - height / 2 - width / 2 - spaceShip.getWidth(null) / 2)));
							randomY.set(j, (int) (Math.random() * (height - height / 4)));
							intersectPlan = true;
						}
					}
				}
			}
			for (int i = 0; i < numOfPlanets; i++)
			{
				planets.add(new Ellipse2D.Double(randomX.get(i) + width / 2 + spaceShip.getWidth(null) / 2, randomY.get(i), planet0.getWidth(null), planet0.getHeight(null)));
			}
		}
		// paint the planets
		for (int i = 0; i < numOfPlanets; i++)
		{
			int X = randomX.get(i) + width / 2 + spaceShip.getWidth(null) / 2 - theXFactor;
			int Y = randomY.get(i);
			if (randomP.get(i) == 0)
			{
				g.drawImage(planet0, X, Y, null);
			} else if (randomP.get(i) == 1)
			{
				g.drawImage(planet1, X, Y, null);
			} else if (randomP.get(i) == 2)
			{
				g.drawImage(planet2, X, Y, null);
			} else if (randomP.get(i) == 3)
			{
				g.drawImage(planet3, X, Y, null);
			} else if (randomP.get(i) == 4)
			{
				g.drawImage(planet4, X, Y, null);
			} else if (randomP.get(i) == 5)
			{
				g.drawImage(planet5, X, Y, null);
			}
			// g.fillOval((int) planets.get(i).getX() - theXFactor, (int) planets.get(i).getY(), (int) planets.get(i).getWidth(), (int) planets.get(i).getHeight());
		}
		g.drawImage(livablePlanet, width * length - livablePlanet.getWidth(null) - theXFactor, height / 2 - livablePlanet.getHeight(null) / 2, null);
		// laser
		if (laserPress == true)
		{
			laserPress = false;
			laserX.add(new Integer(spaceX + spaceShip.getWidth(null)));
			laserY.add(spaceY + spaceShip.getHeight(null) / 2);
			laserD.add(new Integer(0));
		}
		for (int i = laserX.size() - 1; i >= 0; i--)
		{
			for (int j = 0; j < planets.size(); j++) // Work on this part!!!
			{
				if (i >= laserX.size())
				{
					i = laserX.size() - 1;
				}
				if (laserX.size() > 0)
				{
					if (planets.get(j).intersects(laserX.get(i), laserY.get(i), (int) (height / 80.0), (int) (height / 200.0)))
					{
						laserX.remove(i);
						laserY.remove(i);
					}
				}
			}
			if (laserX.size() > 0)
			{
				if (laserX.get(i) - theXFactor >= width && laserD.get(i) >= width / 2 - spaceShip.getWidth(null) / 2)
				{
					laserX.remove(i);
					laserY.remove(i);
				} else
				{
					g.setColor(Color.RED);
					g.fillRect(laserX.get(i) - theXFactor, laserY.get(i), (int) (height / 80.0), (int) (height / 200.0));
					laserX.set(i, laserX.get(i) + speed * 4);
					laserD.set(i, laserD.get(i) + speed * 4);
				}
			}
		}
		// space ship
		g.drawImage(spaceShip, spaceX - theXFactor, spaceY, null);
		die = false;
		for (int i = 0; i < numOfPlanets; i++)
		{
			// In testing
			// if (spaceX + spaceShip.getWidth(null) > randomX.get(i) + width/2 + spaceShip.getWidth(null)/2 && spaceX < randomX.get(i) + width/2 + spaceShip.getWidth(null)/2 + planet0.getWidth(null) && spaceY + spaceShip.getHeight(null) > randomY.get(i) && spaceY < randomY.get(i) + planet0.getHeight(null)) {
			if (planets.get(i).intersects(spaceX + spaceShip.getWidth(null) / 8.0, spaceY + spaceShip.getHeight(null) / 4.0, spaceShip.getWidth(null) - spaceShip.getWidth(null) / 4.0, spaceShip.getHeight(null) - spaceShip.getHeight(null) / 2.0))
			{
				die = true;
			}
		}
		if (die)
		{
			time.setDelay(10);
			drawBoom++;
			if (drawBoom == 4)
			{
				drawBoom = 0;
			} else
			{
				g.drawImage(boom, boomX - theXFactor, boomY, null);
			}
		} else
		{
			time.setDelay(42);
		}
		// g.drawImage(boom, boomX - theXFactor, boomY, null);
		g.fillRect((int) (spaceX + spaceShip.getWidth(null) / 8.0), (int) (spaceY + spaceShip.getHeight(null) / 2.0), (int) (spaceShip.getWidth(null) - spaceShip.getWidth(null) / 4.0), (int) (spaceShip.getHeight(null) - spaceShip.getHeight(null) / 1.5));
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		repaint();
	}
}
