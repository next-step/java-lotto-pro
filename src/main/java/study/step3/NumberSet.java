package study.step3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberSet {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private static final List<Integer> numberSet = new ArrayList<>();

    public static List<Integer> shuffledNumberSet() {
        if (numberSet.isEmpty()) {
            addNumbers();
        }
        Collections.shuffle(numberSet);
        return numberSet;
    }

    private static void addNumbers() {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            numberSet.add(i);
        }
    }
}
