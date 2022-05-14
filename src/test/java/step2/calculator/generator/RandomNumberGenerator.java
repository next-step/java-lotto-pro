package step2.calculator.generator;

import java.util.Random;

/**
 * @author : choi-ys
 * @date : 2022/05/14 9:51 오후
 */
public class RandomNumberGenerator {

    public static int generatePositiveRandomNumber() {
        final int bound = 1000;
        return new Random().nextInt(bound);
    }

    public static int generateNegativeRandomNumber() {
        return generatePositiveRandomNumber() * -1;
    }
}
