import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;

import javax.swing.Timer;

/**
 * Oversees constructor for a PlaneShape object, its translate method, and its draw method
 * 
 * @author (Chase Irby) 
 * @version (3/20/2014)
 */
public class PlaneShape implements MoveableShape
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
     * @param q the q - movement along x axis
     * @param p the p - movement along y axis
     */
    public PlaneShape(int x, int y, int width, final int q, final int p)
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
     * Draws a plane and fills it with pretty colors
     */
    public void draw(Graphics2D g2)
    {
        Rectangle2D.Double body = new Rectangle2D.Double(x, y + width / 3,
            width - 1, width / 6);
        Ellipse2D.Double frontWing = new Ellipse2D.Double(x + width * 5/8, y,
            width / 8, width * 7/8);
        Ellipse2D.Double rearWing = new Ellipse2D.Double(x + width * 1/8, y + width / 4.5,
            width / 8, width * 3/8);
        
        g2.setColor(Color.green);
        
        g2.draw(body);
        g2.fill(body);
        
        g2.setColor(Color.red);
        
        g2.draw(frontWing);
        g2.fill(frontWing);
        
        g2.draw(rearWing);
        g2.fill(rearWing);
        
    }
}
