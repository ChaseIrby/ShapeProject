import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;

import javax.swing.Timer;

/**
 * Write a description of class ClockShape here.
 * 
 * @author (Chase Irby) 
 * @version (3/20/2014)
 */
public class ClockShape implements MoveableShape
{
    private int x;
    private int y;
    private int width;
    private final int DELAY = 10;
    
    /**
     * Constructor for objects of class PlaneShape.
     *
     * @param x the x - starting x coordinate
     * @param y the y - starting y coordinate
     * @param width the width - width of the object
     * @param q the q - movement on the x axis
     * @param p the p - movement on the y axis
     */
    public ClockShape(int x, int y, int width, final int q, final int p)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        
        // timer created in each object and continues to translate in q, p direction so long as the object is still in the ArrayList
        final Timer t = new Timer(DELAY, new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                translate(q, p);
            }
        });
        t.start();
    }

    /* (non-Javadoc)
     * @see MoveableShape#translate(int, int)
     * 
     * Moves the object, also checks for bounds and wraps the object if bounds are met
     */
    public void translate(int dx, int dy)
    {   	
    	if (x >= 400 && y >= 400)
    	{
    		x = -width + dx;
    		y = -width + dy;
    	}
    	else if (x < -width && y < -width)
    	{
    		x = 400 + dx;
    		y = 400 + dy;
    	}
    	else if (y >= 400)
    	{
    		x += dx;
    		y = -width + dy;
    	}
    	else if (y < -width)
    	{
    		x += dx;
    		y = 400 + dy;
    	}
    	else if (x >= 400)
    	{
    		x = -width + dx;
    		y += dy;
    	}
    	else if (x < -width)
    	{
    		x = 400 + dx;
    		y += dy;
    	}
    	else
    	{
    		x += dx;
    		y += dy;
    	}
    }
    
    /* (non-Javadoc)
     * @see MoveableShape#draw(java.awt.Graphics2D)
     * 
     * Draws a clock and fills it with pretty colors
     */
    public void draw(Graphics2D g2)
    {
    	Ellipse2D.Double clockBody = new Ellipse2D.Double(x + width * .25, y + width * .25,
                width * .50, width * .50);
    	Ellipse2D.Double innerClock = new Ellipse2D.Double(x + width * .43, y + width * .42, width * .15, width * .15);
    	
    	Point2D.Double r1 = new Point2D.Double(x + width * .5, y + width * .5);
    	Point2D.Double r2 = new Point2D.Double(x + width *.75, y + width * .5);
    	Point2D.Double r3 = new Point2D.Double(x + width * .37, y + width * .37);
    	
    	Line2D.Double bigHand = new Line2D.Double(r1, r2);
    	Line2D.Double littleHand = new Line2D.Double(r1, r3);
    	
    	g2.setColor(Color.yellow);
    	g2.draw(clockBody);
    	g2.fill(clockBody);
    	
    	g2.setColor(Color.green);
    	g2.draw(innerClock);
    	g2.fill(innerClock);
    	
    	g2.setColor(Color.black);
    	g2.draw(bigHand);
    	g2.draw(littleHand);
    }
}
