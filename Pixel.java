import java.awt.Component; 
import java.awt.Color; 
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import javax.swing.JFrame;

/**
 * A simple Pixel class to draw rectangles onto a window to display to the user.
 * All generated rectangles have a random color when displayed.
 *
 * @author Harry Baines
 */
public class Pixel extends Component
{
    // member variables
    private static final int frameSize = 500;
    private static final int rectSize = 20;
    private static int r = 0;
    private static int g = 0;
    private static int b = 0;
    private static int range = 0;
    
    private static Graphics2D g2d;
    private static JFrame frame;

    /**
     * Draws a rectangle on the JFrame.
     * @param g The graphics component to draw.
     */
    public void paint(Graphics g)
    { 
        g2d = (Graphics2D) g;
        for (int row = 0; row < frameSize/rectSize; row++)
        {
            for (int col = 0; col < frameSize/rectSize; col++)
            {
                g2d.setColor(getNewColor());
                g2d.drawRect(col*rectSize,row*rectSize,rectSize,rectSize);
                g2d.fillRect(col*rectSize,row*rectSize,rectSize,rectSize);
            }
        }
    }
    
    /**
     * Returns a random color from the colors array.
     * @return The new random color.
     */
    private static Color getNewColor()
    {
        r = randomWithRange(0,255);
        g = randomWithRange(0,255);
        b = randomWithRange(0,255);
        return (new Color(r,g,b,210));
    }
    
    /**
     * Returns an integer value within the range min and max inclusive.
     * @param min The minimum value for the range.
     * @param max The maximum value for the range.
     * @return The integer value in this range.
     */
    private static int randomWithRange(int min, int max)
    {
        range = (max - min) + 1;
        return ((int)(Math.random() * range) + min);
    }

    /**
     * A simple main method to initialise a new JFrame.
     * @param args Not used.
     */
    public static void main(String[] args)
    {
        frame = new JFrame();
        frame.setSize(frameSize, frameSize+22); // add 22 for mac support
        frame.getContentPane().add(new Pixel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true); 
    }
}
