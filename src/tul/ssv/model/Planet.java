package tul.ssv.model;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Planet{

    private int nextX, nextY;
    private int width, height;
    private int angle = 0;
    private int radius;

    public Planet (int radius,int width, int height){

        this.height = height;
        this.width = width;
        this.radius = radius;
    }

    public int nextX(){
        nextX = (int) (cos(angle) * radius);
        angle ++;
        return nextX;
    }

    public int nextY(){
        nextY = (int) (sin(angle) * radius);
        return nextY;
    }

}
