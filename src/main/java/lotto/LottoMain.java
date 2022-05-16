package lotto;

import java.util.List;
import lotto.controller.LottoController;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.strategy.ManualPickNumberStrategy;

public class LottoMain {

    public static void main(String[] args) {
        LottoController.startLotto();
        LottoNumbers lottoNumbers = new LottoNumbers(new ManualPickNumberStrategy());
        List<LottoNumber> lottoNumberList = lottoNumbers.getValues();
        for (LottoNumber lottoNumber : lottoNumberList) {
            System.out.println(lottoNumber);
        }
    }
}
