package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {

    private final List<LottoNumber> lottoNumbers = new ArrayList<>();

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        validLottoNumber(lottoNumbers);
        this.lottoNumbers.addAll(lottoNumbers);
    }

    public int size() {
        return this.lottoNumbers.size();
    }

    private void validLottoNumber(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호 입력은 6개의 숫자로 이루어져야 합니다.");
        }
        // TODO: 정상적인 로또 숫자 인지 확인 필요
        // TODO: 입력한 값의 로또 번호가 중복인 경우
    }

    @Override
    public String toString() {
        return "LottoNumbers{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }
}
