package Lotto;

import java.util.ArrayList;
import java.util.stream.IntStream;

public final class RangeNumbers {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    public static final ArrayList<Integer> RANGE_NUMBERS = IntStream.range(MIN_NUMBER, MAX_NUMBER)
            .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

    public static ArrayList<Integer> getRangeNumbers() {
        return RANGE_NUMBERS;
    }
}
