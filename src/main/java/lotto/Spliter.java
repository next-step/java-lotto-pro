/*
 * Spliter.java
 * v0.1
 * 2022.10.30
 */
package lotto;

import static lotto.Constant.DELIMITER;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Spliter {
    public List<Integer> split(String input) {
        StringTokenizer token = new StringTokenizer(input, DELIMITER);
        List<Integer> winningNumbers = new ArrayList<>();
        while (token.hasMoreTokens()) {
            winningNumbers.add(Integer.valueOf(token.nextToken()));
        }
        return winningNumbers;
    }
}
