package study.step4.helper;

import study.step4.models.Lotto;
import study.step4.models.LottoNumber;
import study.step4.models.Lottos;
import study.step4.models.Money;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMaker {
    private static final int SUB_LIST_START_INDEX = 0;
    private static final int SUB_LIST_END_INDEX = 6;

    public static Lottos makeLottos(Money inputMoney) {
        List<Lotto> lottoList = new ArrayList<>();
        int num = inputMoney.dividedBy(Money.PRICE_PER_LOTTO);
        for (int i = 0; i < num; i++) {
            lottoList.add(makeLotto());
        }
        return new Lottos(lottoList);
    }

    private static Lotto makeLotto() {
        List<LottoNumber> numbers = new ArrayList<>(LottoNumber.getLottoNumbers());
        Collections.shuffle(numbers);
        return new Lotto(new ArrayList<>(numbers.subList(SUB_LIST_START_INDEX, SUB_LIST_END_INDEX)));
    }
}
