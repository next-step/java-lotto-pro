package study.lotto.automatic.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumbers {
    static final int LOTTO_NUMBER_SIZE = 6;
    static final String TO_STRING_DELIMITER = ", ";

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개만 가능합니다.");
        }
        lottoNumbers = numbers.stream().map(LottoNumber::new).collect(Collectors.toList());
    }

    public List<Integer> numbers() {
        return lottoNumbers.stream().map(LottoNumber::toString).map(Integer::valueOf).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return String.join(TO_STRING_DELIMITER,
                lottoNumbers.stream().map(LottoNumber::toString).collect(Collectors.toList()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
