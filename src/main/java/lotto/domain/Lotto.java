package lotto.domain;

import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    public static final int LOTTO_NUMBER_SIZE = 6;
    public static final String COMMA = ",";
    public static final String LOTTO_NUMBER_MUST_SIX = "로또 번호는 6개여야 합니다.";

    private final Set<LottoNumber> lotto = new HashSet<>();

    protected Lotto(List<Integer> lottoNumbers) {
        for (Integer number : lottoNumbers) {
            lotto.add(new LottoNumber(number));
        }
        validateSize();
    }

    private void validateSize() {
        if (lotto.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBER_MUST_SIX);
        }

    public static Lotto create(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public static Lotto createWithNumberLetter(String numbers) {
        return new Lotto(getLottoNumbers(numbers));
    }

    protected static List<Integer> getLottoNumbers(String numbers) {
        return Arrays.stream(numbers.split(COMMA))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int match(Lotto winningLotto) {
        return (int) this.lotto.stream()
                .filter(winningLotto::match)
                .count();
    }

    protected boolean match(LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
    }

    public List<LottoNumber> getLotto() {
        return new ArrayList<>(lotto);
    }
}
