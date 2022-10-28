package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        validLottoNumber(lottoNumbers);
        this.lottoNumbers = lottoNumbers.stream().map(LottoNumber::new).collect(Collectors.toList());
    }

    public int size() {
        return this.lottoNumbers.size();
    }

    private void validLottoNumber(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호 입력은 6개의 숫자로 이루어져야 합니다.");
        }
        // TODO: 정상적인 로또 숫자 인지 확인 필요
        // TODO: 입력한 값의 로또 번호가 중복인 경우
    }

}
