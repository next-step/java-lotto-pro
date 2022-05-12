package study.lotto.automatic.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    static final int LOTTO_NUMBER_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개만 가능합니다.");
        }
        lottoNumbers = numbers.stream().map(LottoNumber::new).collect(Collectors.toList());
    }
}
