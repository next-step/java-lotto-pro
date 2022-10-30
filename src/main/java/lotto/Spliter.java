package lotto;

import static lotto.Constant.DELIMITER;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Spliter {
    public List<Integer> split(String input) {
        StringTokenizer token = new StringTokenizer(input, DELIMITER);
        List<Integer> winningNumbers = new ArrayList<>();
        while (token.hasMoreTokens()) {
            winningNumbers.add(Validate.validateNumberRange(Validate.validateInput(token.nextToken())));
        }
        return winningNumbers;
    }
}
