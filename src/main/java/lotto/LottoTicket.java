package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private static final String LEFT_BRACE = "[";
    private static final String RIGHT_BRACE = "]";
    private static final String COMMA_SPACE = ", ";

    private List<Integer> numbers;

    public LottoTicket() {
        List<Integer> possibleNumbers = IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
            .boxed()
            .collect(Collectors.toList());

        Collections.shuffle(possibleNumbers);

        numbers = possibleNumbers.stream()
            .limit(LOTTO_SIZE)
            .sorted()
            .collect(Collectors.toList());
    }

    public int getSize() {
        return numbers.size();
    }

    public String makeMessage() {
        return LEFT_BRACE
            + numbers.stream().map(String::valueOf).collect(Collectors.joining(COMMA_SPACE))
            + RIGHT_BRACE;
    }
}
