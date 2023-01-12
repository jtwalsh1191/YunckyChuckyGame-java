 import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.Color;
import java.util.concurrent.TimeUnit;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Map;
/*
 *  the main window of the gui
 *  notice that it extends JFrame - so we can add our own components
 *  notice that it implements ActionListener - so we can handle user input
 */
public class WindowDemo extends JFrame implements ActionListener
{
	// gui components that are contained in this frame:
	private JPanel topPanel, sidePanel, bottomPanel;	// top and bottom panels in the main window
	private JLabel topLabel;				// a text label to appear in the top panel
	private JButton topButton;
	private JLabel playerLabel;// a 'reset' button to appear in the top panel
	private GridSquare [][]  gridSquares;	// squares to appear in grid formation in the bottom panel
	private GridSquare [][] gridSquares2;
	static int x,y;
	static int size;
	private int playerTurn;
        private String X_O;
	private JButton six;
	private JButton four;
	private JButton five;
	private JFrame frame;
	private int counter;
        private int xcoor, ycoor;
	private static boolean gameState;
	private String winner;
	private int one;
	
	
	

	
	/*
	 *  constructor method takes as input how many rows and columns of gridsquares to create
	 *  it then creates the panels, their subcomponents and puts them all together in the main frame
	 *  it makes sure that action listeners are added to selectable items
	 *  it makes sure that the gui will be visible
	 */
	public WindowDemo()
	{
		playerTurn = 0;
		X_O="Humans Turn";
		gameState = true;
		counter = 0;
		one = 1;
		
		// first create the panels
		topPanel = new JPanel();
		topPanel.setLayout( new FlowLayout());
		
		sidePanel = new JPanel();
		sidePanel.setLayout(new FlowLayout());
		
		bottomPanel = new JPanel();
		bottomPanel.setLayout( new GridLayout(4,4));
		
		frame = new JFrame();
		// then create the components for each panel and add them to it
		
		// for the top panel:
		topLabel = new JLabel("Click the Buttons!");
		playerLabel = new JLabel(X_O);
		
		topButton = new JButton("Reset");
		topButton.addActionListener( this);
	        four = new JButton("4x4");
		//five = new JButton("5x5");
		//six = new JButton("6x6");
		topPanel.add( topLabel);
		
		sidePanel.add(playerLabel);
		
		
	
		
		gridSquares = new GridSquare [4][4];
		
		{
			//for ( int row = 0; row < 4; row ++)
			
				gridSquares [0][0] = new GridSquare( x,y);
				gridSquares [0][0].setSize(100, 100);
				gridSquares [0][0].setColor2();
				gridSquares [0][0].setOpaque( true);				
				gridSquares [0][0].setBorderPainted( true);
					
				bottomPanel.add( gridSquares [0][0]);
				
				gridSquares [1][0] = new GridSquare( x,y);
				gridSquares [1][0].setSize(100, 100);
				gridSquares [1][0].setColor();
				gridSquares [1][0].setOpaque( true);				
				gridSquares [1][0].setBorderPainted( true);		
				gridSquares [1][0].addActionListener( this);
				gridSquares [1][0].setEnabled(true);
				bottomPanel.add( gridSquares [1][0]);
				
				gridSquares [2][0] = new GridSquare( x,y);
				gridSquares [2][0].setSize(100, 100);
				gridSquares [2][0].setColor();
				gridSquares [2][0].setOpaque( true);				
				gridSquares [2][0].setBorderPainted( true);		
				gridSquares [2][0].addActionListener( this);
				gridSquares [2][0].setEnabled(true);
				bottomPanel.add( gridSquares [2][0]);
				
				gridSquares [3][0] = new GridSquare( x,y);
				gridSquares [3][0].setSize(100, 100);
				gridSquares [3][0].setColor();
				gridSquares [3][0].setOpaque( true);				
				gridSquares [3][0].setBorderPainted( true);		
				gridSquares [3][0].addActionListener( this);
				gridSquares [3][0].setEnabled(true);
				bottomPanel.add( gridSquares [3][0]);
			
				gridSquares [0][1] = new GridSquare( x,y);
				gridSquares [0][1].setSize(100, 100);
				gridSquares [0][1].setColor();
				gridSquares [0][1].setOpaque( true);				 
				gridSquares [0][1].setBorderPainted( true);		
				gridSquares [0][1].addActionListener( this);
				gridSquares [0][1].setEnabled(true);
				bottomPanel.add( gridSquares [0][1]);
				
				gridSquares [2][1] = new GridSquare( x,y);
				gridSquares [2][1].setSize(100, 100);
				gridSquares [2][1].setColor();
				gridSquares [2][1].setEnabled(false);
				gridSquares [2][1].setOpaque( true);				
				gridSquares [2][1].setBorderPainted( true);		
				//gridSquares [2][1].addActionListener( this);		
				bottomPanel.add( gridSquares [2][1]);
				
				
				gridSquares [3][2] = new GridSquare( x,y);
				gridSquares [3][2].setSize(100, 100);
				gridSquares [3][2].setColor();
				gridSquares [3][2].setOpaque( true);
				gridSquares [3][2].setEnabled(false);
				gridSquares [3][2].setBorderPainted( true);		
				
				bottomPanel.add( gridSquares [3][2]);
				
				gridSquares [1][1] = new GridSquare( x,y);
				gridSquares [1][1].setSize(100, 100);
				gridSquares [1][1].setColor();
				gridSquares [1][1].setOpaque( true);
				gridSquares [1][1].setEnabled(false);
				gridSquares [1][1].setBorderPainted( true);		
						
				bottomPanel.add( gridSquares [1][1]);
				
				gridSquares [0][2] = new GridSquare( x,y);
				gridSquares [0][2].setSize(100, 100);
				gridSquares [0][2].setColor();
				gridSquares [0][2].setOpaque( true);
				
				gridSquares [0][2].setBorderPainted( true);		
				gridSquares [0][2].addActionListener(this);		
				bottomPanel.add( gridSquares [0][2]);
				
				gridSquares [3][1] = new GridSquare( x,y);
				gridSquares [3][1].setSize(100, 100);
				gridSquares [3][1].setColor();
				gridSquares [3][1].setEnabled(false);
				gridSquares [3][1].setOpaque( true);				
				gridSquares [3][1].setBorderPainted( true);		
						
				bottomPanel.add( gridSquares [3][1]);
				
				gridSquares [1][2] = new GridSquare( x,y);
				gridSquares [1][2].setSize(100, 100);
				gridSquares [1][2].setColor();
				gridSquares [1][2].setEnabled(false);
				gridSquares [1][2].setOpaque( true);				
				gridSquares [1][2].setBorderPainted( true);		
					
				bottomPanel.add( gridSquares [1][2]);
				
				gridSquares [2][2] = new GridSquare( x,y);
				gridSquares [2][2].setSize(100, 100);
				gridSquares [2][2].setColor();
				gridSquares [2][2].setEnabled(false);
				gridSquares [2][2].setOpaque( true);				
				gridSquares [2][2].setBorderPainted( true);		
					
				bottomPanel.add( gridSquares [2][2]);
				
				gridSquares [0][3] = new GridSquare( x,y);
				gridSquares [0][3].setSize(100, 100);
				gridSquares [0][3].setColor();
				gridSquares [0][3].setEnabled(true);
				gridSquares [0][3].setOpaque( true);				
				gridSquares [0][3].setBorderPainted( true);		
				gridSquares [0][3].addActionListener( this);		
				bottomPanel.add( gridSquares [0][3]);
				
				gridSquares [1][3] = new GridSquare( x,y);
				gridSquares [1][3].setSize(100, 100);
				gridSquares [1][3].setColor();
				gridSquares [1][3].setEnabled(false);
				gridSquares [1][3].setOpaque( true);				
				gridSquares [1][3].setBorderPainted( true);		
				
				bottomPanel.add( gridSquares [1][3]);
				
				gridSquares [2][3] = new GridSquare( x,y);
				gridSquares [2][3].setSize(100, 100);
				gridSquares [2][3].setColor();
				gridSquares [2][3].setEnabled(false);
				gridSquares [2][3].setOpaque( true);				
				gridSquares [2][3].setBorderPainted( true);		
						
				bottomPanel.add( gridSquares [2][3]);
				
				gridSquares [3][3] = new GridSquare( x,y);
				gridSquares [3][3].setSize(100, 100);
				gridSquares [3][3].setColor();
				gridSquares [3][3].setEnabled(false);
				gridSquares [3][3].setOpaque( true);				
				gridSquares [3][3].setBorderPainted( true);
					
				bottomPanel.add( gridSquares [3][3]);
				
				
		}
		
		
		getContentPane().setLayout( new BorderLayout());
		getContentPane().add( topPanel, BorderLayout.NORTH);
		getContentPane().add( bottomPanel, BorderLayout.CENTER);
		getContentPane().add(sidePanel,BorderLayout.EAST);
		pack();
		
		
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setVisible( true);
		
		
		Object[] options = {"4x4",
                    "5x5",
                    "6x6"
                };
             int n = JOptionPane.showOptionDialog(frame,
    "Which size "
    + "chocolate bar would you like?",
    "Chocolate Bar Choice",
    JOptionPane.YES_NO_CANCEL_OPTION,
    JOptionPane.QUESTION_MESSAGE,
    null,
    options,
    options[2]);
	}
	public void actionPerformed (ActionEvent aevt)
	
	{
	
		Object selected = aevt.getSource();
		
		
		if ( selected instanceof GridSquare);
		{
		
		    {
			((GridSquare) selected).switchColor();
			wait(1000);
			if (((GridSquare) selected).equals(gridSquares[1][0]))
			  {
			      (gridSquares[3][1]).switchColor();
			      (gridSquares[2][1]).switchColor();
			      (gridSquares[1][3]).switchColor();
			      (gridSquares[3][2]).switchColor();
			      (gridSquares[1][2]).switchColor();
			      (gridSquares[2][3]).switchColor();
			      (gridSquares[1][1]).switchColor();
			      (gridSquares[2][2]).switchColor();
			      (gridSquares[3][3]).switchColor();
			      (gridSquares[2][0]).switchColor();
			      (gridSquares[3][0]).switchColor();
			      gridSquares [1][0].setEnabled(false);
			      gridSquares[3][1].setEnabled(false);
			      gridSquares[2][1].setEnabled(false);
			      gridSquares[1][3].setEnabled(false);
			      gridSquares[3][2].setEnabled(false);
			      gridSquares[1][2].setEnabled(false);
			      gridSquares[2][3].setEnabled(false);
			      gridSquares[1][1].setEnabled(false);
			      gridSquares[2][2].setEnabled(false);
			      gridSquares[3][3].setEnabled(false);
			      gridSquares[2][0].setEnabled(false);
			      gridSquares[3][0].setEnabled(false);
			      String tempChoc = turnChange();
			      checkComplete();
			      playerLabel.setText(X_O);
			      counter();
			      
			     }
			((GridSquare) selected).switchColor();
			if (((GridSquare) selected).equals(gridSquares[2][0]))
			  {
			      (gridSquares[3][2]).switchColor();
			      (gridSquares[1][2]).switchColor();
			      (gridSquares[2][3]).switchColor();
			      (gridSquares[1][1]).switchColor();
			      (gridSquares[2][2]).switchColor();
			      (gridSquares[3][3]).switchColor();
			      (gridSquares[3][0]).switchColor();
			      gridSquares[3][2].setEnabled(false);
			      gridSquares[1][2].setEnabled(false);
			      gridSquares[1][1].setEnabled(false);
			      gridSquares[2][2].setEnabled(false);
			      gridSquares[3][3].setEnabled(false);
			      gridSquares[2][3].setEnabled(false);
			      gridSquares[3][0].setEnabled(false);
			      gridSquares[2][0].setEnabled(false);
			      String tempChoc = turnChange();
			      checkComplete();
			      playerLabel.setText(X_O);
			      counter();
			      
			     }
			     ((GridSquare) selected).switchColor();
			if (((GridSquare) selected).equals(gridSquares[3][0]))
			  {
			      (gridSquares[1][1]).switchColor();
			      (gridSquares[2][2]).switchColor();
			      (gridSquares[3][3]).switchColor();
			      gridSquares[1][1].setEnabled(false);
			      gridSquares[2][2].setEnabled(false);
			      gridSquares[3][3].setEnabled(false);
			      gridSquares[3][0].setEnabled(false);
			      String tempChoc = turnChange();
			      checkComplete();
			      playerLabel.setText(X_O);
			      counter();
			     
			     }
			((GridSquare) selected).switchColor();
			if (((GridSquare) selected).equals(gridSquares[0][1]))
			  {
			      (gridSquares[2][1]).switchColor();
			      (gridSquares[3][2]).switchColor();
			      (gridSquares[1][1]).switchColor();
			      (gridSquares[3][1]).switchColor();
			      (gridSquares[1][2]).switchColor();
			      (gridSquares[2][2]).switchColor();
			      (gridSquares[1][3]).switchColor();
			      (gridSquares[2][3]).switchColor();
			      (gridSquares[3][3]).switchColor();
			      (gridSquares[0][2]).switchColor();
			      (gridSquares[0][3]).switchColor();
			       (gridSquares[0][1]).switchColor();
			      gridSquares[2][1].setEnabled(false);
			      gridSquares[3][2].setEnabled(false);
			      gridSquares[1][1].setEnabled(false);
			      gridSquares[3][1].setEnabled(false);
			      gridSquares[1][2].setEnabled(false);
			      gridSquares[2][2].setEnabled(false);
			      gridSquares[1][3].setEnabled(false);
			      gridSquares[2][3].setEnabled(false);
			      gridSquares[3][3].setEnabled(false);
			      gridSquares[0][2].setEnabled(false);
			      gridSquares[0][3].setEnabled(false);
			      gridSquares[0][1].setEnabled(false);
			      String tempChoc = turnChange();
			      checkComplete();
			      playerLabel.setText(X_O);
			      counter();
			      
			     }
			((GridSquare) selected).switchColor();
			if (((GridSquare) selected).equals(gridSquares[0][2]))
			  {
			      (gridSquares[3][1]).switchColor();
			      (gridSquares[1][2]).switchColor();
			      (gridSquares[2][2]).switchColor();
			      (gridSquares[1][3]).switchColor();
			      (gridSquares[2][3]).switchColor();
			      (gridSquares[3][3]).switchColor();
			      (gridSquares[0][3]).switchColor();
			      
			      (gridSquares[0][2]).switchColor();
			      gridSquares[0][2].setEnabled(false);
			      
			      gridSquares[3][1].setEnabled(false);
			      gridSquares[3][1].setEnabled(false);
			      gridSquares[1][2].setEnabled(false);
			      gridSquares[2][2].setEnabled(false);
			      gridSquares[1][3].setEnabled(false);
			      gridSquares[2][3].setEnabled(false);
			      gridSquares[3][3].setEnabled(false);
			      gridSquares[0][3].setEnabled(false);
			      String tempChoc = turnChange();
			      checkComplete();
			      playerLabel.setText(X_O);
			      counter();
			      
			     }
		       ((GridSquare) selected).switchColor();
		       
			if (((GridSquare) selected).equals(gridSquares[0][3]))
			  {
			      (gridSquares[1][3]).switchColor();
			      (gridSquares[2][3]).switchColor();
			      (gridSquares[3][3]).switchColor();
			      gridSquares[1][3].setEnabled(false);
			      gridSquares[2][3].setEnabled(false);
			      gridSquares[3][3].setEnabled(false); 
			      gridSquares[0][3].setEnabled(false); 
			      String tempChoc = turnChange();
			      checkComplete();
			      playerLabel.setText(X_O);
			      counter();
			      
			      
			     }
			 }
}
	//private void computerTurn()
	//{
	                  /* if(counter == 1){
                               
                              (gridSquares2[1][3]).switchColor2(); 
			      (gridSquares2[2][3]).switchColor2();
			      (gridSquares2[3][3]).switchColor2();
			      (gridSquares2[0][3]).switchColor2();
			      gridSquares2[1][3].setEnabled(false);
			      gridSquares2[2][3].setEnabled(false);
			      gridSquares2[3][3].setEnabled(false);  
			      gridSquares2[0][3].setEnabled(false);
			      (gridSquares2[1][1]).switchColor2();
			      (gridSquares2[2][2]).switchColor2();
			      (gridSquares2[3][0]).switchColor2();
			      gridSquares2[1][1].setEnabled(false);
			      gridSquares2[2][2].setEnabled(false); 
			      gridSquares2[3][0].setEnabled(false); 
			      String tempChoc = turnChange();
			      checkComplete();
			      playerLabel.setText(X_O);
			      counter();
			     }
			     
			      
			     
			      if(counter == 3){
			         
			           (gridSquares[3][1]).switchColor();
			      (gridSquares[2][1]).switchColor();
			      (gridSquares[1][0]).switchColor();
			      (gridSquares[1][3]).switchColor();
			      (gridSquares[3][2]).switchColor();
			      (gridSquares[1][2]).switchColor();
			      (gridSquares[2][3]).switchColor();
			      (gridSquares[1][1]).switchColor();
			      (gridSquares[2][2]).switchColor();
			      (gridSquares[3][3]).switchColor();
			      (gridSquares[2][0]).switchColor();
			      (gridSquares[3][0]).switchColor();
			      gridSquares [1][0].setEnabled(false);
			      gridSquares[3][1].setEnabled(false);
			      gridSquares[2][1].setEnabled(false);
			      gridSquares[1][3].setEnabled(false);
			      gridSquares[3][2].setEnabled(false);
			      gridSquares[1][2].setEnabled(false);
			      gridSquares[2][3].setEnabled(false);
			      gridSquares[1][1].setEnabled(false);
			      gridSquares[2][2].setEnabled(false);
			      gridSquares[3][3].setEnabled(false);
			      gridSquares[2][0].setEnabled(false);
			      gridSquares[3][0].setEnabled(false);
			      String tempChoc = turnChange();
			      checkComplete();
			      playerLabel.setText(X_O);
			      counter();
			             }
			             else{
			                 (gridSquares[2][1]).switchColor();
			      (gridSquares[3][2]).switchColor();
			      (gridSquares[1][1]).switchColor();
			      (gridSquares[3][1]).switchColor();
			      (gridSquares[1][2]).switchColor();
			      (gridSquares[2][2]).switchColor();
			      (gridSquares[1][3]).switchColor();
			      (gridSquares[2][3]).switchColor();
			      (gridSquares[3][3]).switchColor();
			      (gridSquares[0][2]).switchColor();
			      (gridSquares[0][3]).switchColor();
			      (gridSquares[0][1]).switchColor();
			      gridSquares[2][1].setEnabled(false);
			      gridSquares[3][2].setEnabled(false);
			      gridSquares[1][1].setEnabled(false);
			      gridSquares[3][1].setEnabled(false);
			      gridSquares[1][2].setEnabled(false);
			      gridSquares[2][2].setEnabled(false);
			      gridSquares[1][3].setEnabled(false);
			      gridSquares[2][3].setEnabled(false);
			      gridSquares[3][3].setEnabled(false);
			      gridSquares[0][2].setEnabled(false);
			      gridSquares[0][3].setEnabled(false);
			      gridSquares[0][1].setEnabled(false);
			      String tempChoc = turnChange();
			      checkComplete();
			      playerLabel.setText(X_O);
			      counter(); 
			             }
			         
			     if(counter == 5)
			     {
			         (gridSquares[2][1]).switchColor();
			      (gridSquares[3][2]).switchColor();
			      (gridSquares[0][1]).switchColor();
			      (gridSquares[1][1]).switchColor();
			      (gridSquares[3][1]).switchColor();
			      (gridSquares[1][2]).switchColor();
			      (gridSquares[2][2]).switchColor();
			      (gridSquares[1][3]).switchColor();
			      (gridSquares[2][3]).switchColor();
			      (gridSquares[3][3]).switchColor();
			      (gridSquares[0][2]).switchColor();
			      (gridSquares[0][3]).switchColor();
			      gridSquares[2][1].setEnabled(false);
			      gridSquares[3][2].setEnabled(false);
			      gridSquares[1][1].setEnabled(false);
			      gridSquares[3][1].setEnabled(false);
			      gridSquares[1][2].setEnabled(false);
			      gridSquares[2][2].setEnabled(false);
			      gridSquares[1][3].setEnabled(false);
			      gridSquares[2][3].setEnabled(false);
			      gridSquares[3][3].setEnabled(false);
			      gridSquares[0][2].setEnabled(false);
			      gridSquares[0][3].setEnabled(false);
			      gridSquares[0][1].setEnabled(false);
			      String tempChoc = turnChange();
			      checkComplete();
			      playerLabel.setText(X_O);
			      counter(); 
			     }*/
			// }

	 
			   playerTurn ++;
			 
}

	

	      
			 		     
private void checkComplete()
{
    if ((gridSquares[0][1]).getBackground().equals(Color.black) & (gridSquares[1][0]).getBackground().equals(Color.black))
   
    {
        gameState=true;
    }
   
    if((gridSquares[0][1]).getBackground().equals(Color.white) && (gridSquares[1][0]).getBackground().equals(Color.white))
    
    {
                //gridSquares[0][1].switchColor2();
                 //gridSquares[0][1].setEnabled(true);
                endGame();
           
    }
}

    private void endGame()
    {
        
        int newGame = JOptionPane.showConfirmDialog
            (null,  winner + "`s win! \n New game?", "New Game?",
                JOptionPane.YES_NO_OPTION);
                if(newGame == JOptionPane.YES_OPTION)
        {
            resetGame();
            
        }
        else
        {
            System.exit(0);
        }
        
    }
    private String turnChange()
    {
        String toReturn = this.X_O;
            {
 
        if(this.counter % 2 == 0)
        {
            	
            this.playerTurn = 1;
            this.X_O = "Player 2 Turn";
            winner = "Player 1";
            checkComplete();
            
           
        }
        else
        {
            this.playerTurn = 0;
            this.X_O = "Player 1 Turn";
            winner = "Player 2";
            checkComplete();
            
            
        }
        
        return toReturn;
    }
}
    
    private static void wait(int ms){
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

   
    private void resetGame()
    {
        
        gridSquares[0][1].switchColor2();
        gridSquares[0][1].setEnabled(true);
        
        gridSquares[0][2].setColor();
        gridSquares[0][2].setEnabled(true);
        
        gridSquares[0][3].setColor();
        gridSquares[0][3].setEnabled(true);
        
        gridSquares[1][0].switchColor2();
        gridSquares[1][0].setEnabled(true);
        
        gridSquares[1][1].setColor();
        
        
        gridSquares[1][2].setColor();
        
        
        gridSquares[1][3].setColor();
       
        
        gridSquares[2][0].setColor();
        
        
        gridSquares[2][1].setColor();
        
        
        gridSquares[2][2].setColor();
       
        
        gridSquares[2][3].setColor();
       
        
        gridSquares[3][0].setColor();
        gridSquares[3][0].setEnabled(true);
        
        gridSquares[3][1].setColor();
        
        gridSquares[3][2].setColor();
        
        gridSquares[3][3].setColor();
      
        
        counter = 0;
        playerTurn = 0;
        
        
        
        
        
        
        
    } private void counter()
{
    counter = counter + 1;
    
    
}
private void startGame()
{
    if (counter == 0)
    {
    
               (gridSquares[0][1]).setColor();
            
                (gridSquares[1][0]).setColor();
 

}
}
}
  
    

