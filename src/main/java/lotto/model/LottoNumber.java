package lotto.model;

import static lotto.constants.LottoConstant.NUMBER_SIZE;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class LottoNumber {
    private final List<Number> lottoNumber;

    public LottoNumber(List<Number> lottoNumber) {
        validateDuplicate(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public int countMatchLottoNumber(LottoNumber lottoNumber) {
        return (int) this.lottoNumber
                .stream()
                .filter(lottoNumber::isContainNumber)
                .count();
    }

    public boolean isContainNumber(Number number) {
        return this.lottoNumber.contains(number);
    }

    public void validateDuplicate(List<Number> lottoNumber) {
        Set<Number> numberSet = new HashSet<>(lottoNumber);
        if (numberSet.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 숫자의 중복은 허용되지 않습니다.");
        }
    }

    public List<Number> getLottoNumber() {
        lottoNumber.sort(Comparator.comparing(Number::getNumber));
        return Collections.unmodifiableList(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(lottoNumber, that.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
