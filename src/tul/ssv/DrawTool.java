package tul.ssv;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import tul.ssv.model.Planet;
import tul.ssv.utils.Point;

public class DrawTool {

    public static int drawScale = 500 * 1000;
    public static final int defaultScale = 500 * 1000;
    
    private int width, height;

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
        int radius = (int) planet.getSize();
        if (size < 2)
            return;

        for (int i = start; i < start + size - 1; i+=1) {
            Point p0 = planet.history.get(i);
            Point p1 = planet.history.get(i + 1);
            g.drawLine(
                    width / 2 + (int) ((p0.x / drawScale)), height / 2 + (int) (p0.y / drawScale),
                    width / 2 + (int) ((p1.x / drawScale)), height / 2 + (int) (p1.y / drawScale)
            );
        }
    }

    public void draw(Graphics g, Planet planet) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setColor(planet.getColor());
        graphics2D.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
            
        double shrinkRatio = defaultScale / (double) drawScale;
        graphics2D.fillOval(
                width / 2 + (int) ((planet.getX() / drawScale) - (planet.getSize() / 2)* shrinkRatio),
                height / 2 + (int) ((planet.getY() / drawScale) - (planet.getSize() / 2)* shrinkRatio),
                (int) (planet.getSize() * shrinkRatio),
                (int) (planet.getSize() * shrinkRatio));
    }

    public void setOrigin(Dimension size) {
        this.width = size.width;
        this.height = size.height;
    }

}
