package lotto.winningnumber.role;

import java.util.HashSet;
import java.util.Set;

public class CommaSplitter implements WinningNumberRole {

    private static final String SEPARATOR = ",";

    @Override
    public Set<Integer> execute(String winningNumber) {
        Set<Integer> winningNumbers = new HashSet<>();
        for (String number : winningNumber.split(SEPARATOR)) {
            winningNumbers.add(Integer.parseInt(number.trim()));
        }
        return winningNumbers;
    }
}
