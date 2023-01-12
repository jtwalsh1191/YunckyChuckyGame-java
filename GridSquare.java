import java.awt.Color;
import javax.swing.*;
/**
 * Write a description of class GridSquare here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GridSquare extends JButton
{
    // instance variables - replace the example below with your own
    private int xcoor, ycoor;

    /**
     * Constructor for objects of class GridSquare
     */
    public GridSquare(int xcoor, int ycoor)
    {
        super();
        this.xcoor = xcoor;
        this.ycoor = ycoor;
    }
// if the decider is even, it chooses black, otherwise white (for 'column+row' will allow a chequerboard effect)
    public void setColor()
    {
        Color colour = Color.black;
        this.setBackground(colour);
    }
    
    public void setColor2()
    {   Color colour = Color.green;
        this.setBackground(colour);   
    }
    
    public void switchColor2()
    {
        
      Color colour = (getBackground() == Color.black) ? Color.white: Color.black;
		this.setBackground( colour);

        
    }
    
    // if the square is black it becomes white, and vice-versa
    public void switchColor()
    {
       
        Color colour = (getBackground() == Color.black) ? Color.white: Color.white;
        this.setBackground(colour);
    }
      public static void wait(int ms){
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
    
}

