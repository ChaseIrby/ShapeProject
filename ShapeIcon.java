import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
   This class adds new shapes to an ArrayList and proceeds to draw them
*/
public class ShapeIcon implements Icon
{
	private int width;
	private int height;
	private ArrayList<MoveableShape> shapeList;

   /**
    * Instantiates a new shape icon within an ArrayList
    *
    * @param shape the shape
    * @param width the width
    * @param height the height
    */
   public ShapeIcon(ArrayList<MoveableShape> shape,
      int width, int height)
   {
      this.shapeList = shape;
      this.width = width;
      this.height = height;
   }
   
   /* (non-Javadoc)
    * @see javax.swing.Icon#getIconWidth()
    */
   public int getIconWidth()
   {
      return width;
   }

   /* (non-Javadoc)
    * @see javax.swing.Icon#getIconHeight()
    */
   public int getIconHeight()
   {
      return height;
   }

   /* (non-Javadoc)
    * @see javax.swing.Icon#paintIcon(java.awt.Component, java.awt.Graphics, int, int)
    */
   public void paintIcon(Component c, Graphics g, int x, int y)
   {
	  // draw the objects as they are created
      Graphics2D g2 = (Graphics2D) g;
      ListIterator<MoveableShape> iterator = shapeList.listIterator();
      while(iterator.hasNext() == true)
      {
    	  iterator.next().draw(g2);
      }
   }
}