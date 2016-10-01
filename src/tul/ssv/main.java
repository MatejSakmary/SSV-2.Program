package tul.ssv;


import tul.ssv.view.PlanetHolder;

import javax.swing.*;
import java.awt.*;

public class main extends JFrame{

    public final int FPS = 60;
    public final PlanetHolder planetHolder = new PlanetHolder();

    public static void main(String[] args) {
        new main();
    }


    public main() throws HeadlessException {

        this.setTitle("GUI aplikace");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setBackground(Color.BLACK);
        this.setLayout(new BorderLayout());

        Container container = getContentPane();

        container.add(planetHolder, BorderLayout.CENTER);



        while (true) {
            this.repaint();

            try {
                Thread.currentThread().sleep(1000 / FPS);
            } catch (InterruptedException ex) {
            }
        }

    }



}
