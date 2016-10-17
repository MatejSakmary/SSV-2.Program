package tul.ssv.math;

import java.util.Random;

/**
 *
 * @author jan-hybs
 */
public class Math {

    private static Random random = new Random(1234);

    public static double[][] foo(double[][] data) {

        if (random.nextDouble() > .8)
            data[random.nextInt(data.length)][1 + random.nextInt(2)] += random.nextDouble() * 3 - 1.5;
        return data;
    }

}
