package camp.nextstep.edu.step3;

import java.util.List;

public class Lotto {
    private List<LottoNumber> lottoNumbers;
    public Lotto(LottoNumber[] lottoNumbers) {
        validationInputSize(lottoNumbers.length);
    }

    private void validationInputSize(final int inputSize) {
        if (inputSize != 6) {
            throw new IllegalArgumentException("LottoNumberArray invalid size : "+inputSize);
        }
    }
}
