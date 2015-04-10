import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

/**
 * This class handles the creation and management of the interface, creation of objects, and translate direction
 * 
 * @author (Chase Irby) 
 * @version (3/20/2014)
 */
public class MultiShapeTest 
{
    
    private static final Random random = new Random();
    private static int rand;
    private static int rand1;
    private static int rand2;
    private static int rand3;
    private static int rand4;
    private static int rand5;
    private static int rand6;
    
    private static final int ICON_WIDTH = 400;
    private static final int ICON_HEIGHT = 400;
    private static final int OBJECT_WIDTH = 100;
    private static final int DELAY = 10;
    
    /**
     * Build the control panel
     */
    public MultiShapeTest() 
    {
        JFrame controller = new JFrame("Mission Control");
        
        JPanel ctrlPanel = new JPanel();
        
        final ArrayList<MoveableShape> shapeArray = new ArrayList<MoveableShape>();
        
        ShapeIcon icon = new ShapeIcon(shapeArray, ICON_WIDTH, ICON_HEIGHT);
        
        final JLabel label1 = new JLabel(icon);
        
        JButton hideAnimationButton = new JButton("HIDE");
        JButton exitAnimationButton = new JButton("EXIT");
        
        final JFrame animationWindow = new JFrame();
        animationWindow.setLayout(new BorderLayout());
        animationWindow.setSize(400,400);
        animationWindow.setResizable(false);
        animationWindow.add(label1, BorderLayout.CENTER);
        animationWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        animationWindow.add(hideAnimationButton, BorderLayout.NORTH);
        animationWindow.add(exitAnimationButton, BorderLayout.SOUTH);
        animationWindow.pack();
        animationWindow.setVisible(false);
        
        final JCheckBox planeSelection = new JCheckBox("PLANE", true);
        final JCheckBox boatSelection = new JCheckBox("BOAT", false);
        final JCheckBox clockSelection = new JCheckBox("CLOCK", false);
        
        JButton addButton = new JButton("ADD");
        JButton removeButton = new JButton("REMOVE");
        JButton showButton = new JButton("SHOW");
        JButton exitButton = new JButton("EXIT");
        
        controller.setLayout(new FlowLayout());
        controller.setResizable(false);
        controller.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ctrlPanel.add(showButton);
        ctrlPanel.add(addButton);
        ctrlPanel.add(removeButton);
        ctrlPanel.add(exitButton);
        
        ctrlPanel.add(planeSelection);
        ctrlPanel.add(boatSelection);
        ctrlPanel.add(clockSelection);
        
        final Timer t = new Timer(DELAY, new ActionListener()
        {
        	public void actionPerformed(ActionEvent event)
        	{
        		// repaints the label frequently enough to reflect the continuous translations
        		label1.repaint();
        	}
        });
        
        showButton.addActionListener(new ActionListener()
        
        {
            public void actionPerformed(ActionEvent event)
            {
                animationWindow.setVisible(true);
            }
        });
        
        addButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
            	// used this form of random as opposed to random.nextInt in order to specify proper bounds for spawning objects
                rand1 = (int)(25 + (Math.random() * ((400 - (OBJECT_WIDTH / 2)) + 1)));
                rand2 = (int)(25 + (Math.random() * ((400 - (OBJECT_WIDTH / 3)) + 1)));
                
                rand3 = (int)(25 + (Math.random() * ((400 - (OBJECT_WIDTH / 2)) + 1)));
                rand4 = (int)(25 + (Math.random() * ((400 - (OBJECT_WIDTH / 3)) + 1)));
                
                rand5 = (int)(25 + (Math.random() * ((400 - (OBJECT_WIDTH / 2)) + 1)));
                rand6 = (int)(25 + (Math.random() * ((400 - (OBJECT_WIDTH / 3)) + 1)));
                
                if (planeSelection.isSelected() == true)
                {
                	// new random number between 0-7 is created each time add button is pressed with Plane selected
                	rand = random.nextInt(8);
                	
                	// switch on rand with cases used to provide random directions for translate and at random speeds
                	switch (rand)
                	{
                		case 0:
                			shapeArray.add(new PlaneShape(rand1, rand2, OBJECT_WIDTH, random.nextInt(3) + 1, random.nextInt(4)));
                			break;
                		case 1:
                			shapeArray.add(new PlaneShape(rand1, rand2, OBJECT_WIDTH, random.nextInt(3) + 1, 0));
                			break;
                		case 2:
                			shapeArray.add(new PlaneShape(rand1, rand2, OBJECT_WIDTH, 0, random.nextInt(3) + 1));
                			break;
                		case 3:
                			shapeArray.add(new PlaneShape(rand1, rand2, OBJECT_WIDTH, (random.nextInt(3) + 1) * -1, random.nextInt(3) + 1));
                			break;
                		case 4:
                			shapeArray.add(new PlaneShape(rand1, rand2, OBJECT_WIDTH, (random.nextInt(3) + 1) * -1, 0));
                			break;
                		case 5:
                			shapeArray.add(new PlaneShape(rand1, rand2, OBJECT_WIDTH, random.nextInt(3) + 1, (random.nextInt(3) + 1) * -1));
                			break;
                		case 6:
                			shapeArray.add(new PlaneShape(rand1, rand2, OBJECT_WIDTH, 0, (random.nextInt(3) + 1) * -1));
                			break;
                		case 7:
                			shapeArray.add(new PlaneShape(rand1, rand2, OBJECT_WIDTH, (random.nextInt(3) + 1) * -1, (random.nextInt(3) + 1) * -1));
                			break;
                	}
                }
                
                if (boatSelection.isSelected() == true)
                {
                	// new random number between 0-7 is created each time add button is pressed with Boat selected
                	rand = random.nextInt(8);
                	
                	// switch on rand with cases used to provide random directions for translate and at random speeds
                	switch (rand)
                	{
                		case 0:
                			shapeArray.add(new BoatShape(rand3, rand4, OBJECT_WIDTH, random.nextInt(3) + 1, random.nextInt(4)));
                			break;
                		case 1:
                			shapeArray.add(new BoatShape(rand3, rand4, OBJECT_WIDTH, random.nextInt(3) + 1, 0));
                			break;
                		case 2:
                			shapeArray.add(new BoatShape(rand3, rand4, OBJECT_WIDTH, 0, random.nextInt(3) + 1));
                			break;
                		case 3:
                			shapeArray.add(new BoatShape(rand3, rand4, OBJECT_WIDTH, (random.nextInt(3) + 1) * -1, random.nextInt(3) + 1));
                			break;
                		case 4:
                			shapeArray.add(new BoatShape(rand3, rand4, OBJECT_WIDTH, (random.nextInt(3) + 1) * -1, 0));
                			break;
                		case 5:
                			shapeArray.add(new BoatShape(rand3, rand4, OBJECT_WIDTH, random.nextInt(3) + 1, (random.nextInt(3) + 1) * -1));
                			break;
                		case 6:
                			shapeArray.add(new BoatShape(rand3, rand4, OBJECT_WIDTH, 0, (random.nextInt(3) + 1) * -1));
                			break;
                		case 7:
                			shapeArray.add(new BoatShape(rand3, rand4, OBJECT_WIDTH, (random.nextInt(3) + 1) * -1, (random.nextInt(3) + 1) * -1));
                			break;
                	}
                }
                if(clockSelection.isSelected() == true)
                {
                	// new random number between 0-7 is created each time add button is pressed with Clock selected
                	rand = random.nextInt(8);
                	
                	// switch on rand with cases used to provide random directions for translate and at random speeds
                	switch (rand)
                	{
                		case 0:
                			shapeArray.add(new ClockShape(rand5, rand6, OBJECT_WIDTH, random.nextInt(3) + 1, random.nextInt(4)));
                			break;
                		case 1:
                			shapeArray.add(new ClockShape(rand5, rand6, OBJECT_WIDTH, random.nextInt(3) + 1, 0));
                			break;
                		case 2:
                			shapeArray.add(new ClockShape(rand5, rand6, OBJECT_WIDTH, 0, random.nextInt(3) + 1));
                			break;
                		case 3:
                			shapeArray.add(new ClockShape(rand5, rand6, OBJECT_WIDTH, (random.nextInt(3) + 1) * -1, random.nextInt(3) + 1));
                			break;
                		case 4:
                			shapeArray.add(new ClockShape(rand5, rand6, OBJECT_WIDTH, (random.nextInt(3) + 1) * -1, 0));
                			break;
                		case 5:
                			shapeArray.add(new ClockShape(rand5, rand6, OBJECT_WIDTH, random.nextInt(3) + 1, (random.nextInt(3) + 1) * -1));
                			break;
                		case 6:
                			shapeArray.add(new ClockShape(rand5, rand6, OBJECT_WIDTH, 0, (random.nextInt(3) + 1) * -1));
                			break;
                		case 7:
                			shapeArray.add(new ClockShape(rand5, rand6, OBJECT_WIDTH, (random.nextInt(3) + 1) * -1, (random.nextInt(3) + 1) * -1));
                			break;
                	}
                } 
                
                animationWindow.pack();
                animationWindow.setVisible(true);
                
            }
        });
        
        removeButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
            	// remove the last element added
            	if (shapeArray.isEmpty() == false)
            	{
            		shapeArray.remove(shapeArray.size() - 1);
            	}
            	// repaint to label to get rid of that object in window
            	label1.repaint();
            }
        });
        
        exitButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                System.exit(0);
            }
        });
        
        hideAnimationButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                animationWindow.setVisible(false);
            }
        });
        
        exitAnimationButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
            	// empty the array of objects so they no longer exist and/or animated
            	shapeArray.clear();
            	// clear resources and kill the window
                animationWindow.dispose();
            }
        });
        
        controller.add(ctrlPanel);
        controller.pack();
        controller.setVisible(true);
        
        // start the repaint timer
        t.start();
    }
    
    /**
     * The main method. Creates a new MultiShapeTest object
     *
     * @param args the arguments
     */
    public static void main(String[] args)
    {
    	// create the control panel
        MultiShapeTest multi = new MultiShapeTest();
    }

}
