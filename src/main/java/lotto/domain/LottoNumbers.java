package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import utils.CollectionsUtil;

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
        lottoNumberSizeValid(numbers);
        distinctLottoNumberValid(numbers);
    }

    private void lottoNumberSizeValid(List<Integer> numbers) {
        if (Objects.isNull(numbers) || isLottoOverSize(numbers)) {
            throw new IllegalArgumentException("로또 번호는" + MAX_LOTTO_NUMBER_QTY + "자리 이어야 합니다.");
        }
    }

    private void distinctLottoNumberValid(List<Integer> numbers) {
        Set<Integer> distinctSet = new HashSet<>(numbers);
        if (distinctSet.size() != numbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복되지 않아야 합니다.");
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

    @Override
    public String toString() {
        return lottoNumbers.toString();

    }
}
