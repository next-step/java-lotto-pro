package camp.nextstep.edu.step3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoVendingMachine {
    private final List<LottoNumber> lottoNumbers = new ArrayList<>();
    private final int PRICE_PER = 1000;

    public LottoVendingMachine() {
        initLottoNumbers();
    }

    private void initLottoNumbers() {
        final int START_NUMBER = 1;
        final int END_NUMBER = 45;
        for (int i = START_NUMBER; i <= END_NUMBER; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }

    }

    public LottoPaper issued(final int amount) {
        Lotto[] lottoArray = new Lotto[numberOfPurchases(amount)];
        for (int i = 0; i < lottoArray.length; i++) {
            Collections.shuffle(lottoNumbers);
            lottoArray[i] = (new Lotto(lottoNumbers.subList(0, 6).toArray(new LottoNumber[0])));
        }
        return new LottoPaper(lottoArray);
    }

    private int numberOfPurchases(final int amount) {
        return amount / PRICE_PER;
    }
}
