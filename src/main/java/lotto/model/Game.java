package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.common.Constants.*;

public class Game {

    private List<Integer> numbers;

    public Game() {
        this.numbers = generateNumbers();
        System.out.println(this.numbers);
    }

    /**
     * 난수목록 생성
     *
     * @return GET_NUMBER_COUNT 길이의 배열을 반환
     */
    private List<Integer> generateNumbers() {
        List<Integer> randomNumbers = IntStream.range(MIN_RANGE_VALUE, MAX_RANGE_VALUE)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(randomNumbers);
        return randomNumbers.subList(0, GET_NUMBER_COUNT)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
