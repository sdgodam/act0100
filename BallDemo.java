import java.awt.Color;
import java.util.Random;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael KÃ¶lling and David J. Barnes
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
     * el usuario introduzca por parámetro cuántas bolas quiere que aparezcan en 
     * pantalla. El radio y color de las bolas debe ser aleatorio. Su posicion de 
     * inicio también debe ser aleatoria, pero siempre de la mitad de la pantalla 
     * hacia la izquierda. La animación debe terminar cuando alguna bola se salga 
     * del suelo por la derecha
     */
    public void bounce(int numBolas)
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);
        //declarate and inicialize Array of balls
        BouncingBall[] ball = new BouncingBall[numBolas];
        //Array of colors
        Color[] color = {Color.RED,Color.GREEN,Color.YELLOW,Color.BLACK,Color.ORANGE,Color.CYAN,Color.BLUE,Color.DARK_GRAY};
        // crate and show the balls
        for(int i=0; i<numBolas; i++){
            Random diameter = new Random();
            Random xPosition = new Random();
            Random yPosition = new Random();
            Random colorNumber = new Random();
            ball[i] = new BouncingBall(3 + xPosition.nextInt(200),3 + yPosition.nextInt(300), 10 + diameter.nextInt(30), color[colorNumber.nextInt(8)], ground, myCanvas);
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

    public void boxBounce()
    {
        int ground = 450;
        int left = 50;
        int right = 550;
        int top = 50;

        myCanvas.setVisible(true);

        // draw the rectangle
        //sup de izq a derecha
        myCanvas.drawLine(left, top, right, top);
        //izquierda de arriba a abajo
        myCanvas.drawLine(left, left, left, ground);
        //abajo de izq a derecha
        myCanvas.drawLine(left, ground, right, ground);
        //derecha de arriba a abajo
        myCanvas.drawLine(right, top, right, ground);
    }
}
