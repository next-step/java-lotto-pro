package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import view.Printable;

public class LottoTicket implements Printable {
    private static final String COMMA_SPACE = ", ";
    private static final String LEFT_BRACE = "[";
    private static final String RIGHT_BRACE = "]";

    private List<Integer> numbers;

    public LottoTicket(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public LottoTicket(String text) {
        numbers = Arrays.stream(text.split(COMMA_SPACE))
            .map(Integer::parseInt)
            .sorted()
            .collect(Collectors.toList());
    }

    public LottoResult calculateResult(LottoTicket winnerTicket) {
        int correctCount = (int)this.numbers.stream()
            .filter(number -> winnerTicket.numbers.contains(number))
            .count();

        return LottoResult.findResult(correctCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoTicket)) {
            return false;
        }
        LottoTicket that = (LottoTicket)o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String makePrintableMessage() {
        return LEFT_BRACE
            + numbers.stream().map(String::valueOf).collect(Collectors.joining(COMMA_SPACE))
            + RIGHT_BRACE;
    }
}
