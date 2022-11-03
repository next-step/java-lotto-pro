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
    public List<LottoNumber> split(String input) {
        StringTokenizer token = new StringTokenizer(input, DELIMITER);
        List<LottoNumber> winningNumbers = new ArrayList<>();
        while (token.hasMoreTokens()) {
            winningNumbers.add(new LottoNumber(Integer.parseInt(token.nextToken())));
        }
        return winningNumbers;
    }
}
