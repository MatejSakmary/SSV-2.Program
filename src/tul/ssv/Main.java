package tul.ssv;

import tul.ssv.model.Planet;
import tul.ssv.view.PlanetHolder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import tul.ssv.view.Controls;

public class Main extends JFrame {

    public java.util.List<Planet> items = new ArrayList<>();

    public final int FPS = 60;
    public final PlanetHolder planetHolder = new PlanetHolder();
    public final Controls controls = new Controls(planetHolder);

    public static void main(String[] args) {
        new Main();
    }

    public Main() throws HeadlessException {

        this.setTitle("GUI aplikace");
        this.setSize(1920, 1080);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setBackground(Color.RED);
        this.setLayout(new BorderLayout());

        Container container = getContentPane();
        container.add(planetHolder, BorderLayout.CENTER);
        container.add(controls, BorderLayout.EAST);
        
        Planet a = new Planet(59736*10e19, 3496*10e4, 200*10e5, 20, Color.blue);
        Planet b = new Planet(1989*10e26, 200*10e5, 200*10e5, 100, Color.yellow);
        Planet c = new Planet(7347*10e19, 349384*10e2, 200*10e5, 10, Color.black);


        a.setVy(-750000);

        planetHolder.add(a);
        planetHolder.add(b);
        planetHolder.add(c);
        planetHolder.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                controls.updatePos(e);
            }
            
        });

        while (true) {
            double[][] data = planetHolder.save();
            data = tul.ssv.math.Math.step(data);
            planetHolder.load(data);
            
            controls.updateDebugArea();
            repaint();

            try {
                Thread.currentThread().sleep(1000 / FPS);
            } catch (InterruptedException ex) {
            }
        }

    }

}
