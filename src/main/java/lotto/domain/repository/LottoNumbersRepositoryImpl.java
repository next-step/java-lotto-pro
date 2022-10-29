package lotto.domain.repository;

import lotto.domain.lottonumber.LottoNumbers;

public class LottoNumbersRepositoryImpl implements LottoNumbersRepository {

    private LottoNumbers lottoNumbers;

    @Override
    public void save(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public LottoNumbers findOne() {
        return lottoNumbers;
    }
}
