package lottoauto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberExtractor {
    private static final int MIN_SIZE = 0;
    private static final int MAX_SIZE = 6;
    private List<Integer> allNumbers;
    public List<Integer> getRandomNumbers() {
        allNumbers = IntStream.range(1, 45).boxed().collect(Collectors.toList());
        Collections.shuffle(allNumbers);
        List<Integer> randomNumbers = new ArrayList<>();
        IntStream.range(MIN_SIZE, MAX_SIZE).mapToObj(allNumbers::get).forEachOrdered(randomNumbers::add);
        return randomNumbers;
    }

}
