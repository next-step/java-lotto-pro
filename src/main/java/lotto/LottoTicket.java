package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private Set<Integer> numbers;

    public LottoTicket() {
        List<Integer> possibleNumbers = IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
            .boxed()
            .collect(Collectors.toList());

        Collections.shuffle(possibleNumbers);
        this.numbers = new HashSet<>(possibleNumbers.subList(0, LOTTO_SIZE));
    }

    public int getSize() {
        return numbers.size();
    }
}
