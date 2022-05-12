package camp.nextstep.edu.step3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;
    public Lotto(LottoNumber[] lottoNumbers) {
        validationInputSize(lottoNumbers.length);
        this.lottoNumbers = sortedLottoNumbers(lottoNumbers);
    }

    private List<LottoNumber> sortedLottoNumbers(final LottoNumber[] lottoNumbers) {
        List<LottoNumber> lottoNumberList = Arrays.asList(lottoNumbers);
        Collections.sort(lottoNumberList);
        return lottoNumberList;
    }

    private void validationInputSize(final int inputSize) {
        if (inputSize != 6) {
            throw new IllegalArgumentException("LottoNumberArray invalid size : "+inputSize);
        }
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
}
