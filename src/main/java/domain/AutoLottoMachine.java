package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoMachine implements LottoMachine {
    private static final List<LottoNumber> LOTTO_NUMBERS = new ArrayList<>();
    private static final int LOTTE_MIN_NUMBER = 1;
    private static final int LOTTE_MAX_NUMBER = 45;

    public AutoLottoMachine() {
        setupLotto();
    }

    private void setupLotto() {
        for (int i = LOTTE_MIN_NUMBER; i <= LOTTE_MAX_NUMBER; i++) {
            LOTTO_NUMBERS.add(new LottoNumber(i));
        }

    }

    @Override
    public Lotto createLottoNumber() {
        Collections.shuffle(LOTTO_NUMBERS);
        return new Lotto(new ArrayList<>(LOTTO_NUMBERS.subList(0, 6)));
    }

    @Override
    public Lottos purchaseLotto(int lottoTicketCount) {
        Lottos lottos = new Lottos(new ArrayList<>());
        for (int i = 0; i < lottoTicketCount; i++) {
            lottos.add(createLottoNumber());
        }
        return lottos;
    }

}
