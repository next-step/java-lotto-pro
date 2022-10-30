package lotto.domain.lottonumber.factory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.lottonumber.LottoNumber;

public class LottoNumberFactoryImpl implements LottoNumberFactory {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45 + MIN_LOTTO_NUMBER;
    private static List<Integer> lottoNumber;

    static {
        lottoNumber = new ArrayList<>();
        for (int i = MIN_LOTTO_NUMBER; i < MAX_LOTTO_NUMBER; i++) {
            lottoNumber.add(i);
        }
    }

    @Override
    public LottoNumber createLottoNumber() {
        Collections.shuffle(lottoNumber);
        List<Integer> randomLottoNumber = new ArrayList<>(lottoNumber.subList(0, 6));
        Collections.sort(randomLottoNumber);
        return new LottoNumber(randomLottoNumber);
    }
}
