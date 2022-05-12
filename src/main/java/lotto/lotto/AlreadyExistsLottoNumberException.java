package lotto.lotto;

import java.util.List;

public class AlreadyExistsLottoNumberException extends RuntimeException {

    public AlreadyExistsLottoNumberException(List<LottoNumber> lottoNumbers) {
        super(String.format("이미 존재하는 로또 번호가 있습니다. (입력값: %s)", lottoNumbers));
    }
}
