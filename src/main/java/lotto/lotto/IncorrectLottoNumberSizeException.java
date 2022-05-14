package lotto.lotto;

import java.util.List;

public class IncorrectLottoNumberSizeException extends RuntimeException {

    public IncorrectLottoNumberSizeException(List<LottoNumber> lottoNumbers) {
        super(String.format("로또 번호의 갯수가 올바르지 않습니다. (입력값: %s, 허용 갯수: %d)", lottoNumbers, Lotto.SIZE));
    }
}
