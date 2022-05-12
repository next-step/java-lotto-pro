package lottoauto.util;

import lottoauto.wrapper.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SixRandomNumberUtil {
    List<Integer> streamList;

    public SixRandomNumberUtil() {
        makeDefaultArray();
    }

    private void makeDefaultArray() {
        IntStream intStream = IntStream.range(1, 45);
        streamList = intStream.boxed().collect(Collectors.toList());
    }

    public List<Integer> makeRandomNumbers() {
        Collections.shuffle(streamList);
        List<Integer> numbers = IntStream.range(0, 6).mapToObj(i -> streamList.get(i)).collect(Collectors.toList());
        return numbers;
    }
}
