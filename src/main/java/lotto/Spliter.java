/*
 * Spliter.java
 * v0.1
 * 2022.10.30
 */
package lotto;

import static lotto.Constant.DELIMITER;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Spliter {
    public LottoNumbers split(String input) {
        StringTokenizer token = new StringTokenizer(input, DELIMITER);
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        while (token.hasMoreTokens()) {
            lottoNumbers.add(LottoNumber.from(Integer.parseInt(token.nextToken())));
        }
        return LottoNumbers.from(lottoNumbers);
    }
}
