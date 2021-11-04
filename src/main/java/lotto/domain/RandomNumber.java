package lotto.domain;

public class RandomNumber {

    private static final int MAX_RANDOM_NUMBER = 45;
    private static final int MIN_RANDOM_NUMBER = 1;

    public int generate() {
        return (int) (Math.random() * MAX_RANDOM_NUMBER) + MIN_RANDOM_NUMBER;
    }
}
