package lotto.domain.winningnumber.role;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CommaSplitter implements WinningNumberRole {

    private static final String SEPARATOR = ",";

    @Override
    public Set<Integer> createWinningNumber(String winningNumber) {
        Set<Integer> winningNumbers = new HashSet<>();
        Arrays.stream(winningNumber.split(SEPARATOR))
                .forEach(number -> winningNumbers.add(Integer.parseInt(number.trim())));
        return winningNumbers;
    }
}
