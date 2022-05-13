package lotto;

import lotto.factory.LottoNumbersFactory;
import lotto.factory.NormalLottoNumbersFactory;

public class LottoMain {
    public static void main(String[] args) {
        LottoNumbersFactory lottoNumbersFactory = new NormalLottoNumbersFactory();
        System.out.println(lottoNumbersFactory.createRandomLottoNumbers());
    }
}
