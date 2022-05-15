package lotto.auto.model;

import static lotto.auto.constant.LottoSetting.LOTTO_SIZE;

import java.util.List;

public class LottoNumbers {

    private List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        validateDuplicate(lottoNumbers);
        validateSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(String.format("로또 숫자는 %d가 필요합니다.", LOTTO_SIZE));
        }
    }

    private void validateDuplicate(List<LottoNumber> lottoNumbers) {
        long lottoNumbersDistinctSize = lottoNumbers.stream().distinct().count();
        if (lottoNumbers.size() != lottoNumbersDistinctSize) {
            throw new IllegalArgumentException("중복된 숫자는 사용할 수 없습니다.");
        }
    }

}
