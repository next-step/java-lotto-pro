package lottoauto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberExtractor {

    public List<Integer> getRandomNumbers() {
        List<Integer> allNumbers = IntStream.range(1, 45).boxed().collect(Collectors.toList());
        Collections.shuffle(allNumbers);
        List<Integer> randomNumbers = new ArrayList<>();
        IntStream.range(0, 6).mapToObj(allNumbers::get).forEachOrdered(randomNumbers::add);
        return randomNumbers;
    }
}
