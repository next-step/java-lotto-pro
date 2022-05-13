package study.lotto.automatic.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {
    static final int LOTTO_NUMBER_SIZE = 6;
    static final String TO_STRING_DELIMITER = ", ";

    private final List<LottoNumber> lottoNumberList;

    public LottoNumbers(List<Integer> numbers) {
        checkLottoNumberSize(numbers);
        checkDuplicates(numbers);
        lottoNumberList = numbers.stream().map(LottoNumber::new).collect(Collectors.toList());
    }

    private void checkLottoNumberSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개만 가능합니다.");
        }
    }

    private void checkDuplicates(List<Integer> numbers) {
        Set<Integer> lottoNumberSet = new HashSet<>(numbers);
        if (lottoNumberSet.size() != numbers.size()) {
            throw new IllegalArgumentException("중복된 로또 번호를 가질 수 없습니다.");
        }
    }

    public List<Integer> numbers() {
        return lottoNumberList.stream().map(LottoNumber::toString).map(Integer::valueOf).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return String.join(TO_STRING_DELIMITER,
                lottoNumberList.stream().map(LottoNumber::toString).collect(Collectors.toList()));
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
        return Objects.equals(lottoNumberList, that.lottoNumberList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumberList);
    }
}
