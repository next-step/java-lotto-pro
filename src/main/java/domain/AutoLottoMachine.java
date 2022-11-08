package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoMachine implements LottoMachine {
    private static final int LOTTE_MIN_NUMBER = 1;
    private static final int LOTTE_MAX_NUMBER = 45;

    private static final List<LottoNumber> LOTTO_NUMBERS = setupLotto();
    private final int lottoTicketCount;

    private final Lottos lottos;

    public AutoLottoMachine(int lottoTicketCount, Lottos lottos) {
        this.lottoTicketCount = lottoTicketCount;
        this.lottos = lottos;
    }

    private static List<LottoNumber> setupLotto() {
        List<LottoNumber> lottonumbers = new ArrayList<>();
        for (int i = LOTTE_MIN_NUMBER; i <= LOTTE_MAX_NUMBER; i++) {
            lottonumbers.add(new LottoNumber(i));
        }
        return lottonumbers;
    }

    private Lotto createLottoNumber() {
        Collections.shuffle(LOTTO_NUMBERS);
        return new Lotto(new ArrayList<>(LOTTO_NUMBERS.subList(0, 6)));
    }

    @Override
    public void purchaseLotto() {
        for (int i = 0; i < lottoTicketCount; i++) {
            lottos.add(createLottoNumber());
        }
    }

}
