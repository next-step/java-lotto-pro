package lotto.domain.repository;

import lotto.domain.lottonumber.LottoNumbers;

public interface LottoNumbersRepository {

    void save(LottoNumbers lottoNumbers);

    LottoNumbers findOne();
}
