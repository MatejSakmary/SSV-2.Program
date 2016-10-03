package tul.ssv.view;

import javax.swing.*;
import java.awt.*;

public class PlanetDraw extends JPanel{

    public PlanetDraw() {
        this.setSize(400, 400);
        this.setBackground(new Color(0, 0, 0, 0));
    }

    
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        Graphics2D graphics2D = (Graphics2D)g;
        graphics2D.setColor(Color.red);
        graphics2D.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING, 
                    RenderingHints.VALUE_ANTIALIAS_ON);
        
        graphics2D.drawLine(50, 50, 0, 0);
        graphics2D.fillOval(10,10,100,100);
        
        graphics2D.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING, 
                    RenderingHints.VALUE_ANTIALIAS_OFF);
        
        graphics2D.drawLine(50, 50, 0, 0);
        graphics2D.fillOval(120,10,100,100);
    }

}