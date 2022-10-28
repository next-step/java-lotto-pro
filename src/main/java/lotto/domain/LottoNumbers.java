package lotto.domain;

import java.util.List;

public class LottoNumbers {

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        validLottoNumber(lottoNumbers);
        this.lottoNumbers = null;
    }

    public int size() {
        return this.lottoNumbers.size();
    }

    private void validLottoNumber(List<Integer> lottoNumbers) {
        // TODO: 정상적인 로또 숫자 인지 확인 필요
        // TODO: 로또 번호 유효성 체크
        // TODO: 입력한 값의 로또 번호가 중복인 경우
    }
}
