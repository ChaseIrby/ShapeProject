import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;

import javax.swing.Timer;

/**
 * Oversees constructor for a BoatShape object, its translate method, and its draw method
 * 
 * @author (Chase Irby) 
 * @version (3/20/2014)
 */
public class BoatShape implements MoveableShape
{
    private int x;
    private int y;
    private int width;
    private final int DELAY = 10;
    
    /**
     * Constructor for objects of class BoatShape.
     *
     * @param x the x - starting x coordinate
     * @param y the y - starting y coordinate
     * @param width the width - width of the object
     * @param q the q - movement on x axis
     * @param p the p - movement on y axis
     */
    public BoatShape(int x, int y, int width, final int q, final int p)
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
     * Draws a boat and fills it with pretty colors
     */
    public void draw(Graphics2D g2)
    {
    	
    	Rectangle2D.Double mast = new Rectangle2D.Double(x + width * .45, y, width * .10, width / 2);
    	Rectangle2D.Double boat = new Rectangle2D.Double(x, y + width / 2, width, width / 3);
    	
    	Point2D.Double r1 = new Point2D.Double(x + width * .55, y);
        Point2D.Double r2 = new Point2D.Double(x + width *.75, y + width * .15);
        Point2D.Double r3 = new Point2D.Double(x + width * .55, y + width * .30);
    	
    	Line2D.Double topOfFlag = new Line2D.Double(r1, r2);
    	Line2D.Double bottomOfFlag = new Line2D.Double(r3, r2);
    	
    	g2.setColor(Color.green);
    	g2.draw(mast);
    	g2.fill(mast);
    	
    	g2.setColor(Color.blue);
    	g2.draw(boat);
    	g2.fill(boat);
    	
    	g2.draw(topOfFlag);
    	g2.draw(bottomOfFlag);
    }
}