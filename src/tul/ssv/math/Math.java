package tul.ssv.math;

import java.util.Random;


public class Math {

    static final double G = 0.00000000006673;
    static final double deltaT = 0.1;


    public static final int MASS = 0;
    public static final int X_POS = 1;
    public static final int Y_POS = 2;
    public static final int X_SPEED = 3;
    public static final int Y_SPEED = 4;

    public static double[][] step(double[][] data) {
        final int PLANET_COUNT = data.length;

        for (int i = 0; i < PLANET_COUNT; i++) {
            double gxSum = 0;
            double gySum = 0;

            for (int j = 0; j < PLANET_COUNT; j++) {
                if (i == j) continue;

                gxSum += calcGForce(data[i], data[j], X_POS);
                gySum += calcGForce(data[i], data[j], Y_POS);

            }
            data[i][X_SPEED] += deltaT * G * gxSum;
            data[i][X_POS] += deltaT * data[i][X_SPEED];

            data[i][Y_SPEED] += deltaT * G * gySum;
            data[i][Y_POS] += deltaT * data[i][Y_SPEED];
        }

    return data;
    }

    public static double calcGForce (double[] a, double[] b, int property) {
        return (b[MASS] * (b[property] - a[property])) /
            java.lang.Math.pow(
                    java.lang.Math.sqrt(
                            java.lang.Math.pow(b[X_POS] - a[X_POS], 2) +
                            java.lang.Math.pow(b[Y_POS] - a[Y_POS], 2)
                    ), 3);
    }

}