package camp.nextstep.edu.step3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private static final int VALID_SIZE = 6;
    private List<LottoNumber> lottoNumbers;

    public Lotto(LottoNumber[] lottoNumbers) {
        validationInputSize(lottoNumbers.length);
        sortedLottoNumbers(lottoNumbers);
    }

    private void sortedLottoNumbers(final LottoNumber[] lottoNumbers) {
        this.lottoNumbers = Arrays.asList(lottoNumbers);
        Collections.sort(this.lottoNumbers);
    }

    private void validationInputSize(final int inputSize) {
        if (!Objects.equals(VALID_SIZE, inputSize)) {
            throw new IllegalArgumentException("LottoNumberArray invalid size : " + inputSize);
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
