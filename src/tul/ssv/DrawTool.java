package tul.ssv;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import tul.ssv.model.Planet;

/**
 *
 * @author jan-hybs
 */
public class DrawTool {

    public DrawTool() {
    }
    
    

    public void draw(Graphics g, Planet planet) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setColor(planet.getColor());
        graphics2D.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        graphics2D.fillOval(
                (int) planet.getX(),
                (int) planet.getY(),
                (int) planet.getSize(),
                (int) planet.getSize());
    }

}
