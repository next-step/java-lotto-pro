package lotto.domain.repository;

import lotto.domain.Lotto;

public interface LottoRepository {

    void save(Lotto lotto);

    Lotto findOne();
}
