package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import lotto.util.CollectionsUtil;

public class LottoNumbers {
    private static final int MAX_LOTTO_NUMBER_QTY = 6;
    private static final int FIRST_INDEX = 0;
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<Integer> numbers) {
        valid(numbers);
        Collections.sort(numbers);
        this.lottoNumbers = this.mapToLottoNumber(numbers);
    }

    public static LottoNumbers autoLottoNumbers() {
        List<Integer> autoLottoNumbers = CollectionsUtil
                .shuffleSequentialNumbers(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
                .subList(FIRST_INDEX, MAX_LOTTO_NUMBER_QTY);

        return new LottoNumbers(autoLottoNumbers);
    }

    public int matchCount(LottoNumbers matchNumbers) {
        return (int) this.lottoNumbers.stream()
                .filter(matchNumbers.lottoNumbers::contains)
                .count();
    }

    private void valid(List<Integer> numbers) {
        if (Objects.isNull(numbers) || isLottoOverSize(numbers)) {
            throw new IllegalArgumentException("로또 번호는" + MAX_LOTTO_NUMBER_QTY + "자리 이어야 합니다.");
        }
    }


    private boolean isLottoOverSize(List<Integer> numbers) {
        return numbers.size() != MAX_LOTTO_NUMBER_QTY;
    }

    private List<LottoNumber> mapToLottoNumber(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
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
