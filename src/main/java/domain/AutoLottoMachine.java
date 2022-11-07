package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoMachine implements LottoMachine {
    private static final int LOTTE_MIN_NUMBER = 1;
    private static final int LOTTE_MAX_NUMBER = 45;

    private static final List<LottoNumber> LOTTO_NUMBERS = setupLotto();

    public AutoLottoMachine() {

    }

    private static List<LottoNumber> setupLotto() {
        List<LottoNumber> lottonumbers = new ArrayList<>();
        for (int i = LOTTE_MIN_NUMBER; i <= LOTTE_MAX_NUMBER; i++) {
            lottonumbers.add(new LottoNumber(i));
        }
        return lottonumbers;
    }

    public Lotto createLottoNumber() {
        Collections.shuffle(LOTTO_NUMBERS);
        return new Lotto(new ArrayList<>(LOTTO_NUMBERS.subList(0, 6)));
    }

    @Override
    public Lottos purchaseLotto(int lottoTicketCount, Lottos lottos) {
        for (int i = 0; i < lottoTicketCount; i++) {
            lottos.add(createLottoNumber());
        }
        return lottos;
    }

    @Override
    public Lotto splitPurchaseLottoNumbers(String inputWinLottNumbers) {
        return null;
    }

}
