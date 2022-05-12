package lotto.lotto;

import java.util.List;

public class FailureCreatingLottoGeneratorException extends RuntimeException {

    public FailureCreatingLottoGeneratorException(List<LottoNumber> lottoNumbers) {
        super(String.format("LottoGenerator 생성 실패했습니다. (입력값: %s, 최소 갯수:%d", lottoNumbers, Lotto.SIZE));
    }

    public FailureCreatingLottoGeneratorException(String value, String delimiter) {
        super(String.format("LottoGenerator 생성 실패했습니다. (입력값: %s, 최소 갯수: %s", value, delimiter));
    }
}
