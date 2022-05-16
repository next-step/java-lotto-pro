package domain.helper;

import domain.Lotto;
import domain.LottoFactory;

import java.util.Deque;
import java.util.List;

public class FixedLottoFactory implements LottoFactory {

    private final Deque<Lotto> lottos;

    public FixedLottoFactory(Deque<Lotto> lottos) {
        this.lottos = lottos;
    }

    @Override
    public Lotto make() {
        return lottos.pop();
    }




}
