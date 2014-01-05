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
	SpaceAge game;
	Timer time4Intro;
	JFrame introWindow;
	static Intro introToGame;
	int width = Toolkit.getDefaultToolkit().getScreenSize().width - 20;
	int height = width / 2;
	Image explanation;
	int lines = 1;
	boolean doingAnimation = false;

	public static void main(String[] args) throws IOException
	{
		introToGame = new Intro();
	}

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
