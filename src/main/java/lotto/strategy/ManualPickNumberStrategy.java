package lotto.strategy;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoNumber;
import lotto.view.InputView;

public class ManualPickNumberStrategy implements PickNumberStrategy {

    @Override
    public List<LottoNumber> pickLottoNumbers() {
        return convertToLottoNumber(InputView.enterManualLotto());
    }

    private List<LottoNumber> convertToLottoNumber(int[] lottoNumberArray) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int number : lottoNumberArray) {
            lottoNumbers.add(new LottoNumber(number));
        }
        return lottoNumbers;
    }
}
