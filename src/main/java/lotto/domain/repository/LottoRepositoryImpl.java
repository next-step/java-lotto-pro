package lotto.domain.repository;

import lotto.domain.Lotto;

public class LottoRepositoryImpl implements LottoRepository {

    private Lotto lotto;

    @Override
    public void save(Lotto lotto) {
        this.lotto = lotto;
    }

    @Override
    public Lotto findOne() {
        return lotto;
    }
}
