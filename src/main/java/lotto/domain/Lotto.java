package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import utils.CollectionsUtil;

public class Lotto {
    private static final int MAX_LOTTO_NUMBER_QTY = 6;
    private static final int FIRST_INDEX = 0;
    public static final int LOTTO_MONEY = 1000;

    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<Integer> lottoNumbers) {
        valid(lottoNumbers);
        Collections.sort(lottoNumbers);
        this.lottoNumbers = mapToLottoNumber(lottoNumbers);
    }

    public static Lotto createAutoLotto() {
        return new Lotto(autoLottoNumbers());
    }

    public static Lotto createCustomLotto(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public int matchCount(Lotto lotto) {
        return (int) this.lottoNumbers.stream()
                .filter(lotto.lottoNumbers::contains)
                .count();
    }

    private static List<Integer> autoLottoNumbers() {
        return CollectionsUtil
                .shuffleSequentialNumbers(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
                .subList(FIRST_INDEX, MAX_LOTTO_NUMBER_QTY);
    }

    public boolean isContain(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
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
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }


    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
