import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class Intro extends JComponent implements ActionListener, MouseListener
{
	Timer time4Intro;
	JFrame introWindow;
	int width = Toolkit.getDefaultToolkit().getScreenSize().width - 20;
	int height = width / 2;
	Image explanation;
	int lines = 1;
	boolean doingAnimation = true;
	int animationCounter = 0;
	double lineWidthRatio = 0.08;
	double animationSpeed = width / 200;

	public Intro() throws IOException
	{
		explanation = ImageIO.read(getClass().getResource("explanation.png")).getScaledInstance(width, -1, 0);
		introWindow = new JFrame();
		introWindow.add(this);
		introWindow.addMouseListener(this);
		introWindow.pack();
		introWindow.setVisible(true);
		introWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		time4Intro = new Timer(20, this);
		time4Intro.start();
	}

	@Override
	public void paint(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		g.drawImage(explanation, 0, (height / 2) - (explanation.getHeight(null)) / 2, null);
		if (doingAnimation && lines == 1)
		{
			g.fillRect(animationCounter, 0, width, (int) (explanation.getHeight(null) * lineWidthRatio));
			animationCounter += animationSpeed;
			if (animationCounter > explanation.getWidth(null) * 0.5)
			{
				doingAnimation = false;
				animationCounter = 0;
			}
		}
		if (doingAnimation && lines == 2)
		{
			g.fillRect(animationCounter, (int) (explanation.getHeight(null) * lineWidthRatio), width, (int) (explanation.getHeight(null) * lineWidthRatio));
			animationCounter += animationSpeed;
			if (animationCounter > explanation.getWidth(null) * 0.3)
			{
				doingAnimation = false;
				animationCounter = 0;
			}
		} else if (lines < 2)
		{
			g.fillRect(0, (int) (explanation.getHeight(null) * lineWidthRatio), width, (int) (explanation.getHeight(null) * lineWidthRatio));
		}
		if (doingAnimation && lines == 3)
		{
			g.fillRect(animationCounter, (int) (explanation.getHeight(null) * lineWidthRatio * 2), width, (int) (explanation.getHeight(null) * lineWidthRatio));
			animationCounter += animationSpeed;
			if (animationCounter > explanation.getWidth(null) * 0.8)
			{
				doingAnimation = false;
				animationCounter = 0;
			}
		} else if (lines < 3)
		{
			g.fillRect(0, (int) (explanation.getHeight(null) * lineWidthRatio * 2), width, (int) (explanation.getHeight(null) * lineWidthRatio));
		}
		if (doingAnimation && lines == 4)
		{
			g.fillRect(animationCounter, (int) (explanation.getHeight(null) * lineWidthRatio * 3), width, (int) (explanation.getHeight(null) * lineWidthRatio));
			animationCounter += animationSpeed;
			if (animationCounter > explanation.getWidth(null) * 0.9)
			{
				doingAnimation = false;
				animationCounter = 0;
			}
		} else if (lines < 4)
		{
			g.fillRect(0, (int) (explanation.getHeight(null) * lineWidthRatio * 3), width, (int) (explanation.getHeight(null) * lineWidthRatio));
		}
		if (doingAnimation && lines == 5)
		{
			g.fillRect(animationCounter, (int) (explanation.getHeight(null) * lineWidthRatio * 4), width, (int) (explanation.getHeight(null) * lineWidthRatio));
			animationCounter += animationSpeed;
			if (animationCounter > explanation.getWidth(null) * 0.6)
			{
				doingAnimation = false;
				animationCounter = 0;
			}
		} else if (lines < 5)
		{
			g.fillRect(0, (int) (explanation.getHeight(null) * lineWidthRatio * 4), width, (int) (explanation.getHeight(null) * lineWidthRatio));
		}
		if (doingAnimation && lines == 6)
		{
			g.fillRect(animationCounter, (int) (explanation.getHeight(null) * lineWidthRatio * 5), width, (int) (explanation.getHeight(null) * lineWidthRatio));
			animationCounter += animationSpeed;
			if (animationCounter > explanation.getWidth(null))
			{
				doingAnimation = false;
				animationCounter = 0;
			}
		} else if (lines < 6)
		{
			g.fillRect(0, (int) (explanation.getHeight(null) * lineWidthRatio * 5), width, (int) (explanation.getHeight(null) * lineWidthRatio));
		}
		if (doingAnimation && lines == 7)
		{
			g.fillRect(animationCounter, (int) (explanation.getHeight(null) * lineWidthRatio * 6), width, (int) (explanation.getHeight(null) * lineWidthRatio));
			animationCounter += animationSpeed;
			if (animationCounter > explanation.getWidth(null) * 0.4)
			{
				doingAnimation = false;
				animationCounter = 0;
			}
		} else if (lines < 7)
		{
			g.fillRect(0, (int) (explanation.getHeight(null) * lineWidthRatio * 6), width, (int) (explanation.getHeight(null) * lineWidthRatio));
		}
		if (doingAnimation && lines == 8)
		{
			g.fillRect(animationCounter, (int) (explanation.getHeight(null) * lineWidthRatio * 7), width, (int) (explanation.getHeight(null) * lineWidthRatio));
			animationCounter += animationSpeed;
			if (animationCounter > explanation.getWidth(null) * 0.3)
			{
				doingAnimation = false;
				animationCounter = 0;
			}
		} else if (lines < 8)
		{
			g.fillRect(0, (int) (explanation.getHeight(null) * lineWidthRatio * 7), width, (int) (explanation.getHeight(null) * lineWidthRatio));
		}
		if (doingAnimation && lines == 9)
		{
			g.fillRect(animationCounter, (int) (explanation.getHeight(null) * lineWidthRatio * 8), width, (int) (explanation.getHeight(null) * lineWidthRatio));
			animationCounter += animationSpeed;
			if (animationCounter > explanation.getWidth(null) * 0.3)
			{
				doingAnimation = false;
				animationCounter = 0;
			}
		} else if (lines < 9)
		{
			g.fillRect(0, (int) (explanation.getHeight(null) * lineWidthRatio * 8), width, (int) (explanation.getHeight(null) * lineWidthRatio));
		}
		if (doingAnimation && lines == 10)
		{
			g.fillRect(animationCounter, (int) (explanation.getHeight(null) * lineWidthRatio * 9), width, (int) (explanation.getHeight(null) * lineWidthRatio));
			animationCounter += animationSpeed;
			if (animationCounter > explanation.getWidth(null) * 0.7)
			{
				doingAnimation = false;
				animationCounter = 0;
			}
		} else if (lines < 10)
		{
			g.fillRect(0, (int) (explanation.getHeight(null) * lineWidthRatio * 9), width, (int) (explanation.getHeight(null) * lineWidthRatio));
		}
		if (doingAnimation && lines == 11)
		{
			g.fillRect(animationCounter, (int) (explanation.getHeight(null) * lineWidthRatio * 10), width, (int) (explanation.getHeight(null) * lineWidthRatio));
			animationCounter += animationSpeed;
			if (animationCounter > explanation.getWidth(null))
			{
				doingAnimation = false;
				animationCounter = 0;
			}
		} else if (lines < 11)
		{
			g.fillRect(0, (int) (explanation.getHeight(null) * lineWidthRatio * 10), width, (int) (explanation.getHeight(null) * lineWidthRatio));
		}
		if (doingAnimation && lines == 12)
		{
			g.fillRect(animationCounter, (int) (explanation.getHeight(null) * lineWidthRatio * 11), width, (int) (explanation.getHeight(null) * lineWidthRatio));
			animationCounter += animationSpeed;
			if (animationCounter > explanation.getWidth(null))
			{
				doingAnimation = false;
				animationCounter = 0;
			}
		} else if (lines < 12)
		{
			g.fillRect(0, (int) (explanation.getHeight(null) * lineWidthRatio * 11), width, (int) (explanation.getHeight(null) * lineWidthRatio));
		}
		if (doingAnimation && lines == 13)
		{
			g.fillRect(animationCounter, (int) (explanation.getHeight(null) * lineWidthRatio * 12), width, (int) (explanation.getHeight(null) * lineWidthRatio));
			animationCounter += animationSpeed;
			if (animationCounter > explanation.getWidth(null) * 0.2)
			{
				doingAnimation = false;
				animationCounter = 0;
			}
		} else if (lines < 13)
		{
			g.fillRect(0, (int) (explanation.getHeight(null) * lineWidthRatio * 12), width, (int) (explanation.getHeight(null) * lineWidthRatio));
		}
		if (lines == 14)
		{
			time4Intro.stop();
			introWindow.setVisible(false);
			try
			{
				new SpaceAge();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public Dimension getPreferredSize()
	{
		return new Dimension(width, height);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		if (!doingAnimation)
		{
			lines++;
			doingAnimation = true;
		}
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
	}
}
