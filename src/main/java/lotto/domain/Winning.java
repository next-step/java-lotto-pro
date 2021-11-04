package lotto.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Winning {
    private static final String WINNING_NUMBER_REGEX = "\\s*,\\s*";

    private final LottoNumbers winningNumbers;

    public Winning(final String input) {
        this.winningNumbers = new LottoNumbers(
                Arrays.stream(input.split(WINNING_NUMBER_REGEX))
                        .mapToInt(Integer::valueOf)
                        .boxed()
                        .collect(Collectors.toList())
        );
    }

    public LottoNumbers getWinningNumbers() {
        return winningNumbers;
    }
}
