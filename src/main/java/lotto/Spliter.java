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
    public List<Integer> splitToList(String input) {
        List<Integer> lottoNumbers = new ArrayList<>();
        StringTokenizer token = new StringTokenizer(input, DELIMITER);
        while (token.hasMoreTokens()) {
            lottoNumbers.add(Integer.parseInt(token.nextToken()));
        }
        return lottoNumbers;
    }
}
