package lotto.model.number;

import static lotto.constant.LottoSetting.LOTTO_SIZE;

import java.util.List;

public class LottoNumbers {

    private List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        validateDuplicate(lottoNumbers);
        validateSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public String toLottoNumbersString() {
        return lottoNumbers.toString();
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

    public int countContainLottoNumber(LottoNumbers winningLottoNumbers) {
        return (int) this.lottoNumbers.stream().filter(winningLottoNumbers::existLottoNumber).count();
    }

    private boolean existLottoNumber(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

}
