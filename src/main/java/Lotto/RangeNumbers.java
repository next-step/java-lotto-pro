package Lotto;

import java.util.ArrayList;
import java.util.stream.IntStream;

public final class RangeNumbers {
    public static final ArrayList<Integer> rangeNumbers = IntStream.range(1, 45)
            .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

    public static ArrayList<Integer> getRangeNumbers() {
        return rangeNumbers;
    }
}
