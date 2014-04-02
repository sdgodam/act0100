import java.awt.Color;
import java.util.Random;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate n bouncing balls
     */
    public void bounce(int numBolas)
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);
        //declarate and inicialize Array of balls
        BouncingBall[] ball = new BouncingBall[numBolas];
        // crate and show the balls
        for(int i=0; i<numBolas; i++){
            Random diameter = new Random();
            Random xPosition = new Random();
            Random yPosition = new Random();
            ball[i] = new BouncingBall(3 + xPosition.nextInt(200),3 + yPosition.nextInt(300), 10 + diameter.nextInt(14), Color.RED, ground, myCanvas);
            ball[i].draw();
        }
        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            for(int i=0; i<numBolas; i++){
                ball[i].move();
            }
            // stop once ball has travelled a certain distance on x axis
            for(int i=0; i<numBolas; i++){
                if(ball[i].getXPosition() >= 550) {
                    finished = true;
                }
            }
        }
    }
}
