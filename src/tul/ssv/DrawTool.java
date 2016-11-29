package tul.ssv;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import tul.ssv.model.Planet;
import tul.ssv.utils.Point;


public class DrawTool {

    public DrawTool() {
    }
    
    

    public void drawHistory(Graphics g, Planet planet) {
        
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setColor(planet.getColor());
        graphics2D.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        
        int size = planet.history.getSize();
        int start = planet.history.getPointer();
        int radius =  (int) planet.getSize();
        if (size < 2) return;
        
        for (int i = start; i < start + size - 1; i++) {
            Point p0 = planet.history.get(i);
            Point p1 = planet.history.get(i+1);
            g.drawLine(
                    (int) ((p0.x/500000) ), (int) (p0.y/500000) ,
                    (int) ((p1.x/500000) ), (int) (p1.y/500000)
            );
        }
    }
    
    public void draw(Graphics g, Planet planet) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setColor(planet.getColor());
        graphics2D.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        graphics2D.fillOval(
                (int) ((planet.getX()/500000)-(planet.getSize()/2)),
                (int) ((planet.getY()/500000)-(planet.getSize()/2)),
                (int) planet.getSize(),
                (int) planet.getSize());
    }
    
    
    
}
