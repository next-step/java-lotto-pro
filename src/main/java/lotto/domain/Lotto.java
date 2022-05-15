package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    public static final int LOTTO_NUMBER_SIZE = 6;
    public static final String COMMA = ",";
    public static final String LOTTO_NUMBER_MUST_SIX = "로또 번호는 6개여야 합니다.";

    private List<LottoNumber> lotto = new ArrayList<>();

    private Lotto(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBER_MUST_SIX);
        }
        for (Integer number : lottoNumbers) {
            lotto.add(new LottoNumber(number));
        }
    }

    public static Lotto create(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public static Lotto create(String numbers) {
        return new Lotto(Arrays.stream(numbers.split(COMMA))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

    public int match(Lotto winningLotto) {
        return (int) this.lotto.stream()
                .filter(winningLotto::match)
                .count();
    }

    private boolean match(LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
    }

    public List<LottoNumber> getLotto() {
        return lotto;
    }
}
