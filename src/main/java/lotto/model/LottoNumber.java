package lotto.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class LottoNumber {
    private final List<Number> lottoNumber;

    public LottoNumber(List<Number> lottoNumber) {
        sortLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public LottoRank getLottoRank(LottoNumber winningLottoNumber) {
        int count = (int) lottoNumber.stream()
                .filter(winningLottoNumber::isContainNumber)
                .count();
        return LottoRank.findByHits(count);
    }

    private boolean isContainNumber(Number number) {
        return this.lottoNumber.contains(number);
    }

    public static void sortLottoNumber(List<Number> lottoNumber) {
        lottoNumber.sort(Comparator.comparing(Number::getNumber));
    }

    public List<Number> getLottoNumber() {
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
