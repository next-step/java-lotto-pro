package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.constants.LottoConstants;

public class LottoNumberPool {

    private final List<LottoNumber> numberList;

    public LottoNumberPool() {
        numberList = new ArrayList<>();

        for (int number = LottoConstants.MIN_LOTTO_NUMBER; number <= LottoConstants.MAX_LOTTO_NUMBER; number++) {
            numberList.add(new LottoNumber(number));
        }
    }

    public Lotto generateLotto() {
        shuffleLottoNumberList();
        return new Lotto(drawLottoNumbers());
    }

    private void shuffleLottoNumberList() {
        Collections.shuffle(numberList);
    }

    private List<LottoNumber> drawLottoNumbers() {
        return numberList.subList(0, LottoConstants.LOTTO_SIZE);
    }
}
