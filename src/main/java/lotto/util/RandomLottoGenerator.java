package lotto.util;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoGenerator implements LottoGenerator {
    private static final List<Integer> BASE_NUMBERS =
            IntStream.range(LottoNumber.LOTTO_NUMBER_MIN, LottoNumber.LOTTO_NUMBER_MAX)
                    .boxed()
                    .collect(Collectors.toList());

    @Override
    public LottoTicket create() {
        List<Integer> numbers = new ArrayList<>(BASE_NUMBERS);
        List<Integer> randomNumbers = sort(toSubList(shuffle(numbers)));

        return LottoTicket.create(randomNumbers.stream()
                .map(i -> LottoNumber.get(i))
                .collect(Collectors.toList())
        );
    }

    private List<Integer> shuffle(List<Integer> numbers) {
        Collections.shuffle(numbers);
        return numbers;
    }

    private List<Integer> toSubList(List<Integer> numbers) {
        return numbers.stream()
                .limit(LottoTicket.LOTTO_NUMBER_LENGTH)
                .collect(Collectors.toList());
    }

    private List<Integer> sort(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }
}
