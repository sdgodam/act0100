import java.awt.*;
import java.awt.geom.*;

/**
 * Class BoxBall - a graphical ball that has the ability to move. Details of movement are determined by the ball itself. It
 * will fall downwards and bounce upward again when hitting the ground.
 *
 * This movement can be initiated by repeated calls to the "move" method.
 * 
 * @author Michael Kölling (mik)
 * @author David J. Barnes
 * @author Bruce Quig
 *
 * @version 2011.07.31
 */

public class BoxBall
{
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private final int groundPosition;      // y position of ground
    private final int leftPosition;        // left x position of rectangle
    private final int rightPosition;       // right x position of rectangle
    private final int topPosition;         // y position of top
    private Canvas canvas;
    private int ySpeed = 10;                // initial y position speed
    private int xSpeed = 10;                // initial x position speed

    /**
     * Constructor for objects of class BoxBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param groundPos  the position of the ground (where the wall will bounce)
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor,int groundPos,
    int leftPos, int rightPos, int topPos, Canvas drawingCanvas)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        groundPosition = groundPos;
        leftPosition = leftPos;
        rightPosition = rightPos;
        topPosition = topPos;
        canvas = drawingCanvas;
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();
            
        // compute new position
        yPosition += ySpeed;
        xPosition += xSpeed;

        // check if it has hit the ground
        if(yPosition >= (groundPosition - diameter)) {
            yPosition = (int)(groundPosition - diameter);
            ySpeed = -ySpeed;
        }
        
        if(yPosition <= topPosition) {
            yPosition = (int)topPosition;
            ySpeed = -ySpeed;
        }
        
        if(xPosition <= (leftPosition)) {
            xPosition = (int)leftPosition;
            xSpeed = -xSpeed;
        }
        
        if(xPosition >= (rightPosition - diameter)) {
            xPosition = (int)(rightPosition - diameter);
            xSpeed = -xSpeed;
        }
        // draw again at new position
        draw();
    }    

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
}