package lotto;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.IntStream;

interface LottoNumber {
    int MIN_NUMBER = 1;
    int MAX_NUMBER = 45;
    int NUMBER_SIZE = 6;
    List<Integer> NUMBER_RANGE = IntStream.range(MIN_NUMBER, MAX_NUMBER + 1)
            .boxed()
            .collect(toList());

    List<Integer> getLottoNumbers();
}
