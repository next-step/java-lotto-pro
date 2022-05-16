package lotto.model.number;

import static lotto.constant.LottoSetting.LOTTO_SIZE;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {

    private Set<LottoNumber> lottoNumbers;

    private LottoNumbers(Set<LottoNumber> lottoNumberSet) {
        validateSize(lottoNumberSet);
        this.lottoNumbers = lottoNumberSet;
    }

    public static LottoNumbers fromLottoNumberSet(Set<LottoNumber> lottoNumberSet) {
        return new LottoNumbers(lottoNumberSet);
    }

    public static LottoNumbers fromInputLottoNumbers(String inputLottoNumbers) {
        String[] inputLottoNumberArr = inputLottoNumbers.replace(" ", "").split(",");
        Set<LottoNumber> lottoNumberSet = Arrays.stream(inputLottoNumberArr)
            .map(LottoNumber::new)
            .collect(Collectors.toSet());

        return new LottoNumbers(lottoNumberSet);
    }

    public String toLottoNumbersString() {
        return lottoNumbers.toString();
    }

    private void validateSize(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(String.format("로또 숫자는 %d가 필요합니다.", LOTTO_SIZE));
        }
    }

    public int countContainLottoNumber(LottoNumbers winningLottoNumbers) {
        return (int) this.lottoNumbers.stream().filter(winningLottoNumbers::existLottoNumber).count();
    }

    private boolean existLottoNumber(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

}
