package camp.nextstep.edu.step3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    private static final int VALID_SIZE = 6;
    private final List<LottoNumber> lottoNumbers = new ArrayList<>();

    public Lotto(List<LottoNumber> lottoNumbers) {
        validationSize(lottoNumbers);
        this.lottoNumbers.addAll(lottoNumbers);
        Collections.sort(this.lottoNumbers);
    }
    public Hit checkTo(final Lotto prizeLotto) {
        return Hit.valueOf(prizeLotto.checkBy(this.lottoNumbers));
    }

    private void validationSize(List<LottoNumber> lottoNumbers) {
        if (Objects.isNull(lottoNumbers) || removeOverlap(lottoNumbers).size() < VALID_SIZE) {
            throw new IllegalArgumentException("invalid LottoNumbers");
        }
    }

    private List<LottoNumber> removeOverlap(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream().distinct().collect(Collectors.toList());
    }

    private int checkBy(List<LottoNumber> userLottoNumbers) {
        return userLottoNumbers.stream()
                .filter(this.lottoNumbers::contains)
                .toArray().length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
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
