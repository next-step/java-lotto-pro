package lotto.strategy;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoNumber;

public class ManualPickNumberStrategy implements PickNumberStrategy {

    private final List<LottoNumber> lottoNumbers;

    public ManualPickNumberStrategy(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public List<LottoNumber> pickLottoNumbers() {
        return lottoNumbers;
    }

    private List<LottoNumber> convertToLottoNumber(int[] lottoNumberArray) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int number : lottoNumberArray) {
            lottoNumbers.add(new LottoNumber(number));
        }
        return lottoNumbers;
    }
}
